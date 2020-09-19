package com.teiphu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows <= 0) {
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        list.add(cur);
        int size;
        List<Integer> next;
        for (int i = 1; i < numRows; i++) {
            next = new ArrayList<>(cur.size() + 1);
            next.add(1);
            for (int j = 1; j < (size = cur.size()); j++) {
                next.add(cur.get(j - 1) + cur.get(j));
            }
            next.add(1);
            list.add(next);
            cur = next;
        }
        return list;
    }
}
