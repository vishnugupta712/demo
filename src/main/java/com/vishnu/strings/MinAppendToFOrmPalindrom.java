package com.vishnu.strings;

public class MinAppendToFOrmPalindrom {
	static boolean isPalindrome(char[] str) {
		int len = str.length;

		// single character is always palindrome
		if (len == 1)
			return true;

		// pointing to first character
		int ptr1 = 0;

		// pointing to last character
		int ptr2 = len - 1;

		while (ptr2 >= ptr1) {
			if (str[ptr1] != str[ptr2])
				return false;
			ptr1++;
			ptr2--;
		}

		return true;
	}

	// Recursive function to count number of appends
	static int noOfAppends(String s) {
		if (isPalindrome(s.toCharArray()))
			return 0;

		// Removing first character of string by
		// incrementing base address pointer.
		s = s.substring(1);

		return 1 + noOfAppends(s);
	}

	// Driver code
	public static void main(String arr[]) {
		String s = "abede";
		System.out.printf("%d\n", noOfAppends(s));
	}
}
