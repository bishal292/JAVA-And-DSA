package mergeSort;

import java.util.Arrays;

public class MergeSort {


//  This is the code for merge sort algorithm which will return a new sorted array and original array will remain unchanged.
	static int[] mergeSort(int[] arr){
		if(arr.length == 1) {
			return arr;
		}
		int mid = arr.length/2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid , arr.length));

		return merge(left,right);
	}
//	Function to merge 2 dufferent arrays and returns new array in sorted manner.
	static int[] merge(int[] left, int[] right) {
		int[] merged = new int[left.length + right.length];
		int i=0, j=0, k=0;
		while(i<left.length && j<right.length) {
			if(left[i] <= right[j]) {
				merged[k++] = left[i++];
			}else {
				merged[k++] = right[j++];
			}
		}
		while(i<left.length) {
			merged[k++] = left[i++];
		}
		while(j<right.length) {
			merged[k++] = right[j++];
		}
		return merged;
	}

//	This is also a function of mergesort but this will sort the array in-place, instead of returning the new array
	static void mergeSortInPlace(int[] arr, int s, int e) {
		if(e-s == 1) {
			return;
		}
		int mid = (s+e)/2;
		
		mergeSortInPlace(arr, s, mid);
		mergeSortInPlace(arr, mid, e);
		
		mergeInPlace(arr, s, mid, e);
	}
	
	private static void mergeInPlace(int[] arr, int s, int mid, int e) {
//		Creating 2 different arrays keeping the mid as divider.
		
//		int[] left = Arrays.copyOfRange(arr, s, mid);
//		int[] right = Arrays.copyOfRange(arr, mid, e);
//		int i = 0, j = 0, k = s;
//		while(i < left.length && j < right.length) {
//			if(left[i] <= right[j]) {
//				arr[k++] = left[i++];
//			}else {
//				arr[k++] = right[j++];
//			}
//		}
//		while(i < left.length) {
//			arr[k++] = left[i++];
//		}
//		while(j < right.length) {
//			arr[k++] = right[j++];
//		}
		
//		Creating a single array which stores the elements in sorted order.
		int[] sorted = new int[e-s];
		int i = s , j = mid , k = 0;
		
		while(i < mid && j < e) {
			if(arr[i] < arr[j]) {
				sorted[k] = arr[i];
				i++;
			}else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i < mid) {
			sorted[k++] = arr[i++];
		}
		while(j < e) {
			sorted[k++] = arr[j++];
		}
		
		for(i=0;i<sorted.length;i++) {
			arr[i + s] =sorted[i];
		}
		
	}

	public static void main(String[] args) {
		int[] arr = {38, 27, 43, 3, 9, 82, 10};
		int[] sortedArr = mergeSort(arr);
		System.out.println(Arrays.toString(sortedArr));
		System.out.println(Arrays.toString(arr)); // original array remains unchanged
		mergeSortInPlace(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr)); // original array is now sorted
	}
}
