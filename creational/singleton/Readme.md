# Singleton Design Pattern

## Overview
The **Singleton Pattern** ensures that a class has **only one instance** and provides a **global point of access** to that instance.  
This pattern is widely used when **exactly one object** is needed to coordinate actions across the system, such as managing configurations, logging, or database connections.

---

## Real-World Example
Consider a **Database Connection Manager** in an application:  
- We only want **one connection object** managing access to the database.  
- Multiple instances could lead to **conflicts, resource wastage, or inconsistent states**.  
- The Singleton ensures that all parts of the application use the **same instance** consistently.

---

## Key Characteristics
- **Single Instance:** Only one object of the class exists at runtime.  
- **Global Access:** The instance can be accessed globally through a controlled method.  
- **Lazy or Eager Initialization:** The instance can be created when first requested (lazy) or at application startup (eager).  

---

## When to Use
- When you need **exactly one instance** of a class.  
- When you want to **control access to shared resources**, like a logging service, thread pool, or configuration manager.  
- When you want to **coordinate actions across the system** from a central object.

---

## Advantages
- **Controlled Access:** The singleton class controls the instantiation of itself.  
- **Reduced Memory Usage:** Only one instance exists, reducing overhead.  
- **Consistency:** Ensures that all parts of the system use the same instance.

---

## Disadvantages
- **Overuse Risk:** Can lead to **tight coupling** and hidden dependencies.  
- **Difficult Testing:** The global state can make unit testing more challenging.  
- **Concurrency Issues:** Without proper synchronization, lazy initialization may be unsafe in multithreaded environments.

---

## Summary
The Singleton Pattern is a **creational design pattern** that guarantees a class has **a single instance**, while providing **controlled global access**.  
It is a **simple yet powerful tool** for managing shared resources and maintaining consistent state across an application.
Nice implementation 👌 — this is a **Singleton Pattern** in action.
Let me explain what your code does step by step:

---

### 🔑 Key Points of Your Code:

1. **Private Constructor (`AppConfig`)**

   * Prevents outside classes from creating new instances using `new`.
   * Ensures control over instance creation.

2. **Private Static Final Instance**

   ```java
   private static final AppConfig instance = new AppConfig();
   ```

   * A single, eagerly created instance is stored here.
   * The moment the class is loaded, the instance is created.

3. **Public Access Method**

   ```java
   public static AppConfig getInstance() {
       return instance;
   }
   ```

   * Provides a global access point to the single instance.

4. **Configuration Fields**

   * `databaseUrl` and `apiKey` simulate real-world config values.

5. **Verification in `Main`**

   * You check if `config1` and `config2` are the same instance using `==`.
   * If true → proves Singleton works correctly.

---

### ✅ Sample Output (when you run it)

```
Starting the Food Delivery App...
---------------------------------
The User Module needs the configuration...
AppConfig instance created. Reading configuration...
User Module using DB URL: jdbc:mysql://localhost/food_delivery_db

The Order Module needs the configuration...
Order Module using API Key: ABC123XYZ789-SECRET

--- Verifying Singleton ---
SUCCESS: config1 and config2 are the same instance.
Object reference for config1: AppConfig@1b6d3586
Object reference for config2: AppConfig@1b6d3586
```

