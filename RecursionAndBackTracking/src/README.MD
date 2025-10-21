# Recursion in Java

Recursion is a programming technique where a function calls itself to solve smaller instances of a problem. It is a fundamental concept for solving problems that can be broken down into similar subproblems.

This module is organized into the following directories, each focusing on a specific aspect or application of recursion:

---

## 1. [recursionBasic](./recursionBasic/Recursion.java)

**Description:**  
Covers the fundamentals of recursion, including:
- What is recursion?
- Base case and recursive case
- Stack overflow and recursion depth

**Example Problems (see [Recursion.java](./recursionBasic/Recursion.java)):**
- Print numbers from N to 1 and 1 to N
- Print numbers from N to 1 then 1 to N (both directions)
- Calculate factorial of a number
- Find nth Fibonacci number
- Sum of numbers up to N
- Sum of digits of a number
- Reverse a number using recursion (two methods)

---

## 2. [recursionArray](./recursionArray/RecursionOnArray.java)

**Description:**  
Focuses on applying recursion to array-based problems, such as:
- Searching for an element in an array recursively
- Finding all indices of a target value
- Checking if an array is sorted using recursion
- Returning an ArrayList from recursion in different ways

**Example Problems (see [RecursionOnArray.java](./recursionArray/RecursionOnArray.java)):**
- Check if an array is sorted recursively
- Linear search using recursion
- Find all indices of a target value (using global variable, passing ArrayList, or returning from recursion)
- Binary search using recursion
- Search in a rotated sorted array recursively
- Bubble sort and selection sort implemented recursively

---

## 3. [recSubsetStringSubseq_3](./recSubsetStringSubseq_3/SubSeq.java)

**Description:**  
Explores recursion for generating subsets, subsequences, and string manipulations.

**Example Problems (see [SubSeq.java](./recSubsetStringSubseq_3/SubSeq.java) and [RecString.java](./recSubsetStringSubseq_3/RecString.java)):**
- Print all subsequences of a string
- Return all subsequences as an ArrayList
- Generate all subsequences including ASCII representations
- Generate all subsets of an array (including handling duplicates)
- String skipping problems:
  - Skip a specific character from a string
  - Skip a substring (e.g., "apple") from a string
  - Skip "app" only if not followed by "apple"

---

## 4. [recPermutaions](./recPermutaions/recPermutations.java)

**Description:**  
Deals with recursive generation of permutations.

**Example Problems (see [recPermutations.java](./recPermutaions/recPermutations.java)):**
- Print all permutations of a string
- Return all permutations as an ArrayList
- Count the number of permutations

---

## 5. [recAdvProblems](./recAdvProblems/RecAdvProblems.java)

**Description:**  
Advanced recursion problems and variations.

**Example Problems (see [RecAdvProblems.java](./recAdvProblems/RecAdvProblems.java)):**
- Letter Combinations of a Phone Number [LeetCode 17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)
- Dice roll problems:
  - Print all ways to reach a target sum with dice rolls
  - Print all ways to reach a target sum with dice rolls within a roll count limit

---

## How to Use

- Each directory contains Java files with problem statements, explanations, and solutions.
- Start with `recursionBasic` to build a strong foundation, then proceed to more advanced topics.
- Refer to comments and documentation within each file for detailed explanations.

---

## Additional Resources

- [Recursion (Wikipedia)](https://en.wikipedia.org/wiki/Recursion_(computer_science))
- [GeeksforGeeks Recursion](https://www.geeksforgeeks.org/recursion/)
- [Java Recursion Tutorial (Programiz)](https://www.programiz.com/java-programming/recursion)

---
