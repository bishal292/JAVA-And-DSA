# Cycle Sort

Cycle sort is an in-place, unstable sorting algorithm that is optimal in terms of the number of writes to the array. It is based on the idea that the permutation to be sorted can be factored into cycles, which can individually be rotated to give a sorted result.

## Time Complexity
- Worst and Average Case: $$O(N^2)$$
- Best Case: $$O(N)$$ when most elements are already in correct positions

## Space Complexity
- Space: $$O(1)$$ as it is an in-place sorting algorithm

## Key Properties
- Unstable sorting algorithm.
- Minimizes number of writes: each element is written exactly once to its final position (except already-correct elements).
- Useful when write operations are expensive (e.g., EEPROM/flash memory).

## How it works (detailed)
1. For each index i, compute the correct position by counting how many elements are smaller than arr[i].
2. If arr[i] is already at its correct position, move to the next index.
3. Otherwise, place arr[i] into its correct position (swap/write), and continue rotating the cycle:
   - While the displaced element is not in its correct position, place it into its correct position.
4. Handle duplicates by skipping positions where the value is equal to the current element.

## Handling Duplicates
- When finding the correct position, skip positions with the same value to avoid infinite loops.
- Continue rotating until the cycle closes.

## When to use
- Prefer Cycle Sort when minimizing the total number of writes is more important than comparisons or runtime.

![Cycle Sort Example](https://upload.wikimedia.org/wikipedia/commons/e/ef/Sorting_cycle_sort_anim.gif)

## Problems Solved

### 1. Missing Number ([LeetCode 268](https://leetcode.com/problems/missing-number/))
- Problem: Given an array containing n distinct numbers taken from the range [0, n], find the one number missing from the array.
- Solution: Cycle sort approach places each number at its index (value i to index i), then scans for the first mismatch; alternatively use arithmetic sum difference.
- Intuition and Approach:
  - For each element, compute its correct index and swap until the current index has the correct value.
  - The index where `arr[i] != i` is the missing number; if all match, the missing number is n.
- CODE: See Problems.java -> missingNumber

### 2. Find the Duplicate Number ([LeetCode 287](https://leetcode.com/problems/find-the-duplicate-number/))
- Problem: Array of size n+1 with numbers in [1, n] containing exactly one duplicate; return the duplicate.
- Solution: Cycle sort style: place each value v at index v-1; when a value’s correct spot already holds the same value, that value is the duplicate.
- Intuition and Approach:
  - While `nums[i] != i+1`, swap to place it at `i = nums[i]-1`.
  - If the correct index already has the same number, return it.
- CODE: See Problems.java -> findDuplicate

### 3. Set Mismatch ([LeetCode 645](https://leetcode.com/problems/set-mismatch/))
- Problem: Original set is [1..n] but due to an error one number is duplicated and another is missing; return [duplicate, missing].
- Solution: Use cycle sort to position values; after placement, the index where `nums[i] != i+1` gives duplicate `nums[i]` and missing `i+1`.
- Intuition and Approach:
  - Swap each value to its correct index `v-1` if not already present.
  - Scan to find the index with a mismatch; that reveals both numbers.
- CODE: See Problems.java -> findErrorNums

### 4. First Missing Positive ([LeetCode 41](https://leetcode.com/problems/first-missing-positive/))
- Problem: Given an unsorted integer array `nums`, return the smallest positive integer that is missing.
- Solution: Place each positive value `v` (1 ≤ v ≤ n) at index `v-1` using cycle sort swaps; scan for first index where `nums[i] != i+1`.
- Intuition and Approach:
  - Ignore non-positive and out-of-range numbers.
  - While `nums[i]` is in range and not at the correct index and the correct position doesn’t already contain the same value, swap it into place.
  - After placement, the first index `i` where `nums[i] != i+1` gives the answer `i+1`; if all match, answer is `n+1`.
- CODE: See Problems.java -> firstMissingPositive

## Code
You can find the implementation of Cycle Sort in Java [here](./CycleSort.java) and problem solutions [here](./Problems.java).

## Advantages
- Minimal writes to the array.
- In-place and memory-efficient.

## Disadvantages
- Comparisons are $$O(N^2)$$ in average/worst cases.
- Unstable; equal elements may change relative order.
