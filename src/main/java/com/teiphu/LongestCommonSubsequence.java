package com.teiphu;

/**
 * 1143. 最长公共子序列
 *
 * @author Zheng Lifu
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "ezupkr";
        String text2 = "ubmrapg";
        int res = longestCommonSubsequence0(text1, text2);
        System.out.println(res);

    }

    /**
     * 有缺陷
     *
     * @param text1
     * @param text2
     * @return
     */
    private static int longestCommonSubsequence0(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int last = 0;
        int index = -1;
        int index1 = -1;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j) && i > index && j > index1) {
                    index = i;
                    index1 = j;
                    last++;
                }
            }
        }
        return last;
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
