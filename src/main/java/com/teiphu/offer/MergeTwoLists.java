package com.teiphu.offer;

import com.teiphu.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * @author Zheng Lifu
 */
public class MergeTwoLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(2);
//		l2.next = new ListNode(3);
//		l2.next.next = new ListNode(4);
		MergeTwoLists mtl = new MergeTwoLists();
		l1 = mtl.mergeTwoLists(l1, l2);
		while (l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		if (p1 == null) {
			return p2;
		}
		if (p2 == null) {
			return p1;
		}
		ListNode pre = null;
		while (p2 != null) {
			if (p1 == null) {
				pre.next = p2;
				p2 = null;
			} else if (p1.val == p2.val) {
				ListNode t = p2.next;
				p2.next = p1.next;
				p1.next = p2;
				p2 = t;
				pre = p1;
				p1 = p1.next;
			} else if (p1.val > p2.val) {
				ListNode t = p2.next;
				p2.next = p1;
				if (pre == null) {
					l1 = p2;
				} else {
					pre.next = p2;
				}
				p1 = p2;
				p2 = t;
			} else {
				pre = p1;
				p1 = p1.next;
			}
		}

		return l1;
	}

}
