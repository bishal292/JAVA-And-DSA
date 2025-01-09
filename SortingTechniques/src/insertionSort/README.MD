# Insertion Sort

Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

## Time Complexity
- Worst and Average Case: $$O(N^2)$$
- Best Case: $$O(N)$$ when the array is already sorted

## Space Complexity
- Space: $$O(1)$$ as it is an in-place sorting algorithm

## How it works
1. Iterate from the second element to the end of the array.
2. Compare the current element with the previous elements.
3. If the current element is smaller than the previous element, swap them.
4. Repeat the process until the current element is in the correct position.

![Insertion Sort Example](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)

## Code
You can find the implementation of Insertion Sort in Java [here](./InsertionSort.java).
