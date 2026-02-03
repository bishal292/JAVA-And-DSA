# Heap Sort

Heap Sort is a comparison-based sorting algorithm that uses a Binary Heap (typically a **max-heap**) to sort elements. It works by first building a heap from the input array, then repeatedly extracting the maximum element (root of the heap) and placing it at the end of the array.

## Time Complexity
- Best Case: $$O(N \log N)$$
- Average Case: $$O(N \log N)$$
- Worst Case: $$O(N \log N)$$

> Heap Sort guarantees $$O(N \log N)$$ time regardless of input order.

## Space Complexity
- Extra Space: $$O(1)$$ (in-place, aside from a few variables)
- Recursion stack: $$O(\log N)$$ if heapify is implemented recursively (iterative heapify can make it strictly $$O(1)$$ extra space)

## Key Properties
- In-place (sorts within the array).
- Not stable by default (equal elements may change relative order).
- Predictable performance: always $$O(N \log N)$$.
- Based on heap operations: build-heap + repeated heapify after extraction.

## How it works
1. **Build a max-heap** from the array (largest element becomes the root).
2. **Swap** the root (max element) with the last element in the heap range.
3. Reduce the heap size by 1 (the last element is now in correct final position).
4. **Heapify** the root to restore the max-heap property.
5. Repeat steps 2–4 until the heap size becomes 1.

## Heapify (Sift-Down)
- Heapify assumes subtrees are already heaps and fixes the heap property at a given index.
- For a max-heap, it pushes the value down until:
  - it is >= its children, or
  - it reaches a leaf.

## Optimizations / Notes
- Use **iterative heapify** to avoid recursion overhead and stack usage.
- Building the heap takes $$O(N)$$ (not $$O(N \log N)$$) due to bottom-up heap construction.
- Heap Sort has worse cache locality than Quick Sort in practice, so it can be slower despite the same asymptotic bound.

## When to use
- When you need **guaranteed** $$O(N \log N)$$ performance.
- When **extra memory must be minimal**.
- Avoid when **stability** is required (prefer stable sorts like Merge Sort).

## Diagrammatic Representation
![Heap Sort Example](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

## Code
You can find the implementation of Heap Sort in Java [here](./HeapSort.java).
