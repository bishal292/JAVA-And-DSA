# Quick Sort

Quick Sort is a divide-and-conquer, comparison-based sorting algorithm. It selects a pivot, partitions the array into elements less than and greater than the pivot, and recursively sorts the partitions. It is widely used due to its good average-case performance and in-place partitioning.

## Time Complexity
- Average Case: $$O(N \log N)$$
- Best Case: $$O(N \log N)$$
- Worst Case: $$O(N^2)$$ (occurs with poor pivot choices, e.g., always picking first/last on sorted input)

## Space Complexity
- Extra Space: $$O(\log N)$$ on average for recursion stack (in-place partitioning)
- Worst-case stack: $$O(N)$$ without optimizations

## Key Properties
- In-place (uses only recursion stack).
- Not stable by default (relative order of equal elements may change).
- Performance depends on pivot selection; randomized or median-of-three pivots reduce chance of worst-case.

## How it works
1. Choose a pivot (common choices: last element, first element, random element, median-of-three).
2. Partition the array so elements <= pivot go left and elements > pivot go right (or variations).
3. Recursively sort left and right partitions.
4. No merge step required — pivot ends in its final place after partitioning.

## Partition Schemes
- Lomuto partition:
  - Simple to implement, uses a single index, may perform more swaps.
- Hoare partition:
  - Often faster (fewer swaps), but requires careful bounds handling.
- Choose pivot strategy (randomized or median-of-three) to improve robustness.

## Optimizations
- Use randomized pivot to avoid adversarial inputs.
- Switch to insertion sort for small subarrays (e.g., size < 10) to reduce overhead.
- Use tail-call elimination or iterative partitioning to reduce recursion depth.
- Use median-of-three pivot to improve partition balance on partially sorted data.

## When to use
- Good general-purpose sort when average performance and low memory usage matter.
- Avoid when stability is required — prefer Merge Sort or a stable algorithm.

## Diagrammatic Representation
![Quick Sort Example](https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif)

## Code
You can find the implementation of Quick Sort in Java [here](./QuickSort.java).
