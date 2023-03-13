package com.heroku;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends BasePage {

    public DragAndDropTest(WebDriver driver) {
        super(driver);
    }

    @BeforeMethod
    public void navigateToDragAndDropPage() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(10) > a")).click();
    }

    @Test
    public void dragAndDropPageTest() throws InterruptedException {
        DragAndDropPage dragAndDropPage = PageFactory.initElements(driver, DragAndDropPage.class);
        Assert.assertTrue(dragAndDropPage.dragAndDropTheElement());
    }
}
