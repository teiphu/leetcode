package com.teiphu;

/**
 * 523.连续的子数组和
 *
 * @author Zheng Lifu
 */
public class CheckSubarraySum {

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        boolean res = checkSubarraySum(nums, k);
        System.out.println(res);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
//        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            /*list.add(nums[i - 1]);
            for (int j = 0; j < list.size(); j++) {
                list.set(j, list.get(j) + nums[i]);
                if (k == 0) {
                    if (list.get(j) == 0) {
                        return true;
                    }
                } else if (list.get(j) % k == 0) {
                    return true;
                }
            }*/
            int sum = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                sum += nums[j];
                if (k == 0) {
                    if (sum == 0) {
                        return true;
                    }
                } else if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }


}
