package com.teiphu;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /*ClassLoader loader = App.class.getClassLoader();
        System.out.println(loader);
        ClassLoader loader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader1);*/
        Test test = new Test();
        System.out.println(test);

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "ZhengLifu");

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("name", "ZhengLifu");


    }
}
