package com.teiphu.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.电话号码的字母组合
 *
 * @author Zheng Lifu
 */
public class LetterCombinations {

    private static Map<String, String> dict = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        helper(res, digits, "", 0);
        return res;
    }

    private static void helper(List<String> res, String digits, String s, int i) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String ch = String.valueOf(digits.charAt(i));
        String val = dict.get(ch);
        for (int j = 0; j < val.length(); j++) {
            helper(res, digits, s + val.charAt(j), i + 1);
        }
    }
}
