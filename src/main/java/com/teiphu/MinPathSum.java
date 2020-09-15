package org.teiphu;

/**
 * ��С·����
 * @author Lonuan
 * @creation 2018��5��8��
 */
public class MinPathSum {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//		System.out.println(arr.length);
		int result = minPathSum(arr);
		System.out.println();
		System.out.println(result);
//		printArray(arr);
	}
	
	public static int minPathSum(int[][] grid) {
		int[] temp = new int[grid[0].length];
		temp[0] = grid[0][0];
		for (int i = 1; i < grid[0].length; i++) {
			temp[i] = temp[i-1] + grid[0][i];
		}
		printArray(temp);
		
		for (int j = 1; j < grid.length; j++) {
			temp[0] = grid[j][0] + temp[0];
			System.out.println(temp[0]);
			for (int k = 1; k < grid[0].length; k++) {
				temp[k] = Math.min(temp[k-1], temp[k]) + grid[j][k];
			}
			printArray(temp);
		}
		return temp[grid[0].length-1];
	}
	
	private static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1] + "]");
	}
	
	@SuppressWarnings("unused")
	private static void printArray(int[][] arr) {
		System.out.println("[");
		for (int i = 0; i < arr.length; i++) {
			printArray(arr[i]);
		}
		System.out.println("]");
	}

}
