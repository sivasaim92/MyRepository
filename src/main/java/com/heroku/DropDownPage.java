package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class DropDownPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(11) > a:nth-child(1)")
    protected WebElement dropDownoption;
    @FindBy(css = "#dropdown")
    protected WebElement dropDownElement;

    public DropDownPage(WebDriver driver) {
        super(driver);
    }
    public boolean selectOption1FromDropDown() {
        dropDownoption.click();
        Select dropdown = new Select(dropDownElement);
        dropdown.selectByIndex(1);
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String expectedOption = "Option 1";
        String actualOption = selectedOption.getText();
        return expectedOption.equals(actualOption);
    }
    public boolean selectOption2FromDropDown() {
        dropDownoption.click();
        Select dropdown = new Select(dropDownElement);
        dropdown.selectByIndex(2);
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String expectedOption = "Option 2";
        String actualOption = selectedOption.getText();
        return expectedOption.equals(actualOption);
    }
}
