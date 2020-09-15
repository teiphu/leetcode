package org.teiphu;

import java.util.*;

/**
 * @Author Teiphu
 * @Creation 2018.09.23 15:18
 **/
public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println();
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println();
        Set<List<Integer>> set = new HashSet<>(lists);
        for (List<Integer> list : set) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(lists, new ArrayList<>(), nums, 0);
        Set<List<Integer>> set = new HashSet<>(lists);
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    private static void backtrack(List<List<Integer>> lists,
                                  List<Integer> tempList, int[] nums, int index) {

        if (tempList.size() == nums.length) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]) && i <= index) {
                    continue; // element already exists, skip
                }
                tempList.add(nums[i]);
                backtrack(lists, tempList, nums, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
