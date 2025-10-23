# Introduction to Object-Oriented Programming (OOP)

**Object-Oriented Programming (OOP)** is a programming paradigm that revolves around the concept of **objects**. It is widely used in modern software development due to its ability to model real-world entities and manage complex systems effectively.

## Key Concepts of OOP

1. **Class**
    - A **class** is a blueprint or template for creating objects.
    - It defines the properties (fields) and behaviors (methods) that the objects created from the class will have.
    - Example:
      ```java
      class Car {
          String color;
          String model;
 
          void drive() {
              System.out.println("Car is driving.");
          }
      }
      ```

2. **Object**
    - An **object** is an instance of a class. It represents a specific entity with the data and behavior defined by its class.
    - Example:
      ```java
      Car myCar = new Car();
      myCar.color = "Red";
      myCar.drive(); // Outputs: Car is driving.
      ```
      
---
## The 4 Pillars Of OOP

1. **Encapsulation**
    - **Encapsulation** is the practice of bundling the data (fields) and methods that operate on the data into a single unit (class).
    - It also involves restricting direct access to some components using access modifiers (`private`, `protected`, `public`) and providing controlled access through methods.
    - Example:
      ```java
      class BankAccount {
          private double balance;
 
          public void deposit(double amount) {
              balance += amount;
          }
 
          public double getBalance() {
              return balance;
          }
      }
      ```

2. **Inheritance**
    - **Inheritance** allows one class (child class) to inherit the fields and methods of another class (parent class), promoting code reuse.
    - Example:
      ```java
      class Animal {
          void eat() {
              System.out.println("This animal eats food.");
          }
      }
 
      class Dog extends Animal {
          void bark() {
              System.out.println("The dog barks.");
          }
      }
      ```

3. **Polymorphism**
    - **Polymorphism** enables a single interface to represent different data types or behaviors.
    - It can be achieved through:
        - **Method Overloading**: Same method name, different parameter lists within the same class.
        - **Method Overriding**: A child class provides a specific implementation of a method already defined in its parent class.
    - Example of overriding:
      ```java
      class Animal {
          void sound() {
              System.out.println("Animal makes a sound.");
          }
      }
 
      class Cat extends Animal {
          @Override
          void sound() {
              System.out.println("Cat meows.");
          }
      }
      ```

4. **Abstraction**
    - **Abstraction** is the process of hiding the implementation details and showing only the essential features of an object.
    - It can be achieved using **abstract classes** and **interfaces**.
    - Example of abstract class:
      ```java
      abstract class Shape {
          abstract void draw();
      }
 
      class Circle extends Shape {
          void draw() {
              System.out.println("Drawing a circle.");
          }
      }
      ```

### Benefits of OOP

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