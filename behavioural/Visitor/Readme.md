# Visitor Pattern

## 📖 Overview
The **Visitor Pattern** lets you add new operations to existing object structures **without modifying their classes**.  
Instead of embedding logic inside objects, it separates the logic into a **visitor**, which is then applied to elements.

In this example, we use the Visitor Pattern to calculate the **total shopping cart cost with discounts** for different types of items.

---

## 🛠️ Key Points
- **`ItemElement`**: Interface for all items in the shopping cart.
- **`Clothing`, `Electronics`, `Grocery`**: Concrete item classes that implement `ItemElement`.
- **`ShoppingCartVisitor`**: Visitor interface declaring visit methods for each item type.
- **`ShoppingCartVisitorImpl`**: Concrete visitor with discount logic for each item.
- **`ShoppingCart`**: Holds a list of items and calculates the total using the visitor.
- **`ShoppingCartClient`**: User-driven client to add items and calculate total.

---

## 📂 Implementation

### **Element Interface**
```java
public interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}
````

### **Concrete Elements**

```java
public class Electronics implements ItemElement {
    private int price;
    private String name;

    public Electronics(int price, String name) {
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
```

```java
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
```

```java
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
```

---

### **Visitor Interface**

```java
public interface ShoppingCartVisitor {
    int visit(Electronics electronics);
    int visit(Grocery grocery);
    int visit(Clothing clothing);
}
```

### **Concrete Visitor**

```java
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
```

---

### **Shopping Cart**

```java
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
```

---

### **Client**

```java
import java.util.Scanner;

public class ShoppingCartClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Add items to your shopping cart (type 'done' to finish):");

        while (true) {
            System.out.print("Enter item type (Electronics/Grocery/Clothing): ");
            String type = sc.nextLine();
            if (type.equalsIgnoreCase("done")) break;

            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            System.out.print("Enter item price: ");
            int price = sc.nextInt();
            sc.nextLine(); 

            switch (type.toLowerCase()) {
                case "electronics":
                    cart.addItem(new Electronics(price, name));
                    break;
                case "grocery":
                    cart.addItem(new Grocery(price, name));
                    break;
                case "clothing":
                    cart.addItem(new Clothing(price, name));
                    break;
                default:
                    System.out.println("Invalid type!");
            }
        }

        System.out.println("\nCalculating total cost with discounts:");
        int total = cart.calculateTotal();
        System.out.println("Total Cost: " + total);
        sc.close();
    }
}
```

---

## ▶️ Example Run

```
Add items to your shopping cart (type 'done' to finish):
Enter item type (Electronics/Grocery/Clothing): Electronics
Enter item name: Laptop
Enter item price: 1200
Enter item type (Electronics/Grocery/Clothing): Grocery
Enter item name: Apples
Enter item price: 200
Enter item type (Electronics/Grocery/Clothing): Clothing
Enter item name: Jacket
Enter item price: 600
Enter item type (Electronics/Grocery/Clothing): done

Calculating total cost with discounts:
Electronics Item: Laptop, Cost after discount: 1080
Grocery Item: Apples, Cost: 200
Clothing Item: Jacket, Cost after discount: 550
Total Cost: 1830
```

---

## ✅ When to Use

* When you want to **add new operations** to objects **without modifying their classes**.
* When objects belong to a structure with **different unrelated types**, but you need to perform operations on all of them.
* Examples:

  * Shopping carts (price calculation, discount application)
  * Document processing
  * Compiler syntax trees

---

## 🎯 Advantages

* **Open/Closed Principle**: Add new operations without changing element classes.
* Cleaner separation of **object structure** and **operations**.
* Easy to add different types of operations (discounts, taxes, reporting).

## ⚠️ Limitations

* Adding new element types requires modifying the visitor interface and all visitors.
* Can become complex if too many elements/visitors are added.