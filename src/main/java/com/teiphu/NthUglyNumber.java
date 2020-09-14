package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));

    }

    public static int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        for (int i = 2; i <= n; i++) {
            int r2 = dp[i2] * 2;
            int r3 = dp[i3] * 3;
            int r5 = dp[i5] * 5;
            dp[i] = Math.min(r2, Math.min(r3, r5));
            if (r2 == dp[i]) {
                ++i2;
            }
            if (r3 == dp[i]) {
                ++i3;
            }
            if (r5 == dp[i]) {
                ++i5;
            }
        }
        return dp[n];
    }
}
