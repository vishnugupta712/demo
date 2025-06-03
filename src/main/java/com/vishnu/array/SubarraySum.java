package com.vishnu.array;

import java.util.HashMap;
import java.util.Scanner;

class SubarraySum {
	/* Returns true if the there is
a subarray of arr[] with sum equal to
	'sum' otherwise returns false.
Also, prints the result */
	int subArraySum(int arr[], int n, int sum)
	{
		int curr_sum = arr[0], start = 0, i;

		// Pick a starting point
		for (i = 1; i <= n; i++) {
			// If curr_sum exceeds the sum,
			// then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum,
			// then return true
			if (curr_sum == sum) {
				int p = i - 1;
				System.out.println(
					"Sum found between indexes " + start
					+ " and " + p);
				return 1;
			}

			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];
		}

		System.out.println("No subarray found");
		return 0;
	}
	
	public static void subArraySumByHashMap(int[] arr, int n, int sum) {
        //cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);
 
        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                            + start + " to " + end);
        }
 
    }

	// Function to check if subarray with sum
    // exists when negative elements are also present
    static void subArraySumForConstantSpace(int arr[], int n, int sum)
    {
        int minEle = Integer.MAX_VALUE;
     
        // Find minimum element in the array
        for (int i = 0; i < n; i++)
            minEle = Math.min(arr[i], minEle);
     
        // Initialize curr_sum as value of
        // first element and starting point as 0
        int curr_sum = arr[0] + Math.abs(minEle);
        int start = 0, i;
     
        // Starting window length will be 1,
        // For generating new target sum,
        // add abs(minEle) to sum only 1 time
        int targetSum = sum;
     
        // Add elements one by one to curr_sum
        // and if the curr_sum exceeds the
        // updated sum, then remove starting element
        for (i = 1; i <= n; i++)
        {
     
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum - (i - start) *
                   Math.abs(minEle) > targetSum &&
                                      start < i)
            {
                curr_sum = curr_sum - arr[start] -
                           Math.abs(minEle);
                start++;
            }
     
            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum - (i - start) *
                Math.abs(minEle) == targetSum)
            {
                System.out.println("Sum found between indexes " +
                                      start + " and " + (i - 1));
                return;
            }
     
            // Add this element to curr_sum
            if (i < n)
            {
                curr_sum = curr_sum + arr[i] +
                             Math.abs(minEle);
            }
        }
     
        // If we reach here, then no subarray
        System.out.println("No subarray found");
    }
	public static void main(String[] args)
	{
		SubarraySum arraysum = new SubarraySum();
		/*
		 * Scanner sc = new Scanner(System.in); int n = sc.nextInt(); int s =
		 * sc.nextInt();
		 */

        //int[] m = new int[n];
		/*
		 * for (int j = 0; j < n; j++) { m[j] = sc.nextInt(); }
		 */
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 23;
		arraysum.subArraySumByHashMap(arr, n, sum);
	}
}

