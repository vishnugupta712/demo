package com.vishnu.mathsBitsAndRecursion;

public class PowerCalculationRecAndItr {

  public static void main(String[] args) {
    System.out.println(modularExpoRecursive(-3, 5));
    System.out.println(modularExpoIterative(-3, 5));
  }

  private static int modularExpoRecursive(int x, int y ){

    if(y==0){
      return 1;
    }
    int half = modularExpoRecursive(x, y/2);
    if(y%2 ==0){
      half = (half*half);
    }
    else{
      half =(half * half *x);
    }
    return (half);
  }

  private static int modularExpoIterative(int x, int y){
    int res=1;
    while(y>0){
      if(y %2 !=0){
        res = (res *x) ;
      }
      y = y/2;
      x = (x*x);
    }
    return (res);
  }
}
