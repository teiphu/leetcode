package com.teiphu.offer;

import com.teiphu.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * @author Zheng Lifu
 */
public class LevelOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		LevelOrder lo = new LevelOrder();
		lo.levelOrder(root);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			Deque<TreeNode> temp = new LinkedList<>();
			List<Integer> list = new ArrayList<>();
			while (!deque.isEmpty()) {
				TreeNode node = deque.remove();
				list.add(node.val);
				if (node.left != null) {
					temp.add(node.left);
				}
				if (node.right != null) {
					temp.add(node.right);
				}
			}
			res.add(list);
			deque = temp;
		}
		return res;
	}

}
