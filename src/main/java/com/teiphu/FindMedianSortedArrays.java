package com.teiphu;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @Author Teiphu
 * @Creation 2018.10.11 11:50
 **/
public class FindMedianSortedArrays {

	public static void main(String[] args) {
		FindMedianSortedArrays fmsa = new FindMedianSortedArrays();
		int[] nums1 = {};
		int[] nums2 = {};
		double res = fmsa.findMedianSortedArrays(nums1, nums2);
		System.out.println(res);
	}

    /**
     * n的时间复杂度
     * @param nums1
     * @param nums2
     * @return
     */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int len = len1 + len2;
		int mid = len / 2;
		if (len == 0) {
			return 0;
		}

		int cur = 0;
		int pre = 0;
		for (int i = 0, j = 0, k = 0; i <= mid; i++) {
			pre = cur;
			if (j >= len1) {
				cur = nums2[k];
				k++;
				continue;
			} else if (k >= len2) {
				cur = nums1[j];
				j++;
				continue;
			}
			if (nums1[j] <= nums2[k]) {
				cur = nums1[j];
				j++;
			} else {
				cur = nums2[k];
				k++;
			}
		}
		double res;
		if (len % 2 == 0) {
			res = (pre + cur) / 2.0;
		} else {
			res = cur;
		}
		return res;
	}

	public static double findMedianSortedArrays0(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int len = len1 + len2;
		int mid = (len - 1) / 2;
		int i = 0, j = 0, k = 0;
		int[] nums = new int[len];
		double[] medians = new double[2];
		if (len1 == 0 && len2 == 0) {
			return 0;
		} else if (len1 == 0 && len2 != 0) {
			return findMedian(nums2, len2);
		} else if (len2 == 0 && len1 != 0) {
			return findMedian(nums1, len1);
		}
		for (i = 0; i < len; i++) {
			if (nums1[j] <= nums2[k]) {
				nums[i] = nums1[j];
				j++;
			} else {
				nums[i] = nums2[k];
				k++;
			}
			if (i == mid) {
				medians[0] = nums[i];
			} else if (i == mid + 1) {
				medians[1] = nums[i];
				i++;
				break;
			}
			if (j >= len1 || k >= len2) {
				i++;
				break;
			}
		}
		if (i <= mid + 1) {
			if (j < len1) {
				for (; i < len; i++, j++) {
					nums[i] = nums1[j];
					if (i == mid) {
						medians[0] = nums[i];
					} else if (i == mid + 1) {
						medians[1] = nums[i];
						break;
					}
				}
			} else if (k < len2) {
				for (; i < len; i++, k++) {
					nums[i] = nums2[k];
					if (i == mid) {
						medians[0] = nums[i];
					} else if (i == mid + 1) {
						medians[1] = nums[i];
						break;
					}
				}
			}
		}
		if (len % 2 == 1) {
			return medians[0];
		} else {
			return (medians[0] + medians[1]) / 2;
		}
	}

	private static double findMedian(int[] nums, int len) {
		double med;
		if (len % 2 == 0) {
			med = ((double) nums[len / 2 - 1] + (double) nums[len / 2]) / 2;
		} else {
			med = nums[len / 2];
		}
		return med;
	}
}
