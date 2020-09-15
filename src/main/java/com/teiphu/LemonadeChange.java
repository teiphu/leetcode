package org.teiphu;

/**
 * @author TeIphu
 * @data 2018.08.28 21:14
 */
public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int tenNum = 0;
        int fiveNum = 0;
        int n = bills.length;
        int change = 0;
        for (int i = 0; i < n; i++) {
            change = bills[i] - 5;

            if (change != 0) {
                if (change == 5) {
                    tenNum++;
                }
                if (tenNum != 0 && change - 10 >= 0) {
                    tenNum--;
                    change = change - 10;
                }
                if (change / 5 <= fiveNum) {
                    fiveNum = fiveNum - change / 5;
                    change = 0;
                }
            } else {
                fiveNum++;
                change = 0;
            }
            if (change != 0) {
                return false;
            }
        }
        return true;
    }
}
