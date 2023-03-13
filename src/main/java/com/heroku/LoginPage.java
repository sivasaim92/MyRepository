package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(21) > a:nth-child(1)")
    protected WebElement authenticationFormLink;
    @FindBy(css = "#username")
    protected WebElement usernameField;
    @FindBy(css = "#password")
    protected WebElement passwordField;
    @FindBy(css = ".radius")
    protected WebElement loginButton;
    @FindBy(css = "#flash")
    protected WebElement flashMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public boolean doLogin() {
        authenticationFormLink.click();
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(flashMessage));
        System.out.println(flashMessage.getAttribute("outerText"));
        return flashMessage.getAttribute("outerText").contains("You logged into a secure area!");
    }
    public boolean doFailedLogin() {
        authenticationFormLink.click();
        usernameField.sendKeys("tomsmithh");
        passwordField.sendKeys("SSuperSecretPassword!");
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(flashMessage));
        return flashMessage.getAttribute("outerText").contains("Your username is invalid!");
    }
}

