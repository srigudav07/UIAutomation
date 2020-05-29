package com.epm.fta.designpattern.pages.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epm.fta.designpattern.pages.utils.Utlity.waitOperation;

public class DownloadsPage {
    @FindBy(xpath = "//h1")
    private  WebElement title;
    @FindBy(className = "releases-button")
    private WebElement previousReleaseButon;
    private WebDriver driver;


    public DownloadsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this. driver,this );
    }

    public boolean verifyIndownlaodsPage() {
        String pageTitle = title.getText();
        return pageTitle.equalsIgnoreCase( "Downloads" );
    }

    public DownloadReleasesPage naviagteToPrevoiusReleasesIn() {
        try {
            if (verifyIndownlaodsPage()) {
                previousReleaseButon.click();
                waitOperation();
            }
        } catch (Exception e) {

        }
        return new DownloadReleasesPage( driver );
    }

}
