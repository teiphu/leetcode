package com.teiphu;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @author Zheng Lifu
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        ThreeSumClosest tsc = new ThreeSumClosest();
        int res = tsc.threeSumClosest(nums, target);
        System.out.println(res);
    }

    /**
     * 使用双指针，先定位第一个数，后面两个数按双指针思路
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum;
                if (Math.abs((sum = nums[i] + nums[left] + nums[right]) - target) < Math.abs(closestSum)) {
                    closestSum = sum - target;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }

        return target + closestSum;
    }

}
