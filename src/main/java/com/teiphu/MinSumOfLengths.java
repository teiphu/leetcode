package com.teiphu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1477. 找两个和为目标值且不重叠的子数组
 *
 * @author Zheng Lifu
 */
public class MinSumOfLengths {

    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 1, 5, 1, 2, 1};
        int target = 3;
        int res = minSumOfLengths(arr, target);
        System.out.println(res);
    }

    private static int minSumOfLengths(int[] arr, int target) {
        // 累加数组：[1, 3, 4, 7, 8, 10, 11, 3]
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, -1);
        int notFound = Integer.MAX_VALUE;

        //min是答案
        int min = notFound;

        //比如输入样例为arr = [1, 2, 1, 3, 1, 2, 1], target = 3时
        //对应的数组record是[0, 0, 2, 2, 1, 1, 1, 1]
        // 可以取前i个数字时组成target的1个子数组的最短长度
        int[] record = new int[arr.length + 1];
        Arrays.fill(record, notFound);

        //累加器
        int sum = 0;

        //比如输入样例为arr = [1, 2, 1, 3, 1, 2, 1], target = 3时
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //前面是否有正好小3的sum，即两者之间的数组，累加之后正好是一个target
            if (sums.get(sum - target) != null) {
                //产生了一个target
                int leftIdx = sums.get(sum - target);
                int lastRecord = record[leftIdx + 1];
                int nowRecord = i - leftIdx;
                record[i + 1] = nowRecord;
                if (lastRecord != notFound) {
                    min = Math.min(min, lastRecord + nowRecord);
                }
            }
            //比较后记录
            record[i + 1] = Math.min(record[i], record[i + 1]);
            sums.put(sum, i);
        }
        return min == notFound ? -1 : min;
    }

    /**
     * 思路：可以找出所有等于target的子数组，再从中选出长度和最小的。
     *
     * @param arr
     * @param target
     * @return
     */
    private static int minSumOfLengths0(int[] arr, int target) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += arr[j];
                if (sum == target) {
                    dp[i] = i - j + 1;
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int min = Integer.MAX_VALUE;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] != 0) {
                for (int j = i - dp[i]; j >= 0; j--) {
                    if (dp[j] != 0) {
                        min = Math.min(min, dp[i] + dp[j]);
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }
}
