# Binary Search Algorithm

Binary search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.

## Algorithm
1. Start with the middle element:
   - If the target value is equal to the middle element, the search is complete.
   - If the target value is less than the middle element, repeat the search with the left half of the list.
   - If the target value is greater than the middle element, repeat the search with the right half of the list.
2. Continue until the target value is found or the subarray size becomes zero.

[***CODE***](#binary-search)

## Diagrammatic Representation
![Binary Search](https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Binary_Search_Depiction.svg/320px-Binary_Search_Depiction.svg.png)

## Problems Solved

### 1. Find First and Last Position of Element in Sorted Array ([LeetCode 34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/))
- **Problem:** Given an array of integers `arr` sorted in ascending order, find the starting and ending position of a given target value.
- **Solution:** Use binary search to find the first and last positions separately.
- **Intuition and Approach:**
  - Perform binary search to find the first occurrence of the target.
  - Perform binary search again to find the last occurrence of the target.
  - This ensures that both the first and last positions are found efficiently.

[***CODE***](#find-first-and-last-position-of-element-in-sorted-array)

### 2. Find Peak Index in a Mountain Array ([LeetCode 852](https://leetcode.com/problems/peak-index-in-a-mountain-array/))
- **Problem:** Given a mountain array (an array that increases and then decreases), find the peak index.
- **Solution:** Use binary search to find the peak index by comparing middle elements.
- **Intuition and Approach:**
  - The peak index is the point where the array changes from increasing to decreasing.
  - Use binary search to compare the middle element with its neighbors.
  - If the middle element is greater than the next element, the peak is on the left side.
  - If the middle element is less than the next element, the peak is on the right side.

[***CODE***](#find-peak-index-in-a-mountain-array)

### 3. Find Target Element Index in a Mountain Array ([LeetCode 1095](https://leetcode.com/problems/find-in-mountain-array/))  ([LeetCode 81](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/))
- **Problem:** Given a mountain array and a target value, find the index of the target value.
- **Solution:** First, find the peak index using binary search, then search in the left and right subarrays.
- **Intuition and Approach:**
  - First, find the peak index using the same approach as the previous problem.
  - Perform binary search on the left subarray (which is sorted in ascending order).
  - If the target is not found, perform binary search on the right subarray (which is sorted in descending order).

[***CODE***](#find-target-element-index-in-a-mountain-array)

### 4. Find Pivot in Rotated Sorted Array
- **Problem:** Given a rotated sorted array, find the index of the largest element (pivot).
- **Solution:** Use binary search to find the point where the array changes from increasing to decreasing.
- **Intuition and Approach:**
  - The pivot is the index where `arr[i] > arr[i+1]` or `arr[i] < arr[i-1]`.
  - Use binary search to efficiently locate this point.

[***CODE***](#find-pivot-in-rotated-sorted-array)

### 5. Search in Rotated Sorted Array ([LeetCode 33](https://leetcode.com/problems/search-in-rotated-sorted-array/))
- **Problem:** Given a rotated sorted array and a target value, find the index of the target.
- **Solution:** Use binary search, considering the rotation to decide which half to search.
- **Intuition and Approach:**
  - Determine which part of the array is sorted.
  - Adjust the search boundaries based on the target's relation to the sorted part.

[***CODE***](#search-in-rotated-sorted-array)

### 6. Split Array Largest Sum ([LeetCode 410](https://leetcode.com/problems/split-array-largest-sum/))
- **Problem:** Split an array into `k` non-empty subarrays such that the largest sum among these subarrays is minimized.
- **Solution:** Use binary search on the possible answer range.
- **Intuition and Approach:**
  - The smallest possible largest sum is the max element, and the largest is the sum of all elements.
  - Use binary search to find the minimum largest sum that allows splitting into `k` subarrays.

[***CODE***](#split-array-largest-sum)

## Code Examples

### Binary Search
```java
public static int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (target < arr[mid]) {
            end = mid - 1;
        } else if (target > arr[mid]) {
            start = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```

### Find First and Last Position of Element in Sorted Array
```java
public static int[] findFirstAndLastPosOfElem(int[] arr, int target) {
    return new int[] {Helper.searchFirstOrLastIndex(arr, target, true), Helper.searchFirstOrLastIndex(arr, target, false)};
}
```

### Find Peak Index in a Mountain Array
```java
public static int peakIndex(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] > arr[mid + 1]) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    return start;
}
```

### Find Target Element Index in a Mountain Array
```java
public static int binarySearchInMountainArray(int[] arr, int target) {
    int start = 0;
    int end = arr.length;
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] > arr[mid + 1]) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    int peakIdx = start;
    if (arr[peakIdx] < target) return -1;
    start = 0;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] > target) {
            end = mid - 1;
        } else if (arr[mid] < target) {
            start = mid + 1;
        } else {
            return mid;
        }
    }
    start = peakIdx;
    end = arr.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] < target) {
            end = mid - 1;
        } else if (arr[mid] > target) {
            start = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```

### Find Pivot in Rotated Sorted Array
```java
public static int pivotInRotatedSortedArray(int[] arr) {
    int left = 0;
    int right = arr.length-1;
    while(left < right) {
        int mid = left + (right - left)/2;
        if(arr[mid] > arr[mid+1]) {
            return mid;
        } else if(arr[mid] < arr[mid - 1]) {
            return mid -1;
        } else if(arr[left] < arr[mid]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
```

### Search in Rotated Sorted Array
```java
public static int searchInRotatedSortedArray(int[] nums,int target) {
    int n = nums.length;
    int left =0, right =n-1;
    while(left <= right){
        int mid = left + (right-left)/2;
        if(nums[mid] == target) return mid;
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return -1;
}
```

### Split Array Largest Sum
```java
public static int splitArray(int[] nums, int k) {
    int start = 0;
    int end = 0;
    for(int num : nums){
        start = Math.max(start,num);
        end += num;
    }
    while(start < end){
        int mid = start + (end - start)/2;
        int pieces = 1;
        int sum = 0;
        for(int num : nums){
            if(sum + num > mid){
                pieces++;
                sum = num;
            }else{
                sum += num;
            }
            if(pieces > k){
                start = mid + 1;
                break;
            }
        }
        if(pieces <= k){
            end = mid;
        }
    }
    return end;
}
```
