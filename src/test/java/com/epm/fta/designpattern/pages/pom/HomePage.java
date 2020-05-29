package com.epm.fta.designpattern.pages.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    public static final String HOME_URL = "https://www.selenium.dev/";
    private By download = By.partialLinkText( "Downloads" );
    private  By documentation = By.partialLinkText( "Documentation" );
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get( HOME_URL );
        driver.manage().window().maximize();
    }

    public DownloadsPage navigateToDownloadsPage() {
        driver.findElement( download ).click();
        return new DownloadsPage( driver );
    }

    public DocumentationPage naviagteToDocumentationPage(){
        driver.findElement( documentation ).click();
        return new DocumentationPage(driver);
    }
}