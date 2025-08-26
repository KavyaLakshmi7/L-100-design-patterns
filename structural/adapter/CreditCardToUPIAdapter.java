public class CreditCardToUPIAdapter implements UPIPayment {
    private CreditCardProcessor creditCardProcessor;

    public CreditCardToUPIAdapter(CreditCardProcessor processor) {
        this.creditCardProcessor = processor;
    }

    @Override
    public String pay(double amount) {
        return creditCardProcessor.payWithCard(amount);
    }
}
