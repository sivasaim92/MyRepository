package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePage {
    @FindBy(css = "#checkbox")
    public WebElement checkBoxAdded;
    @FindBy(css = "#checkbox-example > button:nth-child(1)")
    public WebElement addCheckBoxButton;
    @FindBy(css = "#checkbox-example > button:nth-child(2)")
    public WebElement removeCheckBoxButton;
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(13) > a:nth-child(1)")
    public WebElement dynamicControlsLink;
    @FindBy(css = "#input-example > button:nth-child(2)")
    public WebElement enableButton;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public boolean removeCheckBox() throws InterruptedException {
      dynamicControlsLink.click();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(removeCheckBoxButton));
      removeCheckBoxButton.click();
      pause();
      String message = driver.findElement(By.cssSelector("#message")).getText();
      return message.equals("It's gone!");
    }
    public boolean removeAndAddCheckBox() throws InterruptedException {
        removeCheckBox();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addCheckBoxButton));
        addCheckBoxButton.click();
        pause();
        String message = driver.findElement(By.cssSelector("#message")).getText();
        return message.equals("It's back!");
    }
    public boolean enableInputField() throws InterruptedException {
        dynamicControlsLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));
        enableButton.click();
        pause();
        String message = driver.findElement(By.cssSelector("#message")).getText();
        return message.equals("It's enabled!");
    }
}
