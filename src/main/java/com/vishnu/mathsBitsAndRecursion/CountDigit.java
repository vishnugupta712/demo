package com.vishnu.mathsBitsAndRecursion;

import static java.lang.Math.log10;

public class CountDigit {

  public static void main(String[] args) {
    System.out.println("no of digits "+countDigitsLogarithmicSolution(19839398));
  }

  static int countDigitsLogarithmicSolution(long n){
    return (int)Math.floor(log10(n)+1);
  }
}
