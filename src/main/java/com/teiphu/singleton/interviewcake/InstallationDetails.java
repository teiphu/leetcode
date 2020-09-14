package com.teiphu.singleton.interviewcake;

/**
 * 饿汉式
 *
 * @author Zheng Lifu
 */
public class InstallationDetails {

    private static final InstallationDetails INSTANCE = new InstallationDetails();

    private long licenseNumber;

    public long getLicenseNumber() {
        return licenseNumber;
    }

    // by making the constructor private, we prevent instantiation
    private InstallationDetails() {
        this.licenseNumber = 12345;
    }

    public static InstallationDetails getInstance() {
        return INSTANCE;
    }

}
