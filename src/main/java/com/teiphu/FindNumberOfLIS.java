package com.teiphu;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数
 *
 * @author Zheng Lifu
 */
public class FindNumberOfLIS {

    public static void main(String[] args) {
        FindNumberOfLIS fnolis = new FindNumberOfLIS();
        int[] nums = new int[]{1, 3, 5, 4, 7};
        nums = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
//        nums = new int[]{1, 1, 1, 1, 1, 1};
        int res = fnolis.findNumberOfLIS(nums);

        System.out.println(res);
    }

    /*public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int[] n = new int[nums.length];
        n[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && n[j] > max) {
                    dp[i] = j;
                    max = n[j];
                }
            }
            n[i] = max + 1;
        }
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n.length; i++) {
            if (n[i] > max) {
                max = n[i];
                set.clear();
                set.add(i);
            } else if (n[i] == max) {
                set.add(i);
            }
        }
        return set.size();
    }*/

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] n = new int[nums.length];
        n[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (n[j] > max) {
                        max = n[j];
                        dp[i] = dp[j];
                    } else if (n[j] == max) {
                        dp[i] += dp[j];
                    }
                }
            }
            n[i] = max + 1;
        }
        int max = -1;
        int res = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] > max) {
                max = n[i];
                res = dp[i];
            } else if (n[i] == max) {
                res += dp[i];
            }
        }
        return res;


        /*int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n.length; i++) {
            if (n[i] > max) {
                max = n[i];
                set.clear();
                set.add(i);
            } else if (n[i] == max) {
                set.add(i);
            }
        }
        int res = 0;
        for (Integer i : set) {
            res += dp[i];
        }
        return res;*/
    }
}
