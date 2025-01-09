# Selection Sort

Selection sort is a simple sorting algorithm that divides the input list into two parts: the sublist of items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.

## Time Complexity
- Worst, Average, and Best Case: $$O(N^2)$$

## Space Complexity
- Space: $$O(1)$$ as it is an in-place sorting algorithm

## How it works
1. Find the minimum element in the unsorted array.
2. Swap it with the element at the beginning of the unsorted array.
3. Move the boundary of the sorted and unsorted sublists one element to the right.
4. Repeat the process for the remaining elements until the entire array is sorted.

![Selection Sort Example](https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif)

## How it works (Sorting from Right)
1. Find the maximum element in the unsorted array.
2. Swap it with the element at the end of the unsorted array.
3. Move the boundary of the sorted and unsorted sublists one element to the left.
4. Repeat the process for the remaining elements until the entire array is sorted.



## Code
You can find the implementation of Selection Sort in Java [here](./SelectionSort.java).

