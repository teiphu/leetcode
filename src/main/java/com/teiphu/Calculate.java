package org.teiphu;

/**
 * LCP 17. 速算机器人
 *
 * @author Zheng Lifu
 */
public class Calculate {

	public static void main(String[] args) {
		Calculate c = new Calculate();
		int res = c.calculate("AB");
		System.out.println(res);
	}

	public int calculate(String s) {
		int x = 1;
		int y = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				x = 2 * x + y;
			} else if (s.charAt(i) == 'B') {
				y = 2 * y + x;
			}
		}
		return x + y;
	}
}
