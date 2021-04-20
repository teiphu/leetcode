package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 713. 乘积小于K的子数组
 *
 * @author Zheng Lifu
 */
public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        NumSubarrayProductLessThanK nspltk = new NumSubarrayProductLessThanK();
        int count = nspltk.numSubarrayProductLessThanK(nums, k);
        System.out.println(count);

    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int count = 0;
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len);
        for (int num : nums) {
            List<Integer> list2 = new ArrayList<>(len);
            if (num < k) {
                count++;
            }
            list2.add(num);
            for (Integer integer : list) {
                int n = integer * num;
                if (n < k) {
                    count++;
                    list2.add(n);
                }
            }
            list = list2;
        }

        return count;
    }

}
