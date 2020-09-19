package com.teiphu;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

	private List<Integer> data;

	private int p_start;

	public MyQueue() {
		this.data = new ArrayList<>();
		p_start = 0;
	}

	public boolean enQueue(int x) {
		data.add(x);
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		p_start++;
		return true;
	}

	public int front() {
		return data.get(p_start);
	}

	public boolean isEmpty() {
		return p_start >= data.size();
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enQueue(5);
		queue.enQueue(4);
		if (!queue.isEmpty()) {
			System.out.println(queue.front());
		}
		queue.deQueue();
		if (!queue.isEmpty()) {
			System.out.println(queue.front());
		}
		if (!queue.isEmpty()) {
			System.out.println(queue.front());
		}
	}
}
