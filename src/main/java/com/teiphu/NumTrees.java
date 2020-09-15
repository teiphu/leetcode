package org.teiphu;

import java.util.Scanner;

/**
 * @Author Teiphu
 * @Creation 2018.09.21 14:17
 **/
public class NumTrees {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(numTrees(n));
        }
    }

    private static int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        int val;
        for (int i = 2; i <= n; i++) {
            val = 0;
            for (int j = 0; j < i; j++) {
                val += (arr[j] * arr[i - 1 - j]);
            }
            arr[i] = val;
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
        return arr[n];
    }

    private static int numTrees0(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        int val;
        int j;
        for (int i = 2; i <= n; i++) {
            val = 0;
            for (j = 0; j < i / 2; j++) {
                val += (arr[j] * arr[i - 1 - j]) * 2;
            }
            if (i % 2 == 1) {
                val += (arr[j] * arr[j]);
            }
            arr[i] = val;
        }
        return arr[n];
    }
}
