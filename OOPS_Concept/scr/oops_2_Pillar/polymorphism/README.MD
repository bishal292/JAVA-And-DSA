# Polymorphism in Java

Polymorphism = *"The ability of one entity (method/member) to behave in multiple forms."* 
<br/>**OR**<br/>
*"The Process of one member working as more than one is known as polymorphism."*

> NOTE: =>  Final Method cannot be Overridden.Final class cannot be inherited.

> Static Methods are also not overridden as they are not dependent on objects but overriding depends.

> But Static methods can be inherited means the static method from parent class can also be used by using the child class if the child class does not have such method.
---

## Types of Polymorphism

- **Compile-Time (Static) Polymorphism:**  
  Achieved by method overloading and constructor overloading.
- **Runtime (Dynamic) Polymorphism:**  
  Achieved by method overriding.

```
                         ┌───────────────────────────┐
                         │        Polymorphism       │
                         └───────────────┬───────────┘
                                         │
          ┌──────────────────────────────┴──────────────────────────────┐
          │                                                             │
┌─────────▼───────────┐                                   ┌─────────────▼──────────┐
│Compile-Time (Static)│                                   │ Runtime (Dynamic)      │
└─────────┬───────────┘                                   └────────────┬───────────┘
          │                                                            │
┌─────────▼───────┐                                          ┌─────────▼─────────┐
│ Method Overload │                                          │ Method Override   │
├─────────────────┤                                          └───────────────────┘
│ Constructor OL  │
│ Method Hiding   │
└─────────────────┘
```

---

## Compile-Time Polymorphism (Overloading)

- **Method Overloading:**  
  Multiple methods with the same name but different parameter lists in the same class.
- **Constructor Overloading:**  
  Multiple constructors with different parameter lists in the same class.
- **Static Method Hiding:**  
  Static methods with the same name in parent and child classes; child hides the parent method.

---

## Runtime Polymorphism (Overriding)

- **Method Overriding:**  
  Child class provides a specific implementation of a method already defined in its parent class.  
  The method signature must be the same.
- **Dynamic Method Dispatch:**  
  At runtime, the JVM determines which method to invoke based on the actual object type, not the reference type.

---

## Key Notes

- Final methods cannot be overridden. Final classes cannot be inherited.
- Static methods are not overridden; they are hidden.
- Static methods can be inherited and called using the child class if not present in the child.

---

## Method Overriding vs Field Hiding

- **Instance Methods:**  
  Resolved at runtime based on the actual object type.
- **Fields (Instance Variables):**  
  Resolved at compile time based on the reference type.

| Feature           | Behavior                           |
|-------------------|------------------------------------|
| Instance Methods  | Runtime polymorphism (child called)|
| Fields            | Compile-time binding (parent used) |

---

## Example Usage

See the following files for practical examples:

- [Main.java](./Main.java): Demonstrates polymorphism, method overriding, and field hiding.
- [Shapes.java](./Shapes.java): Parent class with area method and field.
- [Square.java](./Square.java), [Circle.java](./Circle.java), [Triangle.java](./Triangle.java): Child classes overriding area method and demonstrating field hiding.

---

## Summary

Polymorphism enables flexible and reusable code by allowing objects to be treated as instances of their parent class, while still invoking child-specific behavior. Use method overriding for runtime flexibility and method overloading for compile-time convenience.
