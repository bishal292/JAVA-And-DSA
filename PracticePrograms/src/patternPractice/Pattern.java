package patternPractice;

public class Pattern {
	/*
	 1. *****
	  	*****
	  	*****
	  	*****
	  	*****
	  	
	 2. *
	 	**
	 	***
	 	****
	 	*****
	 	
	 3. 1
	 	12
	 	123
	 	1234
	 	12345
	 	
	 4. 1
	 	22
	 	333
	 	4444
	 	55555
	 	
	 5. *****
	 	****
	 	***
	 	**
	 	*
	 	
	 6.	12345
	 	1234
	 	123
	 	12
	 	1
	 	
	 7.     *
	 	   ***
	 	  *****
	 	 *******
	 	*********
	 	
	 8.	Reverse of 7
	 
	 9.     *
	 	   ***
	 	  *****
	 	 *******
	 	*********
	 	*********
	 	 *******
	 	  *****
	 	   ***
	 	    *
	 	    
	10.	*
		**
		***
		****
		*****
		****
		***
		**
		*
		
	11.	1
		01
		101
		0101
		10101
		
	12.	1      1
		12    21
		123  321
		12344321
		
	13. 1
		2  3
		4  5  6
		7  8  9  10
		11 12 13 14 15
		
	14. A
		A B
		A B C
		A B C D
		A B C D E
		
	15. Reverse of 14
	
	16. 	A
		   ABA
		  ABCBA
		 ABCDCBA
		ABCDEDCBA
		
	17. E
		DE
		CDE
		BCDE
		ABCDE
		
	18. **********
		****  ****
		***	   ***
		**      **
		*        *
		*        *
		**      **
		***	   ***
		****  ****
		**********
		
	19. *        *
		**	    **
		***    ***
		****  ****
		**********
		****  ****
		***    ***
		**	    **
		*        *
		
	20. *****
		*   *
		*   *
		*   *
		*****
		
	21. 4 4 4 4 4 4 4
		4 3 3 3 3 3 4
		4 3 2 2 2 3 4
		4 3 2 1 2 3 4
		4 3 2 2 2 3 4
		4 3 3 3 3 3 4
		4 4 4 4 4 4 4
		
	 */
	static void pattern1(int n){
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void pattern2(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void pattern3(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(j+1+" ");
			}
			System.out.println();
		}
	}
	
	static void pattern4(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(i+1+" ");
			}
			System.out.println();
		}
	}
	
	static void pattern5(int n) {
		for(int i=n;i>0;i--) {
			for(int j=i;j>0;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void pattern6(int n) {
		for(int i=n;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print(j+1+" ");
			}
			System.out.println();
		}
	}
	
	static void pattern7(int n) {
		// By keeping i=1
		for(int i=1;i<=n;i++) {
			for(int spaces=n-i;spaces>=1;spaces--) {
				System.out.print("  ");				
			}
			for(int star=i*2-1;star>=1;star--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		// By keeping i=0
		/*
		for(int i=0;i<n;i++) {
			for(int spaces=n-i-1;spaces>0;spaces--) {
				System.out.print("  ");				
			}
			for(int star=i*2+1;star>0;star--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		*/
	}
	
	static void pattern8(int n) {
		for(int i=0;i<n;i++) {
			for(int spaces=i;spaces>0;spaces--) {
				System.out.print("  ");
			}
			for(int star=n*2-(i*2+1);star>0;star--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void pattern9(int n) {
		// For upper portion
		for(int i=0;i<n;i++) {
			for(int spaces=n-1-i;spaces>0;spaces--) {
				System.out.print("  ");
			}
			for(int star=i*2+1;star>0;star--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		//for lower Portion
		for(int i=0;i<n;i++) {
			for(int spaces=i;spaces>0;spaces--) {
				System.out.print("  ");
			}
			for(int star=n*2-(i*2+1);star>0;star--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void pattern10(int n) {
		for(int i=1;i<2*n;i++) {
			int stars=i;
			if(i>n) {
				stars=2*n-i;
			}
			for(int j=stars;j>0;j--) {
				System.out.print("* ");				
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		pattern10(5);
	}

}
