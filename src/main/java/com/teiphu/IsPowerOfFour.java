package com.teiphu;

public class IsPowerOfFour {

	public static void main(String[] args) {

		int num = 13;
		double d = Math.log10(num);
		System.out.println(d);
	}
	
	public static boolean isPowerOfFour(int num) {
		if (num <= 0) {
			return false;
		}
		String str = Integer.toBinaryString(num);
		char[] cs = str.toCharArray();
		if (cs.length % 2 == 0) {
			return false;
		}
		for (int i = 1; i < cs.length; i++) {
			if (cs[i] == '1') {
				return false;
			}
		}
		return true;
	}

}
