import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose order type:");
        System.out.println("1. Electronics");
        System.out.println("2. Grocery");
        int choice = sc.nextInt();

        OrderProcessTemplate order = null;

        switch (choice) {
            case 1:
                order = new ElectronicsOrder();
                break;
            case 2:
                order = new GroceryOrder();
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        System.out.println("\nProcessing order...");
        order.processOrder();

        sc.close();
    }
}
