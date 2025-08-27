# Chain of Responsibility Pattern

## 📌 Definition
The **Chain of Responsibility Pattern** allows a request to pass along a chain of handlers.  
Each handler can either process the request or pass it to the next handler in the chain.  

This decouples the sender of a request from its receivers and promotes flexibility in assigning responsibilities.

---

## ⚡ Real-World Analogy
Imagine a **Customer Support System**:
- A **Chatbot** handles basic queries like password reset or FAQs.
- A **Junior Support Executive** handles billing-related issues.
- A **Senior Support Executive** handles technical issues.
- A **Manager** handles critical or unresolved cases.  

The request flows through this chain until it reaches the appropriate handler.

---

## 🛠 Implementation

### Abstract Handler
```java
public abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String query);
}
````

### Concrete Handlers

#### Chatbot Handler

```java
public class ChatbotHandler extends SupportHandler {
    @Override
    public void handleRequest(String query) {
        if (query.contains("password") || query.contains("FAQ")) {
            System.out.println("Chatbot: I can help you with resetting your password or FAQs.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(query);
        }
    }
}
```

#### Junior Support Handler

```java
public class JuniorSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(String query) {
        if (query.contains("billing")) {
            System.out.println("Junior Support: I can help you with billing issues.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(query);
        }
    }
}
```

#### Senior Support Handler

```java
public class SeniorSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(String query) {
        if (query.contains("technical") || query.contains("error")) {
            System.out.println("Senior Support: I will resolve your technical issue.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(query);
        }
    }
}
```

#### Manager Handler

```java
public class ManagerHandler extends SupportHandler {
    @Override
    public void handleRequest(String query) {
        System.out.println("Manager: This seems critical. I will personally handle this case.");
    }
}
```

---

### Client Code

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SupportHandler chatbot = new ChatbotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();
        SupportHandler manager = new ManagerHandler();

        // Setting the chain
        chatbot.setNextHandler(junior);
        junior.setNextHandler(senior);
        senior.setNextHandler(manager);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your support query:");
        String query = sc.nextLine();

        chatbot.handleRequest(query);
    }
}
```

---

## 🎯 Output Example

```
Enter your support query:
I have a billing issue

Junior Support: I can help you with billing issues.
```

```
Enter your support query:
My system has a technical error

Senior Support: I will resolve your technical issue.
```

```
Enter your support query:
I lost all my data!!!

Manager: This seems critical. I will personally handle this case.
```

---

## ✅ Key Points

* Handlers are linked in a chain.
* Each handler decides either to process the request or pass it to the next handler.
* Promotes loose coupling between sender and receiver.

---

## 📂 Folder Structure

```
ChainOfResponsibility/
│── ChatbotHandler.java
│── JuniorSupportHandler.java
│── SeniorSupportHandler.java
│── ManagerHandler.java
│── SupportHandler.java
│── Main.java
│── README.md
```
