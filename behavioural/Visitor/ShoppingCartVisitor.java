public interface ShoppingCartVisitor {
    int visit(Electronics electronics);
    int visit(Grocery grocery);
    int visit(Clothing clothing);
}
