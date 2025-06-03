package com.vishnu.array;

public class MaxAbsoluteValueExpression {
  /*
   expression : |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
   time Complexity : O[n]
   space complexity : O[1]
   */
  private static int maxAbsValExpr(int[] arr1, int[] arr2) {
    int len = arr1.length;
    int maxArr1 = Integer.MIN_VALUE;
    int minArr1 = Integer.MAX_VALUE;
    int maxArr2 = Integer.MIN_VALUE;
    int minArr2 = Integer.MAX_VALUE;
    int maxArr3 = Integer.MIN_VALUE;
    int minArr3 = Integer.MAX_VALUE;
    int maxArr4 = Integer.MIN_VALUE;
    int minArr4 = Integer.MAX_VALUE;
    for(int i = 0 ; i < len ; i++){
      maxArr1 = Math.max(maxArr1, arr1[i] - arr2[i] + i);
      minArr1 = Math.min(minArr1, arr1[i] - arr2[i] + i);

      maxArr2 = Math.max(maxArr2, arr1[i] - arr2[i] - i);
      minArr2 = Math.min(minArr2, arr1[i] - arr2[i] - i);

      maxArr3 = Math.max(maxArr3, arr1[i] + arr2[i] + i);
      minArr3 = Math.min(minArr3, arr1[i] + arr2[i] + i);

      maxArr4 = Math.max(maxArr4, arr1[i] + arr2[i] - i);
      minArr4 = Math.min(minArr4, arr1[i] + arr2[i] - i);
    }
    return Math.max(Math.max(maxArr1-minArr1, maxArr2-minArr2), Math.max(maxArr3-minArr3,
                                                                         maxArr4-minArr4));
  }

  public static void main(String[] args) {
    int[] arr1 = {1,-2,-5,0,10};
    int [] arr2 = {0,-2,-1,-7,-4};
    System.out.println("max absolute value expression : "+ maxAbsValExpr(arr1, arr2));
  }
}
