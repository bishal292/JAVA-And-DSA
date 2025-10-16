package recursionArray;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionOnArray {
//	Recursive approach to check wether an array is sorted or not.
	public static boolean isSorted(int[] arr,int index) {
		if(index == arr.length - 1)return true;
		return arr[index] <= arr[index + 1] && isSorted(arr, index+1);
	}
	
//	Linear search using Recursion.
	static int linearSearch(int[] arr,int target,int index) {
		if(index >= arr.length)return -1;
		
		if(arr[index] == target)return index;
		
		return linearSearch(arr, target, index + 1);
	}
	
//	Linear Search for multiple Occurance
	static ArrayList<Integer> res = new ArrayList<>();
	static ArrayList<Integer> linearSearchMulOcc(int[] arr,int target,int index) {
		if(index >= arr.length)return res;
		if(arr[index] == target)res.add(index);
		return linearSearchMulOcc(arr, target, index+1);
	}
	
//	Linear Search for multiple Occurance
	static ArrayList<Integer> LinearSearchMulOcc2(int[] arr,int target,ArrayList<Integer> list,int index){
		if(index >= arr.length)return list;
		if(arr[index] == target)list.add(index);
		return LinearSearchMulOcc2(arr, target, list, index+1);
	}
//	Returning an arraylist without passing it in the function arguments and whitout using the outerscope variable(Object).
	static ArrayList<Integer> LinearSearchMulOcc3(int[] arr,int target,int index){
		ArrayList<Integer> list = new ArrayList<>();
		if(index >= arr.length)return list;
		if(arr[index] == target)list.add(index);
		ArrayList<Integer> listFromBeloCalls = LinearSearchMulOcc3(arr, target, index + 1);
		list.addAll(listFromBeloCalls);
		return list;
	}

	
//	-----------------------------------------------------------------------------------------------
//								Binary Search
//	-----------------------------------------------------------------------------------------------
	
//	Recursive Approach for Binary Search	
	public static int binarySearch(int[] arr,int target,int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if(arr[mid] == target) {
			return mid;
		}
		if(target < arr[mid]) {
			return binarySearch(arr, target, start, mid-1);
		}
		return binarySearch(arr, target, mid + 1, end);
	}
	
//	-----------------------------------------------------------------------------------------------
//								Rotated Binary Search
//	-----------------------------------------------------------------------------------------------
	static int search(int[] arr,int target,int start,int end) {
		if(start > end)return -1; // element not found
		int mid = start + (end - start) / 2;
		if(arr[mid] == target)return mid; // element found.
		if(arr[start] <= arr[mid]) { // if array is sorted till mid and not rotated
			if(target >= arr[start] && target < arr[mid]) { // if the targer element lies between the range of start and mid element.
				return search(arr, target, start, mid - 1);
			}else { // if target elem doesn't lies between s to mid then search in other half
				return search(arr, target, mid + 1, end);
			}
		}
		if(target > arr[mid] && target <= arr[end]) { // if the rotated part is in the left side of mid and the element is less than the end and greater than the mid.
			return search(arr, target, mid + 1, end);
		}
		return search(arr, target, start, mid - 1);
	}
	
//	------------------------------------------------------------------------------------------------------------
//								Bubble Sort	
//	------------------------------------------------------------------------------------------------------------
	static void bubble(int[] arr,int r,int c) {
		if (r == 0)return;
		if(c < r) {
			if(arr[c] > arr[c+1]) {
				int temp = arr[c];
				arr[c] = arr[c+1];
				arr[c+1] = temp;
			}
			bubble(arr,r,c+1);
		}else {
			bubble(arr,r -1 , 0);
		}
	}
//	------------------------------------------------------------------------------------------------------------
//								Selection Sort	
//	------------------------------------------------------------------------------------------------------------
	static void selection(int[] arr,int r,int c,int max) {
		if (r == 0)return;
		if(c < r) {
			if(arr[c] > arr[max]) {
				selection(arr,r,c+1,c);
			}else {
				selection(arr,r,c+1,max);				
			}
		}else {
			int temp = arr[max];
			arr[max] = arr[r-1];
			arr[r-1] = temp;
			selection(arr,r-1,0,0);
		}
	}

	public static void main(String[] args) {
		int [] arr = {1,3,4,5,5,6,5,3,1,6,2,5,8,10,15};
		System.out.println(isSorted(arr, 0)); // true
		System.out.println(linearSearch(arr, 8, 0));
		linearSearchMulOcc(arr, 5, 0);
		System.out.println(res);
		System.out.println(LinearSearchMulOcc2(arr, 5, new ArrayList<Integer>(), 0));
		

		int arr2[] = {1,4,5,6,7,8,11,14,15,18,57,59,60,67,78,89,90,91,93,95,101};
		
		System.out.println(binarySearch(arr2, 57, 0, arr.length - 1)); // Output: 10
		int[] rotArr = {5,6,7,8,9,0,1,2,4,4,5};
//						0 1 2 3 4 5 6 7 8 9 10
		System.out.println(search(rotArr, 2, 0, rotArr.length - 1)); // 7
//		bubble(arr, arr.length - 1, 0);
		selection(arr, arr.length - 1, 0, 0);
		System.out.println(Arrays.toString(arr));
	}
}
