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
* @purpose: This is Streaming Quotes Page class contains all the elements to be interacted in test scenarios.
* @creation date: 10/01/2017
*
*/

public class StreamingQuotes extends MerrillLynchProductPage {
		
	@FindBy(xpath = ".//*[@id='MarketsOverviewCtrl']/tbody/tr[1]/td[1]/span[1]")
	public WebElement wbelemDowIndex;	
	@FindBy(xpath = ".//*[@id='MarketsOverviewCtrl']/tbody/tr[2]/td[4]/span[1]")
	public WebElement wbelemAmexIndex;
	@FindBy(xpath = ".//*[@id='MarketsOverviewCtrl']/tbody/tr[1]/td[2]/span[1]")
	public WebElement wbelemSP500Index;;
	@FindBy(xpath = ".//*[@id='MarketsOverviewCtrl']/tbody/tr[2]/td[5]/span[1]")
	public WebElement wbelemRussellIndex;
	@FindBy(xpath = ".//*[@id='MarketsOverviewCtrl']/tbody/tr[1]/td[3]/span[1]")
	public WebElement wbelemNasdaqIndex;
	@FindBy(xpath = ".//*[@id='MarketsOverviewCtrl']/tbody/tr[2]/td[6]/span[1]")
	public WebElement wbelemNyseIndex;	
	@FindBy(xpath = ".//*[@class='editModuleIcon']")
	public List<WebElement> wbelemMenu;
	
	// QuoteList
	
	@FindBy(xpath = ".//*[@id='tabs']/div[1]/ul/li[6]/span[2]")
	public WebElement wbelemAddNewModule;
	@FindBy(id = "QuoteTallspan_0")
	public WebElement wbelemQuoteList;
	@FindBy(xpath = ".//*[@id='resizable']/div/div[2]/div/div/strong")
	public WebElement wbelemChooseAnExistingQuotelist;	
	@FindBy(id = "SECTallspan_0")
	public WebElement wbelemSecuritySnapshot;
	@FindBy(id = "NewsTallspan_1")
	public WebElement wbelemNews;
	@FindBy(id = "HOLDTallspan_1")
	public WebElement wbelemHoldings;
	@FindBy(xpath = ".//*[@id='resizable']/div/div[2]/div/div/select")
	public WebElement wblstQuoteListDropdown;
	@FindBy(xpath = ".//*[@id='tableHead']/table/thead/tr/th[1]/a")
	public WebElement wbelemSecurityText;
	@FindBy(xpath = ".//*[@id='tableHead']/table/thead/tr/th[3]/a")
	public WebElement wbelemQuoteLastPriceText;
	@FindBy(xpath = ".//*[@id='tableHead']/table/thead/tr/th[4]/a")
	public WebElement wbelemDayHighText;
	
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/div[2]/table/tbody")
	public WebElement wbtblQuotelistSymbolsTable;
	
	// News
	
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[1]/span")
	public WebElement wbelemLatestMarketNews;
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[3]/div/div/ul/li[1]/div/div/a[1]")
	public WebElement wblnkFirstNewsLink;	
	@FindBy(xpath = "html/body/div[6]/div[1]/span")
	public WebElement wbelemNewsTitleOnPopup;	
	@FindBy(xpath = "html/body/div[6]/div[1]/button")
	public WebElement wbelemNewsPopupCloseButton;
	
	
	//Security Snapshot
	
	@FindBy(xpath = ".//*[@id='resizable']/div/div[3]/div/div/div/span")
	public WebElement wbelemSecuritySnapshotText;	
	@FindBy(xpath = ".//*[@id='resizable']/div/div[4]/form/input")
	public WebElement wbtxtSecurityTextBox;	
	@FindBy(xpath = ".//*[@id='ng-app']/body/div[10]/ul/li[1]/a/span[1]")
	public WebElement wbelemIBMSymbolMatch;
	
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/table[1]/tbody/tr[1]/td[2]")
	public WebElement wbelemLastPriceText;
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/table[1]/tbody/tr[1]/td[3]")
	public WebElement wbelemBidSizeText;
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/table[1]/tbody/tr[1]/td[4]")
	public WebElement wbelemAskSizeText;
	
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/table[2]/thead/tr/th[2]")
	public WebElement wbelemDaysChangeInDollarText;
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/table[2]/thead/tr/th[3]")
	public WebElement wbelemDaysChangeInPercentageText;
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/table[2]/thead/tr/th[4]")
	public WebElement wbelemDaysVolumeText;
	
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div/table[3]/tbody")
	public WebElement wbelemAttributeTable;
	
	
	//Holdings
	
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[1]/span")
	public WebElement wbelemHoldingsText;	
	
	@FindBy(xpath = ".//*[@id='resizable']/div[1]/div[2]/div[3]/span")
	public WebElement wbelemNoHoldingsAvailableText;
	
	//settings
	
	@FindBy(xpath = ".//*[@id='tabs']/div[1]/ul/li[8]/span[2]")
	public WebElement wbelemSettings;
	@FindBy(xpath = ".//*[@id='settingsDialog']/div[1]/input[1]")
	public WebElement wbrdbtnLightView;	
	@FindBy(xpath = ".//*[@id='settingsDialog']/div[1]/input[2]")
	public WebElement wbrdbtnDarkView;
	
	@FindBy(xpath = ".//*[@id='settingsDialog']/div[2]/a")
	public WebElement wbelemViewTutorial;
	@FindBy(xpath = ".//*[@id='settingsDialog']/div[3]/a")
	public WebElement wbelemResetWorkSpace;
	@FindBy(css = "#ui-id-3")
	public WebElement wbeleTutorialPopupTitle;	
	@FindBy(xpath = "html/body/div[6]/div[1]/button")
	public WebElement wbeleTutorialPopupCloseButton;	
	
	
	
	public StreamingQuotes(WebDriver driver ) {
		super(driver);		
	}


}
