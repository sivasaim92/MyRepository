package com.heroku;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownLoadTest extends BaseTest {

    @Test(priority = 0)
    public void fileDownloadTest() throws InterruptedException {
        setUpLocalBrowser();
        FileDownloadPage fileDownloadPage = PageFactory.initElements(driver, FileDownloadPage.class);
        Assert.assertTrue(fileDownloadPage.downloadFile());
    }
}
