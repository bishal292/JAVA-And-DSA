# Linear Search Algorithm

Linear search is a simple algorithm that checks every element in a list until the target element is found or the list ends. It is useful for unsorted lists.

## Algorithm
1. Start from the first element and compare it with the target.
2. If the target matches the current element, return the index.
3. If the target does not match, move to the next element and repeat step 2.
4. Continue until the target is found or the list ends.

## Code Example
```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

## Problems Solved

### 1. Find Minimum Element in Array
- **Problem:** Find the minimum element in an array.
- **Solution:** Iterate through the array and keep track of the minimum element.
- **Code:**
```java
public static int findMinimum(int[] arr) {
    int minimum = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] < minimum) {
            minimum = arr[i];
        }
    }
    return minimum;
}
```

### 2. Find Maximum Element in Array
- **Problem:** Find the maximum element in an array.
- **Solution:** Iterate through the array and keep track of the maximum element.
- **Code:**
```java
public static int findMaximum(int[] arr) {
    int maximum = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > maximum) {
            maximum = arr[i];
        }
    }
    return maximum;
}
```

### 3. Search in 2D Array
- **Problem:** Find the position of an element in a 2D array.
- **Solution:** Iterate through each element in the 2D array and return the position if found.
- **Code:**
```java
public static int[] searchIn2DArrays(int[][] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            if (arr[i][j] == target) {
                return new int[]{i, j};
            }
        }
    }
    return new int[]{-1, -1};
}
```

### 4. Find Count of Numbers with Even Number of Digits
- **Problem:** Find the count of numbers in an array that have an even number of digits.
- **Solution:** Iterate through the array and count the numbers with an even number of digits.
- **Code:**
```java
public static int findCountNumberWithEvenDigit(int[] arr) {
    int count = 0;
    for (int num : arr) {
        if (digitCount(Math.abs(num)) % 2 == 0) {
            count++;
        }
    }
    return count;
}

public static int digitCount(int number) {
    int count = 0;
    while (number > 9) {
        number /= 10;
        count++;
    }
    return count + 1;
}
```

### 5. Maximum Subarray ([Kadane's Algorithm](https://leetcode.com/problems/maximum-subarray/))
- **Problem:** Find the maximum sum of a contiguous subarray.
- **Solution:** Use Kadane's Algorithm to find the maximum subarray sum.
- **Intuition and Approach:**
  - Initialize two variables: `sum` to store the current subarray sum and `maxSum` to store the maximum subarray sum.
  - Iterate through the array and update `sum` by adding the current element.
  - If `sum` is greater than `maxSum`, update `maxSum`.
  - If `sum` becomes negative, reset `sum` to 0.
- **Code:**
```java
public static int maxSubArray(int[] nums) {
    int sum = nums[0], maxSum = sum;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum > maxSum) maxSum = sum;
        if (sum < 0) sum = 0;
    }
    return maxSum;
}
```

## External Algorithm: Kadane's Algorithm
Kadane's Algorithm is used to find the maximum sum of a contiguous subarray in an array of integers. It works by iterating through the array and keeping track of the current subarray sum and the maximum subarray sum found so far. If the current subarray sum becomes negative, it is reset to zero, as a negative sum would decrease the overall sum of any subsequent subarray.
