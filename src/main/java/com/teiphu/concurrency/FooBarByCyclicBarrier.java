package com.teiphu.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 1115. 交替打印FooBar
 *
 * @author Zheng Lifu
 * @// TODO: 2021/8/13 用CyclicBarrier解，
 */
public class FooBarByCyclicBarrier {

    private int n;

    private CyclicBarrier fooBarrier = new CyclicBarrier(2);

    private CyclicBarrier barBarrier = new CyclicBarrier(2);

    public FooBarByCyclicBarrier(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                barBarrier.await();
                fooBarrier.await();
                fooBarrier.reset();
            }
            barBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            for (int i = 0; i < n; i++) {
                barBarrier.await();
                printBar.run();
                barBarrier.reset();
                fooBarrier.await();
            }
            barBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
