package binarySearch;

import java.util.Arrays;

public class Problems {
	
//	-------------------------------------------------------------------------------------------------------------
	
//	LeetCode: 34 -> Find First and Last Position of Element in Sorted Array
	public static int[] findFirstAndLastPosOfElem(int[] arr,int target) {
//		Run the Binary search two times one for finding start index and another for last index.
		return new int[] {Helper.searchFirstOrLastIndex(arr, target, true),Helper.searchFirstOrLastIndex(arr, target, false)};
	}
	
	
//	-------------------------------------------------------------------------------------------------------------

//	LeetCode: 852 -> Find Peak Index in a Mountain Array.
//	Mountain array means an Array which is ascending in order and after some point it becomes decreasing.
//	Peak Index means the position of the highest element in the array.
//	{0,2,1,0} :-> here array is in ascending order upto index 1 and after 1 it is in decreasing order and 1 is the peak index.
	public static int peakIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {// if start and end will be pointing to an index then it is the peak index.
			int mid = start + (end - start) / 2;
			
			if(arr[mid] > arr[mid+1] ) { // if cuurent mid element is grater than it's right element then it can be the peak index or peak index can be on it's left.
				end = mid;
			}else { // if mid element is less than next element means we are in the ascending part of the array and peak index lies on right side.
				start = mid + 1;
			}
		}
		return start; // start or end both would be pointing to the same element.
	}
	
	
	
//	-------------------------------------------------------------------------------------------------------------

//	LeetCode: 1095 -> Find target element index in a mountain array.
//	Find the element smallest index in a mountain array if it exists else return -1;
	public static int binarySearchInMountainArray(int[] arr,int target) {
		int start = 0;
		int end = arr.length;
//		Finding peak index in the array -> after this loop start and end will be pointing to the peak element;
		while(start < end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] > arr[mid+1]) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		int peakIdx = start;
		if(arr[peakIdx] < target)return -1; // if target is greater than the peak element itself then it doesn't exists in the array.
		
//		Traverse the left sorted array
		start = 0;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(arr[mid] > target) {
				end = mid - 1;
			}else if(arr[mid] < target) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
//		If target doesnot lies in the left side it may exists in right side.
//		Note: it would be sortedd in descending order
		start = peakIdx;
		end = arr.length - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(arr[mid] < target) {
				end = mid - 1;
			}else if(arr[mid] > target) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
//		if element is not found in the right part also then return -1; as element doesn't exists in the array.
		return -1 ;
	}
	
//	-------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
		int[] arr = {5,7,7,8,8,10};
//		For the above array where target is 7: Output must be [1,2] where 1 is start index and 2 is the last index of 7 occurances in arr.
//		Similary for 5:Output will be [0,0] and for 9: [-1,-1]
		System.out.println(Arrays.toString(findFirstAndLastPosOfElem(arr, 8))); // Output: [3,4]
		
		System.out.println( peakIndex(new int[]{0,1,2,5,6,11,9,7,6,4,2,1,0}) ); // Output: 5
		System.out.println( binarySearchInMountainArray(new int[]{0,1,2,5,6,11,9,7,6,4,2,1,0}, 8) ); // Output: 5
	}
}













class Helper{
//	Helper Function to get the first or last occurance of an element in the array based on the what we are trying to search(Either 1st Or last).
	static int searchFirstOrLastIndex(int[] arr,int target, boolean isFindingStart) {
		int ans = -1;
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] > target) {
				end = mid - 1;
			}else if(arr[mid] < target) {
				start = mid + 1;
			}else { // Element is found
				ans = mid;// possible index
				
				if(isFindingStart) {//if finding starting index then search on left else right
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
		}
		
		return ans;
	}
}