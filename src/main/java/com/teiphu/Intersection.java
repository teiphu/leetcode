package com.teiphu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author Zheng Lifu
 */
public class Intersection {

	public static void main(String[] args) {
		Intersection intersection = new Intersection();
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};
		int[] arr = intersection.intersection(nums1, nums2);
		System.out.println(Arrays.toString(arr));
	}

	public int[] intersection(int[] nums1, int[] nums2) {
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
		int[] arr = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		int i = 0;
		while (it.hasNext()) {
			arr[i++] = it.next();
		}
		return arr;
	}
}
