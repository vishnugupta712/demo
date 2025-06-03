package com.vishnu.mathsBitsAndRecursion;

public class CheckIfKthBitIsSet {

  public static void main(String[] args) {
    int n=13, k=3;
    //left shift
    //1 << k - 1 will have only 1's which is at kth position
    if ((n & (1 << k - 1)) != 0) {
      System.out.println("Set");
    } else {
      System.out.println("Not Set");
    }

    //right shift
    //n >> k-1 will carry kth bit to LSB position
    if (((n >> k-1)&1) != 0) {
      System.out.println("Set");
    } else {
      System.out.println("Not Set");
    }
  }
}
