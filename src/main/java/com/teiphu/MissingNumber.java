package com.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * 268. 丢失的数字
 *
 * @author Zheng Lifu
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        MissingNumber mn = new MissingNumber();
        int res = mn.missingNumber(nums);
        System.out.println(res);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "ZhengLifu");
        System.out.println(map.toString());

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "ZhengLifu");
        System.out.println(map1.toString());

    }

    public int missingNumber(int[] nums) {
        boolean b = false;
        int index = -1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == nums.length) {
                b = true;
                index = i;
                i++;
            } else if (nums[i] != i && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        if (!b) {
            return nums.length;
        } else {
            return index;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
