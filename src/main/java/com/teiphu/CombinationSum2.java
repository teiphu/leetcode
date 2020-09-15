package org.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @Author Teiphu
 * @Creation 2018.09.23 23:29
 **/
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists.size());
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        backtrack(lists, tempList, candidates, target, 0);
        return lists;
    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> tempList,
                                  int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > 0 && i - 1 >= start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                backtrack(lists, tempList, candidates, remain - candidates[i],
                        i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
