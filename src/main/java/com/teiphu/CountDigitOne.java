package com.teiphu;

public class CountDigitOne {

	public static void main(String[] args) {
		int start = 100000000;
		int end = 999999999;
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		// TODO �Զ����ɵķ������
		System.out.println(count(start, end));
	}
	
	public static int countDigitOne(int n) {
		return n;
		
	}

	public static int count(int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			int n = i;
			while (n != 0) {
				if (n % 10 == 1) {
					count++;
				}
				n = n / 10;
			}
		}
		return count;
	}
	
}
