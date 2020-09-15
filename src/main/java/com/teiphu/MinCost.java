package org.teiphu;

public class MinCost {

	public static void main(String[] args) {
		MinCost mc = new MinCost();
		System.out.println(mc.minCost("aaaaaaaaaaaaaa", new int[]{1, 3, 6, 5, 4, 5, 4, 4, 2, 8, 3, 10, 6, 6}));
	}

	public int minCost(String s, int[] cost) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int costs = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		for (int i = 1, j = 0, k = 0; i < s.length(); i++) {
			if (s.charAt(i) == sb.charAt(j)) {
				if (cost[k] < cost[i]) {
					costs += cost[k];
					k = i;
				} else {
					costs += cost[i];
				}
			} else {
				sb.append(s.charAt(i));
				j++;
				k = i;
			}
		}
		return costs;
	}
}
