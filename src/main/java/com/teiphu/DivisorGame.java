package com.teiphu;

/**
 * 1025. 除数博弈
 *
 * @author Zheng Lifu
 */
public class DivisorGame {

    public static void main(String[] args) {
        DivisorGame dg = new DivisorGame();
        System.out.println(dg.divisorGame(2));
    }

    public boolean divisorGame(int N) {
        int res = divisor(N, 0);
        return res % 2 == 1;
    }

    private int divisor(int n, int num) {
        if (n == 1) {
            return num;
        }
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) {
                n = n - i;
                break;
            }
        }
        return divisor(n, num + 1);
    }
}
