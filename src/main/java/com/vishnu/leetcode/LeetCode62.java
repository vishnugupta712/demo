package com.vishnu.leetcode;

public class LeetCode62 {

  public static void main(String[] args) {
    System.out.println(uniquePaths(3,7));
    System.out.println(uniquePathsByCombinatorics(3,7));
  }

  private static int uniquePaths(int m , int n){
    int [][] mat = new int[m][n];
    for(int i = 0 ; i<m ; i++){
      for(int j = 0 ; j<n ; j++){
        if(i==0 || j==0){
          mat[i][j]=1;
        }
        else{
          mat[i][j]=0;
        }
      }
    }
    for(int i = 1 ; i<m ; i++){
      for(int j = 1 ; j<n ; j++){
        mat[i][j] = mat[i-1][j]+mat[i][j-1];
      }
    }
    return mat[m-1][n-1];
  }

  private static int uniquePathsByCombinatorics(int m , int n){
    int totalMoves = m + n - 2; // Total number of moves needed (m-1 down + n-1 right)
    int k = Math.min(m - 1, n - 1); // Choose the smaller of (m-1) or (n-1)

    long result = 1; // We use long to handle large numbers
    for (int i = 1; i <= k; i++) {
      result = result * (totalMoves - i + 1) / i;
    }
    return (int) result;
  }
}
