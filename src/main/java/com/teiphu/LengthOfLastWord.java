package org.teiphu;

/**
 * @Author Teiphu
 * @Creation 2018.10.11 11:04
 **/
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));

    }

    private static int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int i = len - 1;
        int n = 0;
        while (i >= 0 && Character.isSpaceChar(cs[i])) {
            i--;
        }
        if (i < 0) {
            return 0;
        }
        while (i >= 0 && !Character.isSpaceChar(cs[i--])) {
            n++;
        }
        return n;
    }
}
