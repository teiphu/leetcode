package com.teiphu;

/**
 * 111. 二叉树的最小深度
 *
 * @author Zheng Lifu
 */
public class MinDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int res = minDepth(root);
        System.out.println(res);
    }

    public static int minDepth(TreeNode root) {
        return depth(root, 0);
    }

    private static int depth(TreeNode node, int len) {
        if (node == null) {
            return len;
        }
        if (node.left == null && node.right == null) {
            return len + 1;
        }
        if (node.left != null && node.right != null) {
            return Math.min(depth(node.left, len + 1), depth(node.right, len + 1));
        }
        if (node.left != null) {
            return depth(node.left, len + 1);
        } else {
            return depth(node.right, len + 1);
        }
    }
}
