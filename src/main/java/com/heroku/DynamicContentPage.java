package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(12) > a:nth-child(1)")
    public WebElement DynamicContentLink;
    @FindBy(css = "div.large-10:nth-child(1) > div:nth-child(1) > div:nth-child(1) > img:nth-child(1)")
    public WebElement image1;
    @FindBy(css = "div.row:nth-child(4) > div:nth-child(1) > img:nth-child(1)")
    public WebElement image2;
    @FindBy(css = "div.large-10:nth-child(1) > div:nth-child(7) > div:nth-child(1) > img:nth-child(1)")
    public WebElement image3;

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }
    public boolean refreshToChangeImages() {
        DynamicContentLink.click();
        String image1Name = image1.getAttribute("currentSrc");
        String image2Name = image2.getAttribute("currentSrc");
        String image3Name = image3.getAttribute("currentSrc");
        driver.navigate().refresh();
        String image1NameAfterRefresh = image1.getAttribute("currentSrc");
        String image2NameAfterRefresh = image2.getAttribute("currentSrc");
        String image3NameAfterRefresh = image3.getAttribute("currentsrc");
        return image1Name != image1NameAfterRefresh && image2Name != image2NameAfterRefresh && image3Name != image3NameAfterRefresh;
    }

}
