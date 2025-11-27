# Trees — Concepts & Implementations

Concise reference for tree data structures with links to local implementations.

## Overview
A tree is a hierarchical data structure of nodes with parent-child relationships. Common tree types implemented here:
- Binary Tree — each node has up to two children.
- Binary Search Tree (BST) — binary tree with left < node < right property for ordered storage and fast lookup.
- AVL Tree — a self-balancing BST that maintains O(log n) height by rotations.
- Segment Tree — a tree built over an array to answer range queries and updates efficiently.

## Files (implementations)
- [BinaryTree.java](BinaryTree.java) — generic binary tree creation and display helpers.
- [BinarySearchTree.java](BinarySearchTree.java) — BST insertions, traversal (pre/in/post), height and balance checks.
- [AVLTrees.java](AVLTrees.java) — AVL insertion with rotations, traversal, and height tracking.
- [SegmentTree.java](SegmentTree.java) — segment tree for range queries and point updates.

## Key operations & complexity
- Search (BST): average O(log n), worst O(n) (unbalanced)
- Insert/Delete (BST): average O(log n), worst O(n)
- Insert/Delete (AVL): O(log n) guaranteed (rotations keep tree balanced)
- Traversals (pre/in/post/level-order): O(n)
- Segment Tree:
  - Build: O(n)
  - Range query (sum/min/max etc.): O(log n)
  - Point update: O(log n)
  - Space: O(n) (usually ~4n for array-backed implementations)

## Segment Tree — Brief
- Purpose: answer range queries (sum / min / max / gcd ...) and perform updates (point or range) efficiently.
- Build: recursively divide array into halves, store aggregated value at each node.
- Query: if node range is completely inside query range return node value; if outside return neutral value; otherwise combine left/right results.
- Update: update leaf and recompute ancestors.

Visual (segment tree):
![Segment Tree](https://media.geeksforgeeks.org/wp-content/cdn-uploads/segment-tree1.png)

Implementation note
- See [SegmentTree.java](SegmentTree.java) for an array-to-tree recursive implementation with:
  - populate(int[] arr) — build tree
  - getSumInRange(int start, int end) — range sum query
  - update(int index, int value) — point update
- The provided implementation stores start/end indices and aggregates values in Node.data; adapt easily for other operations (min/max) by changing the aggregation.

## Traversals (brief)
- Pre-order: Node -> Left -> Right
- In-order: Left -> Node -> Right (BST yields sorted order)
- Post-order: Left -> Right -> Node

## Balancing (AVL)
- Balance factor = height(left) - height(right)
- If balance factor ∉ {-1,0,1} perform rotations:
  - Left-Left -> right rotation
  - Right-Right -> left rotation
  - Left-Right -> left then right
  - Right-Left -> right then left

## Visuals
Binary tree example:
![Binary Tree](https://upload.wikimedia.org/wikipedia/commons/f/f7/Binary_tree.svg)

BST (in-order yields sorted sequence):
![BST Inorder](https://upload.wikimedia.org/wikipedia/commons/d/da/Binary_search_tree.svg)

AVL rotation illustration:
![AVL Rotations](https://astikanand.github.io/techblogs/advanced-data-structures/assets/avl_insertion_example_2.png)

## Usage
- Compile: javac *.java
- Run demos:
  - BinaryTree has a simple interactive `main` to populate and display.
  - BinarySearchTree and AVLTrees include `main` examples that populate and print traversals.
  - SegmentTree includes a `main` demonstrating populate, range query and update.
- Inspect code for examples of insertion, traversal, balancing and segment operations.

## Notes
- Implementations emphasize clarity and are suitable for learning and experiments.
- For production use prefer well-tested libraries or thoroughly test edge cases (concurrency, nulls, I/O).
