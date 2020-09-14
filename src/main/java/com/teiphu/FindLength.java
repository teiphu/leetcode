package com.teiphu;

/**
 * 718.最长重复子数组
 *
 * @author Zheng Lifu
 */
public class FindLength {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        int res = findLength(A, B);
        System.out.println(res);
    }

    private static int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 蛮力法
     *
     * @param A
     * @param B
     * @return
     */
    private static int findLength0(int[] A, int[] B) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = 0;
                while (i + k < A.length && j + k < B.length &&
                        A[i + k] == B[j + k]) {
                    k += 1;
                }
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

}
