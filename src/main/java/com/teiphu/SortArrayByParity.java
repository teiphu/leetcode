package com.teiphu;

/**
 * 905. 按奇偶校验排序数组
 *
 * @Author Teiphu
 * @Creation 2018.10.11 11:29
 **/
public class SortArrayByParity {

    public int[] sortArrayByParity0(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while ((A[i] & 1) == 0 && i < j) {
                i++;
            }
            while ((A[j] & 1) == 1 && j > i) {
                j--;
            }
            if (i < j) {
                swap(A, i, j);
            } else {
                break;
            }
        }
        return A;
    }

    public int[] sortArrayByParity(int[] A) {
        int i = -1;
        int j = 0;
        int n = A.length;
        while (j < n) {
            if ((A[j] & 1) == 0) {
                i++;
                swap(A, i, j);
            }
            j++;
        }
        return A;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
