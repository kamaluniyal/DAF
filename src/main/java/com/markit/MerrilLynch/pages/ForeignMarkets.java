package com.markit.MerrilLynch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.markit.DigitalAutomationFramework.common.Page;
import com.markit.DigitalAutomationFramework.page.ProductPage;

/*
*
* @author: Kamal Uniyal
* @purpose: This Foreign market page class contains all the elements to be interacted in test scenarios.
* @creation date: 24/6/2016
*
*/

public class ForeignMarkets extends MerrillLynchProductPage {
	public WebDriverWait wait;

	// Locators of Asia page
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(2)>a")
	public WebElement wblnkForeignMarkets;
	@FindBy(css = "ul.clearfix.mod-tabs>li:nth-child(1)")
	public WebElement wblnkAsiaPacific;
	@FindBy(css = "ul.clearfix.mod-tabs>li:nth-child(3)")
	public WebElement wblnkAmericas;
	@FindBy(css = "#ForeignMarketsSummary>div>div>div:nth-child(2)")
	public WebElement wbelemSummary;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkFTSE_Singapore;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkHangSeng;

	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkNikkei225;

	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(4)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkTopixJapan;

	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(5)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkAllOrdinariesAustralia;

	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(2)")
	public WebElement wbelemQuotesDelayedBy_AsiaPacific;

	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemLatestNews;

	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(1)")
	public WebElement wbelemShowOnly;

	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>span")
	public WebElement wbelemMyholdingsText;

	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>input")
	public WebElement wbchkboxMyholdingsCheckbox;

	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>span")
	public WebElement wbelemMyWatchlistText;

	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>input")
	public WebElement wbchkboxMyWatchlistCheckbox;

	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>a")
	public WebElement wblnkNewsHeadlineOnRecentNews;

	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(1)")
	public WebElement wbelemCompanyNameForNews;

	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemTeaserForFirstNews;

	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(2)")
	public WebElement wbelemTimeStampInformationForNews;

	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)>div>a")
	public WebElement wblnkReadMoreOnRecentNews;

	@FindBy(css = "#generic-view>div:nth-child(3)>a")
	public WebElement wblnkMoreForeignMarketNews;

	@FindBy(css = "#companies_in_the_news_widget>div:nth-child(1)")
	public WebElement wbelemCompaniesInTheNews;

	@FindBy(css = "#companies_in_the_news_widget>div:nth-child(3)")
	public WebElement wbelemCompaniesinNews_AsOf;

	// locators of ways to invest
	@FindBy(css = "#mod_ways_to_invest>div>div:nth-child(1)")
	public WebElement wbelemWaysToInvestText;

	@FindBy(css = "#mod_ways_to_invest>div>table:nth-child(2)>tbody>tr:nth-child(1)>td:nth-child(1)>div>a")
	public WebElement wblnkMerrillEdgeSelectETFs;

	@FindBy(css = "#mod_ways_to_invest>div>table:nth-child(2)>tbody>tr:nth-child(2)>td:nth-child(1)>div>a")
	public WebElement wblnkMerrillEdgeSelectFunds;

	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-of-type(1)>td:nth-of-type(1)>div")
	public WebElement wbelemWaysToInvest_MutualFunds;

	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-of-type(2)>td:nth-of-type(1)>div>a")
	public WebElement wblnkWaysToInvest_MutualFunds_Fund;

	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-of-type(5)>td:nth-of-type(1)>div")
	public WebElement wbelemWaysToInvest_ETFs;

	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-of-type(6)>td:nth-of-type(1)>div>a")
	public WebElement wblnkWaysToInvest_ETFs_Fund;

	@FindBy(css = "#mod_MutualFundScreenerHeaderView>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemScreenForMutualFund;

	@FindBy(css = "#mod_ETFScreenerHeaderView>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemETF_Screener;

	// Latest reports locators
	@FindBy(css = "#generic-research-view>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemReportsFromBofAMLText;

	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>a")
	public WebElement wblnkReportsFromBofAML_ReportLink;

	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span")
	public WebElement wbelemReportsFromBofAML_ReportTimestamp;

	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemReportsFromBofAML_ReportTeaser;

	@FindBy(css = "#generic-research-view>div:nth-child(3)>a")
	public WebElement wblnkReportsFromBofAML_MoreReports;

	// currencies
	@FindBy(css = "#mod_AsiaPacificCurrenciesView>div>div:nth-child(1)")
	public WebElement wbelemAsiaPacificCurrencies;

	@FindBy(css = "#mod_AsiaPacificCurrenciesView>div>div:nth-child(2)>div:nth-child(1)>select")
	public WebElement wblstAsiaPacificCurrencies_List;

	@FindBy(css = "#mod_AsiaPacificCurrenciesView>div>div:nth-child(2)>div:nth-child(1)>span")
	public WebElement wbelem_vs1Dollar_AsiaPAcific;

	@FindBy(css = "#modCurrencyContent>div:nth-child(1)")
	public WebElement wbelemCurrencies_CurrencyConverter;

	@FindBy(css = "#modCurrencyContent>div:nth-child(2)>img")
	public WebElement wbimgCurrencies_ChartImage;

	// Locators for Performance chart under FTSE-Singapore
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(1)")
	public WebElement wbelemCurrentValue_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(2)")
	public WebElement wbelemCurrentPerformance_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(3)")
	public WebElement wbelemCurrentMonthChange_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(1)>a")
	public WebElement wblnk1Day_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(3)>a")
	public WebElement wblnk1Week_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(5)>a")
	public WebElement wblnk1Month_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(7)>a")
	public WebElement wblnk3Month_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(9)>a")
	public WebElement wblnk6Month_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(11)>a")
	public WebElement wblnk1Year_FTSE;
	@FindBy(css = "#mod_AsiaPacificQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>select")
	public WebElement wblstCompareTo_FTSE;

	// Locator for Europe

	@FindBy(css = "ul.clearfix.mod-tabs>li:nth-child(2)")
	public WebElement wblnkEurope;
	@FindBy(css = "#ForeignMarketsSummary>div>div>div:nth-child(1)")
	public WebElement wbelemEuropeInBrief;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkBrussels_SE_Bel_20;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkIrish_SE_ISEQ_Over;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkCAC40_France;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(4)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkFTSE100;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(5)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkAEX_Amsterdam;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(6)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkDAX_Index_Germany;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(7)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkIBEX35_Spain;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(8)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkOMXC20_Denmark;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(9)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkOMXH_Finland;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(10)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkOMX_AllShare;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(11)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkSMIprice_Swiss;

	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(2)")
	public WebElement wbelemQuotesDelayedBy_Europe;
	@FindBy(css = "#mod_EuropeCurrenciesView>div>div:nth-child(1)")
	public WebElement wbelemEuropeanCurrencies;
	@FindBy(css = "#mod_EuropeCurrenciesView>div>div:nth-child(2)>div:nth-child(1)>select")
	public WebElement wblstEuropeanCurrencies_List;
	@FindBy(css = "#mod_EuropeCurrenciesView>div>div:nth-child(2)>div:nth-child(1)>span")
	public WebElement wbelem_vs1Dollar_European;

	// Locators for Performance chart under Europe Brussels
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(1)")
	public WebElement wbelemCurrentValue_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(2)")
	public WebElement wbelemCurrentPerformance_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(3)")
	public WebElement wbelemCurrentMonthChange_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(1)>a")
	public WebElement wblnk1Day_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(3)>a")
	public WebElement wblnk1Week_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(5)>a")
	public WebElement wblnk1Month_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(7)>a")
	public WebElement wblnk3Month_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(9)>a")
	public WebElement wblnk6Month_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(11)>a")
	public WebElement wblnk1Year_Brussels;
	@FindBy(css = "#mod_EuropeQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>select")
	public WebElement wblstCompareTo_Brussels;

	// Locator for Americas

	// Americas

	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(2)")
	public WebElement wbelemQuotesDelayedBy_Americas;
	@FindBy(css = "#mod_AmericasQuoteView>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkCanada_TSX;
	@FindBy(css = "#mod_AmericasQuoteView>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkBrazil_Bovespa;

	// currencies
	@FindBy(css = "#mod_AmericasCurrenciesView>div>div:nth-child(1)")
	public WebElement wbelemAmericasCurrencies;
	@FindBy(css = "#mod_AmericasCurrenciesView>div>div:nth-child(2)>div:nth-child(1)>select")
	public WebElement wblstAmericasCurrencies_List;
	@FindBy(css = "#mod_AmericasCurrenciesView>div>div:nth-child(2)>div:nth-child(1)>span")
	public WebElement wbelem_vs1Dollar_Americas;

	// Locators for Performance chart under Americas - canada

	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(1)")
	public WebElement wbelemCurrentValue_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(2)")
	public WebElement wbelemCurrentPerformance_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(3)")
	public WebElement wbelemCurrentMonthChange_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(1)>a")
	public WebElement wblnk1Day_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(3)>a")
	public WebElement wblnk1Week_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(5)>a")
	public WebElement wblnk1Month_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(7)>a")
	public WebElement wblnk3Month_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(9)>a")
	public WebElement wblnk6Month_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(11)>a")
	public WebElement wblnk1Year_Canada;
	@FindBy(css = "#mod_AmericasQuoteView>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>select")
	public WebElement wblstCompareTo_Canada;

	public ForeignMarkets(WebDriver driver) {
		super(driver);
	}

}
