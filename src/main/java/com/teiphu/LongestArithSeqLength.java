package com.teiphu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1027. 最长等差数列
 *
 * @author Zheng Lifu
 */
public class LongestArithSeqLength {

    public static void main(String[] args) {
        // 4,7,10
        int[] a = new int[]{9, 4, 7, 2, 10};
        LongestArithSeqLength lasl = new LongestArithSeqLength();
        int res = lasl.longestArithSeqLength(a);
        System.out.println(res);
    }

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        List<Map<Integer, Integer>> list = new ArrayList<>(A.length);
        list.add(new HashMap<>());
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                Map<Integer, Integer> map1 = list.get(j);
                int t = map1.getOrDefault(d, 1) + 1;
                map.put(d, t);
                if (t > max) {
                    max = t;
                }
            }
            list.add(map);
        }
//        int max = 0;
        /*for (Map<Integer, Integer> map : list) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
        }*/
        return max;
    }

    // 1 3 5 7
    // 2 4 6 8 10
}
