package com.teiphu.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 47.全排列II
 * @author Zheng Lifu
 */
public class PermuteUnique {

    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        permuteUnique(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        helper(map, new ArrayList<>());
        return res;
    }

    private static void helper(HashMap<Integer, Integer> map, ArrayList<Integer> list) {
        if (map.isEmpty()) {
            res.add(list);
            return;
        }
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
            list1.add(i);
            HashMap<Integer, Integer> map1 = (HashMap<Integer, Integer>) map.clone();
            int value;
            if ((value = map1.get(i)) == 1) {
                map1.remove(i);
            } else {
                map1.put(i, value - 1);
            }
            helper(map1, list1);
        }
    }
}
