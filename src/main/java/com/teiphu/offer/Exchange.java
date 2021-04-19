package com.teiphu.offer;


/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * @author Zheng Lifu
 */
public class Exchange {

	public static void main(String[] args) {
		Exchange e = new Exchange();
		e.exchange(new int[]{1, 2, 3, 4});
	}

	public int[] exchange(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			while (nums[i] % 2 == 1) {
				i++;
				if (i >= nums.length - 1) {
					break;
				}
			}
			while (nums[j] % 2 != 1) {
				j--;
				if (j <= 0) {
					break;
				}
			}
			if (i < j) {
				swap(nums, i, j);
			}
		}
		return nums;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}


}
