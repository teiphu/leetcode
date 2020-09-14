package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        return false;
    }

    private int getDepth(TreeNode root, int x, int depth) {
        depth += 1;
        if (root.val == x) {
            return depth;
        }
        if (root.left != null) {
            getDepth(root.left, x, depth);
        }
        if (root.right != null) {
            getDepth(root.right, x, depth);
        }
        return -1;

    }
}
