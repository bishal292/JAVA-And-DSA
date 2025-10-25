# Bitwise Operators in Java

Bitwise operators perform operations directly on the binary representations of integers. They are useful for low-level programming, optimization, and solving certain algorithmic problems efficiently.

---

## Operators Overview

| Operator | Name                  | Description                                                      |
|----------|-----------------------|------------------------------------------------------------------|
| `&`      | Bitwise AND           | Sets each bit to 1 if both bits are 1                            |
| `|`      | Bitwise OR            | Sets each bit to 1 if one of two bits is 1                       |
| `^`      | Bitwise XOR           | Sets each bit to 1 if only one of two bits is 1                  |
| `~`      | Bitwise NOT           | Inverts all the bits                                             |
| `<<`     | Left Shift            | Shifts bits to the left (multiplies by powers of 2)              |
| `>>`     | Right Shift           | Shifts bits to the right (divides by powers of 2)                |
| `>>>`    | Unsigned Right Shift  | Shifts bits to the right, fills leftmost bits with zeros         |

---

## Common Use Cases

- **Odd or Even Check:**  
  Use `n & 1` to check if a number is odd or even.
- **Find Unique Element:**  
  Use XOR to find a non-repeating number in an array where others repeat twice.
- **Get/Set Nth Bit:**  
  Use bitwise AND/OR and shifting to get or set a specific bit.
- **Isolate Rightmost Set Bit:**  
  Use `num & -num` to isolate the lowest set bit.
- **Magic Number Calculation:**  
  Convert binary to a special number using bitwise operations.
- **Pascal's Triangle Row Sum:**  
  Use left shift to compute powers of 2 efficiently.

---

## Example Problems Solved

- Odd or even check
- Find non-repeating number in array
- Get/set nth bit of a number
- Find position of rightmost set bit
- Calculate nth magic number
- Pascal's triangle row sum using bitwise shift

See [BitwiseOperators.java](./BitwiseOperators.java) for code and explanations.

---

## Learn More

- [Java Bitwise Operators (Oracle Docs)](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html)
- [Bit Manipulation Tricks (GeeksforGeeks)](https://www.geeksforgeeks.org/bitwise-operators-in-java/)

---
