package com.teiphu;

import java.util.Arrays;

/**
 * 面试题 17.14. 最小K个数
 * 解决方案：使用堆排序，构建小顶堆
 *
 * @author Zheng Lifu
 */
public class SmallestK {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        SmallestK smallestK = new SmallestK();
        int[] res = smallestK.smallestK(arr, k);
        System.out.println(Arrays.toString(res));
    }

    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        if (k <= 0) {
            return new int[0];
        }
        int len = arr.length - 1;
        int beginIndex = (arr.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            minHeapify(arr, i, len);
        }

        int[] res = new int[k];
        for (int i = len, j = 0; j < k; i--, j++) {
            res[j] = arr[0];
            swap(arr, 0, i);
            minHeapify(arr, 0, i - 1);
        }
        return res;
    }

    private void minHeapify(int[] arr, int index, int len) {
        int left = (index << 1) + 1;
        int right = left + 1;
        int cMin = left;
        if (left > len) {
            return;
        }

        if (right <= len && arr[right] < arr[left]) {
            cMin = right;
        }
        if (arr[cMin] < arr[index]) {
            swap(arr, cMin, index);
            minHeapify(arr, cMin, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
