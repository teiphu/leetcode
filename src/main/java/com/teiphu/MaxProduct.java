package com.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 152.乘积最大子数组
 *
 * @author Zheng Lifu
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        MaxProduct mp = new MaxProduct();
        int res = mp.maxProduct2(nums);
        System.out.println(res);

    }

    public int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = i; j >= 0; j--) {
                sum *= nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 优化
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        List<Integer> list = new ArrayList<>();
        list.add(max);
        for (int i = 1; i < nums.length; i++) {
            List<Integer> t = new ArrayList<>();
            if (nums[i] > max) {
                max = nums[i];
            }
            t.add(nums[i]);
            for (Integer integer : list) {
                int i1 = integer * nums[i];
                if (i1 > max) {
                    max = i1;
                }
                t.add(i1);
            }
            list = t;
        }
        return max;
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
