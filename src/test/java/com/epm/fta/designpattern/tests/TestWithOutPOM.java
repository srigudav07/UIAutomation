package com.epm.fta.designpattern.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestWithOutPOM {
    WebDriver driver;

    @Test
    public void testSeleniumSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        naviagteToDownloads();
        driver.manage().window().maximize();
        if (driver.findElement( By.xpath( "//h1" ) ).getText().equalsIgnoreCase( "Downloads" )) {
            driver.findElement( By.className( "releases-button" ) ).click();
            driver.findElement( By.xpath( "//div[@id='3.10-expand']/img" ) ).click();
            driver.findElement( By.className( "close" ) ).click();
        }

    }

    private void naviagteToDownloads() {
        driver.get( "https://www.selenium.dev/" );
        driver.findElement( By.partialLinkText( "Downloads" ) ).click();
    }
}
