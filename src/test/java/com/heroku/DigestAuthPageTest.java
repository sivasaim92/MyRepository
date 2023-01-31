package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DigestAuthPageTest extends BaseTest  {
    @Test
    public void digestAuthLoginTest() throws MalformedURLException {
        setUpBrowser();
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(8) > a")).click();
        DigestAuthPage digestAuthPage = PageFactory.initElements(driver, DigestAuthPage.class);
        String actualPageHeader = "Congratulations! You must have the proper credentials.";
        Assert.assertEquals(digestAuthPage.getPageHeader(), actualPageHeader, "Login successful !");
    }
}