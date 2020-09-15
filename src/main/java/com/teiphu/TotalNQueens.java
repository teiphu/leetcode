package org.teiphu;

import java.util.Scanner;

/**
 * 52. N皇后 II
 * @Author Teiphu
 * @Creation 2018.10.01 22:07
 **/
public class TotalNQueens {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(totalNQueens(n));
            System.out.println(totalNQueens0(n));

        }
    }

    public static int totalNQueens0(int n) {
        if (n == 0) {
            return 0;
        }
        int[][] board = new int[n][n];
        int num = backtrack(board, n, 0);
        return num;
    }

    private static int backtrack(int[][] board, int n, int level) {
        if (level == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (isSafe(board, i, level)) {
                    board[i][level] = 1;
                    count += backtrack(board, n, level + 1);
                    board[i][level] = 0;
                }
            }
            return count;
        }
    }

    private static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
//        检查row行的左侧
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
//        检查左上对角线
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
//        检查左下对角线
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        int[] board = new int[n];
        int num = backtrack(board, n, 0);
        return num;
    }

    private static int backtrack(int[] board, int n, int level) {
        if (level == n) {
            return 1;
        } else {
            int mask = 0;
            for (int i = 0; i < level; i++) {
                int pos = board[i];
                mask = mask | pos | (pos << (level - i)) | (pos >>> (level - i));
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) == 0) {
                    board[level] = (1 << i);
                    count += backtrack(board, n, level + 1);
                    board[level] = 0;
                }
            }
            return count;
        }
    }


}
