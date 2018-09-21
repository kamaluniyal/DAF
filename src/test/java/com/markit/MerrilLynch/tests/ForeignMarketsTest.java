
package com.markit.MerrilLynch.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.DigitalAutomationFramework.page.FundDetails;
import com.markit.DigitalAutomationFramework.page.ProductPage;
import com.markit.DigitalAutomationFramework.test.ProductTestClass;
import com.markit.DigitalAutomationFramework.common.DataReader;
import com.markit.DigitalAutomationFramework.common.TestClass;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.markit.MerrilLynch.pages.ForeignMarkets;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;

/*
*
* @author: Kamal Uniyal
* @purpose: this is a Foreign market Test class
* @creation date: 24/6/2016
*
*/

public class ForeignMarketsTest extends MerrilLynchProductTest{
	

	PropertyReader prop;
	GlobalDriver gDriver;
	ForeignMarkets ForeignMarkets;
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
		ForeignMarkets = new ForeignMarkets(driver);
		
		parent = extent.startTest("Foreign market");
	}
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}

	@Test(priority =0)
	public void TC_VerificationOfPageComponentsOnForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfPageComponentsOnForeignMarkets", "This Method will verify the existence of several compoenents on Foreign Markets page");
		parent
	    .appendChild(test1);
		mlPP.wblnkResearch.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wblnkForeignMarkets);
		ForeignMarkets.wblnkForeignMarkets.click();
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkAsiaPacific,"Asia Pacific");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkEurope, "Europe");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkAmericas, "Americas");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemLatestNews, "Latest Asia Pacific news");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvestText, "Ways to invest in Asia Pacific");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemAsiaPacificCurrencies, "Asian Pacific currencies");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemReportsFromBofAMLText ,"Latest Asia Pacific reports from BofAML Global Research");
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	

	
	@Test(priority =1 , enabled = true)
	public void TC_VerificationOfVariousMarketsIn_AsiaPacific_Under_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfVariousMarketsIn_AsiaPacific_Under_ForeignMarkets", "This Method will verify the basic elements in Asia Pacific Page");
		parent.appendChild(test1);
		fnVerifyElementExistence(ForeignMarkets.wbelemSummary, "Summary of Asia In Brief");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkFTSE_Singapore,"FTSE - Singapore") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkHangSeng,"Hang Seng") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkNikkei225,"Nikkei 225") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkTopixJapan,"Topix - Japan") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkAllOrdinariesAustralia,"All Ordinaries - Australia") ;
		// add logic to verify the static text 
		fnVerifyElementExistence(ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific,"Quotes delayed by message"+ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific.getText());
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentValue_FTSE, "Current value :" +ForeignMarkets.wbelemCurrentValue_FTSE.getText() );
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentPerformance_FTSE, "Current Performance :" +ForeignMarkets.wbelemCurrentPerformance_FTSE.getText() );
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentMonthChange_FTSE, "Monthly Performance :" +ForeignMarkets.wbelemCurrentMonthChange_FTSE.getText() );
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Day_FTSE,"1 Day") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Week_FTSE,"1 Week") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Month_FTSE,"1 Month") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk3Month_FTSE,"3 Months") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk6Month_FTSE,"6 Months") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Year_FTSE,"1 Year") ;
		fnVerifyElementExistence(ForeignMarkets.wblstCompareTo_FTSE, "Compare to List -");
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority =2 , enabled = true)
	public void TC_VerificationOf_WaysToInvestInAsiaPacific_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_WaysToInvestInAsiaPacific_ForeignMarkets", "This Method will verify the components under ways to invest in Asia Pacific page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMerrillEdgeSelectETFs,"Merrill Edge Select™ ETFs") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMerrillEdgeSelectFunds,"Merrill Edge Select™ Funds") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvest_MutualFunds,"Mutual funds") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvest_ETFs,"ETFs") ;
		ForeignMarkets.wblnkWaysToInvest_MutualFunds_Fund.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemScreenForMutualFund);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemScreenForMutualFund,"Screen for mutual funds") ;
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		ForeignMarkets.wblnkWaysToInvest_ETFs_Fund.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemETF_Screener);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemETF_Screener,"Screen for ETFs");
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	@Test(priority =3 , enabled = true)
	public void TC_VerificationOf_LatestReportsInAsiaPacific_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_LatestReportsInAsiaPacific_ForeignMarkets", "This Method will verify the components under Reports in Asia Pacific page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemReportsFromBofAMLText,"Latest Asia Pacific reports from BofAML Global Research") ;
		fnVerifyElementExistence(ForeignMarkets.wblnkReportsFromBofAML_ReportLink, "News headline under Latest Reports - "+ForeignMarkets.wblnkReportsFromBofAML_ReportLink.getText());
		fnVerifyElementExistence(ForeignMarkets.wbelemReportsFromBofAML_ReportTimestamp, "Time stamp information for Latest reports-"+ForeignMarkets.wbelemReportsFromBofAML_ReportTimestamp.getText());
		fnVerifyElementExistence(ForeignMarkets.wbelemReportsFromBofAML_ReportTeaser, "Teaser section for Latest reports");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkReportsFromBofAML_MoreReports,"More research reports") ;
		extReport.enterLog("Info","Clicking on more link");
		ForeignMarkets.wblnkReportsFromBofAML_MoreReports.click();
		mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemOverviewTab);
		fnVerifyElementExistence(mlPP.wbelemOverviewTab,"Overview tab");
		fnVerifyElementExistence(mlPP.wbelemResearchAndinsightText,"Research & Insight text");
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemReportsFromBofAMLText);
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	
	@Test(priority =4 , enabled = true)
	public void TC_VerificationOf_RecentNewsInAsiaPacific_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_RecentNewsInAsiaPacific_ForeignMarkets", "This Method will verify the components under recent news in Asia Pacific page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemLatestNews,"Latest Asia Pacific news");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemShowOnly,"Show only");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemMyholdingsText,"My holdings");
		fnVerifyElementExistence(ForeignMarkets.wbchkboxMyholdingsCheckbox,"My Holdings checkbox");		
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemMyWatchlistText,"My watchlist");
		fnVerifyElementExistence(ForeignMarkets.wbchkboxMyWatchlistCheckbox,"My watchlist checkbox");
		fnVerifyElementExistence(ForeignMarkets.wblnkNewsHeadlineOnRecentNews,"First news heading-"+ForeignMarkets.wblnkNewsHeadlineOnRecentNews.getText());
		fnVerifyElementExistence(ForeignMarkets.wbelemCompanyNameForNews,"Company name for First news heading-"+ ForeignMarkets.wbelemCompanyNameForNews.getText());
		fnVerifyElementExistence(ForeignMarkets.wbelemTeaserForFirstNews,"Teaser for first news");
		fnVerifyElementExistence(ForeignMarkets.wbelemTimeStampInformationForNews,"TimeStamp Information for first news-"+ForeignMarkets.wbelemTimeStampInformationForNews.getText());
		fnVerifyElementExistence(ForeignMarkets.wblnkReadMoreOnRecentNews,"Read more link");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMoreForeignMarketNews,"More foreign markets news");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemCompaniesInTheNews,"Companies in the news");
		fnVerifyElementExistence(ForeignMarkets.wbelemCompaniesinNews_AsOf,"TimeStamp of Companies in the news");
		extReport.endTest(test1);
		softAssert.assertAll();
	}
		
	@Test(priority =5 , enabled = true)
	public void TC_VerificationOf_CurrenciesInAsiaPacific_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_CurrenciesInAsiaPacific_ForeignMarkets", "This Method will verify the components under currencies in Asia Pacific page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemAsiaPacificCurrencies,"Asian Pacific currencies");
		fnVerifyElementExistence(ForeignMarkets.wblstAsiaPacificCurrencies_List,"List of currencies");
		fnVerifyElementExistence(ForeignMarkets.wbelem_vs1Dollar_AsiaPAcific,"Currency Vs 1 Dollar"+ForeignMarkets.wbelem_vs1Dollar_AsiaPAcific.getText());
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrencies_CurrencyConverter,"Currency conversion value-"+ForeignMarkets.wbelemCurrencies_CurrencyConverter.getText());
		// add logic to verify xyz = 1 USD
		fnVerifyElementExistence(ForeignMarkets.wbimgCurrencies_ChartImage,"Chart image");
		fnVerifyDropdownOptions(ForeignMarkets.wblstAsiaPacificCurrencies_List,PropertyReader.getFieldValue("AciaPacificCurrencies","DataFile.properties"));
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	
	@Test(priority =6 , enabled = true)
	public void TC_VerificationOfVariousMarketsIn_Europe_Under_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfVariousMarketsIn_Europe_Under_ForeignMarkets", "This Method will verify the existence of several compoenents on Europe page");
		parent.appendChild(test1);
		ForeignMarkets.wblnkEurope.click();
		fnVerifyElementExistence(ForeignMarkets.wbelemSummary, "Summary of Europe In Brief");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkBrussels_SE_Bel_20 ,"Brussels SE Bel-20");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkIrish_SE_ISEQ_Over ,"Irish SE ISEQ Over");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkCAC40_France ,"CAC 40 - France");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkFTSE100 ,"FTSE 100");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkAEX_Amsterdam ,"AEX - Amsterdam");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkDAX_Index_Germany ,"DAX Index - Germany");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkIBEX35_Spain ,"IBEX 35 - Spain");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkOMXC20_Denmark ,"OMXC 20 - Denmark");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkOMXH_Finland ,"OMXH - Finland");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkOMX_AllShare ,"OMX All Share");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkSMIprice_Swiss ,"SMI Price - Swiss");
		fnVerifyElementExistence(ForeignMarkets.wbelemQuotesDelayedBy_Europe,"Quotes delayed by message");
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentValue_Brussels, "Current value :" +ForeignMarkets.wbelemCurrentValue_Brussels.getText() );
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentPerformance_Brussels, "Current Performance :" +ForeignMarkets.wbelemCurrentPerformance_Brussels.getText() );
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentMonthChange_Brussels, "Monthly Performance :" +ForeignMarkets.wbelemCurrentMonthChange_Brussels.getText() );
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Day_Brussels,"1 Day") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Week_Brussels,"1 Week") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Month_Brussels,"1 Month") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk3Month_Brussels,"3 Months") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk6Month_Brussels,"6 Months") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Year_Brussels,"1 Year") ;
		fnVerifyElementExistence(ForeignMarkets.wblstCompareTo_Brussels, "Compare to List -");
		
		extReport.endTest(test1);
		
		softAssert.assertAll();
	}
	
	
	@Test(priority =7 , enabled = true)
	public void TC_VerificationOf_WaysToInvestInEurope_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_WaysToInvestInEurope_ForeignMarkets", "This Method will verify the components under Ways to Invest in Europe page");
		parent.appendChild(test1);
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemWaysToInvestText);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvestText,"Ways to invest in Europe");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMerrillEdgeSelectETFs,"Merrill Edge Select™ ETFs");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMerrillEdgeSelectFunds,"Merrill Edge Select™ Funds");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvest_MutualFunds,"Mutual funds") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvest_ETFs,"ETFs") ;
		ForeignMarkets.wblnkWaysToInvest_MutualFunds_Fund.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemScreenForMutualFund);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemScreenForMutualFund,"Screen for mutual funds") ;
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		ForeignMarkets.wblnkEurope.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Europe);
		ForeignMarkets.wblnkWaysToInvest_ETFs_Fund.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemETF_Screener);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemETF_Screener,"Screen for ETFs") ;
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		ForeignMarkets.wblnkEurope.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Europe);
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	@Test(priority =8 , enabled = true)
	public void TC_VerificationOf_LatestReportsInEurope_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_LatestReportsInEurope_ForeignMarkets", "This Method will verify the components under Reports in Europe page");
		parent.appendChild(test1);
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Europe);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemReportsFromBofAMLText,"Latest European reports from BofAML Global Research") ;
		fnVerifyElementExistence(ForeignMarkets.wblnkReportsFromBofAML_ReportLink, "News headline under Latest Reports");
		fnVerifyElementExistence(ForeignMarkets.wbelemReportsFromBofAML_ReportTimestamp, "Time stamp information for Latest reports");
		fnVerifyElementExistence(ForeignMarkets.wbelemReportsFromBofAML_ReportTeaser, "Teaser section for Latest reports");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkReportsFromBofAML_MoreReports,"More research reports") ;
		extReport.enterLog("Info","Clicking on the more link");
		ForeignMarkets.wblnkReportsFromBofAML_MoreReports.click();
		mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemOverviewTab);
		fnVerifyElementExistence(mlPP.wbelemOverviewTab,"Overview tab");
		fnVerifyElementExistence(mlPP.wbelemResearchAndinsightText,"Research & Insight text");
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		ForeignMarkets.wblnkEurope.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Europe);
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	
	
	@Test(priority =9 , enabled = true)
	public void TC_VerificationOf_RecentNewsInEurope_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_RecentNewsInEurope_ForeignMarkets", "This Method will verify the components under Recent news in Europe page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemLatestNews,"Latest European news");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemShowOnly,"Show only");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemMyholdingsText,"My holdings");
		fnVerifyElementExistence(ForeignMarkets.wbchkboxMyholdingsCheckbox,"My Holdings checkbox");		
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemMyWatchlistText,"My watchlist");
		fnVerifyElementExistence(ForeignMarkets.wbchkboxMyWatchlistCheckbox,"My watchlist checkbox");
		fnVerifyElementExistence(ForeignMarkets.wblnkNewsHeadlineOnRecentNews,"First news heading");
		fnVerifyElementExistence(ForeignMarkets.wbelemCompanyNameForNews,"Company name for First news heading");
		fnVerifyElementExistence(ForeignMarkets.wbelemTeaserForFirstNews,"Teaser for first news");
		fnVerifyElementExistence(ForeignMarkets.wbelemTimeStampInformationForNews,"TimeStamp Information for first news");
		fnVerifyElementExistence(ForeignMarkets.wblnkReadMoreOnRecentNews,"Read more link");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMoreForeignMarketNews,"More foreign markets news");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemCompaniesInTheNews,"Companies in the news");
		fnVerifyElementExistence(ForeignMarkets.wbelemCompaniesinNews_AsOf,"TimeStamp of Companies in the news");
		extReport.endTest(test1);
		softAssert.assertAll();
		
	}
	
	
	@Test(priority =10 , enabled = true)
	public void TC_VerificationOf_CurrenciesInEurope_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_CurrenciesInEurope_ForeignMarkets", "This Method will verify the components under currencies in Europe page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemEuropeanCurrencies,"European currencies");
        fnVerifyElementExistence(ForeignMarkets.wblstEuropeanCurrencies_List,"List of currencies");
        fnVerifyElementExistence(ForeignMarkets.wbelem_vs1Dollar_European,"Currency Vs 1 Dollar");
        fnVerifyElementExistence(ForeignMarkets.wbelemCurrencies_CurrencyConverter,"Currency conversion value");
        // add logic to verify xyz = 1 USD
        fnVerifyElementExistence(ForeignMarkets.wbimgCurrencies_ChartImage,"Chart image");
        fnVerifyDropdownOptions(ForeignMarkets.wblstEuropeanCurrencies_List,PropertyReader.getFieldValue("EuropeCurrencies","DataFile.properties"));
        
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	
	@Test(priority =11 , enabled = true)
	public void TC_VerificationOfVariousMarketsIn_Americas_Under_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfVariousMarketsIn_Americas_Under_ForeignMarkets", "This Method will verify the existence of several compoenents on Americas page");
		parent.appendChild(test1);
		ForeignMarkets.wblnkAmericas.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Americas);
		fnVerifyElementExistence(ForeignMarkets.wbelemSummary, "Summary of Americas In Brief");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkCanada_TSX ,"Canada TSX");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkBrazil_Bovespa ,"Brazil Bovespa");
		fnVerifyElementExistence(ForeignMarkets.wbelemQuotesDelayedBy_Americas,"Quotes delayed by message");
		
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentValue_Canada, "Current value :" +ForeignMarkets.wbelemCurrentValue_Canada.getText() );
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentPerformance_Canada, "Current Performance :" +ForeignMarkets.wbelemCurrentPerformance_Canada.getText() );
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrentMonthChange_Canada, "Monthly Performance :" +ForeignMarkets.wbelemCurrentMonthChange_Canada.getText() );
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Day_Canada,"1 Day") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Week_Canada,"1 Week") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Month_Canada,"1 Month") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk3Month_Canada,"3 Months") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk6Month_Canada,"6 Months") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnk1Year_Canada,"1 Year") ;
		fnVerifyElementExistence(ForeignMarkets.wblstCompareTo_Canada, "Compare to List -");
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	
	@Test(priority =12 , enabled = true)
	public void TC_VerificationOf_WaysToInvestInAmericas_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_WaysToInvestInAmericas_ForeignMarkets", "This Method will verify the components under ways to invest in the Americas page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMerrillEdgeSelectETFs,"Merrill Edge Select™ ETFs") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMerrillEdgeSelectFunds,"Merrill Edge Select™ Funds") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvest_MutualFunds,"Mutual funds") ;
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemWaysToInvest_ETFs,"ETFs") ;
		ForeignMarkets.wblnkWaysToInvest_MutualFunds_Fund.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemScreenForMutualFund);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemScreenForMutualFund,"Screen for mutual funds") ;
		ForeignMarkets.fnNavigateBack(); 
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		ForeignMarkets.wblnkAmericas.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Americas);
		ForeignMarkets.wblnkWaysToInvest_ETFs_Fund.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemETF_Screener);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemETF_Screener,"Screen for ETFs") ;
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		ForeignMarkets.wblnkAmericas.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Americas);
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	@Test(priority =13 , enabled = true)
	public void TC_VerificationOf_LatestReportsInAmericas_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_LatestReportsInAmericas_ForeignMarkets", "This Method will verify the components under Reports in the Americas page");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemReportsFromBofAMLText,"Latest American reports from BofAML Global Research") ;
		fnVerifyElementExistence(ForeignMarkets.wblnkReportsFromBofAML_ReportLink, "News headline under Latest Reports");
		fnVerifyElementExistence(ForeignMarkets.wbelemReportsFromBofAML_ReportTimestamp, "Time stamp information for Latest reports");
		fnVerifyElementExistence(ForeignMarkets.wbelemReportsFromBofAML_ReportTeaser, "Teaser section for Latest reports");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkReportsFromBofAML_MoreReports,"More research reports") ;
		extReport.enterLog("Info","Clicking on more link");
		ForeignMarkets.wblnkReportsFromBofAML_MoreReports.click();
		mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemOverviewTab);
		fnVerifyElementExistence(mlPP.wbelemOverviewTab,"Overview tab");
		fnVerifyElementExistence(mlPP.wbelemResearchAndinsightText,"Research & Insight text");
		ForeignMarkets.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_AsiaPacific);
		ForeignMarkets.wblnkAmericas.click();
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemQuotesDelayedBy_Americas);
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	
	@Test(priority =14 , enabled = true)
	public void TC_VerificationOf_RecentNewsInAmericas_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_RecentNewsInAmericas_ForeignMarkets", "This Method will verify the components under recent news in Americas page");
		
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemLatestNews,"Latest American news");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemShowOnly,"Show only");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemMyholdingsText,"My holdings");
		fnVerifyElementExistence(ForeignMarkets.wbchkboxMyholdingsCheckbox,"My Holdings checkbox");		
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemMyWatchlistText,"My watchlist");
		fnVerifyElementExistence(ForeignMarkets.wbchkboxMyWatchlistCheckbox,"My watchlist checkbox");
		fnVerifyElementExistence(ForeignMarkets.wblnkNewsHeadlineOnRecentNews,"First news heading");
		fnVerifyElementExistence(ForeignMarkets.wbelemCompanyNameForNews,"Company name for First news heading");
		fnVerifyElementExistence(ForeignMarkets.wbelemTeaserForFirstNews,"Teaser for first news");
		fnVerifyElementExistence(ForeignMarkets.wbelemTimeStampInformationForNews,"TimeStamp Information for first news");
		fnVerifyElementExistence(ForeignMarkets.wblnkReadMoreOnRecentNews,"Read more link");
		fnVerifyElementExistenceWithText(ForeignMarkets.wblnkMoreForeignMarketNews,"More foreign markets news");
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemCompaniesInTheNews,"Companies in the news");
		fnVerifyElementExistence(ForeignMarkets.wbelemCompaniesinNews_AsOf,"TimeStamp of Companies in the news");
		extReport.endTest(test1);
		softAssert.assertAll();
	}
		
	@Test(priority =15 , enabled = true)
	public void TC_VerificationOf_CurrenciesInAmericas_ForeignMarkets() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_CurrenciesInAmericas_ForeignMarkets", "This Method will verify the components under currencies in Americas page");
		parent.appendChild(test1);
		mlPP.fnWaitTillElementVisible(driver, 40, ForeignMarkets.wbelemAmericasCurrencies);
		fnVerifyElementExistenceWithText(ForeignMarkets.wbelemAmericasCurrencies,"North and South American currencies");
		fnVerifyElementExistence(ForeignMarkets.wblstAmericasCurrencies_List,"List of currencies");
		fnVerifyElementExistence(ForeignMarkets.wbelem_vs1Dollar_Americas,"Currency Vs 1 Dollar");
		fnVerifyElementExistence(ForeignMarkets.wbelemCurrencies_CurrencyConverter,"Currency conversion value");
		// add logic to verify xyz = 1 USD
		fnVerifyElementExistence(ForeignMarkets.wbimgCurrencies_ChartImage,"Chart image");
		// verifying values in the list.
		fnVerifyDropdownOptions(ForeignMarkets.wblstAmericasCurrencies_List,PropertyReader.getFieldValue("AmericasCurrencies","DataFile.properties"));
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	@AfterClass

	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
		
	}
	
	
}
