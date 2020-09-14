package com.teiphu;

/**
 * 面试题 16.17. 连续数列
 *
 * @author Zheng Lifu
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 3, 1, 3};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
