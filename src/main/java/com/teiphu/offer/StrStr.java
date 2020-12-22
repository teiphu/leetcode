package com.teiphu.offer;

/**
 * 28. 实现 strStr()
 *
 * @author Zheng Lifu
 */
public class StrStr {

    public static void main(String[] args) {
        StrStr ss = new StrStr();
        int res = ss.strStr("aaaaa", "bba");
        System.out.println(res);
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        int t = 0;
        int i = t;
        int j = 0;
        for (; i < haystack.length() && j < needle.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = 0;
                t++;
                i = t;
            }
        }
        if (j == needle.length()) {
            return t;
        } else {
            return -1;
        }
    }
}
