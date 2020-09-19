package com.teiphu;

/**
 * @Author Teiphu
 * @Creation 2018.10.06 20:18
 **/
public class GetSum {

    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            b = (a & b) << 1;
            a = a ^ b;
            return getSum(a, b);
        }
    }
}
