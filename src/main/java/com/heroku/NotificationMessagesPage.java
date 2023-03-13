package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NotificationMessagesPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(35) > a:nth-child(1)")
    protected WebElement notificationMessagesElement;
    @FindBy(css = ".example > p:nth-child(2) > a:nth-child(5)")
    protected WebElement clickElementGToGetMessage;
    @FindBy(css = "#flash")
    protected WebElement flashMessageToBeReceived;

    public NotificationMessagesPage(WebDriver driver) {
        super(driver);
    }
    public boolean getNotificationMessage() {
        notificationMessagesElement.click();
        clickElementGToGetMessage.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return flashMessageToBeReceived.getAttribute("outerText").contains(" Action successful") || flashMessageToBeReceived.getAttribute("outerText").contains(" Action unsuccesful, please try again");
    }
}
