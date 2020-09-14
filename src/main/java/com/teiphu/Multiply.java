package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class Multiply {

    public static void main(String[] args) {
        Multiply m = new Multiply();
        int res = m.multiply(1, 10);
        System.out.println(res);
    }

    public int multiply(int A, int B) {
        if (B == 1) {
            return A;
        }
        if (B % 2 == 1) {
            B = B / 2;
            return multiply(A << 1, B) + A;
        } else {
            B = B / 2;
            return multiply(A << 1, B);
        }
    }

}
