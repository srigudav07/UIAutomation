package com.epm.fta.grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelUsingTestNg {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void testOnecanOpenSelniumSite() {
        driver.get( "https://www.selenium.dev/" );
        System.out.println( "Test Case one with Thread Id:- "
                + Thread.currentThread().getId() );
    }

    @Test
    public void testOneCanLoginGitHubPage() {
        driver.get( "https://github.com/" );
        System.out.println( "Test Case two with Thread Id:- "
                + Thread.currentThread().getId() );
    }
}
