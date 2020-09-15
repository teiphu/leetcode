package org.teiphu;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Teiphu
 * @Creation 2018.10.04 14:25
 **/
public class KthLargest {

    Queue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        int[] arr = {2, 4, 1, 5, 3};
        for (int i : arr) {
            queue.offer(i);
        }
        while (queue.size() != 0) {
            System.out.println(queue.poll());

        }
    }

}
