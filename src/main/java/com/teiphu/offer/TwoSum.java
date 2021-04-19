package com.teiphu.offer;

/**
 * 剑指 Offer 57. 和为s的两个数字
 *
 * @author Zheng Lifu
 */
public class TwoSum {

	/**
	 * 前后双指针向中间靠拢
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int end = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < target) {
				end = i;
				break;
			}
		}
		int start = 0;

		while (start < end) {
			if (nums[start] + nums[end] == target) {
				return new int[]{nums[start], nums[end]};
			} else if (nums[start] + nums[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		return new int[0];
	}
}
