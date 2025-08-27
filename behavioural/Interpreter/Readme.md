# Interpreter Pattern Example

## 📖 Overview

The **Interpreter Pattern** is a behavioral design pattern that defines a representation for a grammar and provides an interpreter to evaluate sentences in the language.

In this example, we implement a **simple math expression interpreter** that can process basic arithmetic operations such as **addition, subtraction, and multiplication**.

---

## 📂 Project Structure

```
.
├── Expression.java
├── AddExpression.java
├── SubtractExpression.java
├── MultiplyExpression.java
└── ExpressionInterpreter.java
```

---

## 🛠️ Classes & Responsibilities

* **Expression (Interface)**
  Defines the `interpret()` method for all expressions.

* **AddExpression**
  Implements addition (`a + b`).

* **SubtractExpression**
  Implements subtraction (`a - b`).

* **MultiplyExpression**
  Implements multiplication (`a * b`).

* **ExpressionInterpreter (Main Program)**

  * Reads user input from the console.
  * Parses commands like `add 5 10`, `subtract 20 7`, `multiply 3 4`.
  * Creates the correct `Expression` object.
  * Calls the `interpret()` method to evaluate and display the result.

---

## ▶️ How to Run

1. Compile all `.java` files:

   ```bash
   javac *.java
   ```

2. Run the interpreter:

   ```bash
   java ExpressionInterpreter
   ```

3. Enter commands:

   ```
   add 5 10
   subtract 20 7
   multiply 3 4
   exit
   ```

---

## 💻 Example Run

```
Simple Math Expression Interpreter
Enter expressions like: add 5 10 | subtract 20 7 | multiply 3 4
Type 'exit' to quit.

Enter expression: add 5 10
Result: 15

Enter expression: subtract 20 7
Result: 13

Enter expression: multiply 3 4
Result: 12

Enter expression: exit
Interpreter exited.
```

---

## 🎯 Key Point

This program demonstrates how the **Interpreter Pattern** can be used to **evaluate expressions dynamically at runtime**.

Each new operation can be easily added by creating a new class that implements `Expression` (e.g., `DivideExpression`).
