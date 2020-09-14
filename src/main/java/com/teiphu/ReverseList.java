package com.teiphu;

/**
 * 206. 反转链表
 *
 * @author : ZhengLifu
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode root = node;
        for (int i = 1; i < 10; i++) {
            ListNode node1 = new ListNode(i);
            node.next = node1;
            node = node1;
        }

        node = root;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("----------");

        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.reverseList(root);
        node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head, head.next);
    }

    public ListNode reverse(ListNode node, ListNode next) {
        ListNode head = null;
        if (next.next != null) {
            head = reverse(next, next.next);
        } else {
            node.next = null;
            next.next = node;
            head = next;
            return head;
        }
        node.next = null;
        next.next = node;
        return head;
    }

}

