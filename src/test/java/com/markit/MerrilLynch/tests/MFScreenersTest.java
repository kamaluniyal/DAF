
package com.markit.MerrilLynch.tests;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.MerrilLynch.pages.MFScreeners;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
public class MFScreenersTest extends MerrilLynchProductTest{
	/*
	 *
	 * @author: Rahul Tiwari
	 * @purpose: This class contains all the regression scenarios of MF screeners module.
	 * @creation date: 12/05/2016
	 *
	 */
	PropertyReader prop;
	GlobalDriver gDriver;
	MFScreeners MFS;
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
		MFS = new MFScreeners(driver);
		parent = extent.startTest("MF Screeners");
	}
	/*
	 * @purpose: This function is used for initialising assertions before each test method.
	 */
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens section on MF Screener page.
	 */

	@Test(priority =0)
	public void TC_VerificationOfPredefinedScreensOnLeftPanel() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensOnLeftPanel", "This Method will verify Predefined Screens On Left Panel for MF Screeners");
		parent.appendChild(test);
		mlPP.actMouseOver(mlPP.wblnkResearch);		
		mlPP.fnWaitTillElementEnable(driver, 30, MFS.wblnkMFScreenerLink);
		fnClick(MFS.wblnkMFScreenerLink);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wblnkMFScreenerTab);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");
		fnClick(MFS.wbelemPredefinedScreens);
		fnVerifyElementExistenceWithText(MFS.wbelemNoLoadOption,"No load, no transaction fee funds");
		fnVerifyElementExistenceWithText(MFS.wbelemTargetDateOption,"Target date funds");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Option,"Morningstar 5 star rated funds");
		fnVerifyElementExistenceWithText(MFS.wbelemTargetAllocationOption,"Target allocation funds");
		fnVerifyElementExistenceWithText(MFS.wbelemIndexOption,"Index funds");
		fnVerifyElementExistenceWithText(MFS.wbelemRetirementOption,"Retirement income funds");
		fnVerifyElementExistenceWithText(MFS.wbelemPortfolioOption,"Portfolio building blocks");
		fnVerifyElementExistenceWithText(MFS.wbelemSociallyRespOption,"Socially responsible funds");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar4Option,"Morningstar 4 and 5-star rated tax-free funds");
		fnVerifyElementExistenceWithText(MFS.wbelemHighPayingOption,"High-paying dividend funds");
		fnVerifyElementExistenceWithText(MFS.wbelemInflationOption,"Inflation aware funds");
		fnVerifyElementExistenceWithText(MFS.wbelemTopPerformingOption,"Top-performing international funds");
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthOption,"Growth funds");
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens results on MF Screener page.
	 */
	@Test(priority =1 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResults() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResults", "This Method will verify Predefined Screens results for MF Screeners");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Option,"Morningstar 5 star rated funds");
		fnClick(MFS.wbelemMorningStar5Option);
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Description,"Mutual funds rated 5 stars overall by Morningstar");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5View,"View");
		fnClick(MFS.wbelemMorningStar5View);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbHeaderMorningStar);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemMorningStar5Option.getText()+":");
		Thread.sleep(5000);
		fnClick(MFS.wbelemMorningStar5Option);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Composition of Predefined Screens on MF Screener page.
	 */
	@Test(priority =2 , enabled= true)
	public void TC_ComposingScreens() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_ComposingScreens", "This Method will validate composition of Predefined Screens for MF Screeners");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Option,"Morningstar 5 star rated funds");
		fnClick(MFS.wbelemMorningStar5Option);
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Option,"Morningstar 5 star rated funds");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Description,"Mutual funds rated 5 stars overall by Morningstar");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5View,"View");
		fnClick(MFS.wbelemMorningStar5View);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking Applied criteria before adding additional criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemMorningStar5Option.getText()+":");
		//verifying criterias before adding criteria
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar rating overall: Rated 5 Star");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Status: Open to new investors");
		//Adding more criteria to the screen
		extReport.enterLog("info", "adding additional criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemBasicCriteriaText,"Basic criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemLoadPercentageText,"Load percentage");
		extReport.enterLog("info", "Adding price range as a criteria");
		fnClick(MFS.wbelemLoadPercentageText);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMax, MFS.wbelemLoadPercentageMaxTarget);
		Thread.sleep(5000);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMin, MFS.wbelemLoadPercentageMinTarget);
		Thread.sleep(5000);
		//verifying criterias after adding criteria
		extReport.enterLog("info", "Checking Applied criteria after adding additional criteria");
		fnVerifyElementExistence(MFS.wbelem1stCriteria,MFS.wbelem1stCriteria.getText());
		fnVerifyElementExistence(MFS.wbelem2ndCriteria,MFS.wbelem2ndCriteria.getText());
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemCloseLoadPercentage1);
		Thread.sleep(5000);
		fnClick(MFS.wbelemCloseMorning5);
		Thread.sleep(5000);
		fnClick(MFS.wbelemMorningStar5Option);
		extReport.enterLog("info", "Added Criteria Removed");
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for MorningStar Funds on MF Screener page.
	 */
	@Test(priority =3 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsMorningStar5() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsMorningStar", "This Method will verify Predefined Screens results for Morning Star criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Option,"Morningstar 5 star rated funds");
		fnClick(MFS.wbelemMorningStar5Option);
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Option,"Morningstar 5 star rated funds");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5Description,"Mutual funds rated 5 stars overall by Morningstar");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar5View,"View");
		fnClick(MFS.wbelemMorningStar5View);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemMorningStar5Option.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar rating overall: Rated 5 Star");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemMorningStar5Option);	
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for No Load Funds on MF Screener page.
	 */
	@Test(priority =4 , enabled= true)
	public void TC_VerificationOfPredefinedScreensNoLoadFunds() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensNoLoadFunds", "This Method will verify Predefined Screens results for No Load Funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemNoLoadOption,"No load, no transaction fee funds");
		fnClick(MFS.wbelemNoLoadOption);
		fnVerifyElementExistenceWithText(MFS.wbelemNoLoadOption,"No load, no transaction fee funds");
		fnVerifyElementExistenceWithText(MFS.wbelemNoLoadDescritpion,"Mutual funds with no front- or back-end sales load, no transaction fee for purchases or sales, and an expense ratio less than .5%");
		fnVerifyElementExistenceWithText(MFS.wbelemNoLoadView,"View");
		fnClick(MFS.wbelemNoLoadView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemNoLoadOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Gross expense ratio: Less than 0.5");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Load type: No Load");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Status: Open to new investors");
		fnVerifyElementExistenceWithText(MFS.wbelem4thCriteria,"Transaction fee: No");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemNoLoadOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for target Funds on MF Screener page.
	 */
	@Test(priority =5 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsTargetDateFunds() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsTargetDateFunds", "This Method will verify Predefined Screens results for Target Date Funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemTargetDateOption,"Target date funds");
		fnClick(MFS.wbelemTargetDateOption);
		fnVerifyElementExistenceWithText(MFS.wbelemTargetDateOption,"Target date funds");
		fnVerifyElementExistenceWithText(MFS.wbelemTargetDateDescription,"Mutual funds that gradually move from an aggressive to a conservative portfolio allocation as the investor approaches the maturity date of the fund");
		fnVerifyElementExistenceWithText(MFS.wbelemTargetDateView,"View");
		fnClick(MFS.wbelemTargetDateView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemTargetDateOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar asset class: Allocation");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar category: Target-Date 2000-2010, Target-Date 2015, Target-Date 2020, Target-Date 2025, Target-Date 2030, Target-Date 2035, Target-Date 2040, Target-Date 2045, Target-Date 2050, Target-Date 2055");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Load type: No Load");
		fnVerifyElementExistenceWithText(MFS.wbelem4thCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemTargetDateOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Target allocation Funds on MF Screener page.
	 */
	@Test(priority =6 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsTargetAllocation() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsTargetAllocation", "This Method will verify Predefined Screens results for Target Allocation criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemTargetAllocationOption,"Target allocation funds");
		fnClick(MFS.wbelemTargetAllocationOption);
		fnVerifyElementExistenceWithText(MFS.wbelemTargetAllocationOption,"Target allocation funds");
		fnVerifyElementExistenceWithText(MFS.wbelemTargetAllocationDescription,"Mutual funds designed to retain an aggressive, moderate or conservative allocation based on the fund’s individual holdings");
		fnVerifyElementExistenceWithText(MFS.wbelemTargetAllocationView,"View");
		fnClick(MFS.wbelemTargetAllocationView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemTargetAllocationOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar category: Allocation--50% to 70% Equity");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Fund objective: Mixed-Asset Target Alloc Consv Funds,Mixed-Asset Target Alloc Growth Funds,Mixed-Asset Target Alloc Moderate Funds");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Load type: No Load");
		fnVerifyElementExistenceWithText(MFS.wbelem4thCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemTargetAllocationOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Index Funds on MF Screener page.
	 */
	@Test(priority =7 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsIndexFunds() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsIndexFunds", "This Method will verify Predefined Screens results for Index Funds criteria");
		parent.appendChild(test);		
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemIndexOption,"Index funds");
		fnClick(MFS.wbelemIndexOption);
		fnVerifyElementExistenceWithText(MFS.wbelemIndexOption,"Index funds");
		fnVerifyElementExistenceWithText(MFS.wbelemIndexDescription,"Mutual funds with portfolios designed to match closely or track a specific market index");
		fnVerifyElementExistenceWithText(MFS.wbelemIndexView,"View");
		fnClick(MFS.wbelemIndexView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemIndexOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Passively managed: Yes");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemIndexOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Retirements Funds on MF Screener page.
	 */
	@Test(priority =8 , enabled= true)
	public void TC_VerificationOfPredefinedScreensRetirements() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensRetirements", "This Method will verify Predefined Screens results for Retirements Funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemRetirementOption,"Retirement income funds");
		fnClick(MFS.wbelemRetirementOption);
		fnVerifyElementExistenceWithText(MFS.wbelemRetirementOption,"Retirement income funds");
		fnVerifyElementExistenceWithText(MFS.wbelemRetirementDescription,"Mutual funds that Morningstar classify as retirement income");
		fnVerifyElementExistenceWithText(MFS.wbelemRetirementView,"View");
		fnClick(MFS.wbelemRetirementView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemRetirementOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar category: Target-Date Retirement");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar asset class: Allocation");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemRetirementOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Portfolio Funds on MF Screener page.
	 */
	@Test(priority =9, enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsPortfolio() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsPortfolio", "This Method will verify Predefined Screens results for Portfolio building blocks criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemPortfolioOption,"Portfolio building blocks");
		fnClick(MFS.wbelemPortfolioOption);
		fnVerifyElementExistenceWithText(MFS.wbelemPortfolioOption,"Portfolio building blocks");
		fnVerifyElementExistenceWithText(MFS.wbelemPortfolioDescription,"Mutual funds that Morningstar classify as mid-cap blend for both equity and bond styles");
		fnVerifyElementExistenceWithText(MFS.wbelemPortfolioView,"View");
		fnClick(MFS.wbelemPortfolioView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemPortfolioOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar equity style: Mid Blend");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar bond style: Mid Mod");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemPortfolioView);	
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Socially Responsible Funds on MF Screener page.
	 */
	@Test(priority =10 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsSociallyResponsibleFunds() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsSociallyResponsibleFunds", "This Method will verify Predefined Screens results for Socially responsible funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemSociallyRespOption,"Socially responsible funds");
		fnClick(MFS.wbelemSociallyRespOption);
		fnVerifyElementExistenceWithText(MFS.wbelemSociallyRespOption,"Socially responsible funds");
		fnVerifyElementExistenceWithText(MFS.wbelemSociallyRespDescription,"Mutual funds that invest in companies with strong environmental, social and corporate governance policies (also known as ESG investments)");
		fnVerifyElementExistenceWithText(MFS.wbelemSociallyRespView,"View");
		fnClick(MFS.wbelemSociallyRespView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemSociallyRespOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Is socially conscious: Yes");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemSociallyRespOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for MorningStar 4 Funds on MF Screener page.
	 */
	@Test(priority =11 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsMorningStar4() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsMorningStar4", "This Method will verify Predefined Screens results for Morningstar 4 and 5-star rated tax-free funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar4Option,"Morningstar 4 and 5-star rated tax-free funds");
		fnClick(MFS.wbelemMorningStar4Option);
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar4Option,"Morningstar 4 and 5-star rated tax-free funds");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar4Description,"Mutual funds with municipal bond portfolios rated 4 or 5 stars by Morningstar");
		fnVerifyElementExistenceWithText(MFS.wbelemMorningStar4View,"View");
		fnClick(MFS.wbelemMorningStar4View);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemMorningStar4Option.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar rating overall: Rated 4 or 5 Star");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar asset class: Municipal Bond");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemMorningStar4Option);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for High Paying Dividends Funds on MF Screener page.
	 */
	@Test(priority =12 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsHighPayingDividends() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsHighPayingDividends", "This Method will verify Predefined Screens results for High-paying dividend funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemHighPayingOption,"High-paying dividend funds");
		fnClick(MFS.wbelemHighPayingOption);
		fnVerifyElementExistenceWithText(MFS.wbelemHighPayingOption,"High-paying dividend funds");
		fnVerifyElementExistenceWithText(MFS.wbelemHighPayingDescription,"Mutual funds with portfolios composed of U.S. stock investments with dividend yields greater than 3%");
		fnVerifyElementExistenceWithText(MFS.wbelemHighPayingView,"View");
		fnClick(MFS.wbelemHighPayingView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemHighPayingOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Dividend yield (TTM): Greater than 3%");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar category: Large Blend, Large Growth, Large Value, Mid-Cap Blend, Mid-Cap Growth, Mid-Cap Value, Small Blend, Small Growth, Small Value");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Morningstar asset class: U.S. Equity");
		fnVerifyElementExistenceWithText(MFS.wbelem4thCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemHighPayingOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Inflation Aware Funds on MF Screener page.
	 */
	@Test(priority =13 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsInflationAware() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsInflationAware", "This Method will verify Predefined Screens results for Inflation aware funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemInflationOption,"Inflation aware funds");
		fnClick(MFS.wbelemInflationOption);
		fnVerifyElementExistenceWithText(MFS.wbelemInflationOption,"Inflation aware funds");
		fnVerifyElementExistenceWithText(MFS.wbelemInflationDescription,"Mutual funds with taxable-bond portfolios classified as “inflation aware” by Morningstar");
		fnVerifyElementExistenceWithText(MFS.wbelemInflationView,"View");
		fnClick(MFS.wbelemInflationView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemInflationOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar category: Inflation-Protected Bond");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar asset class: Taxable Bond");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemInflationOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Top Performing Funds on MF Screener page.
	 */
	@Test(priority =14 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsTopPerforming() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsTopPerforming", "This Method will verify Predefined Screens results for Top-performing international funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemTopPerformingOption,"Top-performing international funds");
		fnClick(MFS.wbelemTopPerformingOption);
		fnVerifyElementExistenceWithText(MFS.wbelemTopPerformingOption,"Top-performing international funds");
		fnVerifyElementExistenceWithText(MFS.wbelemTopPerformingDescription,"Mutual funds with a 3-year average annual total return in the top 20%, a 3-year return in the top 20% for their category, and a 3-year return in the top 20% when compared to their underlying benchmark");
		fnVerifyElementExistenceWithText(MFS.wbelemTopPerformingView,"View");
		fnClick(MFS.wbelemTopPerformingView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemTopPerformingOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Average annual total return non-load adjusted 3 year percentile: Greater than 80");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Return vs. benchmark 3 year percentile: Greater than 80");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Return vs. category non-load adjusted 3 year percentile: Greater than 80");
		fnVerifyElementExistenceWithText(MFS.wbelem4thCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemTopPerformingOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Predefined Screens Results table for Growth Funds on MF Screener page.
	 */
	@Test(priority =15 , enabled= true)
	public void TC_VerificationOfPredefinedScreensResultsGrowtFunds() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_VerificationOfPredefinedScreensResultsGrowthFunds", "This Method will verify Predefined Screens results for Growth funds criteria");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreens,"Pre-defined screens");		
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthOption,"Growth funds");
		fnClick(MFS.wbelemGrowthOption);
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthOption,"Growth funds");
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthDescription,"Mutual funds with portfolios composed of U.S. and international growth stocks");
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthView,"View");
		fnClick(MFS.wbelemGrowthView);
		Thread.sleep(7000);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemGrowthOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar category: Foreign Large Growth, Foreign Small/Mid Growth, Large Growth, Mid-Cap Growth, Small Growth");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar asset class: International Equity, U.S. Equity");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Status: Open to new investors");
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		fnClick(MFS.wbelemGrowthOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Search of Custom Criteria MF Screener page.
	 */
	@Test(priority =16 , enabled= true)
	public void TC_SearchCustomCriteriaVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_SearchCustomCriteriaVerification", "This Method will validate search custom criteria module");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbelemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(MFS.wbelemSearchCustomCriteriaText,"Search custom criteria");
		fnVerifyElementExistence(MFS.wbtxtCriteriaSearchTextBox,"Search box");
		extReport.enterLog("info", "Verifying watermark in search box ");
		if(MFS.wbtxtCriteriaSearchTextBox.getAttribute("value").equalsIgnoreCase("Enter criteria name"))
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
	 * @purpose: This function is used for validating Search section on MF Screener page.
	 */
	@Test(priority =17 , enabled= true)
	public void TC_YourSearchVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_YourSearchVerification", "This Method will validate Your search tab after applying a custom criteria");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbelemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(MFS.wbelemSearchCustomCriteriaText,"Search custom criteria");
		//Adding more criteria to the screen
		extReport.enterLog("info", "adding additional criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemBasicCriteriaText,"Basic criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemLoadPercentageText,"Load percentage");
		extReport.enterLog("info", "Adding Load percentage as a criteria");
		fnClick(MFS.wbelemLoadPercentageText);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMax, MFS.wbelemLoadPercentageMaxTarget);
		Thread.sleep(5000);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMin, MFS.wbelemLoadPercentageMinTarget);
		Thread.sleep(5000);
		if(MFS.wblnkYourSearchTab.getAttribute("class").equalsIgnoreCase("tab active")&&MFS.wbelemAppliedCriteriaName.getText().contains("Load"))
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
	 * @purpose: This function is used for validating Search functionality on MF Screener page.
	 */
	@Test(priority =18 , enabled= true)
	public void TC_PerformSearch() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_PerformSearch", "This Method will validate search functionality by seraching for a criteria");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbelemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(MFS.wbelemSearchCustomCriteriaText,"Search custom criteria");
		fnVerifyElementExistence(MFS.wbtxtCriteriaSearchTextBox,"Search box");
		MFS.wbtxtCriteriaSearchTextBox.clear();
		MFS.wbtxtCriteriaSearchTextBox.sendKeys("Mor");
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbelemSearchResultDropdown);
		fnVerifyElementExistence(MFS.wbelemSearchResultDropdown,"Search Result Dropdown");
		List<WebElement> dropdownOptions = new ArrayList<WebElement>();
		try
		{
			dropdownOptions = MFS.wbelemSearchResultDropdown.findElements(By.tagName("li"));
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
		MFS.wbtxtCriteriaSearchTextBox.clear();
		MFS.wbtxtCriteriaSearchTextBox.sendKeys("abc");
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbelemEmptyMessage);
		fnVerifyElementExistenceWithText(MFS.wbelemEmptyMessage,"No results found");			
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Search of Custom Criteria on Mutual fund Screener page.
	 */
	@Test(priority =19 , enabled= true)
	public void TC_CustomCriteriaVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_CustomCriteriaVerification", "This Method will verify the composition of all Custom criteria");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbelemSearchCustomCriteriaText);
		fnVerifyElementExistenceWithText(MFS.wbelemBasicCriteriaText,"Basic criteria");
		verifySubOptions(MFS.wbelemBasicCriteriaText);
		fnVerifyElementExistenceWithText(MFS.wbelemRatingsText,"Ratings");
		verifySubOptions(MFS.wbelemRatingsText);
		fnVerifyElementExistenceWithText(MFS.wbelemPerformanceText,"Performance");
		verifySubOptions(MFS.wbelemPerformanceText);
		fnVerifyElementExistenceWithText(MFS.wbelemPortfolioText,"Portfolio");
		verifySubOptions(MFS.wbelemPortfolioText);
		fnVerifyElementExistenceWithText(MFS.wbelemManagementFeesText,"Management & fees");
		verifySubOptions(MFS.wbelemManagementFeesText);
		fnVerifyElementExistenceWithText(MFS.wbelemRiskText,"Risk");
		verifySubOptions(MFS.wbelemRiskText);
		fnVerifyElementExistenceWithText(MFS.wbelemDistributionsText,"Distributions");
		verifySubOptions(MFS.wbelemDistributionsText);
		fnVerifyElementExistenceWithText(MFS.wbelemSavedScreensText,"Saved screens");
		verifySubOptions(MFS.wbelemSavedScreensText);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Composition of Selected Screens on Mutual fund Screener page.
	 */
	@Test(priority =20 , enabled= true)
	public void TC_ComposingSelectedScreens() throws InterruptedException {
		ExtentTest test = extReport.startTest("TC_ComposingSelectedScreens", "This Method will validate composition of Predefined Screens");
		parent.appendChild(test);
		fnVerifyElementExistenceWithText(MFS.wblnkMFScreenerTab,"Mutual Funds Screener");
		fnVerifyElementExistence(MFS.wbelemPredefinedScreens,"Pre-defined screens arrow");
		fnVerifyElementExistenceWithText(MFS.wbelemPredefinedScreensLabel,"Pre-defined screens");
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthOption,"Growth funds");
		fnClick(MFS.wbelemGrowthOption);
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthOption,"Growth funds");
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthDescription,"Mutual funds with portfolios composed of U.S. and international growth stocks");
		fnVerifyElementExistenceWithText(MFS.wbelemGrowthView,"View");
		fnClick(MFS.wbelemGrowthView);
		Thread.sleep(7000);
		fnVerifyElementExistence(MFS.wbTableResult,"Pre-defined screener Result Table");
		fnVerifyElementExistence(MFS.wbelemResultCount,MFS.wbelemResultCount.getText()+" results matching");	
		extReport.enterLog("info", "Checking Applied criteria before adding additional criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemGrowthOption.getText()+":");
		extReport.enterLog("info", "Checking criteria Applied");
		fnVerifyElementExistenceWithText(MFS.wbelemAppliedCriteria,"Pre-defined screen - "+MFS.wbelemGrowthOption.getText()+":");
		fnVerifyElementExistenceWithText(MFS.wbelem1stCriteria,"Morningstar category: Foreign Large Growth, Foreign Small/Mid Growth, Large Growth, Mid-Cap Growth, Small Growth");
		fnVerifyElementExistenceWithText(MFS.wbelem2ndCriteria,"Morningstar asset class: International Equity, U.S. Equity");
		fnVerifyElementExistenceWithText(MFS.wbelem3rdCriteria,"Status: Open to new investors");
		//Adding more criteria to the screen
		extReport.enterLog("info", "adding additional criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemBasicCriteriaText,"Basic criteria");
		fnVerifyElementExistenceWithText(MFS.wbelemLoadPercentageText,"Load percentage");
		extReport.enterLog("info", "Adding Load percentage as a criteria");
		fnClick(MFS.wbelemLoadPercentageText);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMax, MFS.wbelemLoadPercentageMaxTarget);
		Thread.sleep(5000);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMin, MFS.wbelemLoadPercentageMinTarget);
		Thread.sleep(5000);
		//verifying criterias after adding criteria
		extReport.enterLog("info", "Checking Applied criteria after adding additional criteria");

		fnVerifyElementExistence(MFS.wbelem1stCriteria1,MFS.wbelem1stCriteria1.getText());
		fnVerifyElementExistence(MFS.wbelem1stCriteria,MFS.wbelem1stCriteria.getText());
		fnVerifyElementExistence(MFS.wbelem2ndCriteria,MFS.wbelem2ndCriteria.getText());
		extReport.enterLog("info", "Verifying count of results displayed");
		fnVerifyElementExistence(MFS.wbelemCountDisplayed,MFS.wbelemCountDisplayed.getText()+ " in result table");
		fnVerifyElementExistence(MFS.wbelemCountMatched,MFS.wbelemCountMatched.getText()+ " Matching results");
		try
		{
			if(Integer.parseInt(MFS.wbelemCountMatched.getText())>=Integer.parseInt(MFS.wbelemCountDisplayed.getText()))
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
		extReport.enterLog("info", "Removing criteria");
		fnClick(MFS.wbelemCloseLoadPercentage);
		Thread.sleep(3000);
		if(driver.findElements(By.xpath("//thead/tr/th[4]/a/div[1]")).size()==0)
		{
			extReport.enterLog("info", "Criteria is Removed");
		}


		fnClick(MFS.wbelemGrowthOption);
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function is used for validating Default sorting of Results table on Mutual fund Screener page.
	 */
	@Test(priority =21 , enabled= true)
	public void TC_DefaultSortVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_DefaultSortVerification", "This Method will verify the Default sorting of ETF Screener");
		parent.appendChild(test);
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbTableResult);
		extReport.enterLog("info", "Checking symbols in table"); 
		List<WebElement> rows = MFS.wbTableResults.findElements(By.tagName("tr"));
		List<String> symbols = new ArrayList<String>();
		boolean flag=false;
		for(int i=1;i<rows.size()+1;i++)
		{
			WebElement el = null ;
			try
			{
				 el = driver.findElement(By.xpath("//tr["+i+"]/td[2]/div/div[1]/strong/a"));
				symbols.add(el.getText());
			}
			catch(Exception e)
			{
				if(e.getMessage().contains("stale element"))
				{
					symbols.add(el.getText());
				}
			}
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
	 * @purpose: This function is used for validating Overall criteria fit sorting on Mutual fund Screener page.
	 */
	@Test(priority =22 , enabled= true)
	public void TC_OverallCriteriaFitVerification() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_OverallCriteriaFitVerification", "This Method will validate 'Overall Criteria Fit' view in Your search tab after applying a custom criteria");
		parent.appendChild(test);
		fnClick(MFS.wblnkMFScreenerTab);
		mlPP.fnWaitTillElementEnable(driver, 30, MFS.wbelemCloseRestorePopup);
		fnClick(MFS.wbelemCloseRestorePopup);
		//Adding more criteria to the screen
		extReport.enterLog("info", "adding additional criteria");

		fnVerifyElementExistenceWithText(MFS.wbelemLoadPercentageText,"Load percentage");
		extReport.enterLog("info", "Adding Load percentage as a criteria");

		fnClick(MFS.wbelemLoadPercentageText);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMax, MFS.wbelemLoadPercentageMaxTarget);
		Thread.sleep(5000);
		mlPP.dragAndDrop(MFS.wbelemLoadPercentageMin, MFS.wbelemLoadPercentageMinTarget);
		Thread.sleep(5000);
		if(MFS.wblnkYourSearchTab.getAttribute("class").equalsIgnoreCase("tab active")&&MFS.wbelem1stCriteria.getText().contains("Load percentage"))
		{
			extReport.enterLog("Pass", "Result table is displayed in 'Your search' tab");	
		}
		else
		{
			extReport.enterLog("Fail", "Result table is not displayed in 'Your search' tab");
		}
		mlPP.fnWaitTillElementVisible(driver, 30, MFS.wbLstSortbyDropdown);
		fnClick(MFS.wbLstSortbyDropdown );
		fnClick(MFS.wbCriteriaFitOption );
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
		List<WebElement> rows = MFS.wbTableResults.findElements(By.tagName("tr"));
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
		mlPP.actMouseOver(MFS.wbToolTip);
		fnVerifyElementExistenceWithText(MFS.wbCriteriaFitMessage, "Overall Criteria Fit"+"\n"+"Funds are sorted algorithmically for your convenience. Matching funds are sorted by the best matches for each of your filter selections.");
		extReport.endTest(test);
		softAssert.assertAll();
	}
	/*
	 * @purpose: This function  will validate result table for 'Load Adjusted Total Annual Return' in Your search tab on Mutual fund Screener page.
	 */
	@Test(priority =23 , enabled= true)
	public void TC_PerformanceAnnualTotalReturnLoadAdjusted() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_PerformanceAnnualTotalReturnLoadAdjusted", "This Method will validate result table for 'Load Adjusted Total Annual Return' in Your search tab");
		parent.appendChild(test);
		fnClick(MFS.wblnkMFScreenerTab);
		mlPP.fnWaitTillElementEnable(driver, 30, MFS.wbelemCloseRestorePopup);
		fnClick(MFS.wbelemCloseRestorePopup);
		//Adding more criteria to the screen
		extReport.enterLog("info", "Adding additional criteria");
		fnClick(MFS.wbelemPerformanceText);
		fnVerifyElementExistenceWithText(MFS.wbelemAverageAnnualTotalReturnLoadAdjusted, "Average annual total return"+"\n"+"(load adjusted)");
		fnClick(MFS.wbelemAverageAnnualTotalReturnLoadAdjusted);
		WebElement element= MFS.wbelemAverageAnnualTotalReturnLoadAdjusted.findElement(By.xpath("ancestor::div[@class='field active']"));
		List<WebElement> l1 = element.findElements(By.xpath(".//div[@class='filter histograms']"));

		for(WebElement subFields : l1)
		{
			extReport.enterLog("info", "Verifying filter attributes");
			try
			{
				WebElement sectionHeader = subFields.findElement(By.xpath(".//*[@class='sectionHeader']"));
				WebElement displayName = subFields.findElement(By.xpath(".//div[@class='display-name']"));
				fnVerifyElementExistence(sectionHeader,sectionHeader.getText());
				fnVerifyElementExistence(displayName,displayName.getText());
				WebElement slider = subFields.findElement(By.xpath("following-sibling::div[1]"));
				WebElement sliderName=slider.findElement(By.xpath(".//div[@class='display-name']"));
				fnVerifyElementExistence(sliderName,sliderName.getText());
				WebElement sliderRangeMin = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[22]"));
				fnVerifyElementExistence(sliderRangeMin,sliderRangeMin.getText()+ "displayed as Min label");
				WebElement sliderRangeMax = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[2]"));
				fnVerifyElementExistence(sliderRangeMax,sliderRangeMax.getText()+ "displayed as Max label");
				WebElement sliderMax = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[24]"));
				WebElement sliderMin = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[23]"));
				WebElement targetMin = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[18]"));
				WebElement targetMax = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[6]"));
				extReport.enterLog("info", "Applying criteria for "+sectionHeader.getText());
				mlPP.dragAndDrop(sliderMax, targetMax);
				Thread.sleep(3000);
				mlPP.dragAndDrop(sliderMin, targetMin);
				Thread.sleep(3000);
				if(MFS.wblnkYourSearchTab.getAttribute("class").equalsIgnoreCase("tab active")&&MFS.wbelem1stCriteria.getText().contains(sectionHeader.getText()))
				{
					extReport.enterLog("Pass", "Result table is displayed in 'Your search' tab and "+sectionHeader.getText()+" column is displayed in table");	
				}
				else
				{
					extReport.enterLog("Fail", "Result table is not displayed in 'Your search' tab");
				}

				fnClick(MFS.wbelemRemoveFilter);
				Thread.sleep(7000);
				fnClick(MFS.wbelemAverageAnnualTotalReturnLoadAdjusted);
				
			}
			catch(Exception e)
			{
				if(e.getMessage().contains("stale element"))
				{
					extReport.enterLog("fail", "stale element execption occured , aborting further execution for this test case");
				}
			}
		}




		extReport.endTest(test);
		softAssert.assertAll();
	}	

	/*
	 * @purpose: This function  will validate result table for 'Load Adjusted Total Annual Return' in Your search tab on Mutual fund Screener page.
	 */
	@Test(priority =24 , enabled= true)
	public void TC_PerformanceAnnualTotalReturnLoadNotAdjusted() throws InterruptedException 
	{
		ExtentTest test = extReport.startTest("TC_PerformanceAnnualTotalReturnLoadNotAdjusted", "This Method will validate result table for 'Non Load Adjusted Total Annual Return' in Your search tab");
		parent.appendChild(test);
		fnClick(MFS.wblnkMFScreenerTab);
		mlPP.fnWaitTillElementEnable(driver, 30, MFS.wbelemCloseRestorePopup);
		fnClick(MFS.wbelemCloseRestorePopup);
		//Adding more criteria to the screen
		extReport.enterLog("info", "Adding additional criteria");
		fnClick(MFS.wbelemPerformanceText);
		fnVerifyElementExistenceWithText(MFS.wbelemAverageAnnualTotalReturnNonLoadAdjusted, "Average annual total return"+"\n"+"(non-load adjusted)");
		fnClick(MFS.wbelemAverageAnnualTotalReturnNonLoadAdjusted);
		WebElement element= MFS.wbelemAverageAnnualTotalReturnNonLoadAdjusted.findElement(By.xpath("ancestor::div[@class='field active']"));
		List<WebElement> l1 = element.findElements(By.xpath(".//div[@class='filter histograms']"));

		for(WebElement subFields : l1)
		{
			extReport.enterLog("info", "Verifying filter attributes");
			try
			{
				WebElement sectionHeader = subFields.findElement(By.xpath(".//*[@class='sectionHeader']"));
				WebElement displayName = subFields.findElement(By.xpath(".//div[@class='display-name']"));
				fnVerifyElementExistence(sectionHeader,sectionHeader.getText());
				fnVerifyElementExistence(displayName,displayName.getText());
				WebElement slider = subFields.findElement(By.xpath("following-sibling::div[1]"));
				WebElement sliderName=slider.findElement(By.xpath(".//div[@class='display-name']"));
				fnVerifyElementExistence(sliderName,sliderName.getText());
				WebElement sliderRangeMin = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[22]"));
				fnVerifyElementExistence(sliderRangeMin,sliderRangeMin.getText()+ "displayed as Min label");
				WebElement sliderRangeMax = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[2]"));
				fnVerifyElementExistence(sliderRangeMax,sliderRangeMax.getText()+ "displayed as Max label");
				WebElement sliderMax = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[24]"));
				WebElement sliderMin = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[23]"));
				WebElement targetMin = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[18]"));
				WebElement targetMax = slider.findElement(By.xpath(".//div[2]/div/div[2]/span[6]"));
				extReport.enterLog("info", "Applying criteria for "+sectionHeader.getText());
				mlPP.dragAndDrop(sliderMax, targetMax);
				Thread.sleep(3000);
				mlPP.dragAndDrop(sliderMin, targetMin);
				Thread.sleep(3000);
				if(MFS.wblnkYourSearchTab.getAttribute("class").equalsIgnoreCase("tab active")&&MFS.wbelem1stCriteria.getText().contains(sectionHeader.getText()))
				{
					extReport.enterLog("Pass", "Result table is displayed in 'Your search' tab and "+sectionHeader.getText()+" column is displayed in table");	
				}
				else
				{
					extReport.enterLog("Fail", "Result table is not displayed in 'Your search' tab");
				}				
				fnClick(MFS.wbelemRemoveFilter);
				Thread.sleep(7000);
				fnClick(MFS.wbelemAverageAnnualTotalReturnNonLoadAdjusted);
			}
			catch(Exception e)
			{
				if(e.getMessage().contains("stale element"))
				{
					extReport.enterLog("fail", "stale element execption occured , aborting further execution for this test case");
				}
			}

		}

		extReport.endTest(test);
		softAssert.assertAll();
	}

	public void verifySubOptions(WebElement e)
	{

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
		fnClick(MFS.wblnkLogout);
		driver.quit();
		extent.endTest(parent);
	}
}
