package com.teiphu;

/**
 * 1103. 分糖果 II
 *
 * @author : ZhengLifu
 */
public class DistributeCandies {

    public static void main(String[] args) {
        distributeCandies(16, 5);
    }

    public static int[] distributeCandies(int candies, int num_people) {
//        int sum = (1 + num_people) * num_people / 2;

        int separableNum = (int) (Math.sqrt(candies * 2 + 0.25) - 0.5);
        int sum = (1 + separableNum) * separableNum / 2;
        int remaining = candies - sum;
        int[] res = new int[num_people];
        int j = 0;
        for (int i = 1; i <= separableNum; i++, j++) {
            if (j == num_people) {
                j = 0;
            }
            res[j] += i;
        }
        if (remaining > 0) {
            if (j == num_people) {
                j = 0;
            }
            res[j] += remaining;
        }
        return res;
    }
}
