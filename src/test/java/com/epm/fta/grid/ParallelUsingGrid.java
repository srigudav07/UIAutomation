package com.epm.fta.grid;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelUsingGrid {
   public RemoteWebDriver driver;

    private static String HOST = "http://localhost:4444/wd/hub";
    @BeforeTest
    public void setUp(){
        try {
            //Setting all your broswer related information
            DesiredCapabilities desiredCapabilities= DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy( PageLoadStrategy.EAGER );
            //execute AUT on to remote machine/nodes
            driver = new RemoteWebDriver( new URL( HOST ), options  );
        }catch (MalformedURLException me){

        }
    }

    @Test
    public void testOnecanOpenSelniumSite(){
        driver.get( "https://www.selenium.dev/" );
    }

    @Test
    public void testOneCanLoginGitHubPage(){
        driver.get("https://github.com/");
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
