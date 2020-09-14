package com.teiphu.singleton.interviewcake;

/**
 * @author Zheng Lifu
 */
public class InstallationDetailsII {

    private static volatile InstallationDetailsII INSTANCE = null;

    private long licenseNumber;

    private InstallationDetailsII() {
        this.licenseNumber = 12345;
    }

    public long getLicenseNumber() {
        return licenseNumber;
    }

    public static InstallationDetailsII getInstance() {
        if (INSTANCE == null) {
            synchronized (InstallationDetailsII.class) {
                if (INSTANCE == null) {
                    INSTANCE = new InstallationDetailsII();
                }
            }
        }
        return INSTANCE;
    }
}
