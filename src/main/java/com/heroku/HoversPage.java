package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(25) > a:nth-child(1)")
    protected WebElement hoversElement;
    @FindBy(css = "div.figure:nth-child(3)")
    protected WebElement imageAvatar;
    @FindBy(css = "div.figure:nth-child(3) > div:nth-child(2) > a:nth-child(2)")
    protected WebElement viewProfileElement;

    public HoversPage(WebDriver driver) {
        super(driver);
    }
    public boolean findElementPresentAfterHover() {
        hoversElement.click();
        Actions action = new Actions(driver);
        action.moveToElement(imageAvatar).build().perform();
        return viewProfileElement.isDisplayed();
    }
}
