package com.teiphu.offer;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author Zheng Lifu
 */
public class CQueue {

	private Stack<Integer> stack;
	private Stack<Integer> stack1;

	public static void main(String[] args) {

	}

	public CQueue() {
		stack = new Stack<>();
		stack1 = new Stack<>();
	}

	public void appendTail(int value) {
		/*if (!stack1.isEmpty()) {
			Integer i = stack1.pop();
			stack.push(i);
		}*/
		stack.push(value);
	}

	public int deleteHead() {
		if (stack.isEmpty()) {
			return -1;
		}
		while (!stack.isEmpty()) {
			Integer i = stack.pop();
			stack1.push(i);
		}
		Integer res = stack1.pop();

		while (!stack1.isEmpty()) {
			Integer i = stack1.pop();
			stack.push(i);
		}
		return res;

		/*if (!stack1.isEmpty()) {
			return stack1.pop();
		} else {
			if (stack.isEmpty()) {
				return -1;
			} else {
				while (stack.size() != 1) {
					Integer i = stack.pop();
					stack1.push(i);
				}
				return stack.pop();
			}
		}*/
	}
}
