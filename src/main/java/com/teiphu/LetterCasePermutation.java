package com.teiphu;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 784. 字母大小写全排列
 *
 * @Author Teiphu
 * @Creation 2018.09.19 14:17
 **/
public class LetterCasePermutation {

    public static void main(String[] args) {

    }

    /**
     * DFS解法
     *
     * @param S
     * @return
     */
    public List<String> letterCasePermutation0(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S, res, 0);
        return res;
    }

    private void helper(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        if (Character.isDigit(s.charAt(pos))) { //如果该位置是数字
            helper(s, res, pos + 1);
            return;
        }

        char[] cs = s.toCharArray();
        cs[pos] = Character.toLowerCase(cs[pos]);
        helper(String.valueOf(cs), res, pos + 1);

        cs[pos] = Character.toUpperCase(cs[pos]);
        helper(String.valueOf(cs), res, pos + 1);
    }

    /**
     * BFS解法
     *
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                continue;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] cs = cur.toCharArray();

                cs[i] = Character.toUpperCase(cs[i]);
                queue.offer(String.valueOf(cs));

                cs[i] = Character.toLowerCase(cs[i]);
                queue.offer(String.valueOf(cs));
            }
        }
        return new LinkedList<>(queue);
    }

}
