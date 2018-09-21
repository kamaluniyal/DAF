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
* @purpose: This Commodities page class contains all the elements to be interacted in test scenarios.
* @creation date: 11/7/2016
*
*/

public class Commodities extends MerrillLynchProductPage {
	public WebDriverWait wait;
	
	
//Commodities page
	@FindBy(css="#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a")
	public WebElement wblnkCommoditiesTab ;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(1)>div>div")
	public WebElement wbelemWhatsHappeningInCommodities;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemCommodityNews;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(1)>div")
	public WebElement wbelemCrudeOilText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(1)>div")
	public WebElement wbelemGoldText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(1)>div")
	public WebElement wbelemCornText;
	
//What's happening in commodities
		
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)")
	public WebElement wbelemCrudeOilCurrentPrice;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemCrudeOilPriceIn;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>div")
	public WebElement wbelemCrudeOilTodaysPerformanceText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span>span")
	public WebElement wbelemCrudeOilTodaysPerformanceValue;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)")
	public WebElement wbelemCrudeOilOneMonthTrendText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>span:nth-child(1)>span")
	public WebElement wbelemCrudeOilOneMonthTrendValue;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>span:nth-child(2)")
	public WebElement wbelemCrudeOilThisMonthText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)")
	public WebElement wbelemGoldCurrentPrice;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemGoldPriceIn;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>div")
	public WebElement wbelemGoldTodaysPerformanceText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span>span")
	public WebElement wbelemGoldTodaysPerformanceValue;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)")
	public WebElement wbelemGoldOneMonthTrendText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>span:nth-child(1)>span")
	public WebElement wbelemGoldOneMonthTrendValue;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>span:nth-child(2)")
	public WebElement wbelemGoldThisMonthText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)")
	public WebElement wbelemCornCurrentPrice;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemCornPriceIn;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>div")
	public WebElement wbelemCornTodaysPerformanceText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>span>span")
	public WebElement wbelemCornTodaysPerformanceValue;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)")
	public WebElement wbelemCornOneMonthTrendText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>span:nth-child(1)>span")
	public WebElement wbelemCornOneMonthTrendValue;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(3)>div>div>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>span:nth-child(2)")
	public WebElement wbelemCornThisMonthText;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(2)>div")
	public WebElement wbelemCommoditiesQuotesTimeStamp;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(1)>div>div>div>a")
	public WebElement wblnkCommoditiesNewsHeadline;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(1)>div>div>div>div:nth-of-type(2)>span:nth-child(1)")
	public WebElement wbelemCommoditiesNewsSource;
	
	@FindBy(css="#mod_wh_commodities>div:nth-child(2)>div:nth-child(1)>div>div>div>div:nth-of-type(2)>span:nth-child(2)")
	public WebElement wbelemCommoditiesNewsTimeStamp;
	
	@FindBy(css="#generic-view>div:nth-child(1)>div>div")
	public WebElement wbelemCommoditiesNews_RelatedNews;
	
	@FindBy(css="#news_article_full_story>div>div:nth-child(2)")
	public WebElement wbelemCommoditiesNews_FullNewsHeader;
	
//Energy TAB
	
	@FindBy(css="#CommoditiesInBrief>div>div>div:nth-child(2)")
	public WebElement wbelemCommoditiesInBrief;
	
	@FindBy(css="#mod_commodities_tabs>div>ul>li:nth-child(1)>a")
	public WebElement wblnkCommodities_EnergyTab;
	//Crude Oil and Gas
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(1)")
	public WebElement wbelem_Commodities_energy_crudeoilgas_Text;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnk_commodities_energy_crudeoilgas_CrudeOil;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnk_commodities_energy_crudeoilgas_E_mini_CrudeOil ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnk_commodities_energy_crudeoilgas_NaturalGas ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelem_commodities_energy_crudeoilgas_QuotesTimeStamp ;
	//Crude oil (WTI)
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(1)>span:nth-child(1)")
	public WebElement wbelem_commodities_energy_crudeoilgas_CurrentValue ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(1)>span:nth-child(2)")
	public WebElement wbelem_commodities_energy_crudeoilgas_CurrentValueIn_USD ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(1)>span:nth-child(3)")
	public WebElement wbelem_commodities_energy_crudeoilgas_CurrentPerformance ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(1)>span:nth-child(4)")
	public WebElement wbelem_commodities_energy_crudeoilgas_MonthlyPerformance ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>select")
	public WebElement wblst_commodities_energy_crudeoilgas_CompareList ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>img")
	public WebElement wbimg_commodities_energy_crudeoilgas_Image ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(1)>a")
	public WebElement wblnk_commodities_energy_crudeoilgas_1Day ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(3)>a")
	public WebElement wblnk_commodities_energy_crudeoilgas_1Week ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(5)>a")
	public WebElement wblnk_commodities_energy_crudeoilgas_1Month ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(7)>a")
	public WebElement wblnk_commodities_energy_crudeoilgas_3Month ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(1)")
	public WebElement wbelem_commodities_energy_crudeoilgas_1WeekChangeText ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(2)")
	public WebElement wbelem_commodities_energy_crudeoilgas_1MonthChangeText ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(3)")
	public WebElement wbelem_commodities_energy_crudeoilgas_3MonthChangeText ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(4)")
	public WebElement wbelem_commodities_energy_crudeoilgas_52WeekRangeText ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelem_commodities_energy_crudeoilgas_52WeekLow;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div>div:nth-child(1)>div:nth-child(3)")
	public WebElement wbelem_commodities_energy_crudeoilgas_52WeekHigh;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div:nth-child(2)")
	public WebElement wbelem_commodities_energy_crudeoilgas_1WeekMomentum ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(1)>div>span")
	public WebElement wbelem_commodities_energy_crudeoilgas_1WeekChangeValue;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(2)>div>span")
	public WebElement wbelem_commodities_energy_crudeoilgas_1MonthChangeValue ;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(3)>div>span")
	public WebElement wbelem_commodities_energy_crudeoilgas_3MonthChangeValue;
	//Refined Products
	@FindBy(css="#mod_commodities_energy_refinedproducts>div:nth-child(1)")
	public WebElement wbelem_commodities_energy_refinedproducts_Text ;
	
	@FindBy(css="#mod_commodities_energy_refinedproducts>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement  wblnk_commodities_energy_refinedproducts_RBOB_Gasoline;
	
	@FindBy(css="#mod_commodities_energy_refinedproducts>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement  wblnk_commodities_energy_refinedproducts_RBOB_NY_Harbor_ULSD;
	
	@FindBy(css="#mod_commodities_energy_crudeoilgas>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelem_commodities_energy_refinedproducts_QuotesTimeStamp ;
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//													Metals Tab																							    //																						  
//																																						   //
//																																						  //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@FindBy(css="#mod_commodities_tabs>div>ul>li:nth-child(2)>a")
	public WebElement wblnkCommodities_MetalsTab;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(1)")
	public WebElement wbelemPreciousMetalsText;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelemPreciousMetalsQuotesTimeStamp;
	
	@FindBy(css="#mod_commodities_metals_basemetals>div:nth-child(1)")
	public WebElement wbelemBaseMetalsText;
	
	@FindBy(css="#mod_commodities_metals_basemetals>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelemBaseMetalsQuotesTimeStamp;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkPreciousMetals_GoldText;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkPreciousMetals_SilverText;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkPreciousMetals_PlatinumText;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(4)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkPreciousMetals_MiniGoldText;
	
	@FindBy(css="#mod_commodities_metals_basemetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkBaseMetals_Copper;
	
	@FindBy(css="#mod_commodities_metals_basemetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkBaseMetals_Aluminium;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div>span:nth-child(1)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_CurrentValue ;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div>span:nth-child(2)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_CurrentValueIn_USD ;	
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(1)>span:nth-child(3)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_CurrentPerformance ;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(1)>span:nth-child(4)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_MonthlyPerformance ;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>select")
	public WebElement wblst_commodities_metals_preciousmetals_Gold_CompareList ;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>img")
	public WebElement wbimg_commodities_metals_preciousmetals_Gold_Image ;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(1)")
	public WebElement wblnk_commodities_metals_preciousmetals_Gold_1Day ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(3)")
	public WebElement wblnk_commodities_metals_preciousmetals_Gold_1Week ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(5)")
	public WebElement wblnk_commodities_metals_preciousmetals_Gold_1Month ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(7)")
	public WebElement wblnk_commodities_metals_preciousmetals_Gold_3Month ;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(1)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_1WeekChangeText ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(2)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_1MonthChangeText ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(3)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_3MonthChangeText ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(4)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_52WeekRangeText ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_52WeekLow;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div>div:nth-child(1)>div:nth-child(3)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_52WeekHigh;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div:nth-child(2)")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_1WeekMomentum ;
	
	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(1)>div>span")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_1WeekChangeValue;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(2)>div>span")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_1MonthChangeValue ;

	@FindBy(css="#mod_commodities_metals_preciousmetals>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(3)>div>span")
	public WebElement wbelem_commodities_metals_preciousmetals_Gold_3MonthChangeValue;
	
	 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //													Agriculture Tab																							//																						  
   //																																						   //
  //																																						  //
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@FindBy(css="#mod_commodities_tabs>div>ul>li:nth-child(3)>a")
	public WebElement wblnkCommodities_AgricultureTab;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(1)")
	public WebElement wbelemGrainsAndOilseed;
		
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkGrainsAndOilseed_Corn_Text;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkGrainsAndOilseed_Soybeans_Text;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkGrainsAndOilseed_SoybeanMeal_Text;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(4)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkGrainsAndOilseed_Oats_Text;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(5)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkGrainsAndOilseed_RoughRice_Text;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelemGrainsAndOilseedQuotesTimeStamp;
	
	@FindBy(css="#mod_commodities_agriculture_livestock>div:nth-child(1)")
	public WebElement wbelemLivestock;
	
	@FindBy(css="#mod_commodities_agriculture_livestock>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkLivestock_LeanHog_Text;
	
	@FindBy(css="#mod_commodities_agriculture_livestock>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkLivestock_LiveCattle_Text;
	
	@FindBy(css="#mod_commodities_agriculture_livestock>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkLivestock_FeederCattle_Text;
	
	@FindBy(css="#mod_commodities_agriculture_livestock>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelemLivestockQuotesTimeStamp;
	
	@FindBy(css="#mod_commodities_agriculture_forest>div:nth-child(1)")
	public WebElement wbelemForest;
	
	@FindBy(css="#mod_commodities_agriculture_forest>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkForest_Lumber_Text;
	
	@FindBy(css="#mod_commodities_agriculture_forest>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelemForestQuotesTimeStamp;
	
	@FindBy(css="#mod_commodities_agriculture_softs>div:nth-child(1)")
	public WebElement wbelemSofts;
	
	@FindBy(css="#mod_commodities_agriculture_softs>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkSofts_Cocoa;
	
	@FindBy(css="#mod_commodities_agriculture_softs>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkSofts_Coffee;
	
	@FindBy(css="#mod_commodities_agriculture_softs>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkSofts_Cotton;
	
	@FindBy(css="#mod_commodities_agriculture_softs>div:nth-child(2)>div:nth-child(1)>div:nth-child(4)>div:nth-child(1)>div>div:nth-child(1)>a")
	public WebElement wblnkSofts_Sugar;
	
	@FindBy(css="#mod_commodities_agriculture_softs>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelemSoftsQuotesTimeStamp;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div>span:nth-child(1)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_CurrentValue ;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div>span:nth-child(2)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_CurrentValueIn_USD ;	
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div>span:nth-child(3)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_CurrentPerformance ;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div>span:nth-child(4)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_MonthlyPerformance ;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>select")
	public WebElement wblst_commodities_Agriculture_Grains_Corn_CompareList ;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>img")
	public WebElement wbimg_commodities_Agriculture_Grains_Corn_Image ;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(1)")
	public WebElement wblnk_commodities_Agriculture_Grains_Corn_1Day ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(3)")
	public WebElement wblnk_commodities_Agriculture_Grains_Corn_1Week ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(5)")
	public WebElement wblnk_commodities_Agriculture_Grains_Corn_1Month ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>ul>li:nth-child(7)")
	public WebElement wblnk_commodities_Agriculture_Grains_Corn_3Month ;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(1)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_1WeekChangeText ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(2)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_1MonthChangeText ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(3)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_3MonthChangeText ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>thead>tr>th:nth-child(4)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_52WeekRangeText ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_52WeekLow;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div>div:nth-child(1)>div:nth-child(3)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_52WeekHigh;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div:nth-child(2)")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_1WeekMomentum ;
	
	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(1)>div>span")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_1WeekChangeValue;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(2)>div>span")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_1MonthChangeValue ;

	@FindBy(css="#mod_commodities_agriculture_grainsOilSeed>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(3)>div>span")
	public WebElement wbelem_commodities_Agriculture_Grains_Corn_3MonthChangeValue;
	
	
//Ways to Invest
	@FindBy(css="#mod_ways_to_invest>div>div")
	public WebElement wbelemWaysToInvest ;
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-child(1)>td:nth-child(1)>div")
	public WebElement wbelemStocks;	
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-child(2)>td>div>a")
	public WebElement wblnkBuyRatedStocks;	
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-child(3)>td>div")
	public WebElement wbelemETFs;
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-child(4)>td>div>a")
	public WebElement wblnkCommodityETFs;	
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-child(5)>td>div>a")
	public WebElement wblnkEnergySectorETF;	
	@FindBy(css="#mod_ways_to_invest>div>table>tbody>tr:nth-child(1)>td:nth-child(2)>div")
	public WebElement wbelemBookIcon;	
	@FindBy(css="#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(2)>a>span")
	public WebElement wblnkStockScreeenersTab;
	@FindBy(css="#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span")
	public WebElement wblnkETFScreeenersTab;

//CommodityEvents
		
	@FindBy(css="#commodity_events_widget>div:nth-child(1)")
	public WebElement wbelemCommodityEvents;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelemThisWeekEventCalendarText ;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)")
	public WebElement wbelemCalendarIcon ;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>a")
	public WebElement wblnkCommodityEvents_FirstEventLink ;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)")
	public WebElement wbelemCommodityEvents_FirstEvent_TimeStamp ;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>div")
	public WebElement wbelemEventsModal_EventName;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>table>tbody>tr:nth-child(2)>th:nth-child(1)")
	public WebElement wbelemEventsModal_ActualNumberReportedText;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>table>tbody>tr:nth-child(1)>td:nth-child(1)")
	public WebElement wbelemEventsModal_ActualNumberReportedValue;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>table>tbody>tr:nth-child(2)>th:nth-child(2)")
	public WebElement wbelemEventsModal_NumberFromPreviousText;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)>table>tbody>tr:nth-child(1)>td:nth-child(2)")
	public WebElement wbelemEventsModal_NumberFromPreviousValue;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(4)>div")
	public WebElement wbelemAnalysis;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(5)>div")
	public WebElement wbelemLogo_ECONODAY;
	@FindBy(css="#commodity_events_widget>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div")
	public WebElement wbelemEventModal_Close;
	@FindBy(css="#commodity_events_widget>div:nth-child(3)>a")
	public WebElement wblnkMoreMarketEvents;
	
//News
	@FindBy(css="#generic-view>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemLatestNews;
	@FindBy(css="#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(1)")
	public WebElement wbelemShowOnly;
	@FindBy(css="#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>span")
	public WebElement wbelemMyholdingsText;
	@FindBy(css="#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(2)>input")
	public WebElement wbchkboxMyholdingsCheckbox;
	@FindBy(css="#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>span")
	public WebElement wbelemMyWatchlistText;
	@FindBy(css="#generic-view>div:nth-child(1)>div>div>div>div:nth-child(2)>span>span:nth-child(3)>input")
	public WebElement wbchkboxMyWatchlistCheckbox;
	@FindBy(css="#generic-view>div:nth-child(2)>div:nth-child(1)>div>a")
	public WebElement wblnkNewsHeadlineOnLatestNews;
	@FindBy(css="#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(1)")
	public WebElement wbelemCompanyNameForNews;
	@FindBy(css="#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)")
	public WebElement wbelemTeaserForFirstNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(2)")
	public WebElement wbelemTimeStampInformationForNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div:nth-child(1)>div>div>div:nth-child(2)>div>a")
	public WebElement wblnkReadMoreOnRecentNews;
	@FindBy(css="#generic-view>div:nth-child(3)>a")
	public WebElement wblnkMoreNews;
	
	@FindBy(css="#generic-view>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>a")
	public WebElement wblnkSecondNewsHealine;
	@FindBy(css="#hover-news-intro>div>h1")
	public WebElement wbelemHoverNewsModalHeader;
	@FindBy(css="#hover-news-intro>div>div>div>div:nth-child(1)>h2")
	public WebElement wbelemHoverNewsTitle;
	@FindBy(css="#companies_in_the_news_widget>div:nth-child(1)")
	public WebElement wbelemCompaniesInTheNews;
	@FindBy(css="#companies_in_the_news_widget>div:nth-child(3)")
	public WebElement wbelemCompaniesinNews_AsOf;
	@FindBy(css="#companies_in_the_news_widget>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)")
	public WebElement wbelemCompaniesinNews_FirstCompanySymbol;
	@FindBy(css="#companies_in_the_news_widget>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)")
	public WebElement wbelemCompaniesinNews_FirstCompanyName;
	@FindBy(css="#companies_in_the_news_widget>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)")
	public WebElement wbelemCompaniesinNews_FirstCompanyValue;
	@FindBy(css="#companies_in_the_news_widget>div:nth-child(2)>div>div:nth-child(1)>div:nth-child(2)>div:nth-child(2)")
	public WebElement wbelemCompaniesinNews_FirstCompanyChangePercent;

	public Commodities(WebDriver driver)
		{
			super(driver);
		}
	
	}


