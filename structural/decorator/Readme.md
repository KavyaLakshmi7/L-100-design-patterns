# 🎭 Decorator Design Pattern – Example: Game Character Power-Ups

## 🔹 Overview

The **Decorator Pattern** allows behavior to be added to individual objects, dynamically, without affecting the behavior of other objects of the same class.

In this example:

* A **Basic Character** starts with a default description and power level.
* Using **Power-Up Decorators** (Speed Boost, Shield, Double Damage), we can dynamically enhance the character.
* The pattern lets us "wrap" the character with new abilities at runtime.

This avoids subclass explosion (we don’t need a class for every possible combination of power-ups).

---

## 🔹 UML Diagram

```
       Character (interface)
       + getDescription()
       + getPower()
              ^
              |
   ----------------------------
   |                          |
BasicCharacter        PowerUpDecorator (abstract)
                             ^
                             |
        ----------------------------------------
        |                  |                  |
   SpeedBoost           Shield         DoubleDamage
```

---

## 🔹 Pattern Participants

1. **Component (Character)** → Defines the interface (`getDescription()`, `getPower()`).
2. **Concrete Component (BasicCharacter)** → Base object that can be decorated.
3. **Decorator (PowerUpDecorator)** → Abstract class that holds a reference to a `Character` and forwards calls.
4. **Concrete Decorators (SpeedBoost, Shield, DoubleDamage)** → Add new behavior (increase description + power).

---

## 🔹 Flow of Execution

1. Player starts as a **Basic Character** (power = 10).
2. Each chosen **Power-Up** wraps the existing character.

   * Example: `new SpeedBoost(new BasicCharacter())`
3. The result is a chain of decorators that build up the character’s powers.
4. The client (Game) treats everything as a `Character`, without caring if it’s a base or decorated object.

---

## 🔹 Example Run

```
Your character starts as: Basic Character (Power: 10)

Choose a power-up:
1. Speed Boost (+5 power)
2. Shield (+8 power)
3. Double Damage (+15 power)
4. Exit
Enter choice: 1

Current Character: Basic Character + Speed Boost (Power: 15)

Choose a power-up:
1. Speed Boost (+5 power)
2. Shield (+8 power)
3. Double Damage (+15 power)
4. Exit
Enter choice: 3

Current Character: Basic Character + Speed Boost + Double Damage (Power: 30)

Game Over! Final Character: Basic Character + Speed Boost + Double Damage (Power: 30)
```

---

## 🔹 Benefits of Decorator Pattern

✅ **Flexibility** – Add features at runtime without modifying the base class.
✅ **Avoids subclass explosion** – Instead of dozens of combinations (e.g., `ShieldedSpeedBoostedCharacter`), we just compose decorators.
✅ **Open/Closed Principle** – Existing code remains untouched; new power-ups can be added easily.
