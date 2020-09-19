package com.teiphu;

public class CountBits {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
//		System.out.println(Integer.toBinaryString(15));
		/*
		int num = 40;
		for (int i = 0; i <= num; i++) {
			System.out.print(Integer.toBinaryString(i));
			System.out.print(": " + bitCount(i));
			System.out.println(" | " + bitCount0(i));
		}
		*/
//		int num = 31;
//		System.out.println(Integer.toBinaryString(num));
//		System.out.println(bitCount(num));
//		System.out.println();
//		
//		bitCount0(num);
//		System.out.println(Integer.valueOf("11101", 2).toString());
//		System.out.println(Integer.valueOf("10000000000000000000000000000000", 2).toString());
		int n = 214748364;
		System.out.println(n);
		
	}
	
	public int[] countBits(int num) {
		
		return null;
	}
	
	private static int bitCount0(int n) {
		int count = 0;
		System.out.println(n);
		for (; n > 0; count++) {
			System.out.println(Integer.toBinaryString(n));
			System.out.println(Integer.toBinaryString(n-1));
			n = n & (n-1);
			System.out.println(Integer.toBinaryString(n));
			System.out.println(n);
			System.out.println();
		}
		return count;
	}
	
	private static int bitCount(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>= 1;
		}
		return count;
	}

}
