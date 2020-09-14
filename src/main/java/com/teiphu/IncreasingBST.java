package com.teiphu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zheng Lifu
 */
public class IncreasingBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        increasingBST(root);

    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !linkedList.isEmpty()) {
            while (cur != null) {
                linkedList.push(cur);
                cur = cur.left;
            }
            cur = linkedList.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        root = new TreeNode(list.get(0));
        cur = root;

        for (int i = 1; i < list.size(); i++) {
            Integer val = list.get(i);
            TreeNode node = new TreeNode(val);
            cur.right = node;
            cur = node;
        }

        return root;
    }

}
