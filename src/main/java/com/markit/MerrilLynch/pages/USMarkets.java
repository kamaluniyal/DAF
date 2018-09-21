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
* @purpose: This US Markets Page class contains all the elements to be interacted in test scenarios.
* @creation date: 22/6/2016
*
*/

public class USMarkets extends MerrillLynchProductPage {

	@FindBy(css = "#news_article_full_story>div:nth-of-type(1)>div:nth-of-type(1)>a:nth-of-type(2)")
	public WebElement wblnkReturnToUSMarket;
	
	@FindBy(css = "#news_article_full_story>div:nth-of-type(1)>div:nth-of-type(1)>a")
	public WebElement wblnkReturnToNews;

	@FindBy(css = "div#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-child(1)>a")
	public WebElement wblnkUSMarket;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-of-type(1)>div>div>div:nth-of-type(1)")
	public WebElement wbelemWhatsHappeningInUSMarkets;
	@FindBy(css = "#generic-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(1)")
	public WebElement wbelemRecentNews;
	@FindBy(css = "#mod_USMarketsEconomicEventsView>div:nth-of-type(1)")
	public WebElement wbelemEconomicEvents;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsView>div:nth-of-type(1)>div>div")
	public WebElement wbelemCompanyAnnouncements;
	@FindBy(css = "#generic-research-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(1)")
	public WebElement wbelemLatestReports;
	@FindBy(css = "#mod_USMarketsInvestmentProductsView>div")
	public WebElement wbelemInvestmentProductAndMore;
	@FindBy(css = "#us_markets_wmm_composite_widget>div:nth-of-type(1)>div:nth-of-type(1)>div>div>div")
	public WebElement wbelemWhatsMovingTheMarkets;
	@FindBy(css = "#mod_USMarketsRecentRatingsView>div:nth-of-type(1)>div>div")
	public WebElement wbelemSectorPerformanceAndRecentRatingChanges;

	// Recent News Components:

	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(1)")
	public WebElement wbelemShowOnly;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>input")
	public WebElement wbchkboxMyHoldings;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>input")
	public WebElement wbchkboxMyWatchlist;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>span")
	public WebElement wbelemMyHoldings;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>span")
	public WebElement wbelemMyWatchlist;
	@FindBy(css = "#generic-view>div:nth-child(3)>a")
	public WebElement wblnkMoreUsMarketsNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)>div>a")
	public WebElement wblnkReadMoreOnRecentNews;
	@FindBy(css = "#companies_in_the_news_widget>div:nth-child(1)")
	public WebElement wbelemCompaniesInTheNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>a")
	public WebElement wblnkNewsHeadlineOnRecentNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemTeaserForFirstNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(1)")
	public WebElement wbelemCompanyNameForNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(2)")
	public WebElement wbelemTimeStampInformationForNews;

	// What's Happening in Us Markets:

	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(1)>div>div>div>a")
	public WebElement wblnkNewsLinkForMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(1)>div>div>div>div:nth-of-type(2)>div:nth-child(1)>span:nth-child(1)")
	public WebElement wbelemCompanyNameForMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(1)>div>div>div>div:nth-of-type(2)>div:nth-child(1)>span:nth-child(2)")
	public WebElement wbelemTimeStampInformationForNewsUnderMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(1)>div>div>div>div:nth-of-type(2)>div:nth-child(2)")
	public WebElement wbelemTeaserForMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(1)>span")
	public WebElement wbelemDowJonesForMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(1)>span")
	public WebElement wbelemNASDAQCompForMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(1)>span")
	public WebElement wbelemSP500ForMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div>div")
	public WebElement wbelemMarketActionUnderMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(1)>div>div>ul>li:nth-child(2)>div:nth-child(1)")
	public WebElement wbelemTodaysGainerOrLoserUnderMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(3)>div")
	public WebElement wbelemTimeStampInformationForMarketUpdate;

	@FindBy(id = ".DJIA_.DJIA_id")
	public WebElement wblblDJIASymbol;
	@FindBy(id = "COMP_COMP_id")
	public WebElement wblblCOMPSymbol;
	@FindBy(id = ".SPX_.SPX_id")
	public WebElement wblblSPXSymbol;
	@FindBy(css = "#ctl00_ctl00_ctl01_globalHoverQuoteContainer>div:nth-of-type(1)>span:nth-of-type(2)")
	public WebElement wbelemSymbolHovertext;
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_H1Tag>div:nth-child(1)>span:nth-of-type(1)")
	public WebElement wbelemSecurityProfileSymbolText;

	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(1)>span>strong>a")
	public WebElement wblnkDJIASymbol;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(1)>span>strong>a")
	public WebElement wblnkCOMPSymbol;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(1)>span>strong>a")
	public WebElement wblnkSPXSymbol;

	// Economic events
	
	@FindBy(css = "#mod_USMarketsEconomicEventsView>div:nth-child(2)>ul>li:nth-child(1)>a")
	public WebElement wblnkEventNameUnderEconomicEvents;
	@FindBy(css = "#mod_USMarketsEconomicEventsView>div:nth-child(2)>div:nth-of-type(1)>img")
	public WebElement wbelemAnnouncedDate;
	@FindBy(css = "#mod_USMarketsEconomicEventsView>a")
	public WebElement wblnkSeeAllEconomicsEvents;
	@FindBy(css = "#mod_USMarketsEconomicEventsView>div:nth-of-type(2)>div:nth-of-type(1)>img")
	public WebElement wbimgChartUnderEconomicEvents;
	@FindBy(css = "#mod_USMarketsEconomicEventsView>div:nth-child(2)>ul>li:nth-child(2)>a>div")
	public WebElement wbelemCalendarSymbol;

	@FindBy(css = ".mod-sprite.mod-icon-econodoay-logo.floatLeft")
	public WebElement wbelemEventLogo;
	@FindBy(css = "#mod_USMarketsEconomicEventsView>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(4)>div")
	public WebElement wbelemAnalysisHeader;
	@FindBy(css = ".mod-economic-indicators-modal-footer.clearfix>p")
	public WebElement wbelemDisclaimerText;
	@FindBy(css = ".mod-economic-indicators-modal-table>table>tbody>tr>th:nth-child(1)")
	public WebElement wbelemEconomicEventHeader1Text;
	@FindBy(css = ".mod-economic-indicators-modal-table>table>tbody>tr>th:nth-child(2)")
	public WebElement wbelemEconomicEventHeader2Text;
	@FindBy(css = ".mod-economic-indicators-modal-table>table>tbody>tr>th:nth-child(3)")
	public WebElement wbelemEconomicEventHeader3Text;
	@FindBy(css = ".mod-economic-indicators-modal-close")
	public WebElement wbelemCloseEvent;

	// Latest Reports:
	
	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>a")
	public WebElement wblnkNewsHeadlineUnderLatestReports;
	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span")
	public WebElement wbelemTimeStampInformationForLatestReports;
	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemTeaserForLatestReports;
	@FindBy(css = "#generic-research-view>div:nth-child(3)>a")
	public WebElement wblnlMoreResearchReports;

	// Company announcements:
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-child(1)>p>span:nth-child(1)")
	public WebElement wbelemCompanyEventCalendarTextUndeCompanyAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-child(1)>p>span:nth-of-type(2)")
	public WebElement wbelemSmartTextForWeekEventsUnderCompanyAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-child(1)>div")
	public WebElement wbelemCalenderIconUndeCompanyAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-child(2)>div>div:nth-child(1)>ul>li:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)")
	public WebElement wbelemEarningAnnouncementsUndeCompanyAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-child(2)>div>div:nth-child(1)>ul>li:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)")
	public WebElement wbelemDividendsUndeCompanyAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-child(2)>div>div:nth-child(1)>ul>li:nth-child(3)>div:nth-child(1)>div>div:nth-child(1)")
	public WebElement wbelemSplitsUndeCompanyAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsView>div:nth-child(3)>a")
	public WebElement wblnkViewAllCompanies;

	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbelemHeader1UnderEarningAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbelemHeader2UnderEarningAnnouncements;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(3)")
	public WebElement wbelemHeader3UnderEarningAnnouncements;

	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbelemHeader1UnderDividends;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbelemHeader2UnderDividends;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(3)")
	public WebElement wbelemHeader3UnderDividends;

	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbelemHeader1UnderSplits;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbelemHeader2UnderSplits;
	
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemEarningAnnouncementsCount;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemDividendsCount;
	@FindBy(css = "#mod_USMarketsCompanyAnnouncementsContent>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(3)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemSplitsCount;

	// Investment products & more

	@FindBy(css = "#mod_USMarketsInvestmentProductsView>ul>li:nth-child(1)>div>a")
	public WebElement wblnkMerrillEdgeMarketProUnderInvestmentProducts;
	@FindBy(css = "#mod_USMarketsInvestmentProductsView>ul>li:nth-child(2)>div>a")
	public WebElement wblnkStreamingQuotesUnderInvestmentProducts;
	@FindBy(css = "#mod_USMarketsInvestmentProductsView>ul>li:nth-child(3)>div>a")
	public WebElement wblnkWatchlistsUnderInvestmentProducts;
	@FindBy(css = "#mod_USMarketsInvestmentProductsView>ul>li:nth-child(4)>div>a")
	public WebElement wblnkCompareToolUnderInvestmentProducts;
	@FindBy(css = "#mod_USMarketsInvestmentProductsView>ul>li:nth-child(5)>div>a")
	public WebElement wblnkScreenInvestmentsUnderInvestmentProducts;
	@FindBy(css = "#mod_USMarketsInvestmentProductsView>ul>li:nth-child(6)>div>a")
	public WebElement wblnkOptionsstrategyBuilderUnderInvestmentProducts;

	@FindBy(css = "#tabs>div:nth-of-type(1)>ul>li:nth-of-type(2)>span")
	public WebElement wbelemImportantRiskdisclosures;
	@FindBy(id = "createNewWatchlist")
	public WebElement wblnkCreateNewWatchlist;
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(2)>a>span>strong")
	public WebElement wbelemStockScreener;
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span>strong")
	public WebElement wbelemOptionsStrategyBuilder;
	@FindBy(css = "#div-Compare>div:nth-of-type(2)>h2")
	public WebElement wbelemCompareanInvestmentText;
	@FindBy(css = "#mppbmpExt>div:nth-of-type(1)>a")
	public WebElement wblnkCloseCompareTool;
	@FindBy(id = "pucbmpExt")
	public WebElement wbframeCompareTool;

	// Whats moving the markets
	// Sector performance

	@FindBy(css = "#mod_USMarketsRecentRatingsView>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)")
	public WebElement wbelemSectorHeading;
	@FindBy(css = "#mod_USMarketsRecentRatingsView>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemTodaysChangeHeading;
	@FindBy(id = "mod-sectors-link")
	public WebElement wblnkMoreSectorInformation;
	@FindBy(css = "#mod_USMarketsRecentRatingsView>div:nth-of-type(2)>div:nth-of-type(2)>div>a:nth-of-type(1)")
	public WebElement wblnkBofAMLGlobalResearch;
	@FindBy(css = "#mod_USMarketsRecentRatingsView>div:nth-of-type(2)>div:nth-of-type(2)>div>a:nth-of-type(2)")
	public WebElement wblnkMorningStar;
	@FindBy(css = "#mod_USMarketsRecentRatingsView>div:nth-of-type(2)>div:nth-of-type(2)>div>a:nth-of-type(3)")
	public WebElement wblnkSPCapitalIQ;
	@FindBy(css = "#mod_ratingsTable>div>table>thead>tr>th:nth-child(1)")
	public WebElement wbelemSectorPerformanceHeading1;
	@FindBy(css = "#mod_ratingsTable>div>table>thead>tr>th:nth-child(2)")
	public WebElement wbelemSectorPerformanceHeading2;
	@FindBy(css = "#mod_ratingsTable>div>table>thead>tr>th:nth-child(3)")
	public WebElement wbelemSectorPerformanceHeading3;
	@FindBy(css = "#mod_ratingsTable>div>table>thead>tr>th:nth-child(4)")
	public WebElement wbelemSectorPerformanceHeading4;
	
	@FindBy(css = "#pc-thirdPartyOpinionsDetail>div:nth-of-type(2)>h3")
	public WebElement wbelemMorningStarRatingText;
	@FindBy(css = "#pc-thirdPartyOpinionsDetail>div:nth-of-type(2)>h3")
	public WebElement wbelemSPCapitalIQRatingText;
	@FindBy(css = "#analystRatingsChanges>div:nth-of-type(1)>h2")
	public WebElement wbelemBofAMerrillLynchText;

	// Stocks:

	@FindBy(css = "#mod_rankTables>div:nth-of-type(1)>div>div:nth-of-type(1)>table>thead")
	public WebElement wbtblPMostActivesTable;
	@FindBy(css = "#mod_rankTables>div:nth-of-type(2)>div>div:nth-of-type(1)>table>thead")
	public WebElement wbtblPMostGainersTable;
	@FindBy(css = "#mod_rankTables>div:nth-of-type(3)>div>div:nth-of-type(1)>table>thead")
	public WebElement wbtblPMostLosersTable;
	@FindBy(css = "#mod_rankTables>div:nth-of-type(1)>div>div:nth-of-type(2)>a")
	public WebElement wblnkMoreMostActives;
	@FindBy(css = "#mod_rankTables>div:nth-of-type(2)>div>div:nth-of-type(2)>a")
	public WebElement wblnkMoreGainers;
	@FindBy(css = "#mod_rankTables>div:nth-of-type(3)>div>div:nth-of-type(2)>a")
	public WebElement wblnkMoreLosers;
	@FindBy(css = "#mod_rankToggle>ul>li:nth-of-type(1)>a")
	public WebElement wblnkDollarChange;
	@FindBy(css = "#mod_rankToggle>ul>li:nth-of-type(3)>a")
	public WebElement wblnkPercentageChange;
	@FindBy(css = "#mod_holdingsToggle>span:nth-of-type(1)")
	public WebElement wbelemShowOnlyTextUnderStocks;
	@FindBy(css = "#mod_holdingsToggle>span:nth-of-type(2)")
	public WebElement wbelemMyHoldingsTextUnderStocks;
	@FindBy(css = "#mod_holdingsToggle>input:nth-of-type(1)")
	public WebElement wbchkMyHoldingsCheckboxUnderStocks;
	@FindBy(css = "#mod_holdingsToggle>span:nth-of-type(3)")
	public WebElement wbelemMyWatchlistsTextUnderStocks;
	@FindBy(css = "#mod_holdingsToggle>input:nth-of-type(2)")
	public WebElement wbchkMywatchlistCheckboxUnderStocks;

	@FindBy(css = "#mod_USMarketsStocksRankView>div>table>tbody>tr:nth-of-type(1)>td:nth-of-type(1)>a")
	public WebElement wblnkNewsLinkUnderStock;
	@FindBy(css = "#mod_USMarketsStocksRankView>div>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement wbelemNewsSourceUnderStock;
	@FindBy(css = "#mod_USMarketsStocksRankView>div>table>tbody>tr:nth-of-type(3)>td:nth-of-type(1)>div>p")
	public WebElement wbelemNewsTeaserUnderStock;
	@FindBy(css = "#mod_USMarketsStocksRankView>div>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>a")
	public WebElement wblnkReadmoreUnderStock;
	
	@FindBy(css = "#readOnlyTitle>span:nth-of-type(1)")
	public WebElement wbelemSPActiveGainerLoserText;

	// Options
	@FindBy(css = "#us_markets_wmm_composite_widget>div:nth-of-type(1)>div:nth-of-type(2)>ul>li:nth-of-type(2)>a")
	public WebElement wblnkOptionsTab;
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-child(1)>div>div:nth-child(1)>div>div:nth-child(1)")
	public WebElement wbelemAnalysisTextUnderOptions;
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-child(1)>div>div:nth-child(2)>div>div")
	public WebElement wbelemCBOETextUnderOptions;
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelemChangesInOptionVolumeTextUnderOptions;
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelemChangesInOptionOpenInterestTextUnderOptions;

	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-of-type(1)>div>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div")
	public WebElement wbelemSentimentTextUnderOptions;
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-of-type(1)>div>div:nth-of-type(1)>div>div:nth-of-type(3)>div>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div")
	public WebElement wbelem5DayTrendTextUnderOptions;
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-of-type(1)>div>div:nth-of-type(1)>div>div:nth-of-type(4)>p")
	public WebElement wbelemSmartTextUnderOptions;
	@FindBy(css = ".mod-innerunit>img")
	public WebElement wbimgCBOEChartUnderOptions;

	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblChangesInOptionsVolumeTable;
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblChangesInOptionsOpenIntertestTable;
	
	@FindBy(css = "#mod_USMarketsOptionsView>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>td:nth-of-type(1)>strong>a>label")
	public WebElement wbelemSymbolInTableUnderOptions;
	@FindBy(css = "#ctl00_ctl00_ctl01_globalHoverQuoteContainer>div:nth-of-type(1)>span:nth-of-type(2)")
	public WebElement wbelemSymbolHoverOverTextInTableUnderOptions;	

	// ETFs
	@FindBy(css = "#us_markets_wmm_composite_widget>div:nth-of-type(1)>div:nth-of-type(2)>ul>li:nth-of-type(3)>a")
	public WebElement wblnkETFTab;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemETFCategoryTextUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)")
	public WebElement wbelemTimeStampUnderETFs;
	@FindBy(css = ".mod-inline-list")
	public WebElement wbelemPerformanceHeapMapUnderETFs;

	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(1)>a")
	public WebElement wblnk1DayLinkUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(3)>a")
	public WebElement wblnk1MonthLinkUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(5)>a")
	public WebElement wblnk3MonthsLinkUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(7)>a")
	public WebElement wblnk6MonthsLinkUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(9)>a")
	public WebElement wblnk1YearLinkUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(11)>a")
	public WebElement wblnk3YearsLinkUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(13)>a")
	public WebElement wblnk5YearsLinkUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(15)>a")
	public WebElement wblnk10YearsLinkUnderETFs;

	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div>div")
	public WebElement wbelemPerformanceOfAltETFsTextUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemGainersTextUnderETFsPerformance;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemLosersTextUnderETFsPerformance;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblGainersTableUndeETF;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblLosersTableUndeETF;

	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbelemTradingVolumeTextUnderETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemMostActivelyTradedTextUnderTradingVolumeofETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemUnusuallyHighVolumeTextUnderTradingVolumeofETFs;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblMostActivelyTradedTableUndeETF;
	@FindBy(css = "#modUSMarketsETFContent>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblUnUsuallyHighVolumeTableUndeETF;

	
	// Mutual Funds
	
	@FindBy(css = "#us_markets_wmm_composite_widget>div:nth-of-type(1)>div:nth-of-type(2)>ul>li:nth-of-type(4)>a")
	public WebElement wblnkMutualFundsTab;
	
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemMutualFundsCategoryTextUnderMutualFunds;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)")
	public WebElement wbelemTimeStampUnderMutualFundss;
	@FindBy(css = ".mod-inline-list")
	public WebElement wbelemPerformanceHeapMapUnderMutualFunds;
	
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(1)>a")
	public WebElement wblnk1DayLinkUnderMutualFunds;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(3)>a")
	public WebElement wblnk3MonthsLinkUnderMutualFunds;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(5)>a")
	public WebElement wblnk6MonthsLinkUnderMutualFunds;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(7)>a")
	public WebElement wblnk1YearLinkUnderMutualFunds;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(9)>a")
	public WebElement wblnk3YearsLinkUnderMutualFunds;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(11)>a")
	public WebElement wblnk5YearsLinkUnderMutualFunds;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(1)>div:nth-of-type(3)>ul>li:nth-of-type(13)>a")
	public WebElement wblnk10YearsLinkUnderMutualFunds;
	
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(2)>div>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemMunicipalBondCategoryTextUnderMutualFund;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemHighPerformingTextUnderMutualFund;
	
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(2)>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblMunicipalBondCategoryTableUnderMutualFund;
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>table>thead")
	public WebElement wbtblHighPerformingTableUnderMutualFund;
	
	@FindBy(css = "#modUSMarketsMutualFundContent>div:nth-of-type(2)>div>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemTable1HeaderUnderMutualFund;
	
	
	// Fixed Income
	
	@FindBy(css = "#us_markets_wmm_composite_widget>div:nth-of-type(1)>div:nth-of-type(2)>ul>li:nth-of-type(5)>a")
	public WebElement wblnkFixedIncomeTab;
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)")
	public WebElement wbelemAnalysisTextUnderMutualFunds;
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div>div>div:nth-child(2)>div:nth-child(1)>div>div")
	public WebElement wbelemSentimentTextUnderMutualFunds;
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(3)>div>div>div:nth-child(2)>div:nth-child(1)>div>div")
	public WebElement wbelem1MonthTrendTextUnderMutualFunds;
	
	
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(4)>p")
	public WebElement wbelemSmartTextUnderFixedIncome;
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(1)>div:nth-child(2)>div>img")
	public WebElement wbimgChartUnderFixedIncome;
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(2)>div")
	public WebElement wbelemCalendarEventsTextUnderMutualFunds;
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(4)>div")
	public WebElement wbelemMerrillEdgeSelectTextUnderMutualFunds;
	@FindBy(css = "#mod_selectFunds>div:nth-child(1)>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelemEtfsTextUnderMutualFunds;
	@FindBy(css = "#mod_selectFunds>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelemMutualFundsTextUnderMutualFunds;
	
	
	@FindBy(css = "#mod_USMarketsFixedIncomeView>div>div:nth-child(3)>div>table>thead")
	public WebElement wbtblCalendarEventsTableUnderFixedIncome;
	@FindBy(css = "#mod_selectFunds>div:nth-child(1)>div>div:nth-child(2)>table>thead")
	public WebElement wbtblEtfsTableUnderFixedIncome;
	@FindBy(css = "#mod_selectFunds>div:nth-child(2)>div>div:nth-child(2)>table>thead")
	public WebElement wbtblMutualFundsTableUnderFixedIncome;
	@FindBy(css = "#mod_selectFunds>div:nth-of-type(1)>div>div:nth-of-type(3)>a")
	public WebElement wblnkMoreMerrillEdgeETFSUnderFixedIncome;
	@FindBy(css = "#mod_selectFunds>div:nth-of-type(2)>div>div:nth-of-type(3)>a")
	public WebElement wblnkMoreMerrillEdgeFundsUnderFixedIncome;
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span>strong")
	public WebElement wbelemETFScreener;
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span>strong")
	public WebElement wbelemMutualFundsScreener;
	@FindBy(css = "#mod_ETFScreenerHeaderView>div:nth-of-type(1)>div>div>div>div:nth-of-type(1)")
	public WebElement wbelemScreenForETFText;
	@FindBy(css = "#mod_MutualFundScreenerHeaderView>div:nth-of-type(1)>div>div>div>div:nth-of-type(1)")
	public WebElement wbelemScreenForMutualFundsText;
	
	public USMarkets(WebDriver driver) {
		super(driver);
	}

	public List<String> fnGetSectorCategories() {
		try {
			List<String> sectorCategories = new ArrayList<String>();
			for (int i = 1; i < 12; i++) {

				String str = _driver
						.findElement(By.cssSelector("#mod_sectorNav>li:nth-of-type(" + i + ")>div:nth-of-type(2)>a"))
						.getText();
				sectorCategories.add(str);
			}
			return sectorCategories;
		} catch (Exception e) {
			Log.info(e.toString());
			return null;
		}
	}

}
