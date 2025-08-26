public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Electronics electronics) {
        int cost = electronics.getPrice();
        if (cost > 1000) cost -= cost * 0.1;
        System.out.println("Electronics Item: " + electronics.getName() + ", Cost after discount: " + cost);
        return cost;
    }

    @Override
    public int visit(Grocery grocery) {
        int cost = grocery.getPrice();
        System.out.println("Grocery Item: " + grocery.getName() + ", Cost: " + cost);
        return cost;
    }

    @Override
    public int visit(Clothing clothing) {
        int cost = clothing.getPrice();
        if (cost > 500) cost -= 50;
        System.out.println("Clothing Item: " + clothing.getName() + ", Cost after discount: " + cost);
        return cost;
    }
}
