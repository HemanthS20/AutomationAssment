package com.gamil.demo.pages;

import com.gamil.demo.config.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    protected WebDriver driver;

    //We have to initialize all the Pages Created in this class.
    protected HomePage homePage;

    public Pages() {
        this.driver = new BrowserFactory().chromeDriver();
        PageObjects();
    }

    public void PageObjects() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
}
