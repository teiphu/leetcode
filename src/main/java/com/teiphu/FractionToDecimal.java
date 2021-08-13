package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class FractionToDecimal {

    public static void main(String[] args) {
        int numerator = 1;
        int denominator = 32;
        FractionToDecimal ftd = new FractionToDecimal();
        String res = ftd.fractionToDecimal(numerator, denominator);
//        System.out.println(res);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        double d = (double) numerator / denominator;
        System.out.println(d);
        /*int i = (int) d;
        System.out.println(i);
        int i1 = (int) (d * 10) % 10;
        System.out.println(i1);*/

        for (int j = 0; j < 10; j++) {
            d = d * 10;
            int t = (int) (d % 10);
            System.out.println(t);
        }

        return null;
    }
}
