package com.vishnu.mathsBitsAndRecursion;

public class CheckPrime {
//Overall TC for both method : O(sqrt(n))
  public static void main(String[] args) {
    int n = 232432;
    for(int i = 2 ; i*i <=n ; i++){
      if(n%i == 0){
        System.out.println("number is not prime");
        break;
      }
    }
    System.out.println("number is prime");
  }

  static boolean checkPrimeFromEfficientWay(int number){
    if(number == 1){
      return false;
    }
    if(number == 2 || number == 3){
      return true;
    }
    if(number%2 ==0  || number%3 == 0){
      return false;
    }
    for(int i =5 ; i*i <= number ; i+=6){
      if(number%i ==0 || number%(i+2) ==0){
        return true;
      }
    }
    return false;
  }
}
