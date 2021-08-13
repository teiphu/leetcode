package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 5;
        SearchInsert si = new SearchInsert();
        si.searchInsert(arr, target);
    }

    public int searchInsert(int[] nums, int target) {
        int mid = (nums.length >> 2);
        System.out.println(mid);

        return -1;
    }
}
