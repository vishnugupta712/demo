package com.vishnu.array;

import java.util.Stack;

public class AntiSpiralMatrix {
	public static void antiSpiralTraversal(int m, int n, int a[][]) {
		int i, k = 0, l = 0;

		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index i - iterator
		 */
		Stack<Integer> stk = new Stack<Integer>();

		while (k <= m && l <= n) {
			/*
			 * Print the first row from the remaining rows
			 */
			for (i = l; i <= n; ++i)
				stk.push(a[k][i]);
			k++;

			/*
			 * Print the last column from the remaining columns
			 */
			for (i = k; i <= m; ++i)
				stk.push(a[i][n]);
			n--;

			/*
			 * Print the last row from the remaining rows
			 */
			if (k <= m) {
				for (i = n; i >= l; --i)
					stk.push(a[m][i]);
				m--;
			}

			/*
			 * Print the first column from the remaining columns
			 */
			if (l <= n) {
				for (i = m; i >= k; --i)
					stk.push(a[i][l]);
				l++;
			}
		}

		while (!stk.empty()) {
			System.out.print(stk.peek() + " ");
			stk.pop();
		}
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };

		antiSpiralTraversal(mat.length - 1, mat[0].length - 1, mat);
	}
}
