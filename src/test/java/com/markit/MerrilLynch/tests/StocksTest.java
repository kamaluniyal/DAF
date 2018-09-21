package com.markit.MerrilLynch.tests;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.DigitalAutomationFramework.page.FundDetails;
import com.markit.MerrilLynch.pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.markit.DigitalAutomationFramework.common.ExtentReporting;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;

/*
*
* @author: Sunny Jain	
* @purpose: This class contains all the regression scenarios of debt market module.
* @creation date: 13/7/2016
*
*/
public class StocksTest extends MerrilLynchProductTest{
	
   
	PropertyReader prop;
	GlobalDriver gDriver;
	Stocks stk;
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
		mlPP.fnWaitTillElementEnable(driver, 40, mlPP.wblnkResearch);
		stk = new Stocks(driver);
		

		parent = extent.startTest("Stocks");
	}
 
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	
	@Test(priority =0)
	public void TC_VerificationOfOverviewSearch_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfOverviewSearch_Stocks", "This Method will verify the search functionality on Stocks overview page."); 
	parent.appendChild(test);
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wblnkResearch);
	mlPP.actMouseOver(mlPP.wblnkResearch);
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemStocks);
	mlPP.wbelemStocks.click();
	
	stk.fnWaitTillElementVisible(driver, 40, stk.wbtxtSearchBoxOnStocks);
	
	fnVerifyElementExistence(stk.wbtxtSearchBoxOnStocks,"Seach Textbox on Stock Overview");
	fnVerifyElementExistence(stk.wblstStocksDropdown,"Dropdown right to serach box");
	
	stk.wbtxtSearchBoxOnStocks.sendKeys("AAPL");
	fnClick(stk.wbbtnSerachButton);
	Thread.sleep(5000);
	fnVerifyElementExistence(stk.wbelemSecurityProfile,"Security Profile");
	fnVerifyElementExistenceWithPartialText(stk.wbelemSymbolNameText,"APPLE");
	fnClick(stk.wblnkBackToOverviewLink);
	stk.fnWaitTillElementVisible(driver, 40, stk.wbtxtSearchBoxOnStocks);
	
	Thread.sleep(5000);
	
	stk.wbtxtSearchBoxOnStocks.sendKeys("AAPL");
	stk.fnSelectValueFromDropDownByValue(stk.wblstStocksDropdown, "NW");
	fnClick(stk.wbbtnSerachButton);
	fnVerifyElementExistenceWithText(stk.wbelemNewsSearchResults,"News Search Results");
	Thread.sleep(5000);
	fnClick(stk.wblnkBackToOverviewLinkOnNews);
	stk.fnWaitTillElementVisible(driver, 40, stk.wbtxtSearchBoxOnStocks);
	extReport.endTest(test);softAssert.assertAll();
	
	}
		
	
	@Test(priority =1,enabled = true)
	public void TC_VerificationOfMarketData_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfMarketData_Stocks", "This Method will verify the existence of several compoenents under 'US treasury' section on  the page"); 
	parent.appendChild(test);
	fnVerifyElementExistenceWithText(stk.wbelemFirstIndexOnStocks,"Dow Jones");
	fnVerifyElementExistenceWithText(stk.wbelemSecondIndexOnStocks,"S&P 500");
	fnVerifyElementExistenceWithText(stk.wbelemThirdIndexOnStocks,"NASDAQ");
	fnVerifyElementExistence(stk.wbelemStaticTextBelowIndices,"Market data is delayed by at least 20 minutes");
	
	extReport.enterLog("Info", "Mouse hover on Dow Jones");
	stk.jsMouseOver(stk.wbelemFirstIndexOnStocks);
	stk.fnWaitTillElementVisible(driver, 100, stk.wbelemIndicesHoverTextOnStocks);
	Thread.sleep(2000);
	fnVerifyElementExistenceWithPartialText(stk.wbelemIndicesHoverTextOnStocks,"DOW JONES INDUSTRIAL AVERAGE");
	
	Thread.sleep(3000);
	
	extReport.enterLog("Info", "Mouse hover on S&P 500");
	stk.jsMouseOver(stk.wbelemSecondIndexOnStocks);
	stk.fnWaitTillElementVisible(driver, 100, stk.wbelemIndicesHoverTextOnStocks);
	Thread.sleep(2000);
	fnVerifyElementExistenceWithPartialText(stk.wbelemIndicesHoverTextOnStocks,"S&P 500 INDEX");
	
	Thread.sleep(3000);
	
	extReport.enterLog("Info", "Mouse hover on NASDAQ");
	stk.jsMouseOver(stk.wbelemThirdIndexOnStocks);
	stk.fnWaitTillElementVisible(driver, 100, stk.wbelemIndicesHoverTextOnStocks);
	Thread.sleep(2000);
	fnVerifyElementExistenceWithPartialText(stk.wbelemIndicesHoverTextOnStocks,"NASDAQ COMPOSITE");
	
	
	extReport.endTest(test);softAssert.assertAll();
	
	}	

	
	@Test(priority =2,enabled = true)
	public void TC_VerificationOfScreeningStrategies_ResearchFirms_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfScreeningStrategies_ResearchFirms_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistenceWithText(stk.wbelemStrategiesFromResearchFirms,"Strategies from Research Firms");
	fnVerifyElementExistenceWithText(stk.wbelemPopularScreeningStrategies,"Popular Screening Strategies");
	fnVerifyElementExistenceWithText(stk.wbelemCreateYourOwnScreen,"Create Your Own Screen");
	fnVerifyElementExistence(stk.wbelemBankOfAmericaMerrillLynch,"Bank of America Merrill Lynch Strategy");
	fnVerifyElementExistence(stk.wblnkMoreLinkUnderBankOfAmericaMerrillLynch,"More link under Bank of America Merrill Lynch Strategy");
	fnVerifyElementExistence(stk.wbelemMorningStar,"Morning Star Strategy");
	fnVerifyElementExistence(stk.wblnkMoreLinkUnderMorningStar,"More link under Morning Star Strategy");
	fnVerifyElementExistence(stk.wbelemSPCapitalIQ,"S&P Capital IQ Strategy");
	fnVerifyElementExistence(stk.wblnkMoreLinkUnderSPCapitalIQ,"More link under S&P Capital IQ Strategy");
	
	extReport.endTest(test);softAssert.assertAll();

	}	
	
	@Test(priority =3,enabled = true)
	public void TC_VerificationOfPopularScreeningStrategies_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfPopularScreeningStrategies_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistence(stk.wbelemFirstPopularScreen,"First Popular Screen under Popular Screening Strategies");
	fnVerifyElementExistence(stk.wbelemSecondPopularScreen,"Second Popular Screen under Popular Screening Strategies");
	fnVerifyElementExistence(stk.wbelemThirdPopularScreen,"Third Popular Screen under Popular Screening Strategies");
	fnVerifyElementExistence(stk.wblnkMoreLinkUnderMorningStar,"More link under Popular Screening Strategies");
	fnClick(stk.wbelemFirstPopularScreen);
	fnVerifyElementExistence(stk.wbelemCustomScreens,"Custom Screens");
	
	stk.fnNavigateBack();
	stk.fnWaitTillElementVisible(driver, 80, stk.wbtxtSearchBoxOnStocks);
	extReport.endTest(test);softAssert.assertAll();

	}	
	
	@Test(priority =4,enabled = true)
	public void TC_VerificationOfCreateYourOwnScreenSection_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfCreateYourOwnScreenSection_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistenceWithText(stk.wbelemCreateYourOwnScreenText,"Choose from more than 100 filters to help narrow down your stock search.");
	fnVerifyElementExistence(stk.wbbtnCreateScreenButton,"Create Screen under Create your owm Screen");
	fnVerifyElementExistence(stk.wblstScreenDropdown,"Dropdown next to Create button under Create your owm Screen");

	extReport.endTest(test);softAssert.assertAll();

	}	
	
	@Test(priority =5,enabled = true)
	public void TC_VerificationOfCalendarSection_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfCalendarSection_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistenceWithText(stk.wbelemCalendarText,"Calendar");
	fnVerifyElementExistenceWithText(stk.wblnkEconomicCalendarLink,"Economic Calendar");
	fnVerifyElementExistenceWithText(stk.wblnkStocksSplitsLink,"Stock Splits");
	fnVerifyElementExistenceWithText(stk.wblnkPublicOfferingsLink,"Public Offerings");
	fnVerifyElementExistence(stk.wblnkViewMoreEvents,"View more events link under Calendar");
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	@Test(priority =6,enabled = true)
	public void TC_VerificationOfLatestStocksNews_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfLatestStocksNews_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistenceWithText(stk.wbelemLatestStocksNewsText,"Latest Stocks News");
	fnVerifyElementExistenceWithText(stk.wblnkViewMoreStocksNews,"View more Stocks News >");
	
	fnClick(stk.wblnkFirstNewsUnderLatstStocksNews);
	fnVerifyElementExistence(stk.wbelemRelatedNews,"Related News");
	fnClick(stk.wblnkBackToOverviewLinkOnNewsSection);
	stk.fnWaitTillElementVisible(driver, 80, stk.wbtxtSearchBoxOnStocks);
	extReport.endTest(test);softAssert.assertAll();

	}


	
	@Test(priority =7,enabled = true)
	public void TC_VerificationOfRelatedInsights_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfRelatedInsights_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistenceWithText(stk.wbelemRelatedInsightsText,"Related Insights");
	fnVerifyElementExistenceWithText(stk.wbelemInvestingInStocks,"Investing in Stocks");
	fnVerifyElementExistenceWithText(stk.wbelemPortfolioRebalancing,"Portfolio Rebalancing");
	extReport.endTest(test);softAssert.assertAll();

	}
	
	
	@Test(priority =8,enabled = true)
	public void TC_VerificationOfFreeFundamentalAnalysis_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfFreeFundamentalAnalysis_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistence(stk.wbimgFreeFundamentalAnalysis,"Free fundamental analysis for Edge investors module");
	fnVerifyElementExistenceWithText(stk.wbelemSectorSummary,"Sector Summary");
	fnVerifyElementExistenceWithText(stk.wblnkViewMoreNewsResearchBySector,"View More News & Research by Sector >");
	fnClick(stk.wblnkFirstSector);
	
	fnVerifyElementExistenceWithPartialText(stk.wbelemSectorSummaryTitle,"Sector Summary");
	stk.fnNavigateBack();
	stk.fnWaitTillElementVisible(driver, 80, stk.wbtxtSearchBoxOnStocks);
	
	fnClick(stk.wblnkViewMoreNewsResearchBySector);
	
	fnVerifyElementExistenceWithText(stk.wbelemSectorSummaryTitle,"Sector Summary");
	stk.fnNavigateBack();
	stk.fnWaitTillElementVisible(driver, 80, stk.wbtxtSearchBoxOnStocks);
	
	
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	
	@Test(priority = 9,enabled = true)
	public void TC_VerificationOfBofAMLResearchChanges_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfBofAMLResearchChanges_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistenceWithText(stk.wbelemBofAMLResearchChanges,"BofAML Research Changes");
	fnVerifyElementExistence(stk.wblstViewByDropdown,"View by Dropdown");
	fnVerifyElementExistence(stk.wblstChangeTypeDropdown,"Change type Dropdown");
	fnVerifyElementExistenceWithText(stk.wblnkViewMoreBofAMLRatingsCHanges,"View More BofAML Ratings Changes >");
	
	fnVerifyElementExistenceWithText(stk.wbelemSectorSummary,"Sector Summary");
	
    try{
    	
    	String str = "Security@Change Date@Previous@New";
	
	List<String> actualText = stk.fnGetListOfColumnElementsForRowFromWebtable(stk.wbtblResearchTable,0);

    String[] expectedText = str.split("@");

    for (int j = 0; j < expectedText.length; j++) {

          if (expectedText[j].equals(actualText.get(j))) {
                 extReport.enterLog("Pass", actualText.get(j) + " has been verified successfully.");
          } else {
                 extReport.enterLog("Fail",
                               actualText.get(j) + " is not same with expected text - " + expectedText[j]);
                 softAssert.assertEquals(true, false, "Webtable header verification failed ");
          }
    }
} catch (Exception e) {
    extReport.enterLog("Fail", e.getMessage());
    softAssert.assertEquals(true, false, e.getMessage()+"Exception Occured");
    Log.info(e.getMessage());

}

    fnClick(stk.wblnkViewMoreBofAMLRatingsCHanges);
	
	fnVerifyElementExistenceWithText(stk.wbelemBofAMLRatingComponentChanges,"BofAML Rating Component Changes");

	fnClick(stk.wblnkBackToOverviewLinkOnNewsSection);
	stk.fnWaitTillElementVisible(driver, 80, stk.wbtxtSearchBoxOnStocks);
	extReport.endTest(test);softAssert.assertAll();

	}
		
	
	@Test(priority =10,enabled = true)
	public void TC_VerificationOfFeaturedResearchReports_Stocks() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfFeaturedResearchReports_Stocks", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	

	
	fnVerifyElementExistenceWithText(stk.wbelemFeaturedResearchReportsText,"Featured Research Reports");
	fnVerifyElementExistenceWithText(stk.wblnkViewMoreStocksResearch,"View more Stocks Research >");
	
	String str= stk.wblnkFirstReportUnderFeaturedResearchReports.getText();
	fnClick(stk.wblnkFirstReportUnderFeaturedResearchReports);
	
	Thread.sleep(15000);
	stk.fnSwitchToNewlyOpenedWindow();
	
	Thread.sleep(15000);
	String title= driver.getTitle();
	
	if (str.contains(title.substring(0, title.indexOf(" ")))){
		 extReport.enterLog("Pass", "Report title in PDF has been verfied successfully");
	}
		else{
		
			 extReport.enterLog("Fail", "Report title in PDF has not been verfied successfully");
	}
	
	driver.close();
	Thread.sleep(6000);
	
	
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	@AfterClass
	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
	}

}
