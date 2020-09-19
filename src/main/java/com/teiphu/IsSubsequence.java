package com.teiphu;

/**
 * 392. 判断子序列
 * @author Zheng Lifu
 */
public class IsSubsequence {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println(isSubsequence(s, t));

	}

	private static boolean isSubsequence(String s, String t) {
		int i = 0;
		for (int j = 0; i < s.length() && j < t.length(); j++) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
		}
		return i >= s.length();
	}
}
