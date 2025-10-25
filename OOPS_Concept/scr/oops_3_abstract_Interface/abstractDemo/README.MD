# Java Abstract Classes — Concepts and Use Cases

This directory demonstrates the concept of **abstract classes** in Java, their syntax, and practical use cases including abstraction, inheritance, and enforcing implementation in subclasses.

---

## What is an Abstract Class?

- An **abstract class** is a class declared with the `abstract` keyword.
- It can contain abstract methods (methods without a body) and concrete methods (methods with a body).
- Abstract classes cannot be instantiated directly; they must be subclassed.
- Any subclass of an abstract class must implement all its abstract methods.

---

## Important Notes and Rules for Abstract Classes

1. **Abstract Methods:**  
   - Declared without a body using the `abstract` keyword.
   - Must be implemented by subclasses.

2. **Concrete Methods:**  
   - Abstract classes can also have regular methods with implementation.

3. **Constructors:**  
   - Abstract classes can have constructors, but cannot be instantiated directly.
   - Subclasses can call the abstract class constructor using `super()`.

4. **No Abstract Static Methods:**  
   - Static methods cannot be abstract, as static methods cannot be overridden.

5. **No Abstract Final Classes:**  
   - Abstract classes cannot be declared as `final` because they are meant to be inherited.

6. **Multiple Inheritance:**  
   - Java does not support multiple inheritance with abstract classes.

7. **Access Modifiers:**  
   - Abstract methods must be `public` or `protected` (not `private`).

---

## Why Use Abstract Classes?

- **Abstraction:**  
  Hide implementation details and enforce a contract for subclasses.
- **Code Reuse:**  
  Provide common functionality in the abstract class, while allowing subclasses to implement specific behavior.
- **Template Design:**  
  Define a template for subclasses to follow.

---

## Key Features Demonstrated

- **Abstract Class Declaration:**  
  - [Father.java](./Father.java): Abstract class with abstract and concrete methods, and a constructor.
- **Concrete Subclasses:**  
  - [Son.java](./Son.java), [Daughter.java](./Daughter.java): Implement all abstract methods from `Father`.
- **Usage:**  
  - Demonstrates how to instantiate subclasses and call both abstract and concrete methods.

---

## File Overview

- **[Father.java](./Father.java):**  
  Abstract class with abstract methods (`carrer`, `partner`), concrete method (`displayAge`), and constructor.
- **[Son.java](./Son.java):**  
  Subclass of `Father`, implements abstract methods.
- **[Daughter.java](./Daughter.java):**  
  Subclass of `Father`, implements abstract methods.

---

## How to Run

Compile all files and run `Son.java` or `Daughter.java` to see how abstract classes enforce method implementation and enable code reuse.

---

## Learn More

- [Java Abstract Classes (Oracle Docs)](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Abstract Classes vs Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

---
