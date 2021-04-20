package com.teiphu;

/**
 * 11. 盛最多水的容器
 *
 * @author Zheng Lifu
 */
public class MaxArea {

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = ma.maxArea(height);
        System.out.println(max);
    }

    /**
     * 双指针思路
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int max = (Math.min(height[start], height[end])) * (end - start);
        while (start < end) {
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
            max = Math.max((Math.min(height[start], height[end])) * (end - start), max);
        }
        return max;
    }

}
