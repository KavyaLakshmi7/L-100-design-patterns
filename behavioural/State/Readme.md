# State Pattern - Traffic Light Example

## 📖 Overview
The **State Design Pattern** allows an object to change its behavior when its internal state changes.  
This example demonstrates a **Traffic Light System** that can switch between different modes:
- **Normal Mode**
- **Night Mode**
- **Emergency Mode**

Each mode has its own rules for how the traffic light behaves.

---

## 🛠 Implementation

### 🔹 `TrafficLightState` (Interface)
Defines the contract for different traffic light states:
```java
public interface TrafficLightState {
    void handleRequest();
}
````

### 🔹 `NormalMode`

Represents the standard mode with Green → Yellow → Red cycle.

```java
public class NormalMode implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Normal Mode: Green → Yellow → Red with standard timings.");
    }
}
```

### 🔹 `NightMode`

Represents night operation where the light blinks yellow for caution.

```java
public class NightMode implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Night Mode: Blinking Yellow for caution.");
    }
}
```

### 🔹 `EmergencyMode`

Represents emergency operation where the light stays green for quick passage.

```java
public class EmergencyMode implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Emergency Mode: Always Green to allow quick passage.");
    }
}
```

### 🔹 `TrafficLightContext`

Maintains the current state and delegates behavior to the active state.

```java
public class TrafficLightContext {
    private TrafficLightState currentState;

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void applyState() {
        if (currentState != null) {
            currentState.handleRequest();
        } else {
            System.out.println("No state set yet.");
        }
    }
}
```

### 🔹 `Main`

Interactive console program to switch between modes dynamically.

```java
public class Main {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose Traffic Light Mode:");
            System.out.println("1. Normal Mode");
            System.out.println("2. Night Mode");
            System.out.println("3. Emergency Mode");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> context.setState(new NormalMode());
                case 2 -> context.setState(new NightMode());
                case 3 -> context.setState(new EmergencyMode());
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

            context.applyState();
        }
    }
}
```

---

## 🎯 Example Output

```
Choose Traffic Light Mode:
1. Normal Mode
2. Night Mode
3. Emergency Mode
4. Exit

1
Normal Mode: Green → Yellow → Red with standard timings.

2
Night Mode: Blinking Yellow for caution.

3
Emergency Mode: Always Green to allow quick passage.
```

---

## ✅ Key Takeaways

* The **State Pattern** makes it easy to add new traffic light modes without modifying existing code.
* Each mode is encapsulated as a separate class, improving maintainability.
* The `TrafficLightContext` delegates behavior to the current active state.

