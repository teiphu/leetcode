package com.teiphu;

/**
 * 617.合并二叉树
 *
 * @author Zheng Lifu
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return t1;
        }
        if (t1 == null) {
            return t2;
        }
        merge(t1, t2);
        return t1;
    }

    private void merge(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            node1.val += node2.val;
        }
        if (node1.left != null && node2.left != null) {
            merge(node1.left, node2.left);
        } else if (node1.left == null && node2.left != null) {
            node1.left = node2.left;
        }

        if (node1.right != null && node2.right != null) {
            merge(node1.right, node2.right);
        } else if (node1.right == null && node2.right != null) {
            node1.right = node2.right;
        }
    }
}
