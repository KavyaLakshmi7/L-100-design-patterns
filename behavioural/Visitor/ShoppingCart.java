import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ItemElement> items = new ArrayList<>();

    public void addItem(ItemElement item) {
        items.add(item);
    }

    public int calculateTotal() {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int total = 0;
        for (ItemElement item : items) {
            total += item.accept(visitor);
        }
        return total;
    }
}
