package com.teiphu;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author Zheng Lifu
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> res = ga.groupAnagrams(strs);
        System.out.println(res.toString());

    }

    /**
     * 正解
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String ts = String.valueOf(cs);
            Integer val = map.get(ts);
            if (val == null) {
                map.put(ts, index);
                index++;
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
            } else {
                if (val >= res.size()) {
                    res.add(new ArrayList<>());
                }
                List<String> list = res.get(val);
                if (list == null) {
                    list = new ArrayList<>();
                    res.add(val, list);
                }
                list.add(str);
            }
        }
        return res;
    }
}
