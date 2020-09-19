package com.teiphu;

import java.util.Arrays;

/**
 * 891. 子序列宽度之和
 */
public class SumSubseqWidths {

    public static void main(String[] args) {
        int[] A = {2, 1, 3, 5, 9};
        System.out.println(sumSubseqWidths0(A));
        System.out.println(sumSubseqWidths1(A));
    }

    public static int sumSubseqWidths0(int[] A) {
        Arrays.sort(A);
        long c = 1;
        long res = 0;
        long mod = (long) 1e9 + 7;
        for (int i = 0; i < A.length; ++i, c = (c << 1) % mod) {
            res = (res + A[i] * c - A[A.length - i - 1] * c) % mod;
        }

        return (int) ((res + mod) % mod);
    }

    public static int sumSubseqWidths1(int[] A) {
        Arrays.sort(A);
        long c = 1;
        long res = 0;
        int n = A.length;
        for (int i = 0; i < n; i++, c = c * 2) {
            System.out.println("i = " + i);
            System.out.println(n - i - 1);
            res += A[i] * c - A[n - i - 1] * c;
        }
        return (int) res;
    }

    public static int sumSubseqWidths(int[] A) {
        int n = A.length;
        long res = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            max = min = A[i];
            System.out.println(max);
            System.out.println(min);
            for (int j = i + 1; j < n; j++) {
                System.out.println("A[j] = " + A[j]);
                if (A[j] < min) {
                    min = A[j];
                } else if (A[j] > max) {
                    max = A[j];
                }
                System.out.println(max);
                System.out.println(min);
                System.out.println("max - min = " + (max - min));
                res += max - min;
                System.out.println();
            }
        }
        return (int) (res % 1000000007);
    }

}
