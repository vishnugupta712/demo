package com.vishnu.array;

public class RotateArray {
	static void reverse(int arr[], int start, int end)
    {
        int temp = 0;
        while(start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void rotateByd(int arr[], int d, int n)
    {
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }
	public static void main (String[] args) 
	{
	    int arr[] = new int[]{2, 8, 7, 10, 5};
	    int n = arr.length;
	    int d = 3;
	    
	    rotateByd(arr, d, n);
	    for(int i = 0; i < n; i++)
	     System.out.print(arr[i] + " ");
	}
}
