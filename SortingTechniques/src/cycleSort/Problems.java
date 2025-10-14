package cycleSort;

public class Problems {
	
//	Leetcode 268 -> Find Missing Number from the array which is in the range [0,N].
	
	public static int missingNumber(int[]arr) {
//		int i = 0;
//		while(i < arr.length) {
//			int crtIdx = arr[i];
//			if(arr[i] < arr.length && arr[i] != arr[crtIdx]) {
//				swap(arr,i,crtIdx);
//			}else {
//				i++;
//			}
//		}
//		for(i =0 ;i<arr.length;i++) {
//			if(arr[i] != i)return i;
//		}
//		return arr.length;
		
		
//		Most Optimized approach for this problem.
		int totSum = 0,reqSum = 0;
		for(int i = 0;i<arr.length;i++) {
			totSum += arr[i];
			reqSum += i + 1; // as we are not counting the n itself but for n times so 1*n=n
		}
		return reqSum - totSum;
	}
	

//	 Leetcode 287 -> Find the Duplicate Number
/*	Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
	There is only one repeated number in nums, return this repeated number. */
	
	public static int findDuplicate(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] != i+1) {// if element is not at correct index.
				int crtIdx = arr[i] - 1;
				if(arr[i] == arr[crtIdx]) { // if there is already a same element at the current element's correct index.
					return arr[i];
				}
				swap(arr, i, crtIdx);
			}else {
				i++;				
			}
		}
		return -1;
	}
	
	
	/*
	 * Leetcode 645 -> You have a set of integers s, which originally contains all the numbers from 1 to n. 
	 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
	 * which results in repetition of one number and loss of another number.
	 *
	 *Find the number that occurs twice and the number that is missing and return them in the form of an array.
	 */
	public static int[] findErrorNums(int[] nums) {
		int[] ans = new int[2];
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) { // the number present at the wrong index is the duplicate one and the number which is required to be here is the missing one.
				ans[0] = nums[i];
				ans[1] = i+1;
			}
		}
		return ans;
	}
	
	/*
	 * Leetcode 41 -> First Missing Positive
	 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
	 * */
	 public static int firstMissingPositive(int[] nums) {
		 int i = 0;
		 int n = nums.length;
		 while(i < n){
			 int correctIdx = nums[i] - 1; // CorrectIdx for 4 is 4-1 = 3;
			 int elem = nums[i];
			 // Swap the numbers at the correct positions iff the current element is not at the correct index and there is not any correct element placed at the same index (To avoid infinite loop).
			 if( elem > 0 && elem <= n && elem != i+1 && nums[correctIdx] != elem ){ 
				 swap(nums,i,correctIdx);
			 }else{
				 i++;
			 }
		 }

		 for(i=0;i<nums.length;i++){
			 if(nums[i] != i+1)return i+1;
		 }
		 return nums.length + 1;
	 }
	 
	 
	public static void main(String[] args) {
		int[] arr = {1,4,0,3,5};
		System.out.println(missingNumber(arr));
	}

	
	
	static void swap(int[] arr, int i, int crtIdx) {
		int temp = arr[i];
		arr[i]= arr[crtIdx];
		arr[crtIdx]=temp;
	}

}
