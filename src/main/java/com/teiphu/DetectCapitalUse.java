package org.teiphu;

/**
 * @Author Teiphu
 * @Creation 2018.10.05 15:20
 **/
public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
        char[] cs = word.toCharArray();
        boolean res = true;
        boolean up = false;
        boolean down = false;
        boolean t;
        if (Character.isUpperCase(cs[0])) {
            for (int i = 1; i < cs.length; i++) {
                if ((t = Character.isUpperCase(cs[i])) && down) {
                    res = false;
                    break;
                } else if (!t && up) {
                    res = false;
                    break;
                } else if (t) {
                    up = true;
                } else {
                    down = true;
                }
            }
        } else {
            for (int i = 1; i < cs.length; i++) {
                if (Character.isUpperCase(cs[i])) {
                    res = false;
                    break;
                }
            }
        }

        return res;
    }
}
