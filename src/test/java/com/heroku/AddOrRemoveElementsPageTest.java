package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AddOrRemoveElementsPageTest extends BaseTest {

    @BeforeClass
    public void beforeTestAddRemoveButtons() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(2) > a")).click();
    }

    @AfterClass
    public void afterTestAddRemoveButtons() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 0)
    public void pageHeaderTest() throws MalformedURLException {
        setUpBrowser();
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertEquals(addOrRemoveElementsPage.getPageHeader(),"Add/Remove Elements");
    }

    @Test(priority = 1)
    public void pageFooterTest() throws MalformedURLException {
        setUpBrowser();
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertEquals(addOrRemoveElementsPage.getPageFooter(),"Powered by Elemental Selenium");
    }

    @Test(priority = 2)
    public void addElementInAddOrRemoveElementsPageTest() throws MalformedURLException {
        setUpBrowser();
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertTrue(addOrRemoveElementsPage.addElementInAddOrRemoveElementsPage());
    }

    @Test(priority = 3)
    public void deleteElementInAddOrRemoveElementsPageTest() throws MalformedURLException {
        setUpBrowser();
        AddOrRemoveElementsPage addOrRemoveElementsPage = PageFactory.initElements(driver, AddOrRemoveElementsPage.class);
        Assert.assertTrue(addOrRemoveElementsPage.deleteElementInAddOrRemoveElementsPage());
    }
}

