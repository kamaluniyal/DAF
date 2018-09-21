
package com.markit.MerrilLynch.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import com.markit.MerrilLynch.pages.Commodities;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;

/*
*
* @author: Kamal Uniyal
* @purpose: This class contains all the regression scenarios of Commodities test cases
* @creation date: 11/7/2016
*
*/

public class CommoditiesTest extends MerrilLynchProductTest{
	

	PropertyReader prop;
	GlobalDriver gDriver;
	Commodities Commodities;
	MerrillLynchProductPage mlPP;
	String loggedUser;
	SendMail mailObj;
	ExtentTest parent;
	
	@DataProvider(name = "sector")
	public static Object[][] sectorsTest() 
	{
		Object[][] obj= {{"Energy"},{"Metals"},{"Agriculture"}};
		return obj;
	}
	
	
	@BeforeClass
	@Parameters({ "browser", "version", "Sel_Grid", "environment" })
	public void initialSetup(@Optional String browser, @Optional String version, @Optional String Sel_Grid,
			@Optional String environment) throws Exception {
				
		mlPP = setupEnvironment(browser, version, Sel_Grid, environment);
		mlPP.sendObject(extReport ,softAssert);
		mlPP.fnWaitTillElementEnable(driver, 40, mlPP.wbframe1);				
		mlPP.fnLogin(userId,password);
		mlPP.fnWaitTillElementEnable(driver, 40, mlPP.wblnkResearch);
		Commodities = new Commodities(driver);
		parent = extent.startTest("Commodities");
	}
	
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}

	@Test(priority =0 , enabled = true)
	public void TC_VerificationOfPageComponentsOnCommodities() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfPageComponentsOnCommodities", "This Method will verify the existence of several compoenents on Commodities page");
		parent.appendChild(test1);
		mlPP.wblnkResearch.click();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wblnkCommoditiesTab);
		Commodities.wblnkCommoditiesTab.click();
		fnVerifyElementExistenceWithText(Commodities.wbelemWhatsHappeningInCommodities,"What's happening in commodities");
		fnVerifyElementExistenceWithText(Commodities.wbelemCommodityNews,"Commodity news");
		fnVerifyElementExistenceWithText(Commodities.wbelemCrudeOilText,"Crude oil (WTI)");
		fnVerifyElementExistenceWithText(Commodities.wbelemGoldText,"Gold");
		fnVerifyElementExistenceWithText(Commodities.wbelemCornText,"Corn");
		fnVerifyElementExistenceWithText(Commodities.wbelemWaysToInvest,"Ways to invest in energy");
		fnVerifyElementExistenceWithText(Commodities.wbelemCommodityEvents,"Commodity events");
		fnVerifyElementExistenceWithText(Commodities.wbelemLatestNews,"Latest energy news");
		extReport.endTest(test1);
		softAssert.assertAll();
		
	}
	
	
	@Test(priority =1 , enabled = true)
	public void TC_VerificationOfWhatsHappeningInCommodities() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfWhatsHappeningInCommodities", "This Method will verify the existence of several compoenents under What's happening in commodities on Commodities page");
		parent.appendChild(test1);
		fnVerifyElementExistence(Commodities.wblnkCommoditiesNewsHeadline,"Commodity News Headline link - " + Commodities.wblnkCommoditiesNewsHeadline.getText());
		fnVerifyElementExistence(Commodities.wbelemCommoditiesNewsSource,"Commodity News Source - " + Commodities.wbelemCommoditiesNewsSource.getText());
		fnVerifyElementExistence(Commodities.wbelemCommoditiesNewsTimeStamp,"Commodity News Timestamp Information - " + Commodities.wbelemCommoditiesNewsTimeStamp.getText());
		fnVerifyElementExistence(Commodities.wbelemCrudeOilCurrentPrice,"Crude Oil Current Price - " + Commodities.wbelemCrudeOilCurrentPrice.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemCrudeOilPriceIn,"USD/bbl.");
		fnVerifyElementExistenceWithText(Commodities.wbelemCrudeOilTodaysPerformanceText,"Today's performance");
		
		
		
		if(driver.findElements(By.cssSelector("#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span")).size()==0)
		{
		                                     
			fnVerifyElementExistence(Commodities.wbelemCrudeOilTodaysPerformanceValue,"Crude oil Performance Value - " + Commodities.wbelemCrudeOilTodaysPerformanceValue.getText());
		}
		
		else
		{
			Commodities.wbelemCrudeOilTodaysPerformanceValue=driver.findElement(By.cssSelector("#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span"));
			fnVerifyElementExistence(Commodities.wbelemCrudeOilTodaysPerformanceValue,"Crude oil Performance Value - " + Commodities.wbelemCrudeOilTodaysPerformanceValue.getText());
		}
			
		
		
		
		fnVerifyElementExistenceWithText(Commodities.wbelemCrudeOilOneMonthTrendText,"1-Month trend");
		fnVerifyElementExistence(Commodities.wbelemCrudeOilOneMonthTrendValue,"Crude Oil One Month trend Value - " + Commodities.wbelemCrudeOilOneMonthTrendValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemCrudeOilThisMonthText,"this month");
		fnVerifyElementExistence(Commodities.wbelemGoldCurrentPrice,"Gold Current Price - " + Commodities.wbelemGoldCurrentPrice.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemGoldPriceIn,"USD/t oz.");
		fnVerifyElementExistenceWithText(Commodities.wbelemGoldTodaysPerformanceText,"Today's performance");
		
		
		
		if(driver.findElements(By.cssSelector("#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span")).size()==0)
		{
		                                     
			fnVerifyElementExistence(Commodities.wbelemGoldTodaysPerformanceValue,"Gold Performance Value - " + Commodities.wbelemGoldTodaysPerformanceValue.getText());
		}
		
		else
		{
			Commodities.wbelemGoldTodaysPerformanceValue=driver.findElement(By.cssSelector("#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span"));
			fnVerifyElementExistence(Commodities.wbelemGoldTodaysPerformanceValue,"Gold  Performance Value - " + Commodities.wbelemGoldTodaysPerformanceValue.getText());
		}
		
		
		
		
		fnVerifyElementExistenceWithText(Commodities.wbelemGoldOneMonthTrendText,"1-Month trend");
		fnVerifyElementExistence(Commodities.wbelemGoldOneMonthTrendValue,"Gold One Month trend Value - " + Commodities.wbelemGoldOneMonthTrendValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemGoldThisMonthText,"this month");
		fnVerifyElementExistence(Commodities.wbelemCornCurrentPrice,"Corn Current Price - " + Commodities.wbelemCornCurrentPrice.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemCornPriceIn,"USD/bu.");
		fnVerifyElementExistenceWithText(Commodities.wbelemCornTodaysPerformanceText,"Today's performance");
		
		
		if(driver.findElements(By.cssSelector("#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span")).size()==0)
		{
		                                     
			fnVerifyElementExistence(Commodities.wbelemCornTodaysPerformanceValue,"Corn Performance Value - " + Commodities.wbelemCornTodaysPerformanceValue.getText());
		}
		
		else
		{
			Commodities.wbelemCornTodaysPerformanceValue=driver.findElement(By.cssSelector("#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span"));
			fnVerifyElementExistence(Commodities.wbelemCornTodaysPerformanceValue,"Corn Performance Value - " + Commodities.wbelemCornTodaysPerformanceValue.getText());
		}
		
		
		
		
		
		
		fnVerifyElementExistenceWithText(Commodities.wbelemCornOneMonthTrendText,"1-Month trend");
		fnVerifyElementExistence(Commodities.wbelemCornOneMonthTrendValue,"Corn One Month trend Value - " + Commodities.wbelemCornOneMonthTrendValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemCornThisMonthText,"this month");
		fnVerifyElementExistence(Commodities.wbelemCommoditiesQuotesTimeStamp,"Commodity Quote Timestamp Information - " + Commodities.wbelemCommoditiesQuotesTimeStamp.getText());
		extReport.enterLog("info","Clicking on Commodity News link ");
		Commodities.wblnkNewsHeadlineOnLatestNews.click();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemCommoditiesNews_RelatedNews);
		fnVerifyElementExistenceWithText(Commodities.wbelemCommoditiesNews_RelatedNews,"Related news");
		fnVerifyElementExistence(Commodities.wbelemCommoditiesNews_FullNewsHeader,"Commodity News Full News Story - Header Text - " + Commodities.wbelemCommoditiesNews_FullNewsHeader.getText());
		Commodities.fnNavigateBack();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemCommodityNews);
		extReport.endTest(test1);
		softAssert.assertAll();
	}
	
	@Test(priority =2 , enabled = true)
	public void TC_VerificationOfEnergyPage_Commodities() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfEnergyPage", "This Method will verify the existence of several compoenents on Energy page");
		parent.appendChild(test1);
		fnVerifyElementExistence(Commodities.wbelemCommoditiesInBrief ,"Overview of Energy Sector");
		fnVerifyElementExistenceWithText(Commodities.wbelem_Commodities_energy_crudeoilgas_Text,"Crude oil & gas");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_crudeoilgas_CrudeOil,"Crude oil (WTI)");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_crudeoilgas_E_mini_CrudeOil,"E-mini crude oil");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_crudeoilgas_NaturalGas,"Natural gas");
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp ,"Crude Oil & gas Quotes information - " + Commodities.wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_energy_refinedproducts_Text,"Refined products");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_refinedproducts_RBOB_Gasoline,"RBOB gasoline");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_refinedproducts_RBOB_NY_Harbor_ULSD,"NY Harbor ULSD");
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_refinedproducts_QuotesTimeStamp,"Crude Oil & gas Quotes information - " + Commodities.wbelem_commodities_energy_refinedproducts_QuotesTimeStamp.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_CurrentValue ,"Current price of Crude Oil:"+Commodities.wbelem_commodities_energy_crudeoilgas_CurrentValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_energy_crudeoilgas_CurrentValueIn_USD,"USD/bbl.");
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_CurrentPerformance ,"Today's Performance value of the Crude Oil :"+Commodities.wbelem_commodities_energy_crudeoilgas_CurrentPerformance.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_MonthlyPerformance ,"1 Month Performance value of the Crude Oil :"+Commodities.wbelem_commodities_energy_crudeoilgas_MonthlyPerformance.getText());
		fnVerifyElementExistence(Commodities.wblst_commodities_energy_crudeoilgas_CompareList,"Compare to List");
		fnVerifyElementExistence(Commodities.wbimg_commodities_energy_crudeoilgas_Image,"Chart Image");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_crudeoilgas_1Day,"1 Day");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_crudeoilgas_1Week,"1 Week");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_crudeoilgas_1Month,"1 Month");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_energy_crudeoilgas_3Month,"3 Months");
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_energy_crudeoilgas_1WeekChangeText,"1 Week Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_1WeekChangeValue ," 1 Week change value:"+Commodities.wbelem_commodities_energy_crudeoilgas_1WeekChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_energy_crudeoilgas_1MonthChangeText,"1 Month Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_1MonthChangeValue,"1 Month change value:"+Commodities.wbelem_commodities_energy_crudeoilgas_1MonthChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_energy_crudeoilgas_3MonthChangeText,"3 Month Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_3MonthChangeValue ,"3 Month change value:"+Commodities.wbelem_commodities_energy_crudeoilgas_3MonthChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_energy_crudeoilgas_52WeekRangeText,"52-Week Range for" +"\n"+ "Continuous Contract");
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_52WeekLow,"52-Week Low Value:"+Commodities.wbelem_commodities_energy_crudeoilgas_52WeekLow.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_energy_crudeoilgas_52WeekHigh,"52-Week High Value:"+Commodities.wbelem_commodities_energy_crudeoilgas_52WeekHigh.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_energy_crudeoilgas_1WeekMomentum,"1 Week Momentum");
		extReport.endTest(test1);
		softAssert.assertAll();

	}
	
	
	@Test(priority =3 , enabled = true)
	public void TC_VerificationOf_WaysToInvest_Energy_Commodities() throws InterruptedException 
	{
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_WaysToInvest_Energy","This Method will verify the components under Ways to Invest in Energy");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(Commodities.wbelemWaysToInvest,"Ways to invest in energy");
		fnVerifyElementExistenceWithText(Commodities.wbelemStocks,"Stocks");
		fnVerifyElementExistenceWithText(Commodities.wblnkBuyRatedStocks,"Buy rated energy stocks");
		fnVerifyElementExistenceWithText(Commodities.wbelemETFs,"ETFs");
		fnVerifyElementExistenceWithText(Commodities.wblnkCommodityETFs,"Energy commodity ETFs");
		fnVerifyElementExistenceWithText(Commodities.wblnkEnergySectorETF,"Energy sector ETFs");
		extReport.enterLog("Info", "Clicking on Buy rated energy stocks link");
		Commodities.wblnkBuyRatedStocks.click();
		Thread.sleep(5000);
		fnVerifyElementExistenceWithText(Commodities.wblnkStockScreeenersTab,"Stock Screener");
		Commodities.fnNavigateBack();
		extReport.enterLog("Info", "Navigating Back");
		Thread.sleep(5000);
		extReport.enterLog("Info", "Clicking on ETF Link");
		Commodities.wblnkCommodityETFs.click();
		Thread.sleep(5000);
		fnVerifyElementExistenceWithText(Commodities.wblnkETFScreeenersTab,"ETF Screener");
		Commodities.fnNavigateBack();
		extReport.enterLog("Info", "Navigating Back");
		Thread.sleep(5000);		
		fnVerifyElementExistence(Commodities.wbelemBookIcon,"Book Icon");
		extReport.endTest(test1);
		softAssert.assertAll();		
 }
	
	
	@Test(priority =4 , enabled = true)
	public void TC_VerificationOfMetalsPage_Commodities() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfMetalsPage", "This Method will verify the existence of several compoenents on Metals page");
		Commodities.wblnkCommodities_MetalsTab.click();
		parent.appendChild(test1);
		
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemBaseMetalsQuotesTimeStamp);
		fnVerifyElementExistenceWithText(Commodities.wbelemPreciousMetalsText,"Precious metals");
		fnVerifyElementExistenceWithText(Commodities.wblnkPreciousMetals_GoldText,"Gold");
		fnVerifyElementExistenceWithText(Commodities.wblnkPreciousMetals_SilverText,"Silver");
		fnVerifyElementExistenceWithText(Commodities.wblnkPreciousMetals_PlatinumText,"Platinum");
		fnVerifyElementExistenceWithText(Commodities.wblnkPreciousMetals_MiniGoldText,"E-mini gold");
		fnVerifyElementExistence(Commodities.wbelemPreciousMetalsQuotesTimeStamp,"Precious Metals Quote  Timestamp : "+Commodities.wbelemPreciousMetalsQuotesTimeStamp.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemBaseMetalsText,"Base metals");
		fnVerifyElementExistenceWithText(Commodities.wblnkBaseMetals_Copper,"Copper");
		fnVerifyElementExistenceWithText(Commodities.wblnkBaseMetals_Aluminium,"Aluminum");
		fnVerifyElementExistence(Commodities.wbelemBaseMetalsQuotesTimeStamp,"   "+Commodities.wbelemBaseMetalsQuotesTimeStamp.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_CurrentValue," Current price of Gold:  "+Commodities.wbelem_commodities_metals_preciousmetals_Gold_CurrentValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_metals_preciousmetals_Gold_CurrentValueIn_USD,"USD/t oz.");
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_CurrentPerformance," Today's Performance value of Gold:  "+Commodities.wbelem_commodities_metals_preciousmetals_Gold_CurrentPerformance.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_MonthlyPerformance," 1 Month Performance value of Gold:  "+Commodities.wbelem_commodities_metals_preciousmetals_Gold_MonthlyPerformance.getText());
		fnVerifyElementExistence(Commodities.wblst_commodities_metals_preciousmetals_Gold_CompareList,"Compare to List");
		fnVerifyElementExistence(Commodities.wbimg_commodities_metals_preciousmetals_Gold_Image,"Chart Image");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_metals_preciousmetals_Gold_1Day,"1 Day");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_metals_preciousmetals_Gold_1Week,"1 Week");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_metals_preciousmetals_Gold_1Month,"1 Month");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_metals_preciousmetals_Gold_3Month,"3 Months");
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_metals_preciousmetals_Gold_1WeekChangeText,"1 Week Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_1WeekChangeValue ," 1 Week change value:"+Commodities.wbelem_commodities_metals_preciousmetals_Gold_1WeekChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_metals_preciousmetals_Gold_1MonthChangeText,"1 Month Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_1MonthChangeValue,"1 Month change value:"+Commodities.wbelem_commodities_metals_preciousmetals_Gold_1MonthChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_metals_preciousmetals_Gold_3MonthChangeText,"3 Month Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_3MonthChangeValue ,"3 Month change value:"+Commodities.wbelem_commodities_metals_preciousmetals_Gold_3MonthChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_metals_preciousmetals_Gold_52WeekRangeText,"52-Week Range for" +"\n"+ "Continuous Contract");
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_52WeekLow,"52-Week Low Value:"+Commodities.wbelem_commodities_metals_preciousmetals_Gold_52WeekLow.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_metals_preciousmetals_Gold_52WeekHigh,"52-Week High Value:"+Commodities.wbelem_commodities_metals_preciousmetals_Gold_52WeekHigh.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_metals_preciousmetals_Gold_1WeekMomentum,"1 Week Momentum");
		extReport.endTest(test1);
		softAssert.assertAll();
		
	}
	
	
	@Test(priority =5 , enabled = true)
	public void TC_VerificationOf_WaysToInvest_Metals_Commodities() throws InterruptedException 
	{
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_WaysToInvest_Metals","This Method will verify the components under Ways to Invest in Metals");
		parent.appendChild(test1);
		
		fnVerifyElementExistenceWithText(Commodities.wbelemWaysToInvest,"Ways to invest in metals");
		fnVerifyElementExistenceWithText(Commodities.wbelemStocks,"Stocks");
		fnVerifyElementExistenceWithText(Commodities.wblnkBuyRatedStocks,"Buy rated materials stocks");
		fnVerifyElementExistenceWithText(Commodities.wbelemETFs,"ETFs");
		fnVerifyElementExistenceWithText(Commodities.wblnkCommodityETFs,"Metal commodity ETFs");
		extReport.enterLog("Info", "Clicking on Buy rated material stocks link");
		Commodities.wblnkBuyRatedStocks.click();
		Thread.sleep(5000);
		fnVerifyElementExistenceWithText(Commodities.wblnkStockScreeenersTab,"Stock Screener");
		Commodities.fnNavigateBack();
		extReport.enterLog("Info", "Navigating Back");
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp);
		Commodities.wblnkCommodities_MetalsTab.click();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemBaseMetalsQuotesTimeStamp);
		extReport.enterLog("Info", "Clicking on ETF Link");
		Commodities.wblnkCommodityETFs.click();
		Thread.sleep(5000);
		fnVerifyElementExistenceWithText(Commodities.wblnkETFScreeenersTab,"ETF Screener");
		Commodities.fnNavigateBack();
		extReport.enterLog("Info", "Navigating Back");
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp);
		Commodities.wblnkCommodities_MetalsTab.click();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemBaseMetalsQuotesTimeStamp);
		fnVerifyElementExistence(Commodities.wbelemBookIcon,"Book Icon");
		extReport.endTest(test1);
		softAssert.assertAll();

 }
	
	@Test(priority =6 , enabled = true)
	public void TC_VerificationOfAgriculturePage_Commodities() throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOfAgriculturePage", "This Method will verify the existence of several compoenents on Agriculture page");
		parent.appendChild(test1);
		Commodities.wblnkCommodities_AgricultureTab.click();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemGrainsAndOilseedQuotesTimeStamp);
		fnVerifyElementExistenceWithText(Commodities.wbelemGrainsAndOilseed,"Grains & oilseed");
		fnVerifyElementExistenceWithText(Commodities.wblnkGrainsAndOilseed_Corn_Text,"Corn");
		fnVerifyElementExistenceWithText(Commodities.wblnkGrainsAndOilseed_Soybeans_Text,"Soybeans");
		fnVerifyElementExistenceWithText(Commodities.wblnkGrainsAndOilseed_SoybeanMeal_Text,"Soybean meal");
		fnVerifyElementExistenceWithText(Commodities.wblnkGrainsAndOilseed_Oats_Text,"Oats");
		fnVerifyElementExistenceWithText(Commodities.wblnkGrainsAndOilseed_RoughRice_Text,"Rough rice");
		fnVerifyElementExistence(Commodities.wbelemGrainsAndOilseedQuotesTimeStamp,"Grains and oilseed Quote Timestamp : "+Commodities.wbelemGrainsAndOilseedQuotesTimeStamp.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemLivestock,"Livestock");
		fnVerifyElementExistenceWithText(Commodities.wblnkLivestock_LeanHog_Text,"Lean hog");
		fnVerifyElementExistenceWithText(Commodities.wblnkLivestock_LiveCattle_Text,"Live cattle");
		fnVerifyElementExistenceWithText(Commodities.wblnkLivestock_FeederCattle_Text,"Feeder cattle");
		fnVerifyElementExistence(Commodities.wbelemLivestockQuotesTimeStamp,"Livestock Quote Timestamp : "+Commodities.wbelemGrainsAndOilseedQuotesTimeStamp.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemForest,"Forest");
		fnVerifyElementExistenceWithText(Commodities.wblnkForest_Lumber_Text,"Lumber");
		fnVerifyElementExistence(Commodities.wbelemForestQuotesTimeStamp,"Forest Quote Timestamp : "+Commodities.wbelemForestQuotesTimeStamp.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelemSofts,"Softs");
		fnVerifyElementExistenceWithText(Commodities.wblnkSofts_Cocoa,"Cocoa");
		fnVerifyElementExistenceWithText(Commodities.wblnkSofts_Coffee,"Coffee");
		fnVerifyElementExistenceWithText(Commodities.wblnkSofts_Cotton,"Cotton");
		fnVerifyElementExistenceWithText(Commodities.wblnkSofts_Sugar,"Sugar");
		fnVerifyElementExistence(Commodities.wbelemSoftsQuotesTimeStamp,"Softs Quote Timestamp : "+Commodities.wbelemSoftsQuotesTimeStamp.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_CurrentValue," Current price of Corn:  "+Commodities.wbelem_commodities_Agriculture_Grains_Corn_CurrentValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_Agriculture_Grains_Corn_CurrentValueIn_USD,"USD/bu.");
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_CurrentPerformance," Today's Performance value of Corn:  "+Commodities.wbelem_commodities_Agriculture_Grains_Corn_CurrentPerformance.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_MonthlyPerformance," 1 Month Performance value of Corn:  "+Commodities.wbelem_commodities_Agriculture_Grains_Corn_MonthlyPerformance.getText());
		fnVerifyElementExistence(Commodities.wbimg_commodities_Agriculture_Grains_Corn_Image,"Chart Image");
		fnVerifyElementExistence(Commodities.wblst_commodities_Agriculture_Grains_Corn_CompareList,"Compare to List");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_Agriculture_Grains_Corn_1Day,"1 Day");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_Agriculture_Grains_Corn_1Week,"1 Week");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_Agriculture_Grains_Corn_1Month,"1 Month");
		fnVerifyElementExistenceWithText(Commodities.wblnk_commodities_Agriculture_Grains_Corn_3Month,"3 Months");
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_Agriculture_Grains_Corn_1WeekChangeText,"1 Week Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_1WeekChangeValue," 1 Week change value:"+Commodities.wbelem_commodities_Agriculture_Grains_Corn_1WeekChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_Agriculture_Grains_Corn_1MonthChangeText,"1 Month Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_1MonthChangeValue,"1 Month change value:"+Commodities.wbelem_commodities_Agriculture_Grains_Corn_1MonthChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_Agriculture_Grains_Corn_3MonthChangeText,"3 Month Change");
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_3MonthChangeValue ,"3 Month change value:"+Commodities.wbelem_commodities_Agriculture_Grains_Corn_3MonthChangeValue.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_Agriculture_Grains_Corn_52WeekRangeText,"52-Week Range for" +"\n"+ "Continuous Contract");
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_52WeekLow,"52-Week Low Value:"+Commodities.wbelem_commodities_Agriculture_Grains_Corn_52WeekLow.getText());
		fnVerifyElementExistence(Commodities.wbelem_commodities_Agriculture_Grains_Corn_52WeekHigh,"52-Week High Value:"+Commodities.wbelem_commodities_Agriculture_Grains_Corn_52WeekHigh.getText());
		fnVerifyElementExistenceWithText(Commodities.wbelem_commodities_Agriculture_Grains_Corn_1WeekMomentum,"1 Week Momentum");
		extReport.endTest(test1);
		softAssert.assertAll();
				
	}
		
	@Test(priority =7 , enabled = true)
	public void TC_VerificationOf_WaysToInvest_Agriculture_Commodities() throws InterruptedException 
	{
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_WaysToInvest_Agriculture","This Method will verify the components under Ways to Invest in Agriculture");
		parent.appendChild(test1);
		fnVerifyElementExistenceWithText(Commodities.wbelemWaysToInvest,"Ways to invest in agriculture");
		fnVerifyElementExistenceWithText(Commodities.wbelemStocks,"Stocks");
		fnVerifyElementExistenceWithText(Commodities.wblnkBuyRatedStocks,"Buy rated consumer staples stocks");
		fnVerifyElementExistenceWithText(Commodities.wbelemETFs,"ETFs");
		fnVerifyElementExistenceWithText(Commodities.wblnkCommodityETFs,"Agricultural commodity ETFs");
		extReport.enterLog("Info", "Clicking on  stocks link");
		Commodities.wblnkBuyRatedStocks.click();
		Thread.sleep(5000);
		fnVerifyElementExistenceWithText(Commodities.wblnkStockScreeenersTab,"Stock Screener");
		Commodities.fnNavigateBack();
		extReport.enterLog("Info", "Navigating Back");
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp);
		Commodities.wblnkCommodities_AgricultureTab.click();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemGrainsAndOilseedQuotesTimeStamp);
		extReport.enterLog("Info", "Clicking on ETF Link");
		Commodities.wblnkCommodityETFs.click();
		Thread.sleep(5000);
		fnVerifyElementExistenceWithText(Commodities.wblnkETFScreeenersTab,"ETF Screener");
		Commodities.fnNavigateBack();
		extReport.enterLog("Info", "Navigating Back");
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp);
		Commodities.wblnkCommodities_AgricultureTab.click();
		mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemGrainsAndOilseedQuotesTimeStamp);
		fnVerifyElementExistence(Commodities.wbelemBookIcon,"Book Icon");
		extReport.endTest(test1);
		softAssert.assertAll();
		 }
	
	@Test(dataProvider="sector" , priority =8 , enabled = true)
	public void TC_VerificationOf_LatestNews(String sector) throws InterruptedException {
		ExtentTest test1 = extReport.startTest("TC_VerificationOf_LatestNews"+sector, "This Method will verify the components under Latest "+ sector + " news and Commodity events");
		parent.appendChild(test1);
		fnClickSector(sector) ;
		fnConditionalWait(sector);				
		sector = sector.toLowerCase() ;
		fnVerifyElementExistenceWithText(Commodities.wbelemLatestNews,"Latest " + sector + " news");
		fnVerifyElementExistenceWithText(Commodities.wbelemShowOnly,"Show only");
		fnVerifyElementExistenceWithText(Commodities.wbelemMyholdingsText,"My holdings");
		fnVerifyElementExistence(Commodities.wbchkboxMyholdingsCheckbox,"My Holdings checkbox");		
		fnVerifyElementExistenceWithText(Commodities.wbelemMyWatchlistText,"My watchlist");
		fnVerifyElementExistence(Commodities.wbchkboxMyWatchlistCheckbox,"My watchlist checkbox");
		fnVerifyElementExistence(Commodities.wblnkNewsHeadlineOnLatestNews,"First news heading-"+Commodities.wblnkNewsHeadlineOnLatestNews.getText());
		fnVerifyElementExistence(Commodities.wbelemCompanyNameForNews,"Company name for First news heading-"+ Commodities.wbelemCompanyNameForNews.getText());
		fnVerifyElementExistence(Commodities.wbelemTeaserForFirstNews,"Teaser for first news");
		fnVerifyElementExistence(Commodities.wbelemTimeStampInformationForNews,"TimeStamp Information for first news-"+Commodities.wbelemTimeStampInformationForNews.getText());
		fnVerifyElementExistence(Commodities.wblnkReadMoreOnRecentNews,"Read more link");
		fnVerifyElementExistenceWithText(Commodities.wblnkMoreNews,"More " + sector + " news");
		 
		
		extReport.enterLog("Info", "Mouse hover on News Item ");
        Commodities.actMouseOver(Commodities.wblnkSecondNewsHealine);
        mlPP.fnWaitTillElementVisible(driver,10,Commodities.wblnkSecondNewsHealine);
        fnVerifyElementExistence(Commodities.wblnkSecondNewsHealine,"Second News Headline on Mouse over");
        fnVerifyElementExistenceWithText(Commodities.wbelemHoverNewsModalHeader,"News");
        
        
        //Commenting this as news headlines cannot be matched since it changes within seconds and leads to script failure.
        //String SecondNewsText = Commodities.wblnkSecondNewsHealine.getText();
        //fnVerifyElementExistenceWithText(Commodities.wbelemHoverNewsTitle,SecondNewsText);
        
        
        fnVerifyElementExistenceWithText(Commodities.wbelemCompaniesInTheNews,"Companies in the news");

		
		
		
		
		
		fnVerifyElementExistence(Commodities.wbelemCompaniesinNews_FirstCompanySymbol,"First Company Symbol under companies in news:"+Commodities.wbelemCompaniesinNews_FirstCompanySymbol.getText());	
		fnVerifyElementExistence(Commodities.wbelemCompaniesinNews_FirstCompanyName,"First Company Name under companies in news:"+Commodities.wbelemCompaniesinNews_FirstCompanyName.getText());
		fnVerifyElementExistence(Commodities.wbelemCompaniesinNews_FirstCompanyValue,"First Company Last Price under companies in news:"+Commodities.wbelemCompaniesinNews_FirstCompanyValue.getText());
		fnVerifyElementExistence(Commodities.wbelemCompaniesinNews_FirstCompanyChangePercent,"First Company Last Price under companies in news:"+Commodities.wbelemCompaniesinNews_FirstCompanyChangePercent.getText());
		fnVerifyElementExistence(Commodities.wbelemCompaniesinNews_AsOf,"TimeStamp of Companies in the news");
			
		fnVerificationOf_Commodity(sector) ;
		extReport.endTest(test1);
		softAssert.assertAll();
		
	}
	
	//  This function will verify commodity section for all sectors
	
	public void fnVerificationOf_Commodity(String sector) throws InterruptedException {
		
		extReport.enterLog("Info", "------------------Verifying Commodity Event Section-------------------------------------");
		fnVerifyElementExistenceWithText(Commodities.wbelemCommodityEvents,"Commodity events");
		fnVerifyElementExistenceWithText(Commodities.wbelemThisWeekEventCalendarText,"This week's commodities event calendar");
		fnVerifyElementExistence(Commodities.wbelemCalendarIcon,"Calendar Icon");
		fnVerifyElementExistence(Commodities.wblnkCommodityEvents_FirstEventLink,"First event:" +Commodities.wblnkCommodityEvents_FirstEventLink.getText() );
		fnVerifyElementExistence(Commodities.wbelemCommodityEvents_FirstEvent_TimeStamp,"First event Timestamp :" +Commodities.wbelemCommodityEvents_FirstEvent_TimeStamp.getText() );
		extReport.enterLog("Info", "Clicking on the First event in event calendar");
		Commodities.wblnkCommodityEvents_FirstEventLink.click();
		String EventName = Commodities.wblnkCommodityEvents_FirstEventLink.getText() ;
		fnVerifyElementExistenceWithText(Commodities.wbelemEventsModal_EventName,EventName);
		fnVerifyElementExistenceWithText(Commodities.wbelemEventsModal_ActualNumberReportedText,"Actual number"+"\n"+ "reported");
		fnVerifyElementExistence(Commodities.wbelemEventsModal_ActualNumberReportedValue,"Actual number reported (value):" +Commodities.wbelemEventsModal_ActualNumberReportedValue.getText() );
		fnVerifyElementExistenceWithText(Commodities.wbelemEventsModal_NumberFromPreviousText,"Number from the"+"\n"+ "previous period");
		fnVerifyElementExistence(Commodities.wbelemEventsModal_NumberFromPreviousValue,"Numbers from the previous period (value):" +Commodities.wbelemEventsModal_NumberFromPreviousValue.getText() );
		fnVerifyElementExistenceWithText(Commodities.wbelemAnalysis,"Analysis");
		fnVerifyElementExistence(Commodities.wbelemLogo_ECONODAY,"ECONODAY LOGO ");
		extReport.enterLog("Info", "Clicking on Close to Close event modal");
		Commodities.wbelemEventModal_Close.click();
		Thread.sleep(1000);
		
		fnVerifyElementExistenceWithText(Commodities.wblnkMoreMarketEvents,"More market events");
		
	}	
		
	// This method clicks on the specific sector tab which is passed as parameter to the function.
	// Parameter to be passed is the Sector name
	public void fnClickSector(String sector)
	{
		switch( sector)
		{
		case "Energy":
			Commodities.wblnkCommodities_EnergyTab.click();
			break;
		case "Metals":
			Commodities.wblnkCommodities_MetalsTab.click();
			break;
		case "Agriculture":
			Commodities.wblnkCommodities_AgricultureTab.click();
			break;
		default:
			System.out.println("Option not found :"+sector);
			break;
		}
	}
	
	//This method is an alternate to the  WaitTillElementVisible and implement the same functinality based on the parameter passed to the function. 
	// Parameter to be passed is the Sector name
	public void fnConditionalWait(String sector)
	{
		switch( sector)
		{
		case "Energy":
			mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp);
			break;
		case "Metals":
			mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemPreciousMetalsQuotesTimeStamp);
			break;
		case "Agriculture":
			mlPP.fnWaitTillElementVisible(driver, 40, Commodities.wbelemGrainsAndOilseedQuotesTimeStamp);
			break;			
		default:
			System.out.println("Quote option not found for :"+sector);
			break;
		}
				
	}
	@AfterClass

	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
		
	}
	
	
}

