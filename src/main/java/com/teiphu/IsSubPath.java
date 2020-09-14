package com.teiphu;

/**
 * 1367. 二叉树中的列表
 *
 * @author Zheng Lifu
 */
public class IsSubPath {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSub(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null || head.val != root.val) {
            return false;
        }
        return isSub(head.next, root.left) || isSub(head.next, root.right);
    }
}
