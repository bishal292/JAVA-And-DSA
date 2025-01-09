package cycleSort;

import java.util.Arrays;

public class CycleSort {
 
	public static void cyclicSort(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			int correctIndex = arr[i]-1;
			
			if(arr[i] != arr[correctIndex]) {
				swap(arr, i, correctIndex);
			}else {
				i++;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {5,7,4,2,1,6,3,7,7};
		
		cyclicSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	

	public static void swap(int[] arr,int index1,int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
