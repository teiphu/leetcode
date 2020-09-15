package org.teiphu;

/**
 * 秋叶收藏集
 *
 * @author Zheng Lifu
 */
public class MinimumOperations {

	public static void main(String[] args) {
		MinimumOperations mo = new MinimumOperations();
		int res = mo.minimumOperations("rrryyyrryyyrr");
		System.out.println(res);
	}

	public int minimumOperations(String leaves) {
		char[] value = leaves.toCharArray();
		int x = 0;
		int min = Integer.MAX_VALUE;
		int temp = 0;
		for (int i = 2; i < leaves.length(); i++) {
			if (value[i] == 'y') {
				temp++;
			}
		}
		for (int i = 0; i < leaves.length() - 2; i++) {
			if (value[i] == 'y') {
				x++;
			}
			int y = 0;
			int z = temp;
			if (i + 1 >= 2 && value[i + 1] == 'y') {
				z--;
			}
			temp = z;
			for (int j = i + 1; j < leaves.length() - 1; j++) {
				if (value[j] == 'r') {
					y++;
				}
				if (j - i > 1 && value[j] == 'y') {
					z--;
				}
				int t = x + y + z;
				if (t < min) {
					min = t;
				}
			}
		}
		return min;
	}
}
