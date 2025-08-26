public class MultiplyExpression implements Expression {
    private int a, b;

    public MultiplyExpression(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int interpret() {
        return a * b;
    }
}
