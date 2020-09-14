package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
//        return preOrderTraversal(root, val);
        return search(root, val);
    }

    /**
     * 二分查找
     *
     * @param root
     * @param val
     * @return
     */
    private TreeNode search(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return search(root.right, val);
        } else {
            return search(root.left, val);
        }
    }

    /**
     * 前序遍历查找
     *
     * @param node
     * @param val
     * @return
     */
    private TreeNode preOrderTraversal(TreeNode node, int val) {
        if (node.left != null) {
            TreeNode res = preOrderTraversal(node.left, val);
            if (res != null) {
                return res;
            }
        }
        if (node.val == val) {
            return node;
        }
        if (node.right != null) {
            return preOrderTraversal(node.right, val);
        }
        return null;
    }
}
