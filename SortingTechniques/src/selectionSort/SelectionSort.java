package selectionSort;

import java.util.Arrays;
import java.util.Iterator;

public class SelectionSort {
	
	public static void selectionSort(int[] arr) {
//		Sorting from left to right in ascending order.
		
//		for (int i = 0; i < arr.length - 1; i++) {
//			int minIdx = i;
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[j] < arr[minIdx]) {
//					minIdx = j;
//				}
//			}
//			// Swapping the smallest element with its corresponding position.
//			int temp = arr[minIdx];
//			arr[minIdx] = arr[i];
//			arr[i] = temp;
//		}
		
		for (int i = 0; i < arr.length; i++) {
			int maxElemIdx = 0;
			for(int j = 0; j< arr.length-i;j++) {
				if(arr[j] > arr[maxElemIdx]) {
					maxElemIdx = j;
				}
			}
			int temp = arr[maxElemIdx];
			arr[maxElemIdx] = arr[arr.length-i-1];
			arr[arr.length - i -1] = temp;
		}
		
//		Sorting from right to left which will also be in ascending order.
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 20, 30, 10, -5, 1, 0, -98, 34, 9, 9, 143, 98, 76, 7, 1, 43, 54};
		
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
