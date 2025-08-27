# Prototype Pattern 

## Goal

The **Prototype Pattern** is used to create new objects by cloning existing ones (prototypes) instead of creating them from scratch. This is especially useful when object creation is expensive or repetitive.

In this example, a **game level editor** uses preloaded prototypes (like enemies and blocks) to quickly clone and place objects in the game world.

---

## Real-World Analogy

Imagine you’re designing a video game level. Instead of creating a new enemy or block configuration from scratch every time, you keep a **catalog of master copies**. Whenever you need one, you **duplicate the prototype** and customize its properties (position, speed, etc.).

---

## How It Works

* **GameObject (Abstract Class):** Defines common properties (`name`, `x`, `y`) and implements `clone()`.
* **Goomba & BrickBlock (Concrete Prototypes):** Specific game entities with additional attributes (`speed`, `breakable`).
* **PrototypeRegistry (Prototype Manager):** Stores master prototypes in a registry (map) and provides clones on request.
* **Main (Client):** Retrieves prototypes, clones them, modifies properties, and places them in the level.

---

## Execution Flow

1. Master prototypes (`Goomba`, `BrickBlock`) are registered in the `PrototypeRegistry`.
2. When a designer wants a new object, the registry **clones the prototype**.
3. The cloned object can be customized (e.g., position, speed, breakability).
4. Verification shows that cloned objects are **different instances**, not the same object.

---

## Why This Design?

* **Efficiency:** Avoids recreating complex objects from scratch.
* **Consistency:** Ensures cloned objects inherit the correct base configuration.
* **Flexibility:** Cloned objects can be customized independently without affecting the prototype.

---

## Run

```sh
javac Main.java
java Main
```

### Output

```
--- Prototype Pattern: Game Level Editor ---
Loading master game object prototypes...
Prototypes loaded!

>> Level designer places a Goomba.
Rendering a 'Goomba' at (100, 50) with speed 1.

>> Level designer places another Goomba.
Rendering a 'Goomba' at (150, 50) with speed 2.

>> Level designer places a Brick Block.
Rendering a 'Brick Block' at (200, 100). Breakable: true

--- Verification ---
Is goomba1 the same object as goomba2? false
--------------------

Re-rendering the first Goomba to show it's unchanged:
Rendering a 'Goomba' at (100, 50) with speed 1.
```

---

## Files

* **GameObject.java** → Abstract prototype with cloning logic.
* **Goomba.java** → Concrete prototype representing an enemy.
* **BrickBlock.java** → Concrete prototype representing a block.
* **PrototypeRegistry.java** → Stores and provides cloned objects.
* **Main.java** → Client demo showing how prototypes are cloned and customized.
