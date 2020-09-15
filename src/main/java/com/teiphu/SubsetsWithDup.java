package org.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Teiphu
 * @Creation 2018.09.23 21:22
 **/
public class SubsetsWithDup {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(lists, new ArrayList<Integer>(), nums, 0);
        return lists;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList,
                           int[] nums, int start) {

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
