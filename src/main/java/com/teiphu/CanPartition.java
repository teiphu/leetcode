package com.teiphu;

import java.util.Arrays;

/**
 * 416.分割等和子集
 * 思路参考背包问题
 *
 * @author Zheng Lifu
 */
public class CanPartition {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean res = canPartition(nums);
        System.out.println(res);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;

        int[][] dp = new int[nums.length + 1][half + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= half; j++) {
                dp[i][j] = dp[i - 1][j];
                if ((j >= nums[i - 1]) && dp[i][j] < dp[i - 1][j - nums[i - 1]] + nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + nums[i - 1];
                }
            }
        }
        return dp[nums.length][half] == half;
    }

}
