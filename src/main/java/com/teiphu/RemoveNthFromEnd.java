package com.teiphu;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * @author Zheng Lifu
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        RemoveNthFromEnd rnfe = new RemoveNthFromEnd();
        head = rnfe.removeNthFromEnd(head, 1);
        System.out.println(head.val);
    }

    /**
     * 快慢指针解法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode front = head;
        int i = 0;
        for (; i <= n; i++) {
            if (front != null) {
                front = front.next;
            } else {
                break;
            }
        }
        if (i <= n) {
            ListNode t = head;
            head = head.next;
            t.next = null;
            return head;
        }

        ListNode back = head;
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        ListNode next = back.next;
        back.next = next.next;
        next.next = null;
        return head;
    }
}
