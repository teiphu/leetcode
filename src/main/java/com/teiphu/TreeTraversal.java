package com.teiphu;

import java.util.LinkedList;

/**
 * 树的非递归遍历
 *
 * @author Zheng Lifu
 */
public class TreeTraversal {

    private void nrPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode p = root;
        while (!(p == null && linkedList.isEmpty())) {
            while (p != null) {
                System.out.println(p.val);

            }
        }

    }
}
