package com.teiphu;

/**
 * 709. 转换成小写字母
 *
 * @Author Teiphu
 * @Creation 2018.10.08 16:24
 **/
public class ToLowerCase {

    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (Character.isUpperCase(cs[i])) {
                cs[i] = Character.toLowerCase(cs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cs);
        return sb.toString();

    }
}
