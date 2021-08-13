package com.teiphu.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * 1115. 交替打印FooBar
 *
 * @author Zheng Lifu
 * @// TODO: 2021/8/13 用消费者通知者模式解
 */
public class FooBar {

    private int n;

    private final Boolean lock = Boolean.FALSE;

    private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        /*FooBar fooBar = new FooBar(4);
        fooBar.bar(new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        });
        fooBar.foo(new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        });*/
        //a，b这两个runnable 实际上在foo，和bar里面执行的是原生的run方法。
        Runnable a = () -> System.out.print("foo");

        Runnable b = () -> System.out.print("bar");

        FooBarBySemaphore fooBar = new FooBarBySemaphore(3);

        //真正start的是这个。lamada表达式创建的匿名类
        new Thread(() -> {
            try {
                fooBar.foo(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.bar(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                latch.countDown();
                lock.notify();
                printFoo.run();
                lock.wait();
            }
        }
//        用于唤醒另一个线程使其结束工作
        synchronized (lock) {
            lock.notify();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            latch.await();
            synchronized (lock) {
                printBar.run();
                lock.notify();
                lock.wait();
            }
        }
    }
}
