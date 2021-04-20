package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class DeleteDuplicates {

    /**
     * 1->1->2->3->3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        boolean b = false;
        while (true) {
            if (next.val == prev.val) {
                b = true;
                next = next.next;
            } else if (b) {

            }
        }
    }
}
