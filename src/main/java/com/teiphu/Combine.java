package com.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Teiphu
 * @Creation 2018.09.23 14:34
 **/
public class Combine {

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), n, k, 1);
        return lists;
    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> tempList,
                                  int n, int remain, int start) {
        if (remain == 0) {
            lists.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = start; i <= n; i++) {
                tempList.add(i);
                backtrack(lists, tempList, n, remain - 1, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
