package com.heroku;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "columns")
    protected WebElement dropLocation;

    @FindBy(id = "column-a")
    protected WebElement dragBoxA;

    @FindBy(id = "column-b")
    protected WebElement dragBoxB;

    @FindBy(css = "#column-a > header")
    protected WebElement columnAHeaderText;

    @FindBy(css = "#column-b > header")
    protected WebElement columnBHeaderText;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public boolean dragAndDropTheElement() throws InterruptedException {
        Actions action = new Actions(driver);
        action.dragAndDrop(dragBoxA,dragBoxB).build().perform();
        pause();
        action.dragAndDrop(dragBoxB,dragBoxA).build().perform();
        pause();
        return columnBHeaderText.getText().contains("B");

//        Actions swap = new Actions(driver);
//        Action dragAndDrop1 = swap.clickAndHold(dragBoxA).moveToElement(dragBoxB).release(dragBoxA).build();
//        Action dragAndDrop2 = swap.clickAndHold(dragBoxB).moveToElement(dragBoxA).release(dragBoxB).build();
//        pauseScreen();
//        dragAndDrop2.perform();
//        dragAndDrop1.perform();
//        pauseScreen();
//        return columnBHeaderText.getText().contains("B");
    }
}
