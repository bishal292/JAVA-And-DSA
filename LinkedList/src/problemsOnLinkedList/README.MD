# Linked List — Algorithms & Problems

Educational Java implementations for classic singly-linked list problems.  
Each problem includes a concise description, intuition, and approach with a link to its implementation.

---

## Files
- [ListNode.java](./ListNode.java): Node structure and helper methods.
- [Problems.java](./Problems.java): Core linked list algorithms.
- [Problems2.java](./Problems2.java): Advanced algorithms and variations.
- [Main.java](./Main.java): Entry point and demo runner.

---

## Problems Solved

### Problems.java

#### 1. Delete Duplicates from Sorted List ([LeetCode 83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/))
- **Problem:** Remove all nodes that have duplicate numbers from a sorted linked list.
- **Intuition and Approach:**
  - Use a dummy node to handle edge cases.
  - Traverse while skipping nodes with equal values to remove duplicates in-place.

[***CODE***](./Problems.java)

#### 2. Merge Two Sorted Lists ([LeetCode 21](https://leetcode.com/problems/merge-two-sorted-lists/))
- **Problem:** Merge two sorted linked lists into one sorted list.
- **Intuition and Approach:**
  - Use two pointers and a dummy head.
  - Continuously attach the smaller node until one list is exhausted. 

[***CODE***](./Problems.java)

#### 3. Detect Cycle ([LeetCode 141](https://leetcode.com/problems/linked-list-cycle/))
- **Problem:** Determine if a linked list contains a cycle.
- **Intuition and Approach:**
  - Use Floyd’s Cycle Detection (fast and slow pointers).
  - If both pointers meet, a cycle exists.  

[***CODE***](./Problems.java)

#### 4. Detect Cycle Start ([LeetCode 142](https://leetcode.com/problems/linked-list-cycle-ii/))
- **Problem:** Find the node where the cycle begins in a linked list.
- **Intuition and Approach:**
  - After fast and slow pointers meet, reset one to head.
  - Move both one step at a time — the meeting point is the cycle start. 

[***CODE***](./Problems.java)

#### 5. Cycle Length
- **Problem:** Find the length of a detected cycle in a linked list.
- **Intuition and Approach:**
  - After detecting a cycle, move one pointer around the loop until it meets again.
  - Count the number of steps taken.  

[***CODE***](./Problems.java)

#### 6. Happy Number ([LeetCode 202](https://leetcode.com/problems/happy-number/))
- **Problem:** Determine if a number becomes 1 when replaced by the sum of squares of its digits repeatedly.
- **Intuition and Approach:**
  - Apply Floyd’s algorithm to detect cycles in the digit-square-sum sequence.
  - If 1 is reached, it’s a happy number.  

[***CODE***](./Problems.java)

#### 7. Middle Node ([LeetCode 876](https://leetcode.com/problems/middle-of-the-linked-list/))
- **Problem:** Return the middle node of a linked list.
- **Intuition and Approach:**
  - Use slow and fast pointers; move fast by two and slow by one.
  - When fast reaches the end, slow is at the middle.  

[***CODE***](./Problems.java)

---

### Problems2.java

#### 8. Reverse List (Iterative/Recursive) ([LeetCode 206](https://leetcode.com/problems/reverse-linked-list/))
- **Problem:** Reverse a singly linked list.
- **Intuition and Approach:**
  - Iterative: Rewire the next pointers in a single pass.
  - Recursive: Reverse during the unwind phase of recursion.  

[***CODE***](./Problems2.java)

#### 9. Reverse Sublist (Between Left & Right) ([LeetCode 92](https://leetcode.com/problems/reverse-linked-list-ii/))
- **Problem:** Reverse a portion of the list between given positions.
- **Intuition and Approach:**
  - Traverse to `left` position.
  - Reverse nodes until `right`, then reconnect the sublist.  

[***CODE***](./Problems2.java)

#### 10. Reverse Nodes in K-Group ([LeetCode 25](https://leetcode.com/problems/reverse-nodes-in-k-group/))
- **Problem:** Reverse nodes of the list in groups of `k`.
- **Intuition and Approach:**
  - Check if `k` nodes exist, reverse them, then recursively process the rest.
  - Connect the reversed blocks properly.  

[***CODE***](./Problems2.java)

#### 11. Reverse Alternate K-Groups
- **Problem:** Reverse every alternate block of `k` nodes.
- **Intuition and Approach:**
  - Alternate between reversing and skipping `k`-sized groups.
  - Maintain proper linkage between segments.  

[***CODE***](./Problems2.java)

#### 12. Sort List (Merge Sort) ([LeetCode 148](https://leetcode.com/problems/sort-list/))
- **Problem:** Sort a linked list in O(n log n) time using constant space.
- **Intuition and Approach:**
  - Split the list at midpoint.
  - Recursively sort both halves, then merge them.

[***CODE***](./Problems2.java)

#### 13. Bubble Sort & Swap Nodes
- **Problem:** Sort the linked list using bubble sort by swapping node pointers.
- **Intuition and Approach:**
  - Perform nested traversal comparing adjacent nodes.
  - Swap links if they are in the wrong order.  
  
[***CODE***](./Problems2.java)

---
