package com.teiphu;

/**
 * 1372. 二叉树中的最长交错路径
 *
 * @author Zheng Lifu
 */
public class LongestZigZag {

    private int max;

    public static void main(String[] args) {
        LongestZigZag lzz = new LongestZigZag();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        int res = lzz.longestZigZag(root);
        System.out.println(res);
    }

    public int longestZigZag0(TreeNode root) {
        dfs(root.left, true);
        dfs(root.right, false);
        return max;
    }

    private int  dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, true);
        int right = dfs(root.right, false);
        max = Math.max(max, left);
        max = Math.max(max, right);
        return isLeft ? right + 1 : left + 1;

    }

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.val = 0;
        max = root.val;
        zigZag(root, root.left, true, false);
        zigZag(root, root.right, false, true);
        traverse(root);
        return max;
    }

    private void traverse(TreeNode root) {
        if (root.val > max) {
            max = root.val;
        }
        if (root.left != null) {
            traverse(root.left);
        }
        if (root.right != null) {
            traverse(root.right);
        }
    }

    private void zigZag(TreeNode parNode, TreeNode root, boolean isLeft, boolean parIsLeft) {
        if (root == null) {
            return;
        }
        if (isLeft ^ parIsLeft) {
            root.val = parNode.val + 1;
        } else {
            root.val = 1;
        }
        zigZag(root, root.left, true, isLeft);
        zigZag(root, root.right, false, isLeft);
    }
}
