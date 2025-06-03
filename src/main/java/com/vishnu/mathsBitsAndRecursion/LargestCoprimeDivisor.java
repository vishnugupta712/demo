package com.vishnu.mathsBitsAndRecursion;

public class LargestCoprimeDivisor {

  public static void main(String[] args) {
    int A = 12;
    int B=30;
    System.out.println(largestCoprimeFactor(A, B));
  }
  static int largestCoprimeFactor(int a, int b){
     while(gcd(a,b) != 1){
       a = a/gcd(a,b);
     }
     return a;
  }

  static int gcd(int a, int b){
    if(b==0){
      return a;
    }
    return gcd(b, a%b);
  }
}
