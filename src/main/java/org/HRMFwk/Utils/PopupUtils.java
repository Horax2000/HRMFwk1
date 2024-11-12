package org.HRMFwk.Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class PopupUtils {
    public static void acceptAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }

    public static void dismissAlert(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }
}