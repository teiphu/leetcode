package com.teiphu;

/**
 * 141. 环形链表
 *
 * @author Zheng Lifu
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast;
        ListNode slow;
        fast = slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
