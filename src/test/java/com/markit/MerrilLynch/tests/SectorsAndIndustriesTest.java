package com.markit.MerrilLynch.tests;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.DigitalAutomationFramework.page.FundDetails;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.markit.MerrilLynch.pages.SectorsAndIndustries;
import com.markit.MerrilLynch.pages.USMarkets;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.markit.DigitalAutomationFramework.common.ExtentReporting;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;


public class SectorsAndIndustriesTest extends MerrilLynchProductTest{


	/*
	 *
	 * @author: Rahul Tiwari
	 * @purpose: This class contains all the regression scenarios of Sectors and Industries module.
	 * @creation date: 5/7/2016
	 *
	 */
	PropertyReader prop;
	GlobalDriver gDriver;
	SectorsAndIndustries SI;
	MerrillLynchProductPage mlPP;
	String loggedUser;
	SendMail mailObj;
	ExtentTest parent;
	int expCounter=0;
	/*
	 *@purpose: This function is used to click the desired sector tab based on the values passed by the dataprovider.
	 * 
	 */

	public void fnClickSector(String sector) throws InterruptedException
	{
		
		try{
			switch( sector)
			{		
			case "Energy":
				Thread.sleep(3000);			
				SI.wbelemEnergyIcon.click();
				Thread.sleep(4000);	
				break;
			case "Utilities":
				Thread.sleep(3000);
				SI.wbelemUtilitiesIcon.click();
				Thread.sleep(4000);
				break;
			case "Financials":
				Thread.sleep(3000);
				SI.wbelemFinancialsIcon.click();
				Thread.sleep(4000);
				break;
			case "Consumer Discretionary":
				Thread.sleep(3000);
				SI.wbelemConsumerDiscretionaryIcon.click();
				Thread.sleep(4000);
				break;
			case "Consumer Staples":
				Thread.sleep(3000);
				SI.wbelemConsumerStaplesIcon.click();
				Thread.sleep(4000);
				break;
			case "Telecommunication Services":
				Thread.sleep(3000);
				SI.wbelemTelecommunicationServicesIcon.click();
				Thread.sleep(4000);
				break;
			case "Information Technology":
				Thread.sleep(3000);
				SI.wbelemInformationTechnologyIcon.click();
				Thread.sleep(4000);
				break;
			case "Health Care":
				Thread.sleep(3000);
				SI.wbelemHealthCareIcon.click();
				Thread.sleep(4000);
				break;
			case "Materials":
				Thread.sleep(3000);
				SI.wbelemMaterialsIcon.click();
				Thread.sleep(4000);
				break;
			case "Industrials":
				Thread.sleep(3000);
				SI.wbelemIndustrialsIcon.click();
				Thread.sleep(4000);
				break;
			default:
				System.out.println("Option not found :"+sector);
				break;

			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while clicking");
			expCounter++;
			if(expCounter<3)
			{
				System.out.println("Trying to click again...");
				fnClickSector(sector);
				Thread.sleep(4000);
			}
		}
	}

	/*
	 *@purpose: This function is used to provide data to the scenarios which have repeated verifications but for different category of indicators.
	 * 
	 */
	@DataProvider(name = "sector")
	public static Object[][] sectorsTest() 
	{
		Object[][] obj= {{"Energy"},{"Information Technology"},{"Utilities"},{"Materials"},{"Consumer Staples"},{"Consumer Discretionary"},{"Telecommunication Services"},{"Financials"},{"Industrials"},{"Health Care"}};

		//Object[][] obj= {{"Information Technology"}};
		return obj;
	}
	
	/*
	 * @purpose: This function is used for initial setup and launching the ML application on browser.
	 */

	@BeforeClass
	@Parameters({ "browser", "version", "Sel_Grid", "environment" })
	public void initialSetup(@Optional String browser, @Optional String version, @Optional String Sel_Grid,
			@Optional String environment) throws Exception {


		mlPP = setupEnvironment(browser, version, Sel_Grid, environment);
		mlPP.sendObject(extReport ,softAssert);
		mlPP.fnWaitTillElementEnable(driver, 120, mlPP.wbframe1);				
		mlPP.fnLogin(userId,password);
		mlPP.fnWaitTillElementEnable(driver, 120, mlPP.wblnkResearch);
		SI = new SectorsAndIndustries(driver);

		parent = extent.startTest("Sector and Industries");

	}
	
	/*
	 * @purpose: This function is used for initialising assertions before each test method.
	 */
	
	@BeforeMethod

	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	/*
	 * @purpose: This function is used for consolidating assertions after each test method.
	 */
	

	//Sector Overview
	@Test(priority =0)
	public void TC_VerificationOfSectorOverviewSection() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfSectorOverviewSection", "This Method will verify the Sector Overview section");
		parent.appendChild(test);
		mlPP.wblnkResearch.click();
		Thread.sleep(7000);
		SI.wblnkSectorIndustriesTab.click();
		Thread.sleep(7000);
		//mlPP.fnWaitTillElementVisible(driver, 120, SI.wbelemSectorOverviewText);

		fnVerifyElementExistenceWithText(SI.wbelemSectorOverviewText,"Sector overview");
		
		fnVerifyElementExistence(SI.wbelemSectorOverviewContent,"Sector overview content");
		
		fnVerifyElementExistenceWithText(SI.wbelemDailySectorWrapUpText,"Daily Sector Wrap Up");
		
		fnVerifyElementExistence(SI.wblnkDailySectorWrapUpNewsLink,"Daily Sector Wrap Up News Link");
		
		fnVerifyElementExistence(SI.wbelemDailySectorWrapUpNewsSource,"Daily Sector Wrap Up News Source");
		
		fnVerifyElementExistence(SI.wbelemDailySectorWrapUpNewsTimestamp,"Daily Sector Wrap Up News Timestamp");
				
		extReport.endTest(test);
		softAssert.assertAll();
	}

	// components on page
	@Test(dataProvider="sector",priority =1,enabled=true)
	public void TC_VerificationOfPageComponentsOnSectorAndIndustries(String sector) throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPageComponentsOnSectorAndIndustriesFor"+sector, "This Method will verify the existence of several compoenents  on page for "+sector); 
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 120, "//div[contains(text(), 'performance')]"); // need to update

		fnClickSector(sector);
		//		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 120, "//div[text()='Your holdings in "+sector+"']");

		fnVerifyElementExistenceWithText(SI.wbelemWhatsHappeningText,"What's happening in sectors & industries");
		fnVerifyElementExistenceWithText(SI.wbelemSectorPerformanceText,sector+" performance");
		fnVerifyElementExistenceWithText(SI.wbelemSectorIndustries,sector+" industries");
		fnVerifyElementExistenceWithText(SI.wbelemYourHoldingsSectorText,"Your holdings in "+sector);
		fnVerifyElementExistenceWithText(SI.wbelemWaysToInvestText,"Ways to invest");
		//fnVerifyElementExistenceWithText(SI.wbelemSectorCompanyAnnouncementsText,"Company announcements");
		fnVerifyElementExistenceWithText(SI.wbelemSectorAnalystRatingsText,"Analyst ratings in the "+sector+" sector");
		if(sector.equalsIgnoreCase("Telecommunication Services"))
		{
			fnVerifyElementExistenceWithText(SI.wbelemLatestSectorNewsText,"Latest Telecom. Services news");
		}
		else 
		{
			fnVerifyElementExistenceWithText(SI.wbelemLatestSectorNewsText,"Latest "+sector+" news");	
		}
		
		extReport.endTest(test);
		softAssert.assertAll();
		

	}


	// Performance
	@Test(dataProvider="sector",priority =2, enabled=true)
	public void TC_VerificationOfPerformnaceSection(String sector) throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPerformnaceSectionFor"+sector, "This Method will verify the Performance section for "+sector); 
		parent.appendChild(test);
		fnClickSector(sector);
		//	Thread.sleep(7000);
		
		
		
		mlPP.fnWaitTillElementVisible(driver, 120, "//div[text()='Your holdings in "+sector+"']");
		mlPP.fnWaitTillElementVisible(driver, 120,SI.wbelemSectorChart);
		fnVerifyElementExistence(SI.wbelemSectorChart,sector+" Sector chart comparing the"+sector+" sector performance with S and P ");
		fnVerifyElementExistence(SI.wbelemSectorText,sector+" Sector Smart Text");
		fnVerifyElementExistenceWithText(SI.wbelemSectorNameChart,sector+" sector");
		fnVerifyElementExistenceWithText(SI.wbelemSectorNameVerususChart,"vs S&P 500");
		softAssert.assertAll();
		extReport.endTest(test);
	}
	// industries
	@Test(dataProvider="sector",priority =3, enabled=true)
	public void TC_VerificationOfIndustriesSection(String sector) throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfIndustriesSectionFor"+sector, "This Method will verify the Industry section for "+sector); 
		parent.appendChild(test);
		fnClickSector(sector);
		//		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 120, "//div[text()='"+sector+" industries']");
		fnVerifyElementExistenceWithText(SI.wbelemSectorIndustries,sector+" industries");
		fnVerifyElementExistence(SI.wbelemComapny1CompaniesCount,"Companies count");
		fnVerifyElementExistence(SI.wblnkCompany1Link,sector+" Company 1 link "+SI.wblnkCompany1Link.getText()+"'");
		fnVerifyElementExistence(SI.wbelemIndustries1MonthChangeText,"1 Month Change Text");
		fnVerifyElementExistence(SI.wbelemIndustries1MonthChangeValue,"1 Month Change Value "+SI.wbelemIndustries1MonthChangeValue.getText()+"'");
		fnVerifyElementExistence(SI.wbelemIndustries3MonthChangeText,"3 Month Change Text");
		fnVerifyElementExistence(SI.wbelemIndustries3MonthChangeValue,"3 Month Change Value "+SI.wbelemIndustries3MonthChangeValue.getText()+"'");
		fnVerifyElementExistence(SI.wbelemIndustries6MonthChangeText,"6 Month Change Text");
		fnVerifyElementExistence(SI.wbelemIndustries6MonthChangeValue,"6 Month Change Value "+SI.wbelemIndustries6MonthChangeValue.getText()+"'");
		fnVerifyElementExistence(SI.wbelemIndustries1YearChangeText,"1 Year Change Text");
		fnVerifyElementExistence(SI.wbelemIndustries1YearChangeValue,"1 Year Change Value "+SI.wbelemIndustries1YearChangeValue.getText()+"'");
		if(!SI.wbelemIndustriesSmartText.getText().equalsIgnoreCase("No data available"))
		{
			fnVerifyElementExistence(SI.wbelemIndustriesSmartText,"Smart text under industries section ");	
			fnVerifyElementExistence(SI.wbelemIndustries1YearChangeValue,"1 Year Change Value "+SI.wbelemIndustries1YearChangeValue.getText()+"'");
			fnVerifyElementExistence(SI.wbelemIndustriesSmartTextSectorChange,"Sector change in Smart text section in Industries");
			fnVerifyElementExistence(SI.wblnkIndustriesSmartTextLink,"Company link in Smart text section in Industries");
			fnVerifyElementExistence(SI.wbelemIndustriesSmartTextEquityChange,"Equity change in Smart text section in Industries");	
		}
		else 
		{
			fnVerifyElementExistenceWithText(SI.wbelemIndustriesSmartText,"No data available");
		}

		fnVerifyElementExistence(SI.wblstIndicesDropdown,"Dropdown for selecting the Indices");
		fnVerifyElementExistence(SI.wblstMarketCapDropdown,"Dropdown for selecting Market cap");		

		//Table verification 
		fnVerifyHeadersOfwebtable(SI.wbelemIndustriesTable,1,PropertyReader.getFieldValue("IndustryTableHeaders","DataFile.properties"));

		//dropdown selection 
		fnVerifyDropdownOptions(SI.wblstIndicesDropdown,PropertyReader.getFieldValue("IndicesDropdown","DataFile.properties"));
		fnVerifyDropdownOptions(SI.wblstMarketCapDropdown,PropertyReader.getFieldValue("MarketCapDropdown","DataFile.properties"));
		extReport.endTest(test);
		softAssert.assertAll();
		
	}



	@AfterClass
	public void quit() {
		driver.quit();
		extent.endTest(parent);
		
	}
	
}

