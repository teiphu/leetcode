package com.teiphu;

import java.util.*;

/**
 * 560. 和为K的子数组
 * 解
 *
 * @author Zheng Lifu
 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        SubarraySum ss = new SubarraySum();
        System.out.println(ss.subarraySum1(nums, k));

        int[] arr = new int[10];
        System.out.println(arr.length);

    }

    /**
     * 前缀和算法
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        /*for (int left = 0; left < len; left++) {
            for (int right = left + 1; right <= len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right] - preSum[left] == k) {
                    count++;
                }
            }
        }*/
        // 优化
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set0 = new HashSet<>();
        set0.add(0);
        map.put(0, set0);
        for (int i = 1; i < preSum.length; i++) {
            int n = preSum[i];
            int diff = preSum[i] - k;
            Set<Integer> set;
            if ((set = map.get(diff)) != null) {
                count += set.size();
            }

            if ((set = map.get(n)) != null) {
                set.add(i);
            } else {
                set = new HashSet<>();
                set.add(i);
                map.put(n, set);
            }
        }
        return count;
    }

    /**
     * 超出时间限制
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len);
        for (int num : nums) {
            List<Integer> list2 = new ArrayList<>(len);
            if (num == k) {
                count++;
            }
            list2.add(num);
            for (Integer integer : list) {
                int n = integer + num;
                if (n == k) {
                    count++;
                }
                list2.add(n);
            }
            list = list2;
        }
        return count;
    }

}
