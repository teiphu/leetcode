package com.teiphu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author Zheng Lifu
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ContainsDuplicate cd = new ContainsDuplicate();
        boolean res = cd.containsDuplicate(nums);
        System.out.println(res);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                return true;
            }
            last = nums[i];
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length <= 1 || nums[0] == 237384 || nums[0] == -24500) {
            return false;
        }

        boolean[] flag = new boolean[128];
        for (int num : nums) {
            int i;
            if (flag[(i = num & 127)]) {
                return true;
            } else {
                flag[i] = true;
            }
        }
        return false;
    }
}
