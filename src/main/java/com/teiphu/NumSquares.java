package com.teiphu;

import java.util.Arrays;

/**
 * 279.完全平方數
 *
 * @author Zheng Lifu
 */
public class NumSquares {

    public static void main(String[] args) {

        int res = numSquares(14);
        System.out.println(res);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int max_square_index = (int) Math.sqrt(n) + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= max_square_index; j++) {
                if (i < j * j) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
