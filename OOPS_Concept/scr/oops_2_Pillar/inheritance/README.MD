# Inheritance in Java

Inheritance is a fundamental concept in Object-Oriented Programming (OOP) that allows one class (child/subclass) to acquire the properties and behaviors of another class (parent/superclass). In Java, inheritance is implemented using the `extends` keyword.

## Key Concepts

- **Parent/Base Class:** The class whose members are inherited.
- **Child/Derived Class:** The class that inherits from the parent.

### Syntax

```java
class Child extends Parent {
    // Child class body
}
```

---

## Types of Inheritance Demonstrated

- **Single Inheritance:** One child class inherits from one parent class.
- **Multilevel Inheritance:** A class inherits from a child class, which itself inherits from another parent class.
- **Hierarchical Inheritance:** Multiple child classes inherit from the same parent class.

*Note: Java does not support multiple inheritance directly (a class cannot extend more than one class), but it can be achieved using interfaces.*

---

## How Members Are Inherited

- **Instance Members:** All non-private instance variables and methods of the parent are accessible in the child.
- **Static Members:** Static members are associated with the class and accessible via child class name.
- **Private Members:** Not accessible in child classes.
- **Constructors:** Parent constructors can be called from child constructors using `super()`.

---

## Constructor Chaining

- If the parent class has a parameterized constructor, the child must call it explicitly using `super(parameters)`.
- If not specified, Java automatically inserts a call to the parent's no-argument constructor.

---

## Example Classes

- [Box.java](./Box.java): Base class with dimensions.
- [BoxWeight.java](./BoxWeight.java): Inherits from Box, adds weight.
- [BoxPrice.java](./BoxPrice.java): Inherits from BoxWeight, adds cost.
- [BoxColor.java](./BoxColor.java): Inherits from Box, adds color.

See [Main.java](./Main.java) for usage and demonstration of inheritance types.

---

## Example

```java
class Box { ... }
class BoxWeight extends Box { ... }
class BoxPrice extends BoxWeight { ... }
class BoxColor extends Box { ... }
```

---

## Usage

- Create objects of child classes to access both parent and child members.
- Use `super()` in child constructors to initialize parent class members.

---

## Learn More

- [Java Inheritance (Oracle Docs)](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Main.java Example](./Main.java)

---