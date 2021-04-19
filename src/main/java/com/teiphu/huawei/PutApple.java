package com.teiphu.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 放苹果
 *
 * @author Zheng Lifu
 */
public class PutApple {

	/**
	 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
	 * <p>
	 * 数据范围：0<=m<=10，1<=n<=10。
	 *
	 * 动态规划解法
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			int index = str.indexOf(" ");
			int m = Integer.parseInt(str.substring(0, index));
			int n = Integer.parseInt(str.substring(index + 1));
			int[][] arr = new int[m + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				arr[i][1] = 1;
			}
			for (int i = 1; i <= n; i++) {
				arr[1][i] = 1;
			}
			for (int i = 2; i <= m; i++) {
				for (int j = 2; j <= n; j++) {
					if (i < j) {
						arr[i][j] = arr[i][j - 1];
					} else if (i == j) {
						arr[i][j] = arr[i][j - 1] + 1;
					} else {
						arr[i][j] = arr[i][j - 1] + arr[i - j][j];
					}
				}
			}
			System.out.println(arr[m][n]);
		}
	}
}
