package com.vishnu.hashing;

import java.util.ArrayList;
import java.util.HashMap;

class Pair
{
    int first, second;
    Pair(int a, int b)
    {
        first = a;
        second = b;
    }
}
public class ZeroSumSubArray {
	static ArrayList<Pair> findSubArrays(int[] arr, int n)
    {
            // create an empty map
            HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
 
            // create an empty vector of pairs to store
            // subarray starting and ending index
            ArrayList<Pair> out = new ArrayList<>();
 
            // Maintains sum of elements so far
            int sum = 0;
 
            for (int i = 0; i < n; i++)
            {
                // add current element to sum
                sum += arr[i];
 
                // if sum is 0, we found a subarray starting
                // from index 0 and ending at index i
                if (sum == 0)
                    out.add(new Pair(0, i));
                ArrayList<Integer> al = new ArrayList<>();
                 
                // If sum already exists in the map there exists
                // at-least one subarray ending at index i with
                // 0 sum
                if (map.containsKey(sum))
                {
                    // map[sum] stores starting index of all subarrays
                    al = map.get(sum);
                    for (int it = 0; it < al.size(); it++)
                    {
                            out.add(new Pair(al.get(it) + 1, i));
                    }
                }
                al.add(i);
                map.put(sum, al);
            }
            return out;
    }

  public static long findSubarrayCount(long[] arr ,long n)
  {
    long sum=0, counter=0;
    //using Hashmap to store the prefix sum which has appeared already.
    HashMap<Long, Long>mp=new HashMap<>();

    //iterating over the array.
    for(int i=0;i<n;i++)
    {
      //storing prefix sum.
      sum+=arr[i];

      //if prefix sum is zero that means we get a subarray with sum=0.
      if(sum==0)
      {
        //incrementing the counter.
        counter++;
      }

      //if prefix sum is already present in Hashmap then it is repeated
      //which means there is a subarray whose summation is 0.
      if(mp.containsKey(sum))
      {
        //we add the value at prefix sum in Hashmap to counter.
        counter+=mp.get(sum);
      }

      //incrementing the count of prefix sum obtained in Hashmap.
      if(mp.containsKey(sum))
      {
        long k=mp.get(sum);
        k++;
        mp.put(sum,k);

      }
      else
        mp.put(sum,1L);
    }

    //returning the counter.
    return counter ;
  }
 
    // Utility function to print all subarrays with sum 0
    static void print(ArrayList<Pair> out)
    {
            for (int i = 0; i < out.size(); i++)
            {
                Pair p = out.get(i);
                System.out.println("Subarray found from Index "
                        + p.first + " to " + p.second);
            }
    }
 
    // Driver code
    public static void main(String args[])
    {
            int[] arr = {6, 3, -1, -3, 4, -2, 2};
            int n = arr.length;
             
            ArrayList<Pair> out = findSubArrays(arr, n);
             
            // if we did not find any subarray with 0 sum,
            // then subarray does not exists
            if (out.size() == 0)
                System.out.println("No subarray exists");
            else
                print(out);
    }
}
