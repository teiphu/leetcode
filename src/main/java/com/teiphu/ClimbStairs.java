package org.teiphu;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int n = 0;
		System.out.println(climbStairs1(n));
		System.out.println(climbStairs(n));
	}
	
	
	public static int climbStairs1(int n) {
		int ret = 1;
		int a = 1;
		int b = 1;
//		if (n == 1 || n == 0) {
//			return ret;
//		}
		while (--n > 0) {
			ret = a + b;
			b = a;
			a = ret;
		}
		return ret;
	}
	
	public static int climbStairs(int n) {
		if (n == 0 || n == 1) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
	
	}

}
