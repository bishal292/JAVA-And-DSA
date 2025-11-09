# Stack, Queue, and Deque — Custom Implementations

This folder contains concise Java implementations of classic linear data structures: Stack, Queue, Deque, and their dynamic/circular variants.

---

## Stack

A Stack is a LIFO (Last-In, First-Out) structure.  
- **Push:** Add to top  
- **Pop:** Remove from top  
- **Peek:** View top element

**Files:**
- `CustomStack.java` — Basic stack
- `DynamicCustomStack.java` — Stack with dynamic resizing

---

## Queue

A Queue is a FIFO (First-In, First-Out) structure.  
- **Add/Offer:** Insert at rear  
- **Remove/Poll:** Remove from front  
- **Peek:** View front element


**Files:**
- `CustomQueue.java` — Basic queue
- `DynamicCustomQueue.java` — Queue with dynamic resizing
- `CircularQueue.java` — Circular buffer queue
- `DynamicCircularQueue.java` — Circular queue with dynamic resizing

---

## Deque

A Deque (Double-Ended Queue) allows insertion and removal from both ends.  
- **AddFirst/AddLast:** Insert at front/rear  
- **RemoveFirst/RemoveLast:** Remove from front/rear

*Java's built-in `ArrayDeque` is used for demonstration in `Main.java`.*

---

## Usage

- See `Main.java` for example usage and demos of each structure.
- All implementations provide basic methods for adding, removing, and inspecting elements.

---

## Visualization

- Stack: Items are added/removed from one end.
- Queue: Items are added at rear, removed from front.
- Circular Queue: Rear/front wrap around for efficient space use.
- Deque: Items can be added/removed from both ends.

---

## Files Overview

- `CustomStack.java`, `DynamicCustomStack.java`
- `CustomQueue.java`, `DynamicCustomQueue.java`
- `CircularQueue.java`, `DynamicCircularQueue.java`
- `Main.java` — Demo runner

---
