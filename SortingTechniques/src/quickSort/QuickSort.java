package quickSort;

import java.util.Arrays;

public class QuickSort {

    /*
     QuickSort implementation (Hoare-style partitioning with middle-element pivot).
     - Divide and conquer: pick a pivot, partition the array so that elements <= pivot are at left
       and elements >= pivot are at right, then recursively sort both the partitions.
     - Pivot choice: middle element (helps reduce worst-case on already sorted input vs. always-last).
     - Partitioning approach: two pointers (start from low, end from high) move inward,
       swapping any out-of-place pair (left >= pivot and right <= pivot).
     - After partition loop finishes, 'end' is the last index of the left partition and
       'start' is the first index of the right partition; recurse on [low..end] and [start..high].
     - Time complexity: average O(n log n), worst-case O(n^2) depending on pivot choices.
    */
    static void quickSort(int[] arr, int low, int high) {

        if (low >= high) return; // base case: zero or one element is already sorted

        int start = low;
        int end = high;
        int mid = low + (end - start) / 2;
        int pivot = arr[mid]; // choose middle element as pivot

        // Partition loop: move pointers inward and swap out-of-place elements
        while (start <= end) {

            // Advance start while values are correctly on the left side (less than pivot)
            while (arr[start] < pivot) {
                start++;
            }
            // Decrease end while values are correctly on the right side (greater than pivot)
            while (arr[end] > pivot) {
                end--;
            }
            // Now arr[start] >= pivot and arr[end] <= pivot (possible inversions).
            // If pointers haven't crossed, swap to place elements on correct sides.
            if (start <= end) {
                swap(arr, start, end);
                // Move pointers past swapped elements to avoid re-checking them.
                start++;
                end--;
            }
        }
        // At this point:
        // - end is the correct index of the pivot element. Means:
        // - All elements at indices <= end are <= pivot
        // - All elements at indices >= start are >= pivot
        // Recurse on the two partitions defined by [low..end] and [start..high].
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,7,24,2,34,65,76,87,0,39,99,123,1,7,9};
        System.out.println(arr.length);
        quickSort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
}
