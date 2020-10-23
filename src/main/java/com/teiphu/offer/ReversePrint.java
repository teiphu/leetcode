package com.teiphu.offer;

import com.teiphu.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheng Lifu
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        print(head, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void print(ListNode head, List<Integer> list) {
        if (head.next != null) {
            print(head.next, list);
        }
        list.add(head.val);
    }
}
