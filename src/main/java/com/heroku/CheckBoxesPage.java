package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckBoxesPage extends BasePage {
    @FindBy(css = "#checkboxes > input:nth-child(1)")
    public WebElement checkBox1;
    @FindBy(css = "#checkboxes > input:nth-child(3)")
    public WebElement checkBox2;
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(6) > a:nth-child(1)")
    public WebElement checkBoxOption;

    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCheckBox1() {
        checkBoxOption.click();
        checkBox1.click();
        return checkBox1.isSelected();
    }
    public boolean uncheckCheckBox2() {
        checkBoxOption.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox2));
        checkBox2.click();
        return !checkBox2.isSelected();
    }
    public boolean checkAndUncheckBox1() {
        CheckBoxesPage checkBoxesPage = PageFactory.initElements(driver, CheckBoxesPage.class);
        checkBoxesPage.checkCheckBox1();
        checkBoxesPage.checkCheckBox1();
        return !checkBox1.isSelected();
    }

}
