package org.HRMFwk.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Conditions {
    private WebDriver driver;

    public Conditions(WebDriver driver) {
        this.driver = driver;
    }

    public Conditions setInput(WebElement element, String value) {
        WaitUtil waitUtil = new WaitUtil(driver);
        waitUtil.waitForVisibility(element);
        element.sendKeys(value);
        return this;
    }

    public Conditions click(WebElement element) {
        WaitUtil waitUtil = new WaitUtil(driver);
        waitUtil.waitForElementToBeClickable(element);
        element.click();
        return this;
    }
}