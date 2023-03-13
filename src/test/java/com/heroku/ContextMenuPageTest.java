package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuPageTest extends BaseTest{

    @Test
    public void testContextMenuAlert() {
        setUpLocalBrowser();
        ContextMenuPage contextMenuPage = PageFactory.initElements(driver, ContextMenuPage.class);
        Assert.assertTrue(contextMenuPage.rightClickOnContextMenu());
    }
}
