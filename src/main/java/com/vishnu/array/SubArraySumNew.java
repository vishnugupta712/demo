package com.vishnu.array;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArraySumNew{
	public static void main(String[] args) {
      int[] arr = {1, 4, 19, 3, 10, 20, 5};
      int n = arr.length;
      int sum = 33;
      Solution obj = new Solution();
      ArrayList<Integer> res = obj.subarraySum(arr, n, sum);
      for (int i : res)
          System.out.print(i + " ");
    }

}// } Driver Code Ends




class Solution{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        int start = 0;
        int last = 0;
        boolean flag=false;
        int currsum=0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        //iterating over the array.
        for(int i=0;i<n;i++)
        {
            //storing sum upto current element.
            currsum+= arr[i];

            //checking if current sum is greater than or equal to given number.
            if(currsum>=s)
            {
                last=i;
                //we start from starting index till current index and do the
                //excluding part while s(given number) < currsum.
                while(s<currsum && start<last)
                {
                    //subtracting the element from left i.e., arr[start]
                    currsum-= arr[start];
                    ++start;
                }

                //now if current sum becomes equal to given number, we store
                //the starting and ending index for the subarray.
                if(currsum==s)
                {
                    res.add(start + 1);
                    res.add(last + 1);

                    //flag is set to true since subarray exists.
                    flag = true;
                    break;
                }
            }
        }
        //if no subarray is found, we store -1 in result else the found indexes.
        if (flag==false) {
            res.add(-1);
        }
        //returning the result.
        return res;

    }
}
