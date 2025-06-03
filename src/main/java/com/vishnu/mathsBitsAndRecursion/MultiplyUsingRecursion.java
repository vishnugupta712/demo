package com.vishnu.mathsBitsAndRecursion;

public class MultiplyUsingRecursion {

  public static void main(String[] args) {
    System.out.println("multiply is "+multiply(4,6));
  }

  private static int multiply(int x, int y){
    if(x < y){
      return multiply(y, x);
    }
    else if(y != 0){
      return (x+ multiply(x, y-1));
    }
    else{
      return 0;
    }
  }
}
