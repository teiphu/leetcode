package com.teiphu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheng Lifu
 */
public class Test {

    public static void main(String[] args) {
        String gbcode = "";
        List<String> list = getParGbCodes(gbcode);
        System.out.println(list);
    }

    private static List<String> getParGbCodes(String gbCode) {
        List<String> parGbCodes = new ArrayList<>();
        while (gbCode.length() > 2) {
            if (gbCode.length() <= 6) {
                gbCode = gbCode.substring(0, gbCode.length() - 2);
                parGbCodes.add(gbCode);
            } else {
                gbCode = gbCode.substring(0, gbCode.length() - 3);
                parGbCodes.add(gbCode);
            }
        }
        return parGbCodes;
    }

}
