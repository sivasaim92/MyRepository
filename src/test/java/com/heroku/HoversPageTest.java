package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class HoversPageTest extends BaseTest {

    @Test
    public void HoverTest() throws AWTException, InterruptedException {
        //setUpBrowser();
        setUpLocalBrowser();
        HoversPage hoversPage = PageFactory.initElements(driver, HoversPage.class);
        Assert.assertTrue(hoversPage.findElementPresentAfterHover());
    }
}
