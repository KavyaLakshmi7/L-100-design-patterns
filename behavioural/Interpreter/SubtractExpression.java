public class SubtractExpression implements Expression {
    private int a, b;

    public SubtractExpression(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int interpret() {
        return a - b;
    }
}
