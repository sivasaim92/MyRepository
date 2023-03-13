package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest{

    @Test
    public void switchToIframeTest() {
        setUpLocalBrowser();
        IFramePage iframeInFramesPage = PageFactory.initElements(driver, IFramePage.class);
        Assert.assertEquals(iframeInFramesPage.inputTextToIframe(), "Hello");
    }

}
