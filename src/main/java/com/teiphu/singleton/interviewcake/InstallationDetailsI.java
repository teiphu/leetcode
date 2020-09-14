package com.teiphu.singleton.interviewcake;

/**
 * 懒惰式非线程安全的
 *
 * @author Zheng Lifu
 */
public class InstallationDetailsI {

    private static InstallationDetailsI INSTANCE = null;

    private long licenseNumber;

    private InstallationDetailsI() {
        this.licenseNumber = 12345;
    }

    public long getLicenseNumber() {
        return licenseNumber;
    }

    public static InstallationDetailsI getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InstallationDetailsI();
        }
        return INSTANCE;
    }
}
