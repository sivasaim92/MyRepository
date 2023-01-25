package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class KeyPressesTest extends BaseTest {

    @Test(priority = 0)
    public void KeyTest() {
        try {
            setUpBrowser();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        KeyPresses keyPresses = PageFactory.initElements(driver, KeyPresses.class);
        Assert.assertTrue(keyPresses.sendInputToKeyPresses());
    }
}
