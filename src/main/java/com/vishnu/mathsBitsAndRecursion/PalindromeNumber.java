package com.vishnu.mathsBitsAndRecursion;

public class PalindromeNumber {
  public static void main(String[] args) {
    System.out.println("is palindrome "+ checkPalindromeNumber(Long.MAX_VALUE));
  }

  static boolean checkPalindromeNumber(long n){
    int M = 1000000007;
    int[] arr = new int[Integer.MAX_VALUE % M];
    System.out.println("array size "+ arr.length);
    int originalNum = (int)n;
    int reversedNum = 0;
    while(n > 0){
      int digit = (int)n % 10;
      reversedNum = reversedNum * 10 + digit;
      n = (int)n / 10;
    }
    return originalNum == reversedNum;
    //var intArr = Integer.toString((int)n).chars().map(i -> i-'0').toArray();

  }
}
