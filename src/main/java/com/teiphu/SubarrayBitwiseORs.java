package com.teiphu;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Teiphu
 * @Creation 2018.09.21 15:11
 **/
public class SubarrayBitwiseORs {

    public static void main(String[] args) {
        int[] A = {1, 2, 4};
        System.out.println(subarrayBitwiseORs(A));
    }


    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        Set<Integer> cur2;
        for (Integer i : A) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (Integer j : cur) {
                cur2.add(i|j);
            }
            cur = cur2;
            res.addAll(cur);
        }
        return res.size();
    }

}
