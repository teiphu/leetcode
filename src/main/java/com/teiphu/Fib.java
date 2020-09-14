package com.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zheng Lifu
 */
public class Fib {

    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Fib fib = new Fib();
        long start = System.currentTimeMillis();
        int res = fib.fib(45);
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);

    }

    public int fib(int n) {
        /*if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = fib(n - 1) + fib(n - 2);
        map.put(n, res);
        return res;*/
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
