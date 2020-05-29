package com.epm.fta.designpattern.tests;


import com.epm.fta.designpattern.pages.pom.DocumentationPage;
import com.epm.fta.designpattern.pages.pom.DownloadReleasesPage;
import com.epm.fta.designpattern.pages.pom.DownloadsPage;
import com.epm.fta.designpattern.pages.pom.HomePage;
import org.testng.annotations.Test;


public class TestWithPageObject extends Base {

    @Test
    public void testPreviousReleasesInSeleniumSite() {
        HomePage homePage = new HomePage( driver );
        homePage.openHomePage();
        DownloadsPage downloadsPage = homePage.navigateToDownloadsPage();
        DownloadReleasesPage downloadReleasesPage = downloadsPage.naviagteToPrevoiusReleasesIn();
        downloadReleasesPage.clikcOnExpandDownlaodVersion();
        //Assertions should be placed here.
    }

    @Test
    public void testDocumentsPageInSeleniumSite() {
        HomePage homePage = new HomePage( driver );
        homePage.openHomePage();
        DocumentationPage documentationPage = homePage.naviagteToDocumentationPage();
        System.out.println( documentationPage.verifyInDocumentsPage() );

    }


}
