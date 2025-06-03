package com.vishnu.mathsBitsAndRecursion;

public class CountSubSeqOfLen3 {

  public static void main(String[] args) {
    int[] A = {1, 2, 4, 3}; // Example input
    int N = A.length;
    int M = 3;
    System.out.println(countSubSeq(A,N,M));
  }

  private static long countSubSeq(int[] A, int N, int M){
    int[] count = new int[M];
    for(int num: A) {
      count[num%M]++;
    }
    long result =0;
    //case1 : All number have different remainder
    for(int i=0; i<M; i++){
       for(int j = i+1; j<M; j++){
         int k = (M-((i+j)%M))%M;
         if(k>j) {
           result += count[i] * count[j] * count[k];
         }
       }
    }
    //case2 : one number has different remainder and 2 numbers have same remainder
    for(int i=0; i<M; i++){
      int k = (M-((2*i)%M))%M;
      if(k<i && k<M) {
        result += ((count[i]*count[i-1])/2)*count[k];//choose pair for count[i] so count[i]C2-> nc2
      }
    }

    //case3: all 3 numbers have same remainder
    for(int i=0; i<M; i++){
      if(count[i]>=3){
        result+= (count[i]*count[i-1]*count[i-2])/6; // equivalent to nc3
      }
    }
    return result;
  }
}
