package com.teiphu;

/**
 * 1290. 二进制链表转整数
 *
 * @author Zheng Lifu
 */
public class GetDecimalValue {

    private int digits = 1;

    public static void main(String[] args) {
        GetDecimalValue gdv = new GetDecimalValue();
        ListNode root = new ListNode(0);
        root.next = new ListNode(0);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(0);
        root.next.next.next.next = new ListNode(1);
        int res = gdv.getDecimalValue(root);
        System.out.println(res);
    }

    public int getDecimalValue(ListNode head) {
        int res = decimalValue(head);
        return res;
    }

    private int decimalValue(ListNode node) {
        if (node == null) {
            return 0;
        }
        int val = decimalValue(node.next);
        int res = node.val * digits + val;
        digits *= 2;
        return res;
    }
}
