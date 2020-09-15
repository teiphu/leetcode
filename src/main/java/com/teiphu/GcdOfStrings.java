package org.teiphu;

public class GcdOfStrings {

	public static void main(String[] args) {
		String result = gcdOfStrings("OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO", "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO");
		System.out.println(result);
	}

	public static String gcdOfStrings0(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}
		return str1.substring(0, gcd(str1.length(), str2.length()));
	}

	private static int gcd(int a, int b) {
		while(b != 0){
			int tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}

	public static String gcdOfStrings(String str1, String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int t = 1;
		int temp = 0;
		do {
			for (int i = t, j = 0; i < chars1.length; i++) {
				if (t > chars1.length / 2) {
					t = str1.length();
					break;
				}
				if (j >= t) {
					j = 0;
				}
				if (chars1[i] != chars1[j]) {
					t++;
					j = 0;
					i = t - 1;
				} else {
					j++;
				}
			}
			if (t > str2.length()) {
				return "";
			}
			int j = 0;
			for (int i = 0; j < chars2.length; j++) {
				if (i >= t) {
					i = 0;
				}
				if (chars1[i] == chars2[j]) {
					i++;
					System.out.println();
				} else {
					System.out.println();
					break;
				}
			}
			if (j >= chars2.length) {
				if (chars2.length % t == 0) {
					temp = t;
					if (temp >= str2.length() / 2) {
						return str1.substring(0, temp);
					} else {
						t++;
					}
				} else {
					return "";
				}
			} else if (t == str1.length()) {
				return "";
			} else {
				t++;
			}
		} while (true);

	}

}
