package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382.将二叉搜索树变平衡
 *
 * @author Zheng Lifu
 */
public class BalanceBST {

    public static void main(String[] args) {
//        [14,9,16,2,13]
        TreeNode root = new TreeNode(14);
        TreeNode left = new TreeNode(9);
        root.left = left;
        TreeNode right = new TreeNode(16);
        root.right = right;
        TreeNode node = new TreeNode(2);
        left.left = node;
        TreeNode node1 = new TreeNode(13);
        left.right = node1;
        balanceBST(root);

    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        Integer[] arr = list.toArray(new Integer[0]);
        if (arr.length == 0) {
            return null;
        }
        int mid = ((arr.length - 1) >> 1);
        root = new TreeNode(arr[mid]);
        buildTree(root, arr, 0, mid - 1, true);
        buildTree(root, arr, mid + 1, arr.length - 1, false);
        return root;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param list
     */
    private static void traversal(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            traversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            traversal(root.right, list);
        }
    }

    /**
     * 构建二叉搜索树
     *
     * @param root
     * @param arr
     * @param start
     * @param end
     * @param b
     */
    private static void buildTree(TreeNode root, Integer[] arr, int start, int end, boolean b) {
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

