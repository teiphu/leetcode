package com.teiphu;

/**
 * 507. 完美数
 *
 * @Author Teiphu
 * @Creation 2018.09.24 11:44
 **/
public class CheckPerfectNumber {

    public static void main(String[] args) {
//        System.out.println(checkPerfectNumber(28));
//        int t = 28 & (7-1);
//        System.out.println(t);
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        int i = 1;
        for (; i < num && sum <= num; i++) {
            System.out.println(i);
            if ((num % i) == 0) {
                sum += i;
            }
        }
        if (sum == num && i == num) {
            return true;
        }
        return false;
    }
}
