package com.heroku;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.checkerframework.common.util.report.qual.ReportWrite;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlertPageTest extends BaseTest {

    @BeforeTest
    public void landingPage() {
        driver.get("https://the-internet.herokuapp.com");
    }
    @Test
    public void jsAlertTest() {
        setUpLocalBrowser();
        JavaScriptAlertPage javaScriptAlertPage = PageFactory.initElements(driver, JavaScriptAlertPage.class);
        Assert.assertTrue(javaScriptAlertPage.clickJSAlertButton());
    }
    @Test
    public void jsConfirmTest() {
        setUpLocalBrowser();
        JavaScriptAlertPage javaScriptAlertPage = PageFactory.initElements(driver, JavaScriptAlertPage.class);
        Assert.assertTrue(javaScriptAlertPage.clickJSConfirmButton());
    }
    @Test
    public void jsPromptTest() {
        setUpLocalBrowser();
        JavaScriptAlertPage javaScriptAlertPage = PageFactory.initElements(driver, JavaScriptAlertPage.class);
        Assert.assertTrue(javaScriptAlertPage.clickJSPromptButton("HEYYYYYYYYYYYYYYYYYY"));
    }
}
