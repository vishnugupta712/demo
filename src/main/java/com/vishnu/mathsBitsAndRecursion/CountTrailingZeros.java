package com.vishnu.mathsBitsAndRecursion;

public class CountTrailingZeros {

  public static void main(String[] args) {
      int num = 10;
      int result = 0;
      for(int i = 5 ; i <= num ; i*=5){
         result = result + num/5;
      }
    System.out.println("trailing zeros in factorial : "+ result);
  }
}
