package org.HRMFwk.Utils;

import org.testng.asserts.SoftAssert;

public class SoftAssertUtil {
    private static SoftAssert softAssert = new SoftAssert();

    public static void assertTrue(boolean condition, String message) {
        softAssert.assertTrue(condition, message);
    }

    public static void assertAll() {
        softAssert.assertAll();
    }
}