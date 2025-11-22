# Trees — Concepts & Implementations

Concise reference for tree data structures with links to local implementations.

## Overview
A tree is a hierarchical data structure of nodes with parent-child relationships. Common tree types implemented here:
- Binary Tree — each node has up to two children.
- Binary Search Tree (BST) — binary tree with left < node < right property for ordered storage and fast lookup.
- AVL Tree — a self-balancing BST that maintains O(log n) height by rotations.

## Files (implementations)
- [BinaryTree.java](BinaryTree.java) — generic binary tree creation and display helpers.
- [BinarySearchTree.java](BinarySearchTree.java) — BST insertions, traversal (pre/in/post), height and balance checks.
- [AVLTrees.java](AVLTrees.java) — AVL insertion with rotations, traversal, and height tracking.

## Key operations & complexity
- Search (BST): average O(log n), worst O(n) (unbalanced)
- Insert/Delete (BST): average O(log n), worst O(n)
- Insert/Delete (AVL): O(log n) guaranteed (rotations keep tree balanced)
- Traversals (pre/in/post/level-order): O(n)

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
- Inspect code for examples of insertion, traversal and balancing logic.

## Notes
- Implementations emphasize clarity and are suitable for learning and experiments.
- For production use prefer Java's collections or thoroughly test edge cases (concurrency, nulls, I/O).
