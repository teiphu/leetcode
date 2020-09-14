package com.teiphu.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zheng Lifu
 */
public class FooBar {

    private AtomicInteger jobDone = new AtomicInteger(0);

    CountDownLatch latch = new CountDownLatch(1);
    CountDownLatch latch1 = new CountDownLatch(1);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            latch1.countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            latch1.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            latch.countDown();
        }
    }
}
