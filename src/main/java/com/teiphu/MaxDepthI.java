package com.teiphu;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * @author Zheng Lifu
 */
public class MaxDepthI {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int len) {
        if (node == null) {
            return len;
        }
        if (node.left == null && node.right == null) {
            return len + 1;
        }
        if (node.left != null && node.right != null) {
            return Math.max(dfs(node.left, len + 1), dfs(node.right, len + 1));
        }
        if (node.left != null) {
            return dfs(node.left, len + 1);
        } else {
            return dfs(node.right, len + 1);
        }
    }

}
