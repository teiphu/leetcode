package org.teiphu;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] nums = {2, 2, 1, 1, 1, 2, 2};
		System.out.println(majorityElement(nums));
	}
	
	/**
	 * ���Žⷨ
	 * @param nums
	 * @return
	 */
	public static int majorityElement0(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        int m = nums[0];
        int count = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(count == 0){
                m = nums[i];
                count = 1;
            } else if(m == nums[i]){
                count++;
            } else if(m != nums[i]){
                count--;
            }
            if (count > half) {
                return m;
            }
        }
        return m;
    }
	
	public static int majorityElement(int[] nums) {
		int n = nums.length;
		int m = n / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
				if (map.get(num) > m) {
					return num;
				}
			} else {
				map.put(num, 1);
			}
			
		}
		return nums[0];
	}

}
