package com.teiphu.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * @author Zheng Lifu
 */
public class PrintNumbers {

    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();
        int[] arr = pn.printNumbers(2);
        System.out.println(Arrays.toString(arr));

    }

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int ten = 10;
        int res = 10;
        for (int i = 1; i < n; i++) {
            res = res * ten;
        }
        res = res - 1;
        int[] arr = new int[res];
        for (int i = 1; i <= res; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }

}
