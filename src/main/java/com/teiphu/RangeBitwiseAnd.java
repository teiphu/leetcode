package com.teiphu;

/**
 * @Author Teiphu
 * @Creation 2018.10.11 11:49
 **/
public class RangeBitwiseAnd {

    public static int rangeBitwiseAnd(int m, int n) {
        String str = Integer.toBinaryString(m);
        char[] chars = str.toCharArray();
        int len = chars.length;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[i] = '1';
        }
        for (int i = m; i <= n; i++) {
            str = Integer.toBinaryString(i);
            chars = str.toCharArray();
            printChars(chars);
            for (int j = chars.length - len, k = 0; j < chars.length; j++, k++) {
                if (chars[j] == '0') {
                    res[k] = '0';
                }
            }
        }
//        String s = String.valueOf(res);
//        int result = convertAlgorism(res);
        int result = Integer.valueOf(String.valueOf(res), 2);
        return result;
    }


    private static void printChars(char[] chars) {
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println();
    }
}
