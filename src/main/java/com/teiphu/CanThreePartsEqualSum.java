package com.teiphu;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 1013. 将数组分成和相等的三个部分
 * 解
 */
public class CanThreePartsEqualSum {

	public boolean canThreePartsEqualSum(int[] A) {
		/*OptionalInt sumOpt = Arrays.stream(A).reduce(Integer::sum);
		int sum = sumOpt.getAsInt();*/
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		if (sum % 3 != 0) {
			return false;
		}
		int part = sum / 3;
		int temp = part;
		int num = 0;
		for (int i = 0; i < A.length; i++) {
			temp -= A[i];
			if (temp == 0) {
				temp = part;
				num++;
			}
		}
		if (num < 3) {
			return false;
		}
		return true;
	}

}
