package org.teiphu;

/**
 * @Author Teiphu
 * @Creation 2018.10.11 11:49
 **/
public class ConvertAlgorism {

    private static int convertAlgorism(char[] cars) {
        int result = 0;
        int num = 0;
        for (int i = cars.length - 1; 0 <= i; i--) {
            int temp = 2;
            if (num == 0) {
                temp = 1;
            } else if (num == 1) {
                temp = 2;
            } else {
                for (int j = 1; j < num; j++) {
                    temp = temp * 2;
                }
            }
            int sum = Integer.parseInt(String.valueOf(cars[i]));
            result = result + (sum * temp);
            num++;
        }

        return result;
    }

}
