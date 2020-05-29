package com.epm.fta.designpattern.pages.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentationPage {
    WebDriver driver;
    @FindBy(xpath = "//h1")
    private WebElement documentation;

    public DocumentationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements( this.driver,this );
    }

    public boolean verifyInDocumentsPage() {
        String pageTitle = documentation.getText();
        return pageTitle.equalsIgnoreCase( "The Selenium Browser Automation Project" );
    }
}
