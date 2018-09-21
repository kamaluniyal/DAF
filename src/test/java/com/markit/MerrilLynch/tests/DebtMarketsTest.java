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
public class DebtMarketsTest extends MerrilLynchProductTest{
	
   
	PropertyReader prop;
	GlobalDriver gDriver;
	DebtMarkets DM;
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
		DM = new DebtMarkets(driver);
		

		parent = extent.startTest("Debt market");
	}
 
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	
	@Test(priority =0)
	public void TC_VerificationOfPageComponentsOnDebtMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfPageComponentsOnDebtMarkets", "This Method will verify the existence of several components on page"); 
	parent.appendChild(test);
	mlPP.wblnkResearch.click();
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemDebtMarketsTab);
	mlPP.wbelemDebtMarketsTab.click();
	mlPP.fnWaitTillElementVisible(driver, 40, DM.wbelemUSTreasuryText);
	
	fnVerifyElementExistenceWithText(DM.wbelemUSTreasuryText,"U.S. Treasury");
	fnVerifyElementExistenceWithText(DM.wbelemFixedIncomeETFsText,"Fixed income ETFs");
	fnVerifyElementExistenceWithText(DM.wbelemLatestFixedIncomeNewsText,"Latest fixed income news");
	fnVerifyElementExistenceWithText(DM.wbelemTreasuryBondMaturitiesText,"Treasury bond maturities");
	fnVerifyElementExistenceWithText(DM.wbelemMovingTheMarketText,"Moving the Market");
	fnVerifyElementExistenceWithText(DM.wbelemWaysToInvestInDebtMarketsText,"Ways to invest in debt markets");
	fnVerifyElementExistenceWithText(DM.wbelemLatestFixedIncomeReportsText,"Latest fixed income reports from BofAML Global Research");
	
	extReport.endTest(test);softAssert.assertAll();
	
	}
		
	
	@Test(priority =1,enabled = true)
	public void TC_VerificationOfUSTreasurySection_DebtMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfUSTreasurySectionOnUsMarkets", "This Method will verify the existence of several compoenents under 'US treasury' section on  the page"); 
	parent.appendChild(test);
	fnVerifyElementExistenceWithText(DM.wbimgTreasuryYieldCurveText,"Treasury yield curve");
	fnVerifyElementExistenceWithText(DM.wbelemAnalysisText,"Analysis:");
	fnVerifyElementExistenceWithText(DM.wbelem1MonthTrendText,"1 month trend");
	fnVerifyElementExistence(DM.wbelemAnalysisIcon,"Analysis Icon");
	fnVerifyElementExistence(DM.wbelem1MonthTrendIcon,"1 month Trend Icon");
	fnVerifyElementExistence(DM.wbimgTreasuryYieldCurveChart,"Treasury Yield Curve Chart");
	fnVerifyElementExistence(DM.wbelemTimeStampBelowTreasuryYieldCurve,"Time Stamp below Treasury Yield Curve");
	
	extReport.endTest(test);softAssert.assertAll();
	
	}	

	
	@Test(priority =2,enabled = true)
	public void TC_VerificationOfFixedIncomeETFs_DebtMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfFixedIncomeETFs", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	fnVerifyElementExistenceWithText(DM.wbelemUSBroadMarketETFs,"U.S. broad market ETFs");
	fnVerifyElementExistenceWithText(DM.wbelemUSCorporateETFs,"U.S. corporate ETFs");
	fnVerifyElementExistenceWithText(DM.wbelemUSTreasuryETFs,"U.S. Treasury ETFs");
	fnVerifyElementExistenceWithText(DM.wbelemUSMunicipalETFs,"U.S. municipal ETFs");
	fnVerifyElementExistence(DM.wbimgTopPerformingChart,"Top Performing Chart");
	fnVerifyHeadersOfwebtable(DM.wbtblTopPerformingFundsTable,2,PropertyReader.getFieldValue("TopPerformingFundsTableHeadings","DataFile.properties"));
	fnVerifyElementExistenceWithText(DM.wblnkFindFundsUsingOurScreener,"Find funds using our screener");
	
	extReport.enterLog("Info","Clicking on the Read more link");
	DM.wblnkFindFundsUsingOurScreener.click();
	mlPP.fnWaitTillElementVisible(driver, 60, DM.wbelemScreenForETFText);
	fnVerifyElementExistenceWithText(DM.wbelemETFScreener,"ETF Screener");	
	fnVerifyElementExistenceWithText(DM.wbelemScreenForETFText,"Screen for ETFs");	
	DM.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, DM.wbelemUSTreasuryText);
	
	extReport.endTest(test);softAssert.assertAll();

	}	
	
	
	@Test(priority =3,enabled = true)
	public void TC_VerificationOfTreasuryBondMaturities_DebtMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfTReasuryBondMaturities", "This Method will verify the existence of several elements under 'Treasury Bond Maturities' section on  the page"); 
	parent.appendChild(test);
	fnVerifyElementExistenceWithText(DM.wblnk1weekLinkUnderTreasuryBondMaturities,"1 Week");
	fnVerifyElementExistenceWithText(DM.wblnk1MonthLinkUnderTreasuryBondMaturities,"1 Month");
	fnVerifyElementExistenceWithText(DM.wblnk3MonthsLinkUnderTreasuryBondMaturities,"3 Months");
	fnVerifyElementExistenceWithText(DM.wblnk6MonthsLinkUnderTreasuryBondMaturities,"6 Months");
	fnVerifyElementExistenceWithText(DM.wblnk1yearLinkUnderTreasuryBondMaturities,"1 Year");
	fnVerifyHeadersOfwebtable(DM.wbtblTreasuryBondMaturitiesTable,1,PropertyReader.getFieldValue("TreasuryBondMaturitiesTableHeadings","DataFile.properties"));
	fnVerifyElementExistence(DM.wbelemTimeStampUnderTreasuryBondMaturities,"Time stamp information under Treasury bond maturities");
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	
	@AfterClass
	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
	}

}
