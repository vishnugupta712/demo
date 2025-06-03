package com.vishnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) {
      //System.out.println(maxCoins(new int[]{3,1,5,8}));
      //System.out.println(matrixMultiplication(new int[]{40,20,30,10,30}));
      //System.out.println(lengthOfLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60}));
      //System.out.println(splitArraySameAverage(new int[]{1,2,3,4,5,6,7,8}));
      //System.out.println(isScramble("great", "rgeat"));
      //System.out.println(printLCS("abcde", "ace"));
      System.out.println(printSCS("geek", "eke"));
    }
  public static String printSCS(String text1, String text2){
    int m = text1.length();
    int n = text2.length();

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i < m+1; i++) {
      for (int j = 1; j < n+1; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    StringBuilder sb = new StringBuilder();
    int i=m, j=n;
    while(i>0 && j>0){
      if (text1.charAt(i - 1) == text2.charAt(j - 1)){
        sb.append(text1.charAt(i - 1));
        i--;
        j--;
      }
      else if(dp[i][j-1] > dp[i-1][j]){
        sb.append(text2.charAt(j - 1));
        j--;
      }
      else{
        sb.append(text1.charAt(i - 1));
        i--;
      }
    }
    while(i>0){
      sb.append(text1.charAt(i - 1));
      i--;
    }
    while(j>0){
      sb.append(text2.charAt(j - 1));
      j--;
    }
    return sb.reverse().toString();
  }


    public static String printLCS(String text1, String text2){
      int m = text1.length();
       int n = text2.length();

       int[][] dp = new int[m + 1][n + 1];
       for (int i = 1; i < m+1; i++) {
           for (int j = 1; j < n+1; j++) {
               if (text1.charAt(i - 1) == text2.charAt(j - 1))
                   dp[i][j] = dp[i - 1][j - 1] + 1;
               else
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
           }
       }
       StringBuilder sb = new StringBuilder();
       int i=m, j=n;
       while(i>0 && j>0){
         if (text1.charAt(i - 1) == text2.charAt(j - 1)){
           sb.append(text1.charAt(i - 1));
           i--;
           j--;
         }
         else if(dp[i][j-1] > dp[i-1][j]){
           j--;
         }
         else{
           i--;
         }
       }
       return sb.reverse().toString();
    }

  public static boolean isScramble(String s1, String s2){
    int n = s1.length();
    if (n != s2.length()) return false;

    // dp[i][j][len] means whether s1[i:i+len] is a scramble of s2[j:j+len]
    boolean[][][] dp = new boolean[n][n][n + 1];

    // Base case: single character substrings
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
      }
    }

    // Start filling for longer substrings
    for (int len = 2; len <= n; len++) {
      for (int i = 0; i <= n - len; i++) {
        for (int j = 0; j <= n - len; j++) {
          // Check for all possible splits of length len
          for (int k = 1; k < len; k++) {
            // Case 1: No swap
            if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
              dp[i][j][len] = true;
              break;
            }
            // Case 2: Swap
            if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
              dp[i][j][len] = true;
              break;
            }
          }
        }
      }
    }

    return dp[0][0][n];
  }

  public static boolean splitArraySameAverage(int[] nums) {
    /////////////////////////////////////
    int n = nums.length;
    int totalSum = Arrays.stream(nums).sum();

    // Edge case: If not possible mathematically
    boolean possible = false;
    for (int size = 1; size <= n / 2; size++) {
      if ((totalSum * size) % n == 0) {
        possible = true;
        break;
      }
    }
    if (!possible) return false;

    // DP - HashSet to track possible subset sums
    Map<Integer, HashSet<Integer>> dp = new HashMap<>();
    dp.put(0, new HashSet<>());
    dp.get(0).add(0);

    for (int num : nums) {
      // Traverse existing dp keys in reverse order
      List<Integer> sizes = new ArrayList<>(dp.keySet());
      //Collections.sort(sizes, Collections.reverseOrder());

      for (int size : sizes) {
        HashSet<Integer> newSums = new HashSet<>();
        for (int prevSum : dp.get(size)) {
          newSums.add(prevSum + num);
        }

        dp.putIfAbsent(size + 1, new HashSet<>());
        dp.get(size + 1).addAll(newSums);
      }
    }

    // Check if valid subset exists
    for (int size = 1; size <= n / 2; size++) {
      if ((totalSum * size) % n == 0) {
        int requiredSum = (totalSum * size) / n;
        if (dp.containsKey(size) && dp.get(size).contains(requiredSum)) {
          return true;
        }
      }
    }
    return false;
  }

  public static int lengthOfLIS(int[] nums) {
    //T.C O(n^2)
    // Step 1: Base Condition
    if (nums == null || nums.length == 0)
      return 0;

    int n = nums.length;

    // Step 2: DP Array Initialization
    int[] dp = new int[n];
    Arrays.fill(dp, 1);  // Har element apne aap mein ek subsequence hai
    // Step 3: DP Logic
    for (int i = 1; i < n; i++) {  // Har element ke liye
      for (int j = 0; j < i; j++) {  // Us element ke pehle wale elements ke liye
        if (nums[i] > nums[j]) {  // Increasing subsequence condition
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    // Step 4: Final Answer (DP array ka maximum value)
    int maxLIS = 0;
    for (int value : dp) {
      maxLIS = Math.max(maxLIS, value);
    }

    return maxLIS;
  }
//  public static int maxCoins(int[] nums) {
//    int m = nums.length;
//    int [][] dp = new int[m][m];
//    for(int g=0; g<m; g++){
//      for(int i=0, j=g; j<m; i++,j++){
//        int max = Integer.MIN_VALUE;
//        for(int k=i; k<=j; k++){
//          int left = k==i ? 0 : dp[i][k-1];
//          int right = k==j ? 0 : dp[k+1][j];
//          int val = (i==0 ? 1 : nums[i-1]) * nums[k] * (j==nums.length-1 ? 1 : nums[j+1]);
//          int total = left + right + val;
//          if(total > max){
//            max = total;
//          }
//        }
//        dp[i][j] = max;
//      }
//    }
//    return dp[0][m-1];
//  }

  static int matrixMultiplication(int arr[]) {
    // code here
    int n = arr.length;
    // Step 1: DP array create karo
    int[][]dp = new int[n][n];
    // Step 2: Base case -> Ek single matrix multiply karne ka cost = 0
    for(int i=1; i<n; i++){
      dp[i][i] = 0;
    }
    // Step 3: Chain length ka loop (2 se shuru hoga kyunki 2 se kam mein multiplication ka matlab nahi)
    for(int l=2; l<n; l++){
      // Step 4: Starting index ko set karo
      for(int i=1; i< n-l+1; i++){
        int j = i+l-1; // Ending index
        dp[i][j] = Integer.MAX_VALUE;
        // Step 5: Har possible break point try karenge
        for(int k = i; k<j ; k++){
          int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
          dp[i][j] = Math.min(dp[i][j], cost);
        }
      }
    }
    return dp[1][n-1];
  }
    }
