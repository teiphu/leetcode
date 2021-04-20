package com.teiphu;

/**
 * 33. 搜索旋转排序数组
 * 解
 *
 * @author Zheng Lifu
 */
public class Search {

    public static void main(String[] args) {
        int[] num =
//                {4, 5, 6, 7, 0, 1, 2};
//                {5, 1, 3};
                {5, 1, 2, 3, 4};
        Search search = new Search();
        for (int i = -2; i < 10; i++) {
            int res = search.search(num, i);
            System.out.println("target: " + i + "; res: " + res);
        }
    }

    /**
     * 二分法解决
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                if (nums[start] < nums[mid]) {
                    start = mid + 1;
                } else if (nums[end] > nums[mid]) {
                    if (nums[end] == target) {
                        return end;
                    } else if (nums[end] > target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    return -1;
                }
            } else {
//                target小于中间值
                if (nums[end] > nums[mid]) {
//                    最高值在左边
                    end = mid - 1;
                } else {
//                    最高值在右边
                    if (nums[start] > target) {
                        start = mid + 1;
                    } else if (nums[start] < target) {
                        end = mid - 1;
                    } else {
                        return start;
                    }
                }
            }
        }
        return -1;
    }
}
