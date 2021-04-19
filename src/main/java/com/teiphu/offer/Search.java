package com.teiphu.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author Zheng Lifu
 */
public class Search {

	public static void main(String[] args) {
		Search search = new Search();
		search.search(new int[]{5, 7, 7, 8, 8, 10}, 11);

	}

	/**
	 * 先二分查找目标值
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = start + ((end - start) >> 1);
		while (start <= end) {
			if (nums[mid] < target) {
				start = mid + 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				break;
			}
			mid = start + ((end - start) >> 1);
		}
		int count = 0;
		if (start <= end) {
			for (int i = start; i <= end; i++) {
				if (nums[i] == target) {
					count++;
				}
			}
		}
		return count;
	}

}
