package com.teiphu;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * @author : ZhengLifu
 */
public class NumWays {

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        long start = System.currentTimeMillis();
        System.out.println(numWays.numWays(44));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public int numWays(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int pre = 1;
        int next = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = (pre + next) % 1000000007;
            pre = next;
            next = res;
        }
        return res;
    }
}
