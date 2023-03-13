package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.awt.*;
import java.net.MalformedURLException;
public class FileUploadTest extends BaseTest{
    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {
        //setUpBrowser();
        setUpLocalBrowser();
        driver.get("https://the-internet.herokuapp.com/");
        FileUploadPage fileUploadPage = PageFactory.initElements(driver, FileUploadPage.class);
        Assert.assertTrue(fileUploadPage.uploadFile());
    }
}
