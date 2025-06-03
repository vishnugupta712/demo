package com.vishnu.array;

public class DamOfCandies {

   public static void main(String[] args) {
      int [] height = {2,1,3,4,6,5};
      System.out.println(maxCandy(height, height.length));
   }

   static int maxCandy(int height[], int n)
   {
      int i =0,j=n-1, maxArea=0;
      while(i<j){
         maxArea = Math.max(maxArea, (j-i-1)*Math.min(height[i],height[j]));
         if(height[i] < height[j]){
            i++;
         }
         else{
            j--;
         }
      }
      return maxArea;
   }
}
