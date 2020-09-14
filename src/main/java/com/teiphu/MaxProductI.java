package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 1339. 分裂二叉树的最大乘积
 *
 * @author Zheng Lifu
 */
public class MaxProductI {

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        MaxProductI mp = new MaxProductI();
        System.out.println(mp.maxProduct(root));

    }

    /**
     * 计算每个节点下的子树和
     *
     * @param root
     * @return
     */
    public int maxProduct(TreeNode root) {
        /*long sum = dfs(root);
        long max = 0;
        for (long val : list) {
            long product = val * (sum - val);
            if (product > max) max = product;
        }
        return (int) (max % (int) (1e9 + 7));*/

        /*int sum = dfs(root);
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            long s = (long)list.get(i) * (long)(sum - list.get(i));
            if (s > max) {
                max = s;
            }
        }
        return (int) (max % (int) (1e9 + 7));*/

        int sum = dfs(root);
        double mid = sum / 2.0;
        double min = Integer.MAX_VALUE;
        int t = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(Math.abs((double) list.get(i) - mid), min);
            t = i;
        }
        return (int) ((long) (sum - list.get(t)) * (long) (list.get(t)) % (int) (1e9 + 7));

        /*double mid = list.get(list.size() - 1) / 2.0;
        double min = Integer.MAX_VALUE;
        int t = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - mid) < min) {
                min = Math.abs(list.get(i) - mid);
                t = i;
            }
        }
        long sum = list.get(t) * (list.get(list.size() - 1) - list.get(t));
        return (int) (sum % 1000000007);*/
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        list.add(sum);
        return sum;
    }

}
