package com.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers gln = new GetLeastNumbers();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        List<Integer> res = gln.getLeastNumbers_Solution(input, k);
        System.out.println(res.toString());

        int[] arr = gln.getLeastNumbers1(input, k);
        System.out.println(Arrays.toString(arr));

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        buildHeap(arr, k);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                buildHeap(arr, k);
            }
        }
        int[] res = Arrays.copyOf(arr, k);
        return res;
    }

    /**
     * 给定一个数组，找出其中最小的K个数。
     * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，
     * 则最小的4个数字是1,2,3,4。
     * 如果K>数组的长度，那么返回一个空的数组
     * <p>
     * 解法：先为前k个数据构建大顶堆，然后再把k个后面的数据逐个和堆顶的数据比较并重构大顶堆
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }

        buildHeap(input, k);
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                swap(input, i, 0);
                buildHeap(input, k);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private void buildHeap(int[] input, int k) {
        // 构建大顶堆
        int beginIndex = (k >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(input, i, k);
        }
    }

    private void maxHeapify(int[] input, int index, int k) {
        int left = (index << 1) + 1;
        if (left >= k) {
            return;
        }
        int right = left + 1;
        int cMax = left;
        if (right < k && input[right] > input[left]) {
            cMax = right;
        }
        if (input[cMax] > input[index]) {
            swap(input, cMax, index);
            maxHeapify(input, cMax, k);
        }
    }

    private void swap(int[] input, int cMin, int i) {
        int t = input[cMin];
        input[cMin] = input[i];
        input[i] = t;
    }
}
