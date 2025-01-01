package linearSearch;

import java.util.Arrays;

public class Problems {
//	Return the minimum elements from the array.
	public static int findMinimum(int[] arr) {
		int minimum = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < minimum) {
				minimum = arr[i];
			}
		}
		return minimum;
	}
	
//	Return the maximum elements from the array.
	public static int findMaximum(int[] arr) {
		int maximum = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > maximum) {
				maximum = arr[i];
			}
		}
		
		return maximum;
	}

//	return the {i,j} position of the element from the array if exists else {-1,-1}
//	This will works for Jagged Array Also.
	public static int[] searchIn2DArrays(int[][] arr,int target) {
		for(int i =0;i<arr.length;i++) {
			for(int j =0; j<arr[i].length;j++) {
				if(arr[i][j] == target) {
					return new int[] {i,j};
				}
			}
		}
		return new int[]{-1,-1};
	}
	
//	LeetCode 1295: find the count of Nuber from an array with even Number Of Digits.
	public static int findCountNumberWithEvenDigit(int[]arr ) {
		int count =0;
		for(int num:arr) {
			if(digitCount(Math.abs(num)) % 2 == 0) {
				count++;
			}
//			Optimized Solution for checking Even digit
//			if(((int)Math.log10(Math.abs(num))+1) % 2 == 0) {
//				count++;
//			}
		}
		return count;
	}
	

//  LeetCode 53: Maximum Subarray
	public static int maxSubArray(int[] nums) {
        // Brute Force Approach
        
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum += nums[j];
        //         if(sum > maxSum)maxSum=sum;
        //     }
        // }
        // return maxSum;


        // Optimal approach (Kadane Algorithm)

        int sum=nums[0],maxSum = sum;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > maxSum)maxSum=sum;
            if(sum < 0)sum=0;
        }
        return maxSum;
    }
	
	public static void main(String[] args) {
		int[] arr = {23,12,43,123,18,343,-1223, 92673,123,-9234,12,98};
		int[][] arr2 = {{1,2,3,4,8},{43,12,334,54,23,54,103902,128}};
		
		System.out.println(findMinimum(arr)); // Output: -9234
		System.out.println(findMaximum(arr)); // Output: 92673
		System.out.println(Arrays.toString(searchIn2DArrays(arr2, 0))); // Output: [-1 ,-1]
		System.out.println(findCountNumberWithEvenDigit(arr)); // Output: 8
	}
	
	
	public static int digitCount(int number) {
		int count = 0;
		
		while(number > 9) {
			number /= 10;
			count++;
		}
		return count+1;
	}
}
