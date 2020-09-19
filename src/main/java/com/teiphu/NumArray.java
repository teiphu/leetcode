package com.teiphu;

public class NumArray {
	
	private int[] nums;
    private int[] sum;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
    /*
    public int sumRange1(int i, int j) {
        int res = 0;
        int m = i, n = j;
        if ((n-m+1) % 2 == 1) {
            res += nums[(n-m)/2 + m];
        }
        for (; m < n; m++, n--) {
            res += nums[m] + nums[n];
        }
        return res;
    }
    
    public int sumRange2(int i, int j) {
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += nums[k];
        }
        return res;
    }
	*/
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
