package com.teiphu;

import java.util.Arrays;

/**
 * 1262.可被三整除的最大和
 *
 * @author Zheng Lifu
 */
public class MaxSumDivThree {

    public static void main(String[] args) {
        int[] num = {3, 6, 5, 1, 8};
        int res = maxSumDivThree(num);
        System.out.println(res);
    }

    private static int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length + 1][3];
        for (int i = 0; i < nums.length; i++) {
            int remainder = nums[i] % 3;
            if (remainder == 0) {
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][(3 - remainder) % 3] + nums[i]);
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][(4 - remainder) % 3] + nums[i]);
                dp[i + 1][2] = Math.max(dp[i][2], dp[i][(5 - remainder) % 3] + nums[i]);
            } else if (remainder == 1) {
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][(5 - remainder) % 3] + nums[i]);
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][(3 - remainder) % 3] + nums[i]);
                dp[i + 1][2] = Math.max(dp[i][2], dp[i][(4 - remainder) % 3] + nums[i]);
            } else if (remainder == 2) {
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][(4 - remainder) % 3] + nums[i]);
                dp[i + 1][1] = Math.max(dp[i][1], dp[i][(5 - remainder) % 3] + nums[i]);
                dp[i + 1][2] = Math.max(dp[i][2], dp[i][(3 - remainder) % 3] + nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return -1;
    }
}

