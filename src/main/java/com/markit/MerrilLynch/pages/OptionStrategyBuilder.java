package com.markit.MerrilLynch.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.markit.DigitalAutomationFramework.common.Page;
import com.markit.DigitalAutomationFramework.page.ProductPage;

/*
*
* @author: Sunny Jain	
* @purpose: This is Stock Page class contains all the elements to be interacted in test scenarios.
* @creation date: 3/01/2017
*
*/

public class OptionStrategyBuilder extends MerrillLynchProductPage {
		
	@FindBy(id = "approved-strategies-checkbox")
	public WebElement wbchkOnlyShowStrategiescurrentlyApproved;	
	@FindBy(id = "one-click-trade-support-check")
	public WebElement wbchkOnlyShowStrategiesWithOneClickTradeSupport;
	
	@FindBy(xpath = ".//*[@id='filter-options-container']/div[1]/fieldset/label")
	public WebElement wbelemOnlyShowStrategiescurrentlyApprovedText;	
	@FindBy(xpath = ".//*[@id='filter-options-container']/div[3]/label[3]")
	public WebElement wbelemOnlyShowStrategiesWithOneClickTradeSupportText;
	
	@FindBy(id = "txtSymbolInWatchList")
	public WebElement wbtxtSearchSymbolTextBox;
	@FindBy(id = "btnAddText")
	public WebElement wbbtnGoButton;
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[2]/div/a")
	public WebElement wblnkSymbolLink;	
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[2]/div/span[1]")
	public WebElement wbelemMarketPrice;	
	
	@FindBy(xpath = ".//*[@id='cards-table-view']/div[1]/div/h4")
	public WebElement wbelemStrategyToBeSelected;
	
	
	
	//Strategy
	
	
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[3]/div/h6[1]")
	public WebElement wbelemSelectedStrategyText;
	
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[3]/div/span")
	public WebElement wbelemSelectedStrategyScaledDownChart;
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[3]/div/table/tbody/tr[1]/th")
	public WebElement wbelemImpactOfVolatility;
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[3]/div/table/tbody/tr[3]/th")
	public WebElement wbelemOutlookText;
	
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[3]/div/h6[2]")
	public WebElement wbelemLegsTextOutlookText;
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[3]/div/div[1]/ul/li")
	public WebElement wbelemBuyStatementUnderLegsText;
	
	
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[2]")
	public WebElement wbelemSelectASymbol;
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[3]")
	public WebElement wbelemSelectAnOptionStrategyText;
	@FindBy(xpath = ".//*[@id='options-cart-container']/div[4]")
	public WebElement wbelemSelectAnOptionText;
	
	
	public OptionStrategyBuilder(WebDriver driver ) {
		super(driver);		
	}


}
