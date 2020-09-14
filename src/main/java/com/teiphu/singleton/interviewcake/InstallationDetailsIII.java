package com.teiphu.singleton.interviewcake;

/**
 * 通过静态内部类实现
 *
 * @author Zheng Lifu
 */
public class InstallationDetailsIII {

    private long licenseNumber;

    public long getLicenseNumber() {
        return licenseNumber;
    }

    // by making the constructor private, we prevent instantiation
    private InstallationDetailsIII() {
        this.licenseNumber = 123456;
    }

    private static class InstallationDetailsHolder {
        private static final InstallationDetailsIII INSTANCE = new InstallationDetailsIII();
    }

    public static InstallationDetailsIII getInstance() {
        return InstallationDetailsHolder.INSTANCE;
    }
}
