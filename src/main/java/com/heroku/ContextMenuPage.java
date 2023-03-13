package com.heroku;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(7) > a:nth-child(1)")
    protected WebElement contextMenuElement;
    @FindBy(css = "#hot-spot")
    protected WebElement contextMenuBox;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
    public boolean rightClickOnContextMenu() {
        contextMenuElement.click();
        Actions action = new Actions(driver);
        action.contextClick(contextMenuBox).perform();
        Alert alert = driver.switchTo().alert();
        return alert.getText().equals("You selected a context menu");
    }
}
