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
//	Basic function to understand working of recursion.
	static void priDecr(int n) {// print the number from n to 1;
		if(n == 0)return;
		System.out.println(n);
		priDecr(n-1);
	}
	static void priInc(int n) {// print the number from 1 to n;
		if(n == 0)return;
		priInc(n-1);
		System.out.println(n);
	}
	static void priBoth(int n) {// print the number from n to 1 then 1 to n;
		if(n == 0)return;
		System.out.println(n);
		priBoth(n-1);
		System.out.println(n);
	}
	
//	-----------------------------------------------------------------------------------------------

	static int factorial(int n) {
		if(n <=  1)return 1;
		return n * factorial(n-1);
	}
	
	static int sumUpToN(int n) {
		if(n <=  1)return 1;
		return n + sumUpToN(n-1);
	}
	
	static int sumOfDigits(int n) {
		if(n == 0)return 0;
		return (n % 10) + sumOfDigits(n / 10);
	}
//	1st Way to reverse a number.
	static int rev = 0;
	static void reverseNum(int num) {
		if(num == 0)return;
		
		rev = rev * 10 + (num % 10);
		reverseNum(num / 10);
	}
	static int reverNum2(int n) {
		int digits = (int)(Math.log10(n) +1);
		return helper(n, digits);
	}
	
	private static int helper(int n, int digits) {
		if(n < 10 )return n;
		int rem = n % 10;
		return rem * (int)(Math.pow(10, digits-1)) + helper(n /10, digits -1);
	}
	
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
	
	public static void main(String[] args) {
		priDecr(5);
		priInc(5);
		priBoth(5);
		System.out.println("\n-------------------------------------\n");
		System.out.println(factorial(5)); // 120
		System.out.println(sumUpToN(7)); // 28
		System.out.println(sumOfDigits(1432)); // 10
		reverseNum(1432);
		System.out.println(rev); // 2341
		System.out.println(reverNum2(1432));
		System.out.println("\n-------------------------------------\n");

//		0 1 1 2 3 5 8 13 21 34 55
		System.out.println(fib(10)); // Output: 55
		
	}

}