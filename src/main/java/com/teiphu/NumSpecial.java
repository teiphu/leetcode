package com.teiphu;

import java.util.*;

/**
 * @author Zheng Lifu
 */
public class NumSpecial {
	public static void main(String[] args) {
		NumTriplets nt = new NumTriplets();

	}

	public int numSpecial(int[][] mat) {
		if (mat == null) {
			return 0;
		}
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					x.add(i);
					y.add(j);
				}
			}
		}
		for (int i = 1; i < x.size(); i++) {
			if (x.get(i).equals(x.get(i - 1))) {
				set.add(i);
				set.add(i - 1);
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < y.size(); i++) {
			Integer t = map.get(y.get(i));
			if (t != null) {
				set.add(t);
				set.add(i);
			} else {
				map.put(y.get(i), i);
			}
		}
		return x.size() - set.size();
	}
}
