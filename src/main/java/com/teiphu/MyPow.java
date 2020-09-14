package com.teiphu;

/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * @author Zheng Lifu
 */
public class MyPow {

    public static void main(String[] args) {
        /*MyPow p = new MyPow();
        double res = p.myPow(2.00000, -2147483648);*/

        System.out.println((Integer.MIN_VALUE + 1) % 2);

    }

    public double myPow1(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 1) {
            n = n / 2;
            return myPow(x * x, n) * x;
        } else {
            n = n / 2;
            return myPow(x * x, n);
        }
    }

    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if (x == -1.0) {
            if (n % 2 == 1 || n % 2 == -1) {
                return -1;
            } else {
                return 1;
            }
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        if (n < 0) {
            n = -n;
            double res = pow(x, n);
            return 1 / res;
        } else {
            return pow(x, n);
        }

    }

    private double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 1) {
            n = n / 2;
            return myPow(x * x, n) * x;
        } else {
            n = n / 2;
            return myPow(x * x, n);
        }
    }
}
