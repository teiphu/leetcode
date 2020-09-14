package com.teiphu;

import java.util.Arrays;

/**
 * @author Zheng Lifu
 */
public class DivingBoard {

    public static void main(String[] args) {
        int shorter = 2;
        int longer = 1118596;
        int k = 979;
        DivingBoard db = new DivingBoard();
        int[] res = db.divingBoard(shorter, longer, k);
        System.out.println(Arrays.toString(res));
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }

}
