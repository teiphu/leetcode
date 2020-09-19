package com.teiphu;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = new int[]{5, 7, 3, 1, 2, 0, 8};
		coinChange(coins, 4);
	}

	public static int coinChange(int[] coins, int amount) {
		if (coins.length == 0) {
			return -1;
		}
		int[] arr = new int[amount + 1];
		Arrays.fill(arr, amount + 1);
		arr[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					arr[i] = Math.min(arr[i], arr[i - coin] + 1);
				}
			}
		}
		return arr[amount] == (amount + 1) ? -1 : arr[amount];
	}

}
