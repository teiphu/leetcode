package com.teiphu.dfs;

/**
 * 101. 对称二叉树
 *
 * @author Zheng Lifu
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res = dfs(root.left, root.right);
        return res;
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        }
        if (left != null) {
            if (left.val == right.val) {
                return dfs(left.left, right.right) && dfs(left.right, right.left);
            } else {
                return false;
            }
        }
        return true;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

