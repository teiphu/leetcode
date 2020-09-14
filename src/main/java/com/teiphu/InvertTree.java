package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        invert(node.left);
        invert(node.right);
    }
}
