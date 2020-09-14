package com.teiphu;

/**
 * @author : ZhengLifu
 */
public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(lastRemaining0(5, 3));

    }

    public static int lastRemaining0(int n, int m) {

        return helper(0, n, m - 1);
    }

    public static int lastRemaining(int n, int m) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int remain = n;
        int j = 0;
        int val = -1;
        for (int i = 1; i <= m; i++) {

            if (j == n) {
                j = 0;
            }
            while (arr[j] == -1) {
                j++;
                if (j == n) {
                    j = 0;
                }
            }
            if (i == m) {
                val = arr[j];
                arr[j] = -1;
                remain--;
                i = 0;
            }
            if (remain == 0) {
                break;
            }
            j++;

        }
        return val;


    }

    static int helper(int start, int n, int m) {
        if (n == 1) {
            return 0;
        }
        int del = (start + m) % n;
        int subRes = helper(del, n - 1, m);
        if (subRes >= del) {
            return subRes + 1;
        }
        return subRes;
    }


}
