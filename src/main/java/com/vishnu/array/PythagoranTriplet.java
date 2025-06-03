package com.vishnu.array;

import java.util.*;

public class PythagoranTriplet {
	static boolean isTriplet(int arr[], int n)
    {
        TreeSet<Integer> a=new TreeSet<>();
        for(int i=0;i<arr.length;i++)
        {
            a.add(arr[i]);
        }
        ArrayList<Integer> res = new ArrayList<>(a);
        TreeSet<Integer> hash=new TreeSet<>();
        for(int i=0;i<res.size();i++)
        {
            if(hash.contains(res.get(i)*res.get(i)))
            {
                return true;
            }
            for(int j=i-1;j>=0;j--)
            {
                int value=res.get(j)*res.get(j)+res.get(i)*res.get(i);
                hash.add(value);
            }
        }
        return false;
    }
 
    // Driver program to test above function
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 6, 5 };
        int arr_size = arr.length;
        if (isTriplet(arr, arr_size) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
