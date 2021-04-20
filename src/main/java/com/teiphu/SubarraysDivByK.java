package com.teiphu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 974. 和可被 K 整除的子数组
 *
 * @author Zheng Lifu
 */
public class SubarraysDivByK {

    public int subarraysDivByK(int[] nums, int K) {
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
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set0 = new HashSet<>();
        set0.add(0);
        map.put(0, set0);
        for (int i = 1; i < preSum.length; i++) {
            int n = preSum[i];
            int diff = preSum[i] - K;
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
}
