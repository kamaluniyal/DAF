/**
 * 
 */
package com.markit.MerrilLynch.tests;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import junit.framework.Assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.MerrilLynch.pages.News;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.markit.MerrilLynch.pages.USMarkets;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Ritu.nath
 * @purpose: This class contains all the regression scenarios of News module.
 * @creation date: 20/07/2016
 */
public class NewsTest extends MerrilLynchProductTest {
	
	PropertyReader prop;
	GlobalDriver gDriver;
	News News;
	USMarkets US;
	MerrillLynchProductPage mlPP;
	String loggedUser;
	SendMail mailObj;
	ExtentTest parent;

	
	@BeforeClass
	@Parameters({ "browser", "version", "Sel_Grid", "environment" })
	public void initialSetup(@Optional String browser, @Optional String version, @Optional String Sel_Grid,
			@Optional String environment) throws Exception {

		
		mlPP = setupEnvironment(browser, version, Sel_Grid, environment);
		mlPP.sendObject(extReport ,softAssert);
		mlPP.fnWaitTillElementEnable(driver, 40, mlPP.wbframe1);				
		mlPP.fnLogin(userId,password);
		mlPP.fnWaitTillElementEnable(driver, 60, mlPP.wblnkResearch);
		News = new News(driver);
		
		parent = extent.startTest("News");
}

	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	
	@Test(priority =0,enabled = true)
	public void TC_VerificationOfPageComponentsSearchNews_News() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfPageComponentsSearchNews", "This Method will verify the existence of several compoenents on page"); 
	
	parent.appendChild(test);
	
	mlPP.wblnkResearch.click();
	mlPP.fnWaitTillElementVisible(driver, 40, News.wbelemMarketUpdate);
	extReport.enterLog("Info","Clicking on the News Tab");
	News.wblnkNewsTab.click();
	News.wbelemNewsFilterText.click();
	fnVerifyElementExistenceWithText(News.wbelemLatestHeadlineText,"Latest headlines");
	fnVerifyElementExistenceWithText(News.wbelemSearchNewsText,"Search news");
	fnVerifyElementExistence(News.wblnkSearchTextBox,"Search TextBox ");
	fnVerifyElementExistenceWithText(News.wblnkSelectAll,"Select all");
	fnVerifyElementExistenceWithText(News.wblnkClearAllCriteria,"Clear criteria");
	fnVerifyElementExistenceWithText(News.wbelemNewsFilterText,"News filter");
	fnVerifyElementExistenceWithText(News.wbelemNewsProviderText,"News providers");
	fnVerifyElementExistenceWithText(News.wbelemCategoriesText,"Categories");
	fnVerifyElementExistenceWithText(News.wbelemRegionsText,"Regions");
	fnVerifyElementExistence(News.wbelemMyHoldingsCheckBox,"MyHoldings");
	fnVerifyElementExistence(News.wbelemMyWatchListCheckBox,"MyWatchlist" );
	
	fnVerifyDataOfWebtable(News.wbelemNews1Table,PropertyReader.getFieldValue("NewsProvider1Text1","DataFile.properties") );
	
	extReport.enterLog("Info","Clicking on the News See More link");
	News.wblnkNewsSeeMore.click();
	
	fnVerifyDataOfWebtable(News.wbelemNews2Table,PropertyReader.getFieldValue("NewsProvider2text","DataFile.properties") );
	fnVerifyDataOfWebtable(News.wbelemCategoryTable,PropertyReader.getFieldValue("Category1Text1","DataFile.properties") );
	
	extReport.enterLog("Info","Clicking on the category See More link");
	News.wblnkCategorySeeMore.click();
	fnVerifyDataOfWebtable(News.wbelemCategoryTable1,PropertyReader.getFieldValue("Category1Text2","DataFile.properties") );
	fnVerifyDataOfWebtable(News.wbelemRegionsTable,PropertyReader.getFieldValue("RegionsText","DataFile.properties") );
	
	extReport.endTest(test);softAssert.assertAll();
}
	

	@AfterClass
	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
	}
}
