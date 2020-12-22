package com.teiphu;

/**
 * 14. 最长公共前缀
 *
 * @author Zheng Lifu
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String s = lcp.longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    break;
                }
            }
            if (j == strs.length) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
