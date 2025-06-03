package com.vishnu.mathsBitsAndRecursion;

public class PrintAllDivisorsOfNumber {

  public static void main(String[] args) {
    int num = 24;

//    for(int i = 2 ; i*i <= num ; i++){
//      if(num%i == 0){
//        System.out.println(i);
//        if(i != num/i){
//          System.out.println(num/i);
//        }
//      }
//    }
    printAllDivisorsInSortedOrder(num);
  }

  static void printAllDivisorsInSortedOrder(int n){
    int i;
    for(i = 1 ; i*i <= n ; i++){
      if(n%i ==0){
        System.out.println(i);
      }

    }
    System.out.println(n);
    for(; i> 1; i--){
      if(i != n/i && n%i ==0){
        System.out.println(n/i);
      }

    }
  }
}
