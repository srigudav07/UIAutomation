package com.epm.fta.designpattern.pages.pagefactory;


import com.epm.fta.designpattern.pages.utils.Utlity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public static final String HOME_URL = "https://www.selenium.dev/";
    @FindBy(partialLinkText = "Downloads")
    private WebElement download;

    //@FindBy(partialLinkText="Documentation")
    private WebElement document;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this. driver,this );
    }

    public void openHomePage() {
        driver.get( HOME_URL );
        driver.manage().window().maximize();
    }

    public DownloadsPage navigateToDownloadsPage() {
        Utlity.waitOperation();
        download.click();
        return new DownloadsPage( driver );
    }

    public DocumentationPage naviagteToDocumentationPage(){
        document.click();
        return new DocumentationPage(driver);
    }
}