package bubbleSort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Sorts the given array using the bubble sort algorithm.
     * 
     * Bubble sort is a simple sorting algorithm that repeatedly steps through the list,
     * compares adjacent elements and swaps them if they are in the wrong order. The pass
     * through the list is repeated until the list is sorted. The algorithm gets its name
     * because smaller elements "bubble" to the top of the list.
     * 
     * Time Complexity: O(n^2) in the worst and average case, where n is the number of elements.
     * Space Complexity: O(1) as it is an in-place sorting algorithm.
     * 
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSwapped = true;
                    arr[j] += arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] -= arr[j+1];
                }
            }
            if(!isSwapped)break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,20,20,30,10,-5 , 1, 0, -98,34,9, 9,143, 98, 76, 7, 1,43,54};
        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
