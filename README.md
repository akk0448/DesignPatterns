# 🎯 Java Design Patterns – Summary Guide

![Java](https://img.shields.io/badge/Language-Java-orange)
![OOP](https://img.shields.io/badge/Principle-OOP%20SOLID-blue)
![Patterns](https://img.shields.io/badge/Coverage-Complete-green)

---

## 📦 What Are Design Patterns?

Design patterns are **proven, reusable solutions** to common software design problems. They help developers write **modular, flexible, and maintainable** code.

---

## 📚 Types of Design Patterns

Design patterns fall into **three major categories**:

| Category      | Focus                                   | Examples                           |
|---------------|------------------------------------------|-------------------------------------|
| 🏗️ Creational   | How objects are created                 | Factory, Singleton, Builder         |
| 🧱 Structural   | How objects are composed/structured     | Adapter, Decorator, Composite       |
| 🧠 Behavioral   | How objects interact/communicate        | Strategy, Observer, Command         |

---

# 🏗️ Creational Patterns

These patterns deal with **object creation**. They abstract the instantiation process to make systems **flexible and decoupled**.

### 1. **Factory Method**
- Creates objects without exposing the instantiation logic.
- 🧪 Example: `VehicleFactory` to create `Car` or `Bike`.

### 2. **Abstract Factory**
- Factory of factories for creating related objects.
- 🧪 Example: `UIFactory` for creating buttons/textboxes for Windows/Mac.

### 3. **Singleton**
- Ensures a class has only one instance.
- 🧪 Example: Database connection manager, logger.

### 4. **Builder**
- Builds complex objects step-by-step.
- 🧪 Example: `ReportBuilder` for generating PDF or Excel.

### 5. **Prototype**
- Clones existing objects instead of creating from scratch.
- 🧪 Example: Game characters, deep copy utilities.

---

# 🧱 Structural Patterns

These patterns focus on **how objects are composed** to form larger systems.

### 1. **Adapter**
- Converts one interface into another.
- 🧪 Example: Charger adapter between USB-C and Micro-USB.

### 2. **Bridge**
- Separates abstraction from implementation.
- 🧪 Example: Remote → [TV, Radio] bridge.

### 3. **Composite**
- Treats individual objects and groups uniformly.
- 🧪 Example: File and Folder system.

### 4. **Decorator**
- Adds new responsibilities without changing original class.
- 🧪 Example: Adding toppings to a pizza or logging to a service.

### 5. **Facade**
- Simplifies complex subsystems with a unified interface.
- 🧪 Example: `PaymentFacade` hides bank, wallet, card logic.

### 6. **Flyweight**
- Reduces memory by sharing common parts.
- 🧪 Example: Characters in a text editor.

### 7. **Proxy**
- Controls access to real object.
- 🧪 Example: Access control, lazy loading, logging wrapper.

---

# 🧠 Behavioral Patterns

These patterns deal with **communication between objects**, and define **object responsibilities**.

### 1. **Strategy**
- Defines a family of interchangeable algorithms.
- 🧪 Example: Payment via UPI, card, wallet.

### 2. **Observer**
- Notify all observers when state changes.
- 🧪 Example: News Feed, Stock Market Ticker.

### 3. **Command**
- Encapsulates a request as an object.
- 🧪 Example: Undo/Redo, macro recording, robot commands.

### 4. **State**
- Changes behavior based on internal state.
- 🧪 Example: Order status → Placed, Shipped, Delivered.

### 5. **Template Method**
- Skeleton algorithm with steps overridden by subclasses.
- 🧪 Example: Report generation with different data types.

### 6. **Chain of Responsibility**
- Pass request along a chain of handlers.
- 🧪 Example: Logging → Auth → Validation → Processing.

### 7. **Mediator**
- Central object handles communication between classes.
- 🧪 Example: Chat room handling users.

### 8. **Memento**
- Captures and restores object state (undo support).
- 🧪 Example: Text editor undo/redo.

### 9. **Iterator**
- Sequential access without exposing internal structure.
- 🧪 Example: Playlist manager.

### 10. **Visitor**
- Adds operations to object structure without changing it.
- 🧪 Example: Tax calculator visiting different product types.

---

# 🆚 Key Differences

| Aspect       | Creational         | Structural          | Behavioral             |
|--------------|--------------------|----------------------|------------------------|
| Focus        | Object creation     | Object composition   | Object interaction     |
| Goal         | Flexibility, reuse  | Readability, modular | Separation of concerns |
| Complexity   | Often simple        | Medium               | Often dynamic/complex  |

---

## 🔁 Real-World Analogy Summary

| Pattern Type | Analogy                            |
|--------------|-------------------------------------|
| Creational   | Ordering food → Factory prepares    |
| Structural   | Lego bricks → Combine parts         |
| Behavioral   | Office team → Who communicates how  |

---

## 🏆 Outcome

This summary gives you a **complete reference** and **recap** of all the classic design patterns in Java. Each one:
- Solves a specific category of problem
- Offers modular and maintainable structure
- Has clear real-world application