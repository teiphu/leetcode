package com.teiphu.sort;

import java.util.Arrays;

/**
 * 堆排序，构建大顶堆
 *
 * @author Zheng Lifu
 */
public class HeapSort {
	private int[] arr;

	public HeapSort(int[] arr) {
		this.arr = arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6
//                , 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6
		};
		new HeapSort(arr).sort();
		System.out.println(Arrays.toString(arr));
	}

	private void sort() {
		int len = arr.length - 1;
		int beginIndex = (arr.length >> 1) - 1;
		for (int i = beginIndex; i >= 0; i--) {
			maxHeapify(i, len);
		}

		for (int i = len; i > 0; i--) {
			swap(0, i);
			maxHeapify(0, i - 1);
		}
	}

	private void maxHeapify(int index, int len) {
		int left = (index << 1) + 1;
		int right = left + 1;
		int cMax = left;
		if (left > len) {
			return;
		}
		if (right <= len && arr[right] > arr[left]) {
			cMax = right;
		}
		if (arr[cMax] > arr[index]) {
			swap(cMax, index);
			maxHeapify(cMax, len);
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
