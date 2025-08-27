# 📦 Composite Design Pattern – Example: Weapons & Weapon Packs

## 🔹 Overview

The **Composite Pattern** lets you treat individual objects and groups of objects (compositions) uniformly.
In this example, we model **weapons in a game**. A weapon can be a **Sword**, **Bow**, or **Gun** (leaf objects). A group of weapons can be bundled together into a **WeaponPack** (composite object).

This allows us to:

* Treat a **single weapon** and a **pack of weapons** in the same way.
* Perform actions (`attack()`, `showDetails()`) without caring if it’s a **single object** or a **collection of objects**.

---

## 🔹 UML Diagram

```
            Weapon (Interface)
            + attack()
            + showDetails()
                   ^
                   |
   ---------------------------------
   |               |               |
 Sword           Bow             Gun     (Leaf nodes)
   |
 WeaponPack (Composite) → Holds multiple Weapons
```

---

## 🔹 Code Structure

### **1. Component (Interface)**

```java
public interface Weapon {
    void attack();
    void showDetails();
}
```

### **2. Leaf Classes** (Individual Weapons)

```java
public class Sword implements Weapon {
    private String name;
    public Sword(String name) { this.name = name; }

    @Override
    public void attack() {
        System.out.println(name + " slashes with a sharp blade!");
    }

    @Override
    public void showDetails() {
        System.out.println("Weapon: " + name + " (Sword)");
    }
}
```

Similarly, `Bow` and `Gun` implement `Weapon`.

### **3. Composite Class (WeaponPack)**

```java
import java.util.ArrayList;
import java.util.List;

public class WeaponPack implements Weapon {
    private String packName;
    private List<Weapon> weapons = new ArrayList<>();

    public WeaponPack(String packName) {
        this.packName = packName;
    }

    public void addWeapon(Weapon weapon) { weapons.add(weapon); }
    public void removeWeapon(Weapon weapon) { weapons.remove(weapon); }

    @Override
    public void attack() {
        System.out.println(">>> " + packName + " attacks with all weapons!");
        for (Weapon weapon : weapons) {
            weapon.attack();
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Weapon Pack: " + packName);
        for (Weapon weapon : weapons) {
            weapon.showDetails();
        }
    }
}
```

### **4. Client Code (Game.java)**

```java
public class Game {
    public static void main(String[] args) {
        Weapon sword = new Sword("Excalibur");
        Weapon bow = new Bow("Elven Bow");
        Weapon gun = new Gun("Desert Eagle");

        WeaponPack starterPack = new WeaponPack("Starter Pack");
        starterPack.addWeapon(sword);
        starterPack.addWeapon(bow);

        WeaponPack ultimatePack = new WeaponPack("Ultimate Pack");
        ultimatePack.addWeapon(starterPack);
        ultimatePack.addWeapon(gun);

        System.out.println("\n--- Showing Details ---");
        ultimatePack.showDetails();

        System.out.println("\n--- Attacking ---");
        ultimatePack.attack();
    }
}
```

---

## 🔹 Sample Output

```
--- Showing Details ---
Weapon Pack: Ultimate Pack
Weapon Pack: Starter Pack
Weapon: Excalibur (Sword)
Weapon: Elven Bow (Bow)
Weapon: Desert Eagle (Gun)

--- Attacking ---
>>> Ultimate Pack attacks with all weapons!
>>> Starter Pack attacks with all weapons!
Excalibur slashes with a sharp blade!
Elven Bow shoots an arrow!
Desert Eagle fires a bullet!
```

---

## 🔹 Benefits of Composite Pattern

✅ Treats **individual objects** and **collections uniformly**.
✅ Simplifies client code (client doesn’t need to check if it’s a single object or composite).
✅ Makes it easy to build complex structures like **nested weapon packs**.