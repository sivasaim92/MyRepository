package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowsPage extends BasePage{

    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(33) > a:nth-child(1)")
    protected WebElement multipleWindowsElement;
    @FindBy(css= ".example > a:nth-child(2)")
    protected WebElement newWindowLink;
    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }
    public boolean openNewWindow() {
        multipleWindowsElement.click();
        newWindowLink.click();
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();
        return currentUrl.contains("https://the-internet.herokuapp.com/windows/new") && currentTitle.equals("New Window");
    }
}
