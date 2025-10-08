package binarySearch;

public class BinarySearch {
//	It is the efficient Searching algorithm used to sarch an element in a sorted array.
//	In worst it's time complexity can be O(log N) i.e. when the req, element doesn't exists in the array.
//	Binary search to return the index of an element if exists else -1.
	
	public static int binarySearch(int[] arr,int target) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = start +(end - start)/2;
			
			if(target < arr[mid]) { // mid element is greater than the target element means element lies on left
				end = mid - 1;
			}else if(target > arr[mid]) { // mid element is greater than the target element means element lies on Right
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
	
//	if target element is not found then return the index of the smallest number which is greater than target element.
	
	public static int ceilingNumber(int[] arr,int target) {
		int start = 0;
		int end = arr.length-1;
		
		if(target > arr[end]) { // If the target element is the largest number itself and there is no any greater element in the array.
			return -1;
		}
		
		while(start <= end) {
			int mid = start +(end - start)/2;
			
			if(target < arr[mid]) { // mid element is greater than the target element means element lies on left
				end = mid - 1;
			}else if(target > arr[mid]) { // mid element is greater than the target element means element lies on Right
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
		return start;
	}
	
	//	if target element is not found then return the index of the smallest number which is greater than target element.
	
	public static int floorNumber(int[] arr,int target) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = start +(end - start)/2;
			
			if(target < arr[mid]) { // mid element is greater than the target element means element lies on left
				end = mid - 1;
			}else if(target > arr[mid]) { // mid element is greater than the target element means element lies on Right
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
		return end;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {2,3,5,9,14,16,18};
		
		System.out.println(binarySearch(arr, 14)); // OutPut: 4
		System.out.println(ceilingNumber(arr, 19)); // Output: 5
		System.out.println(floorNumber(arr, 15)); // Output: 4
	}
}
