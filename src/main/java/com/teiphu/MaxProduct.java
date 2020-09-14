package com.teiphu;

import java.util.Arrays;

/**
 * 152.乘积最大子数组
 *
 * @author Zheng Lifu
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {5, 6, -3, 4, -3};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        maxs[0] = nums[0];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxs[i] = Math.max(maxs[i - 1] * nums[i], Math.max(mins[i - 1] * nums[i], nums[i]));
            mins[i] = Math.min(maxs[i - 1] * nums[i], Math.min(mins[i - 1] * nums[i], nums[i]));
        }
        return Arrays.stream(maxs).max().getAsInt();
    }
}
