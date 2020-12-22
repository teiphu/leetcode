package com.teiphu.string;

/**
 * BF算法
 *
 * @author Zheng Lifu
 */
public class BFTest {

    public static void main(String[] args) {
        BFTest bfTest = new BFTest();
        bfTest.testBF("zhenglifujk", "lifu");
    }

    /**
     *
     * @param t
     * @param p
     */
    public void testBF(String t, String p) {
        char[] ts = t.toCharArray();
        char[] ps = p.toCharArray();
        int k = 0;
        for (int i = 0, j = 0; i < ts.length && j < ps.length; ) {
            if (ts[i] == ps[j]) {
                i++;
                j++;
            } else {
                k++;
                i = k;
                j = 0;
            }
        }
        System.out.println("k: " + k);
    }
}
