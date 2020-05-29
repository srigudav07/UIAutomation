package com.epm.fta.designpattern.pages.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epm.fta.designpattern.pages.utils.Utlity.waitOperation;

public class DownloadReleasesPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='3.10-expand']/img")
    private WebElement expandDownloadVersion;

    @FindBy(className = "close")
    private WebElement closeWindow;

    DownloadReleasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this. driver,this );
    }

    public void clikcOnExpandDownlaodVersion() {
        expandDownloadVersion.click();
        waitOperation();
        closeWindow.click();
    }


}
