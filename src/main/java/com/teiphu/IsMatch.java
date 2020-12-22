package com.teiphu;

/**
 * 10. 正则表达式匹配
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 提示: 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class IsMatch {

    public static void main(String[] args) {
        String s = "abefcdgiescdfimde";
        String p = "ab* cd?i*  de";
        s = "mississippi";
        p = "mis*is*p*.";
//		System.out.println(isMatch(s, p));
        IsMatch im = new IsMatch();
        boolean res = im.isMatch(s, p);
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
		char[] sChars = s.toCharArray();
		char[] pChars = p.toCharArray();
		for (int i = 0, j = 0; i < sChars.length; i++, j++) {
			if (sChars[i] == pChars[j]) {
				continue;
			}
			if (pChars[j] == '.') {

			} else if (pChars[j] == '*') {

			}
		}
        return false;
    }


    public static boolean isMatch1(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int k = 0;
        for (int i = 0, j = 0; i < sc.length || j < pc.length; i++, j++) {
            if (i == sc.length && j != pc.length || (i != sc.length && j == pc.length)) {
                return false;
            } else if (sc[i] == pc[j]) {
                continue;
            } else if (pc[j] == '?') {
                continue;
            } else if (pc[j] == '*') {
                if (j == pc.length - 1) {
                    return true;
                }
                for (k = i; k < sc.length; k++) {
                    if (sc[k] == pc[j + 1]) {
                        i = k;
                        j = j + 1;
                        break;
                    }
                }
                if (k == sc.length) {
                    return false;
                }
            } else if (sc[i] != pc[j]) {
                return false;
            }
        }
        return true;
    }

}
