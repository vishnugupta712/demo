package com.vishnu.mathsBitsAndRecursion;

public class ModularExponentiationRecAndItr {

  public static void main(String[] args) {
    System.out.println(modularExpoRecursive(-3, 5, 89));
    System.out.println(modularExpoIterative(2312, 3434, 6789));
  }

  private static int modularExpoRecursive(int x, int y , int p){

    if(y==0){
      return 1;
    }
    long half;
    if(y%2 ==0){
      half = modularExpoRecursive(x, y/2, p);
      half = (half*half)%p;
    }
    else{
      half = x%p;
      half =(half * modularExpoRecursive(x, y-1,p)%p)%p;
    }
    return (int)((half+p)%p);
  }

  private static int modularExpoIterative(int x, int y , int p){
    int res=1;
    while(y>0){
      if(y %2 !=0){
        res = (res *x)%p ;
      }
      y = y/2;
      x = (x*x)%p;
    }
    return (res+p) %p;
  }
}
