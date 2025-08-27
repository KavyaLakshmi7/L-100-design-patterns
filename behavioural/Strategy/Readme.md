# Strategy Pattern - Payment Processing System

## 📌 Overview

This project demonstrates the **Strategy Design Pattern** using a payment processing system.

The **Strategy Pattern** is a behavioral design pattern that enables selecting an algorithm (or strategy) at runtime. Instead of implementing a single payment logic, multiple payment methods are encapsulated as separate strategies.

This allows the client to choose a payment method (Credit Card, UPI, PayPal) dynamically at runtime.

---

## 🛠️ Components

### 1. **PaymentStrategy (Interface)**

```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

* Defines a common interface for all payment strategies.
* Each payment method must implement the `pay()` method.

---

### 2. **Concrete Strategies**

#### CreditCardPayment

```java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}
```

#### UPIPayment

```java
public class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI: " + upiId);
    }
}
```

#### PayPalPayment

```java
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}
```

---

### 3. **PaymentProcessor (Context)**

```java
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment method selected!");
        }
    }
}
```

* Maintains a reference to the selected payment strategy.
* Delegates the payment action to the chosen strategy.

---

### 4. **PaymentClient (Main Class)**

```java
import java.util.Scanner;

public class PaymentClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentProcessor processor = new PaymentProcessor();

        System.out.print("Enter amount to pay: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. PayPal");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter card number: ");
                String card = sc.nextLine();
                processor.setPaymentStrategy(new CreditCardPayment(card));
                break;
            case 2:
                System.out.print("Enter UPI ID: ");
                String upi = sc.nextLine();
                processor.setPaymentStrategy(new UPIPayment(upi));
                break;
            case 3:
                System.out.print("Enter PayPal email: ");
                String email = sc.nextLine();
                processor.setPaymentStrategy(new PayPalPayment(email));
                break;
            default:
                System.out.println("Invalid choice!");
        }

        processor.pay(amount);
        sc.close();
    }
}
```

* Acts as the client that interacts with the user.
* Allows selection of different payment strategies at runtime.

---

## 🚀 How It Works

1. User enters the **amount** to pay.
2. User chooses a **payment method**.
3. The `PaymentProcessor` is assigned the corresponding strategy (`CreditCardPayment`, `UPIPayment`, or `PayPalPayment`).
4. The `pay()` method executes the chosen strategy.

---

## 🖥️ Sample Output

```
Enter amount to pay: 500
Choose payment method:
1. Credit Card
2. UPI
3. PayPal
2
Enter UPI ID: user@upi
Paid 500.0 using UPI: user@upi
```

---

## ✅ Advantages of Strategy Pattern

* Adds flexibility to change payment methods at runtime.
* Promotes **Open/Closed Principle** – new payment methods can be added without modifying existing code.
* Encapsulates each payment logic in its own class, making the code **clean** and **maintainable**.
