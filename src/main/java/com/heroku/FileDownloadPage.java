package com.heroku;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileDownloadPage {

    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(17) > a:nth-child(1)")
    public WebElement fileDownloadOption;
    @FindBy(css = ".example > a:nth-child(2)")
    public WebElement lambdaTestFileDownloadLink;

    public boolean downloadFile() throws InterruptedException {
        fileDownloadOption.click();
        lambdaTestFileDownloadLink.click();
        Thread.sleep(5000);
        String downloadsFolderPath = System.getProperty("user.home") + "/Downloads";
        File[] downloadedFiles = new File(downloadsFolderPath).listFiles();
        boolean fileFound = false;

        for (File file : downloadedFiles) {
            if (file.getName().startsWith("LambdaTest")) { // Replace with the actual file name or part of it
                fileFound = true;
                break;
            }
        }
        return fileFound;
    }
}
