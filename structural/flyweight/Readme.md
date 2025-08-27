# 🎨 Flyweight Pattern

## 📖 Overview

The **Flyweight Pattern** is a **structural design pattern** that minimizes memory usage by sharing common parts of objects instead of duplicating them.
It is particularly useful when creating a large number of similar objects, as it avoids redundant data storage.

In this example, we simulate a **Forest Drawing App** where multiple trees are drawn. Instead of storing unique data for each tree (which would be memory-heavy), we share common properties like **tree type, color, and texture** using the **Flyweight Pattern**.

---

## 🛠 Components

### 1. **Flyweight (TreeType)**

* Stores **intrinsic state** (shared properties: name, color, texture).
* Reused across multiple `Tree` objects.

### 2. **Concrete Flyweight (TreeType Implementation)**

* Implements the `draw()` method with shared data.

### 3. **Flyweight Factory (TreeFactory)**

* Ensures that only one object is created per unique **tree type**.
* Provides shared instances when requested.

### 4. **Context (Tree)**

* Holds **extrinsic state** (unique data like x and y coordinates).
* Uses a `TreeType` (flyweight) to avoid duplication.

### 5. **Client (Forest / Main)**

* Requests trees through the factory.
* Manages tree placement and drawing without worrying about memory.

---

## 📂 Class Diagram

```
Forest (Client) --> Tree (Context) --> TreeType (Flyweight)
          \_____________________/
                   |
             TreeFactory (Factory)
```

---

## 💻 Example Code

### Flyweight (`TreeType.java`)

```java
public class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + "," + y + ") "
                + "with color " + color + " and texture " + texture);
    }
}
```

### Factory (`TreeFactory.java`)

```java
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
            System.out.println("Created new TreeType: " + key);
        }
        return treeTypes.get(key);
    }
}
```

### Context (`Tree.java`)

```java
public class Tree {
    private int x, y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
```

### Client (`Forest.java`)

```java
import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        trees.add(new Tree(x, y, type));
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}
```

### Main (`Main.java`)

```java
public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();

        forest.plantTree(10, 20, "Oak", "Green", "Rough");
        forest.plantTree(30, 40, "Pine", "Dark Green", "Smooth");
        forest.plantTree(50, 60, "Oak", "Green", "Rough"); // Reuses existing flyweight
        forest.plantTree(70, 80, "Pine", "Dark Green", "Smooth"); // Reuses existing flyweight

        forest.draw();
    }
}
```

---

## 🚀 Output

```
Created new TreeType: Oak-Green-Rough
Created new TreeType: Pine-Dark Green-Smooth
Drawing Oak tree at (10,20) with color Green and texture Rough
Drawing Pine tree at (30,40) with color Dark Green and texture Smooth
Drawing Oak tree at (50,60) with color Green and texture Rough
Drawing Pine tree at (70,80) with color Dark Green and texture Smooth
```

---

## ✅ Benefits

* Saves memory by **sharing common data**.
* Reduces object creation overhead.
* Works great in **graphics apps, text editors, or large object simulations**.

## ⚠️ When to Use

* When a program needs to create a **huge number of similar objects**.
* When memory usage becomes a **performance bottleneck**.
