package com.vishnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
      System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    // Sort the array to handle duplicates
    Arrays.sort(candidates);
    backtrack(candidates, target, 0, new ArrayList<>(), result);
    return result;
  }

  private static void backtrack(int[] candidates, int remaining, int start,
                         List<Integer> current, List<List<Integer>> result) {
    // Base case: if remaining becomes 0, we found a valid combination
    if (remaining == 0) {
      result.add(new ArrayList<>(current));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      // Skip if the candidate is too large
      if (candidates[i] > remaining)
        break;  // Changed from continue to break as array is sorted

      // Skip duplicates
      if (i > start && candidates[i] == candidates[i - 1])
        continue;

      // Include the current candidate
      current.add(candidates[i]);

      // Move to next index (i + 1) as we can't reuse same element
      backtrack(candidates, remaining - candidates[i], i + 1, current, result);

      // Backtrack: remove the last added number
      current.remove(current.size() - 1);
    }
  }

    }
