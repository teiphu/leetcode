package com.teiphu.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 未解
 *
 * @author Zheng Lifu
 */
public class MinArray {

	public static void main(String[] args) {
		MinArray ma = new MinArray();
		int res = ma.minArray(new int[]{2, 2, 2, 0, 1});
		System.out.println(res);
	}

	public int minArray(int[] numbers) {
		if (numbers.length == 1) {
			return numbers[0];
		}
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			int mid = start + ((end - start) >> 1);
			if (numbers[mid] < numbers[end]) {
				end = mid;
			} else if (numbers[mid] > numbers[end]) {
				start = mid + 1;
			} else {
				end = end - 1;
			}
		}
		return numbers[start];
		/*while (start <= end && numbers[mid - 1] < numbers[mid + 1]) {
			if (numbers[mid] < numbers[0]) {
				end = mid - 1;
			} else if (numbers[mid] > numbers[0]) {
				start = mid + 1;
			} else {
				break;
			}
		}
		if (numbers[mid - 1] < numbers[mid]) {
			return numbers[mid + 1];
		} else {
			return numbers[mid];
		}*/
	}

}
