package com.teiphu.singleton.interviewcake;

/**
 * 枚举式实现
 *
 * @author Zheng Lifu
 */
public enum InstallationDetailsIV {

    INSTANCE;

    private long licenseNumber;

    private InstallationDetailsIV() {
        this.licenseNumber = 123456;
    }

    public long getLicenseNumber() {
        return licenseNumber;
    }
}
