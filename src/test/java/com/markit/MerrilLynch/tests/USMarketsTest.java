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
import com.markit.MerrilLynch.pages.ForeignMarkets;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.markit.MerrilLynch.pages.USMarkets;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.markit.DigitalAutomationFramework.common.ExtentReporting;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;

/*
*
* @author: Sunny Jain	
* @purpose: This class contains all the regression scenarios of US market module.
* @creation date: 24/6/2016
*
*/
public class USMarketsTest extends MerrilLynchProductTest{
	
   
	PropertyReader prop;
	GlobalDriver gDriver;
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
		mlPP.fnWaitTillElementEnable(driver, 40, mlPP.wblnkResearch);
		US = new USMarkets(driver);
		parent = extent.startTest("US market");
	}
	
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	@Test(priority =0)
	public void TC_VerificationOfPageComponentsOnUsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfPageComponentsOnUsMarkets", "This Method will verify the existence of several components on page"); 
	parent.appendChild(test);

	
	mlPP.wblnkResearch.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	fnVerifyElementExistenceWithText(US.wbelemWhatsHappeningInUSMarkets,"What's happening in U.S. Markets");
	fnVerifyElementExistenceWithText(US.wbelemRecentNews,"Recent news");
	fnVerifyElementExistenceWithText(US.wbelemEconomicEvents,"Economic events");
	fnVerifyElementExistenceWithText(US.wbelemCompanyAnnouncements,"Company announcements");
	fnVerifyElementExistenceWithText(US.wbelemLatestReports,"Latest reports from BofAML Global Research");
	fnVerifyElementExistenceWithText(US.wbelemInvestmentProductAndMore,"Investment products and more");
	fnVerifyElementExistenceWithText(US.wbelemWhatsMovingTheMarkets,"What's moving the markets");	
	fnVerifyElementExistenceWithText(US.wbelemSectorPerformanceAndRecentRatingChanges,"Sector performance and recent ratings changes");
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	@Test(priority =1,enabled = true)
	public void TC_VerificationOfRecentNewsSectionOnUsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfRecentNewsSectionOnUsMarkets", "This Method will verify the existence of several elements under 'Recent news' section on  the page"); 
	parent.appendChild(test);	
	fnVerifyElementExistence(US.wbelemShowOnly,"Show Only text");
	fnVerifyElementExistence(US.wbchkboxMyHoldings,"My Holdings checkbox");
	fnVerifyElementExistence(US.wbchkboxMyWatchlist,"My watchlist checkbox");
	fnVerifyElementExistence(US.wbelemMyHoldings,"My Holdings text");
	fnVerifyElementExistence(US.wbelemMyWatchlist,"My watchlist text");
	fnVerifyElementExistence(US.wblnkNewsHeadlineOnRecentNews,"First news heading");
	fnVerifyElementExistence(US.wbelemCompanyNameForNews,"Company Name for First news");
	fnVerifyElementExistence(US.wbelemTeaserForFirstNews,"Teaser for first news");
	fnVerifyElementExistence(US.wbelemTimeStampInformationForNews,"TimeStamp Information for first news");
	fnVerifyElementExistence(US.wblnkReadMoreOnRecentNews,"Read More link");
	fnVerifyElementExistenceWithText(US.wblnkMoreUsMarketsNews,"More U.S. markets news");	
	fnVerifyElementExistenceWithText(US.wbelemCompaniesInTheNews,"Companies in the news");
	
	extReport.enterLog("Info","Clicking on the Read more link");
	US.wblnkReadMoreOnRecentNews.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wblnkReturnToUSMarket);
	fnVerifyElementExistence(US.wblnkReturnToUSMarket,"Return to US markets link");
	US.wblnkReturnToUSMarket.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.endTest(test);softAssert.assertAll();
	
	
	}	

	
	@Test(priority =2,enabled = true)
	public void TC_VerificationOfWhatsHappeningInUsMarketsSection_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfWhatsHappeningInUsMarketsSection", "This Method will verify the existence of several elements under 'Whats's happening in U.S.Markets' section on  the page"); 
	parent.appendChild(test);
	mlPP.wblnkResearch.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.enterLog("Info","Clicking on the DJIA symbol");
	US.wblblDJIASymbol.click();
	US.wblblDJIASymbol.click();
	fnVerifyElementExistenceWithText(US.wbelemSecurityProfileSymbolText,"DOW JONES INDUSTRIAL AVERAGE");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	extReport.enterLog("Info","Clicking on the COMP symbol");
	US.wblblCOMPSymbol.click();
	US.wblblCOMPSymbol.click();
	fnVerifyElementExistenceWithText(US.wbelemSecurityProfileSymbolText,"NASDAQ COMPOSITE");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	extReport.enterLog("Info","Clicking on the SPX symbol");
	US.wblblSPXSymbol.click();
	US.wblblSPXSymbol.click();
	fnVerifyElementExistenceWithText(US.wbelemSecurityProfileSymbolText,"S&P 500 INDEX");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	fnVerifyElementExistence(US.wbelemMarketUpdate,"Market Update text");
	fnVerifyElementExistence(US.wblnkNewsLinkForMarketUpdate,"News link for market Update");
	fnVerifyElementExistence(US.wbelemCompanyNameForMarketUpdate,"Company Name for News on Market Update section");
	fnVerifyElementExistence(US.wbelemTimeStampInformationForNewsUnderMarketUpdate,"Time stamp information for News on Market Update section");
	fnVerifyElementExistence(US.wbelemTeaserForMarketUpdate,"Teaser information for News on Market Update section");
	fnVerifyElementExistence(US.wbelemDowJonesForMarketUpdate,"Dow Jones performance index");
	fnVerifyElementExistence(US.wbelemNASDAQCompForMarketUpdate,"NASDAQ performance index");
	fnVerifyElementExistence(US.wbelemSP500ForMarketUpdate,"S&P 500 performance index");
	fnVerifyElementExistence(US.wbelemTodaysGainerOrLoserUnderMarketUpdate,"Toady's Gaineror loser section");	
	fnVerifyElementExistence(US.wbelemMarketActionUnderMarketUpdate,"Market Action");
	fnVerifyElementExistence(US.wbelemTimeStampInformationForMarketUpdate,"Time Stamp information section for Whats happening in US markets");
	
	try{
	
	extReport.enterLog("Info","Mouse hovering over DJIA symbol");
	US.actMouseOver(US.wblblDJIASymbol,US.wbelemSymbolHovertext);
	mlPP.fnWaitTillElementVisible(driver, 20, US.wbelemSymbolHovertext);
	fnVerifyElementExistenceWithText(US.wbelemSymbolHovertext,".DJIA");
	
	extReport.enterLog("Info","Mouse hovering over COMP symbol");
	US.actMouseOver(US.wblblCOMPSymbol,US.wbelemSymbolHovertext);
	mlPP.fnWaitTillElementVisible(driver, 20, US.wbelemSymbolHovertext);
	fnVerifyElementExistenceWithText(US.wbelemSymbolHovertext,"COMP");
	
	extReport.enterLog("Info","Mouse hovering over SPX symbol");
	US.actMouseOver(US.wblblSPXSymbol,US.wbelemSymbolHovertext);
	mlPP.fnWaitTillElementVisible(driver, 20, US.wbelemSymbolHovertext);
	fnVerifyElementExistenceWithText(US.wbelemSymbolHovertext,".SPX");
	}catch(Exception e){
	  extReport.enterLog("Fail",e.toString());
	}
	extReport.endTest(test);softAssert.assertAll();
	}	
	
	@Test(priority =3,enabled = true)
	public void TC_VerificationOfLatestReportsSection_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfLatestReportsSection", "This Method will verify the existence of several elements under 'Latest Reports' section on  the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistence(US.wblnkNewsHeadlineUnderLatestReports,"News headline under Latest Reports");
	fnVerifyElementExistence(US.wbelemTimeStampInformationForLatestReports,"Time stamp information for Latest reports");
	fnVerifyElementExistence(US.wbelemTeaserForLatestReports,"Teaser section for Latest reports");
	fnVerifyElementExistence(US.wblnlMoreResearchReports,"More Research Reports link");
	
	extReport.enterLog("Info","Clicking on the Read more link");
	US.wblnlMoreResearchReports.click();
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemOverviewTab);
	fnVerifyElementExistence(mlPP.wbelemOverviewTab,"Overview tab");
	fnVerifyElementExistence(mlPP.wbelemResearchAndinsightText,"Research & Insight text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	
	@Test(priority =4,enabled = true)
	public void TC_VerificationOfEconomicsEventsSection_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfEconomicsEventsSection", "This Method will verify the existence of several elements under 'Economics event' section on  the page"); 
	parent.appendChild(test);
	fnVerifyElementExistence(US.wblnkEventNameUnderEconomicEvents,"Event Name under Economics Event section");
	fnVerifyElementExistence(US.wbelemAnnouncedDate,"Announced Date under Economics Event section");
	fnVerifyElementExistence(US.wbimgChartUnderEconomicEvents,"Chart under Economics Event section");
	fnVerifyElementExistence(US.wbelemCalendarSymbol,"Calender under Economics Event section");
	fnVerifyElementExistence(US.wblnkSeeAllEconomicsEvents,"See all Economics Events");
	
	extReport.enterLog("Info","Clicking on the Econmic event link");
	
	US.wblnkEventNameUnderEconomicEvents.click();
	mlPP.fnWaitTillElementVisible(driver, 60, US.wbelemCloseEvent);
	
	fnVerifyElementExistenceWithText(US.wbelemEconomicEventHeader1Text,"Consensus estimate\nprior to the report");
	fnVerifyElementExistenceWithText(US.wbelemEconomicEventHeader2Text,"Actual number\nreported");
	fnVerifyElementExistenceWithText(US.wbelemEconomicEventHeader3Text,"Number from the\nprevious period");
	fnVerifyElementExistenceWithText(US.wbelemAnalysisHeader,"Analysis");
	fnVerifyElementExistence(US.wbelemDisclaimerText,"Disclaimer text");
	fnVerifyElementExistence(US.wbelemEventLogo,"Logo");
	fnVerifyElementExistence(US.wbelemCloseEvent,"Close button");
	
	US.wbelemCloseEvent.click();
	
	extReport.enterLog("Info","Clicking on the See all Economics Events link");
	US.wblnkSeeAllEconomicsEvents.click();
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemMajorEconomicIndicator);
	fnVerifyElementExistence(mlPP.wbelemMajorEconomicIndicator,"Major Economic Indicator text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);

	extReport.enterLog("Info","Clicking on the Calendar icon");
	US.wbelemCalendarSymbol.click();
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemMajorEconomicIndicator);
	fnVerifyElementExistence(mlPP.wbelemMajorEconomicIndicator,"Major Economic Indicator text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	// This section is dependent on QID .
	
	@Test(priority =5,enabled = false)
	public void TC_VerificationOfCompanyAnnouncementsSection_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfCompanyAnnouncementsSection", "This Method will verify the existence of several elements under 'Company announcements' section on  the page"); 
	parent.appendChild(test);

	
	fnVerifyElementExistence(US.wbelemCompanyEventCalendarTextUndeCompanyAnnouncements,"Company Event calendar text under Company announcements section");
	fnVerifyElementExistence(US.wbelemSmartTextForWeekEventsUnderCompanyAnnouncements,"Smart text for week events under Company announcements section");
	fnVerifyElementExistence(US.wbelemCalenderIconUndeCompanyAnnouncements,"Calendar icon under Company announcements section");
	fnVerifyElementExistence(US.wbelemEarningAnnouncementsUndeCompanyAnnouncements,"Earning Anoouncements under Company announcements section");
	fnVerifyElementExistence(US.wbelemDividendsUndeCompanyAnnouncements,"Dividends under Company announcements section");
	fnVerifyElementExistence(US.wbelemSplitsUndeCompanyAnnouncements,"Splits under Company announcements section");
	fnVerifyElementExistence(US.wblnkViewAllCompanies,"View all companies link");
	
	
	if(!US.wbelemEarningAnnouncementsCount.getText().equals("0")){
	extReport.enterLog("Info","Clicking on the earning announcements section");
	US.wbelemEarningAnnouncementsUndeCompanyAnnouncements.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemHeader1UnderEarningAnnouncements);
	fnVerifyElementExistence(US.wbelemHeader1UnderEarningAnnouncements,"Actual Q header");
	fnVerifyElementExistenceWithText(US.wbelemHeader2UnderEarningAnnouncements,"Estimate");
	fnVerifyElementExistenceWithText(US.wbelemHeader3UnderEarningAnnouncements,"Beat/Below Expectations");
	}
	
	if(!US.wbelemDividendsCount.getText().equals("0")){
	extReport.enterLog("Info","Clicking on the dividends section");
	US.wbelemDividendsUndeCompanyAnnouncements.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemHeader1UnderDividends);	
	fnVerifyElementExistenceWithText(US.wbelemHeader1UnderDividends,"Dividend Amt");
	fnVerifyElementExistenceWithText(US.wbelemHeader2UnderDividends,"Ex-date");
	fnVerifyElementExistenceWithText(US.wbelemHeader3UnderDividends,"Div Yield");
	}
	
	if(!US.wbelemSplitsCount.getText().equals("0")){
	extReport.enterLog("Info","Clicking on the splits section");
	US.wbelemSplitsUndeCompanyAnnouncements.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemHeader1UnderSplits);
	fnVerifyElementExistenceWithText(US.wbelemHeader1UnderSplits,"Ex-date");
	fnVerifyElementExistenceWithText(US.wbelemHeader2UnderSplits,"Ratio");	
	}
		
	extReport.enterLog("Info","Clicking on the View all companies link");
	US.wblnkViewAllCompanies.click();
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemSelectAWeek);
	fnVerifyElementExistence(mlPP.wbelemSelectAWeek,"Select a week text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	
	@Test(priority =6,enabled = true)
	public void TC_VerificationOfInvestmentProductsSection_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfInvestmentProductsSection", "This Method will verify the existence of several elements under 'Investment Products' section on the page"); 
	parent.appendChild(test);
	fnVerifyElementExistence(US.wblnkMerrillEdgeMarketProUnderInvestmentProducts,"Merrill Edge Market Pro tile under Investments product and more section");
	fnVerifyElementExistence(US.wblnkStreamingQuotesUnderInvestmentProducts,"Streaming Quotes tile under Investments product and more section");
	fnVerifyElementExistence(US.wblnkWatchlistsUnderInvestmentProducts,"Watchlists tile under Investments product and more section");
	fnVerifyElementExistence(US.wblnkCompareToolUnderInvestmentProducts,"Compare Tool tile under Investments product and more section");
	fnVerifyElementExistence(US.wblnkScreenInvestmentsUnderInvestmentProducts,"Screen investments tile under Investments product and more section");
	fnVerifyElementExistence(US.wblnkOptionsstrategyBuilderUnderInvestmentProducts,"Option Strategy builder tile under Investments product and more section");
	
	String winHandleBefore = driver.getWindowHandle();
	
	extReport.enterLog("Info","Clicking on the Streaming Quotes");
	US.wblnkStreamingQuotesUnderInvestmentProducts.click();
	mlPP.fnSwitchToNewlyOpenedWindow();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemImportantRiskdisclosures);
	fnVerifyElementExistence(US.wbelemImportantRiskdisclosures,"Important Risk disclosure");
	driver.close();
	driver.switchTo().window(winHandleBefore);
	
	extReport.enterLog("Info","Clicking on the Watchlists section");
	US.wblnkWatchlistsUnderInvestmentProducts.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wblnkCreateNewWatchlist);
	fnVerifyElementExistence(US.wblnkCreateNewWatchlist,"Create New Watchlist link");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.enterLog("Info","Clicking on the Compare tool section");
	US.wblnkCompareToolUnderInvestmentProducts.click();
	mlPP.SwitchToFrame(US.wbframeCompareTool);
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemCompareanInvestmentText);
	fnVerifyElementExistenceWithText(US.wbelemCompareanInvestmentText,"Compare an investment with other investments");	
	mlPP.SwitchToTopFrame();
	US.wblnkCloseCompareTool.click();
	
	extReport.enterLog("Info","Clicking on the Screen Investments section");
	US.wblnkScreenInvestmentsUnderInvestmentProducts.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemStockScreener);
	fnVerifyElementExistenceWithText(US.wbelemStockScreener,"Stock Screener");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.enterLog("Info","Clicking on the Option Strategy Builder section");
	US.wblnkOptionsstrategyBuilderUnderInvestmentProducts.click();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemOptionsStrategyBuilder);
	fnVerifyElementExistenceWithText(US.wbelemOptionsStrategyBuilder,"Options Strategy Builder");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
		
	extReport.endTest(test);softAssert.assertAll();

	}
	
	
	@Test(priority =7,enabled = true)
	public void TC_VerificationOfStocks_SectorPerformance_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfStocks_SectorPerformance", "This Method will verify the existence of several elements under 'Sector performance' section on  the page"); 
	parent.appendChild(test);
	fnVerifyElementExistenceWithText(US.wbelemSectorHeading,"Sector");
	fnVerifyElementExistenceWithText(US.wbelemTodaysChangeHeading,"Today's Change");
	fnVerifyElementExistenceWithText(US.wbelemSectorPerformanceHeading1,"Security");
	fnVerifyElementExistenceWithText(US.wbelemSectorPerformanceHeading2,"Rating Change");
	fnVerifyElementExistenceWithText(US.wbelemSectorPerformanceHeading3,"Change Date");
	fnVerifyElementExistenceWithText(US.wbelemSectorPerformanceHeading4,"Ratings Provider");	
	
	fnVerifyElementExistence(US.wblnkMoreSectorInformation,"More sector information link");
	fnVerifyElementExistence(US.wblnkBofAMLGlobalResearch,"BofAML Global Research link");
	fnVerifyElementExistence(US.wblnkMorningStar,"Morninhg Star link");
	fnVerifyElementExistence(US.wblnkSPCapitalIQ,"S&P Capital IQ link");
	
	// This will verify the sector categories on the sector performance section.
	
	String str = PropertyReader.getFieldValue("stock_Sector_Categories","DataFile.properties");
	String[] expectedText = str.split("@");
	
	List <String> actualText = US.fnGetSectorCategories(); // This will fetch all the sector categories
	
	boolean Flag = true;
   	for(int j =0;j < expectedText.length;j++){
   		
   	for (int k =0;k < actualText.size();k++){
		
	if(expectedText[j].equals(actualText.get(k))){
	extReport.enterLog("Pass",actualText.get(k)+ " has been verified successfully.");
	Flag = true;
	break;}
	else{
		Flag = false;}
	}
   	
	if (Flag = false) {
	extReport.enterLog("Fail",expectedText[j] + " does not exists.");	}	
   	}
   	
	extReport.enterLog("Info","Clicking on the More sector Information link");
	US.wblnkMoreSectorInformation.click();
	mlPP.fnWaitTillElementVisible(driver, 120, mlPP.wbelemWhatsHappeningInSectorIndustries); 
	fnVerifyElementExistence(mlPP.wbelemWhatsHappeningInSectorIndustries,"Whats Happening inSector Industries text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.enterLog("Info","Clicking on BofAML Global Research link");
	US.wblnkBofAMLGlobalResearch.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wbelemBofAMerrillLynchText);
	fnVerifyElementExistence(US.wbelemBofAMerrillLynchText,"BofA Merrill Lynch text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.enterLog("Info","Clicking on Morning Star link");
	US.wblnkMorningStar.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wbelemMorningStarRatingText);
	fnVerifyElementExistence(US.wbelemMorningStarRatingText,"Morning Star Rating text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	extReport.enterLog("Info","Clicking on S&P Capital IQ link");
	US.wblnkSPCapitalIQ.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wbelemSPCapitalIQRatingText);
	fnVerifyElementExistence(US.wbelemSPCapitalIQRatingText," S&P Capital IQ Rating text");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
   	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	@Test(priority =8,enabled = true)
	public void TC_VerificationOfStocks_WhatsMovingTheMarkets_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfStocks_WhatsMovingTheMarkets", "This Method will verify the stocks section under 'Whats Moving The Markets' module on the page"); 
	parent.appendChild(test);
	
	fnVerifyElementExistence(US.wblnkNewsLinkUnderStock,"First news link for Stocks under Whats'moving markets section");
	fnVerifyElementExistence(US.wbelemNewsSourceUnderStock,"Source information for first news for Stocks under Whats'moving markets section");
	fnVerifyElementExistence(US.wbelemNewsTeaserUnderStock,"Teaser information for first news for Stocks under Whats'moving markets section");
	fnVerifyElementExistence(US.wblnkReadmoreUnderStock,"Read more link for first news for Stocks under Whats'moving markets section");
	
	extReport.enterLog("Info","Clicking on the First news link for Stocks under Whats'moving markets section");
	US.wblnkNewsLinkUnderStock.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wblnkReturnToNews); 
	fnVerifyElementExistence(US.wblnkReturnToNews,"Return to News link");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	
	if (US.fnCheckElementExistence(US.wblnkReadmoreUnderStock)){
	extReport.enterLog("Info","Clicking on the Read more link under stocks");
	US.wblnkReadmoreUnderStock.click();
	mlPP.fnWaitTillElementVisible(driver, 60, US.wblnkReturnToNews);
	fnVerifyElementExistence(US.wblnkReturnToNews,"Return to News link");
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	}
	
  	fnVerifyElementExistence(US.wblnkDollarChange,"$ Change link");
   	fnVerifyElementExistence(US.wblnkPercentageChange,"% Chnage link");
   	
	fnVerifyElementExistence(US.wbelemShowOnlyTextUnderStocks,"Show Only text");
	fnVerifyElementExistence(US.wbchkMyHoldingsCheckboxUnderStocks,"My Holdings checkbox");
	fnVerifyElementExistence(US.wbchkMywatchlistCheckboxUnderStocks,"My watchlist checkbox");
	fnVerifyElementExistence(US.wbelemMyHoldingsTextUnderStocks,"My Holdings text");
	fnVerifyElementExistence(US.wbelemMyWatchlistsTextUnderStocks,"My watchlist text");
   	
	fnVerifyHeadersOfwebtable(US.wbtblPMostActivesTable,1,PropertyReader.getFieldValue("s&PMostActivesTableHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblPMostGainersTable,1,PropertyReader.getFieldValue("s&PGainersTableHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblPMostLosersTable,1,PropertyReader.getFieldValue("s&PLosersTableHeadings","DataFile.properties"));
	
	if (US.fnCheckElementExistence(US.wblnkMoreMostActives)){
	extReport.enterLog("Info","Clicking on the more most actives link");
	US.wblnkMoreMostActives.click();
	mlPP.fnWaitTillElementVisible(driver, 60, US.wbelemSPActiveGainerLoserText);
	fnVerifyElementExistenceWithText(US.wbelemStockScreener,"Stock Screener");	
	fnVerifyElementExistenceWithText(US.wbelemSPActiveGainerLoserText,"S&P 500 Most Actives");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	}
	
	if (US.fnCheckElementExistence(US.wblnkMoreGainers)){
	extReport.enterLog("Info","Clicking on the more gainers link");
	US.wblnkMoreGainers.click();
	mlPP.fnWaitTillElementVisible(driver, 60, US.wbelemSPActiveGainerLoserText);
	fnVerifyElementExistenceWithText(US.wbelemStockScreener,"Stock Screener");	
	fnVerifyElementExistenceWithText(US.wbelemSPActiveGainerLoserText,"S&P 500 Gainers");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	}
	
	if (US.fnCheckElementExistence(US.wblnkMoreLosers)){
	extReport.enterLog("Info","Clicking on the more losers link");
	US.wblnkMoreLosers.click();
	mlPP.fnWaitTillElementVisible(driver, 60, US.wbelemSPActiveGainerLoserText);
	fnVerifyElementExistenceWithText(US.wbelemStockScreener,"Stock Screener");	
	fnVerifyElementExistenceWithText(US.wbelemSPActiveGainerLoserText,"S&P 500 Losers");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	}
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	@Test(priority =9,enabled = true)
	public void TC_VerificationOfOptions_WhatsMovingTheMarkets_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfOptions_WhatsMovingTheMarkets", "This Method will verify the options section under 'Whats Moving The Markets' module on the page"); 
	parent.appendChild(test);
	mlPP.fnWaitTillElementVisible(driver, 120, US.wblnkOptionsTab);
	US.wblnkOptionsTab.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wbimgCBOEChartUnderOptions);
	Thread.sleep(5000);
	fnVerifyElementExistenceWithText(US.wbelemAnalysisTextUnderOptions,"Analysis");
	fnVerifyElementExistenceWithText(US.wbelemCBOETextUnderOptions,"CBOE 5-day average put/call ratio");
	fnVerifyElementExistenceWithText(US.wbelemChangesInOptionVolumeTextUnderOptions,"Changes in options volume");
	fnVerifyElementExistenceWithText(US.wbelemChangesInOptionOpenInterestTextUnderOptions,"Changes in options open interest");
	fnVerifyElementExistenceWithText(US.wbelemSentimentTextUnderOptions,"Sentiment");
	fnVerifyElementExistenceWithText(US.wbelem5DayTrendTextUnderOptions,"5-day trend");
	fnVerifyElementExistence(US.wbelemSmartTextUnderOptions,"Smart Text under Options");
	fnVerifyElementExistence(US.wbimgCBOEChartUnderOptions,"CBOE chart under Options");
	fnVerifyHeadersOfwebtable(US.wbtblChangesInOptionsVolumeTable,1,PropertyReader.getFieldValue("ChangesInOptionaVolumeTableHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblChangesInOptionsOpenIntertestTable,1,PropertyReader.getFieldValue("ChangesInOptionsOpenInterestTableHeadings","DataFile.properties"));
	
	try{
	if(US.fnCheckElementExistence(US.wbelemSymbolInTableUnderOptions)){
	extReport.enterLog("Info","Mouse hovering over First symbol");
	US.actMouseOver(US.wbelemSymbolInTableUnderOptions,US.wbelemSymbolHoverOverTextInTableUnderOptions);
	Thread.sleep(5000);
	if(US.wbelemSymbolHoverOverTextInTableUnderOptions.getText().contains(US.wbelemSymbolInTableUnderOptions.getText())){
		extReport.enterLog("Pass","Mouse Hover text has been verified successfully");
	}else{
		extReport.enterLog("Fail","Mouse Hover text is not expected");
	}
	}}catch(Exception e){
	    extReport.enterLog("Fail","Mouse Hover functionality failed!");
	}

	extReport.endTest(test);softAssert.assertAll();
		
	}
	
	@Test(priority =10,enabled = true)
	public void TC_VerificationOfETFs_WhatsMovingTheMarkets_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfETFs_WhatsMovingTheMarkets", "This Method will verify the ETFs section under 'Whats Moving The Markets' module on the page"); 
	parent.appendChild(test);
	mlPP.fnWaitTillElementVisible(driver, 120, US.wblnkETFTab);
	US.wblnkETFTab.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wbelemETFCategoryTextUnderETFs);
	
	fnVerifyElementExistenceWithText(US.wbelemETFCategoryTextUnderETFs,"ETF category performance");
	fnVerifyElementExistence(US.wbelemTimeStampUnderETFs,"Time stamp information under ETF");
	fnVerifyElementExistence(US.wbelemPerformanceHeapMapUnderETFs,"Performance Heap Map");
	fnVerifyElementExistence(US.wblnk1DayLinkUnderETFs,"1 Day link under ETF");
	fnVerifyElementExistence(US.wblnk1MonthLinkUnderETFs,"1 Month link under ETF");
	fnVerifyElementExistence(US.wblnk3MonthsLinkUnderETFs,"3 Months link under ETF");
	fnVerifyElementExistence(US.wblnk6MonthsLinkUnderETFs,"6 Months link under ETF");
	fnVerifyElementExistence(US.wblnk1YearLinkUnderETFs,"1 Year link under ETF");
	fnVerifyElementExistence(US.wblnk3YearsLinkUnderETFs,"3 Yearslink under ETF");
	fnVerifyElementExistence(US.wblnk5YearsLinkUnderETFs,"5 Years link under ETF");
	fnVerifyElementExistence(US.wblnk10YearsLinkUnderETFs,"10 Years link under ETF");
	fnVerifyElementExistence(US.wbelemPerformanceOfAltETFsTextUnderETFs,US.wbelemPerformanceOfAltETFsTextUnderETFs.getText());
	fnVerifyElementExistenceWithText(US.wbelemGainersTextUnderETFsPerformance,"Gainers");
	fnVerifyElementExistenceWithText(US.wbelemLosersTextUnderETFsPerformance,"Losers");
	fnVerifyHeadersOfwebtable(US.wbtblGainersTableUndeETF,1,PropertyReader.getFieldValue("GainersTableUndeETFHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblLosersTableUndeETF,1,PropertyReader.getFieldValue("LosersTableUndeETFHeadings","DataFile.properties"));
	fnVerifyElementExistenceWithText(US.wbelemTradingVolumeTextUnderETFs,"Trading volume of U.S. ETFs");
	fnVerifyElementExistenceWithText(US.wbelemMostActivelyTradedTextUnderTradingVolumeofETFs,"Most actively traded");
	fnVerifyElementExistenceWithText(US.wbelemUnusuallyHighVolumeTextUnderTradingVolumeofETFs,"Unusually high volume");
	fnVerifyHeadersOfwebtable(US.wbtblMostActivelyTradedTableUndeETF,1,PropertyReader.getFieldValue("MostActivelyTradedTableUndeETFHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblUnUsuallyHighVolumeTableUndeETF,1,PropertyReader.getFieldValue("UnUsuallyHighVolumeTableUndeETFHeadings","DataFile.properties"));
	
	extReport.endTest(test);softAssert.assertAll();
		}
	
	
	@Test(priority =11,enabled = true)
	public void TC_VerificationOfMutualFunds_WhatsMovingTheMarkets_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfMutualFunds_WhatsMovingTheMarkets", "This Method will verify the Mutual funds section under 'Whats Moving The Markets' module on the page"); 
	parent.appendChild(test);
	mlPP.fnWaitTillElementVisible(driver, 120, US.wblnkMutualFundsTab);
	US.wblnkMutualFundsTab.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wbelemMutualFundsCategoryTextUnderMutualFunds);
	
	fnVerifyElementExistenceWithText(US.wbelemMutualFundsCategoryTextUnderMutualFunds,"Mutual fund performance");
	fnVerifyElementExistence(US.wbelemTimeStampUnderMutualFundss,"Time stamp information under Mutual funds");
	fnVerifyElementExistence(US.wbelemPerformanceHeapMapUnderMutualFunds,"Performance Heap Map under Mutual funds");
	fnVerifyElementExistence(US.wblnk1DayLinkUnderMutualFunds,"1 Day link under MutualFund");
	fnVerifyElementExistence(US.wblnk3MonthsLinkUnderMutualFunds,"3 Months link under MutualFund");
	fnVerifyElementExistence(US.wblnk6MonthsLinkUnderMutualFunds,"6 Months link under MutualFund");
	fnVerifyElementExistence(US.wblnk1YearLinkUnderMutualFunds,"1 Year link under MutualFund");
	fnVerifyElementExistence(US.wblnk3YearsLinkUnderMutualFunds,"3 Years link under MutualFund");
	fnVerifyElementExistence(US.wblnk5YearsLinkUnderMutualFunds,"5 Years link under MutualFund");
	fnVerifyElementExistence(US.wblnk10YearsLinkUnderMutualFunds,"10 Years link under MutualFund");	
	fnVerifyElementExistence(US.wbelemMunicipalBondCategoryTextUnderMutualFund,US.wbelemMunicipalBondCategoryTextUnderMutualFund.getText());
	fnVerifyElementExistence(US.wbelemHighPerformingTextUnderMutualFund,US.wbelemHighPerformingTextUnderMutualFund.getText());
	
	fnVerifyElementExistence(US.wbelemTable1HeaderUnderMutualFund,US.wbelemTable1HeaderUnderMutualFund.getText());
	
	//fnVerifyHeadersOfwebtable(US.wbtblMunicipalBondCategoryTableUnderMutualFund,1,PropertyReader.getFieldValue("MunicipalBondCategoryTableUnderMutualFundHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblHighPerformingTableUnderMutualFund,1,PropertyReader.getFieldValue("HighPerformingTableUnderMutualFundHeadings","DataFile.properties"));
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	
	@Test(priority =12,enabled = true)
	public void TC_VerificationOfFixedIncome_WhatsMovingTheMarkets_UsMarkets() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfFixedIncome_WhatsMovingTheMarkets", "This Method will verify the Fixed Income section under 'Whats Moving The Markets' module on the page"); 
	parent.appendChild(test);
	mlPP.fnWaitTillElementVisible(driver, 120, US.wblnkFixedIncomeTab);
	US.wblnkFixedIncomeTab.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wbelemAnalysisTextUnderMutualFunds);
	
	fnVerifyElementExistenceWithText(US.wbelemAnalysisTextUnderMutualFunds,"Analysis");
	fnVerifyElementExistenceWithText(US.wbelemSentimentTextUnderMutualFunds,"Sentiment");
	fnVerifyElementExistenceWithText(US.wbelem1MonthTrendTextUnderMutualFunds,"1-month trend");
	fnVerifyElementExistence(US.wbelemSmartTextUnderFixedIncome,"Smart Text under under Fixed-Income");
	fnVerifyElementExistence(US.wbimgChartUnderFixedIncome,"Chart under Fixed-Income");
	fnVerifyElementExistenceWithText(US.wbelemCalendarEventsTextUnderMutualFunds,"Calendar events");
	fnVerifyElementExistenceWithText(US.wbelemMerrillEdgeSelectTextUnderMutualFunds,"Merrill Edge SelectTM fund investing ideas");
	fnVerifyElementExistenceWithText(US.wbelemEtfsTextUnderMutualFunds,"ETFs");
	fnVerifyElementExistenceWithText(US.wbelemMutualFundsTextUnderMutualFunds,"Mutual funds");
	fnVerifyHeadersOfwebtable(US.wbtblCalendarEventsTableUnderFixedIncome,1,PropertyReader.getFieldValue("CalendarEventsTableUnderFixedIncomeHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblEtfsTableUnderFixedIncome,1,PropertyReader.getFieldValue("EtfsTableUnderFixedIncomeHeadings","DataFile.properties"));
	fnVerifyHeadersOfwebtable(US.wbtblMutualFundsTableUnderFixedIncome,1,PropertyReader.getFieldValue("MutualFundsTableUnderFixedIncomeHeadings","DataFile.properties"));
	
	if (US.fnCheckElementExistence(US.wblnkMoreMerrillEdgeETFSUnderFixedIncome)){
	extReport.enterLog("Info","Clicking on the More Merrill Edge ETFs link under Fixed Income");
	US.wblnkMoreMerrillEdgeETFSUnderFixedIncome.click();
	mlPP.fnWaitTillElementVisible(driver, 60, US.wbelemScreenForETFText);
	fnVerifyElementExistenceWithText(US.wbelemETFScreener,"ETF Screener");	
	fnVerifyElementExistenceWithText(US.wbelemScreenForETFText,"Screen for ETFs");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	}
	
	mlPP.fnWaitTillElementVisible(driver, 120, US.wblnkFixedIncomeTab);
	US.wblnkFixedIncomeTab.click();
	mlPP.fnWaitTillElementVisible(driver, 120, US.wblnkMoreMerrillEdgeFundsUnderFixedIncome);
	
	if (US.fnCheckElementExistence(US.wblnkMoreMerrillEdgeFundsUnderFixedIncome)){
	extReport.enterLog("Info","Clicking on the More Merrill Edge Funds link under Fixed Income");
	US.fnWaitTillElementEnable(driver, 120,US.wblnkMoreMerrillEdgeFundsUnderFixedIncome);
	US.wblnkMoreMerrillEdgeFundsUnderFixedIncome.click();
	mlPP.fnWaitTillElementVisible(driver, 60, US.wbelemScreenForMutualFundsText);
	fnVerifyElementExistenceWithText(US.wbelemMutualFundsScreener,"Mutual Funds Screener");	
	fnVerifyElementExistenceWithText(US.wbelemScreenForMutualFundsText,"Screen for mutual funds");	
	US.fnNavigateBack();
	mlPP.fnWaitTillElementVisible(driver, 40, US.wbelemWhatsHappeningInUSMarkets);
	}
	
	extReport.endTest(test);softAssert.assertAll();

	}
	
	@AfterClass
	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
	}

}
