package com.gamil.demo.pages;

import com.gamil.demo.config.AppReader;
import com.gamil.demo.lib.SeleniumLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
        WebDriver driver;
        SeleniumLib seleniumLib;

    @FindBy(xpath = "//span[text()='Sign in']")
    WebElement signIn_link;

    @FindBy(xpath = "//input[@id='login-username']")
    WebElement email_txt_box;

    @FindBy(xpath = "//input[@id='login-signin']")
    WebElement next_btn;

    @FindBy(xpath = "//button[@id='login-signin']")
    WebElement login_btn;

    @FindBy(xpath = "//input[@id='login-passwd']")
    WebElement password_txt_box;




    public LoginPage(WebDriver driver) {
        this.driver= driver;
        seleniumLib = new SeleniumLib(driver);
    }

    public String loadApplication() {
        //The URL will be reading from the Config File.
        String appUrl = AppReader.getPropertyValue("APP_URL");
        if (appUrl == null || appUrl.isEmpty()) {
            return "URL is empty. Please provide URL in Aappconfig.properties file";
        }
        driver.manage().window().maximize();
        driver.get(appUrl);
        return "Success";
    }


    public String loginToApplication() {
        String userName = AppReader.getPropertyValue("UserName");
        String password = AppReader.getPropertyValue("Password");

        seleniumLib.waitForElementVisible(signIn_link);
        signIn_link.click();

        seleniumLib.waitForElementVisible(email_txt_box);
        email_txt_box.sendKeys(userName);
        next_btn.click();
        seleniumLib.waitForElementVisible(password_txt_box);
        password_txt_box.sendKeys(password);
        login_btn.click();
        return "Success";
    }
}
