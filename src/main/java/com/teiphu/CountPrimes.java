package com.teiphu;

/**
 * 204. 计数质数
 *
 * @author Zheng Lifu
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        int res = cp.countPrimes(3);
        System.out.println(res);

    }

    public int countPrimes(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        boolean[] arr = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!arr[i]) {
                for (int j = 2; i * j < n; j++) {
                    int product = i * j;
                    arr[product] = true;
                }
            }
        }
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                count++;
            }
        }
        return count;
    }
}
