package com.teiphu;

/**
 * @Author Teiphu
 * @Creation 2018.10.11 11:49
 **/
public class IntParseIntArray {
    public static int[] intParseIntArray(int n, int len) {
        int[] ints = new int[len];
        for (int i = len - 1; n != 0 && i >= 0; i--) {
            ints[i] = n % 10;
            n = n / 10;
        }
        return ints;
    }
}
