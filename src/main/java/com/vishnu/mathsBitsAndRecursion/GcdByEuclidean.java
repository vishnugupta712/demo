package com.vishnu.mathsBitsAndRecursion;

public class GcdByEuclidean {

  public static void main(String[] args) {
    int a = 48;
    int b = 24;
    while(a != b){
      if(a>b){
        a = a-b;
      }
      else{
        b = b-a;
      }
    }
    System.out.println("gcd of input numbers is "+a);
  }

  //TC O(log(min(a,b))
  static int gcdByOptimizedEuclidean(int num1, int num2){
     if(num2 == 0){
       return num1;
     }
    return gcdByOptimizedEuclidean(num2, num1%num2);
  }
}
