# Heap (Min-Heap / Max-Heap)

A **Heap** is a specialized tree-based data structure commonly implemented using an **array**. It is a **Complete Binary Tree** (all levels filled, except possibly the last, filled left-to-right) with an additional **heap-order property** that makes the “most important” element accessible in **O(1)** time.

## Why heaps are used
Heaps are used when you repeatedly need:
- fast access to the **minimum** element (Min-Heap) or **maximum** element (Max-Heap),
- and fast updates while elements are continuously inserted/removed.

Typical use-cases:
- **Priority Queue** (schedulers, job queues)
- **Top-K** problems (keep K largest/smallest)
- **Graph algorithms** (Dijkstra, Prim) via priority queues
- **Heap Sort** (build heap + repeated delete)

## Heap types
### Min-Heap
- Root contains the **smallest** value.
- For every node: `parent <= children`.

### Max-Heap
- Root contains the **largest** value.
- For every node: `parent >= children`.

> This project provides both: `MinHeap` and `MaxHeap`.

## Array representation (how it “functions” internally)
Although conceptually a tree, heaps are usually stored in an array/list to avoid pointers.

For an element at index `i`:
- `parent(i) = (i - 1) / 2`
- `left(i)   = 2*i + 1`
- `right(i)  = 2*i + 2`

This mapping works because the tree is **complete**.

## Core operations and how they work

### 1) peek()
Returns the root element (min in Min-Heap, max in Max-Heap).
- Time: **O(1)**
- Reason: root is always at index `0`.

### 2) insert(value) — “Sift Up” / “Bubble Up”
Goal: add a new value while keeping the heap property.

Steps:
1. Append `value` to the end of the array (next available spot in complete tree).
2. While heap property is violated with its parent:
   - swap the element with its parent
   - move the index upward and continue

Min-Heap condition (bubble up while): `parent > child`  
Max-Heap condition (bubble up while): `parent < child`

- Time: **O(log N)** (height of the tree)

### 3) pop() (delete root) — “Sift Down” / “Heapify Down”
Goal: remove the root while keeping the heap property.

Common approach (matches your code):
1. Save the root value (this is the answer).
2. Move last element to the root (index `0`) and remove the last slot.
3. Restore heap property by pushing the new root down:
   - compare with children
   - swap with the correct child (smaller child for Min-Heap, larger child for Max-Heap)
   - continue until property holds

Min-Heap: swap with **smallest** child when `node > child`  
Max-Heap: swap with **largest** child when `node < child`

- Time: **O(log N)**

## Complexity summary
- peek(): **O(1)**
- insert(): **O(log N)**
- pop(): **O(log N)**
- space: **O(N)** (stores N elements)

## Relationship to Heap Sort (high-level)
- Build a **Max-Heap** over the array.
- Repeatedly swap root with last element and heapify the reduced heap.
- Produces ascending order in-place.

(See your separate `heapSort` package for the full sorting version.)
