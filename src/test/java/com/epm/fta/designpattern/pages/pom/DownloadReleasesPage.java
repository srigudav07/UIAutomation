package com.epm.fta.designpattern.pages.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epm.fta.designpattern.pages.utils.Utlity.waitOperation;

public class DownloadReleasesPage {
    private WebDriver driver;
    private By expandDownloadVersion = By.xpath( "//div[@id='3.10-expand']/img" );
    private By closeWindow = By.className( "close" );

    DownloadReleasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clikcOnExpandDownlaodVersion() {
        driver.findElement( expandDownloadVersion ).click();
        waitOperation();
        driver.findElement( closeWindow ).click();
    }



}
