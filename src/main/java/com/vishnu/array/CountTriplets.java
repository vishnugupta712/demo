package com.vishnu.array;

import java.util.Arrays;
import java.util.Scanner;

public class CountTriplets {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		    int n = sc.nextInt();
		    int[]arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    Arrays.sort(arr);
		    int ans =0;
		    for(int i=2;i<n;i++){
		        int poss_sum = arr[i];
		        int start = 0,end =n-1;
		        while(start<end){
		            int curr = arr[start]+arr[end];
		            if(curr>poss_sum){
		                end--;
		            }else if(curr<poss_sum){
		                start++;
		            }else{
		                ans++;
		                start++;
		                end--;
		            }
		        }
		    }
		    if(ans==0){
		        System.out.println(-1);
		    }else{
		    System.out.println(ans);
		    }
	}
	
	/**
	 * Count triplets.
	 *
	 * @param a the a
	 * @param n the n
	 * @return the int
	 * It works for output given in form of a[k]<a[i]<a[j] when i<j<k
	 */
	static int CountTriplets(int a[], int n)
	{
	 
	    // To store count of total triplets
	    int ans = 0;
	 
	    for (int i = 0; i < n; i++)
	    {
	 
	        // Initialize count to zero
	        int cnt = 0;
	 
	        for (int j = i + 1; j < n; j++)
	        {
	 
	            // If a[j] > a[i] then,
	            // increment cnt
	            if (a[j] > a[i])
	                cnt++;
	 
	            // If a[j] < a[i], then
	            // it mean we have found a[k]
	            // such that a[k] < a[i] < a[j]
	            else
	                ans += cnt;
	        }
	    }
	 
	    // Return the final count
	    return ans;
	}
}
