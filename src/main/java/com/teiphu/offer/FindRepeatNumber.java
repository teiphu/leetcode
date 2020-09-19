package com.teiphu.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * @author Zheng Lifu
 */
public class FindRepeatNumber {

    /**
     * 细读题目
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int t = nums[i];
                nums[i] = nums[nums[i]];
                nums[t] = t;
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
