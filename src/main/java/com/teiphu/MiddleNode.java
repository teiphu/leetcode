package com.teiphu;

/**
 * 876. 链表的中间结点
 * 解
 *
 * @author : ZhengLifu
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = n1.next;
        while (n2 != null) {
            n1 = n1.next;
            n2 = n2.next;
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        return n1;
    }
}

// 1

