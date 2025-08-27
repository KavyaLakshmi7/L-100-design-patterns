# Bridge Pattern

## 📖 Overview

The **Bridge Pattern** is a **structural design pattern** that decouples an abstraction from its implementation so that the two can vary independently.
Instead of binding a class tightly to one implementation, the pattern introduces a bridge (an interface) that allows you to switch implementations at runtime.

This makes the system more flexible, scalable, and easy to extend.

---

## 🎯 Real-life Analogy

Think of a **remote control** and a **television**:

* A remote (abstraction) can work with any brand of TV (implementation).
* The TV brand might differ (Samsung, Sony, LG), but the remote still controls it.
* Changing the remote’s functions does not affect the TV’s internal workings, and vice versa.

---

## ⚙️ Key Components

1. **Abstraction (Message)**

   * Defines the high-level control logic.
   * Contains a reference to the implementation interface.

2. **Refined Abstraction (TextMessage, UrgentMessage)**

   * Extends the abstraction and provides specific variations.

3. **Implementor (MessageSender)**

   * Defines the interface for the low-level implementation.

4. **Concrete Implementor (EmailSender, SMSSender)**

   * Provides actual implementation details of the sender.

---

## 🛠️ When to Use

* When you need to **decouple abstraction from implementation**.
* When you expect both abstraction and implementation to **evolve independently**.
* When you want to **switch implementations at runtime**.

---

## ✅ Advantages

* Improves **flexibility** by decoupling abstraction from implementation.
* Both abstraction and implementation can be **extended independently**.
* Helps avoid **class explosion** that occurs when you combine multiple abstractions with multiple implementations.

---

## ⚠️ Disadvantages

* Increases complexity due to the introduction of more interfaces and classes.
* May be **overkill** for simple applications with only one implementation.

---

## 📌 Example from Code

In this implementation:

* **Message** (abstraction) → `TextMessage`, `UrgentMessage`.
* **MessageSender** (implementor) → `EmailSender`, `SMSSender`.
* Both evolve independently: You can add new message types **without changing senders**, and new senders **without modifying messages**.

