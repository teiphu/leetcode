package com.teiphu.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Zheng Lifu
 */
public class Foo {

    private AtomicInteger jobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        jobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (jobDone.get() != 1) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        jobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (jobDone.get() != 2) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        jobDone.decrementAndGet();
        jobDone.decrementAndGet();
    }
}
