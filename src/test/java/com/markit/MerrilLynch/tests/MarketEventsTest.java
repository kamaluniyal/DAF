package com.markit.MerrilLynch.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.MerrilLynch.pages.MarketEvents;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class MarketEventsTest extends MerrilLynchProductTest{

	/*
	 *
	 * @author: Rahul Tiwari
	 * @purpose: This class contains all the regression scenarios of Market Events module.
	 * @creation date: 5/7/2016
	 *
	 */
	PropertyReader prop;
	GlobalDriver gDriver;
	MarketEvents ME;
	MerrillLynchProductPage mlPP;
	String loggedUser;
	SendMail mailObj;
	ExtentTest parent;

	/*
	 * @purpose: This function is used for initial setup and launching the ML application on browser.
	 */

	@BeforeClass
	@Parameters({ "browser", "version", "Sel_Grid", "environment" })
	public void initialSetup(@Optional String browser, @Optional String version, @Optional String Sel_Grid,
			@Optional String environment) throws Exception 
	{
		mlPP = setupEnvironment(browser, version, Sel_Grid, environment);
		mlPP.sendObject(extReport ,softAssert);
		mlPP.fnWaitTillElementEnable(driver, 40, mlPP.wbframe1);				
		mlPP.fnLogin(userId,password);
		mlPP.fnWaitTillElementEnable(driver, 40, mlPP.wblnkResearch);
		ME = new MarketEvents(driver);
		parent = extent.startTest("Market Events");
		
	}
	/*
	 * @purpose: This function is used to validate page components for Economic events tab.
	 */

	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	@Test(priority =0)
	public void TC_EconomicEventsPageComponents() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_EconomicEventsPageComponents", "This Method will verify the Componenets on Economic events page");
		parent
	    .appendChild(test);
		mlPP.wblnkResearch.click();
		ME.wblnkMarketEventstab.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ME.wbtblEventsHeaderText);
		fnVerifyElementExistenceWithText(ME.wbelemCompanyEventText, "Company Events");
		fnVerifyElementExistenceWithText(ME.wbelemEconomicEventText, "Economic Events");
		fnVerifyElementExistenceWithText(ME.wbelemMajorEconomicIndicatorText, "Major economic indicators");
		fnVerifyElementExistenceWithText(ME.wbelemSearchEventCalText, "Search event calendar");

		String number = ME.wbtblEventsHeaderText.getText().substring((ME.wbtblEventsHeaderText.getText().indexOf('('))+1,(ME.wbtblEventsHeaderText.getText().length()-1));
		int n = Integer.parseInt(number);
		if(n!=0)
		{
			fnVerifyElementExistence(ME.wbtblEventsTable, "Search result event table");
		}
		else
		{
			extReport.enterLog("info", "Events table not displayed for the current day");
		}

		extReport.endTest(test);softAssert.assertAll();
	}

	/*
	 *@purpose: This function is used to provide data to the scenarios which have repeated verifications but for different category of indicators.
	 * 
	 */
	@DataProvider(name = "indicators")
	public static Object[][] indicatorsTest() 
	{
		Object[][] obj= {{"Gross domestic product"},{"Consumer price index"},{"Retail sales"},{"Unemployment rate"},{"Trade balance report"},{"Factory orders"},{"Housing starts"}};

		//Object[][] obj= {{"Consumer Staples"}};
		return obj;
	}


	/*
	 *@purpose: This function is used to click the desired Indicator tab based on the values passed by the dataprovider.
	 * 
	 */
	public void fnClickTab(String indicators)
	{
		switch( indicators)
		{
		case "Gross domestic product":
			ME.wblnkGDPtab.click();
			break;
		case "Consumer price index":
			ME.wblnkCPItab.click();
			break;
		case "Retail sales":
			ME.wblnkRetailSalesTab.click();
			break;
		case "Unemployment rate":
			ME.wblnkUnemploymentRateTab.click();
			break;
		case "Trade balance report":
			ME.wblnkTradeBalanceReportTab.click();
			break;
		case "Factory orders":
			ME.wblnkFactoryOrderTab.click();
			break;
		case "Housing starts":
			ME.wblnkHousingStartsTab.click();
			break;
		default:
			System.out.println("Option not found :"+indicators);
			break;


		}
	}

	/*
	 *@purpose: This function is used to validate components for each Major indicators for Economic events tab.
	 * 
	 */
	@Test(priority =1, enabled = false,dataProvider="indicators")
	public void TC_EconomicEventsMajorIndicators_MarketsEvents(String indicator) throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_EconomicEventsMajorIndicators"+indicator, "This Method will verify the Major economic indicators ");
		parent
	    .appendChild(test);
		fnVerifyElementExistenceWithText(ME.wblnkGDPtab, "Gross domestic product");
		fnVerifyElementExistenceWithText(ME.wblnkCPItab, "Consumer price index");
		fnVerifyElementExistenceWithText(ME.wblnkFactoryOrderTab, "Factory orders");
		fnVerifyElementExistenceWithText(ME.wblnkRetailSalesTab, "Retail sales");
		fnVerifyElementExistenceWithText(ME.wblnkUnemploymentRateTab, "Unemployment rate");
		fnVerifyElementExistenceWithText(ME.wblnkTradeBalanceReportTab, "Trade balance report");
		fnVerifyElementExistenceWithText(ME.wblnkHousingStartsTab,"Housing starts");


		fnClickTab(indicator);
		Thread.sleep(4000);
		mlPP.fnWaitTillElementVisible(driver, 30, ME.wbelemPerformanceChart);
		fnVerifyElementExistence(ME.wbelemPerformanceChart,"Performance chart for "+ indicator );
		fnVerifyElementExistence(ME.wbelemSummaryText,"Summary text for "+ indicator );
		if(!ME.wbelemSummaryText.getText().equals("No data available"))
		{
			fnVerifyElementExistence(ME.wbelemEconodayText,"Econoday text for "+ indicator +" '"+ME.wbelemEconodayText.getText()+"'");
			fnVerifyElementExistenceWithText(ME.wblnkViewFullAnalysisLink,"View full analysis");
		}
		fnVerifyElementExistenceWithText(ME.wbelem1Month,"1 Month");
		//ME.wbelem1Month.click();
		mlPP.fnWaitTillElementVisible(driver, 30, ME.wbelemPerformanceChart);
		fnVerifyElementExistenceWithText(ME.wbelem3Month,"3 Months");
		//ME.wbelem3Month.click();
		mlPP.fnWaitTillElementVisible(driver, 30, ME.wbelemPerformanceChart);
		fnVerifyElementExistenceWithText(ME.wbelem6Month,"6 Months");
		//ME.wbelem6Month.click();
		mlPP.fnWaitTillElementVisible(driver, 30, ME.wbelemPerformanceChart);
		fnVerifyElementExistenceWithText(ME.wbelem1Year,"1 Year");
		//ME.wbelem1Year.click();
		mlPP.fnWaitTillElementVisible(driver, 60, ME.wbelemChartHeader);
		fnVerifyElementExistenceWithText(ME.wbelemChartHeader,indicator);

		extReport.endTest(test);softAssert.assertAll();
	}

	/*
	 *@purpose: This function is used to validate the Modal appearing after clicking on "View full Analysis" for each Major indicators for Economic events tab.
	 * 
	 */
	@Test(priority =2, enabled = true ,dataProvider="indicators")
	public void TC_EconomicEventsMajorIndicatorsModal_MarketsEvents(String indicator) throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_EconomicEventsMajorIndicatorsModal"+indicator, "This Method will verify the Modal opened after clicking on View Full Analysis link");
		parent
	    .appendChild(test);
		fnClickTab(indicator);
		Thread.sleep(4000);
		mlPP.fnWaitTillElementVisible(driver, 30, ME.wbelemSummaryText);
		if(!ME.wbelemSummaryText.getText().equals("No data available"))
		{
			mlPP.fnWaitTillElementEnable(driver, 30, ME.wblnkViewFullAnalysisLink);
			ME.wblnkViewFullAnalysisLink.click();
			mlPP.fnWaitTillElementVisible(driver, 60, ME.wbelemModalHeadingText);
			fnVerifyElementExistenceWithText(ME.wbelemModalHeadingText,indicator);
			fnVerifyElementExistenceWithText(ME.wbelemModalConsensusEstimateText,"Consensus estimate"+"\n"+"prior to the report");
			fnVerifyElementExistence(ME.wbelemModalConsensusEstimateValue,"Consensus value "+ME.wbelemModalConsensusEstimateValue.getText());
			fnVerifyElementExistenceWithText(ME.wbelemModalActualEstimateText,"Actual number"+"\n"+"reported");
			fnVerifyElementExistence(ME.wbelemModalActualEstimateValue,"Actual number value "+ME.wbelemModalConsensusEstimateValue.getText());
			fnVerifyElementExistenceWithText(ME.wbelemModalPreviousPeriodText,"Number from the"+"\n"+"previous period");
			fnVerifyElementExistence(ME.wbelemModalPreviousPeriodValue,"Previous period value "+ME.wbelemModalConsensusEstimateValue.getText());
			fnVerifyElementExistenceWithText(ME.wbelemModalAnalysisHeader,"Analysis");
			fnVerifyElementExistence(ME.wbelemModalSmartText,"Modal smart text ");
			fnVerifyElementExistence(ME.wbelemModalEconodayLogo,"Econoday logo");
			fnVerifyElementExistence(ME.wblnkModalCloseLink," Close link ");
			fnVerifyElementExistenceWithText(ME.wbelemModalDisclaimerText,"Important Legal Notice: Econoday has attempted to verify the information contained in this calendar. However, any aspect of such info may change without notice. Econoday does not provide investment advice, and does not represent that any of the information or related analysis is accurate or complete at any time. Legal Notices © 1998-2017 Econoday, Inc. All Rights Reserved");

			ME.wblnkModalCloseLink.click();

		}
		else 
		{
			fnVerifyElementExistenceWithText(ME.wbelemSummaryText,"No data available");
		}



		extReport.endTest(test);softAssert.assertAll();
	}

	/*
	 *@purpose: This function is used to validate the Search section for Economic events tab.
	 * 
	 */
	@Test(priority =3, enabled = true)
	public void TC_EconomicEventSearch_MarketsEvents() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_EconomicEventSearch", "This Method will verify the event search section");
		parent
	    .appendChild(test);
		mlPP.wblnkResearch.click();
		ME.wblnkMarketEventstab.click();
		fnVerifyElementExistenceWithText(ME.wbelemEconomicEventSelectWeekText, "Select a week");
		fnVerifyElementExistence(ME.wbelemEconomicSearchbox, "Search event calendar Search box ");
		fnVerifyElementExistenceWithText(ME.wblnkResetLink, "Reset");
		fnVerifyElementExistence(ME.wbtblCurrentWeekTable, "Current week table");
		fnVerifyElementExistenceWithText(ME.wblnkNextWeekLink, "Next week »");
		fnVerifyElementExistenceWithText(ME.wblnkTodayLink, "Today");
		fnVerifyElementExistenceWithText(ME.wblnkPreviousWeekLink, "« Previous week");
		fnVerifyElementExistenceWithPartialText(ME.wbelemEconomicEvents1stDayDate, "Mon");
		fnVerifyElementExistenceWithPartialText(ME.wbelemEconomicEvents2ndDayDate, "Tue");
		fnVerifyElementExistenceWithPartialText(ME.wbelemEconomicEvents3rdDayDate, "Wed");
		fnVerifyElementExistenceWithPartialText(ME.wbelemEconomicEvents4thDayDate, "Thu");
		fnVerifyElementExistenceWithPartialText(ME.wbelemEconomicEvents5thDayDate, "Fri");		 

		extReport.endTest(test);softAssert.assertAll();
	}
	

	
	@AfterClass
	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
	}
}
