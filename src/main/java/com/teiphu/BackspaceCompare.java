package com.teiphu;

/**
 * 844. 比较含退格的字符串
 * @Description
 * @author Teiphu
 * @date 2018年8月15日 下午4:34:21
 */
public class BackspaceCompare {

	public static void main(String[] args) {
		// char[] cs = { '0', '1', '2', '3', '4' };
		// String str = String.copyValueOf(cs, 0, 3);
		// System.out.println(str.toString());
		String S = "xywrrmp";
		String T = "xywrrmu#p";
		System.out.println(backspaceCompare(S, T));

	}

	public static boolean backspaceCompare(String S, String T) {
		char[] sArray = S.toCharArray();
		char[] tArray = T.toCharArray();
		int M = S.length();
		int N = T.length();
		int i = -1, j = 0;
		for (; j < M; j++) {
			if (sArray[j] != '#') {
				sArray[++i] = sArray[j];
			} else if (i != -1) {
				i--;
			}
		}
		if (i == -1) {
			S = "";
		} else {
			S = String.copyValueOf(sArray, 0, i + 1);
		}
		for (i = -1, j = 0; j < N; j++) {
			if (tArray[j] != '#') {
				tArray[++i] = tArray[j];
			} else if (i != -1) {
				i--;
			}
		}
		if (i == -1) {
			T = "";
		} else {
			T = String.copyValueOf(tArray, 0, i + 1);
		}
		return S.equals(T);
	}

}
