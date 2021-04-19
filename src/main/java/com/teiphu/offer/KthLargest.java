package com.teiphu.offer;

import com.teiphu.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * @author Zheng Lifu
 */
public class KthLargest {

	public static void main(String[] args) {

	}

	public int kthLargest(TreeNode root, int k) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		int i = 0;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.right;
			}
			node = stack.pop();
			i++;
			if (i == k) {
				return node.val;
			}
			node = node.left;
		}
		return -1;
	}
}
