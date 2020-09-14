package com.teiphu;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @author Zheng Lifu
 */
public class ConvertBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode r = convertBST(root);
        System.out.println(r);
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        traverse(root, 0);
        return root;
    }

    private static int traverse(TreeNode node, int sum) {
        if (node.right != null) {
            sum = traverse(node.right, sum);
        }
        node.val += sum;
        if (node.left != null) {
            return traverse(node.left, node.val);
        } else {
            return node.val;
        }
    }
}
