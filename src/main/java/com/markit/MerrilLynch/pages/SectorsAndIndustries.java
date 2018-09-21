package com.markit.MerrilLynch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.markit.DigitalAutomationFramework.common.Page;
import com.markit.DigitalAutomationFramework.page.ProductPage;

/*
 *
 * @author: Rahul Tiwari	
 * @purpose: This SectorsAndIndustries Page class contains all the elements to be interacted in test scenarios.
 * @creation date: 5/7/2016
 *
 */


public class SectorsAndIndustries extends MerrillLynchProductPage {

	@FindBy(css="#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(4)>a>span>strong")
	public WebElement wblnkSectorIndustriesTab;

	//Sector elements
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(1)>div>div")
	public WebElement wbelemWhatsHappeningText;
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemSectorPerformanceText;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(1)>div>div")
	public WebElement wbelemSectorIndustries;
	@FindBy(css="#mod_SectorHoldings>div:nth-of-type(1)>div>div")
	public WebElement wbelemYourHoldingsSectorText;
	@FindBy(css="#mod_ways_to_invest>div>div>span:nth-of-type(1)")
	public WebElement wbelemWaysToInvestText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(1)>a")
	public WebElement wbelemSectorCompanyAnnouncementsText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(1)>a")
	public WebElement wbelemSectorAnalystRatingsText;
	@FindBy(css="#generic-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(1)")
	public WebElement wbelemLatestSectorNewsText;


	//What's happening in sectors & industries
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(1)") 
	public WebElement wbelemSectorOverviewText;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(2)>p")
	public WebElement wbelemSectorOverviewContent;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div>span")
	public WebElement wbelemDailySectorWrapUpText;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div>div>p:nth-of-type(1)>a")
	public WebElement wblnkDailySectorWrapUpNewsLink;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div>div>p:nth-of-type(2)")
	public WebElement wbelemDailySectorWrapUpNewsSource;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div>div>p:nth-of-type(2)>span")
	public WebElement wbelemDailySectorWrapUpNewsTimestamp;

	//HeatMap
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(3)>div>ul>li")
	public WebElement wbelemSectorHeatMap;
	@FindBy(css="#news_article_full_story>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemNewsFullTitle;
	@FindBy(css="#news_article_full_story>div:nth-of-type(1)>div:nth-of-type(1)>a")
	public WebElement wblnkReturnToNewsLink;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div>div>p:nth-of-type(3)>a")
	public WebElement wblnkReadMoreLink;
	@FindBy(css="#ctl00_ctl00_ctl00_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(7)>a>span>strong")
	public WebElement wblnkNewsTab;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(2)>ul>li:nth-of-type(1)>a")
	public WebElement wblnkHeatMap1MonthLink;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(2)>ul>li:nth-of-type(3)>a")
	public WebElement wblnkHeatMap3MonthLink;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(2)>ul>li:nth-of-type(5)>a")
	public WebElement wblnkHeatMap6MonthLink;
	@FindBy(css="#mod_SectorsWhatsHappeningView>div:nth-of-type(2)>div:nth-of-type(2)>ul>li:nth-of-type(7)>a")
	public WebElement wblnkHeatMap1YearLink;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(1)>a>div")
	public WebElement wbelemEnergyIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(2)>a>div")
	public WebElement wbelemMaterialsIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(3)>a>div")
	public WebElement wbelemUtilitiesIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(4)>a>div")
	public WebElement wbelemHealthCareIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(5)>a>div")
	public WebElement wbelemConsumerDiscretionaryIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(6)>a>div")
	public WebElement wbelemTelecommunicationServicesIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(7)>a>div")
	public WebElement wbelemInformationTechnologyIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(8)>a>div")
	public WebElement wbelemConsumerStaplesIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(9)>a>div")
	public WebElement wbelemFinancialsIcon;
	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(10)>a>div")
	public WebElement wbelemIndustrialsIcon;

	//Performance
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(2)>p")
	public WebElement wbelemSectorText;
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemSectorChart;
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div>span:nth-of-type(1)")
	public WebElement wbelemSectorNameChart;
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div>span:nth-of-type(2)")
	public WebElement wbelemSectorNameVerususChart;

	//Energy industries
	
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(2)>p>span:nth-of-type(1)")
	public WebElement wbelemSectorSmartText1;
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(2)>p>span:nth-of-type(2)")
	public WebElement wbelemSectorSmartText2;
	@FindBy(css="#Sectors_Brief_Chart>div>div:nth-of-type(1)>div>div:nth-of-type(2)>div:nth-of-type(2)>p>span:nth-of-type(3)")
	public WebElement wbelemSectorSmartText3;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>a")
	public WebElement wbelemComapny1CompaniesCount;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wblnkEnergyEquipmentServicesLink;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>a")
	public WebElement wbelemComapny2CompaniesCount;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wblnkCompany1Link;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemIndustries1MonthChangeText;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(1)>div:nth-of-type(2)>span")
	public WebElement wbelemIndustries1MonthChangeValue;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(2)>div:nth-of-type(1)")
	public WebElement wbelemIndustries3MonthChangeText;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(2)>div:nth-of-type(2)>span")
	public WebElement wbelemIndustries3MonthChangeValue;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(3)>div:nth-of-type(1)")
	public WebElement wbelemIndustries6MonthChangeText;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(3)>div:nth-of-type(2)>span")
	public WebElement wbelemIndustries6MonthChangeValue;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(4)>div:nth-of-type(1)")
	public WebElement wbelemIndustries1YearChangeText;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>ul>li:nth-of-type(4)>div:nth-of-type(2)>span")
	public WebElement wbelemIndustries1YearChangeValue;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>p>span:nth-of-type(1)")
	public WebElement wbelemIndustriesSmartTextSectorChange;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>p")
	public WebElement wbelemIndustriesSmartText;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>p>strong>a>label")
	public WebElement wblnkIndustriesSmartTextLink;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>p>span:nth-of-type(2)")
	public WebElement wbelemIndustriesSmartTextEquityChange;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>select")
	public WebElement wblstIndicesDropdown;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>select")
	public WebElement wblstMarketCapDropdown;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(1)>table")
	public WebElement wbelemIndustriesTable;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(1)>table>thead>tr>th")
	public WebElement wbelemIndustriesTableHeaders;
	@FindBy(css="#mod_SectorsIndustryView>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>a")
	public WebElement wblstIndustriesViewAllLink;

	@FindBy(css="#ctl00_ctl00_ctl00_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(2)>a>span>strong")
	public WebElement wblnkStockScreenerTab;

	//Ways to invest in Energy
	
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)>div")
	public WebElement wbelemBookIcon;
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-of-type(1)>td:nth-of-type(1)>div")
	public WebElement wbelemWaysToInvestStocksText;
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-of-type(2)>td>div>a")
	public WebElement wblnkWaysToInvestBuyRatedStocksLink;
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-of-type(3)>td>div")
	public WebElement wbelemWaysToInvestMFText;
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-of-type(4)>td>div>a")
	public WebElement wblnkWaysToInvestSectorSpecificFundsLink;

	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-of-type(5)>td>div")
	public WebElement wbelemWaysToInvestETFText;
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-of-type(6)>td>div>a")
	public WebElement wblnkWaysToInvestHighlyRatedETFsLink;

	@FindBy(css="#ctl00_ctl00_ctl00_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span>strong")
	public WebElement wblnkETFScreeenersTab;

	@FindBy(css="#ctl00_ctl00_ctl00_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(2)>a>span>strong")
	public WebElement wblnkStockScreeenersTab;

	@FindBy(css="#ctl00_ctl00_ctl00_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span>strong")
	public WebElement wblnkMFScreeenersTab;

	
	//Company announcements
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemEarningsAnnouncementTabText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemEarningsAnnouncementTabValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemDividendTabText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemDividendTabValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(3)>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemSplitsTabText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(3)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemSplitsTabValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(1)>div")
	public WebElement wbelemCalendarIcon;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(1)>p>span:nth-of-type(1)")
	public WebElement wbelemSmartTextHeader;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(1)>p>span:nth-of-type(2)")
	public WebElement wbelemSmartTextHeaderText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(3)>a")
	public WebElement wblnkCompanyAnnouncementViewAllCompaniesLink;

	@FindBy(css=".clearfix.mod-tabs>li:nth-of-type(2)>a")
	public WebElement wblnkCompanyEventTab;
	
	//Company announcements -Dividends
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbelemDividendAmtText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement wbelemDividendAmtValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbelemExDateText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public WebElement wbelemExDatevalue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(3)")
	public WebElement wbelemDivYieldText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(3)")
	public WebElement wbelemDivYieldValue;

	//Company announcements -Earnings
	@FindBy(css="#mod_SectorsEarningsAnno"
			+ "uncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbelemActualEarnings;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement wbelemActualEarningsValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbelemEstimate;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public WebElement wbelemEstimateValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(3)")
	public WebElement wbelemBeatBelowExpectationsText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(3)>span")
	public WebElement wbelemBeatBelowExpectationsValue;

	//Company announcements -Splits
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbelemSplitsExDate;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement wbelemSplitsExDateValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbelemSplitsRatio;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public WebElement wbelemSplitsRatioValue;

	//Analyst Ratings 
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>p>span:nth-of-type(1)")
	public WebElement wbelemAnalystRatingSmartTextHeader;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>p>span:nth-of-type(2)")
	public WebElement wbelemAnalystRatingSmartTextContent;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)>div")
	public WebElement wbelemAnalystRatingCalendar;

	//Analyst Ratings S&P
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemAnalystRatingSPText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(1)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemAnalystRatingSPValue;
	
	//Analyst Ratings BoAML
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemAnalystRatingBoAMLText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(2)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemAnalystRatingBoAMLValue;
	
	//Analyst Ratings Morningstar
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(3)>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemAnalystRatingMorningStarText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(1)>ul>li:nth-of-type(3)>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemAnalystRatingMorningStarValue;

	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(3)>a")
	public WebElement wblnkAnalystRatingsViewAllLink;
	//SP Ratings
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbElemAnalystRatingsSPPrevRatingText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement wbElemAnalystRatingsSPPrevRatingValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbElemAnalystRatingsSPCurrentRatingText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public WebElement wbElemAnalystRatingsSPCurrentRatingValue;

	//BOAML Ratings
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbElemAnalystRatingsBOPrevRatingText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement wbElemAnalystRatingsBOPrevRatingValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbElemAnalystRatingsBOCurrentRatingText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public WebElement wbElemAnalystRatingsBOCurrentRatingValue;

	//ratings Morning star
	
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement wbElemAnalystRatingsMSPrevRatingText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement wbElemAnalystRatingsMSPrevRatingValue;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement wbElemAnalystRatingsMSCurrentRatingText;
	@FindBy(css="#mod_SectorsEarningsAnnouncementsContent>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(3)>div>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public WebElement wbElemAnalystRatingsMSCurrentRatingValue;

	//Latest News
	
	@FindBy(css="#generic-view>div:nth-of-type(2)>div:nth-of-type(1)>div>a")
	public WebElement wblnkNewsHeadline1Link;
	@FindBy(css="#companies_in_the_news_widget>div:nth-of-type(1)")
	public WebElement wbelemCompaniesInNews;
	@FindBy(css="#generic-view>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(2)")
	public WebElement wbelemNewsTeaser;
	@FindBy(css="#generic-view>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(2)>div>a")
	public WebElement wblnkNewsReadMoreLink;
	@FindBy(css="#generic-view>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>span:nth-of-type(1)")
	public WebElement wbelemNewsSource;
	@FindBy(css="#generic-view>div:nth-of-type(2)>div:nth-of-type(1)>div>div>div:nth-of-type(1)>span:nth-of-type(2)")
	public WebElement wbelemNewsTimestamp;
	@FindBy(css="#generic-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(2)>span>span:nth-of-type(1)")
	public WebElement wbelemShowOnlText;
	@FindBy(css="#generic-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(2)>span>span:nth-of-type(2)>input")
	public WebElement wbchkMyHoldingCheckbox;
	@FindBy(css="#generic-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(2)>span>span:nth-of-type(3)>input")
	public WebElement wbchkMyWatchlistCheckbox;
	@FindBy(css="#generic-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(2)>span>span:nth-of-type(2)>span")
	public WebElement wbelemMyHoldingText;
	@FindBy(css="#generic-view>div:nth-of-type(1)>div>div>div>div:nth-of-type(2)>span>span:nth-of-type(3)>span")
	public WebElement wbelemMyWatchlistText;
	@FindBy(css="#generic-view>div:nth-of-type(3)>a")
	public WebElement wblnkMoreSectorNewsLink;
	@FindBy(css="#generic-view>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>a")
	public WebElement wblnkNewsHeadlineLink;
	@FindBy(css="#companies_in_the_news_widget>div:nth-of-type(3)")
	public WebElement wbelemNewsTableAsOfTimeStamp;
	@FindBy(css="#hover-news-intro>div>div>div>div:nth-of-type(1)>div>div:nth-of-type(1)")
	public WebElement wbelemNewsHoverTimestamp;
	@FindBy(css="#hover-news-intro>div>div>div>div:nth-of-type(1)>div>div:nth-of-type(2)")
	public WebElement wbelemNewsHoverSource;
	@FindBy(css="#hover-news-intro>div>div>div>div:nth-of-type(2)")
	public WebElement wbelemNewsHoverTeaser;
	@FindBy(css=".mod-article-headline.mb-s")
	public WebElement wbelemNewsTitleFull;

	public SectorsAndIndustries(WebDriver driver) {
		super(driver);
	}

}

