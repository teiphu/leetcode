package com.teiphu;

import java.util.*;

/**
 * 46. 全排列
 *
 * @Author Teiphu
 * @Creation 2018.09.22 19:42
 **/
public class Permute {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute0(nums);
        System.out.println();
        for (List<Integer> list : lists) {
            System.out.println(list);
        }


    }

    public static List<List<Integer>> permute1(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        int i = 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[i]);
        queue.add(list);
        int size = queue.size();
        i = i + 1;
        while (i < nums.length) {
            List<Integer> l = queue.poll();
            int len = l.size();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= len; j++) {

                l.add(j, i);
                queue.add(l);

            }
        }
        return null;
    }

    /**
     * 广度优先搜索
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute0(int[] nums) {

        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            queue.offer(list);
        }
        for (int i = 1; i < nums.length; i++) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                List<Integer> l = queue.remove();
                for (int k = 0; k < nums.length; k++) {
                    if (l.contains(nums[k])) {
                        continue;
                    } else {
                        List<Integer> li = new ArrayList<>(l);
                        li.add(nums[k]);
                        queue.offer(li);
                    }
                }

            }
        }
        List<List<Integer>> lists = new ArrayList<>(queue);
        return lists;

    }

    /**
     * 深度优先搜索
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(lists, new ArrayList<>(), nums);
        return lists;
    }

    private static void backtrack(List<List<Integer>> lists,
                                  List<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;   // element already exists, skip
                }
                tempList.add(nums[i]);
                backtrack(lists, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
