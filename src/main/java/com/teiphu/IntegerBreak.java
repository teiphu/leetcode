package com.teiphu;

/**
 * @Author Teiphu
 * @Creation 2018.09.21 22:03
 **/
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

    private static int integerBreak0(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        if (n == 1) {
            return n;
        }
        int rest = n;
        int i = 0;
        for (i = 1; rest >= i + 1; i++) {
            arr[i] = arr[i-1] + 1;
            rest = rest - arr[i];
        }
        if (rest > 0) {
            if (rest == i) {
                arr[i-1]++;
            }
            for (int j = i-1; rest > 0; j--) {
                arr[j]++;
                rest--;
            }
        }
        int res = 1;
        for (int j = 1; j < i; j++) {
            res = res * arr[j];
        }
        return res;
    }
}
