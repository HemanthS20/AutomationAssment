package com.gamil.demo.pages;

import com.gamil.demo.config.AppReader;
import com.gamil.demo.lib.SeleniumLib;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class HomePage {

    WebDriver driver;
    SeleniumLib seleniumLib;

    @FindBy(xpath = "//a[contains(text(),'Compose')]")
    WebElement compose_btn;

    @FindBy(xpath = "//input[@id='message-to-field']")
    WebElement sendTo_txt_box;

    @FindBy(xpath = "//input[@data-test-id='compose-subject']")
    WebElement subject_txt_box;

    @FindBy(xpath = "//div[@role='textbox']")
    WebElement content_text_box;

    @FindBy(xpath = "//span[contains(text(),'Send')]/..")
    WebElement send_btn;

    public HomePage(WebDriver driver){
        this.driver = driver;
        seleniumLib = new SeleniumLib(driver);

    }


    public String fillTheMailDetails() {

        String toUser = AppReader.getPropertyValue("MailToUser");
        String sub = AppReader.getPropertyValue("MailSubject");
        String cont = AppReader.getPropertyValue("MailContent");


        seleniumLib.waitForElementVisible(compose_btn);
        compose_btn.click();
        sendTo_txt_box.sendKeys(toUser);
        subject_txt_box.sendKeys(sub);
        content_text_box.sendKeys(cont);

        return "Success";
    }

    public String sendTheMail() {

        send_btn.click();

        return "Success";
    }
}
