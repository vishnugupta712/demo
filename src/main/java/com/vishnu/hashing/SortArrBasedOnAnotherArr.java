package com.vishnu.hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SortArrBasedOnAnotherArr {
	public static void customSort(int[] first, int[] second)
    {
        // map to store the frequency of each element of the first array
        Map<Integer, Integer> freq = new TreeMap<>();
 
        // find the frequency of each element of the first array and
        // store it in a map
        for (int i: first) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
 
        // Note that once we have the frequencies of all elements of
        // the first array, we can overwrite elements of the first array
 
        int index = 0;
 
        // do for every element of the second array
        for (int i: second)
        {
            // If the current element is present on the map, print it `n` times
            // where `n` is the frequency of that element in the first array
            int n = freq.getOrDefault(i, 0);
            while (n-- > 0) {
                first[index++] = i;
            }
 
            // erase the element from the map
            freq.remove(i);
        }
 
        // Now we are left with elements only present in the first array,
        // but not in the second array.
 
        // Sort the remaining elements present on the map (Note that the keys are
        // already sorted since we are using `TreeMap`)
 
        for (Map.Entry<Integer,Integer> entry: freq.entrySet())
        {
            int count = entry.getValue();
            while (count-- > 0) {
                first[index++] = entry.getKey();
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] first = { 5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4 };
        int[] second = { 3, 5, 7, 2 };
 
        customSort(first, second);
        System.out.println("The array after sorting is " + Arrays.toString(first));
    }
}
