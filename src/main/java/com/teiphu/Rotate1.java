package com.teiphu;

/**
 * 189. 旋转数组
 *
 * @author Zheng Lifu
 */
public class Rotate1 {

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int t = nums[nums.length - 1];
//            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = t;
        }
    }

    //    需要想出更好的解决方案
    public void rotate1(int[] nums, int k) {

    }
}
