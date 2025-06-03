package com.vishnu.array;

import java.util.Arrays;

public class ArrayInsertionSort {
   public static void main(String[] args) {
	   int arr[] = { 12, 11, 13, 5, 6 };
	   ArrayInsertionSort ob = new ArrayInsertionSort();
       ob.binarySort(arr);
       //printArray(arr);
}
   void sort(int arr[])
   {
       int n = arr.length;
       for (int i = 1; i < n; ++i) {
           int key = arr[i];
           int j = i - 1;
           while (j >= 0 && arr[j] > key) {
               arr[j + 1] = arr[j];
               j = j - 1;
           }
           arr[j + 1] = key;
       }
   }
// Driver Code
   public void binarySort(int array[])
   {
       for (int i = 1; i < array.length; i++)
       {
           int x = array[i];

           // Find location to insert
           // using binary search
           int j = Math.abs(
               Arrays.binarySearch(array, 0,
                                   i, x) + 1);

           // Shifting array to one
           // location right
           System.arraycopy(array, j,
                            array, j + 1, i - j);

           // Placing element at its
           // correct location
           array[j] = x;
       }
        printArray(array);
   }
   static void printArray(int arr[])
   {
       int n = arr.length;
       for (int i = 0; i < n; ++i)
           System.out.print(arr[i] + " ");

       System.out.println();
   }
}
