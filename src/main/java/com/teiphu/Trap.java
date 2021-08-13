package com.teiphu;

/**
 * 面试题 17.21. 直方图的水量
 * 42. 接雨水
 *
 * @author Zheng Lifu
 */
public class Trap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap t = new Trap();
        System.out.println(t.trap(height));
    }

    public int trap(int[] height) {
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];

        int leftMax = -1;
        int rightMax = -1;
        for (int i = 0; i < height.length; i++) {
            leftArr[i] = leftMax;
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            rightArr[i] = rightMax;
            if (height[i] > rightMax) {
                rightMax = height[i];
            }
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (leftArr[i] > height[i] && rightArr[i] > height[i]) {
                res += Math.min(leftArr[i], rightArr[i]) - height[i];
            }
        }
        return res;
    }

    public int trap0(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int total = 0;
        int temp = 0;
        int topIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[topIndex]) {
                temp += height[topIndex] - height[i];
            } else {
                total += temp;
                temp = 0;
                topIndex = i;
            }
        }
        if (temp != 0) {
            temp = 0;
            int rTopIndex = height.length - 1;
            for (int i = height.length - 2; i >= topIndex; i--) {
                if (height[i] < height[rTopIndex]) {
                    temp += height[rTopIndex] - height[i];
                } else {
                    total += temp;
                    temp = 0;
                    rTopIndex = i;
                }
            }
        }
        return total;
    }
}
