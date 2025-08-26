import java.util.Scanner;

public class AuctionClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Auction auction = new Auction();

        System.out.print("Enter number of buyers: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Buyer[] buyers = new Buyer[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of buyer " + (i + 1) + ": ");
            String name = sc.nextLine();
            buyers[i] = new Buyer(name, auction);
        }

        System.out.println("\nAuction started! Enter bids (type '0' to stop):");

        while (true) {
            System.out.print("Enter buyer name: ");
            String buyerName = sc.nextLine();
            if (buyerName.equals("0")) break;

            System.out.print("Enter bid amount: ");
            int amount = sc.nextInt();
            sc.nextLine(); 

            boolean found = false;
            for (Buyer b : buyers) {
                if (b.getName().equalsIgnoreCase(buyerName)) {
                    b.placeBid(amount);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Buyer not found. Try again.");
            }
        }

        auction.declareWinner();
        sc.close();
    }
}
