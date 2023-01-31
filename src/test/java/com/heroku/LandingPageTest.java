package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LandingPageTest extends BaseTest {
    @BeforeClass
    public void beforeClass() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void landingPageLoadTest() throws MalformedURLException {
        setUpBrowser();
        WebElement pageHeaderElm = driver.findElement(By.cssSelector("#content > h2"));
        Assert.assertEquals(pageHeaderElm.getText(), "Available Examples");
    }
}
