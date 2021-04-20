package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class SearchRange {

    /**
     * O(n)的时间复杂度
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return new int[]{start, end};
    }

    public int[] searchRange1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while (end - start > 1) {
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                break;
            }
            mid = start + (end - start) / 2;
        }
        int s = -1;
        int e = -1;
        for (int i = mid; i > start; i--) {
            if (nums[i] != target) {
                s = i + 1;
                break;
            }
        }
        for (int i = start; i < end; i++) {
            if (nums[i] != target) {
                e = i -1;
                break;
            }
        }
        return new int[]{s, e};
    }

    public static void main(String[] args) {
        int start = 3;
        int end = 5;
        int mid = start + (end - start) / 2;
        System.out.println(mid);
    }
}
