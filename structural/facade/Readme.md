# 🎨 Facade Pattern - Art Studio Example

## 📖 Overview
The **Facade Pattern** provides a simplified interface to a complex subsystem.  
Instead of directly interacting with multiple classes, clients can use a **Facade** that exposes high-level methods while hiding underlying details.

In this example, we simulate a **digital art studio** where multiple components like `Canvas`, `Brush`, `ColorPalette`, `LayerManager`, and `ExportManager` work together.  
The `ArtStudioFacade` acts as the **Facade**, making it easier to create sketches, paint portraits, and export artwork without worrying about individual subsystems.

---

## 🛠️ Components
- **Canvas** → Creates and manages the drawing surface.  
- **Brush** → Selects and applies brush strokes.  
- **ColorPalette** → Chooses colors for painting.  
- **LayerManager** → Adds and merges layers.  
- **ExportManager** → Exports the final artwork.  
- **ArtStudioFacade** → Simplifies all the above operations into easy-to-use methods.  

---

## 📂 Class Diagram
```

ArtStudioFacade
|
\|-- Canvas
\|-- Brush
\|-- ColorPalette
\|-- LayerManager
\|-- ExportManager

````

---

## 💻 Code Example
```java
public class Main {
    public static void main(String[] args) {
        ArtStudioFacade artStudio = new ArtStudioFacade();

        System.out.println("Starting sketch:");
        artStudio.createSketch();

        System.out.println("\nPainting portrait:");
        artStudio.paintPortrait();

        System.out.println("\nExporting artwork:");
        artStudio.exportArtwork("PNG");
    }
}
````

---

## 🖼️ Output

```
Starting sketch:
Canvas created with default size.
Pencil brush selected.
Black color selected.
Brush stroke applied.
Layer 'Sketch Layer' added.

Painting portrait:
Canvas created with default size.
Oil Brush brush selected.
Skin Tone color selected.
Brush stroke applied.
Layer 'Base Layer' added.
Red color selected.
Brush stroke applied.
Layer 'Detail Layer' added.

Exporting artwork:
All layers merged.
Artwork exported as PNG file.
```

---

## ✅ When to Use

* When you want to provide a **simplified interface** to a complex system.
* When clients should not need to know the inner details of subsystems.
* When you want to decouple client code from multiple interdependent classes.

---

## 🎯 Key Takeaway

The **Facade Pattern** helps reduce complexity by providing a **high-level interface** that delegates tasks to underlying subsystems.
It improves **readability**, **maintainability**, and **usability** of complex systems.
