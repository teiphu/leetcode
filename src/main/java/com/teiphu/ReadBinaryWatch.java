package org.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 *
 * @Author Teiphu
 * @Creation 2018.09.22 16:18
 **/
public class ReadBinaryWatch {

    public List<String> readBinaryWatch0(int num) {
        List<String> res = new ArrayList<>();
        if (num > 8) {
            return res;
        }
        if (num == 0) {
            res.add("0:00");
        }
        int temp[] = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        boolean index[] = new boolean[10];
        helper(res, temp, index, num, 0);
        return null;
    }

    private void helper(List<String> res, int[] temp, boolean[] index, int num, int start) {
        if (num == 0) {//num=0,it is time to return answers!
            int hour = 0;
            int minute = 0;
            for (int k = 0; k < 10; k++) {
                if (index[k] == true && k <= 3) {
                    hour += temp[k];
                }
                if (index[k] == true && k > 3) {
                    minute += temp[k];
                }
            }
            if (hour >= 12 || minute >= 60) {//impossible cases!
                return;
            } else {//Two situations of minutes to add to the string!!
                if (minute < 10) {
                    String answer = "" + hour + ":" + "0" + minute;
                    res.add(answer);
                    return;
                } else {
                    String answer = "" + hour + ":" + minute;
                    res.add(answer);
                    return;
                }

            }
        }
        for (int i = start; i < temp.length; i++) {//Backtracking Loop from here!
            index[i] = true;
            helper(res, temp, index, num - 1, i + 1);
            index[i] = false;
        }
    }

    public List<String> readBinaryWatch(int num) {

        String[][] hour = {{"0"},
                {"1", "2", "4", "8"},
                {"3", "5", "6", "9", "10"},
                {"7", "11"}};

        String[][] minute = {{"00"},
                {"01", "02", "04", "08", "16", "32"},
                {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
                {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
                {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
                {"31", "47", "55", "59"}};

        List<String> res = new ArrayList<>();
        if (num < 0 || num > 8) {
            return res;
        }
        int j;
        for (int i = 0; i < hour.length; i++) {
            if ((j = num - i) < minute.length) {
                for (String h : hour[i]) {
                    for (String m : minute[j]) {
                        res.add(h + ":" + m);
                    }
                }
            }
        }
        return res;
    }

}
