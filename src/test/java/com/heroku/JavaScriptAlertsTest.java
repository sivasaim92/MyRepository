package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class JavaScriptAlertsTest extends BaseTest {

    @Test (priority = 1)
    public void openJsAlert () {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(29) > a")).click();
    }
    @Test (priority = 2)
    public void acceptJsAlertTest () throws MalformedURLException {
        setUpBrowser();
        JavaScriptAlerts javaScriptAlerts = PageFactory.initElements(driver, JavaScriptAlerts.class);
        javaScriptAlerts.acceptJsAlert();
        Assert.assertEquals(javaScriptAlerts.getResultText(), "You successfully clicked an alert");
    }
    @Test (priority = 3)
    public void cancelJsConfirmTest () throws MalformedURLException {
        setUpBrowser();
        JavaScriptAlerts javaScriptAlerts = PageFactory.initElements(driver, JavaScriptAlerts.class);
        javaScriptAlerts.cancelJsConfirm();
        Assert.assertEquals(javaScriptAlerts.getResultText(), "You clicked: Cancel");
    }
    @Test (priority = 4)
    public void enterTextJsPromptTest () throws InterruptedException, MalformedURLException {
        setUpBrowser();
        JavaScriptAlerts javaScriptAlerts = PageFactory.initElements(driver, JavaScriptAlerts.class);
        javaScriptAlerts.enterTextInJsPrompt();
        Assert.assertEquals(javaScriptAlerts.getResultText(), "You entered: Hello JS");
    }
}
