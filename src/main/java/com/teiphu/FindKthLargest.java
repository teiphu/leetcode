package com.teiphu;

import java.util.Arrays;

public class FindKthLargest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] nums = {3,2,1,5,6,4};
		System.out.println(findKthLargest1(nums, 2));
	}
	
	public static int findKthLargest0(int[] nums, int k) {
		
		Arrays.sort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
		return nums[nums.length - k];
	}
	
	public static int findKthLargest(int[] nums, int k) {
		int temp;
		int len = nums.length;
		for (int i = 0; i < k; i++, len--) {
			int max = 0;
			for (int j = 1; j < len; j++) {
				if (nums[j] > nums[max]) {
					max = j;
				}
			}
			temp = nums[max];
			nums[max] = nums[len-1];
			nums[len - 1] = temp;
		}
		return nums[nums.length - k];
	}
	
	/**
	 * �ȿ�����������
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest1(int[] nums, int k) {
		Sort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
		return nums[nums.length - k];
	}
	
	private static void Sort(int[] nums) {
		int N = nums.length;
		quickSort(nums, 0, N-1);
	}
	
	private static void quickSort(int[] nums, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int index = partition(nums, lo, hi);
		quickSort(nums, lo, index - 1);
		quickSort(nums, index + 1, hi);
	}

	private static int partition(int[] nums, int lo, int hi) {
		// TODO �Զ����ɵķ������
		int i = lo;
		int j = hi+1;
		int v = nums[lo];
		while (true) {
			while (nums[++i] < v) {
				if (i == hi) {
					break;
				}
			}
			while (nums[--j] > v) {
				if (j == lo) {
					break;
				}
//				j--;
			}
			if (i >= j) {
				break;
			}
			exchge(nums, i, j);
		}
		exchge(nums, lo, j);
		return j;
	}
	
	private static void exchge(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

}












