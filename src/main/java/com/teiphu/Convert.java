package com.teiphu;

/**
 * 6. Z字形变换
 *
 * @author Zheng Lifu
 */
public class Convert {

    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        Convert convert = new Convert();
        String res = convert.convert(s, numRows);
        System.out.println(res);

    }

    /**
     * 思路：按每层的规律计算下一个数据的位置
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int step = (numRows - 1) * 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int index = i;
            boolean b = true;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                if (i == 0 || i == numRows - 1) {
                    index += step;
                } else {
                    int step1 = step - 2 * i;
                    if (b) {
                        index += step1;
                        b = false;
                    } else {
                        index += (step - step1);
                        b = true;
                    }
                }
            }
        }

        return sb.toString();
    }

}
