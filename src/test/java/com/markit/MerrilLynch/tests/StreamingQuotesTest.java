package com.markit.MerrilLynch.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class StreamingQuotesTest extends MerrilLynchProductTest{
	
   
	PropertyReader prop;
	GlobalDriver gDriver;
	StreamingQuotes streamQ;
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
		streamQ = new StreamingQuotes(driver);
		

		parent = extent.startTest("Streaming Quotes");
	}
 
	@BeforeMethod
	public void testInitialization() throws Exception {				
		softAssert = new SoftAssert();

	}
	
	@Test(priority =0)
	public void TC_VerificationOfIndices_Streaming_Quotes() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfIndices_Streaming_Quotes", "This Method will verify the default UI of the page."); 
	parent.appendChild(test);
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wblnkResearch);
	mlPP.actMouseOver(mlPP.wblnkResearch);
	mlPP.fnWaitTillElementVisible(driver, 40, mlPP.wbelemStreamingQuotes);
	mlPP.wbelemStreamingQuotes.click();
	
	mlPP.fnSwitchToNewlyOpenedWindow();	
	
	Thread.sleep(9000);
	
	mlPP.fnWaitTillElementVisible(driver, 120, streamQ.wbelemDowIndex);
	
	fnVerifyElementExistenceWithText(streamQ.wbelemDowIndex,"DOW");
	fnVerifyElementExistenceWithText(streamQ.wbelemAmexIndex,"AMEX");
	fnVerifyElementExistenceWithText(streamQ.wbelemSP500Index,"S&P 500");
	fnVerifyElementExistenceWithText(streamQ.wbelemRussellIndex,"Russell 2000");
	fnVerifyElementExistenceWithText(streamQ.wbelemNasdaqIndex,"NASDAQ");
	fnVerifyElementExistenceWithText(streamQ.wbelemNyseIndex,"NYSE");
	
	extReport.endTest(test);softAssert.assertAll();
	
	}
		
		
	@Test(priority =1,enabled = true)
	public void TC_VerificationOfQuoteList_Streaming_Quotes() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfQuoteList_Streaming_Quotes", "This Method will verify the default UI of the page."); 
	parent.appendChild(test);

	fnRemoveAllQuoteList();
	
	streamQ.fnClick(streamQ.wbelemAddNewModule);
	streamQ.fnClick(streamQ.wbelemQuoteList);
	fnVerifyElementExistenceWithText(streamQ.wbelemChooseAnExistingQuotelist,"Choose an existing Quotelist");
	streamQ.fnSelectValueFromDropDownByVisibleText(streamQ.wblstQuoteListDropdown, "QuoteList");
	
	fnVerifyElementExistenceWithText(streamQ.wbelemSecurityText,"Security");
	fnVerifyElementExistenceWithText(streamQ.wbelemQuoteLastPriceText,"Last Price");
	fnVerifyElementExistenceWithText(streamQ.wbelemDayHighText,"Day's High");
		

	List<String> symbolList = streamQ.fnGetListOfRowElementsForColumnFromWebtable(streamQ.wbtblQuotelistSymbolsTable,0);
	
	String expectedSymbols[] = {"AADR","ABC","S"};
		
	for(int i=0;i<symbolList.size();i++){
		
		if(symbolList.get(i).equals(expectedSymbols[i])){
			
			extReport.enterLog("Pass", symbolList.get(i)+" is verified succesfully");
		}else{
			extReport.enterLog("Fail", symbolList.get(i)+" is not verified.");
		}
				
	}
	
	extReport.endTest(test);softAssert.assertAll();
	
	}
	
	
	@Test(priority =2,enabled = true)
	public void TC_VerificationOfSecuritySnapshot_Streaming_Quotes() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfSecuritySnapshot_Streaming_Quotes", "This Method will verify the default UI of the page."); 
	parent.appendChild(test);

	fnRemoveAllQuoteList();
	
	streamQ.fnClick(streamQ.wbelemAddNewModule);
	streamQ.fnClick(streamQ.wbelemSecuritySnapshot);
	fnVerifyElementExistenceWithText(streamQ.wbelemSecuritySnapshotText,"Security Snapshot");
	Thread.sleep(2000);
	streamQ.wbtxtSecurityTextBox.sendKeys("IBM");
	Thread.sleep(2000);
	
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();

	fnVerifyElementExistenceWithText(streamQ.wbelemLastPriceText,"Last Price");
	fnVerifyElementExistenceWithText(streamQ.wbelemBidSizeText,"Bid x Size");
	fnVerifyElementExistenceWithText(streamQ.wbelemAskSizeText,"Ask x Size");
	
	fnVerifyElementExistenceWithText(streamQ.wbelemDaysChangeInDollarText,"Day's Change($)");
	fnVerifyElementExistenceWithText(streamQ.wbelemDaysChangeInPercentageText,"Day's Change(%)");
	fnVerifyElementExistenceWithText(streamQ.wbelemDaysVolumeText,"Day's Vol.");
			
	List<String> attributeList = new ArrayList();
	
	attributeList = streamQ.fnGetListOfRowElementsForColumnFromWebtable(streamQ.wbelemAttributeTable,0);
	
	String str = PropertyReader.getFieldValue("SymbolAttributes","DataFile.properties");
	
	String expectedAttributes[] = str.split("@");
	
	
	for(int i=0;i<attributeList.size();i++){
		
		if(attributeList.get(i).equals(expectedAttributes[i])){
			
			extReport.enterLog("Pass", attributeList.get(i)+" is verified succesfully");
		}else{
			extReport.enterLog("Fail", attributeList.get(i)+" is not verified.");
		}
				
	}
	
	
	extReport.endTest(test);softAssert.assertAll();
	
	}
	
	@Test(priority =3,enabled = true)
	public void TC_VerificationOfNews_Streaming_Quotes() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfNews_Streaming_Quotes", "This Method will verify the default UI of the page."); 
	parent.appendChild(test);

	fnRemoveAllQuoteList();
	
	streamQ.fnClick(streamQ.wbelemAddNewModule);
	streamQ.fnClick(streamQ.wbelemNews);
	fnVerifyElementExistenceWithText(streamQ.wbelemLatestMarketNews,"Latest Market News");
	
	String newsText = streamQ.wblnkFirstNewsLink.getText();
	
	streamQ.fnClick(streamQ.wblnkFirstNewsLink);
	
	mlPP.fnWaitTillElementVisible(driver, 60, streamQ.wbelemNewsTitleOnPopup);
	
	String popupNewsText = streamQ.wbelemNewsTitleOnPopup.getText();
	
	if(newsText.equals(popupNewsText)){
		
		extReport.enterLog("Pass", newsText+" has been verified succesfully.");
		
	}else{
		extReport.enterLog("Fail", newsText+" has not verified.");
	}
	
	streamQ.fnClick(streamQ.wbelemNewsPopupCloseButton);
	
	extReport.endTest(test);softAssert.assertAll();
	
	}
	
	@Test(priority =4,enabled = true)
	public void TC_VerificationOfHoldings_Streaming_Quotes() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfHoldings_Streaming_Quotes", "This Method will verify the default UI of the page."); 
	parent.appendChild(test);

	fnRemoveAllQuoteList();
	
	streamQ.fnClick(streamQ.wbelemAddNewModule);
	streamQ.fnClick(streamQ.wbelemHoldings);
	fnVerifyElementExistenceWithText(streamQ.wbelemHoldingsText,"Holdings");
	fnVerifyElementExistenceWithText(streamQ.wbelemNoHoldingsAvailableText,"No holdings available.");
	
	extReport.endTest(test);softAssert.assertAll();
	
	}
	
	@Test(priority =5,enabled = true)
	public void TC_VerificationOfStreamingQuotesSettings_Streaming_Quotes() throws InterruptedException {
	ExtentTest test = extReport.startTest("TC_VerificationOfStreamingQuotesSettings_Streaming_Quotes", "This Method will verify the default UI of the page."); 
	parent.appendChild(test);

	fnRemoveAllQuoteList();
	
	streamQ.fnClick(streamQ.wbelemSettings);
	fnVerifyElementExistence(streamQ.wbrdbtnLightView,"Light View radiobutton");
	fnVerifyElementExistence(streamQ.wbrdbtnDarkView,"Dark View radiobutton");
	fnVerifyElementExistenceWithText(streamQ.wbelemViewTutorial,"View the Tutorial");
	fnVerifyElementExistenceWithText(streamQ.wbelemResetWorkSpace,"Reset Workspace");
		
	if(streamQ.wbrdbtnLightView.isSelected()){
		
		extReport.enterLog("Pass", " Light view radiobutton is selected by default.");
	}else{
		extReport.enterLog("Fail", " Light view radiobutton is not selected by default.");
	}
	
//	streamQ.fnClick(streamQ.wbelemViewTutorial);
//	
//	fnVerifyElementExistenceWithText(streamQ.wbeleTutorialPopupTitle,"Streaming Quotes Tutorial");
//	
//	streamQ.fnClick(streamQ.wbeleTutorialPopupCloseButton);
//	
//	streamQ.fnClick(streamQ.wbelemSettings);
	
	streamQ.fnClick(streamQ.wbrdbtnDarkView);
	
	streamQ.fnClick(streamQ.wbelemSettings);
	
if(streamQ.wbrdbtnDarkView.isSelected()){
		
		extReport.enterLog("Pass", " Light view radiobutton is selected by default.");
	}else{
		extReport.enterLog("Fail", " Light view radiobutton is not selected by default.");
	}
	
streamQ.fnClick(streamQ.wbrdbtnLightView);

	extReport.endTest(test);softAssert.assertAll();
	
	}
	
	
	
    void fnRemoveAllQuoteList() throws InterruptedException{
	   List<WebElement> menu = driver.findElements(By.xpath(".//*[@class='editModuleIcon']"));
		
	   List<WebElement> RemoveModule= driver.findElements(By.xpath(".//*[@id='tfhover']/tbody/tr[1]/td[2]/div/p"));
		
	   if(menu.size()>1){
	   
	   for(int i =1 ;i<menu.size();i++){
		menu.get(i).click();
		Thread.sleep(2000);
		fnClick(RemoveModule.get(i));
		
	   }
	   }
    }
	
	@AfterClass
	public void quit() throws AddressException, MessagingException {
		driver.quit();
		extent.endTest(parent);
	}

}
