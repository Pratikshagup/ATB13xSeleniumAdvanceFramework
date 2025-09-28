package com.selenium.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeTrail {
    WebDriver driver;

    public FreeTrail(WebDriver driver){
        this.driver  = driver;
    }

    private By email_input = By.id("page-v1-step1-email");
    private By checkbox = By.id("page-free-trail-step1-cu-gdpr-consent-checkbox");
    private By submitbtn = By.xpath("//button[text()=\"Create a Free Trail Account\"]");
    private By error_msg_xpath = By.xpath("//div[contains(@class,\"invalid-reason\")]");


    public String enterInvalidDetails(String email)
    {
        driver.get("https://app.vwo.com/free-trail/");
        driver.findElement(email_input).sendKeys(email);
        driver.findElement(checkbox).click();
        driver.findElement(submitbtn).click();
        String error_msg = driver.findElement(error_msg_xpath).getText();
        return error_msg;

    }
}
