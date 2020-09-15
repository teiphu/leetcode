package org.teiphu;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Teiphu
 * @Creation 2018.10.11 11:48
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        boolean temp;
        int max = 0;
        int n = 0;
        if (s.length() == 1) {
            return 1;
        } else if (s == null || s.length() == 0) {
            return 0;
        } else {
            for (int i = 0; i < chars.length; i++) {
                char[] chars1 = new char[chars.length];
                chars1[0] = chars[i];
                temp = false;
                for (int j = i + 1; j < chars.length; j++) {

                    for (int k = 0; k < j-i; k++) {
                        if (chars[j] == chars1[k]) {
                            temp = true;
                            break;
                        }
                    }

                    if (temp == true) {
                        n = j;
                        break;
                    } else {
                        chars1[j-i] = chars[j];
                    }
                    if (j == chars.length-1) {
                        n = j + 1;
                    }
                }
                if (n - i > max) {
                    max = n-i;
                }
            }
            return max;
        }

    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    //最快的算法
    public int lengthOfLongestSubstring2(String s) {
        int[] list = new int[256];
        int previous = -1, right = 0, max_len = 0;
        for(int i=0;i<list.length;i++){
            list[i]=-1;
        }
        while(right<s.length()){
            char c = s.charAt(right);
            if(list[(int)c] > previous)
                previous = list[(int)c];
            max_len = Math.max(max_len, right - previous);
            list[(int)c] = right++;
        }
        return max_len;
    }
}
