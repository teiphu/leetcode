package com.teiphu.offer;

import com.teiphu.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 *
 * @author Zheng Lifu
 */
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}

}
