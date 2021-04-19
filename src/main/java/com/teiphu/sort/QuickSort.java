package com.teiphu.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Zheng Lifu
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {9, 6, 4, 4, 7, 8, 5, 3, 2, 6, 7, 9, 5, 6};
		QuickSort qs = new QuickSort();
		qs.qSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private void qSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int index = partition(arr, left, right);
		qSort(arr, left, index - 1);
		qSort(arr, index + 1, right);
	}

	private int partition(int[] arr, int left, int right) {
		// 左右扫描指针
		int i = left;
		int j = right + 1;
		int v = arr[left];  // 切分元素
		while (true) {
			// 扫描左右，检查扫描是否结束并交换元素
			while (arr[++i] < v) {
				if (i == right) {
					break;
				}
			}
			while (v < arr[--j]) {
				if (j == left) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(arr, i, j);
		}
		exch(arr, left, j); // 将v = arr[j]放入正确的位置
		return j;
	}

	private void exch(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
