package com.teiphu;

import java.util.*;

/**
 * 15. 三数之和
 * <p>
 * 待优化
 *
 * @author Zheng Lifu
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> lists = ts.threeSum(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> negativeNum = new HashMap<>();
        Map<Integer, Integer> positiveNum = new HashMap<>();

        int zeroNum = 0;

        for (int num : nums) {
            if (num < 0) {
                negativeNum.put(num, negativeNum.getOrDefault(num, 0) + 1);
            } else if (num > 0) {
                positiveNum.put(num, positiveNum.getOrDefault(num, 0) + 1);
            } else {
                zeroNum++;
            }
        }
        if (zeroNum >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add(list);
        }
        Set<Integer> posNums = positiveNum.keySet();
        Set<Integer> negNums = negativeNum.keySet();
        if (zeroNum > 0) {
            for (Integer positive : posNums) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(positive);
                if (negNums.contains(-positive)) {
                    list.add(-positive);
                    res.add(list);
                }
            }
        }


        Map<Integer, List<Integer>> map = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : negativeNum.entrySet()) {
            if (entry.getValue() >= 2) {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(entry.getKey());
                map.put(entry.getKey() * 2, list);
            }
        }
        for (Map.Entry<Integer, Integer> entry : positiveNum.entrySet()) {
            if (entry.getValue() >= 2) {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(entry.getKey());
                map.put(entry.getKey() * 2, list);
            }
        }

        Set<Integer> set = new HashSet<>();
        set.addAll(posNums);
        set.addAll(negNums);
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i);
            if (m != 0) {
                for (int j = i + 1; j < list.size(); j++) {
                    int n = list.get(j);
                    if ((m > 0 && n > 0) || (m < 0 && n < 0)) {
                        List<Integer> list1 = map.get(m + n);
                        if (list1 == null) {
                            list1 = new ArrayList<>();
                            list1.add(m);
                            list1.add(n);
                            map.put(m + n, list1);
                        } else {
                            list1.add(m);
                            list1.add(n);
                        }
                    }
                }
            }
        }

        for (int posi : set) {
            List<Integer> list2;
            if ((list2 = map.get(-posi)) != null) {
                for (int i = 0; i < list2.size(); i = i + 2) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(posi);
                    list1.add(list2.get(i));
                    list1.add(list2.get(i + 1));
                    res.add(list1);
                }
            }
        }
        return res;
    }
}
