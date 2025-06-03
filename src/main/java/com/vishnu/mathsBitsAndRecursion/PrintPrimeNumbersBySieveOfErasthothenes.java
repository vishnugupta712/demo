package com.vishnu.mathsBitsAndRecursion;

import java.util.Arrays;

public class PrintPrimeNumbersBySieveOfErasthothenes {

  public static void main(String[] args) {
    int n=30;
    boolean primeArr[] = new boolean[n+1];
    Arrays.fill(primeArr,true);
    for(int i = 2 ; i*i<n ; i++){
      if(primeArr[i]){
        for(int j = i*i ; j <= n ; j+=i){
          primeArr[j] = false;
        }
      }
    }
    for(int i = 2 ; i<=n ; i++){
      if(primeArr[i]) {
        System.out.print(i + " ");
      }
    }
    optimizedSOE(30);
  }

  static void optimizedSOE(int n){
    System.out.println();
    boolean primeArr[] = new boolean[n+1];
    Arrays.fill(primeArr,true);
    for(int i = 2 ; i<=n ; i++){
      if(primeArr[i]){
        System.out.print(i + " ");
        for(int j = i*i ; j <= n ; j+=i){
          primeArr[j] = false;
        }
      }
    }
  }
}
