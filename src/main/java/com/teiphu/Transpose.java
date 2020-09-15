package org.teiphu;

/**
 * 867. 转置矩阵
 */
public class Transpose {

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        transpose(A);
    }

    public static int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] b = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[j][i] = A[i][j];
            }
        }
        return b;
    }

    private static void swap(int[][] a, int i, int j) {
        int t = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = t;
    }
}
