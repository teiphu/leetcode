package com.teiphu;

/**
 * 面试题 05.06. 整数转换
 *
 * @author Zheng Lifu
 */
public class ConvertInteger {

    public static void main(String[] args) {
        ConvertInteger ci = new ConvertInteger();
        int count = ci.convertInteger(826966453, -729934991);
        System.out.println(count);

        /*int a = -42345;
        System.out.println(Integer.toBinaryString(a));
        a = -1;
        System.out.println(Integer.toBinaryString(a));
        a = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(a));*/
        /*int t = -449539388;
        System.out.println(Integer.toBinaryString(t));
        t = t & Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(t));*/

    }

    /**
     * @param A
     * @param B
     * @return
     */
    public int convertInteger(int A, int B) {
        int t = A ^ B;
        int count = 0;
        if (t < 0) {
            t = t & Integer.MAX_VALUE;
            count = 1;
        }
        while (t != 0) {
            if ((t & 1) == 1) {
                count++;
            }
            t = t >> 1;
        }
        return count;
    }

}
