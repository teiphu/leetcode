package org.teiphu;

/**
 * 557. 反转字符串中的单词 III
 *
 * @Author Teiphu
 * @Creation 2018.10.05 15:38
 **/
public class ReverseWords {

    public static void main(String[] args) {
        char[] cs = {'w', 'e', 'r', 't', 'y'};
        StringBuilder sb = new StringBuilder();
        sb.append(cs, 1, 4);
        System.out.println(sb.toString());

    }

    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        int j = n - 1;
        char t;
        //先整体反转所有的字母
        while (i < j) {
            t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
            i++;
            j--;
        }
        //再从后面开始添加单词
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (int k = n - 1; k >= 0; k--) {
            if (!Character.isSpaceChar(cs[k])) {
                len++;
            } else {
                sb.append(cs, k + 1, len);
                sb.append(" ");
                len = 0;
            }
        }
        sb.append(cs, 0, len);
        return sb.toString();
    }

}
