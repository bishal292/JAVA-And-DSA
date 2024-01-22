package input;

import java.util.Arrays;
import java.util.Scanner;
public class OneLineMultpileInput {

	public static void main(String[] args) {
//		In This i have explained how to take multiple integers as input from a single line

//		By Scanner Class
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter multiple integers separated by space in a single line:");
//		Creating an array and storing the integers in the array
		int []inpInt=Arrays.stream(sc.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//		Used for each loop to iterate over an array (Collection).
		for (int i : inpInt) {
			System.out.println(i);
		}
		sc.close();
	}

}
