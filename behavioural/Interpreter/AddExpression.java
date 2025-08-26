public class AddExpression implements Expression {
    private int a, b;

    public AddExpression(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int interpret() {
        return a + b;
    }
}
