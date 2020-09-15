package org.teiphu;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * 945. 使数组唯一的最小增量
 * 解
 */
public class MinIncrementForUnique {

	public static void main(String[] args) {
		int[] A = {3, 2, 1, 2, 1, 7};
		System.out.println(minIncrementForUnique(A));

		/*int[] B = {3, 4, 1, 2, 5, 7};
		minIncrementForUnique(B);*/
//		1  2  3  4  5  7
	}

	public static int minIncrementForUnique(int[] A) {
		if (A.length <= 1) {
			return 0;
		}
		Arrays.sort(A);
		int initialValue = Arrays.stream(A).sum();
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) {
				queue.add(i);
			} else {
				if (A[i] - A[i - 1] > 1) {
					for (int j = A[i - 1] + 1; j < A[i]; j++) {
						Integer t = queue.poll();
						if (t != null) {
							A[t] = j;
						} else {
							break;
						}
					}
				}
			}
		}
		if (queue.size() > 0) {
			for (int i = A[A.length - 1] + 1; true; i++) {
				Integer t = queue.poll();
				if (t != null) {
					A[t] = i;
				} else {
					break;
				}
			}
		}
		int sum = Arrays.stream(A).sum();
		return sum - initialValue;
	}

	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + "  ");
		}
		System.out.println();
	}
}

