package com.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * 421. 数组中两个数的最大异或值
 *
 * @author Zheng Lifu
 */
public class FindMaximumXOR {

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        for (int num : nums) {
            System.out.println(Integer.toBinaryString(num));
        }

        String s = "四标四实事项";
//        System.out.println(s.substring(0, s.indexOf('-')));

        Map<String, Integer> map = new HashMap<>();
        map.put(null, 2);
        map.put("zhenglifu", 1);
        System.out.println(map);
    }

    public int findMaximumXOR(int[] nums) {

        return 0;
    }
}
