package com.teiphu;


import java.util.LinkedList;
import java.util.Queue;

public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int old = 0;
        int cur = 0;
        do {
            old = cur;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] != -1) {
                    arr[prerequisites[i][1]] += 1;
                }

            }
            for (int i = 0; i < numCourses; i++) {
                if (arr[i] == 0) {
                    queue.add(i);
                    arr[i] = -1;
                } else if (arr[i] > 0) {
                    arr[i] = 0;
                }
            }
            while (queue.size() != 0) {
                int v = queue.poll();
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][0] == v) {
                        prerequisites[i][0] = -1;
                        prerequisites[i][1] = -1;
                        cur++;
                    }
                }
            }

        } while (old != cur);
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] != -1) {
                return false;
            }
        }

        return true;
    }

}
