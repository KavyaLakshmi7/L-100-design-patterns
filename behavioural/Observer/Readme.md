# 🌦️ Observer Pattern - Weather Station

## 📌 Overview
The **Observer Pattern** is a behavioral design pattern where an object (**Subject**) maintains a list of dependents (**Observers**) and automatically notifies them of any state changes.  
It’s widely used for implementing **event-driven systems**.

In this example, a **Weather Station** broadcasts updates (temperature, humidity, pressure) to multiple observers like **Mobile Apps, Display Boards, and Alert Systems**.

---

## 🛠️ Components

1. **Subject (WeatherStation)**  
   - Maintains weather data (temperature, humidity, pressure).  
   - Registers, removes, and notifies observers.  

2. **Observer Interface**  
   - Defines the `update()` method for all observers.  

3. **Concrete Observers**  
   - **MobileApp** → Shows weather updates to users.  
   - **DisplayBoard** → Public display of weather conditions.  
   - **AlertSystem** → Raises alerts on extreme conditions.  

4. **Client (WeatherStationClient)**  
   - Simulates live weather updates entered by the user.  

---

## 📂 Class Diagram

```

```
    Subject (WeatherStation)
    ├── registerObserver()
    ├── removeObserver()
    ├── notifyObservers()
    └── setMeasurements()

    Observer (interface)
    └── update(temperature, humidity, pressure)

    ┌───────────────┐   ┌────────────────┐   ┌─────────────────┐
    │ MobileApp     │   │ DisplayBoard   │   │ AlertSystem      │
    └───────────────┘   └────────────────┘   └─────────────────┘
```

```

---

## ▶️ Example Run

```

Weather Station started. Enter measurements:
Enter temperature (°C) or '999' to exit: 35
Enter humidity (%): 50
Enter pressure (hPa): 1000

\[User1] Mobile App Update: Temp=35.0°C, Humidity=50.0%, Pressure=1000.0hPa
\[Main Square] DisplayBoard: Temp=35.0°C, Humidity=50.0%, Pressure=1000.0hPa

Enter temperature (°C) or '999' to exit: 42
Enter humidity (%): 18
Enter pressure (hPa): 1005

\[User1] Mobile App Update: Temp=42.0°C, Humidity=18.0%, Pressure=1005.0hPa
\[Main Square] DisplayBoard: Temp=42.0°C, Humidity=18.0%, Pressure=1005.0hPa
Alert: Extreme temperature detected!
Alert: Low humidity warning!

````

---

## ✅ Key Benefits
- Decouples **publisher (Subject)** from **subscribers (Observers)**.  
- Supports multiple observers dynamically.  
- Useful for **event-driven systems** (GUIs, notifications, messaging).  

---

## 📖 Real-World Use Cases
- Weather monitoring systems 🌦️  
- Stock market tickers 📈  
- News updates and push notifications 🔔  
- Chat applications (real-time messaging) 💬  

---

## 🚀 How to Run
1. Compile all `.java` files:  
   ```bash
   javac *.java
````

2. Run the program:

   ```bash
   java WeatherStationClient
   ```