package com.teiphu;

import java.util.*;


/**
 * 78. 子集
 *
 * @author Teiphu
 * @data 2018.08.28 23:19
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets.subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList,
                           int[] nums, int start) {

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }

}
