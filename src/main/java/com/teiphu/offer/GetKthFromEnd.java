package com.teiphu.offer;

import com.teiphu.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author Zheng Lifu
 */
public class GetKthFromEnd {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode last = root;
        for (int i = 2; i <= 10; i++) {
            last.next = new ListNode(i);
            last = last.next;
        }
        root = null;
        GetKthFromEnd kthFromEnd = new GetKthFromEnd();
        ListNode result = kthFromEnd.getKthFromEnd(root, 2);
        System.out.println(result.val);

    }

    int size = 0;

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode node = getKth(head, k);
        return node;
    }

    private ListNode getKth(ListNode head, int k) {
        ListNode node = null;
        if (head.next != null) {
            node = getKth(head.next, k);
        }
        size++;
        if (size == k) {
            return head;
        }
        return node;
    }

}
