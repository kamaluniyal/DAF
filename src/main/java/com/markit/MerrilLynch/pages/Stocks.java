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
* @creation date: 15/12/2016
*
*/

public class Stocks extends MerrillLynchProductPage {
		
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_H1Tag']/div/span")
	public WebElement wbelemStocksText;	
	
	
	//Overview
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_searchWidget_txtProfileSymbol")
	public WebElement wbtxtSearchBoxOnStocks;
	@FindBy(id = "drpRRnNews")
	public WebElement wblstStocksDropdown;
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_searchWidget_litSearch")
	public WebElement wbbtnSerachButton;
	@FindBy(id = "dL2T")
	public WebElement wbelemSecurityProfile;
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_artBack")
	public WebElement wblnkBackToOverviewLink;
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphTopBackButtonControl_Top_BackButton")
	public WebElement wblnkBackToOverviewLinkOnNews;
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_H1Tag']/div/span[1]")
	public WebElement wbelemSymbolNameText;
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStage_Stage_lblNewsRes")
	public WebElement wbelemNewsSearchResults;
	
	//indices on stocks page
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_marketIndices_divMarketIndicesWrapper']/table/tbody/tr/td[1]/div/span[1]/a/span")
	public WebElement wbelemFirstIndexOnStocks;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_marketIndices_divMarketIndicesWrapper']/table/tbody/tr/td[2]/div/span[1]/a/span")
	public WebElement wbelemSecondIndexOnStocks;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_marketIndices_divMarketIndicesWrapper']/table/tbody/tr/td[3]/div/span[1]/a/span")
	public WebElement wbelemThirdIndexOnStocks;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_globalHoverQuoteContainer']/div[1]")
	public WebElement wbelemIndicesHoverTextOnStocks;
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_marketIndices_divMarketIndicesWrapper']/span")
	public WebElement wbelemStaticTextBelowIndices;
		
	// Stock Strategies
	
	@FindBy(xpath = ".//*[@id='researchExperts']/h4")
	public WebElement wbelemStrategiesFromResearchFirms;	
	@FindBy(xpath = ".//*[@id='popularScreener']/h4")
	public WebElement wbelemPopularScreeningStrategies;	
	@FindBy(xpath = ".//*[@id='customScreener']/h4")
	public WebElement wbelemCreateYourOwnScreen;
	@FindBy(xpath = ".//*[@id='researchExperts']/h4")
	public WebElement wbelemBankOfAmericaMerrillLynch;
	@FindBy(xpath = ".//*[@id='researchExperts']/table/tbody/tr/td[1]/div/a[2]")
	public WebElement wblnkMoreLinkUnderBankOfAmericaMerrillLynch;
	@FindBy(xpath = ".//*[@id='popularScreener']/h4")
	public WebElement wbelemMorningStar;
	@FindBy(xpath = ".//*[@id='researchExperts']/table/tbody/tr/td[2]/div/a[2]")
	public WebElement wblnkMoreLinkUnderMorningStar;
	@FindBy(xpath = ".//*[@id='customScreener']/h4")
	public WebElement wbelemSPCapitalIQ;
	@FindBy(xpath = ".//*[@id='researchExperts']/table/tbody/tr/td[3]/div/a[2]")
	public WebElement wblnkMoreLinkUnderSPCapitalIQ;

	//Popular Screens
	
	@FindBy(xpath = ".//*[@id='popularScreener']/ul/li[1]/a")
	public WebElement wbelemFirstPopularScreen;	
	@FindBy(xpath = ".//*[@id='popularScreener']/ul/li[2]/a")
	public WebElement wbelemSecondPopularScreen;		
	@FindBy(xpath = ".//*[@id='popularScreener']/ul/li[3]/a")
	public WebElement wbelemThirdPopularScreen;	
	@FindBy(xpath = ".//*[@id='researchExperts']/table/tbody/tr/td[3]/div/a[2]")
	public WebElement wblnkMoreLinkUnderPopularScreeningStrategy;
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStage_Stage_lblStockScr")
	public WebElement wbelemCustomScreens;
		
	// Create your own  Screen
	
	@FindBy(xpath = ".//*[@id='customScreener']/div[1]")
	public WebElement wbelemCreateYourOwnScreenText;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_marketIndices_divMarketIndicesWrapper']/table/tbody/tr/td[2]/div/span[1]/a/span")
	public WebElement wbbtnCreateScreenButton;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_marketIndices_divMarketIndicesWrapper']/table/tbody/tr/td[3]/div/span[1]/a/span")
	public WebElement wblstScreenDropdown;	
	
	// Calendar
	
	@FindBy(xpath = ".//*[@id='contentCol']/div[3]/div[3]/div[1]/h3")
	public WebElement wbelemCalendarText;	
	@FindBy(id = "liEcnmcCalndr")
	public WebElement wblnkEconomicCalendarLink;	
	@FindBy(xpath = ".//*[@id='liStckSplits']/a")
	public WebElement wblnkStocksSplitsLink;
	@FindBy(xpath = ".//*[@id='liPblcOffrngs']/a")
	public WebElement wblnkPublicOfferingsLink;	
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStage_Stage_calendarWidget_ankEcnmcCalndr")
	public WebElement wblnkViewMoreEvents;	
	
	//Latest Stocks
	
	@FindBy(xpath = ".//*[@id='pc-latestHeadlines']/h3")
	public WebElement wbelemLatestStocksNewsText;		
	@FindBy(xpath = ".//*[@id='pc-latestHeadlines']/div[2]/a")
	public WebElement wblnkViewMoreStocksNews;	
	@FindBy(xpath = ".//*[@id='pc-latestHeadlines']/div[1]/div[1]/a")
	public WebElement wblnkFirstNewsUnderLatstStocksNews;	
	@FindBy(xpath = ".//*[@id='mod_related_news']/div[1]/h3")
	public WebElement wbelemRelatedNews;
	@FindBy(id = "ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStageTop_Top_artBack")
	public WebElement wblnkBackToOverviewLinkOnNewsSection;
	
	// Featured Research Reports
	
	@FindBy(xpath = ".//*[@id='pc-featuredResearch']/div[1]/h3")
	public WebElement wbelemFeaturedResearchReportsText;		
	@FindBy(xpath = ".//*[@id='pc-featuredResearch']/div[3]/a")
	public WebElement wblnkViewMoreStocksResearch;	
	@FindBy(xpath = ".//*[@id='pc-featuredResearch']/div[2]/div[1]/div[2]/span[1]/a")
	public WebElement wblnkFirstReportUnderFeaturedResearchReports;	
	@FindBy(xpath = ".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[12]")
	public WebElement wbelemReportTitleInPDF;	

	
	//Related Insights
	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphStage_Stage_ecmsWPRECMSContentFeatureStoryHeader']/h3")
	public WebElement wbelemRelatedInsightsText;		
	@FindBy(xpath = ".//*[@id='STbtn1']/span[2]")
	public WebElement wbelemInvestingInStocks;	
	@FindBy(xpath = ".//*[@id='STbtn2']/span[2]")
	public WebElement wbelemPortfolioRebalancing;	
	
	
//	Free Fundamental Analysis
	
	@FindBy(xpath = ".//*[@id='eta__ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphRight1_Right_ecmsWPRECMSContentMarketing1__div-7_a-1_img-1']")
	public WebElement wbimgFreeFundamentalAnalysis;		
	@FindBy(xpath = ".//*[@id='rightContentCol']/div/div[2]/h3")
	public WebElement wbelemSectorSummary;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphRight1_Right_sectorSummaryWidget_rptSectorSummary_ctl01_lnkSectorName']")
	public WebElement wblnkFirstSector;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphRight1_Right_sectorSummaryWidget_ankStockMore']")
	public WebElement wblnkViewMoreNewsResearchBySector;	
	@FindBy(id = "h2SectorTitle")
	public WebElement wbelemSectorSummaryTitle;
	
	//BofAML Research Changes
	
	@FindBy(xpath = ".//*[@id='dvBofAMLContainer']/h3")
	public WebElement wbelemBofAMLResearchChanges;		
	@FindBy(id = "ddBofAMLAnalyst")
	public WebElement wblstViewByDropdown;	
	@FindBy(id = "ddBofAMLRCSubSelect")
	public WebElement wblstChangeTypeDropdown;	
	@FindBy(xpath = ".//*[@id='GridBofAMLRatingChanges_tableh_0']/tbody")
	public WebElement wbtblResearchTable;	
	@FindBy(xpath = ".//*[@id='ctl00_ctl00_ctl01_cphSiteMst_cphNestedPage_cphRight1_Right_bofaMLResearchWidget_ankBofAMLRC']")
	public WebElement wblnkViewMoreBofAMLRatingsCHanges;
	
	@FindBy(xpath = ".//*[@id='pc-analystOpinions']/div[2]/h3")
	public WebElement wbelemBofAMLRatingComponentChanges;
	
	public Stocks(WebDriver driver ) {
		super(driver);		
	}


}
