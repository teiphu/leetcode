package org.teiphu;

public class ModifyString {

	public static void main(String[] args) {
		ModifyString ms = new ModifyString();
		System.out.println(ms.modifyString("??yw?ipkj?"));

	}

	public String modifyString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char pre = '?';
			char next = '?';
			if (s.charAt(i) == '?') {
				if (i - 1 >= 0) {
					pre = sb.charAt(i - 1);
				}
				if (i + 1 < s.length()) {
					next = s.charAt(i + 1);
				}
				for (int j = 'a'; j <= 'z'; j++) {
					if (j != pre && j != next) {
						char ch = (char) j;
						sb.append(ch);
						break;
					}
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
