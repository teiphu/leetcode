package com.teiphu;

import java.util.LinkedList;

/**
 * 24. 两两交换链表中的节点
 * 解
 *
 * @author Zheng Lifu
 * @see com.teiphu.ReverseKGroup 同解
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        SwapPairs sp = new SwapPairs();
        ListNode root = sp.swapPairs(head);

        print(root);
    }

    public ListNode swapPairs(ListNode head) {
        int k = 2;
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode pt = head;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode newHead = root;

        while (pt != null) {
            list.push(pt);
            pt = pt.next;
            if (list.size() == k) {
                while (!list.isEmpty()) {
                    ListNode node = list.pop();
                    newHead.next = node;
                    newHead = node;
                }
                newHead.next = pt;
            }
        }
        head = root.next;
        return head;
    }

    private static void print(ListNode root) {
        while (root != null) {
            System.out.print(root.val);
            System.out.print(" -> ");
            root = root.next;
        }
        System.out.println();

    }
}
