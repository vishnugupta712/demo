package com.vishnu.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FourSumElements {
	static class pair {
        int first, second;
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
 
    // The function finds four elements
    // with given sum X
    static void findFourElements(int arr[], int n, int X)
    {
        // Store sums of all pairs in a hash table
        HashMap<Integer, pair> mp
            = new HashMap<Integer, pair>();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                mp.put(arr[i] + arr[j], new pair(i, j));
 
        // Traverse through all pairs and search
        // for X - (current pair sum).
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
 
                // If X - sum is present in hash table,
                if (mp.containsKey(X - sum)) {
 
                    // Making sure that all elements are
                    // distinct array elements and an
                    // element is not considered more than
                    // once.
                    pair p = mp.get(X - sum);
                    if (p.first != i && p.first != j
                        && p.second != i && p.second != j) {
                        System.out.println(
                            arr[i] + ", " + arr[j] + ", "
                            + arr[p.first] + ", "
                            + arr[p.second]);
                        return;
                    }
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> listOfFourSumWithUniqueElements(int[] a, int k) {
        int n = a.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (n < 4) return ans;

        Arrays.sort(a);
        for (int i = 0; i < n - 3; i++) {
            // current element is greater than k then no quadruplet can be found
            if (a[i] > 0 && a[i] > k) break;

            // removing duplicates
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; ++j) {
                // removing duplicates
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                // taking two pointers
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int old_l = left;
                    int old_r = right;
                    // calculate current sum
                    int sum = a[i] + a[j] + a[left] + a[right];
                    if (sum == k) {
                        // add to answer
                        ans.add(new ArrayList<Integer>(
                          Arrays.asList(a[i], a[j], a[left], a[right])));

                        // removing duplicates
                        while (left < right && a[left] == a[old_l]) left++;
                        while (left < right && a[right] == a[old_r]) right--;
                    } else if (sum > k) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 10,2,3,4,5,7,8 };
        int n = arr.length;
        int X = 23;
       
        // Function call
        findFourElements(arr, n, X);
    }
}
