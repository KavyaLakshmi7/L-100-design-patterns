public abstract class OrderProcessTemplate {

    public final void processOrder() {
        validateOrder();
        processPayment();
        shipOrder();
        sendNotification();
    }

    protected abstract void validateOrder();
    protected abstract void processPayment();
    protected abstract void shipOrder();

    protected void sendNotification() {
        System.out.println("Sending order confirmation email...");
    }
}
