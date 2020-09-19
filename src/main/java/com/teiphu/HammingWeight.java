package com.teiphu;

public class HammingWeight {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println(hammingWeight(10));
	}

	public static int hammingWeight(int n) {
        int count = n & 1;
        for (n = n >>> 1; n > 0; count++) {
            n = n & (n-1);
        }
        return count;
	}
	
}
