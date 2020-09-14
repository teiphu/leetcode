package com.teiphu;

/**
 * 面试题 10.01. 合并排序的数组
 *
 * @author : ZhengLifu
 */
public class Merge {

    public void merge(int[] A, int m, int[] B, int n) {

        int len = m + n;
        for (int i = len - 1, j = m - 1, k = n - 1; i >= 0; i--) {
            if (j < 0) {
                A[i] = B[k--];
                continue;
            }
            if (k < 0) {
                A[i] = A[j--];
                continue;
            }
            if (A[j] >= B[k]) {
                A[i] = A[j--];
            } else {
                A[i] = B[k--];
            }
        }

    }

}
