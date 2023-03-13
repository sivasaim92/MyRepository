package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FloatingMenuTest extends BaseTest {

    @Test
    protected void floatingMenuTest () throws MalformedURLException {
        //setUpBrowser();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(19) > a")).click();
        FloatingMenuPage floatingMenuPage = PageFactory.initElements(driver, FloatingMenuPage.class);
        Assert.assertTrue(floatingMenuPage.isMenuFloating());
    }
}
