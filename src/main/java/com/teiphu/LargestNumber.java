package org.teiphu;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
	
	public static String largestNumber1(int[] nums) {
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
		return null;
		
	}
	
	public static String largestNumber(int[] nums) {
        int[] t = new int[10];
        int num;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            while (num != 0) {
                t[num % 10] ++;
                num = num / 10;
            }
        }
        for(int i = t.length-1; i >= 0; i--) {
            for(int j = 1; j <= t[i]; j++) {
                sb.append(String.valueOf(i));
            }
        }
        
        return sb.toString();
    }

}
