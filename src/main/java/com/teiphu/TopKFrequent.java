package com.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * 347. 前 K 个高频元素
 *
 * @author Zheng Lifu
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        topKFrequent(nums, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map.toString());
        return null;
    }
}
