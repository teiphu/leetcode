package com.teiphu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author ZhengLifu
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		TwoSum ts = new TwoSum();
		int[] res = ts.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}

	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int t = target - numbers[i];
			if (map.containsKey(t)) {
				return new int[]{map.get(t) + 1, i + 1};
			} else {
				map.put(numbers[i], i);
			}
		}
		return new int[0];
	}

	/**
	 * 暴力法题解
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum0(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == diff) {
					return new int[]{i, j};
				}
			}
		}
		return new int[2];
	}

	public int[] twoSum1(int[] nums, int target) {
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
