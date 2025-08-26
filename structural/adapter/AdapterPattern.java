import java.util.Scanner;

public class AdapterPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter payment amount (₹): ");
        double amount = sc.nextDouble();

        System.out.println("\nChoose payment method:");
        System.out.println("1. UPI (modern system)");
        System.out.println("2. Credit Card (legacy, adapted to UPI)");

        int choice = sc.nextInt();
        UPIPayment payment;

        if (choice == 1) {
            payment = new UPIPaymentImpl();
        } else if (choice == 2) {
            payment = new CreditCardToUPIAdapter(new CreditCardProcessor());
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        System.out.println(payment.pay(amount));
        sc.close();
    }
}
