package com.selenium.pages.PageObjectModel;

import com.selenium.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    //Page class
    //Step 0 - Parametrised Constructor
    public LoginPage(WebDriver driver){
        this.driver =driver;
    }
    // Step 1 - Page Locators

    private By username = By.id("login_name");
    private By password = By.id("login_password");
    private By signinbtn = By.id("login_btn");
    private By errormsg = By.id("notification_msg");


    // Step 2 - Page Actions
    public String loginWithInvalid(String user, String pwd){
        driver.get("https://app.vwo.com/");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signinbtn).click();

        WaitHelpers.checkVisibility(driver,errormsg);
            String error_message = driver.findElement(errormsg).getText();
            return error_message;

    }

    public String loginWithValid(String user, String pwd){
        driver.get("https://app.vwo.com/");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signinbtn).click();

        // thread sleep for 5 sec
        WaitHelpers.waitJVM(5000);
    }

}
