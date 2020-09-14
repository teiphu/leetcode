package com.teiphu;

/**
 * 931.下降路径最小和
 *
 * @author Zheng Lifu
 */
public class MinFallingPathSum {

    public static void main(String[] args) {
        int[][] a = {{17, 82}, {1, -44}};
        int res = minFallingPathSum(a);
        System.out.println(res);
    }

    public static int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int min = A[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, A[i - 1][j - 1]);
                }
                if (j + 1 < A[i].length) {
                    min = Math.min(min, A[i - 1][j + 1]);
                }
                A[i][j] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[A.length - 1].length; i++) {
            min = Math.min(min, A[A.length - 1][i]);
        }
        return min;
    }
}
