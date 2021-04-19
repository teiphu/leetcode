package com.teiphu.offer;

import com.teiphu.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * @author Zheng Lifu
 */
public class GetIntersectionNode {

	public static void main(String[] args) {

		ListNode headA = new ListNode(3);
//		headA.next = new ListNode(6);
//		headA.next.next = new ListNode(4);
//		headA.next.next.next = new ListNode(4);
//		headA.next.next.next.next = new ListNode(5);

		ListNode headB = new ListNode(2);
		headB.next = headA;
//		headB.next.next = new ListNode(1);
//		headB.next.next.next = new ListNode(8);
//		headB.next.next.next.next = new ListNode(4);
//		headB.next.next.next.next.next = new ListNode(5);

		GetIntersectionNode gin = new GetIntersectionNode();
		ListNode res = gin.getIntersectionNode0(headA, headB);
		System.out.println(res.val);

	}

	/**
	 * 题意在于给的两个链表其实相交的位置的后面的节点地址是同样的
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		while (nodeA != nodeB) {
			if (nodeA != null) {
				nodeA = nodeA.next;
			} else {
				nodeA = headB;
			}
			if (nodeB != null) {
				nodeB = nodeB.next;
			} else {
				nodeB = headA;
			}
		}
		return nodeA;
	}

	/**
	 * 误解题意解法
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		int lenA = 0;
		int lenB = 0;
		while (nodeA != null) {
			lenA++;
			nodeA = nodeA.next;
		}
		while (nodeB != null) {
			lenB++;
			nodeB = nodeB.next;
		}

		ListNode node;
		ListNode node1;
		if (lenA >= lenB) {
			node = headA;
			node1 = headB;
		} else {
			node = headB;
			node1 = headA;
		}

		for (int i = Math.max(lenA, lenB); i > Math.min(lenA, lenB); i--) {
			node = node.next;
		}

		ListNode temp = new ListNode(-1);
		temp.next = node1;

		while (node != null) {
			if (node.val != node1.val) {
				temp = node1;
			}
			node = node.next;
			node1 = node1.next;
		}
		return temp.next;
	}

}
