package com.vishnu.mathsBitsAndRecursion;

public class CountSetBits {
 static int[] table = new int[256];
  public static void main(String[] args) {
   int num = 1009;
    naiveSolution(num);
    brianAndKerninghamAlgo(num);
    initialize();
    constantTimeComplexitySolution(num);
  }

  private static void naiveSolution(int num){
     int count = 0;
     while(num != 0){
        if(((num &  1) == 1)){ // num & 1 can also be written as num % 2
          count++;
        }
        num = num/2;
     }
    System.out.println("count set bits count is "+ count);
  }

  private static void brianAndKerninghamAlgo(int num){
    int count = 0;
    while(num != 0){
      num = num & (num -1);
      count++;
    }
    System.out.println("count set bits count is "+ count);
  }

  private static void constantTimeComplexitySolution(int num){
    int count = 0;
    //here 0xff means all set 8 bits binary number as 11111111
    count = table[num & 0xff] + table[(num>>8) & 0xff] + table[(num>>16) & 0xff] + table[num>>24];
    System.out.println("count set bits count is "+ count);
  }

  private static void initialize(){
    table[0] = 0;
    for(int i = 0 ; i<256 ; i++){
      //help to find no of set bits in each decimal numbers like 1,2,3,..
      table[i] = (i & 1) + table[i/2];
    }
  }
}
