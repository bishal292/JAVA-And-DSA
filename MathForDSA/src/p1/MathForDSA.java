package p1;

import java.util.ArrayList;

public class MathForDSA {
	/*			Sieve of Eratosthenes
	 * if a number is prime then all the multiple of that number cannot be prime.
	 * 
	 * */
	static ArrayList<Integer> primeInRange(int n){ // Inclusive
		ArrayList<Integer> ans = new ArrayList<Integer>();
		boolean[] arr = new boolean[n+1];
		for(int i = 2;i*i <= n;i++) {
			if(!arr[i]) {
				for(int j = i* 2;j <= n;j+=i) {
					arr[j] = true;
				}
			}
		}
		for(int i =2;i<=n;i++) {
			if(!arr[i]) {
				ans.add(i);
			}
		}
		return ans;
	}
	
//	-----------------------------------------------------------------------------------------
	/**
	 * 		Square Root
	 * as we know that square root will always be less than equal to the half of the number 
	 * 4 -> 2 ( 2 = 2)
	 * 9 -> 3 ( 3 < 4.5)
	 * 
	 * Binary Search Approach.
	 */
	/**
	 * @param n The Number whose square root to be found
	 * @param p The number of precision value needed if the number is not a prefect square.
	 * @return returns the double value for the square root of given number if not perfect square else returns the int value.
	 */
	static double sqrt(int n, int p) {
		double root;
		int s = 0,e=n;
		while(s <= e) {
			int m = s + (e - s) / 2;
			if(m * m == n)return m;
			if(m * m > n) 
				e = m -1;
			else 
				s = m+ 1;
		}
		root = e + 0.1;
		double incr = 0.1;
		for(int i = 0; i< p;i++) {
			while(root * root <= n) {
				root += incr;
			}
			root -= incr;
			incr /= 10;
		}
		
		return root;
	}
	
//			Alternate Way - Newton Raphson Method of finding Square Root.
	/**
	 * Acc. to NRM we suppose a value of square root(x)
	 * then 
	 * 
	 * root = ( x + n/x)/2;		where root is the acual square root, x is the root we have assumed and n is the given number.
	 * 
	 * Error Between the actual and assumed root are (e = root - x)
	 */
	/**
	 * Method of finding Square root by using Newton Raphson Method.
	 * @param n -> Given Number
	 * @param e -> Error Limit which is allowed
	 * @return return the double value which is square root of the given number.
	 */
	static double sqrt2(int n, double e) {
		double x = n,root;
		while(true) {
			root = 0.5 * ( x + (n/x));
			if(Math.abs(root - x) < e) {
				break;
			}
			x = root;
		}
		return root;
	}
	
//	------------------------------------------------------------------------------------------------------------
//									GCD / HCF
//	------------------------------------------------------------------------------------------------------------
/*
 * By Euclidean Theorem: -> States that HCF of 2 numbers 'a' and 'b' is same as the HCF of 'b' and '(a % b)'
 * i.e HCF(a,b) = HCF(b,a%b)
 * and HCF(a,0) = a
 */
	static int gcd(int a, int b) {
		if(b == 0)return a;
		return gcd(b,a%b);
	}
	
//	------------------------------------------------------------------------------------------------------------
//										LCM
//	------------------------------------------------------------------------------------------------------------
	/*
	 * Ex: LCM(12,18)
	 * Factors of 12 => 1 * 2 * 2 * 3
	 * Factors of 18 => 1 * 2 * 3 * 3
	 * 
	 * Hcf = 2 * 3 => 6
	 * LCM = (2 * 3)HCF * 2 * 3 => HCF * (a / HCF) * (b / HCF) => a * b / HCF
	 * LCM = a * b / HCF
	 * a * b = HCF * LCM
	 */
	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	
	public static void main(String[] args) {
		System.out.println(primeInRange(45));
		System.out.println(sqrt(333, 6));
		System.out.println(sqrt2(333, 0.0005));
		System.out.println(gcd(12, 18)); // 6
		System.out.println(lcm(12, 18)); // 36
	}
}
