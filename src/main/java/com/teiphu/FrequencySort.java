package com.teiphu;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 451. 根据字符出现频率排序
 *
 * @Author Teiphu
 * @Creation 2018.10.04 17:28
 **/
public class FrequencySort {

    public static void main(String[] args) {
        System.out.println(frequencySort("ZhengLifu"));

    }

    public static String frequencySort(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> queue =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry entry : map.entrySet()) {
            queue.offer(entry);
        }

        StringBuilder sb = new StringBuilder();

        while (queue.size() != 0) {
            Map.Entry<Character, Integer> entry = queue.poll();
            char ch = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(ch);
            }
        }
        String str = sb.toString();
        return str;
    }
}
