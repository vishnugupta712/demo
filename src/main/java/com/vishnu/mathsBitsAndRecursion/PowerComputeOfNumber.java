package com.vishnu.mathsBitsAndRecursion;

public class PowerComputeOfNumber {
//T.C O(logn)
//S.C O(n)
  public static void main(String[] args) {
    int num = 3;
    int power = 5;
    System.out.println("result is "+ computePowerRecursive(num, power));
    System.out.println("result is "+ computePowerIterative(num, power));
  }

  static int computePowerRecursive(int num, int pow){
    if(pow==0){
      return 1;
    }
    int temp = computePowerRecursive(num, pow/2);
    temp = temp*temp;
    if(pow%2 == 0){
      return temp;
    }
    return temp*num;
  }

  static int computePowerIterative(int num, int pow){
    int res = 1;
    while(pow>0){
      if(pow%2!=0){
        res = res*num;
      }
      num = num* num;
      pow = pow/2;
    }
    return res;
  }
}
