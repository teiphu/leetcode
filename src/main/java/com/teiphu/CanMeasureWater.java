package org.teiphu;

/**
 * 365. 水壶问题
 */
public class CanMeasureWater {

	public boolean canMeasureWater(int x, int y, int z) {
		if (x == 0 && y == 0) {
			return z == 0;
		}
		if (z > x + y) {
			return false;
		}
		int a = y == 0 ? gcd(y, x) : gcd(x, y);
		return z % a == 0;
	}

	private int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}
