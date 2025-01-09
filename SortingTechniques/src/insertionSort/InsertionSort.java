package insertionSort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void insertionSort(int[] arr) {
		for(int i =0;i<arr.length-1;i++) {
			for(int j = i+1;j>0;j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else break;
			}
		}
		// OR -> Another way to implement insertion sort:
		for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 20, 30, 10, -5, 1, 0, -98, 34, 9, 9, 143, 98, 76, 7, 1, 43, 54};
		
		insertionSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
    
}
