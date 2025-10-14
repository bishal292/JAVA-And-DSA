# Bubble Sort

Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted. The algorithm gets its name because smaller elements "bubble" to the top of the list.

## Time Complexity
- Worst, Average, and Best Case: $$O(N^2)$$
  - Best Case: $$O(N)$$ when the array is already sorted

## Space Complexity
- Space: $$O(1)$$ as it is an in-place sorting algorithm

## How it works
1. Compare the first two elements of the array.
2. If the first element is greater than the second, swap them.
3. Move to the next pair of elements and repeat the process until the end of the array.
4. Repeat the entire process for the remaining elements until the array is sorted.
5. With each pass, the largest unsorted element moves to its correct position at the end.

## Optimized Bubble Sort
- If no swaps are made during a pass, the array is already sorted and the algorithm can terminate early.

## Diagrammatic Representation
![Bubble Sort Example](https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif)

## Code
You can find the implementation of Bubble Sort in Java [here](./BubbleSort.java).
