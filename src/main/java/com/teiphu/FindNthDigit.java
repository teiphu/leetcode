package com.teiphu;

/**
 * @author Lifu.Zheng
 * @data 2018.04.21 12:53
 */
public class FindNthDigit {

    public int findNthDigit(int n) {

        long temp = 0;
        long j = 0, i = 9;
        int surplus;
        int num;
        int l, m, result = 0;
        if (n < 10) {
            return n;
        }
        for (int k = 1; i <= Math.pow(2, 31); i *= 10, k++) {
            temp = temp + i * k;
            j = j + i;
            if (n > temp) {
                continue;
            } else {
                surplus = n - (int) (temp - i * k);
                num = surplus / k;
                m = num + (int)(j - i);
                l = surplus % k;
                if (l  == 0) {
                    result = m % 10;
                } else {
                    String s = Integer.toString(m + 1);
                    char[] chars = s.toCharArray();
                    result = chars[l-1] - 48;
                    /*
                    int[] ints = intParseIntArray(m + 1, k+1);
                    for (int q = 0; i < ints.length; q++) {
                        System.out.println(ints[q]);
                    }
                    if (m == j) {
                        result = ints[l-1];
                    } else {
                        result = ints[l];
                    }*/

                }
                break;
            }
        }
        return result;
    }

    public static int[] intParseIntArray(int n, int len) {
        int[] ints = new int[len];
        for (int i = len-1; n != 0 && i >= 0; i--) {
            ints[i] = n % 10;
            n = n / 10;
        }
        return ints;
    }
}
