package com.teiphu;

/**
 * 779. 第K个语法符号
 * 0替换为01，1替换为10
 *
 * @author Zheng Lifu
 */
public class KthGrammar {

    public static void main(String[] args) {
        KthGrammar kg = new KthGrammar();
        int res = kg.kthGrammar(2, 2);
        System.out.println(res);
    }

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        int k1 = (K + 1) / 2;
        int res = kthGrammar(N - 1, k1);
        if ((res == 0 && K % 2 == 1) || (res == 1 && K % 2 == 0)) {
            return 0;
        } else {
            return 1;
        }
    }
}
