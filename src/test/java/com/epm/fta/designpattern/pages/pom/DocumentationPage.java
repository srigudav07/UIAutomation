package com.epm.fta.designpattern.pages.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentationPage {
    WebDriver driver;
    private By title = By.xpath( "//h1" );
    DocumentationPage(WebDriver driver){
        this.driver=driver;
    }
    public boolean verifyInDocumentsPage() {
        String pageTitle = driver.findElement( title ).getText();
        return pageTitle.equalsIgnoreCase( "The Selenium Browser Automation Project" );
    }

}
