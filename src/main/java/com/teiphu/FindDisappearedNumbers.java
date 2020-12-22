package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @author Zheng Lifu
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDisappearedNumbers fdn = new FindDisappearedNumbers();
        List<Integer> res = fdn.findDisappearedNumbers(nums);
        System.out.println(res);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                list.add(i + 1);
            }
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
