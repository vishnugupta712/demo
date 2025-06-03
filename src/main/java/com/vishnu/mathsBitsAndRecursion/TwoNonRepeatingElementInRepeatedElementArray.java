package com.vishnu.mathsBitsAndRecursion;

import java.util.Arrays;

//Find the two non-repeating elements in an array of repeating elements
public class TwoNonRepeatingElementInRepeatedElementArray {

  public static void main(String[] args) {
    int[] nums ={2,1,2,3,4,1};
    System.out.println("2 unique elements in array:"+ Arrays.toString(findUniqueElements(nums)));
  }

  static int[] findUniqueElements(int[] arr){
    int xor = 0;
    // Step 1: XOR all elements. The result will be the XOR of the two unique numbers.
    for(int num:arr){
      xor = xor^num;
    }
    // Step 2: Find a set bit (rightmost) in the XOR result
    // This will be used to divide numbers into two groups
    int setBit = xor & ~(xor-1);
    int x = 0, y=0;
    // Step 3: Partition numbers into two groups and XOR each group
    //one group has non-set bit on rightmost set bit position of Xor result and other group has set bit on same position
    for(int num : arr){
      if((num & setBit) == 0){
        x = x^num;
      }
      else{
        y = y^num;
      }
    }
    return new int[]{x,y};
  }
}
