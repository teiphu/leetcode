package com.teiphu;

/**
 * 112. 路径总和
 *
 * @author Zheng Lifu
 */
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        boolean res = hasPathSum(root, -5);
        System.out.println(res);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, sum);
    }

    private static boolean dfs(TreeNode node, int s, int sum) {
        s += node.val;
        if (node.left == null && node.right == null) {
            return s == sum;
        }
        if (node.left != null && node.right != null) {
            return dfs(node.left, s, sum) || dfs(node.right, s, sum);
        } else if (node.left != null) {
            return dfs(node.left, s, sum);
        } else {
            return dfs(node.right, s, sum);
        }
    }
}
