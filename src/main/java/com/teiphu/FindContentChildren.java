package com.teiphu;

import java.util.Arrays;

/**
 * @author TeIphu
 * @data 2018.08.28 22:51
 */
public class FindContentChildren {

    public static void main(String[] args) {

    }

    public static int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        int count = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < m && j < n) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;

        }
        return count;
    }
}
