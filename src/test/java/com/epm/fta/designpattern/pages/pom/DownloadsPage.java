package com.epm.fta.designpattern.pages.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epm.fta.designpattern.pages.utils.Utlity.waitOperation;

public class DownloadsPage {
    private WebDriver driver;
    private By title = By.xpath( "//h1" );
    private By previousReleaseButon = By.className( "releases-button" );


    public DownloadsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyIndownlaodsPage() {
        String pageTitle = driver.findElement( title ).getText();
        return pageTitle.equalsIgnoreCase( "Downloads" );
    }

    public DownloadReleasesPage naviagteToPrevoiusReleasesIn() {
        try {
            if (verifyIndownlaodsPage()) {
                driver.findElement( previousReleaseButon ).click();
                waitOperation();
            }
        } catch (Exception e) {

        }
        return new DownloadReleasesPage( driver );
    }

}
