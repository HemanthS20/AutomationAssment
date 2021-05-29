package com.gamil.demo.steps;

import com.gamil.demo.config.BrowserFactory;
import com.gamil.demo.pages.HomePage;
import com.gamil.demo.pages.LoginPage;
import com.gamil.demo.pages.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppStepDefs {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    public AppStepDefs() {
        this.driver = new BrowserFactory().chromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("the user is able to access the application")
    public void the_user_is_able_to_access_the_application() {

        String stepResult = loginPage.loadApplication();
        if(!stepResult.equalsIgnoreCase("Success")){
            Assert.fail(stepResult);
        }

    }

    @When("user log in to application with valid credentials")
    public void uesr_log_in_to_application_with_valid_credentials(){

        String stepResult = loginPage.loginToApplication();
        if(!stepResult.equalsIgnoreCase("Success")){
            Assert.fail(stepResult);
        }

    }

    @And("user will compose the new mail")
    public void uesr_will_compose_the_new_mail(){

        String stepResult = homePage.fillTheMailDetails();
        if(!stepResult.equalsIgnoreCase("Success")){
            Assert.fail(stepResult);
        }

    }

    @Then("User with send the mail")
    public void uesr_will_send_the_mail(){

        String stepResult = homePage.sendTheMail();
        if(!stepResult.equalsIgnoreCase("Success")){
            Assert.fail(stepResult);
        }

    }

}
