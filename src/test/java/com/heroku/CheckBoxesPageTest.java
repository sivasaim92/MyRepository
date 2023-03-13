package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxesPageTest extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority =  0)
    public void checkCheckBox1Test() {
        CheckBoxesPage checkBoxesPage = PageFactory.initElements(driver, CheckBoxesPage.class);
        Assert.assertTrue(checkBoxesPage.checkCheckBox1());
    }
    @Test(priority =  1)
    public void uncheckCheckBox2Test() {
        CheckBoxesPage checkBoxesPage = PageFactory.initElements(driver, CheckBoxesPage.class);
        Assert.assertTrue(checkBoxesPage.uncheckCheckBox2());
    }
    @Test(priority =  2)
    public void checkAndUncheckBox1Test() {
        CheckBoxesPage checkBoxesPage = PageFactory.initElements(driver, CheckBoxesPage.class);
        Assert.assertTrue(checkBoxesPage.checkAndUncheckBox1());
    }
}
