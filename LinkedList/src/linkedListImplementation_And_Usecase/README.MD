# Linked List — Implementation & Use Cases

This folder contains educational implementations and demos for common linked-list variants used in data-structures practice.

Files
- CustomSinglyLinkedList.java — singly linked list (add, addFirst, insert, removeFirst, removeLast, getFirst, getLast, size, toString)
- CustomDoublyLinkedList.java — doubly linked list (prev/next pointers, reverse traversal)
- CircularLinkedList.java — circular singly linked list (tail.next -> head)
- Main.java — demo usage for all lists

Overview
- Linked lists store elements in nodes with references (pointers) between nodes.
- They provide O(1) insert/delete at ends (when tail/head pointers are maintained) and O(n) indexed access.
- They are preferred when frequent insertions/deletions are required and contiguous memory is not desired.

## Diagrams
- Singly linked list  
    ![Singly-Linked-List](https://media.geeksforgeeks.org/wp-content/uploads/singly-linkedlist.png)
- Doubly linked list  
    ![Doubly-Linked-List](https://scaler.com/topics/images/new-node-addition-back.webp)
- Circular linked list  
    ![Circular-Linked-List](https://media.geeksforgeeks.org/wp-content/uploads/20240402130347/circular-linked-list-copy.webp)

## Types, explanation and use-cases

### 1) Singly Linked List
- Node structure: value, next
- Use when you need simple sequential lists and O(1) head insert/delete.
- Typical operations:
  - add (tail) — O(1) with tail pointer; O(n) otherwise
  - addFirst (head) — O(1)
  - insert at index — O(n)
  - removeFirst — O(1)
  - removeLast — O(n) (unless you maintain a prev pointer)
  - getFirst/getLast — O(1)
- Implementation: CustomSinglyLinkedList.java

### 2) Doubly Linked List
- Node structure: prev, value, next
- Adds backward traversal and O(1) removal of tail when tail is maintained.
- Typical operations:
  - add (tail) — O(1)
  - addFirst — O(1)
  - insert at index — O(n)
  - removeFirst/removeLast — O(1) (tail.prev helps)
  - display in reverse — O(n) using prev pointers
- Use when bidirectional traversal or frequent removals from both ends are required.
- Implementation: CustomDoublyLinkedList.java

### 3) Circular Linked List (singly circular)
- Node structure: value, next; tail.next points to head
- Useful for round-robin scheduling, continuous iteration, or when you want to loop the list.
- Typical operations:
  - add (tail) — O(1) (update tail.next -> head)
  - addFirst — O(1) (adjust head and tail.next)
  - removeFirst/removeLast — O(1) / O(n) similar to singly
  - traversal must stop when node == head again (watch termination)
- Implementation: CircularLinkedList.java

## Operations & Time Complexity (typical)

| Operation             | Singly | Doubly | Circular |
|----------------------:|:------:|:------:|:--------:|
| Access by index       | O(n)   | O(n)   | O(n)     |
| Search by value       | O(n)   | O(n)   | O(n)     |
| Insert at head        | O(1)   | O(1)   | O(1)     |
| Insert at tail        | O(1)*  | O(1)   | O(1)     |
| Insert at middle      | O(n)   | O(n)   | O(n)     |
| Remove head           | O(1)   | O(1)   | O(1)     |
| Remove tail           | O(n)   | O(1)   | O(n)     |

\* O(1) only if tail pointer maintained; otherwise O(n).

#### Usage & Examples
- Compile and run Main.java to see demonstrations for each list.
- The demo shows add, insert, remove, and special behaviors (reverse display, circular wrap-around).

Implementation notes & tips
- Maintain both head and tail to get O(1) inserts at both ends.
- Be careful with null checks (empty list) and with tail.next in circular lists to avoid infinite loops.
- The provided implementations are educational and focus on clarity and is non-generic(Not for all data types rather than int); Java's built-in `LinkedList<E>` (doubly-linked) is recommended for production use.
