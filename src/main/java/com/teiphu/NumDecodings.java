package com.teiphu;

/**
 * 91.解码方法
 *
 * @author Zheng Lifu
 */
public class NumDecodings {

    public static void main(String[] args) {
        String s = "12";
        NumDecodings nd = new NumDecodings();
        System.out.println(nd.numDecodingsByRecursive(s));
    }

    public int numDecodings(String s) {
        for (int i = 0; i < s.length(); i++) {

        }
        return -1;
    }

    public int numDecodingsByRecursive(String s) {
        if (s.length() == 1) {
            return 1;
        } else if (s.length() == 0) {
            return 1;
        }
        int len = s.length();

        if (s.charAt(len - 2) != '0') {
            String sub = s.substring(len - 2);
            int num = Integer.parseInt(sub);
            if (num <= 26) {
                return numDecodings(s.substring(0, len - 2)) + numDecodings(s.substring(0, len - 1));
            } else {
                return numDecodings(s.substring(0, len - 1));
            }
        } else {
            return numDecodings(s.substring(0, len - 1));
        }
    }
}
