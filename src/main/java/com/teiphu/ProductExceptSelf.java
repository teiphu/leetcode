package com.teiphu;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author Zheng Lifu
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] arr = new int[nums.length];

        arr[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            arr[i] = arr[i + 1] * nums[i + 1];
        }
        int t = 1;
        output[0] = arr[0];
        for (int i = 1; i < nums.length; i++) {
            t = t * nums[i - 1];
            output[i] = t * arr[i];
        }
        return output;
    }
}
