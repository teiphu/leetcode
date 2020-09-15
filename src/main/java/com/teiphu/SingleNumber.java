package org.teiphu;

/**
 * 137. 只出现一次的数字 II
 *
 * @author TeIphu
 * @data 2018.08.28 23:27
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int mask = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            twos = twos | (ones & nums[i]);
            ones = ones ^ nums[i];
            mask = ~(ones & twos);
            ones = ones & mask;
            twos = twos & mask;
        }
        return ones;
    }

    public static int singleNumber0(int[] nums) {
//		if (nums.length == 0) {
//			return -1;
//		}
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Integer.toBinaryString(nums[i]));
            ret = ret ^ nums[i];
//			System.out.println(ret);
        }
        return ret;
    }

    public static int singleNumber1(int[] nums) {
        int n = nums[0], i, j;
        for (i = 0; i < nums.length; i += 2) {
            System.out.println("i = " + i);
            if (i == nums.length - 1) {
                n = nums[i];
                break;
            }
            for (j = nums.length - 1; j > i; j--) {
                if (nums[j] == nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i + 1];
                    nums[i + 1] = temp;

                    break;
                }
            }
            if (i == j) {
                n = nums[i];
                break;
            }

        }
        System.out.println("i = " + i);
        return n;
    }
}
