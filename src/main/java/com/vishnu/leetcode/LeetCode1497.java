package com.vishnu.leetcode;

public class LeetCode1497 {
//T.C O(n)
  //S.C O(n)
  public static void main(String[] args) {
     int []arr = {1,2,3,4,5,10,6,7,8,9};
     int k=5;
    System.out.println(canArrange(arr,k));
  }

  private static boolean canArrange(int[] arr, int k) {
    int[]remainderCount = new int[k];
    for(int num: arr){
      int remainder = ((num%k)+k)%k;
      remainderCount[remainder]++;
    }

    for(int i =0; i<= k/2 ; i++){
      if(i==0){
        if(remainderCount[0]%2 != 0){
          return false;
        }
      }
      else {
        // For other remainders, count of remainder i must match count of k - i
        if (remainderCount[i] != remainderCount[k - i]) {
          return false;
        }
      }
    }
    return true;
  }
}
