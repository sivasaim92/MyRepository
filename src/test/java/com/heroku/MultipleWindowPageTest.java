package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class MultipleWindowPageTest extends BaseTest {

    @Test
    public void newWindowTest() throws AWTException, InterruptedException {
        //setUpBrowser();
        setUpLocalBrowser();
        MultipleWindowsPage multipleWindowsPage = PageFactory.initElements(driver, MultipleWindowsPage.class);
        Assert.assertTrue(multipleWindowsPage.openNewWindow());
    }
}

