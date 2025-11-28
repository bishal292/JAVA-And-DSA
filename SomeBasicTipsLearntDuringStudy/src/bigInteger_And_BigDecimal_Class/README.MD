# BigInteger & BigDecimal — Quick Reference

This folder contains concise demos and notes for Java's arbitrary-precision numeric classes:
- BigInteger — for arbitrarily large integer arithmetic.
- BigDecimal — for exact decimal arithmetic (useful for money, precise calculations).

## Files
- [BigIntegerDemo.java](BigIntegerDemo.java) — examples of addition, subtraction, multiplication, division and remainder for large integers.
- [BigDecimalDemo.java](BigDecimalDemo.java) — examples demonstrating exact decimal arithmetic and a note about division/recurring results.

## Why use these classes
- BigInteger: use when integer values exceed long range or you need exact integer arithmetic without overflow.
- BigDecimal: use when you need exact decimal representation and control over scale/rounding (currency, financial calculations, precise math).

## Basic usage (concept)
- BigInteger:
  - Creation: BigInteger.valueOf(long) or new BigInteger(String)
  - Operations: add, subtract, multiply, divide, remainder, pow, gcd, modPow
- BigDecimal:
  - Creation: BigDecimal.valueOf(double) or new BigDecimal(String) (preferred for exact values)
  - Operations: add, subtract, multiply, divide (with RoundingMode), setScale

## Code pointers
- See BigIntegerDemo.java for examples of creating BigInteger from long and String, and performing common arithmetic.
- See BigDecimalDemo.java for decimal subtraction and notes on division (recurring decimals require specifying scale and RoundingMode).


## Important notes & best practices
- Prefer constructors that take String for exact BigDecimal/BigInteger values to avoid floating-point conversion surprises.
- For BigDecimal division, always provide scale and RoundingMode if the result can be non-terminating (recurring).
- Operations are immutable: methods return new objects — reuse references carefully to avoid extra allocations if needed.
- Performance: these classes are slower and allocate more memory than primitives; use them only when required.

## Links
- BigInteger JavaDoc: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigInteger.html
- BigDecimal JavaDoc: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/math/BigDecimal.html
