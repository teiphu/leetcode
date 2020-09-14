package com.teiphu;

/**
 * @author : ZhengLifu
 */
public class Massage {

    public int massage(int[] nums) {
        int ppre;
        int pre = 0;
        int now = 0;
        for (int i = 1, n = nums.length; i <= n; i++) {
            ppre = pre;
            pre = now;
            now = Math.max(pre, ppre + nums[i - 1]);
        }
        return now;
    }
}
