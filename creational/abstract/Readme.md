# Abstract Factory Pattern — Cross-Platform UI

## 📌 Table of Contents

1. [Overview](#overview)
2. [Design Pattern](#design-pattern)

   * Implementation Details
   * Class Structure
   * Key Components
   * Benefits
3. [Features](#features)
4. [Detailed Example Explanation](#detailed-example-explanation)
5. [Installation & Setup](#installation--setup)
6. [Project Structure](#project-structure)
7. [Development / Usage](#development--usage)
8. [Testing / Demonstration](#testing--demonstration)
9. [References](#references)
10. [Comparison with Other Patterns](#comparison-with-other-patterns)

---

## 📖 Overview

The **Abstract Factory Pattern** provides an interface for creating families of related or dependent objects without specifying their concrete classes.

In this project, we simulate a **Cross-Platform UI system**.
Depending on the detected operating system (`macOS` or `Windows`), the application uses the appropriate UI factory to generate **buttons** and **checkboxes** styled for that platform.

---

## 🏗 Design Pattern

### 🔹 Implementation Details

* **Abstract Factory (`UIFactory`)**: Declares methods to create families of UI elements (Button, Checkbox).
* **Concrete Factories (`MacOSFactory`, `WindowsFactory`)**: Implement creation methods for specific OS styles.
* **Products (`Button`, `Checkbox`)**: Define interfaces for UI components.
* **Concrete Products (`MacOSButton`, `WindowsButton`, etc.)**: Provide OS-specific implementations.
* **Client (`Application`)**: Configures itself with a factory and uses it to render UI components.

### 🔹 Class Structure

* `UIFactory` → Abstract factory interface.
* `MacOSFactory` / `WindowsFactory` → Concrete factories.
* `Button`, `Checkbox` → Abstract product interfaces.
* `MacOSButton`, `WindowsButton`, `MacOSCheckbox`, `WindowsCheckbox` → Concrete products.
* `Application` → Client using factory to remain independent of platform-specific implementations.

### 🔹 Key Components

* **Factory**: Encapsulates the decision of which family of objects to use.
* **Client**: Works with abstract types, not concrete classes.
* **Family of Products**: Buttons and Checkboxes are always created together for a consistent UI.

### 🔹 Benefits

* Supports **cross-platform** development.
* Client code remains **independent** of specific product classes.
* Easy to add new families of products (e.g., Linux UI).
* Ensures consistency across related UI elements.

---

## ✨ Features

* Dynamically detects OS (`System.getProperty("os.name")`).
* Creates OS-specific **button** and **checkbox**.
* Consistent rendering of UI across platforms.
* Easily extensible for future platforms.

---

## 📘 Detailed Example Explanation

Imagine you’re building a desktop application that must run on **both macOS and Windows**.

* On macOS, buttons should look like: 🔘 and checkboxes like ☑︎.
* On Windows, buttons should look like: \[□] and checkboxes like \[✓].

The application shouldn’t worry about which OS it is on. Instead, it configures itself with a **UIFactory** that knows how to produce platform-specific elements.

When the OS changes, the app still works without modifying client logic — only the factory changes.

---

## ⚙️ Installation & Setup

```bash
# Clone the repository
git clone https://github.com/KavyaLakshmi7/L-100-design-patterns.git

# Navigate to Abstract Factory Pattern folder
cd L-100-design-patterns/02-abstract-factory

# Compile and run
javac Main.java
java Main
```

---

## 📂 Project Structure

```
02-abstract-factory/
│── app/
│   └── Application.java        # Client application using factory
│
│── components/
│   ├── Button.java             # Abstract product
│   ├── Checkbox.java           # Abstract product
│   ├── MacOSButton.java        # Concrete product
│   ├── MacOSCheckbox.java      # Concrete product
│   ├── WindowsButton.java      # Concrete product
│   └── WindowsCheckbox.java    # Concrete product
│
│── factories/
│   ├── UIFactory.java          # Abstract factory
│   ├── MacOSFactory.java       # Concrete factory
│   └── WindowsFactory.java     # Concrete factory
│
│── Main.java                   # Entry point
│── README.md                   # Documentation
```

---

## 💻 Development / Usage

* The `Application` class accepts any `UIFactory` at runtime.
* To add Linux support:

  1. Create `LinuxButton` and `LinuxCheckbox`.
  2. Implement `LinuxFactory` that returns Linux UI components.
  3. Update `configureApplication()` in `Main.java` to handle Linux OS.

---

## 🧪 Testing / Demonstration

### Run:

```bash
java Main
```

### Sample Output (on macOS):

```
--- Abstract Factory Pattern: Cross-Platform UI ---
Detected OS: macOS
OS is macOS, creating macOS UI components.
Configuring application with a UI factory...
Application is running. Rendering UI elements...
Rendering a button in macOS style. (🔘)
Rendering a checkbox in macOS style. (☑︎)
```

### Sample Output (on Windows):

```
--- Abstract Factory Pattern: Cross-Platform UI ---
Detected OS: windows
OS is not macOS, creating Windows UI components.
Configuring application with a UI factory...
Application is running. Rendering UI elements...
Rendering a button in Windows style. [□]
Rendering a checkbox in Windows style. [✓]
```

---

## 📚 References

* [GoF: Abstract Factory](https://en.wikipedia.org/wiki/Abstract_factory_pattern)
* [Refactoring Guru: Abstract Factory](https://refactoring.guru/design-patterns/abstract-factory)

---

## 🔄 Comparison with Other Patterns

* **Factory Method vs Abstract Factory**:

  * Factory Method creates one product at a time.
  * Abstract Factory creates **families of products** that work together.
* **Abstract Factory vs Builder**:

  * Abstract Factory is about creating related objects.
  * Builder focuses on step-by-step object construction.
* **Abstract Factory vs Prototype**:

  * Prototype clones existing objects, while Abstract Factory creates new ones from scratch.
