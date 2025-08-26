public class ElectronicsOrder extends OrderProcessTemplate {

    @Override
    protected void validateOrder() {
        System.out.println("Validating electronics order with warranty check...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment for electronics using credit card...");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Shipping electronics via courier with insurance...");
    }
}
