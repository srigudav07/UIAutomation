package com.epm.fta.tests;

import com.epm.fta.dataprovider.TestDataProviderFromExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifySearchOfGoogle {
    WebDriver driver;

    @Test(dataProvider = "getData", dataProviderClass = TestDataProviderFromExcel.class)
    //dataProvider value should be equal to @DataProvider method name
    public void verifySearchInGoogleWithMultipleParam(String text, String str1, String str2) throws InterruptedException { //no. of parameter = no. of columns
        System.out.println( "Search ----" + text );
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get( "http://www.google.com" );
        driver.findElement( By.xpath( "//input[@title='Search']" ) ).sendKeys( text );
        driver.findElement( By.name( "btnK" ) ).click();
        Thread.sleep( 7000 );
        driver.quit();
    }
}
