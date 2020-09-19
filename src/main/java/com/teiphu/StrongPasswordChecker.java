package com.teiphu;

import java.awt.JobAttributes.SidesType;

/**
 * 420. 强密码检验器
 * @Description
 * @author Teiphu
 * @date 2018年8月21日 下午3:06:52
 */
public class StrongPasswordChecker {

	public static void main(String[] args) {

	}
	
	public int strongPasswordChecker(String s) {
		char[] cs = s.toCharArray();
		int N = s.length();
		int rep = 1;
		int uppercase = 0;
		int lowercase = 0;
		for (int i = 0; i < N; i++) {
			if (Character.isUpperCase(cs[i])) {
				uppercase++;
			} else if (Character.isLowerCase(cs[i])) {
				lowercase++;
			}
		}
//		for (int i = 1; i < N; i++) {
//			if () {
//				
//			}
//			if (cs[i] == cs[i-1]) {
//				rep++;
//			} else {
//				if (rep > 3) {
//					
//				}
//				rep = 1;
//			}
//		}
		return 0;
	}

}


















