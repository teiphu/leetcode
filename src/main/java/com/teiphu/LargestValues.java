package com.teiphu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Teiphu
 * @Creation 2018.10.01 15:02
 **/
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
//        list.add(root.val);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() != 0) {
            Queue<TreeNode> temp = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            while (queue.size() != 0) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            list.add(max);
            queue = temp;
        }
        return list;
    }

}
