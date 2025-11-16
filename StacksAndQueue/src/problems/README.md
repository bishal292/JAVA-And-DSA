# Problems — Stack & Related Algorithms

This folder contains implementations of common stack/parentheses problems and related algorithms.

Files
- [Problems.java](./Problems.java) — implementations for the problems listed below.

Problems solved
- Valid Parentheses — isValid
  - [LeetCode: 20](https://leetcode.com/problems/valid-parentheses/)
  - Intuition: use a stack (or array as stack) to push opening brackets and verify matching closing brackets; empty stack at end => valid.
  - Implementation: ./Problems.java

- Minimum Add to Make Parentheses Valid — minAddToMakeValid
  - [LeetCode: 921](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)
  - Intuition: track unmatched opens and required opens for unmatched closes in one pass; sum gives required insertions.
  - Implementation: ./Problems.java

- Minimum Insertions to Balance a Parentheses String — minInsertions
  - [LeetCode: 1541](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)
  - Intuition: treat "'))'" as a single close; scan and maintain open count, adding inserts when closings are missing or unmatched.
  - Implementation: ./Problems.java

- Largest Rectangle in Histogram — largestRectangleArea
  - [LeetCode: 84](https://leetcode.com/problems/largest-rectangle-in-histogram/)
  - Intuition: use a monotonic stack of indices to find next/previous smaller bars; compute max area using heights and widths.
  - Implementation: ./Problems.java

Usage
- Compile: javac Problems.java
- Run examples (if any) via the project's Main/demo runner or add small tests that call these static methods.

Notes
- Implementations prioritize clarity and efficient patterns (stack/array-as-stack, one-pass scans).
- See Problems.java for helper utilities and fuller comments.
