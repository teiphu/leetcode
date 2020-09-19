package com.teiphu;

/**
 * LCP 19. 秋叶收藏集
 *
 * @author Zheng Lifu
 */
public class MinimumOperations {

	public static void main(String[] args) {
		MinimumOperations mo = new MinimumOperations();
		int res = mo.minimumOperations("yry");
		System.out.println(res);
	}

	/**
	 * ryr
	 *
	 * @param leaves
	 * @return
	 */
	public int minimumOperations(String leaves) {
		int[][] dp = new int[3][leaves.length()];
		for (int i = 0; i < leaves.length(); i++) {
			if (i - 1 >= 0) {
				dp[0][i] = dp[0][i - 1];
			} else {
				dp[0][i] = 0;
			}
			if (leaves.charAt(i) == 'y') {
				dp[0][i] += 1;
			}
			if (i >= 1) {
				dp[1][i] = Math.min(dp[1][i - 1], dp[0][i - 1]);
				if (leaves.charAt(i) == 'r') {
					dp[1][i] += 1;
				}
			} else {
				dp[1][i] = dp[0][i];
			}
			if (i >= 2) {
				dp[2][i] = Math.min(dp[2][i - 1], dp[1][i - 1]);
				if (leaves.charAt(i) == 'y') {
					dp[2][i] += 1;
				}
			} else {
				dp[2][i] = dp[1][i];
			}
		}
		return dp[2][leaves.length() - 1];
	}

	public int minimumOperations1(String leaves) {
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
