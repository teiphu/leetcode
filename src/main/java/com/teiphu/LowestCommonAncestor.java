package com.teiphu;

/**
 * 235.二叉搜索树的最近公共祖先
 *
 * @author Zheng Lifu
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min, max;
        if (p.val < q.val) {
            min = p.val;
            max = q.val;
        } else {
            min = q.val;
            max = p.val;
        }
        return traverse(root, min, max);
    }

    private TreeNode traverse(TreeNode root, int min, int max) {
        if ((min < root.val && root.val < max) || min == root.val || max == root.val) {
            return root;
        }
        if (root.val > max) {
            return traverse(root.left, min, max);
        } else {
            return traverse(root.right, min, max);
        }
    }

}

