package com.teiphu;

public class TwoSum {

	public static void main(String[] args) {

	}

	public static int[] twoSum(int[] nums, int target) {
		int start = 0;
		int end;
		int N = nums.length;
		end = N - 1;
		while (target != (nums[start] + nums[end])) {
			if (nums[end] >= target) {
				end--;
				continue;
			}
			if ((nums[start] + nums[end]) < target) {
				start++;
			} else if ((nums[start] + nums[end]) > target) {
				end--;
			}
		}
		int[] res = new int[2];
		res[0] = start;
		res[1] = end;
		return res;
	}

}
