package com.vishnu.mathsBitsAndRecursion;

public class ReverseBitsOfUnsigned32BitsNumber {

  public static void main(String[] args) {
     String s = "00000010100101000001111010011100";
    System.out.println(solve(s));
  }

  static long solve(String s){
    int n = Integer.parseInt(s);
    int res =0;
    for(int i=0; i<32; i++){
      res = res << 1;
      res = res|(n&1);
      n = n>>1;
    }
    return res;
  }
}
