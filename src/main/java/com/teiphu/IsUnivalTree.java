package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        return isUnival(root);
    }

    private boolean isUnival(TreeNode root) {
        boolean res = true;
        if (root.left != null) {
            if (root.left.val == root.val) {
                res = isUnival(root.left);
            } else {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val) {
                res = res && isUnival(root.right);
            } else {
                return false;
            }
        }
        return res;
    }
}
