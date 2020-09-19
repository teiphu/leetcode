package com.teiphu;

/**
 * 5491. 矩阵对角线元素的和
 */
public class DiagonalSum {

	public int diagonalSum(int[][] mat) {
		int sum = 0;
		for (int i = 0; i < mat.length; i++) {
			if (i == (mat.length - 1 - i)) {
				sum += mat[i][i];
			} else {
				sum += mat[i][i] + mat[i][mat.length - 1 - i];
			}
		}
		return sum;
	}
}
