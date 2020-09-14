package com.teiphu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * @author Zheng Lifu
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 非递归式的深度优先遍历
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pop();
            System.out.println(node.val);
            if (node.right != null) {
                linkedList.push(node.right);
            }
            if (node.left != null) {
                linkedList.push(node.left);
            }
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            traverse(root.left, list, String.valueOf(root.val));
        }
        if (root.right != null) {
            traverse(root.right, list, String.valueOf(root.val));
        }
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
        }
        return list;
    }

    private void traverse(TreeNode root, List<String> list, String s) {
        s += "->" + root.val;
        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }
        if (root.left != null) {
            traverse(root.left, list, s);
        }
        if (root.right != null) {
            traverse(root.right, list, s);
        }
    }
}
