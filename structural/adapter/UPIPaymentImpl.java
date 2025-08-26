public class UPIPaymentImpl implements UPIPayment {
    public String pay(double amount) {
        return "Paid ₹" + amount + " using UPI";
    }
}
