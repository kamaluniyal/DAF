package com.markit.MerrilLynch.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ETFScreeners extends MerrillLynchProductPage{
	
	//Main Page
	
	@FindBy(linkText="ETF Screener")
	public WebElement wbLnkETFScreenerLink;
	@FindBy(css="#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a")
	public WebElement wbLnkETFScreenerTab;
	
	//Predined screens
	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbElemPredefinedScreens;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemPredefinedScreensLabel;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemMorningStar5StarRatedETFsOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemIndexFundsOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemCommunicationsOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemConsumerDiscretionaryOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemConsumerStaplesOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemEnergyOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemFinancialsOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemHealthCareOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemIndustrialsOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemMaterialsOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemTechnologyOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemUtilitiesOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemRealEstateOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(3)")
	public WebElement wbElemMorningStar5StarRatedETFsHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)")
	public WebElement wbElemIndexFundsHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(3)")
	public WebElement wbElemCommunicationsHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(3)")
	public WebElement wbElemConsumerDiscretionaryHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(3)")
	public WebElement wbElemConsumerStaplesHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(3)")
	public WebElement wbElemEnergyHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(3)")
	public WebElement wbElemFinancialsHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(3)")
	public WebElement wbElemHealthCareHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(3)")
	public WebElement wbElemIndustrialsHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(3)")
	public WebElement wbElemMaterialsHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(3)")
	public WebElement wbElemTechnologyHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(3)")
	public WebElement wbElemUtilitiesHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(3)")
	public WebElement wbElemRealEstateHelp;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemMorningStar5StarRatedETFsName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemMorningStar5StarRatedETFsDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemMorningStar5StarRatedETFsView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemIndexFundsName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemIndexFundsDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemIndexFundsView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemCommunicationsName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemCommunicationsDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemCommunicationsView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemConsumerDiscretionaryName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemConsumerDiscretionaryDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemConsumerDiscretionaryView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemConsumerStaplesName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemConsumerStaplesDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemConsumerStaplesView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemEnergyName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemEnergyDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemEnergyView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemFinancialsName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemFinancialsDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemFinancialsView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemHealthCareName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemHealthCareDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemHealthCareView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemIndustrialsName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemIndustrialsDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemIndustrialsView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemMaterialsName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemMaterialsDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemMaterialsView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemTechnologyName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemTechnologyDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemTechnologyView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemUtilitiesName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemUtilitiesDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemUtilitiesView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(2)>div>div:nth-of-type(1)")
	public WebElement wbElemRealEstateName;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbElemRealEstateDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbElemRealEstateView;
	@FindBy(css="#modAccount>div:nth-of-type(1)>span:nth-of-type(1)")
	public WebElement wbElemNumberOfMatches;
	@FindBy(css="#modAccount>a>span")
	public WebElement wbBtnSaveButton;	
	
	//Result Table
	
	@FindBy(css="#mod_ETFScreenerTableView")
	public WebElement wbTableResult;		
	@FindBy(css=".matchingFunds")
	public WebElement wbElemResultCountLabel;
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(2)>table>tbody>tr>td>table>thead")
	public WebElement wbLnkTableHeaderRow;
	@FindBy(css="#Mod_SymbolResults>table>tbody>tr>td>table>tbody")
	public WebElement wbTableResults;
	
	//Search tools
	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>span:nth-of-type(1)")
	public WebElement wbElemSearchCustomCriteriaText;
	@FindBy(css="#mod-searchbox")
	public WebElement wbtxtCriteriaSearchTextBox;	
	@FindBy(css="#ui-id-1")
	public WebElement wbelemSearchResultDropdown;	
	@FindBy(css="#empty-message")
	public WebElement wbelemEmptyMessage;	
	@FindBy(css=".BestFitToolTipContainer")
	public WebElement wbCriteriaFitMessage;	
	@FindBy(xpath=".//*[@id='Mod_CarousalContainer']/div/div[2]/table/tbody/tr/td/table/thead/tr/th[3]/a/div[1]/div")
	public WebElement wbToolTip;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)")
	public WebElement wbElemBasicCriteriaText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemRatingsText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemPerformanceText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemPortfolioText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemManagementFeesText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemRiskText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemDistributionsText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemSavedScreensText;
	
	//Result table tabs
	
	@FindBy(css="#mod_ETFScreenerTableView>div:nth-of-type(1)>span:nth-of-type(1)")
	public WebElement wbLnkYourSearchTab;
	@FindBy(css="#mod_ETFScreenerTableView>div:nth-of-type(1)>span:nth-of-type(2)")
	public WebElement wbLnkOverviewTab;
	@FindBy(css="#mod_ETFScreenerTableView>div:nth-of-type(1)>span:nth-of-type(3)")
	public WebElement wbLnkRatingsTab;
	@FindBy(css="#mod_ETFScreenerTableView>div:nth-of-type(1)>span:nth-of-type(4)")
	public WebElement wbLnkPerformanceTab;
	@FindBy(css="#mod_ETFScreenerTableView>div:nth-of-type(1)>span:nth-of-type(5)")
	public WebElement wbLnkPortfolioExpensesTab;
	@FindBy(css="#mod_ETFScreenerTableView>div:nth-of-type(1)>span:nth-of-type(6)")
	public WebElement wbLnkRiskTab;
	@FindBy(xpath=".//*[@id='resultControl']/div[1]/label/div")
	public WebElement wbLstSortbyDropdown;
	@FindBy(xpath=".//*[@id='resultControl']/div[1]/div/ul/li[2]")
	public WebElement wbCriteriaFitOption;
	@FindBy(css="#resultControl>div:nth-of-type(1)>label")
	public WebElement wbElemSortbyLabel;
	@FindBy(css="#mod_etfRankings_tab_body>span")
	public WebElement wbElemViewResultsLabel;
	@FindBy(css="#mod_etfRankings_tab_body>div>div>a")
	public WebElement wbLstViewResultsDropdown;	
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[4]/span")
	public WebElement wbElemClosePriceRange;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[3]/span")
	public WebElement wbElemCloseHealthcare;
	
	//Applied criteria
	
	@FindBy(css=".customCriteriaApplied")
	public WebElement wbElemAppliedCriteria;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemPriceRangeText;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(14)")
	public WebElement wbElemPriceRangeMax;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(13)")
	public WebElement wbElemPriceRangeMin;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(3)")
	public WebElement wbElemPriceMaxTarget;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(9)")
	public WebElement wbElemPriceMinTarget;		
	
	//performance filter
	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbElemAITRRangeText;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(24)")
	public WebElement wbElemAITRRangeMax;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(23)")
	public WebElement wbElemAITRRangeMin;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(6)")
	public WebElement wbElemAITRMaxTarget;	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(20)")
	public WebElement wbElemAITRMinTarget;	
	
	//Result table controls
	
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(1)")
	public WebElement wbElemPreviousColumnControl;
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(3)")
	public WebElement wbElemNextColumnControl;
	@FindBy(css="#Mod_EsResultsTables>div:nth-of-type(2)>a:nth-of-type(1)>span")
	public WebElement wbBtnShowSelectedETFsOnlyButton;
	@FindBy(css="#Mod_EsResultsTables>div:nth-of-type(2)>a:nth-of-type(2)>span")
	public WebElement wbBtnSaveAsWatchlistButton;
	@FindBy(css="#Mod_EsResultsTables>div:nth-of-type(2)>a:nth-of-type(3)>span")
	public WebElement wbBtnCompareSelectedFundsButton;	
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(2)>table>tbody>tr>td>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)>div")
	public WebElement wbElemScreenNameResultTable;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[2]")
	public WebElement wbElemLeverageCriteria;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[3]")
	public WebElement wbElemIsBlockedCriteria;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[4]")
	public WebElement wbElemAppliedCriteriaName;
	@FindBy(id="idnumber")
	public WebElement wbElemCountDisplayed;	
	@FindBy(xpath=".//*[@id='Mod_EsResultsTables']/div[7]/div[2]/div/div[1]/span/span[3]")
	public WebElement wbElemCountMatched;
	@FindBy(css="#ctl00_ctl00_ctl01_cphGlobalNav_ctl01_lnkLogout")
	public WebElement wbLnkLogout;

		public ETFScreeners(WebDriver driver) {
			super(driver);

		}
		
	}






