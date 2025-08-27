### 📝 Problem:

* You have **two payment systems**:

  1. **UPI** (modern system, new interface).
  2. **Credit Card** (legacy system, uses a different method).

* Goal: Use **both systems in a unified way** through the `UPIPayment` interface.

---

### ⚙️ Key Components:

1. **Target Interface (UPIPayment)**

   ```java
   public interface UPIPayment {
       String pay(double amount);
   }
   ```

   * This is the standard interface your system expects.
   * Both **UPI** and **Credit Card (via adapter)** must fit into this.

---

2. **Adaptee (Legacy System - Credit CardProcessor)**

   ```java
   public class CreditCardProcessor {
       public String payWithCard(double amount) {
           return " Paid ₹" + amount + " using Credit Card";
       }
   }
   ```

   * This is the old system.
   * Notice it has a **different method name** (`payWithCard`) instead of `pay`.

---

3. **Adapter (CreditCardToUPIAdapter)**

   ```java
   public class CreditCardToUPIAdapter implements UPIPayment {
       private CreditCardProcessor creditCardProcessor;

       public CreditCardToUPIAdapter(CreditCardProcessor processor) {
           this.creditCardProcessor = processor;
       }

       @Override
       public String pay(double amount) {
           return creditCardProcessor.payWithCard(amount);
       }
   }
   ```

   * Converts the **Credit CardProcessor** into something that works like `UPIPayment`.
   * It **wraps** the old class and maps its method.

---

4. **Concrete Implementation of Target (UPIPaymentImpl)**

   ```java
   public class UPIPaymentImpl implements UPIPayment {
       public String pay(double amount) {
           return "Paid ₹" + amount + " using UPI";
       }
   }
   ```

---

5. **Client (AdapterPattern Main)**

   ```java
   if (choice == 1) {
       payment = new UPIPaymentImpl(); // directly supports UPI
   } else if (choice == 2) {
       payment = new CreditCardToUPIAdapter(new CreditCardProcessor()); // adapts legacy CC
   }
   ```

   * Client only deals with `UPIPayment` interface.
   * Doesn’t care whether it’s UPI or Credit Card — thanks to the adapter!

---

### ✅ Output Example:

```
Enter payment amount (₹): 500
Choose payment method:
1. UPI (modern system)
2. Credit Card (legacy, adapted to UPI)
2

 Paid ₹500.0 using Credit Card
```

