package com.markit.MerrilLynch.tests;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.*;

import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.DigitalAutomationFramework.common.DataReader;
import com.markit.DigitalAutomationFramework.common.ExtentReporting;
import com.markit.DigitalAutomationFramework.common.TestClass;
import com.markit.MerrilLynch.pages.DebtMarkets;
import com.markit.MerrilLynch.pages.MerrillLynchProductPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.markit.DigitalAutomationFramework.common.PropertyReader;


/*
*
* @author: Sunny Jain	
* @purpose: this is a Merrill Lynch product class
* @creation date: 22/6/2016
*
*/

public class MerrilLynchProductTest extends TestClass {
	
	MerrillLynchProductPage mlPP ;

	PropertyReader prop;
	
	String userId;
	String password;
	

	protected MerrillLynchProductPage setupEnvironment(String browser, String version, String sel_Grid, String testEnvironment)
			throws IOException, InvalidFormatException {

		// Get environment name
		if (testEnvironment == null) {
			PropertyReader prop = new PropertyReader();
			prop.ValueMap("Configuration.properties");
			this.testEnvironment = PropertyReader.getFieldValue("defaultEnvironment");
		} else {
			this.testEnvironment = testEnvironment;
		}

	
		// Setup DataReader object
		data = new DataReader(this.getClass().getSimpleName(), this.testEnvironment);

		// Set DataReader to EnvironmentInfo sheet and fetch URL for the
		// selected environment
		this.testURL = data.getURL(this.testEnvironment);

		// Initialise the driver
		gDriver = new GlobalDriver();

		// Initialises the browser (uses the global Driver class to initialise
		// the browser)
		driver = gDriver.init(browser, version, sel_Grid);
		

		// Go to MarkitHomePage
		mlPP = new MerrillLynchProductPage(driver);
		userId = data.getUserName("standard",this.testEnvironment);
		password = data.getPassword("standard",this.testEnvironment);
		
		mlPP = mlPP.navigateTo(this.testURL);
		
		return mlPP;
	}	
	
	@BeforeSuite
	public void fnBeforeSuite() throws Exception {
				
		 extent = ExtentReporting.getInstance();		
	}
	
	@AfterSuite
	public void fnAfterSuite() throws Exception {
		
		extReport.flushReport();	
	}


}
