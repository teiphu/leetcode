package com.teiphu;

import java.util.Arrays;

/**
 * 面试题16.01 交换数字
 *
 * @author Zheng Lifu
 */
public class SwapNumbers {

    public static void main(String[] args) {
        SwapNumbers sn = new SwapNumbers();
        int[] numbers = {343, 4};
        int[] res = sn.swapNumbers(numbers);
        System.out.println(Arrays.toString(res));
    }

    /**
     * x:  0101    0110            0011
     * y:  0011            0101
     *
     * @param numbers
     * @return
     */
    public int[] swapNumbers(int[] numbers) {
        int a = numbers[0];
        int b = numbers[1];
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a, b};
    }
}
