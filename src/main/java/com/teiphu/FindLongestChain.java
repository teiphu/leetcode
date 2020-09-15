package org.teiphu;

import java.util.Arrays;

/**
 * 646. 最长数对链
 *
 * @Author Teiphu
 * @Creation 2018.09.21 23:44
 **/
public class FindLongestChain {

    public static void main(String[] args) {
        int[][] pairs = {{1, 5}, {3, 8}, {2, 4}};
        findLongestChain(pairs);
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int i = 0;
        int sum = 0;
        int n = pairs.length;
        while (i < n) {
            sum++;
            int curEnd = pairs[i][1];
            while (i + 1 < n && pairs[i + 1][0] <= curEnd) {
                i++;
            }
            i++;
        }
        return sum;
    }

    private static void print(int[][] pairs) {
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs[i].length; j++) {
                System.out.print(pairs[i][j] + " ");
            }
            System.out.println();

        }
    }
}
