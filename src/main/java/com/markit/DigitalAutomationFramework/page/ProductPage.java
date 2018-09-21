package com.markit.DigitalAutomationFramework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.markit.DigitalAutomationFramework.common.Page;
import org.testng.Reporter;

/*
*
* @author: Sunny Jain	
* @purpose: this is a sample Page class
* @creation date: 8/6/2016
*
*/

public class ProductPage extends Page {

	protected WebDriverWait wait;
	protected String defaultWindowHandle;//

	public ProductPage(WebDriver driver) {
		// The super call below passes the driver to the Page class in the
		// framework that
		// runs PageFactory.initElements(driver, this) which initialises all of
		// the WebElements in this class
		super(driver);
		wait = new WebDriverWait(driver, 20);
		defaultWindowHandle = driver.getWindowHandle();
	}

	public void switchToWindow() {
		_driver.switchTo().window(defaultWindowHandle);
	}

	public ProductPage navigateTo(String url) {

		_driver.get(url);

		ProductPage pp = PageFactory.initElements(_driver, ProductPage.class);

		Log.info("Login page loaded");

		Reporter.log("Login page loaded");

		return pp;

	}

}
