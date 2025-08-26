public class Grocery implements ItemElement {
    private int price;
    private String name;

    public Grocery(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() { return price; }
    public String getName() { return name; }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
