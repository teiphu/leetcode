package com.teiphu;

/**
 * 1160. 拼写单词
 * 解
 *
 * @author : ZhengLifu
 */
public class CountCharacters {

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int len = countCharacters(words, chars);
        System.out.println(len);
    }

    public static int countCharacters(String[] words, String chars) {
        int num = chars.length();
        int[] chArr = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            chArr[chars.charAt(i) - 97] += 1;
        }
        int len = 0;
        for (String word : words) {
            int[] temp = chArr.clone();
            int n = num;
            String s = word;
            for (int j = 0; j < s.length(); j++) {
                if (temp[s.charAt(j) - 97] > 0) {
                    temp[s.charAt(j) - 97] -= 1;
                    n--;
                } else {
                    break;
                }
            }
            if (n + s.length() == num) {
                len += s.length();
            }
        }
        return len;
    }

}
