# Inheritance in Java

Inheritance is a key feature(concept) in OOP that allows one class to acquire the properties and behaviors of another class. It is implemented using the `extends` keyword.

## Key Points
- **Parent/Base Class**: The class whose properties are inherited.
- **Child/Derived Class (Sub-Class)**: The class that inherits the properties of the parent class.

### Syntax
```java
class B extends A {
    // Body of class B
}
```
In this example:
- `A` is the **Parent Class**.
- `B` is the **Child Class** (Sub-Class).

---

## Inheritance Case Study

### Case 1: Instance Members from Parent to Child Class
- All the **instance members** of the parent class are allocated memory within the instance memory of the child class object.

### Case 2: Static Members from Parent to Child Class
- **Static members** of a class are allocated memory within the class they belong to.
- Static members of the parent class are accessible to the child class and can be accessed using the child class name.

### Case 3: Constructors from Parent to Child Class

#### A) Non-Parameterized Constructor
- The compiler automatically inserts a `super()` call in the child class constructor.
- This `super()` call invokes the **parent class’s constructor**.

#### B) Parameterized Constructor
- When a parent class has a **parameterized constructor**, the child class constructor must explicitly call `super` with the required parameters.

### Example: Constructor Usage
```java
class A {
    A() {
        System.out.println("Parent Class Constructor");
    }
    
    A(int x) {
        System.out.println("Parent Class Parameterized Constructor: " + x);
    }
}

class B extends A {
    B() {
        super(); // Calls A()
        System.out.println("Child Class Constructor");
    }
    
    B(int y) {
        super(y); // Calls A(int x)
        System.out.println("Child Class Parameterized Constructor: " + y);
    }
}