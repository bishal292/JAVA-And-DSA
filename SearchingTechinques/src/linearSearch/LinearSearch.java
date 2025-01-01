package linearSearch;

public class LinearSearch {
	
//	A searching algorithm used to search an element from an array usually used for unsorted as for sorted there is binary search.
//	In worst it's time complexity can be O(N) i.e. when the req, element doesn't exists in the array.
//	Linear search to return the first Occurance index of an element if exists else -1.
	
	public static int linearSearch(int[] arr, int target) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				return i;
			}
		}
		return -1;
	}

//	As internally String is also an array and can be traversed as array but in adifferent way.
	public static int searchInString(String str,char target) {
		for(int i=0;i<str.length();i++) {
			if(target == str.charAt(i))return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {45,23,54 ,12,56,87,1, 5, 7,-1, 15 ,99,12232,234,124,421,0};
		int res = linearSearch(arr, 0);
		System.out.println(res); //Output: 16   -> Element is at 16th index (0 -Indexed)
		System.out.println(linearSearch(arr, -123));//Output: -1  -> Element doesn't exists in the array.
		
		System.out.println(searchInString("Hello World!", 'c'));// Output: -1	-> As C doesn't exists in the array.
		System.out.println(searchInString("Hello World!", 'd'));// Output: 10
		
		
		
		
	}
}
