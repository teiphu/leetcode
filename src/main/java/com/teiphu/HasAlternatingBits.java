package com.teiphu;

/**
 * 693. 交替位二进制数
 *
 * @author Zheng Lifu
 */
public class HasAlternatingBits {

    public static void main(String[] args) {
        HasAlternatingBits hab = new HasAlternatingBits();
        int n = 1431655765;
        boolean res = hab.hasAlternatingBits1(n);
        System.out.println(res);

    }

    /**
     * 耗时较久
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits1(int n) {
        int[] arr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
                65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216,
                33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483647};
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (n < arr[i]) {
                index = i - 1;
                break;
            }
        }
        for (int i = index; i >= 0; i = i - 2) {
            n = n - arr[i];
            if (n < 0) {
                return false;
            }
        }
        return n <= 0;
    }

    public boolean hasAlternatingBits(int n) {
        boolean b = n % 2 == 1;
        n = n >> 1;
        while (n != 0) {
            int t = n % 2;
            if ((b && t == 1) || (!b && t == 0)) {
                return false;
            }
            b = (t == 1);
            n = n >> 1;
        }
        return true;
    }
}
