package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @BeforeTest
    public void landingPage() {
        driver.get("https://the-internet.herokuapp.com");
    }
    @Test(priority = 0)
    public void removeCheckBoxTest() throws InterruptedException {
        DynamicControlsPage dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        Assert.assertTrue(dynamicControlsPage.removeCheckBox());
    }
    @Test(priority = 1)
    public void addAndRemoveCheckBoxTest() throws InterruptedException {
        DynamicControlsPage dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        Assert.assertTrue(dynamicControlsPage.removeAndAddCheckBox());
    }
    @Test(priority = 2)
    public void enableFieldTest() throws InterruptedException {
        DynamicControlsPage dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        Assert.assertTrue(dynamicControlsPage.enableInputField());
    }
}
