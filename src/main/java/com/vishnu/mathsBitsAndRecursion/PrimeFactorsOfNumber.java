package com.vishnu.mathsBitsAndRecursion;

//Overall TC for both method : O(sqrt(n))
public class PrimeFactorsOfNumber {
  public static void main(String[] args) {
    int n = 232432;
    for(int i = 2 ; i*i <=n ; i++){
      while(n%i == 0){
        System.out.println(i);
        n/=i;
      }
    }
    System.out.println("number is prime");
  }

  static void getPrimeFactorFromEfficientWay(int number){
    if(number<=1){
      return;
    }
    while(number%2 ==0){
      System.out.println(2);
      number/= 2;
    }
    while(number%3 ==0){
      System.out.println(3);
      number/= 3;
    }
    for(int i =5 ; i*i <= number ; i+=6){
      while(number%i ==0){
        System.out.println(i);
        number/= i;
      }
      while(number%(i+2) ==0){
        System.out.println(i+2);
        number/= (i+2);
      }
    }
  }
}
