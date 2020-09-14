package com.teiphu;

/**
 * 357. 计算各个位数不同的数字个数
 *
 * @author Zheng Lifu
 * @ideas 动态规划的状态转移方程在于排列组合
 */
public class CountNumbersWithUniqueDigits {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));

    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 10;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 10;
        int temp = 9;
        for (int i = 2; i <= n; i++) {
            temp *= (11 - i);
            dp[i] = dp[i - 1] + temp;
        }
        return dp[n - 1];
    }

}
