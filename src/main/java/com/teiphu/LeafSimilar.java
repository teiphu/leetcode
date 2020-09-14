package com.teiphu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 872. 叶子相似的树
 *
 * @author Zheng Lifu
 */
public class LeafSimilar {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inOrderTraversal(root1);
        List<Integer> list2 = inOrderTraversal(root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !linkedList.isEmpty()) {
            while (cur != null) {
                linkedList.push(cur);
                cur = cur.left;
            }
            cur = linkedList.pop();
            if (cur.left == null && cur.right == null) {
                list.add(cur.val);
            }
            cur = cur.right;
        }
        return list;
    }

}
