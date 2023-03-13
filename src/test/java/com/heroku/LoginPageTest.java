package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @BeforeTest
    public void landingPage() {
        driver.get("https://the-internet.herokuapp.com");
    }
    @Test
    public void successfulLoginTest() {
        setUpLocalBrowser();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        Assert.assertTrue(loginPage.doLogin());
    }
    @Test
    public void FailedLoginTest() {
        setUpLocalBrowser();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        Assert.assertTrue(loginPage.doFailedLogin());
    }
}
