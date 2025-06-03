package com.vishnu.array;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

public class ArraySelectionSort {
    private MultiMap<Integer,Integer>dataMap=new MultiValueMap<>();
	public static void main(String[] args) {
		ArraySelectionSort ob = new ArraySelectionSort();
        int arr[] = {64,25,12,22,11};
        int[] a = { 4, 5, 3, 2, 4, 1 };
        ob.sort(a);
        //ob.stableSelectionSort(a, a.length);
        System.out.println("Sorted array");
        ob.printArray(a);
	}
    void sort(int[]arr) {
    	int len=arr.length;
    	for(int i=0;i<len-1;i++) {
    		int minVal=i;
    		for(int j=i+1;j<len;j++) {
    			if(arr[j]<arr[minVal]) {
    				minVal=j;
    			}
    		}
    		int temp = arr[minVal];
    		arr[minVal] = arr[i];
            arr[i] = temp;
    	}
    }
    void stableSelectionSort(int[] a, int n)
    {
        for (int i = 0; i < n - 1; i++)
        {
            int min = i;
            for (int j = i + 1; j < n; j++) {
            	if (a[min] > a[j]) {
            		min = j;
            	}
            }
            int key = a[min];
            while (min > i)
            {
                a[min] = a[min - 1];
                min--;
            }
            a[i] = key;
        }
        int j=0;
        for (int i=0; i<n; ++i) {
        	dataMap.put(a[i],++j);
        	System.out.print(a[i]+" ");
        }
        System.out.println(dataMap);
        System.out.println();
    }
    void printArray(int arr[])
    {
        int n = arr.length;
        int j=0;
        for (int i=0; i<n; ++i) {
        	dataMap.put(arr[i],++j);
        	System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(dataMap);
    }
}
