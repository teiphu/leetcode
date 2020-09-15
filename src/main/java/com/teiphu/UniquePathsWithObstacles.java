package org.teiphu;

public class UniquePathsWithObstacles {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[][] arr = {{0,0,0}, {0,1,0}, {0,0,0}};
		
		printArray(arr);
		uniquePathsWithObstacles(arr);
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] arr = obstacleGrid;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = -1;
				}
			}
		}
		printArray(arr);
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] != -1) {
				arr[0][i] = 1;
			}
		}
		printArray(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] != -1) {
				arr[i][0] = 1;
			}
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i][j] == -1) {
					continue;
				}
				if (arr[i-1][j] != -1 && arr[i][j-1] == -1) {
					arr[i][j] = arr[i-1][j];
				} else if (arr[i-1][j] == -1 && arr[i][j-1] != -1) {
					arr[i][j] = arr[i][j-1];
				} else if (arr[i-1][j] == -1 && arr[i][j-1] == -1) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			}
		}
		printArray(arr);
		return arr[arr.length-1][arr[0].length-1];
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
