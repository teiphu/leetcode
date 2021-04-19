package com.teiphu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 350. 两个数组的交集 II
 *
 * @author Zheng Lifu
 */
public class IntersectionII {

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		Set<Integer> set = new HashSet<>();
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}
		return null;
	}
}
