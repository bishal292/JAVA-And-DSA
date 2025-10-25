# Java Generics, Comparator, and Lambda Expressions

This module demonstrates the use of generics, custom generic classes, comparators, and lambda expressions in Java. Each concept is explained with practical code examples.

---

## Key Concepts

### 1. Generics

- **Type Safety:** Generics allow classes, interfaces, and methods to operate on different data types while ensuring compile-time type safety.
- **Custom Generic Class:**  
  See [CustomArrayList.java](./CustomArrayList.java) for a generic array list implementation with bounded type (`T extends Number`).
- **Type Parameters:**  
  Common symbols: `T` (Type), `E` (Element), `K` (Key), `V` (Value), `?` (Wildcard).
- **Bounded Generics:**  
  - Upper Bound: `<? extends Number>`
  - Lower Bound: `<? super Integer>`
  - PECS Rule: Producer Extends, Consumer Super

### 2. Comparator and Comparable

- **Comparable Interface:**  
  See [ComparatorDemo.java](./ComparatorDemo.java) for sorting custom objects using `compareTo`.
- **Custom Sorting:**  
  Implement `compareTo` to define sorting logic (by roll number or marks).
- **Arrays.sort:**  
  Sorts arrays of objects that implement `Comparable`.

### 3. Lambda Expressions

- **Functional Programming:**  
  Lambda expressions provide a concise way to represent functions.
- **Usage Example:**  
  See [Main.java](./Main.java) for using lambda with `forEach` on an ArrayList.

---

## File Overview

- **[CustomArrayList.java](./CustomArrayList.java):**  
  Generic array list implementation for `Number` types.
- **[ComparatorDemo.java](./ComparatorDemo.java):**  
  Demonstrates sorting custom objects using `Comparable`.
- **[Main.java](./Main.java):**  
  Shows usage of custom generic list and lambda expressions.

---

## How to Use

- Refer to the code files for implementation details and example usage.
- Run the `main` methods to see generics, sorting, and lambda expressions in action.

---

## Summary Table

| Concept        | Description          | Example              |
| -------------- | -------------------- | -------------------- |
| Generic Class  | Type-safe class      | `class Box<T>`       |
| Generic Method | Type-safe method     | `<T> void method()`  |
| Upper Bound    | Subclasses allowed   | `<? extends Number>` |
| Lower Bound    | Superclasses allowed | `<? super Integer>`  |
| Wildcard       | Unknown type         | `List<?>`            |
| Comparable     | Sorting logic        | `compareTo()`        |
| Lambda         | Functional syntax    | `(x) -> x * 2`       |

---

## Learn More

- [Java Generics (Oracle Docs)](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- [Comparator and Comparable](https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html)
- [Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

---
