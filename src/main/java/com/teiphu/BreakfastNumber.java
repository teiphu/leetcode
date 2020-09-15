package org.teiphu;

import java.util.Arrays;

/**
 * LCP 18. 早餐组合
 *
 * @author Zheng Lifu
 */
public class BreakfastNumber {

	public static void main(String[] args) {
		BreakfastNumber bfn = new BreakfastNumber();
		int[] staple = {10, 20, 5};
		int[] drinks = {5, 5, 2};
		int x = 15;
		int res = bfn.breakfastNumber(staple, drinks, x);
		System.out.println(res);

	}

	public int breakfastNumber(int[] staple, int[] drinks, int x) {

		Arrays.sort(staple);
		Arrays.sort(drinks);
		int sum = 0;
		int last = drinks.length - 1;
		for (int value : staple) {
			int t = x - value;
			if (t > 0) {
				for (int j = last; j >= 0; j--) {
					if (drinks[j] <= t) {
						sum += j + 1;
						sum %= 1000000007;
						last = j;
						break;
					}
				}
			} else {
				break;
			}
		}
		return sum;

		/*int sum = 0;
		for (int i = 0; i < staple.length; i++) {
			int t = sum - staple[i];
			if (t > 0) {
				for (int j = 0; j < drinks.length; j++) {
					if (drinks[j] <= t) {
						sum += 1;
						sum %= 1000000007;
					}
				}
			}
		}
		return sum;*/

		/*quickSort(staple);
		quickSort(drinks);
		int sum = 0;
		int last = drinks.length - 1;
		for (int i = 0; i < staple.length; i++) {
			for (int j = last; j >= 0; j--) {
				if (staple[i] + drinks[j] <= x) {
					sum += j + 1;
					sum %= 1000000007;
					last = j;
					break;
				}
			}
		}
		return sum;*/
		/*int sum = 0;
		for (int i = 0; i < staple.length; i++) {
			for (int j = 0; j < drinks.length; j++) {
				if (staple[i] + drinks[j] <= x) {
					sum += 1;
					sum %= 1000000007;
				}
			}
		}
		return sum;*/
	}

	private void quickSort(int[] a) {
		int N = a.length;
		quickSor(a, 0, N - 1);
	}

	private void quickSor(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int index = partition(a, lo, hi);
		quickSor(a, lo, index - 1);
		quickSor(a, index + 1, hi);
	}

	private int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1; //此处+1是为了下面的循环
		int v = a[lo];
		while (true) {
			while (a[++i] < v) {   //相当于while(a[++i] < v)
				if (i == hi)
					break;
			}
			while (v < a[--j]) {   //相当于while(a[--j] > v)
				if (j == lo)
					break;
			}
			if (i >= j)
				break;
			exchge(a, i, j);
		}
		exchge(a, lo, j);
		return j;
	}

	private void exchge(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}


}
