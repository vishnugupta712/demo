package com.vishnu.array;

import java.util.*;

public class ArrayCountSort {
   public static void main(String[] args) {
	   int arr[] = { 12, 11, 13, 5, 6 };
	   ArrayCountSort ob = new ArrayCountSort();
     List<Integer> dataList = new ArrayList<>();
     List<Integer>[] buckets = new ArrayList[10];
     var outputArr = ob.sort(arr);
       printArray(outputArr);
}
   int[] sort(int arr[])
   {
       int n = arr.length;
       int max = 0;
     for (int i = 0; i < n; ++i){
       max = Math.max(max, arr[i]);
     }
     int[] countArr = new int[max+1];
     for (int i = 0; i < n; ++i){
       countArr[arr[i]]++;
     }
     for(int i=1; i<=max ; i++){
       countArr[i] = countArr[i-1]+countArr[i];
     }
     int[] outputArr = new int[n];
   for(int i = n-1 ; i>=0 ; i--){
     outputArr[countArr[arr[i]]-1] = arr[i];
     countArr[arr[i]]--;
   }
       return outputArr;
   }
   static void printArray(int arr[])
   {
       int n = arr.length;
       for (int i = 0; i < n; ++i)
           System.out.print(arr[i] + " ");

       System.out.println();
   }
}
