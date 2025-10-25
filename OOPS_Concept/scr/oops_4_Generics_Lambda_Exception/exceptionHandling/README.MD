# Exception Handling in Java

This module demonstrates how to handle exceptions in Java, including custom exceptions, try-catch-finally blocks, and best practices for writing robust code.

---

## What is Exception Handling?

- **Error:**  
  Irreversible problems in the program (e.g., hardware failure, JVM crash). Errors cannot be recovered or handled in code.
- **Exception:**  
  Recoverable problems in the application code (e.g., invalid input, bad logic, division by zero). Exceptions can be handled and fixed in code.

---

## Key Concepts

- **Try-Catch-Finally Block:**  
  - `try`: Contains code that may throw an exception.
  - `catch`: Handles specific exceptions.
  - Multiple `catch` blocks can be used for different exception types.
  - `finally`: Always executes, regardless of whether an exception occurred.

- **Throwing Exceptions:**  
  - Use `throw` to manually throw an exception (e.g., `throw new ArithmeticException("message")`).
  - Custom exceptions can be created by extending the `Exception` class.

- **Custom Exception:**  
  - See `MyException` class in [ExceptionHandling.java](./ExceptionHandling.java).
  - Allows you to define your own exception types for specific error cases.

- **Checked vs Unchecked Exceptions:**  
  - Checked exceptions must be declared or handled (e.g., `Exception`, `IOException`).
  - Unchecked exceptions do not require explicit handling (e.g., `RuntimeException`, `ArithmeticException`).

---

## File Overview

- **[ExceptionHandling.java](./ExceptionHandling.java):**  
  - Demonstrates try-catch-finally blocks.
  - Shows how to throw and catch custom exceptions.
  - Includes a method for safe division with exception handling.

---

## How to Use

- Refer to [ExceptionHandling.java](./ExceptionHandling.java) for implementation details and example usage.
- Run the `main` method to see exception handling in action.

---

## Learn More

- [Java Exceptions (Oracle Docs)](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [Custom Exceptions in Java](https://www.geeksforgeeks.org/user-defined-exceptions-in-java/)

---
