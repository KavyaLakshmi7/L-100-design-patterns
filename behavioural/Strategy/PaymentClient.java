import java.util.Scanner;

public class PaymentClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentProcessor processor = new PaymentProcessor();

        System.out.print("Enter amount to pay: ");
        double amount = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. PayPal");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter card number: ");
                String card = sc.nextLine();
                processor.setPaymentStrategy(new CreditCardPayment(card));
                break;
            case 2:
                System.out.print("Enter UPI ID: ");
                String upi = sc.nextLine();
                processor.setPaymentStrategy(new UPIPayment(upi));
                break;
            case 3:
                System.out.print("Enter PayPal email: ");
                String email = sc.nextLine();
                processor.setPaymentStrategy(new PayPalPayment(email));
                break;
            default:
                System.out.println("Invalid choice!");
        }

        processor.pay(amount);
        sc.close();
    }
}
