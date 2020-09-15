package org.teiphu;

import java.util.*;

/**
 * @author Zheng Lifu
 */
public class UnhappyFriends {

	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		Map<Integer, Integer> pairsMap = new HashMap<>();
		for (int[] pair : pairs) {
			pairsMap.put(pair[0], pair[1]);
			pairsMap.put(pair[1], pair[0]);
		}
		return -1;
	}
}
