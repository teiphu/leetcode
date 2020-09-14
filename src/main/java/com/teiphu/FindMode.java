package com.teiphu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. 二叉搜索树中的众数
 *
 * @author Zheng Lifu
 */
public class FindMode {

    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        FindMode fm = new FindMode();
        int[] res = fm.findMode0(root);
        System.out.println(res);

    }

    //    List<Integer> list = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int count = 0;
    Integer lastVal = null;

    public int[] findMode0(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        inOrderTraversal0(root, Integer.MIN_VALUE, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderTraversal0(TreeNode root, int max, List<Integer> list) {
        if (root.left != null) {
            inOrderTraversal0(root.left, max, list);
        }
        if (lastVal == null || root.val == lastVal) {
            count++;
        } else {
            count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        lastVal = root.val;
        if (root.right != null) {
            inOrderTraversal0(root.right, max, list);
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        inOrderTraversal(root);
        List<Integer> maxList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxList.clear();
                maxList.add(entry.getKey());
            } else if (entry.getValue() == max) {
                maxList.add(entry.getKey());
            }
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderTraversal(TreeNode root) {
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }
}
