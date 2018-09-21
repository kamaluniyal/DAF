package com.markit.MerrilLynch.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
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
* @creation date: 3/1/2017
*
*/
public class OptionStrategyBuilderTest extends MerrilLynchProductTest{
	
   
	PropertyReader prop;
	GlobalDriver gDriver;
	OptionStrategyBuilder oSB;
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
		oSB = new OptionStrategyBuilder(driver);
		

		parent = extent.startTest("Option Strategy Builder");
	}
 
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	
	@Test(priority =0)
	public void TC_VerificationOfDefaultUI_OptionStrategyBuilder() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfDefaultUI_OptionStrategyBuilder", "This Method will verify the default UI of the page."); 
	parent.appendChild(test);
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wblnkResearch);
	mlPP.actMouseOver(mlPP.wblnkResearch);
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemOptionStrategyBuilder);
	mlPP.wbelemOptionStrategyBuilder.click();
	
	oSB.fnWaitTillElementVisible(driver, 40, oSB.wbtxtSearchSymbolTextBox);
	
	fnVerifyElementExistence(oSB.wbchkOnlyShowStrategiescurrentlyApproved,"Only Show Strategies currently Approved checkbox");
	fnVerifyElementExistence(oSB.wbchkOnlyShowStrategiesWithOneClickTradeSupport,"Only Show Strategies With One Click Trade Support checkbox");
	fnVerifyElementExistenceWithText(oSB.wbelemOnlyShowStrategiescurrentlyApprovedText,"Only show strategies currently approved");
	fnVerifyElementExistenceWithText(oSB.wbelemOnlyShowStrategiesWithOneClickTradeSupportText,"Only show strategies with one-click trade support");
	fnVerifyElementExistence(oSB.wbtxtSearchSymbolTextBox,"Serach text box");
	fnVerifyElementExistence(oSB.wbbtnGoButton,"Go button");
	
	extReport.endTest(test);softAssert.assertAll();
	
	}
		
		
	@Test(priority = 1,enabled = true)
	public void TC_VerificationOfOneClickTradeSupportLogic_OptionStrategyBuilder() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfOneClickTradeSupportLogic_OptionStrategyBuilder", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	
	oSB.fnCheckCheckbox(oSB.wbchkOnlyShowStrategiesWithOneClickTradeSupport);
	
	List<String> StragiesName = new ArrayList<String>();
	List<String> StragiesNameExpected = new ArrayList<String>();
	String[] strArr = {"Long Call","Long Put","Short Call","Short Put","Bull Call Spread","Bull Put Spread","Bear Call Spread","Bear Put Spread","Calendar Call Spread","Calendar Put Spread","Diagonal Call Spread","Diagonal Put Spread","Long Strangle","Short Strangle"};
	
	try{
	for (int j=0;j<strArr.length;j++){
		StragiesNameExpected.add(strArr[j]);
	}
	
	for(int i=1;i<=14;i++){
		
		String xp = ".//*[@id='cards-table-view']/div["+i+"]/div/h4";
		
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(xp)).getText();
		
		StragiesName.add(str);
	}
	
	
	for(int k=0;k<strArr.length;k++){
		
		if(StragiesName.get(k).equals(StragiesNameExpected.get(k))){
			
			extReport.enterLog("Pass", StragiesName.get(k) + " has been verified successfully.");
		}
			else{
			extReport.enterLog("Fail", StragiesName.get(k) + " has not been verified.");
			
		}
		
	}
	}catch(Exception e){
		extReport.enterLog("Fail", e.toString());
		Log.info(e.toString());
		e.printStackTrace();
		softAssert.assertEquals(true, false, e.toString());
	}
	extReport.endTest(test);softAssert.assertAll();

	}	
	

	@Test(priority =2,enabled = true)
	public void TC_VerificationOfCartWorkflow_OptionStrategyBuilder() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfCartWorkflow_OptionStrategyBuilder", "This Method will verify the existence of several elements under 'Fixed Income ETFs' on the page"); 
	parent.appendChild(test);
	fnVerifyElementExistenceWithText(oSB.wbelemSelectASymbol,"1\nSelect a Symbol");
	
	extReport.enterLog("Info", "Searching for IBm symbol symbol");
	oSB.wbtxtSearchSymbolTextBox.sendKeys("ibm");
	fnClick(oSB.wbbtnGoButton);
	
	Thread.sleep(2000);
	
	fnVerifyElementExistenceWithText(oSB.wblnkSymbolLink,"IBM");
	
	fnVerifyElementExistence(oSB.wbelemMarketPrice,"Market Price for Selected symbol");
	
	fnVerifyElementExistenceWithText(oSB.wbelemSelectAnOptionStrategyText,"2\nSelect an Options Strategy");
	fnClick(oSB.wbelemStrategyToBeSelected);
	Thread.sleep(5000);
	
	if(oSB.wbelemSelectedStrategyText.getText().equals(oSB.wbelemStrategyToBeSelected.getText())){
		
		extReport.enterLog("Pass", oSB.wbelemSelectedStrategyText.getText() + " has been selected successfully.");
	}else{
		extReport.enterLog("Fail", oSB.wbelemSelectedStrategyText.getText() + " has not been selected.");
	}
	
	fnVerifyElementExistence(oSB.wbelemSelectedStrategyScaledDownChart,"Scaled Down chart under selected strategy");
	fnVerifyElementExistenceWithText(oSB.wbelemImpactOfVolatility,"Impact of Volatility");
	fnVerifyElementExistenceWithText(oSB.wbelemOutlookText,"Outlook");
	fnVerifyElementExistence(oSB.wbelemLegsTextOutlookText,"Legs heading under selected strategy");
	fnVerifyElementExistence(oSB.wbelemBuyStatementUnderLegsText,oSB.wbelemBuyStatementUnderLegsText.getText());
	
	fnVerifyElementExistenceWithText(oSB.wbelemSelectAnOptionText,"3\nSelect an Option");
	
	
	extReport.endTest(test);softAssert.assertAll();

	}	
	
	
	@AfterClass
	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
	}

}
