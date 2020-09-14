package com.teiphu;

/**
 * 404.左叶子之和
 *
 * @author Zheng Lifu
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = preOrderTraversal(root, false, 0);
        return sum;
    }

    private int preOrderTraversal(TreeNode node, boolean isLeft, int sum) {
        if (node.left != null) {
            sum = preOrderTraversal(node.left, true, sum);
        }
        if (node.right != null) {
            sum = preOrderTraversal(node.right, false, sum);
        }
        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
        }
        return sum;
    }
}
