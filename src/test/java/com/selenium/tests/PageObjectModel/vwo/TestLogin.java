package com.selenium.tests.PageObjectModel.vwo;

import com.selenium.pages.PageObjectModel.Dashboard;
import com.selenium.pages.PageObjectModel.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {
    //D -> DriverManager
    //L -> PageObjectModel/Page Class
    //v -> CommonToAll


    @Owner("Pratiksha")
    @Description("TC01 : Verify login with invalid credentials")
    @Test
    public void test_login_with_invalid(){
        // Driver Manager
        WebDriver driver = new ChromeDriver();

        // Locators from Page class
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginWithInvalid("userinmavid","1234");

        // Verification i.e Assertions
        Assert.assertEquals(error_msg,"Your email, password or IP addess");
        driver.quit();
    }

    @Owner("Pratiksha")
    @Description("TC01 : Verify login with valid credentials")
    @Test
    public void test_login_with_valid(){
        // Driver Manager
        WebDriver driver = new ChromeDriver();

        // Locators from Page class
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithValid("pra0503gupta@gmail.com","Pra0503gupta");

        Dashboard dashboard_Page = new Dashboard(driver);
        String user_Logged = dashboard_Page.loggedInuser();

        // Verification i.e Assertions
        Assert.assertEquals(user_Logged,"Amcat");
        driver.quit();


    }
}
