package com.vishnu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode162WithMinAndmaxPeakWithIndexes {

  public static int[] findPeaks(int[] input) {
    // Edge cases for very small arrays
    if (input.length == 0) return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, -1, -1};
    if (input.length == 1) return new int[]{input[0], input[0], 0, 0};

    int minPeakValue = Integer.MAX_VALUE;
    int maxPeakValue = Integer.MIN_VALUE;
    int minPeakIndex = -1;
    int maxPeakIndex = -1;

    // Binary search to find any peak
    int start = 0, end = input.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;

      // Check if mid is a peak
      if ((mid == 0 || input[mid] > input[mid - 1]) &&
        (mid == input.length - 1 || input[mid] > input[mid + 1])) {
        // Update peak values and indices
        if (input[mid] < minPeakValue) {
          minPeakValue = input[mid];
          minPeakIndex = mid;
        }
        if (input[mid] > maxPeakValue) {
          maxPeakValue = input[mid];
          maxPeakIndex = mid;
        }
        // Continue search for more peaks
        // To ensure all peaks are considered
        start = mid + 1; // Move to the right half
      } else if (mid < input.length - 1 && input[mid] < input[mid + 1]) {
        start = mid + 1; // Move to the right half
      } else {
        end = mid - 1; // Move to the left half
      }
    }

    // Perform a linear scan to find all peak values
    for (int i = 0; i < input.length; i++) {
      if ((i == 0 || input[i] > input[i - 1]) &&
        (i == input.length - 1 || input[i] > input[i + 1])) {
        // Check if it's the minimum or maximum peak
        if (input[i] < minPeakValue) {
          minPeakValue = input[i];
          minPeakIndex = i;
        }
        if (input[i] > maxPeakValue) {
          maxPeakValue = input[i];
          maxPeakIndex = i;
        }
      }
    }

    // Return the results as an array: {minPeakValue, maxPeakValue, minPeakIndex, maxPeakIndex}
    return new int[]{minPeakValue, maxPeakValue, minPeakIndex, maxPeakIndex};
  }

  public static void main(String[] args) {
    int[] input = {1, 2, 1, 3, 5, 6, 4};
    int[] result = findPeaks(input);
    System.out.println("Min Peak Value: " + result[0] + " at index: " + result[2]);
    System.out.println("Max Peak Value: " + result[1] + " at index: " + result[3]);
  }
}
