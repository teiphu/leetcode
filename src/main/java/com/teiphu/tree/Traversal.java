package com.teiphu.tree;

import com.teiphu.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的遍历（深度遍历）
 *
 * @author Zheng Lifu
 */
public class Traversal {

	public static void main(String[] args) {
		Traversal traversal = new Traversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		List<Integer> list = traversal.preorderTraversal(root);
		System.out.println(list.toString());
		list = traversal.inorderTraversal(root);
		System.out.println(list.toString());
		list = traversal.postorderTraversal(root);
		System.out.println(list.toString());

	}

	/**
	 * 前序遍历
	 *
	 * @param root
	 * @return
	 */
	private List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				list.add(node.val);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		return list;
	}

	/**
	 * 中序遍历
	 *
	 * @param root
	 * @return
	 */
	private List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			list.add(node.val);
			node = node.right;
		}
		return list;
	}

	/**
	 * 后序遍历
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		TreeNode prev = null;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			if (node.right == null || node.right == prev) {
				list.add(node.val);
				prev = node;
				node = null;
			} else {
				stack.push(node);
				node = node.right;
			}
		}
		return list;
	}

}
