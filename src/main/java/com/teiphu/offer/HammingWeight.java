package com.teiphu.offer;

/**
 * 剑指 Offer 15. 二进制中1的个数
 *
 * @author Zheng Lifu
 */
public class HammingWeight {

    public static void main(String[] args) {
        int n = -1;
        HammingWeight hw = new HammingWeight();
        int res = hw.hammingWeight(n);
        System.out.println(res);
    }

    public int hammingWeight(int n) {
        int t = n;
        if (n < 0) {
            t = n & Integer.MAX_VALUE;
        }
        int res = weight(t);
        if (n < 0) {
            res += 1;
        }
        return res;
    }

    public int weight(int n) {
        int num = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                num++;
            }
            n = n >> 1;
        }
        return num;
    }
}
