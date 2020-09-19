package com.teiphu;

/**
 * 61. 旋转链表
 *
 * @Author Teiphu
 * @Creation 2018.10.06 19:04
 **/
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int num = 1;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            num++;
        }
        if (k % num == 0) {
            return head;
        }
        end.next = head;
        k = num - 1 - (k % num);
        ListNode t = head;
        while (k != 0) {
            t = t.next;
            k--;
        }
        head = t.next;
        t.next = null;
        return head;
    }

}
