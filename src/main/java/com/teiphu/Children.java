package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class Children extends Parent {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
