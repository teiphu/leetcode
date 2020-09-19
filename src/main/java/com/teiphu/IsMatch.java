package com.teiphu;

public class IsMatch {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String s = "abefcdgiescdfimde";
		String p = "ab* cd?i*  de";
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p) {
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		int k = 0;
		for (int i = 0, j = 0; i < sc.length || j < pc.length; i++, j++) {
			if (i == sc.length && j != pc.length || (i != sc.length && j == pc.length)) {
				return false;
			}else if (sc[i] == pc[j]) {
				continue;
			} else if (pc[j] == '?') {
				continue;
			} else if (pc[j] == '*') {
				if (j == pc.length - 1) {
					return true;
				}
				for (k = i; k < sc.length; k++) {
					if (sc[k] == pc[j+1]) {
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
