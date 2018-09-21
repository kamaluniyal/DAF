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
* @creation date: 12/7/2016
*
*/

public class DebtMarkets extends MerrillLynchProductPage {
	
	
//	Different section:
	
	@FindBy(css = "#mod_Moving_The_Markets>div>h3")
	public WebElement wbelemMovingTheMarketText;	
	
	
	// US Treasury Section:
	
	@FindBy(css = "#mod_debt_markets_composite_widget>div:nth-child(1)>div")
	public WebElement wbelemUSTreasuryText;
	@FindBy(css = "#mod_treasury_yield_curve>div:nth-of-type(1)")
	public WebElement wbimgTreasuryYieldCurveText;
	@FindBy(css = "#mod_treasury_yield_curve>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div>div>div>div:nth-child(2)>div:nth-child(1)>div>div")
	public WebElement wbelemAnalysisText;
	@FindBy(css = "#mod_treasury_yield_curve>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div>div>div:nth-child(2)>div:nth-child(1)>div>div")
	public WebElement wbelem1MonthTrendText;
	@FindBy(css = "#mod_treasury_yield_curve>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemAnalysisIcon;	
	@FindBy(css = "#mod_treasury_yield_curve>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div>div>div>div:nth-child(1)")
	public WebElement wbelem1MonthTrendIcon;
	@FindBy(css = "#mod_treasury_yield_curve>div:nth-child(2)>div:nth-child(3)>img")
	public WebElement wbimgTreasuryYieldCurveChart;
	@FindBy(css = "#mod_treasury_yield_curve>div:nth-child(2)>div:nth-child(4)")
	public WebElement wbelemTimeStampBelowTreasuryYieldCurve;
	
	
	// Latest Fixed Income news:
	
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemLatestFixedIncomeNewsText;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(1)")
	public WebElement wbelemShowOnlyUnderLatestFixedincome;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>input")
	public WebElement wbchkboxMyHoldingsUnderLatestFixedincome;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>input")
	public WebElement wbchkboxMyWatchlistUnderLatestFixedincome;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>span")
	public WebElement wbelemMyHoldingsTextUnderLatestFixedincome;
	@FindBy(css = "#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>span")
	public WebElement wbelemMyWatchlistTextUnderLatestFixedincome;
	@FindBy(css = "#generic-view>div:nth-child(3)>a")
	public WebElement wblnkMoreFixedIncomeNews;
	@FindBy(css = "#companies_in_the_news_widget>div:nth-child(1)")
	public WebElement wbelemCompaniesInTheNews;
	@FindBy(css = "#companies_in_the_news_widget>div:nth-child(3)")
	public WebElement wbelemTimeStampForCompaniesInTheNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>a")
	public WebElement wblnkNewsHeadlineOnLatestFixedIncomeNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemTeaserForFirstNewsOnLatestFixedIncomeNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(1)")
	public WebElement wbelemCompanyNameForNewsOnLatestFixedIncomeNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(2)")
	public WebElement wbelemTimeStampInformationForNewsOnLatestFixedIncomeNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)>div>a")
	public WebElement wblnkReadMoreOnLatestFixedIncomeNews;
	
	@FindBy(css = "#news_article_full_story>div:nth-of-type(1)>div:nth-of-type(1)>a:nth-of-type(2)")
	public WebElement wblnkReturnToDebtMarketsNews;

	@FindBy(css="#generic-view>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>a")
	public WebElement wblnkSecondNewsHealine;
	@FindBy(css="#hover-news-intro>div>h1")
	public WebElement wbelemHoverNewsModalHeader;
	@FindBy(css="#hover-news-intro>div>div>div>div:nth-child(1)>h2")
	public WebElement wbelemHoverNewsTitle;
	
		
	// Latest Fixed Income Reports
	
	@FindBy(css = "#generic-research-view>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemLatestFixedIncomeReportsText;
	@FindBy(css = "#generic-research-view>div:nth-child(1)>div>div>div>div:nth-child(2)")
	public WebElement wbelemLogoUnderLatestFixedIncomeReports;
	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>a")
	public WebElement wblnkNewsHeadlineUnderLatestFixedIncomeReports;
	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span")
	public WebElement wbelemTimeStampInformationForLatestFixedIncomeReports;
	@FindBy(css = "#generic-research-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemTeaserForLatestFixedIncomeReports;
	@FindBy(css = "#generic-research-view>div:nth-child(3)>a")
	public WebElement wblnkMoreResearchReports;

	//Treasury bond maturities
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(1)>div>div")
	public WebElement wbelemTreasuryBondMaturitiesText;
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(1)>a")
	public WebElement wblnk1weekLinkUnderTreasuryBondMaturities;	
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(3)>a")
	public WebElement wblnk1MonthLinkUnderTreasuryBondMaturities;
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(5)>a")
	public WebElement wblnk3MonthsLinkUnderTreasuryBondMaturities;
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(7)>a")
	public WebElement wblnk6MonthsLinkUnderTreasuryBondMaturities;
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(2)>div:nth-child(1)>ul>li:nth-child(9)>a")
	public WebElement wblnk1yearLinkUnderTreasuryBondMaturities;
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(3)>div>p")
	public WebElement wbelemTimeStampUnderTreasuryBondMaturities;	
	@FindBy(css = "#Treasury_Bond_Maturities>div:nth-child(2)>div:nth-child(3)>div>table>thead")
	public WebElement wbtblTreasuryBondMaturitiesTable;
	
	
	//Ways to invest in debt markets
	@FindBy(css = "#mod_ways_to_invest>div>div:nth-child(1)")
	public WebElement wbelemWaysToInvestInDebtMarketsText;	
	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(1)>tbody>tr>td>div>a")
	public WebElement wblnkFixedIncomeCenter;	
	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-of-type(1)>td:nth-of-type(1)>div")
	public WebElement wbelemMerrillEdgeSelectFundsText;	
	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-of-type(4)>td:nth-of-type(1)>div")
	public WebElement wbelemMerrillEdgeSelectETFsText;	
	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-child(2)>td>div>a")
	public WebElement wblnkTaxableBondFunds;	
	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-child(3)>td>div>a")
	public WebElement wblnkMunicipalBondFunds;	
	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-child(5)>td>div>a")
	public WebElement wblnkTaxableBondETFs;	
	@FindBy(css = "#mod_ways_to_invest>div>table:nth-of-type(2)>tbody>tr:nth-child(6)>td>div>a")
	public WebElement wblnkMunicipalBondETFs;
	
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_H1Tag>div:nth-of-type(1)>span")
	public WebElement wbelemResearchText;
	@FindBy(css = "	#news_search_widget>div>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div")
	public WebElement wbelemSerachNewsText;
	@FindBy(css = "#ctl00_ctl00_ctl00_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span>strong")
	public WebElement wbelemMutualFundsScreener;
	@FindBy(css = "#mod_MutualFundScreenerHeaderView>div:nth-of-type(1)>div>div>div>div:nth-of-type(1)")
	public WebElement wbelemScreenForMutualFundsText;
	
	
	//Fixed income ETFs
	
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-child(1)>div>div")
	public WebElement wbelemFixedIncomeETFsText;
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wbelemUSBroadMarketETFs;
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wbelemUSCorporateETFs;
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wbelemUSTreasuryETFs;
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-child(2)>div:nth-child(1)>div:nth-child(4)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wbelemUSMunicipalETFs;
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>img")
	public WebElement wbimgTopPerformingChart;
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div>div:nth-of-type(1)>table>thead")
	public WebElement wbtblTopPerformingFundsTable;	
	@FindBy(css = "#mod_fi_etfs_widget>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div>div:nth-of-type(2)>a")
	public WebElement wblnkFindFundsUsingOurScreener;
	@FindBy(css = "#ctl00_ctl00_ctl00_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span>strong")
	public WebElement wbelemETFScreener;
	@FindBy(css = "#mod_ETFScreenerHeaderView>div:nth-of-type(1)>div>div>div>div:nth-of-type(1)")
	public WebElement wbelemScreenForETFText;
	
	public DebtMarkets(WebDriver driver ) {
		super(driver);		
		
	}

	public List<String> fnGetSectorCategories() {
		try {
			List<String> sectorCategories = new ArrayList<String>();
			for (int i = 1; i < 11; i++) {

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
