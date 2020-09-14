package com.teiphu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zheng Lifu
 */
public class GenerateTrees {

    public static void main(String[] args) {
        int n = 5;
        GenerateTrees gt = new GenerateTrees();
        List<TreeNode> trees = gt.generateTrees(n);
        System.out.println(trees);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate_trees(1, n);
    }

    private List<TreeNode> generate_trees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generate_trees(start, i - 1);
            List<TreeNode> rightTrees = generate_trees(i + 1, end);

            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    allTrees.add(current_tree);
                }
            }
        }
        return allTrees;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
