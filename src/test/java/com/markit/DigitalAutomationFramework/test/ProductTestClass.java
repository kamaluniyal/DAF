package com.markit.DigitalAutomationFramework.test;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.DigitalAutomationFramework.common.DataReader;
import com.markit.DigitalAutomationFramework.common.TestClass;
import com.markit.DigitalAutomationFramework.page.FundDetails;
import com.markit.DigitalAutomationFramework.page.ProductPage;
import com.markit.DigitalAutomationFramework.common.PropertyReader;

/*
*
* @author: Sunny Jain	
* @purpose: this is a sample product class
* @creation date: 8/6/2016
*
*/

public class ProductTestClass extends TestClass {

	protected FundDetails fd;
	ProductPage pp;

	PropertyReader prop;

	protected ProductPage setupEnvironment(String browser, String version, String sel_Grid, String testEnvironment)
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
		pp = new ProductPage(driver);
		pp = pp.navigateTo(this.testURL);
		// FundDetails FundDetails = new FundDetails(driver);

		// Return MarkitHomePage object
		return pp;
	}

}
