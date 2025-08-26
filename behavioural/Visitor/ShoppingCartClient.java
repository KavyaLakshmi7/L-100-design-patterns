import java.util.Scanner;

public class ShoppingCartClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Add items to your shopping cart (type 'done' to finish):");

        while (true) {
            System.out.print("Enter item type (Electronics/Grocery/Clothing): ");
            String type = sc.nextLine();
            if (type.equalsIgnoreCase("done")) break;

            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            System.out.print("Enter item price: ");
            int price = sc.nextInt();
            sc.nextLine(); 

            switch (type.toLowerCase()) {
                case "electronics":
                    cart.addItem(new Electronics(price, name));
                    break;
                case "grocery":
                    cart.addItem(new Grocery(price, name));
                    break;
                case "clothing":
                    cart.addItem(new Clothing(price, name));
                    break;
                default:
                    System.out.println("Invalid type!");
            }
        }

        System.out.println("\nCalculating total cost with discounts:");
        int total = cart.calculateTotal();
        System.out.println("Total Cost: " + total);
        sc.close();
    }
}
