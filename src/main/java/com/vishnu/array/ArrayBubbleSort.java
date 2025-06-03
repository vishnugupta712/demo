package com.vishnu.array;

import java.util.Arrays;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		int arr[] = {34, 64, 25, 12, 22, 11, 90};
		bubbleSortRecursive(arr,arr.length);
		//bubbleSort(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	static void bubbleSortRecursive(int arr[], int n)
    {
        // Base case
        if (n == 1)
            return;
      
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
      
        // Largest element is fixed,
        // recur for remaining array
        bubbleSortRecursive(arr, n-1);
    }
	static void bubbleSort(int arr[], int n) {
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

}
