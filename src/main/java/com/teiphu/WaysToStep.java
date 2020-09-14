package com.teiphu;

/**
 * 面试题 08.01. 三步问题
 *
 * @author Zheng Lifu
 */
public class WaysToStep {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(waysToStep(n));
    }

    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        int n1 = 1;
        int n2 = 2;
        int n3 = 4;
        for (int i = 4; i <= n; i++) {
            int res = (((n3 + n2) % 1000000007) + n1) % 1000000007;
            n1 = n2;
            n2 = n3;
            n3 = res;
        }
        return n3;
    }
}
