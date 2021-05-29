package com.gamil.demo.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLib {
    private static WebDriver driver;
    public SeleniumLib(WebDriver driver) {
        SeleniumLib.driver = driver;
    }
    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        final WebElement el = element;
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return el.isDisplayed();
            }
        });
    }
}
