package com.teiphu;

/**
 * 814.二叉树剪枝
 *
 * @author Zheng Lifu
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        TreeNode node = postOrderTraversal(root);
        if (node != null && root.val == 0) {
            return null;
        }
        return root;
    }

    /**
     * 后序遍历的过程中不断剪枝
     *
     * @param root
     * @return
     */
    private TreeNode postOrderTraversal(TreeNode root) {
        if (root.left != null) {
            TreeNode node = postOrderTraversal(root.left);
            if (node != null) {
                root.left = null;
            }
        }
        if (root.right != null) {
            TreeNode node = postOrderTraversal(root.right);
            if (node != null) {
                root.right = null;
            }
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return root;
        }
        return null;
    }

}
