public class Clothing implements ItemElement {
    private int price;
    private String name;

    public Clothing(int price, String name) {
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
