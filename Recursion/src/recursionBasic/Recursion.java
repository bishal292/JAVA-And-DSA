package recursionBasic;

public class Recursion {
	
	/*
	 * Recursion means a function calling itself inside its body and the process repeats till the goal
	 * of function completes or the edge cases are hit.
	 * 
	 * Recursive function must have the breakpoint(Edge Cases) befor the Recursion call is made in the function.
	 * Else it would create a Recursion Hell and cause STACK OVERFLOW ERROR
	 * */
	
//	-----------------------------------------------------------------------------------------------
	
	/* Why Recursion.
	 * 
	 * -> Helps Solving bigger complex problems in a simple way.
	 * -> Recursive Solution can be converted into iterative Solution and Vice-Versa.
	 * -> Space Complexity for Recursive call are high as multiple function calls are made where each takes a same memory space.
	 */

//	-----------------------------------------------------------------------------------------------

//	Program to Nth fibonacci Numeber
//	Fib(N) = Fib(N-1) + Fib(N-2)
	public static int fib(int n) {
//		This Approach is not suitable for larger number as it is not optimized and duplicate calls is made.
		if(n < 2) {
			return n;
		}
		
		return fib(n-1) + fib(n-2);
	}
	

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
	
	
	public static void main(String[] args) {
//		0 1 1 2 3 5 8 13 21 34 55
		System.out.println(fib(10)); // Output: 55
		
		int arr[] = {1,4,5,6,7,8,11,14,15,18,57,59,60,67,78,89,90,91,93,95,101};
		
		System.out.println(binarySearch(arr, 57, 0, arr.length - 1)); // Output: 10
	}

}