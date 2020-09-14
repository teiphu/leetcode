package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 530.二叉搜索树的最小绝对差
 *
 * @author Zheng Lifu
 */
public class GetMinimumDifference {

    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < min) {
                min = list.get(i) - list.get(i - 1);
            }
        }
        return min;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }
}
