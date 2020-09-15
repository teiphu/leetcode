package org.teiphu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: TeIphu
 * @date: 2020.03.29 下午 08:25
 **/
public class MaxDistance {

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        if (n <= 1) return -1;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.size() == 0 || queue.size() == n * n) {
            return -1;
        }

        int len = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int[] direction : directions) {
                    int x1 = x + direction[0];
                    int y1 = y + direction[1];
                    if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n
                            && grid[x1][y1] == 0) {
                        grid[x1][y1] = 2;
                        queue.add(new int[]{x1, y1});
                    }

                }
            }
            len++;
        }
        return len;

    }
}
