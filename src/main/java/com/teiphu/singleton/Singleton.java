package com.teiphu.singleton;

/**
 * @author Zheng Lifu
 */
public class Singleton {

    private static SingletonObject INSTANCE;

    public static SingletonObject getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonObject();
        }
        return INSTANCE;
    }
}
