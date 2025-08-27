# Factory Method Pattern 

## Goal

The **Factory Method Pattern** defines an interface for creating objects but allows subclasses to decide which class to instantiate. This provides flexibility and decouples the object creation process from the main logic.

In this example, different **restaurants** (Pizzeria, Burger Joint) prepare different **food items** (Pizza, Burger) using a common creation method.

---

## Real-World Analogy

Think of ordering food: you walk into a restaurant, place an order, and the restaurant decides how to prepare it.

* A **Pizzeria** always prepares a Pizza.
* A **Burger Joint** always prepares a Burger.
  You don’t need to know *how* they are made—you just trust the restaurant’s method.

---

## How It Works

* **FoodItem (Interface):** Defines a contract (`prepare`) for all food items.
* **Pizza & Burger (Concrete Classes):** Implement the `prepare` method differently.
* **Restaurant (Abstract Class):** Declares the factory method `createFood()`.
* **Pizzeria & BurgerJoint (Concrete Factories):** Decide which food item to create.
* **FoodOrder (Client):** Places an order without knowing the actual food creation details.

---

## Execution Flow

1. A customer places an order (`orderFood()` method).
2. The restaurant (factory) decides which food to prepare.
3. The food is prepared and served without the customer knowing its exact preparation process.

---

## Why This Design?

* **Encapsulation:** Hides object creation logic.
* **Flexibility:** Easy to add new restaurants and food items without changing existing code.
* **Decoupling:** Client code (FoodOrder) depends only on abstract interfaces, not concrete classes.

---

## Run

```sh
javac FoodOrder.java
java FoodOrder
```

### Output

```
--- Factory Method Pattern ---
A new order has been received.
Preparing a delicious Pizza with cheese and toppings.
The order is ready to be served!

-----------------------------------

A new order has been received.
Grilling a juicy Burger with lettuce and tomato.
The order is ready to be served!
```

---

## Files

* **FoodItem.java** → Interface for all food items
* **Pizza.java, Burger.java** → Concrete implementations of `FoodItem`
* **Restaurant.java** → Abstract factory defining `createFood()`
* **Pizzeria.java, BurgerJoint.java** → Concrete factories implementing `createFood()`
* **FoodOrder.java** → Client code demonstrating the pattern
