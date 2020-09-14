package com.teiphu;

/**
 * 1093. 大样本统计
 *
 * @author : ZhengLifu
 * @message : 未解
 */
public class SampleStats {

    public double[] sampleStats(int[] count) {
        int min = count[0];
        int max = count[0];
        double average = 0;
        int sum = 0;
        int[] modeArr = new int[256];
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (count[i] < min) {
                min = count[i];
            }
            if (count[i] > max) {
                max = count[i];
            }
            sum += count[i];
            modeArr[count[i]]++;
        }
        average = sum * 1.0 / count.length;
        int mode = 0;
        for (int i = 1; i < modeArr.length; i++) {
            if (modeArr[i] > modeArr[mode]) {
                mode = i;
            }
        }

        double median = 0;
        if (count.length % 2 == 0) {
            int temp = 2;
            int mid = count.length / 2;
            int num = 0;
            for (int i = 0; i < modeArr.length; i++) {
                num += modeArr[i];
                if (num < mid - 1) {
                    continue;
                } else if (num == mid - 1) {
                    median += i;
                    temp--;
                } else if (num >= mid) {
                    if (temp < 2) {
                        median += i;
                        median = median / 2.0;
                    } else {
                        median = i;
                    }
                    break;
                }
            }
        } else {
            int num = 0;
            int mid = count.length / 2;
            for (int i = 0; i < modeArr.length; i++) {
                num += modeArr[i];
                if (num >= mid) {
                    median = i;
                    break;
                }
            }
        }
        double[] res = new double[]{min, max, average, median, mode};
        return res;
    }

}
