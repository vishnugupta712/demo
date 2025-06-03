package com.vishnu.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode315 {

  public static void main(String[] args) {
    int[] arr = {5,2,6,1};
    System.out.println(countSmaller(arr));
  }

  private static List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    int[] results = new int[n];
    int[] indexes = new int[n];

    // Initialize indexes to track positions
    for (int i = 0; i < n; i++) {
      indexes[i] = i;
    }

    // Call the merge sort method with results array and indexes array
    mergeSort(nums, indexes, results, 0, n - 1);
    return Arrays.stream(results).boxed().collect(Collectors.toList());
  }

  private static void mergeSort(int[] nums, int[] indexes, int[] results, int left, int right) {
    if (left >= right) {
      return;
    }

    int mid = left + (right - left) / 2;

    // Recursively split into two halves
    mergeSort(nums, indexes, results, left, mid);
    mergeSort(nums, indexes, results, mid + 1, right);

    // Merge and count smaller elements
    merge(nums, indexes, results, left, mid, right);
  }

  private static void merge(int[] nums, int[] indexes, int[] results, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left;        // Pointer for left half
    int j = mid + 1;     // Pointer for right half
    int k = 0;           // Pointer for the temp array
    int rightCounter = 0; // Counts elements in right half that are smaller than left half elements

    // Merge while counting smaller elements
    while (i <= mid && j <= right) {
      if (nums[indexes[j]] < nums[indexes[i]]) {
        // Element in right half is smaller, so it increases count for left elements
        rightCounter++;
        temp[k++] = indexes[j++];
      } else {
        // Count of smaller elements for the element at indexes[i]
        results[indexes[i]] += rightCounter;
        temp[k++] = indexes[i++];
      }
    }

    // Add remaining elements from the left half
    while (i <= mid) {
      results[indexes[i]] += rightCounter;
      temp[k++] = indexes[i++];
    }

    // Add remaining elements from the right half
    while (j <= right) {
      temp[k++] = indexes[j++];
    }

    // Copy sorted temp back to indexes
    for (int p = 0; p < temp.length; p++) {
      indexes[left + p] = temp[p];
    }
  }
}
