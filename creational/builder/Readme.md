# Builder Pattern — Report Generation System

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

The **Builder Pattern** is a creational design pattern that helps construct **complex objects step by step**. It allows flexible and readable configuration of objects without creating large constructors or numerous overloaded methods.

In this project, we implement a **Report Generation System** where reports can be configured with multiple optional parameters such as:

* **Title**
* **Header**
* **Footer**
* **Format (PDF, CSV, HTML)**
* **Include Charts**

Using the Builder pattern ensures the object remains **immutable**, while still providing a simple way to construct different report variations.

---

## 🏗 Design Pattern

### 🔹 Implementation Details

* **Product (`Report`)**: The immutable report object built with different attributes.
* **Builder (`Report.Builder`)**: Provides a fluent API to set optional parameters (title, format, header, etc.).
* **Director (implicit - `Main`)**: Demonstrates how different types of reports can be built.
* **Service (`ReportGenerator`)**: Simulates generating reports from the built configuration.

### 🔹 Class Structure

* `Report` → Product class, immutable once created.
* `Report.Builder` → Nested static builder class.
* `ReportFormat` → Enum defining supported formats (PDF, CSV, HTML).
* `ReportGenerator` → Service class that processes the built report.
* `Main` → Demonstration of building and generating reports.

### 🔹 Key Components

* **Fluent API**: Builder methods return `this` so calls can be chained.
* **Validation**: Data source is mandatory and validated in the builder.
* **Immutability**: Once a `Report` object is built, it cannot be changed.

### 🔹 Benefits

* Cleaner and more readable object construction.
* Reduces complexity when dealing with multiple optional parameters.
* Encourages immutability and thread-safety.
* Allows creation of different report types with minimal effort.

---

## ✨ Features

* Configurable **report building** with optional parameters.
* Multiple output **formats** (CSV, PDF, HTML).
* Flexible **header, footer, title** customization.
* Optional **charts inclusion** for analytics reports.
* Demonstrates multiple use cases in a single run.

---

## 📘 Detailed Example Explanation

Imagine a **report generation system** for different stakeholders:

* **CSV Report**: Quick, simple export for data analysts.
* **PDF Report**: Executive-ready report with title, header/footer, and charts.
* **HTML Report**: Live dashboard integration with charts.

Instead of writing multiple constructors for every possible combination, we use the **Builder Pattern**.
The builder lets us easily construct reports step by step while keeping the final `Report` immutable and consistent.

---

## ⚙️ Installation & Setup

```bash
# Clone the repository
git clone https://github.com/KavyaLakshmi7/L-100-design-patterns.git

# Navigate to Builder Pattern folder
cd L-100-design-patterns/03-builder

# Compile and run
javac Main.java
java Main
```

---

## 📂 Project Structure

```
03-builder/
│── model/
│   ├── Report.java              # Product with nested Builder class
│   └── ReportFormat.java        # Enum for formats (PDF, CSV, HTML)
│
│── service/
│   └── ReportGenerator.java     # Service class for generating reports
│
│── Main.java                    # Demonstration client
│── README.md                    # Documentation
```

---

## 💻 Development / Usage

* Create a new report using `Report.Builder("dataSource")`.
* Chain configuration methods like `.withTitle()`, `.withFormat()`, `.withHeader()`.
* Call `.build()` to get the final immutable `Report`.
* Pass the `Report` object to `ReportGenerator` for processing.

---

## 🧪 Testing / Demonstration

### Run:

```bash
java Main
```

### Sample Output:

```
--- Builder Pattern: Report Generation System ---

Building a simple CSV report...
Starting report generation with the following configuration:
--- Report Configuration ---
  Data Source:   quarterly_sales_2024.csv
  Title:         Untitled Report
  Format:        CSV
  Header:        N/A
  Footer:        N/A
  Include Charts: false
--------------------------
...processing data, applying format, rendering charts...
 Report generation complete!

========================================

Building a formal PDF report for executives...
Starting report generation with the following configuration:
--- Report Configuration ---
  Data Source:   user_engagement_metrics.sql
  Title:         Q3 User Engagement Analysis
  Format:        PDF
  Header:        Confidential - For Internal Use Only
  Footer:        Page 1 of 10
  Include Charts: true
--------------------------
...processing data, applying format, rendering charts...
 Report generation complete!

========================================

Building an HTML report for a web dashboard...
Starting report generation with the following configuration:
--- Report Configuration ---
  Data Source:   live_server_stats.json
  Title:         Live Server Status
  Format:        HTML
  Header:        N/A
  Footer:        N/A
  Include Charts: true
--------------------------
...processing data, applying format, rendering charts...
 Report generation complete!
```

---

## 📚 References

* [GoF: Builder Pattern](https://en.wikipedia.org/wiki/Builder_pattern)
* [Refactoring Guru: Builder](https://refactoring.guru/design-patterns/builder)

---

## 🔄 Comparison with Other Patterns

* **Builder vs Factory Method**:

  * Factory Method creates **one product in one step**.
  * Builder creates **complex products step by step**.
* **Builder vs Abstract Factory**:

  * Abstract Factory focuses on creating families of related products.
  * Builder focuses on building a **single complex object** with optional parts.
* **Builder vs Prototype**:

  * Prototype clones an existing object.
  * Builder constructs a new object step by step.

