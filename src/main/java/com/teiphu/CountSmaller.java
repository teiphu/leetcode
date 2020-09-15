package org.teiphu;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {

    public static void main(String[] args) {

        int[] nums = {5, 2, 6, 1};
        List<Integer> ints;
        ints = countSmaller(nums);
        for (Integer integer : ints) {
            System.out.println(integer);
        }
        System.out.println();
        ints = countSmaller1(nums);
        for (Integer integer : ints) {
            System.out.println(integer);
        }

    }

    /**
     * 超出时间限制的算法
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller0(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    arr[i]++;
                }
            }
        }
        List<Integer> list = new ArrayList<>(n);
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> countSmaller1(int[] nums) {
        List<Integer> ints = new ArrayList<>();
        Node root = buildTree(nums);
        Node node = null;
        for (int i = 0; i < nums.length; i++) {
            node = root;
            while (node != null) {
                if (nums[i] == node.val) {
                    break;
                } else if (nums[i] < node.val) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            ints.add(getSize(node.left));

        }
        return ints;
    }

    /**
     * ��������������
     *
     * @param nums
     * @return
     */
    public static Node buildTree(int[] nums) {
        Node root = new Node(nums[0]);
        Node temp = null;
        Node t = null;
        for (int i = 1; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            temp = root;
            while (temp != null) {
                t = temp;
                if (nums[i] < temp.val) {
                    temp = temp.left;
                } else if (nums[i] > temp.val) {
                    temp = temp.right;
                }
            }
            if (nums[i] < t.val) {
                t.left = node;
            } else {
                t.right = node;
            }
        }
        return root;
    }

    public static int getSize(Node root) {
        return size(root);
    }

    private static int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    private static void preOrderTraver(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderTraver(node.left);
        preOrderTraver(node.right);
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ints = new ArrayList<>();
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            ints.add(count);
        }
        return ints;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

}
