package com.vishnu.leetcode;

public class Leetcode162WithMaxPeakTwist {

  public static void main(String[] args) {
     int []nums = {1,2,1,3,5,6,4};
    int res = findPeakElement(nums);
    System.out.println("max peak is "+nums[res]);
  }
  private static int findPeakElement(int[] input) {
    int start = 0, end = input.length - 1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if ((mid == 0 || input[mid] > input[mid - 1]) &&
        (mid == input.length - 1 || input[mid] > input[mid + 1])) {
        return mid;
      } else if (mid < input.length - 1 && input[mid] < input[mid + 1]) {
        start = mid + 1; // Move to the right half
      } else {
        end = mid - 1; // Move to the left half
      }
    }
    return Integer.MAX_VALUE;
  }
}
