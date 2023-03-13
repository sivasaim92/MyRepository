package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownPageTest extends BaseTest {

    @BeforeTest
    public void landingPage() {
        driver.get("https://the-internet.herokuapp.com");
    }
    @Test
    public void selectionOfOption1InDropDownTest() {
        setUpLocalBrowser();
        DropDownPage dropDownPage = PageFactory.initElements(driver, DropDownPage.class);
        Assert.assertTrue(dropDownPage.selectOption1FromDropDown());
    }
    @Test
    public void selectionOfOption2InDropDownTest() {
        setUpLocalBrowser();
        DropDownPage dropDownPage = PageFactory.initElements(driver, DropDownPage.class);
        Assert.assertTrue(dropDownPage.selectOption2FromDropDown());
    }
}
