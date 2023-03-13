package com.heroku;

import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentTest extends BaseTest {

    @Test
    public void image1DynamicTest() {
        setUpLocalBrowser();
        DynamicContentPage dynamicContentPage = PageFactory.initElements(driver, DynamicContentPage.class);
        Assert.assertTrue(dynamicContentPage.refreshToChangeImages());
    }

}
