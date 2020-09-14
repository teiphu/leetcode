package com.teiphu;

import java.util.Arrays;

/**
 * 213.打家劫舍II
 *
 * @author Zheng Lifu
 */
public class RobII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        int res = rob(nums);
        System.out.println(res);
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int res = Math.max(partRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                partRob(Arrays.copyOfRange(nums, 1, nums.length)));
        return res;
    }

    public static int partRob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
