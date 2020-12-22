package com.teiphu.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * @author Zheng Lifu
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqChar fuc = new FirstUniqChar();
        int res = fuc.firstUniqChar0(s);
        System.out.println(res);

    }

    /**
     * 387. 字符串中的第一个唯一字符
     * @param s
     * @return
     */
    public int firstUniqChar0(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                set.add(map.get(ch));
                set.add(i);
            }
            map.put(ch, i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
