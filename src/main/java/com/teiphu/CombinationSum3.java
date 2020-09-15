package org.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Teiphu
 * @Creation 2018.09.23 14:43
 **/
public class CombinationSum3 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), k, n, 1);
        return lists;
    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> tempList,
                                  int k, int remain, int start) {
        if (remain == 0 && k == 0) {
            lists.add(new ArrayList<>(tempList));
            return;
        } else if (remain < 0 || k < 0) {
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(lists, tempList, k - 1, remain - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
