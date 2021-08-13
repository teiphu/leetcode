package com.teiphu.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 1115. 交替打印FooBar
 *
 * @author Zheng Lifu
 * @// TODO: 2021/8/1 用Semaphore解
 */
public class FooBarBySemaphore {

    private int n;

    private Semaphore fooSemaphore = new Semaphore(1);

    private Semaphore barSemaphore = new Semaphore(0);

    public FooBarBySemaphore(int n) {
        this.n = n;
    }

    //    acquire: -1; release: +1
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }
}
