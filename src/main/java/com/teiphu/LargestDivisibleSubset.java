package com.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 *
 * @author Zheng Lifu
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset lds = new LargestDivisibleSubset();
        int[] num = {1, 2, 3, 9};
        lds.largestDivisibleSubset(num);

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int[] pre = new int[nums.length];
        pre[0] = -1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] > max) {
                    max = dp[j];
                    pre[i] = j;
                }
            }
            if (max == 0) {
                pre[i] = -1;
            }
            dp[i] = max + 1;
        }
        int max = -1;
        int p = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                p = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (pre[p] != -1) {
            list.add(nums[p]);
            p = pre[p];
        }
        list.add(nums[p]);
        return list;
    }
}
