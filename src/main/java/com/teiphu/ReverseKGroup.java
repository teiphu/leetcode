package com.teiphu;

import java.util.LinkedList;

/**
 * 25. K个一组翻转链表
 * 解
 *
 * @author Zheng Lifu
 */
public class ReverseKGroup {

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
        ReverseKGroup rkg = new ReverseKGroup();
        ListNode root = rkg.reverseKGroup(head, 3);
        print(root);
    }

    private static void print(ListNode root) {
        while (root != null) {
            System.out.print(root.val);
            System.out.print(" -> ");
            root = root.next;
        }
        System.out.println();

    }

    public ListNode reverseKGroup(ListNode head, int k) {
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
//                list.clear();
            }
        }
        head = root.next;
        return head;
    }

}
