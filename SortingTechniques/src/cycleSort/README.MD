# Cycle Sort

Cycle sort is an in-place, unstable sorting algorithm that is optimal in terms of the number of writes to the array. It is based on the idea that the permutation to be sorted can be factored into cycles, which can individually be rotated to give a sorted result.

## Time Complexity
- Worst, Average, and Best Case: $$O(N)$$

## Space Complexity
- Space: $$O(1)$$ as it is an in-place sorting algorithm

## How it works
1. For each cycle in the array, find the correct position of the element.
2. If the element is already in the correct position, move to the next element.
3. Otherwise, put the element in its correct position and rotate the rest of the cycle.
4. Repeat the process for all cycles in the array.

![Cycle Sort Example](https://upload.wikimedia.org/wikipedia/commons/4/4c/Sorting_cycle_sort_anim.gif)

## Code
You can find the implementation of Cycle Sort in Java [here](./CycleSort.java).
