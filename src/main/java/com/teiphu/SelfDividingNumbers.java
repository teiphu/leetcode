package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 *
 * @Author Teiphu
 * @Creation 2018.09.24 10:29
 **/
public class SelfDividingNumbers {

    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(1, 22);
        System.out.println(list);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int remain;
        for (int i = left; i <= right; i++) {
            if (i > 0 && i < 10) {
                list.add(i);
            } else if (i % 10 != 0) {
                int temp = i;
                remain = temp % 10;
                while (remain != 0) {
                    if (i % remain == 0) {
                        temp = temp / 10;
                        remain = temp % 10;
                    } else {
                        break;
                    }
                }
                if (temp == 0) {
                    list.add(i);
                }
            }

        }
        return list;
    }
}
