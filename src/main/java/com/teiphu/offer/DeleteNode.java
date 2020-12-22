package com.teiphu.offer;

import com.teiphu.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author Zheng Lifu
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode node = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val == val) {
                node.next = next.next;
                next.next = null;
                break;
            }
            node = next;
            next = next.next;
        }
        return head;
    }
}
