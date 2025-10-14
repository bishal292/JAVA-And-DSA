package bitwise;

public class BitwiseOperators {
/*	As name already suggest bitwise operators are used to perform some operations on numbers working on individua bits.
	1 byte = 8 bit

		Bitwise operators operate on individual bits of integer types. They are used to perform bit-level operations.

		'&'    (Bitwise AND): Performs a bitwise AND operation.
			0 & 0 -> 0 
			0 & 1 -> 0 
			1 & 0 -> 0 
			1 & 1 -> 1
			
		'|'    (Bitwise OR): Performs a bitwise OR operation.
			0 | 0 -> 0
			0 | 1 -> 1 
			1 | 0 -> 1 
			1 | 1 -> 1
		'^'    (Bitwise XOR): Performs a bitwise XOR operation.
			0 ^ 0 -> 0
			0 ^ 1 -> 1 
			1 ^ 0 -> 1 
			1 ^ 1 -> 0
			
		'~'    (Bitwise Complement): Inverts the bits. ~a = -(a+1)
			101101 -> 010010
			45 -> -46
			
		'<<'   (Left Shift): Shifts bits to the left. a << b => a * 2^b
			101 << 1 => 1010				1010 << 1 => 10100
			5 -> 10							10 -> 20
			101 << 3 => 101000  ==> 5 -> 40
			
		'>>'   (Right Shift): Shifts bits to the right. a >> b => a / (2^b)
			101 >> 1 => 010				1010 >> 1 => 0101
			5 -> 2							10 -> 5
			101 >> 3 => 000  ==> 5 -> 0
			
		'>>>'  (Unsigned Right Shift): Shifts bits to the right without considering the sign bit.
*/	
	static void oddOrEven(int n) {
		System.out.println((n & 1) == 1 ? "Odd" : "Even");
	}
	
//	Given an array where all the elements except one are being repeated twice. so find the no. which occured only 1 time.
	static int nonRepeatingNumber(int[] arr) {
		int ans = 0;
		for(int a : arr) {
			ans ^= a;
		}
		return ans;
	}
	
//	Find the nth bit of the given no. from the right side.
	static int nthBit(int number,int n) {
		/**
		 number = 182(10110110) here from right (2,3,5,6,8) are the position at which but are 1 else 0,
		 if 5th is to be found then it can be found by:
		 10110110
	   & 00010000 ==> 1 << 4 => 10000
	   	 00010000 -> 1
	   	 
	   	 
	   	 now this will return the lowest number can be formed with the number at the index with position.
	   	 means
	   	 10000  => 16 
	   	 and for 4th position where the bit is 0
	   	 results in 0000 as the smallest
	   	 
	   	 thats why if the result is 0 the the bit at the given place is 0 else 1
		 */
		int result = number & (1 << (n-1));
		return result == 0 ? 0 : 1;
	}
	
//	Similar as the above but this time we have make the nth bit to 1
	static int setNthBit(int num, int n) {
		int result = num | (1 << (n-1));
		return result;
	}
	
//	Position of righmost set Bit
	static int posOfRightSetBit(int num) {
		/**
		 * num = 18  		10010
		 * -num = -18		01110
		 * num & -num  ->	00010 => Isolates only the righmost set bit.
		 * which is 2 in decimal
		 * suppose we got 0100 which is 4 in decimal but the position is 3.
		 * now we know that in binary during conversion to decimal each bit position represent to power of 2.
		 * means
		 * 4 = 2^(pos - 1)  ==> 2 ^ 2
		 * result = 2 ^(position - 1)
		 * taking log base 2 on both side
		 * log2(result) = position - 1;
		 * So, Position = log2(result) + 1;
		 * 
		 * And in Java There is not Log2 or log base 2
		 * so, log(result) / log(2)
		 */
		
		int res = num & -num;
		return (int)(Math.log(res) / Math.log(2)) + 1;
	}
	
//	---------------------------------------------------------------------------------------
	
/*	Find Nth Magic Number 
						OR
	simply convert a binary number into a specical number where the no.is multiplied with 5 instead of 2 and the power starts from 1 instead of 0.
	like 1 (0001) -> 0 + 0 + 0 + 5 ^ 1  	=> 5
	2 (0010) -> 0 + 0 + 1 * 5^2 + 0			=> 25
	5 (0101) -> 0 + 1 * 5^3 + 0 + 1 * 5^1	=> 130
	
	magic number = last bit * 5^(pos)
	
	5,25,30,125,130,150,......
*/
	static int nthMagicNumber(int n) {
		int magNum = 0;
		int base = 5;
		while(n > 0) {
			int lastBit = n & 1;
			n = n>>1;
			magNum += lastBit * base;
			base *= 5;
		}
		return magNum;
	}
	
	
//	------------------------------------------------------------------------------------------------------
/*			Pascal's Triangle
 * 		Each number is the sum of the 2 previous alternate number.
 * 				1				-> 1 	-> 2^0
 * 			  1   1				-> 2	-> 2^1
 * 			1   2   1			-> 4	-> 2^2
 * 		  1   3   3   1			-> 8	-> 2^3
 * 		1   4   6   4   1		-> 16	-> 2^4
 * 		....
 * 		means each line(Row) Sum is 2^(n-1)
*/
	static int sumOfElem(int row) {
		int totSum = 0;
		for(int i = 0; i < row;i++) {
//			int rowSum = (int) Math.pow(2, i); 
//			Similar as above.
			int rowSum = 1 << (i);
			totSum += rowSum;
		}
		return totSum;
	}
	
	
	public static void main(String[] args) {
		System.out.println(~45); // -46
		System.out.println(1^45); // 44
		oddOrEven(46); // Even
		int[] arr = {1,4,7,2,4,8,8,1,7,6,2};
		System.out.println(nonRepeatingNumber(arr)); // Output : 6
		System.out.println(nthBit(182, 5));	// Output: 1
		System.out.println(setNthBit(182, 4)); // Output : 190
		System.out.println(posOfRightSetBit(4)); // Output : 3
		System.out.println(nthMagicNumber(6)); // Output: 150
		System.out.println(sumOfElem(5)); // Output: 31
	}
}
