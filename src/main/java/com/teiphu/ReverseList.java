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
            System.out.print(node.val + "  ");
            node = node.next;
        }
        System.out.println();

        System.out.println("----------");

        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.reverseList1(root);
        node = head;
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 迭代解法, 自解
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode last = head;
        while (node != null) {
            ListNode t = node.next;
            node.next = last;
            last = node;
            node = t;
        }
        head.next = null;
        head = last;
        return head;
    }

    /**
     * 递归解法,自解
     *
     * @param head
     * @return
     */
    public ListNode reverseList0(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = reverse0(head, head.next);
        return root;
    }

    public ListNode reverse0(ListNode last, ListNode next) {
        ListNode root;
        if (next != null) {
            root = reverse0(next, next.next);
        } else {
            return last;
        }
        next.next = last;
        last.next = null;
        return root;
    }

    /**
     * 递归解法, 另解
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head, head.next);
    }

    public ListNode reverse(ListNode node, ListNode next) {
        ListNode head;
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

