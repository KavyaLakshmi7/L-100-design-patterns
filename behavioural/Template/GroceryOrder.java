public class GroceryOrder extends OrderProcessTemplate {

    @Override
    protected void validateOrder() {
        System.out.println("Validating grocery order for stock availability...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment for groceries using UPI...");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Delivering groceries via local delivery partner...");
    }
}
