package com.teiphu;

import java.util.Arrays;

/**
 * @author Lifu.Zheng
 * @data 2018.04.09 12:30
 */
public class RemoveDuplicates {

    /**
     * 最快算法
     * @param nums
     * @return
     */
    public static int removeDuplicates0(int[] nums) {
        int n = 1;
        int sum = 1;
        if(nums.length==0) return 0;
        int len = nums.length;
        int[] num = new int[len];
        num = Arrays.copyOf(nums,nums.length);
        for(int i = 1; i<num.length ; i++){
            if(num[i]==num[i-1] && n==1){
                n++;
                nums[sum++] = num[i];
                continue;
            }else if(num[i]==num[i-1] && n==2){
                continue;
            }else if(num[i]!=num[i-1]){
                n=1;
                nums[sum++] = num[i];
            }
        }
        return sum;
    }

    public static int removeDuplicates1(int[] nums) {
        int start;
        int end = 0;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        if (nums[0] == nums[n-1]) {
            return 2;
        }
        int j;
        for (int i = 0; i < n; i++) {
            start = i;
            for (j = i+ 1; j < n; j++) {
                if (nums[j] != nums[start]) {
                    end = j - 1;
                    break;
                }
            }
            if (j >= n) {
                end = j -1;
            }
            //后面的往前靠
            if ((end - start + 1) > 2) {
                int dVal = end - start + 1 -2;
                for (int k = start + 2; k + dVal < n; k++) {
                    nums[k] = nums[k + dVal];
                }
                n -= dVal;
            }
        }
        return n;
    }

    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int[][] counts = new int[n][2];
        counts[0][0] = nums[0];
        counts[0][1] = 1;
        int m = 1;
        int j;
        for (int i = 1; i < n; i++) {
            int temp = nums[i];

            for (j = 0; j < m; j++ ) {
                if (temp == counts[j][0]) {
                    counts[j][1] += 1;
                    break;
                }
            }
            if (j >= m) {
                counts[m][0] = temp;
                counts[m][1] = 1;
                m +=1;
            }

        }
        for (int l = 0; l < m; l++) {
            System.out.println(counts[l][0] + "  " + counts[l][1]);
        }
        int temp = 0;
        for (int k = 0; k < m; k++) {
            if (counts[k][1] > 2) {
                temp = temp + (counts[k][1]-2);
            }
        }
        System.out.println("temp = " + temp);
        return n-temp;
    }
}
