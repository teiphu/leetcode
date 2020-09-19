package com.teiphu;

public class CompressString {

	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));

	}

	public static String compressString(String S) {
		char last = S.charAt(0);
		StringBuilder sb = new StringBuilder();
		sb.append(last);
		int num = 1;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) != last) {
				last = S.charAt(i);
				sb.append(num);
				sb.append(last);
				num = 1;
			} else {
				num++;
			}
		}
		sb.append(num);
		if (sb.length() > S.length()) {
			return S;
		} else {
			return sb.toString();
		}
	}

}
