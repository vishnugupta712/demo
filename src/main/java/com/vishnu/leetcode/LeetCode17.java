package com.vishnu.leetcode;
import java.util.*;
public class LeetCode17 {
  public List<String> letterCombinations(String digits) {
    // Base case: if the input is empty, return an empty list
    if (digits == null || digits.isEmpty()) {
      return new ArrayList<>();
    }

    // Map of digits to their corresponding letters
    String[] phoneMapping = {
      "",     // 0
      "",     // 1
      "abc",  // 2
      "def",  // 3
      "ghi",  // 4
      "jkl",  // 5
      "mno",  // 6
      "pqrs", // 7
      "tuv",  // 8
      "wxyz"  // 9
    };

    // List to store the result
    List<String> result = new ArrayList<>();

    // Start backtracking from the first digit
    backtrack(result, digits, phoneMapping, new StringBuilder(), 0);

    return result;
  }

  private void backtrack(List<String> result, String digits, String[] phoneMapping, StringBuilder current, int index) {
    // If the current combination is complete, add it to the result
    if (index == digits.length()) {
      result.add(current.toString());
      return;
    }

    // Get the letters corresponding to the current digit
    String letters = phoneMapping[digits.charAt(index) - '0'];

    // Loop through each letter and proceed with backtracking
    for (char letter : letters.toCharArray()) {
      current.append(letter); // Choose
      backtrack(result, digits, phoneMapping, current, index + 1); // Explore
      current.deleteCharAt(current.length() - 1); // Un-choose
    }
  }

  // Main method for testing
  public static void main(String[] args) {
    LeetCode17 solution = new LeetCode17();
    String digits = "23";
    List<String> combinations = solution.letterCombinations(digits);
    System.out.println(combinations);
  }
}
