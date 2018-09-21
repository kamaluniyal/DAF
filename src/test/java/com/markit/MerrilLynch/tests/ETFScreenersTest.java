package com.markit.MerrilLynch.tests;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.MerrilLynch.pages.ETFScreeners;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.markit.DigitalAutomationFramework.common.PropertyReader;

/*
 *
 * @author: Rahul Tiwari
 * @purpose: This class contains all the regression scenarios of ETF screeners module.
 * @creation date: 11/28/2016
 *
 */
public class ETFScreenersTest extends MerrilLynchProductTest{
	PropertyReader prop;
	GlobalDriver gDriver;
	ETFScreeners ES;
	MerrillLynchProductPage mlPP;
	ExtentTest parent;
	int expCounter=0;

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
		ES = new ETFScreeners(driver);
		parent = extent.startTest("ETF Screeners");
	}

	/*
	 * @purpose: This function is used for initialising assertions before each test method.
	 */

	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens section on ETF Screener page.
	 */

	@Test(priority =0)
	public void TC_VerificationOfPredefinedScreensOnLeftPanel() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensOnLeftPanel", "This Method will verify Predefined Screens On Left Panel");
		parent.appendChild(test);
		mlPP.actMouseOver(mlPP.wblnkResearch);
		mlPP.fnWaitTillElementEnable(driver, 30, ES.wbLnkETFScreenerLink);
		fnClick(ES.wbLnkETFScreenerLink);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLnkETFScreenerTab);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnClick(ES.wbElemPredefinedScreens);
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsOption,"Morningstar 5 Star Rated ETFs");
		fnVerifyElementExistenceWithText(ES.wbElemIndexFundsOption,"Index Funds");
		fnVerifyElementExistenceWithText(ES.wbElemCommunicationsOption,"Communications");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerDiscretionaryOption,"Consumer discretionary");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerStaplesOption,"Consumer staples");
		fnVerifyElementExistenceWithText(ES.wbElemEnergyOption,"Energy");
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareOption,"Health care");
		fnVerifyElementExistenceWithText(ES.wbElemIndustrialsOption,"Industrials");
		fnVerifyElementExistenceWithText(ES.wbElemFinancialsOption,"Financials");
		fnVerifyElementExistenceWithText(ES.wbElemMaterialsOption,"Materials");
		fnVerifyElementExistenceWithText(ES.wbElemTechnologyOption,"Technology");
		fnVerifyElementExistenceWithText(ES.wbElemUtilitiesOption,"Utilities");
		fnVerifyElementExistenceWithText(ES.wbElemRealEstateOption,"Real Estate");
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table on ETF Screener page.
	 */
	@Test(priority =1 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResults() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResults", "This Method will verify Predefined Screens results");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		//fnClick(ES.wbElemPredefinedScreens);
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsOption,"Morningstar 5 Star Rated ETFs");
		fnClick(ES.wbElemMorningStar5StarRatedETFsOption);
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsName,"Morningstar 5 Star Rated ETFs");
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsDescription,"ETFs rated 5 stars overall by Morningstar");
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsView,"View");
		fnClick(ES.wbElemMorningStar5StarRatedETFsView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemMorningStar5StarRatedETFsOption.getText()+":");
		fnClick(ES.wbElemMorningStar5StarRatedETFsOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for MorningStar on ETF Screener page.
	 */
	@Test(priority =2 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsMorningStar() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsMorningStar", "This Method will verify Predefined Screens results for Morning Star criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		//fnClick(ES.wbElemPredefinedScreens);
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsOption,"Morningstar 5 Star Rated ETFs");
		fnClick(ES.wbElemMorningStar5StarRatedETFsOption);
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsName,"Morningstar 5 Star Rated ETFs");
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsDescription,"ETFs rated 5 stars overall by Morningstar");
		fnVerifyElementExistenceWithText(ES.wbElemMorningStar5StarRatedETFsView,"View");
		fnClick(ES.wbElemMorningStar5StarRatedETFsView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemMorningStar5StarRatedETFsOption.getText()+":");
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Morningstar rating overall: Rated 5 Star");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemMorningStar5StarRatedETFsOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Index Funds on ETF Screener page.
	 */
	@Test(priority =3 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsIndexFunds() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsIndexFunds", "This Method will verify Predefined Screens results for Index Funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		//fnClick(ES.wbElemPredefinedScreens);
		fnVerifyElementExistenceWithText(ES.wbElemIndexFundsOption,"Index Funds");
		fnClick(ES.wbElemIndexFundsOption);
		fnVerifyElementExistenceWithText(ES.wbElemIndexFundsName,"Index Funds");
		fnVerifyElementExistenceWithText(ES.wbElemIndexFundsDescription,"ETFs with portfolios designed to match closely or track a specific market index");
		fnVerifyElementExistenceWithText(ES.wbElemIndexFundsView,"View");
		fnClick(ES.wbElemIndexFundsView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemIndexFundsOption.getText()+":");
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Is passively managed: Yes");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		fnClick(ES.wbElemIndexFundsOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Communications on ETF Screener page.
	 */
	@Test(priority =4 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsCommunications() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsCommunications", "This Method will verify Predefined Screens results for Communications criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemCommunicationsOption,"Communications");
		fnClick(ES.wbElemCommunicationsOption);
		fnVerifyElementExistenceWithText(ES.wbElemCommunicationsName,"Communications");
		fnVerifyElementExistenceWithText(ES.wbElemCommunicationsDescription,"ETFs in the communications sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemCommunicationsView,"View");
		fnClick(ES.wbElemCommunicationsView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemCommunicationsOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Telecommunication Services");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemCommunicationsOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Consumer Discretionary on ETF Screener page.
	 */
	@Test(priority =5 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsConsumerDiscretionary() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsConsumerDiscretionary", "This Method will verify Predefined Screens results for Consumer Discretionary criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerDiscretionaryOption,"Consumer discretionary");
		fnClick(ES.wbElemConsumerDiscretionaryOption);
		fnVerifyElementExistenceWithText(ES.wbElemConsumerDiscretionaryName,"Consumer discretionary");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerDiscretionaryDescription,"ETFs in the consumer discretionary sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerDiscretionaryView,"View");
		fnClick(ES.wbElemConsumerDiscretionaryView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemConsumerDiscretionaryOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Consumer Discretionary");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemConsumerDiscretionaryOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Consumer Staples on ETF Screener page.
	 */
	@Test(priority =6 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsConsumerStaples() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsConsumerStaples", "This Method will verify Predefined Screens results for Consumer Staples criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerStaplesOption,"Consumer staples");
		fnClick(ES.wbElemConsumerStaplesOption);
		fnVerifyElementExistenceWithText(ES.wbElemConsumerStaplesName,"Consumer staples");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerStaplesDescription,"ETFs in the consumer staples sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemConsumerStaplesView,"View");
		fnClick(ES.wbElemConsumerStaplesView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemConsumerStaplesOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Consumer Staples");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemConsumerStaplesOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Energy on ETF Screener page.
	 */
	@Test(priority =7 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsEnergy() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsEnergy", "This Method will verify Predefined Screens results for Energy criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemEnergyOption,"Energy");
		fnClick(ES.wbElemEnergyOption);
		fnVerifyElementExistenceWithText(ES.wbElemEnergyName,"Energy");
		fnVerifyElementExistenceWithText(ES.wbElemEnergyDescription,"ETFs in the energy sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemEnergyView,"View");
		fnClick(ES.wbElemEnergyView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemEnergyOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Energy");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemEnergyOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Financials on ETF Screener page.
	 */
	@Test(priority =8 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsFinancials() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsFinancials", "This Method will verify Predefined Screens results for Financials criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemFinancialsOption,"Financials");
		fnClick(ES.wbElemFinancialsOption);
		fnVerifyElementExistenceWithText(ES.wbElemFinancialsName,"Financials");
		fnVerifyElementExistenceWithText(ES.wbElemFinancialsDescription,"ETFs in the financial sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemFinancialsView,"View");
		fnClick(ES.wbElemFinancialsView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemFinancialsOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Financials");

		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemFinancialsOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Industrials on ETF Screener page.
	 */
	@Test(priority =9 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsIndustrials() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsIndustrials", "This Method will verify Predefined Screens results for Industrials criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemIndustrialsOption,"Industrials");
		fnClick(ES.wbElemIndustrialsOption);
		fnVerifyElementExistenceWithText(ES.wbElemIndustrialsName,"Industrials");
		fnVerifyElementExistenceWithText(ES.wbElemIndustrialsDescription,"ETFs in the industrials sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemIndustrialsView,"View");
		fnClick(ES.wbElemIndustrialsView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemIndustrialsOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Industrials");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemIndustrialsOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Materials on ETF Screener page.
	 */
	@Test(priority =10 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsMaterials() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsMaterials", "This Method will verify Predefined Screens results for Materials criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemMaterialsOption,"Materials");
		fnClick(ES.wbElemMaterialsOption);
		fnVerifyElementExistenceWithText(ES.wbElemMaterialsName,"Materials");
		fnVerifyElementExistenceWithText(ES.wbElemMaterialsDescription,"ETFs in the materials sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemMaterialsView,"View");
		fnClick(ES.wbElemMaterialsView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemMaterialsOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Materials");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemMaterialsOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Technology on ETF Screener page.
	 */
	@Test(priority =11 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsTechnology() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsTechnology", "This Method will verify Predefined Screens results for Technology criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemTechnologyOption,"Technology");
		fnClick(ES.wbElemTechnologyOption);
		fnVerifyElementExistenceWithText(ES.wbElemTechnologyName,"Technology");
		fnVerifyElementExistenceWithText(ES.wbElemTechnologyDescription,"ETFs in the technology sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemTechnologyView,"View");
		fnClick(ES.wbElemTechnologyView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemTechnologyOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Information Technology");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemTechnologyOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Utilities on ETF Screener page.
	 */
	@Test(priority =12 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsUtilities() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsUtilities", "This Method will verify Predefined Screens results for Utilities criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemUtilitiesOption,"Utilities");
		fnClick(ES.wbElemUtilitiesOption);
		fnVerifyElementExistenceWithText(ES.wbElemUtilitiesName,"Utilities");
		fnVerifyElementExistenceWithText(ES.wbElemUtilitiesDescription,"ETFs in the utilities sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemUtilitiesView,"View");
		fnClick(ES.wbElemUtilitiesView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemUtilitiesOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Utilities");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemUtilitiesOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Real Estate on ETF Screener page.
	 */
	@Test(priority =13 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsRealEstate() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsRealEstate", "This Method will verify Predefined Screens results for Real Estate criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemRealEstateOption,"Real Estate");
		fnClick(ES.wbElemRealEstateOption);
		fnVerifyElementExistenceWithText(ES.wbElemRealEstateName,"Real Estate");
		fnVerifyElementExistenceWithText(ES.wbElemRealEstateDescription,"ETFs in the real estate sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemRealEstateView,"View");
		fnClick(ES.wbElemRealEstateView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemRealEstateOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Real Estate");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemRealEstateOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for HealthCare on ETF Screener page.
	 */
	@Test(priority =14 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsHealthCare() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsHealthCare", "This Method will verify Predefined Screens results for Health Care criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareOption,"Health care");
		fnClick(ES.wbElemHealthCareOption);
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareName,"Health care");
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareDescription,"ETFs in the health care sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareView,"View");
		fnClick(ES.wbElemHealthCareView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemHealthCareOption.getText()+":");
		try
		{
			if(Integer.parseInt(ES.wbElemResultCountLabel.getText())>0)
			{
				fnVerifyElementExistence(ES.wbElemScreenNameResultTable,"Screen Name '"+ES.wbElemScreenNameResultTable.getText() +"' in Result Table "+ES.wbElemScreenNameResultTable.getText());	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Health Care");

		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemHealthCareOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Composition of Selected Screens on ETF Screener page.
	 */
	@Test(priority =15 , enabled= true)
	public void TC_ComposingSelectedScreens() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_ComposingSelectedScreens", "This Method will validate composition of Predefined Screens");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(ES.wbLnkETFScreenerTab,"ETF Screener");
		fnVerifyElementExistence(ES.wbElemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(ES.wbElemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareOption,"Health care");
		fnClick(ES.wbElemHealthCareOption);
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareName,"Health care");
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareDescription,"ETFs in the health care sector, according to the GICS methodology");
		fnVerifyElementExistenceWithText(ES.wbElemHealthCareView,"View");
		fnClick(ES.wbElemHealthCareView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstViewResultsDropdown);
		fnVerifyElementExistence(ES.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(ES.wbElemResultCountLabel,ES.wbElemResultCountLabel.getText()+" results matching");	
		extReport.enterLog("info", "Checking Applied criteria before adding additional criteria");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteria,"Pre-defined screen - "+ES.wbElemHealthCareOption.getText()+":");
		fnVerifyElementExistenceWithText(ES.wbElemLeverageCriteria,"Leveraged/inverse ETFs: No");
		fnVerifyElementExistenceWithText(ES.wbElemIsBlockedCriteria,"Is blocked ETF: No");
		fnVerifyElementExistenceWithText(ES.wbElemAppliedCriteriaName,"Top sector: Health Care");
		//Adding more criteria to the screen
		extReport.enterLog("info", "Adding adding additional criteria");
		fnVerifyElementExistenceWithText(ES.wbElemBasicCriteriaText,"Basic criteria");
		fnVerifyElementExistenceWithText(ES.wbElemPriceRangeText,"Price range");
		extReport.enterLog("info", "Adding price range as a criteria");
		fnClick(ES.wbElemPriceRangeText);
		mlPP.dragAndDrop(ES.wbElemPriceRangeMax, ES.wbElemPriceMaxTarget);
		Thread.sleep(5000);
		mlPP.dragAndDrop(ES.wbElemPriceRangeMin, ES.wbElemPriceMinTarget);
		Thread.sleep(5000);
		//verifying criterias after adding criteria
		extReport.enterLog("info", "Checking Applied criteria after adding additional criteria");
		fnVerifyElementExistence(ES.wbElemLeverageCriteria,ES.wbElemLeverageCriteria.getText());
		fnVerifyElementExistence(ES.wbElemIsBlockedCriteria,ES.wbElemIsBlockedCriteria.getText());
		fnVerifyElementExistence(ES.wbElemAppliedCriteriaName,ES.wbElemAppliedCriteriaName.getText());
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(ES.wbElemCountDisplayed,ES.wbElemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(ES.wbElemCountMatched,ES.wbElemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(ES.wbElemCountMatched.getText())>=Integer.parseInt(ES.wbElemCountDisplayed.getText()))
			{
				extReport.enterLog("info", "Number of results displayed is less than number of results matched");
			}
			else
			{
				extReport.enterLog("info", "Number of results displayed is more than number of results matched");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		fnClick(ES.wbElemHealthCareOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Search of Custom Criteria ETF Screener page.
	 */
	@Test(priority =16 , enabled= true)
	public void TC_SearchCustomCriteriaVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_SearchCustomCriteriaVerification", "This Method will validate search custom criteria module");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbElemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(ES.wbElemSearchCustomCriteriaText,"Search custom criteria");
		fnVerifyElementExistence(ES.wbtxtCriteriaSearchTextBox,"Search box");
		extReport.enterLog("info", "Verifying watermark in search box ");
		if(ES.wbtxtCriteriaSearchTextBox.getAttribute("value").equalsIgnoreCase("Enter criteria name"))
		{
			extReport.enterLog("Pass", "Watermark 'Enter criteria name' is displayed in serch box");	
		}
		else
		{
			extReport.enterLog("Fail", "Watermark 'Enter criteria name' is not displayed in serch box");
		}
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Search section on ETF Screener page.
	 */
	@Test(priority =17 , enabled= true)
	public void TC_YourSearchVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_YourSearchVerification", "This Method will validate Your search tab after applying a custom criteria");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbElemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(ES.wbElemSearchCustomCriteriaText,"Search custom criteria");
		//Adding more criteria to the screen
		extReport.enterLog("info", "Adding adding additional criteria");
		fnVerifyElementExistenceWithText(ES.wbElemBasicCriteriaText,"Basic criteria");
		fnVerifyElementExistenceWithText(ES.wbElemPriceRangeText,"Price range");
		extReport.enterLog("info", "Adding price range as a criteria");
		fnClick(ES.wbElemPriceRangeText);
		mlPP.dragAndDrop(ES.wbElemPriceRangeMax, ES.wbElemPriceMaxTarget);
		Thread.sleep(5000);
		mlPP.dragAndDrop(ES.wbElemPriceRangeMin, ES.wbElemPriceMinTarget);
		Thread.sleep(5000);
		if(ES.wbLnkYourSearchTab.getAttribute("class").equalsIgnoreCase("tab active")&&ES.wbElemAppliedCriteriaName.getText().contains("Price"))
		{
			extReport.enterLog("Pass", "Result table is displayed in 'Your search' tab");	
		}
		else
		{
			extReport.enterLog("Fail", "Result table is not displayed in 'Your search' tab");
		}
		extReport.endTest(test);
		softAssert.assertAll();
	}


	/*
	 * @purpose: This function is used for validating Search functionality on ETF Screener page.
	 */
	@Test(priority =18 , enabled= true)
	public void TC_PerformSearch() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_PerformSearch", "This Method will validate search functionality by seraching for a criteria");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbElemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(ES.wbElemSearchCustomCriteriaText,"Search custom criteria");
		fnVerifyElementExistence(ES.wbtxtCriteriaSearchTextBox,"Search box");
		ES.wbtxtCriteriaSearchTextBox.clear();
		ES.wbtxtCriteriaSearchTextBox.sendKeys("Mor");
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbelemSearchResultDropdown);
		fnVerifyElementExistence(ES.wbelemSearchResultDropdown,"Search Result Dropdown");
		List<WebElement> dropdownOptions = new ArrayList<WebElement>();
		try
		{
			dropdownOptions = ES.wbelemSearchResultDropdown.findElements(By.tagName("li"));
			for(WebElement e : dropdownOptions)
			{
				fnVerifyElementExistence(e,e.getText());
				if(e.getText().contains("Mor"))
				{
					extReport.enterLog("Pass", "Result containing Searched keyword 'Mor' is returned.");
				}
				else 
				{
					extReport.enterLog("Fail", "Irrelevant results are returned for the search operation");
				}
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		ES.wbtxtCriteriaSearchTextBox.clear();
		ES.wbtxtCriteriaSearchTextBox.sendKeys("abc");
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbelemEmptyMessage);
		fnVerifyElementExistenceWithText(ES.wbelemEmptyMessage,"No results found");			
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Custom Criteria Verification on ETF Screener page.
	 */
	@Test(priority =19 , enabled= true)
	public void TC_CustomCriteriaVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_CustomCriteriaVerification", "This Method will verify the composition of all Custom criteria");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbElemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(ES.wbElemBasicCriteriaText,"Basic criteria");
		verifySubOptions(ES.wbElemBasicCriteriaText);
		fnVerifyElementExistenceWithText(ES.wbElemRatingsText,"Ratings");
		verifySubOptions(ES.wbElemRatingsText);
		fnVerifyElementExistenceWithText(ES.wbElemPerformanceText,"Performance");
		verifySubOptions(ES.wbElemPerformanceText);
		fnVerifyElementExistenceWithText(ES.wbElemPortfolioText,"Portfolio");
		verifySubOptions(ES.wbElemPortfolioText);
		fnVerifyElementExistenceWithText(ES.wbElemManagementFeesText,"Management & fees");
		verifySubOptions(ES.wbElemManagementFeesText);
		fnVerifyElementExistenceWithText(ES.wbElemRiskText,"Risk");
		verifySubOptions(ES.wbElemRiskText);
		fnVerifyElementExistenceWithText(ES.wbElemDistributionsText,"Distributions");
		verifySubOptions(ES.wbElemDistributionsText);
		fnVerifyElementExistenceWithText(ES.wbElemSavedScreensText,"Saved screens");
		verifySubOptions(ES.wbElemSavedScreensText);
		extReport.endTest(test);
		softAssert.assertAll();
	}

	/*
	 * @purpose: This function is used for validating Default sorting of Results table on ETF Screener page.
	 */
	@Test(priority =20 , enabled= true)
	public void TC_DefaultSortVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_DefaultSortVerification", "This Method will verify the Default sorting of ETF Screener");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbTableResult);
		extReport.enterLog("info", "Checking symbols in table"); 
		List<WebElement> rows = ES.wbTableResults.findElements(By.tagName("tr"));
		List<String> symbols = new ArrayList<String>();
		boolean flag=false;
		for(int i=1;i<rows.size()+1;i++)
		{

			symbols.add(driver.findElement(By.xpath("//tr["+i+"]/td[2]/div/div[1]/strong/a")).getText());			
		}
		String symbolString="";
		for(int i=0;i<symbols.size()-1;i++)
		{
			if(symbols.get(i).compareTo(symbols.get(i+1))>0)
			{
				flag = true;
			}
			symbolString=symbolString.concat(symbols.get(i));
			if(i!=48)
			{
				symbolString=symbolString+",";
			}
		}
		extReport.enterLog("info", "Values in 'Symbol' column are : "+symbolString);

		if (flag == true)
		{
			extReport.enterLog("FAIL", "Symbols not sorted in ascending order by symbol ");
		}
		else
		{
			extReport.enterLog("Pass", "Symbols sorted in ascending order by symbol ");
		}		
		extReport.endTest(test);
		softAssert.assertAll();
	}


	/*
	 * @purpose: This function is used for validating Overall criteria fit sorting on ETF Screener page.
	 */
	@Test(priority =21 , enabled= true)
	public void TC_OverallCriteriaFitVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_OverallCriteriaFitVerification", "This Method will validate 'Overall Criteria Fit' view in Your search tab after applying a custom criteria");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbElemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(ES.wbElemSearchCustomCriteriaText,"Search custom criteria");
		//Adding more criteria to the screen
		extReport.enterLog("info", "Adding adding additional criteria");
		fnVerifyElementExistenceWithText(ES.wbElemPerformanceText,"Performance");
		fnVerifyElementExistenceWithText(ES.wbElemAITRRangeText,"Average annual total return");
		extReport.enterLog("info", "Adding Average annual total return as a criteria");
		fnClick(ES.wbElemClosePriceRange);
		Thread.sleep(3000);
		fnClick(ES.wbElemCloseHealthcare);
		Thread.sleep(3000);
		mlPP.dragAndDrop(ES.wbElemAITRRangeMax, ES.wbElemAITRMaxTarget);
		Thread.sleep(5000);
		mlPP.dragAndDrop(ES.wbElemAITRRangeMin, ES.wbElemAITRMinTarget);
		Thread.sleep(5000);
		if(ES.wbLnkYourSearchTab.getAttribute("class").equalsIgnoreCase("tab active")&&ES.wbElemIsBlockedCriteria.getText().contains("Average annual total return"))
		{
			extReport.enterLog("Pass", "Result table is displayed in 'Your search' tab");	
		}
		else
		{
			extReport.enterLog("Fail", "Result table is not displayed in 'Your search' tab");
		}
		mlPP.fnWaitTillElementVisible(driver, 30, ES.wbLstSortbyDropdown);
		fnClick(ES.wbLstSortbyDropdown );
		fnClick(ES.wbCriteriaFitOption );
		Thread.sleep(5000);
		String s = driver.findElement(By.xpath(".//*[@id='Mod_CarousalContainer']/div/div[2]/table/tbody/tr/td/table/thead/tr/th[3]/a/div[1]")).getText();
		if(s.contains("Overall criteria fit"))
		{
			extReport.enterLog("Pass", "'Overall Criteria Fit' applied and displayed in the result table");
		}
		else
		{
			extReport.enterLog("Fail", "'Overall Criteria Fit' not displayed in the result table");
		}
		extReport.enterLog("info", "Checking sorting when overall criteria fit is applied");
		List<WebElement> rows = ES.wbTableResults.findElements(By.tagName("tr"));
		List<String> CriteriaFitValue = new ArrayList<String>();
		boolean flag=false;
		for(int i=1;i<rows.size()+1;i++)
		{
			CriteriaFitValue.add(driver.findElement(By.xpath("//tr["+i+"]/td[3]/div")).getText());			
		}
		String orderString="";
		for(int i=0;i<CriteriaFitValue.size()-1;i++)
		{
			if(Integer.parseInt(CriteriaFitValue.get(i))<Integer.parseInt(CriteriaFitValue.get(i+1)))
			{
				flag = true;
			}
			orderString=orderString.concat(CriteriaFitValue.get(i));
			if(i!=48)
			{
				orderString=orderString+",";
			}
		}
		extReport.enterLog("info", "Values in 'Overall criteria fit' column are : "+orderString);
		if (flag == true)
		{
			extReport.enterLog("FAIL", "Result not sorted in descending order by 'Overall criteria fit' ");
		}
		else
		{
			extReport.enterLog("Pass", "Result sorted in descending order by 'Overall criteria fit' ");
		}
		mlPP.actMouseOver(ES.wbToolTip);
		fnVerifyElementExistenceWithText(ES.wbCriteriaFitMessage, "Overall Criteria Fit"+"\n"+"Funds are sorted algorithmically for your convenience. Matching funds are sorted by the best matches for each of your filter selections.");
		extReport.endTest(test);
		softAssert.assertAll();
	}


	/*
	 * @purpose: This function is used for validating sub options under various Predefined Screens on ETF Screener page.
	 */
	public void verifySubOptions(WebElement e)
	{
		System.out.println(e.findElement(By.xpath("ancestor::div[@class='toggle heading clearfix']")).findElement(By.xpath("ancestor::div[1]")).getAttribute("class"));
		if(!(e.findElement(By.xpath("ancestor::div[@class='toggle heading clearfix']")).findElement(By.xpath("ancestor::div[1]")).getAttribute("class").contains("active")))
		{
			fnClick(e);
		}
		WebElement element= e.findElement(By.xpath("ancestor::div[@class='toggle heading clearfix']")).findElement(By.xpath("following-sibling::div[@class='fields']"));
		extReport.enterLog("INFO", "Checking sub options");
		List<WebElement> l1 = element.findElements(By.xpath(".//div[@class='field']"));
		for(WebElement subFields : l1)
		{
			WebElement ele = subFields.findElement(By.xpath(".//div[1]/div[@class='title-text']"));
			fnVerifyElementExistence(ele,ele.getText());
			fnClick(ele);
		}
	}


	@AfterClass
	public void quit() {
		fnClick(ES.wbLnkLogout);
		driver.quit();
		extent.endTest(parent);
	}

}

