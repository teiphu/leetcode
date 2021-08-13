package com.teiphu.sort;

/**
 * @author Zheng Lifu
 */
public class QuickSort1 {

    private static void quickSort(Comparable<?>[] a) {
        int N = a.length;
        quickSor(a, 0, N-1);
    }

    private static void quickSor(Comparable<?>[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int index = partition(a, lo, hi);
        quickSor(a, lo, index - 1);
        quickSor(a, index + 1, hi);
    }

    private static int partition(Comparable<?>[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1; //此处+1是为了下面的循环
        Comparable<?> v = a[lo];
        while (true){
            while (less(a[++i], v)) {   //相当于while(a[++i] < v)
                if (i == hi)
                    break;
            }
            while (less(v, a[--j])) {   //相当于while(a[--j] > v)
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            exchge(a, i, j);
        }
        exchge(a, lo, j);
        return j;
    }

    private static void exchge(Comparable<?>[] a, int i, int j) {

    }

    private static boolean less(Comparable<?> comparable, Comparable<?> v) {
        return false;
    }
}
