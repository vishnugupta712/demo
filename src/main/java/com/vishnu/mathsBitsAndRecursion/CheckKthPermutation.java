package com.vishnu.mathsBitsAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class CheckKthPermutation {

  public static void main(String[] args) {
      int num = 3;
      int k = 3;
    System.out.println("kth permutation : "+ getPermutation(num,k));
  }

  private static String getPermutation(int n, int k) {
    // Initialize a list of numbers to get the permutations from
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      numbers.add(i);
    }

    // Prepare a result StringBuilder
    StringBuilder result = new StringBuilder();

    // Adjust k to be zero-indexed
    k--; // Convert to zero-based index

    // Factorial array
    int[] factorial = new int[n];
    factorial[0] = 1;
    for (int i = 1; i < n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }

    // Build the k-th permutation
    for (int i = n - 1; i >= 0; i--) {
      int index = k / factorial[i]; // Determine which number will be used
      result.append(numbers.get(index)); // Append that number to the result
      numbers.remove(index); // Remove that number from the list
      k %= factorial[i]; // Update k for the next round
    }

    return result.toString();
  }
}
