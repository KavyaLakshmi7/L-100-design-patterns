# Template Method Pattern

## 📖 Overview
The **Template Method Pattern** defines the skeleton of an algorithm in a superclass while allowing subclasses to provide specific implementations for certain steps.  

This ensures the algorithm’s structure remains the same while different parts can vary.  
It follows the **Hollywood Principle**: *"Don’t call us, we’ll call you."*

---

## 🛠️ Key Points
- Provides a **template method** that defines the overall algorithm.
- Subclasses **override only specific steps** of the algorithm.
- Promotes **code reuse** by keeping the invariant parts in the abstract class.
- Ensures **consistent execution order** of steps.

---

## 🏗️ Structure
1. **Abstract Class (`OrderProcessTemplate`)**
   - Defines the **template method** (`processOrder`) which calls abstract and concrete steps.
   - Abstract methods: `validateOrder()`, `processPayment()`, `shipOrder()`.
   - Concrete method: `sendNotification()`.

2. **Concrete Subclasses**
   - **`ElectronicsOrder`** → Implements order steps for electronics.
   - **`GroceryOrder`** → Implements order steps for groceries.

3. **Client (`OrderClient`)**
   - Chooses order type dynamically and executes the template.

---

## 📂 Implementation
### **Abstract Template**
```java
public abstract class OrderProcessTemplate {

    public final void processOrder() {
        validateOrder();
        processPayment();
        shipOrder();
        sendNotification();
    }

    protected abstract void validateOrder();
    protected abstract void processPayment();
    protected abstract void shipOrder();

    protected void sendNotification() {
        System.out.println("Sending order confirmation email...");
    }
}
````

### **Concrete Subclasses**

```java
public class ElectronicsOrder extends OrderProcessTemplate {
    @Override
    protected void validateOrder() {
        System.out.println("Validating electronics order with warranty check...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment for electronics using credit card...");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Shipping electronics via courier with insurance...");
    }
}
```

```java
public class GroceryOrder extends OrderProcessTemplate {
    @Override
    protected void validateOrder() {
        System.out.println("Validating grocery order for stock availability...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment for groceries using UPI...");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Delivering groceries via local delivery partner...");
    }
}
```

### **Client**

```java
public class OrderClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose order type:");
        System.out.println("1. Electronics");
        System.out.println("2. Grocery");
        int choice = sc.nextInt();

        OrderProcessTemplate order = null;

        switch (choice) {
            case 1: order = new ElectronicsOrder(); break;
            case 2: order = new GroceryOrder(); break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        System.out.println("\nProcessing order...");
        order.processOrder();
        sc.close();
    }
}
```

---

## ▶️ Example Run

```
Choose order type:
1. Electronics
2. Grocery
1

Processing order...
Validating electronics order with warranty check...
Processing payment for electronics using credit card...
Shipping electronics via courier with insurance...
Sending order confirmation email...
```

---

## ✅ When to Use

* When you want to **enforce a standard algorithm** but let subclasses customize certain steps.
* To **avoid code duplication** when multiple classes share the same workflow with small differences.
* Useful in scenarios like:

  * Payment processing systems
  * Order workflows
  * Report generation

---

## 🎯 Advantages

* Promotes **code reuse**.
* Provides **consistent process flow**.
* Easy to extend by adding new subclasses.

## ⚠️ Limitations

* Can lead to **inflexibility** if too many steps are fixed in the template.
* Changes in the template may impact **all subclasses**.