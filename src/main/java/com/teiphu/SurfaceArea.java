package com.teiphu;

/**
 * 892. 三维形体的表面积
 * 解
 *
 * @author : ZhengLifu
 */
public class SurfaceArea {

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
        System.out.println(surfaceArea(grid));
    }

    public static int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int t = (grid[i][j] - 1) * 2;
                t = grid[i][j] * 6 - t;
                if (i >= 1) {
//                    t -= grid[i - 1][j] <= grid[i][j] ? grid[i - 1][j] : grid[i][j];
                    t -= Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (i + 1 < grid.length) {
//                    t -= grid[i + 1][j] <= grid[i][j] ? grid[i + 1][j] : grid[i][j];
                    t -= Math.min(grid[i][j], grid[i + 1][j]);
                }
                if (j >= 1) {
//                    t -= grid[i][j - 1] <= grid[i][j] ? grid[i][j - 1] : grid[i][j];
                    t -= Math.min(grid[i][j], grid[i][j - 1]);
                }
                if (j + 1 < grid[0].length) {
//                    t -= grid[i][j + 1] <= grid[i][j] ? grid[i][j + 1] : grid[i][j];
                    t -= Math.min(grid[i][j], grid[i][j + 1]);
                }
                System.out.println(t);
                sum += t;
            }
        }
        return sum;
    }
}
