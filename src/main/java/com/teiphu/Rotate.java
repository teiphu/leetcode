package com.teiphu;

public class Rotate {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int mid = n / 2;
		for (int i = 0; i < mid; i++) {
			for (int j = i; j < n - i - 1; j++) {

			}
		}
	}

	public void rotate1(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		int mid = n >> 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < mid; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = tmp;
			}
		}

	}
}
