package com.markit.DigitalAutomationFramework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.markit.DigitalAutomationFramework.common.Page;

/*
*
* @author: Sunny Jain	
* @purpose: this is a sample Page class
* @creation date: 8/6/2016
*
*/

public class FundDetails extends ProductPage {

	protected WebDriverWait wait;

	@FindBy(xpath = ".//*[@id='com-mod-nav-bar']/div/div/div/div/ul/li[2]/a")
	WebElement ReturnLink;

	@FindBy(xpath = ".//*[@id='com-mod-nav-bar']/div/div/div/div/ul/li[4]/a")
	WebElement HoldingsLink;

	public FundDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getReturnLinktext() {
		String name;
		name = ReturnLink.getText();
		return name;
	}

	public void clickHoldings() {

		wait = (new WebDriverWait(_driver, 10));
		wait.until(ExpectedConditions.elementToBeClickable(HoldingsLink));
		HoldingsLink.click();
	}

}
