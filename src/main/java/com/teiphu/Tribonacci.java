package com.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zheng Lifu
 */
public class Tribonacci {

    private Map<Integer, Integer> t = new HashMap<>();

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        if (t.containsKey(n)) {
            return t.get(n);
        }
        int r = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        t.put(n, r);
        return r;
    }
}
