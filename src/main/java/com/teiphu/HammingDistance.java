package com.teiphu;

/**
 * 461. 汉明距离
 * 解
 *
 * @author Zheng Lifu
 */
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        int res = hd.hammingDistance(19, 8);
        System.out.println(res);

        /*int n = 2;
        for (int i = 2; i < 31; i++) {
            n *= 2;
            System.out.println("i = " + i + "; " + n);
        }*/
    }

    /**
     * 使用位运算解决
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            count += (res & 1);
            res = res >> 1;
        }
        return count;
    }

}
