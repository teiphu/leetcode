package org.teiphu;

public class Trap {

	public int trap(int[] height) {
		if (height.length < 3){
			return 0;
		}
		int total = 0;
		int temp = 0;
		int topIndex = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i] < height[topIndex]) {
				temp += height[topIndex] - height[i];
			} else {
				total += temp;
				temp = 0;
				topIndex = i;
			}
		}
		if (temp != 0) {
			temp = 0;
			int rTopIndex = height.length - 1;
			for (int i = height.length - 2; i >= topIndex; i--) {
				if (height[i] < height[rTopIndex]) {
					temp += height[rTopIndex] - height[i];
				} else {
					total += temp;
					temp = 0;
					rTopIndex = i;
				}
			}
		}
		return total;
	}
}
