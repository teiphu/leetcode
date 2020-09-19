package com.teiphu;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAtoi {

	public static void main(String[] args) {
		String str = " -41";
		System.out.println(myAtoi(str));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}

	public static int myAtoi1(String str) {
		Pattern pattern = Pattern.compile("[-+]??[0-9]++");
		String strTrim = str.trim();
		Matcher matcher = pattern.matcher(strTrim);
		if (matcher.lookingAt()) {
			String strNum = strTrim.substring(0, matcher.end());
			try {
				return Integer.parseInt(strNum);
			} catch (NumberFormatException nfe) {
				return strNum.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
		}
		return 0;

	}

	public static int myAtoi(String str) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != ' ' && ch != '-' && ch != '+' && (ch < 48 || ch > 57)) {
				break;
			}
			if (ch == ' ' && stack.isEmpty()) {
				continue;
			} else if (ch == ' ' && !stack.isEmpty()) {
				break;
			}
			if ((ch == '-' || ch == '+') && stack.isEmpty()) {
				stack.push(ch);
				sb.append(ch);
				continue;
			} else if ((ch == '-' || ch == '+') && !stack.isEmpty()) {
				break;
			}
			stack.push(ch);
			sb.append(ch);

		}
		Stack<Character> stack1 = (Stack<Character>) stack.clone();

		if (stack.isEmpty()) {
			return 0;
		} else {
			if (sb.charAt(0) == '+') {
				sb.deleteCharAt(0);
			}
			if (sb.length() == 0) {
				return 0;
			}
			if (sb.charAt(0) == '-' && sb.length() == 1) {
				return 0;
			}
			Long l = Long.valueOf(sb.toString());
			if (l < -2147483648) {
				return Integer.MIN_VALUE;
			} else if (l > 2147483647) {
				return Integer.MAX_VALUE;
			} else {
				return Math.toIntExact(l);
			}
			/*if (stack.peek() == '-' || stack.peek() == '+') {
				return 0;
			}
			int num = 0;
			int dec = 1;
			boolean isNeg = false;
			while (!stack.isEmpty()) {
				char ch = stack.pop();
				if (ch != '-' && ch != '+') {
					num += (ch - 48) * dec;
					dec *= 10;
				} else if (ch == '-') {
					num = -num;
					isNeg = true;
				} else {
					break;
				}
			}
			int c = stack1.pop();
			if (isNeg && (stack1.size() > 11 ||-num % 10 != c - 48)) {
				return Integer.MIN_VALUE;
			} else if (!isNeg && (stack1.size() > 10 || num % 10 != c - 48)) {
				return Integer.MAX_VALUE;
			}
			return num;*/
		}
	}
}
