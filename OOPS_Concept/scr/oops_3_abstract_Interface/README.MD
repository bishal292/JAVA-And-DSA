# Introduction to Abstract Classes and Interfaces

Before working with abstract classes and interfaces in Java, here are the essential points to understand:

---

## Key Points

- **Abstract Method:**  
  A method declared without a body (no implementation). Only abstract classes and interfaces can have abstract methods.

- **Concrete Method:**  
  A method declared with a body (implementation).

- **Abstract Class:**  
  A class that may contain abstract methods. Cannot be instantiated directly; must be subclassed.

- **Concrete Class:**  
  A Typical class declared without abstract keyword is known as concrete class.

- **Interface:**  
  A collection of abstract methods (and default/static methods). Used to specify a contract for classes to implement.

- **Static Members:**  
  Static methods and fields belong to the class, not instances. Static methods cannot be overridden.

- **Why Use Abstract/Interface?**  
  - To achieve abstraction (hide implementation details, show only essential features).
  - To define common behavior for multiple classes.
  - Interfaces allow multiple inheritance of type (a class can implement multiple interfaces).

---

## Learn More

For details and examples, see:
- [Abstract Class](./abstractDemo/README.MD)
- [Interfaces](./interfaceDemo/README.MD)