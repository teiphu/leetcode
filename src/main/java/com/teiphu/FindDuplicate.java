package com.teiphu;


/**
 * 287. 寻找重复数
 * 0 1 2 3 4 5
 *
 * @author Zheng Lifu
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        FindDuplicate fd = new FindDuplicate();
        int res = fd.findDuplicate(nums);
        System.out.println(res);
    }

    /**
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n^2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     *
     * @param nums
     * @return
     */
    public int findDuplicate0(int[] nums) {

        return -1;
    }

    /**
     * 有修改数组
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            swap(nums, 0, nums[0]);
        }
        return nums[0];
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
