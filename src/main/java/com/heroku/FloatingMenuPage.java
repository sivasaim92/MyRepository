package com.heroku;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@FindBy (css = "div[id='menu']")

public class FloatingMenuPage extends BasePage {
    protected WebElement menuBar;

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }
    public boolean isMenuFloating () {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return menuBar.isDisplayed();
    }
}
