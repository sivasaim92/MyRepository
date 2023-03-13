package com.heroku;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlertPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(29) > a:nth-child(1)")
    protected WebElement javaScriptAlertOption;
    @FindBy(css = ".example > ul:nth-child(3) > li:nth-child(1) > button:nth-child(1)")
    protected WebElement clickForJsAlertButton;
    @FindBy(css = ".example > ul:nth-child(3) > li:nth-child(2) > button:nth-child(1)")
    protected WebElement clickForJsConfirmButton;
    @FindBy(css = ".example > ul:nth-child(3) > li:nth-child(3) > button:nth-child(1)")
    protected WebElement clickForJsPromptButton;
    @FindBy(css = "#result")
    protected WebElement jsAlertMessage;

    public JavaScriptAlertPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickJSAlertButton() {
        javaScriptAlertOption.click();
        clickForJsAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return jsAlertMessage.getText().equals("You successfully clicked an alert");
    }
    public boolean clickJSConfirmButton() {
        javaScriptAlertOption.click();
        clickForJsConfirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(jsAlertMessage));
        return jsAlertMessage.getText().equals("You clicked: Cancel");
    }
    public boolean clickJSPromptButton(String inputText) {
        javaScriptAlertOption.click();
        clickForJsPromptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(inputText);
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(jsAlertMessage));
        return jsAlertMessage.getText().equals("You entered: " + inputText);
    }
}
