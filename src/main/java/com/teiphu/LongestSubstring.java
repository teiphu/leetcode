package com.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有K个重复字符的最长子串
 *
 * @author Zheng Lifu
 */
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        int res = ls.longestSubstring("ababacb", 3);
        System.out.println(res);
    }

    /**
     * 误解
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            Integer val;
            if ((val = map.get(c)) == null) {
                map.put(c, 1);
            } else {
                map.put(c, val + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= k) {
                res += entry.getValue();
            }
        }

        /*Collection<Integer> list = map.values();
        for (Integer i : list) {
            if (i >= k) {
                res += i;
            }
        }*/
        return res;
    }
}
