package com.selenium.pages.PageObjectModel;

import com.selenium.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    WebDriver driver;
    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    private By userNameOnDashboard = By.xpath("//h6");

    public String loggedInuser(){
        WaitHelpers.waitJVM(1000);
        driver.get("https://app.vwo.com/#/dashboard");
        driver.findElement(userNameOnDashboard).getText();
    }
}
