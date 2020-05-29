package com.epm.fta.designpattern.tests;

import com.epm.fta.designpattern.pages.pagefactory.DocumentationPage;
import com.epm.fta.designpattern.pages.pagefactory.DownloadReleasesPage;
import com.epm.fta.designpattern.pages.pagefactory.DownloadsPage;
import com.epm.fta.designpattern.pages.pagefactory.HomePage;
import org.testng.annotations.Test;

@Test
public class TestWithPageFactory extends Base {

    @Test
    public void testPreviousReleasesInSeleniumSite() {
        HomePage homePage = new HomePage( driver );
        homePage.openHomePage();
        DownloadsPage downloadsPage = homePage.navigateToDownloadsPage();
        DownloadReleasesPage downloadReleasesPage = downloadsPage.naviagteToPrevoiusReleasesIn();
        downloadReleasesPage.clikcOnExpandDownlaodVersion();
    }

    @Test
    public void testDocumentsPageInSeleniumSite() {
        HomePage homePage = new HomePage( driver );
        homePage.openHomePage();
        DocumentationPage documnetioanPage = homePage.naviagteToDocumentationPage();
        System.out.println( documnetioanPage.verifyInDocumentsPage() );

    }


}
