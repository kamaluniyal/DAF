package com.markit.MerrilLynch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketEvents extends MerrillLynchProductPage{

	@FindBy(css="#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(5)>a>span>strong")
	public WebElement wblnkMarketEventstab;
	
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(1)>div")
	public WebElement wbelemMajorEconomicIndicatorText;
	// Major indicators
	@FindBy(css="#mod_indicatorsNav>li:nth-of-type(1)>div:nth-of-type(1)>a")
	public WebElement wblnkGDPtab;
	@FindBy(css="#mod_indicatorsNav>li:nth-of-type(2)>div:nth-of-type(1)>a")
	public WebElement wblnkCPItab;
	@FindBy(css="#mod_indicatorsNav>li:nth-of-type(3)>div:nth-of-type(1)>a")
	public WebElement wblnkRetailSalesTab;
	@FindBy(css="#mod_indicatorsNav>li:nth-of-type(4)>div:nth-of-type(1)>a")
	public WebElement wblnkUnemploymentRateTab;
	@FindBy(css="#mod_indicatorsNav>li:nth-of-type(5)>div:nth-of-type(1)>a")
	public WebElement wblnkTradeBalanceReportTab;
	@FindBy(css="#mod_indicatorsNav>li:nth-of-type(6)>div:nth-of-type(1)>a")
	public WebElement wblnkFactoryOrderTab;
	@FindBy(css="#mod_indicatorsNav>li:nth-of-type(7)>div:nth-of-type(1)>a")
	public WebElement wblnkHousingStartsTab;
	@FindBy(css="#mod_calendarEconomicEventsHeader>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemSearchEventCalText;
	@FindBy(css="#MODCalendarKeywordSearch")
	public WebElement wbelemEconomicSearchbox;
	@FindBy(css=".mod-economic-indicators-chart")
	public WebElement wbelemPerformanceChart;
	// Economic event Components
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)")
	public WebElement wbelemSummaryText;
	@FindBy(css=".economic-indicators-description>div:nth-of-type(4)")
	public WebElement wbelemEconodayText;
	@FindBy(css=".mod-economic-indicators-viewfull")
	public WebElement wblnkViewFullAnalysisLink;
	@FindBy(css=".mod-economic-indicators-chartnav>a:nth-of-type(4)")
	public WebElement wbelem1Year;
	@FindBy(css=".mod-economic-indicators-chartnav>a:nth-of-type(3)")
	public WebElement wbelem6Month;
	@FindBy(css=".mod-economic-indicators-chartnav>a:nth-of-type(2)")
	public WebElement wbelem3Month;
	@FindBy(css=".mod-economic-indicators-chartnav>a:nth-of-type(1)")
	public WebElement wbelem1Month;
	@FindBy(css=".mod-economic-indicators-charttitle")
	public WebElement wbelemChartHeader;
	@FindBy(css="#mod_calendarEconomicEventsHeader>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)")
	public WebElement wbelemEconomicEventSelectWeekText;
	@FindBy(css=".mod-calendar-dateselect")
	public WebElement wbelemEconomicEventDateInput;
	@FindBy(css=".mod-sprite.mod-icon-calendar-small.clickable")
	public WebElement wbelemEconomicEventDateClickable;
	@FindBy(css=".mod-calendar-datepicker-close")
	public WebElement wbelemCalendarCloselink;
	@FindBy(css="#mod_EventsReset")
	public WebElement wblnkResetLink;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(1)")
	public WebElement wbelemEconomicEventText;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(2)")
	public WebElement wbelemCompanyEventText;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div")
	public WebElement wbelemModalHeadingText;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)>table>tbody>tr:nth-of-type(1)>td:nth-of-type(1)")
	public WebElement wbelemModalConsensusEstimateValue;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)>table>tbody>tr:nth-of-type(2)>th:nth-of-type(1)")
	public WebElement wbelemModalConsensusEstimateText;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)")
	public WebElement wbelemModalActualEstimateValue;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)>table>tbody>tr:nth-of-type(2)>th:nth-of-type(2)")
	public WebElement wbelemModalActualEstimateText;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)>table>tbody>tr:nth-of-type(1)>td:nth-of-type(3)")
	public WebElement wbelemModalPreviousPeriodValue;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)>table>tbody>tr:nth-of-type(2)>th:nth-of-type(3)")
	public WebElement wbelemModalPreviousPeriodText;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>a")
	public WebElement wblnkModalCloseLink;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>a>div")
	public WebElement wbbtnModalCloseXButton;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(6)>div")
	public WebElement wbelemModalEconodayLogo;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(4)>div:nth-of-type(1)")
	public WebElement wbelemModalAnalysisHeader;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(6)>p")
	public WebElement wbelemModalDisclaimerText;
	@FindBy(css="#mod_CalendarEconomicIndicators>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(4)>div:nth-of-type(2)")
	public WebElement wbelemModalSmartText;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div")
	public WebElement wbtblCurrentWeekTable;
	@FindBy(css=".previous-week-link")
	public WebElement wblnkPreviousWeekLink;
	@FindBy(css=".today-link")
	public WebElement wblnkTodayLink;
	@FindBy(css=".next-week-link")
	public WebElement wblnkNextWeekLink;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemEconomicEvents1stDayDate;
	
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(2)>div")
	public WebElement wbelemEventModalHeadingText;
	
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div")
	public WebElement wbelemEconomicEvents1stDayContent;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemEconomicEvents2ndDayDate;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div")
	public WebElement wbelemEconomicEvents2ndDayContent;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemEconomicEvents3rdDayDate;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(2)>div")
	public WebElement wbelemEconomicEvents3rdDayContent;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemEconomicEvents4thDayDate;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(2)>div")
	public WebElement wbelemEconomicEvents4thDayContent;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemEconomicEvents5thDayDate;
	@FindBy(css="#mod_CalendarEconomicEventsContent>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)>div")
	public WebElement wbelemEconomicEvents5thDayContent;
	@FindBy(css="#mod_EconomicEventsTable>div:nth-of-type(2)>div>table")
	public WebElement wbtblEventsTable;	
	
	
	@FindBy(css="#mod_EconomicEventsTable>div:nth-of-type(1)>div")
	public WebElement wbtblEventsHeaderText;
	
	@FindBy(css="div.mod-market-reflections-month")
	public WebElement wbelemMarketReflectionDayMonth;
	@FindBy(css="div.mod-market-reflections-day")
	public WebElement wbelemMarketReflectionDate;
	@FindBy(css="#mod_EconomicEventsTable>div:nth-of-type(3)>div:nth-of-type(2)")
	public WebElement wbelemMarketReflectionHeader;
	@FindBy(css="#mod_EconomicEventsTable>div:nth-of-type(3)>p")
	public WebElement wbelemMarketReflectionText;
	
	@FindBy(css="#mod_EconomicEventsTable>div:nth-of-type(2)>div:nth-of-type(1)>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)>a")
	public WebElement wblnkEventTable1stRowEvent;
	@FindBy(css=".mod-economic-indicators-modal-close>a")
	public WebElement wblnkEventModalCloseLink;
	
	@FindBy(css="#mod_calendarCompanyEventsHeader>div>div:nth-of-type(3)>div:nth-of-type(2)>div:nth-of-type(1)")
	public WebElement wbelemCompanySearchEventCalText;
	
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div")
	public WebElement wbelemCompanyCurrentWeekTable;
	
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemCompanyEarningLegend;
	
	
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)")
	public WebElement wbelemCompanyDividendLegend;
	
	
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)")
	public WebElement wbelemCompanySplitLegend;
	
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(1)>div")
	public WebElement wbelemCompanyEarningsHeaderText;
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(2)>div")
	public WebElement wbelemCompanyEarningsNoEventsText;
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(2)>div>table")
	public WebElement wbtblCompanyEarningsTable;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(1)>div")
	public WebElement wbelemCompanyDividendsHeaderText;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(2)>div")
	public WebElement wbelemCompanyDividendNoEventsText;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(2)>div>table")
	public WebElement wbtblCompanyDividendsTable;
	
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(2)>div")
	public WebElement wbelemCompanySplitsNoEventsText;
	
	
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(1)>div")
	public WebElement wbelemStockSplitsHeader;
	
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(2)>div>table")
	public WebElement wbtblStockSplitsTable;
	@FindBy(css="#MODCalendarSymbolSearch")
	public WebElement wbelemCompanyEventSearchbox;
	@FindBy(css="#mod_calendarCompanyEventsHeader>div>div:nth-of-type(2)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEventSelectWeekText;
	@FindBy(css=".mod-calendar-dateselect")
	public WebElement wbelemCompanyEventDateInput ;
	@FindBy(css=".mod-sprite.mod-icon-calendar-small.clickable")
	public WebElement wbelemCompanyEventDateClickable;
	@FindBy(css=".mod-calendar-datepicker-close")
	public WebElement wbelemCompanyEventCalendarCloselink;
	@FindBy(css="#mod_EventsReset")
	public WebElement wblnkCompanyEventResetLink;
	@FindBy(css="#mod_calendarCompanyEventsHeader>div>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEventShowOnlyText;
	@FindBy(css="#my-holdings")
	public WebElement wbChkMyHoldingsCheckbox;
	@FindBy(css="#my-watchlist")
	public WebElement wbChkMyWatchlistCheckbox;
	//Comapany events tab
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEvents1stDayDate;
	
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemCompanyEvents1stDayContent;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEvents2ndDayDate;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemCompanyEvents2ndDayContent;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEvents3rdDayDate;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemCompanyEvents3rdDayContent;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEvents4thDayDate;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemCompanyEvents4thDayContent;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEvents5thDayDate;
	@FindBy(css="#mod_CalendarCompanyEventsContent>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemCompanyEvents5thDayContent;
	//Comapany Earnings
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(3)>div:nth-of-type(1)")
	public WebElement wbelemCompanyEarningShowingText;
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(3)>div:nth-of-type(2)>a:nth-of-type(2)")
	public WebElement wblnkCompanyEarningNextLink;
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(3)>div:nth-of-type(2)>a:nth-of-type(1)")
	public WebElement wblnkCompanyEarningPreviousLink;
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(3)>div:nth-of-type(2)>select")
	public WebElement wbLstCompanyEarningPageDropdown;
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(3)")
	public WebElement wbelemCompanyEarningAsOfDateForLessThan10;
	@FindBy(css="#mod_CompanyEarningsTable>div:nth-of-type(4)")
	public WebElement wbelemCompanyEarningAsOfDateForMoreThan10;
	//Comapany Dividends
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(3)>div:nth-of-type(2)>a:nth-of-type(1)")
	public WebElement wblnkCompanyDivPreviousLink;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(3)>div:nth-of-type(2)>a:nth-of-type(2)")
	public WebElement wblnkCompanyDivNextLink;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(3)>div:nth-of-type(2)>select")
	public WebElement wbLstCompanyDivPageDropdown;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(3)>div:nth-of-type(1)")
	public WebElement wbelemCompanyDivShowingText;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(3)")
	public WebElement wbelemCompanyDivAsOfDateForLessThan10;
	@FindBy(css="#mod_CompanyDividendsTable>div:nth-of-type(4)")
	public WebElement wbelemCompanyDivAsOfDateForMoreThan10;
	//Comapany Stock Splits
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(3)>div:nth-of-type(1)")
	public WebElement wbelemStockSplitsShowingText;
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(3)>div:nth-of-type(2)>a:nth-of-type(2)")
	public WebElement wblnkStockSplitsNextLink;
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(3)>div:nth-of-type(2)>a:nth-of-type(1)")
	public WebElement wblnkStockSplitsPreviousLink;
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(3)>div:nth-of-type(2)>select")
	public WebElement wbLstStockSplitsPageDropdown;
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(3)")
	public WebElement wbelemStockSplitsAsOfDateForLessThan10;
	@FindBy(css="#mod_StockSplitsTable>div:nth-of-type(4)")
	public WebElement wbelemStockSplitsAsOfDateForMoreThan10;


	public MarketEvents(WebDriver driver) {
		super(driver);

	}
}



