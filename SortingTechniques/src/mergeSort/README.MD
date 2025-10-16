# Merge Sort

Merge sort is a divide-and-conquer sorting algorithm that divides the input array into two halves, recursively sorts each half, and then merges the sorted halves to produce the sorted array. It is stable and works well for large datasets.

## Time Complexity
- Worst, Average, and Best Case: $$O(N \log N)$$

## Space Complexity
- Space: $$O(N)$$ due to the use of temporary arrays for merging

## How it works
1. Divide the array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves into a single sorted array.

## Diagrammatic Representation
![Merge Sort Example](https://upload.wikimedia.org/wikipedia/commons/c/c5/Merge_sort_animation2.gif)

## Properties
- Stable sorting algorithm.
- Not in-place (requires extra space).
- Performs well on large lists.

## Code
You can find the implementation of Merge Sort in Java [here](./MergeSort.java).
