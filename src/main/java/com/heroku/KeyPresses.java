package com.heroku;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyPresses extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(31) > a:nth-child(1)")
    protected WebElement keyPressesElement;
    @FindBy(css= "#target")
    protected WebElement inputKeyTabEnterEscape;
    @FindBy(css = "#result")
    protected WebElement resultElement;
    public KeyPresses(WebDriver driver) {
        super(driver);
    }
    public boolean sendInputToKeyPresses() {
      inputKeyTabEnterEscape.sendKeys(Keys.TAB);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOf(resultElement));
      return resultElement.getText().equals("You entered: TAB");
    }
}
