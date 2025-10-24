# Introduction to Object-Oriented Programming (OOP)

**Object-Oriented Programming (OOP)** is a programming paradigm that revolves around the concept of **objects**. It is widely used in modern software development due to its ability to model real-world entities and manage complex systems effectively.

---

## Table of Contents

- [Classes & Objects](./oops_1_Concept/README.MD)
- [Access Modifiers](./oops_1_Concept/accessModifier/README.MD)
- [Packages, Static Keyword, Blocks](./oops_1_Concept/README.MD)
- [Inner Classes](./oops_1_Concept/README.MD)
- [Singleton Class](./oops_1_Concept/singleton/README.MD)
- [Inheritance](./oops_2_Pillar/inheritance/README.MD)
- [Polymorphism](./oops_2_Pillar/polymorphism/README.MD)
- [Abstraction](./oops_2_Pillar/abstraction/README.MD)
- [Encapsulation](./oops_2_Pillar/encapsulation/README.MD)

---

## Key Concepts of OOP

1. **Class**
    - A **class** is a blueprint or template for creating objects.
    - It defines the properties (fields) and behaviors (methods) that the objects created from the class will have.

2. **Object**
    - An **object** is an instance of a class. It represents a specific entity with the data and behavior defined by its class.

---

## The 4 Pillars Of OOP

1. **Encapsulation**
    - Bundling data and methods, restricting direct access using access modifiers.

2. **Inheritance**
    - Allows one class (child) to inherit the fields and methods of another class (parent).

3. **Polymorphism**
    - Enables a single interface to represent different data types or behaviors (method overloading/overriding).

4. **Abstraction**
    - Hiding implementation details and exposing only essential features using abstract classes and interfaces.

---

## Benefits of OOP

- **Modularity**: The code can be organized into distinct classes, making it easier to maintain and understand.
- **Reusability**: Inheritance allows the reuse of existing code.
- **Flexibility**: Polymorphism provides flexibility to use the same interface for different types.
- **Security**: Encapsulation protects the internal state of an object by restricting direct access.

### Summary of OOP Concepts
| **Concept**       | **Description**                                            |
|--------------------|------------------------------------------------------------|
| **Class**          | Blueprint for creating objects.                            |
| **Object**         | Instance of a class.                                       |
| **Encapsulation**  | Bundling data and methods, restricting direct access.      |
| **Inheritance**    | Mechanism to inherit features of a parent class.           |
| **Polymorphism**   | Ability to take many forms (overloading and overriding).   |
| **Abstraction**    | Hiding implementation details and exposing functionalities.|

### Real-World Example
Consider a **Banking System**:
- **Class**: `BankAccount`, `SavingsAccount`, `CurrentAccount`
- **Object**: An instance of `SavingsAccount` with a specific balance.
- **Encapsulation**: Balance is private, accessed through `getBalance()`.
- **Inheritance**: `SavingsAccount` and `CurrentAccount` inherit from `BankAccount`.
- **Polymorphism**: Overriding `calculateInterest()` differently in `SavingsAccount` and `CurrentAccount`.
- **Abstraction**: Abstracting account operations through a common interface.

This makes OOP a powerful paradigm for building scalable and maintainable software solutions.

| Relation                                                                               |
| -------------------------------------------------------------------------------------- |
| **Data Hiding** is *implemented using access modifiers* (`private`, `protected`, etc.) |
| **Encapsulation** uses *data hiding* to secure data inside an object                   |
| **Abstraction** focuses on *what to show to the user*, not how it's done               |
