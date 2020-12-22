package com.teiphu.offer;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * @author Zheng Lifu
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        PlusOne po = new PlusOne();
        int[] arr = po.plusOne(digits);
        System.out.println(Arrays.toString(arr));

    }

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (i == -1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }
}
