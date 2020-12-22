package com.teiphu;

import java.util.Arrays;

/**
 * 1. 两数之和
 *
 * @author ZhengLifu
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum0(nums, target);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 暴力法题解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == diff) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end;
        int N = nums.length;
        end = N - 1;
        while (target != (nums[start] + nums[end])) {
            if (nums[end] >= target) {
                end--;
                continue;
            }
            if ((nums[start] + nums[end]) < target) {
                start++;
            } else if ((nums[start] + nums[end]) > target) {
                end--;
            }
        }
        int[] res = new int[2];
        res[0] = start;
        res[1] = end;
        return res;
    }

}
