package com.teiphu.offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 *
 * @author Zheng Lifu
 */
public class SumNums {

    public static void main(String[] args) {
        SumNums sn = new SumNums();
        int res = sn.sumNums(10);
        System.out.println(res);
    }

    public int sumNums(int n) {
        int sum = sum(n);
        return sum;
    }

    public int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
