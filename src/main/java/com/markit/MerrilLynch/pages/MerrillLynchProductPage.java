package com.markit.MerrilLynch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.markit.DigitalAutomationFramework.common.Page;
import com.markit.DigitalAutomationFramework.common.PropertyReader;

import org.testng.Reporter;

/*
*
* @author: Sunny Jain	
* @purpose: This is Merrill Lynch product page Class & contains all the common locators & methods across product.
* @creation date: 12/6/2016
*
*/

public class MerrillLynchProductPage extends Page {

	protected WebDriverWait wait;
	protected String defaultWindowHandle;
	
	 @FindBy(id = "txtUserid")
	 public WebElement wbtxtUserId;
	 @FindBy(id = "btnValidate")
	 public WebElement wbbtnContinue;
	 @FindBy(id = "txtPassword")
	 public WebElement wbtxtPassword;
	 @FindBy(id = "btnContinue")
	 public WebElement wbLogin;
	 @FindBy(css = "iframe#ctl00_ctl00_cphNestedUtility_cphLeft1_ifrmOnlineLoginExperience")
	 public WebElement wbframe1;
	 @FindBy(css = "li#li_2_RUN_RIReviewMarketsUI_Overview>a")
	 public WebElement wblnkResearch;
	 
	 @FindBy(css = ".selected>span>strong")
	 public WebElement wbelemOverviewTab;
	 @FindBy(css = " #ctl00_ctl00_ctl01_cphSiteMst_H1Tag>div:nth-child(1)>span")
	 public WebElement wbelemResearchAndinsightText;
	 
	 @FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(6)>a>span")
	 public WebElement wbelemDebtMarketsTab; 
	
	 @FindBy(xpath = ".//*[@id='l2Research1']/div/div/div[1]/div/ul[2]/li[1]/a")
	 public WebElement wbelemStocks; 
	 @FindBy(xpath = ".//*[@id='l2Research1']/div/div/div[2]/div/ul[2]/li[1]/a")
	 public WebElement wbelemOptionStrategyBuilder;
	 
	 @FindBy(xpath = ".//*[@id='l2Research1']/div/div/div[3]/div/ul[2]/li[3]/a")
	 public WebElement wbelemStreamingQuotes;
	 
	 
	 // Market events class:
	 
	 @FindBy(css = "#mod_CalendarEconomicIndicators>div:nth-child(1)>div")
	 public WebElement wbelemMajorEconomicIndicator; 
	 @FindBy(css = "#mod_calendarCompanyEventsHeader>div>div:nth-of-type(2)>div:nth-of-type(1)")
	 public WebElement wbelemSelectAWeek; 	 
	 
	 // Sector & Industries
	 
	 @FindBy(css = "#mod_SectorsWhatsHappeningView>div:nth-of-type(1)>div>div")
	 public WebElement wbelemWhatsHappeningInSectorIndustries;  
	
	public MerrillLynchProductPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
	}

	public MerrillLynchProductPage navigateTo(String url) {
		_driver.get(url);
		MerrillLynchProductPage mlPP = PageFactory.initElements(_driver, MerrillLynchProductPage.class);
		Log.info("Merrill Login page loaded");
		Reporter.log("MerrillLogin page loaded");
		return mlPP;
	}
	
 
	 public void fnLogin(String userId,String password) throws InterruptedException{
    	 
    	 _driver.switchTo().frame(wbframe1);
    	 fnWaitTillElementEnable(_driver,40,wbtxtUserId);
    	 wbtxtUserId.clear();
    	 wbtxtUserId.sendKeys(userId);
    	 fnWaitTillElementEnable(_driver,40,wbtxtPassword);
    	 wbtxtPassword.sendKeys(password);
		 fnWaitTillElementEnable(_driver,40,wbbtnContinue);
		 wbbtnContinue.click();
    	
     }
	 
	 
	

}
