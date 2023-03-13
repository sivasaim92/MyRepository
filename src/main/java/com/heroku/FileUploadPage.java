package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v106.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class FileUploadPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(18) > a:nth-child(1)")
    protected WebElement fileUploadElement;
    @FindBy(css = "#drag-drop-upload")
    protected WebElement openExplorerButton;
    @FindBy(css= "#file-submit")
    protected WebElement uploadFileButton;
    @FindBy(css = ".example > h3:nth-child(1)")
    protected WebElement fileUploadedMessage;
    @FindBy(css = "#uploaded-files")
    protected WebElement uploadedFileName;
    @FindBy(css = "#file-upload")
    protected WebElement browseFile;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    protected boolean uploadFile() throws AWTException, InterruptedException {
        fileUploadElement.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(browseFile).click().perform();
        StringSelection filePath = new StringSelection("C:\\Users\\sivas\\Idea\\Sample.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(uploadFileButton));
        uploadFileButton.click();
        return fileUploadedMessage.getText().equals("File Uploaded!") && uploadedFileName.getText().equals("Sample.txt");
//        String uploadFileName = "";
//        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
//            uploadFileName = System.getProperty("user.dir") + "\\Idea\\Sample.txt";  //"C:\Users\sivas\Idea\Sample.txt"
//        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
//            uploadFileName = System.getProperty("user.dir") + "/Idea/Sample.txt";
//        }
//        browseFile.sendKeys(uploadFileName);
//        uploadFileButton.click();
//        return fileUploadedMessage.getText().equals("File Uploaded!") && uploadedFileName.getText().equals("Sample.txt");
    }
}

