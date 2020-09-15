package org.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Teiphu
 * @Creation 2018.10.01 14:43
 **/
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        helper(root, list);
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) {
            root.left.val = root.val * 10 + root.left.val;
            helper(root.left, list);
        }
        if (root.right != null) {
            root.right.val = root.val * 10 + root.right.val;
            helper(root.right, list);
        }

    }
}
