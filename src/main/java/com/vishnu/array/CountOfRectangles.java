package com.vishnu.array;

import java.util.*;

/*
Given an array find rectangles from the array such that area is less than k.
Example
Input: n=5 ,arr=[1,2,3,4,5],k=20
Output: 8
 */
public class CountOfRectangles {

   public static void main(String[] args) {
      int [] height = {2,5,4,6,4,5,3};
      //System.out.println(countRectangles(height, height.length,20));
      System.out.println(largestRectangleArea(height));
   }

   static int countRectangles(int arr[], int n, int k)
   {
      Arrays.sort(arr);
      int count =0;
      for(int i =0; i<n; i++){
         int j=n-1;
         while(i<=j && arr[i]*arr[j] >=k){
            j--;
         }
         count += (j-i);
      }
      return count;
   }

   private static int largestRectangleArea(int[] heights) {
      int len = heights.length;
      int[] nsl= nextSmallerToLeft(heights, len);
      int[] nsr= nextSmallerOnRight(heights, len);
      int maxArea = Integer.MIN_VALUE;
      for(int i = 0 ; i < len ; i++){
         int width = Math.abs(nsr[i]-nsl[i]);
         int area = heights[i]*(width-1);
         maxArea = Math.max(maxArea, area);
      }
      return maxArea;
   }

   private static int[] nextSmallerOnRight(int a[], int n)
   {
      Stack<Integer> stk = new Stack<Integer>();
      int[] res = new int[n];
      for(int i=0; i<n; i++){
         while(!stk.isEmpty() && a[i]< a[stk.peek()]){
            res[stk.peek()] = a[i];
            stk.pop();
         }
         stk.push(i);
      }
      while(!stk.isEmpty()){
         res[stk.peek()] = 0;
         stk.pop();
      }
      return res;
   }
   private static int[] nextSmallerToLeft(int a[], int n)
   {
      Stack<Integer> stk = new Stack<Integer>();
      int[] res = new int[n];
      for(int i=n-1; i>=0; i--){
         while(!stk.isEmpty() && a[i]< a[stk.peek()]){
            res[stk.peek()] = a[i];
            stk.pop();
         }
         stk.push(i);
      }
      while(!stk.isEmpty()){
         res[stk.peek()] = 0;
         stk.pop();
      }
      return res;
   }
}
