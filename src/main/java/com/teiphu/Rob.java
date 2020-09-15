package org.teiphu;

public class Rob {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] nums = {200,234,182,111,87,194,221,217,71,162,140,51,81,80,232,193,223,103,139,103};
//		1630
		System.out.println(rob(nums));
	}
	
	public static int rob(int[] nums) {
		if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
		int sumWithLast = nums[1];
		int sumNoLast = nums[0];
		int temp;
		int res;
		int max = sumNoLast > sumWithLast ? sumNoLast : sumWithLast;
		
		for (int i = 2; i < nums.length; i++) {
			temp = sumWithLast;
			if (sumNoLast > sumWithLast) {
				max = sumNoLast + nums[i];
				sumWithLast = max;
				sumNoLast = temp;
			} else if (sumNoLast < sumWithLast - nums[i-1]) {
				max = sumWithLast - nums[i-1] + nums[i];
				sumWithLast = max;
				sumNoLast = temp;
			} else {
				sumWithLast = sumNoLast + nums[i];
				sumNoLast = temp;
				max = sumNoLast > sumWithLast ? sumNoLast : sumWithLast;
			}
		}
		res = max;
		return res;
	}

}

/*
      1, 3, 1, 3, 100
������������1, 3, 
�������һ����3, 2, 
���ֵ��            3, 3, 

*/

