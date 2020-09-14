package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 *
 * @author Zheng Lifu
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        IsValidBST bst = new IsValidBST();
        System.out.println(bst.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        Integer last = null;
        int t = -1;
        for (int i = 0; i < list.size(); i++) {
            if (last == null || list.get(i) > last) {
                last = list.get(i);
                t = i;
            } else {
                break;
            }
        }
        return t == list.size() - 1;
    }

    private void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            preOrderTraversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            preOrderTraversal(root.right, list);
        }
    }

    private boolean validBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return validBST(root.left) && validBST(root.right);
    }
}
