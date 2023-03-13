package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IFramePage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(22) > a:nth-child(1)")
    protected WebElement framesOption;
    @FindBy(css = ".example > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")
    protected WebElement iframeOption;
    @FindBy(css = "#mce_0_ifr")
    protected WebElement iframeOnPage;
    @FindBy(css = "#tinymce")
    protected WebElement bodyToInputIframe;

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public String inputTextToIframe() {
        framesOption.click();
        iframeOption.click();
        driver.switchTo().frame("#mce_0_ifr");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(bodyToInputIframe));
        bodyToInputIframe.sendKeys("Hello");
        System.out.println(bodyToInputIframe.getText());
        return bodyToInputIframe.getText();
    }

}
