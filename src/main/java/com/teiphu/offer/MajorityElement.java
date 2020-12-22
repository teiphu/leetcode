package com.teiphu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * @author Zheng Lifu
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int mid = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mid) {
                return entry.getKey();
            }
        }
        return -1;
    }
}


