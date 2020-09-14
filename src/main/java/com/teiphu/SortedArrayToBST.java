package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class SortedArrayToBST {

    /**
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = ((nums.length - 1) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        buildTree(root, nums, 0, mid - 1, true);
        buildTree(root, nums, mid + 1, nums.length - 1, false);
        return root;
    }

    /**
     *
     * @param root
     * @param arr
     * @param start
     * @param end
     * @param b
     */
    private static void buildTree(TreeNode root, int[] arr, int start, int end, boolean b) {
        if (start > end) {
            return;
        }
        if (start == end) {
            if (b) {
                root.left = new TreeNode(arr[start]);
            } else {
                root.right = new TreeNode(arr[start]);
            }
            return;
        }
        int mid = ((end - start) >> 1) + start;
        TreeNode r;
        if (b) {
            root.left = new TreeNode(arr[mid]);
            r = root.left;
        } else {
            root.right = new TreeNode(arr[mid]);
            r = root.right;
        }
        buildTree(r, arr, start, mid - 1, true);
        buildTree(r, arr, mid + 1, end, false);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
