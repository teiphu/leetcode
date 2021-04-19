package com.teiphu.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 取近似值
 *
 * @author Zheng Lifu
 */
public class Approximation {

	/**
	 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			int t = 1;
			int res = 0;
			boolean b = false;
			for (int i = 0; i < str.length(); i++) {
				if ('.' != str.charAt(i)) {
					char ch = str.charAt(i);
					int c = ch - 48;
					if (!b) {
						res = res * t + c;
						t = t * 10;
					} else {
						if (c >= 5) {
							res += 1;
						}
						break;
					}
				} else {
					b = true;
				}
			}
			System.out.println(res);

		}
	}
}
