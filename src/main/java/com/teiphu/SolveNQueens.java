package com.teiphu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 * @Author Teiphu
 * @Creation 2018.10.01 19:26
 **/
public class SolveNQueens {

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(lists, board, n, 0);
        return lists;
    }

    private static void backtrack(List<List<String>> lists, char[][] board, int n, int level) {
        if (level == n) {
            List<String> list = new ArrayList<>();
            arrayToList(list, board, n);
            lists.add(list);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (isSafe(board, i, level)) {
                    board[i][level] = 'Q';
                    backtrack(lists, board, n, level + 1);
                    board[i][level] = '.';
                }
            }
            return;
        }
    }

    private static void arrayToList(List<String> list, char[][] board, int n) {
        String str;
        for (int i = 0; i < n; i++) {
            str = String.valueOf(board[i]);
            list.add(str);
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
//        检查row行的左侧
        for (i = 0; i < col; i++)
            if (board[row][i] == 'Q')
                return false;

        /* Check upper diagonal on left side */
//        检查左上对角线
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        /* Check lower diagonal on left side */
//        检查左下对角线
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

}
