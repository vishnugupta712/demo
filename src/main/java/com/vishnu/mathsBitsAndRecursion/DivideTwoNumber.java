package com.vishnu.mathsBitsAndRecursion;

public class DivideTwoNumber {
  public static int divide(int dividend, int divisor) {
    // Handle overflow case
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE; // Overflow case
    }

    // Determine the sign of the result
    boolean negative = (dividend < 0) ^ (divisor < 0);

    // Work with absolute values
    long absDividend = Math.abs((long) dividend); // Use long to prevent overflow
    long absDivisor = Math.abs((long) divisor);

    int quotient = 0;

    // Bit manipulation to calculate quotient
    for (int i = 31; i >= 0; i--) {
      // Check if the current bit can fit in the dividend
      if ((absDividend >> i) >= absDivisor) {
        absDividend -= (absDivisor << i); // Subtract the value
        quotient += (1 << i); // Add the corresponding value to quotient
      }
    }

    // Apply sign to the quotient
    return negative ? -quotient : quotient;
  }

  public static void main(String[] args) {
    DivideTwoNumber solution = new DivideTwoNumber();
    int dividend = 10;
    int divisor = 3;
    int result = divide(dividend, divisor);
    System.out.println("Result: " + result); // Output: 3
  }
}
