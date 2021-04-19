package com.teiphu.offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * @author Zheng Lifu
 */
public class MissingNumber {

	public int missingNumber(int[] nums) {
		if (nums[nums.length - 1] == nums.length - 1) {
			return nums.length;
		}
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != i) {
				break;
			}
		}
		return i;
	}
}
