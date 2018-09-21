package com.markit.MerrilLynch.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MFScreeners extends MerrillLynchProductPage{
	
	//Main Page
	
	@FindBy(css="#ctl00_ctl00_ctl01_cphGlobalNav_ctl01_lnkLogout")
	public WebElement wblnkLogout;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)")
	public WebElement wbelemBasicCriteriaText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemRatingsText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemPerformanceText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemPortfolioText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemManagementFeesText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemRiskText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemDistributionsText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemSavedScreensText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>span:nth-of-type(1)")
	public WebElement wbelemSearchCustomCriteriaText;
	@FindBy(css="#mod-searchbox")
	public WebElement wbtxtCriteriaSearchTextBox;
	
	//Result table
	
	@FindBy(css="#mod_MutualFundScreenerTableView>div:nth-of-type(1)>span:nth-of-type(1)")
	public WebElement wblnkYourSearchTab;
	@FindBy(css="#mod_MutualFundScreenerTableView>div:nth-of-type(1)>span:nth-of-type(2)")
	public WebElement wblnkOverviewTab;
	@FindBy(css="#mod_MutualFundScreenerTableView>div:nth-of-type(1)>span:nth-of-type(3)")
	public WebElement wblnkRatingsTab;
	@FindBy(css="#mod_MutualFundScreenerTableView>div:nth-of-type(1)>span:nth-of-type(4)")
	public WebElement wblnkPerformanceTab;
	@FindBy(css="#mod_MutualFundScreenerTableView>div:nth-of-type(1)>span:nth-of-type(5)")
	public WebElement wblnkPortfolioExpensesTab;
	@FindBy(css="#mod_MutualFundScreenerTableView>div:nth-of-type(1)>span:nth-of-type(6)")
	public WebElement wblnkRiskTab;
	@FindBy(xpath=".//*[@id='resultControl']/div[1]/label/div")
	public WebElement wbLstSortbyDropdown;
	@FindBy(xpath=".//*[@id='resultControl']/div[1]/div/ul/li[2]")
	public WebElement wbCriteriaFitOption;
	@FindBy(css="#resultControl>div:nth-of-type(1)>label")
	public WebElement wbelemSortbyLabel;
	@FindBy(css="#modAccount>div:nth-of-type(1)>span:nth-of-type(1)")
	public WebElement wbelemNumberOfMatches;
	@FindBy(css="#modAccount>a>span")
	public WebElement wbbtnSaveButton;
	@FindBy(css=".matchingFunds")
	public WebElement wbelemResultCount;
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(2)>table>tbody>tr>td>table>thead")
	public WebElement wblnkTableHeaderRow;
	@FindBy(css="#Mod_SymbolResults>table>tbody>tr>td>table>tbody")
	public WebElement wbTableResults;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[2]")
	public WebElement wbelem1stCriteria;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[1]")
	public WebElement wbelem1stCriteria1;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[3]")
	public WebElement wbelem2ndCriteria;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[4]")
	public WebElement wbelem3rdCriteria;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[5]")
	public WebElement wbelem4thCriteria;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[4]")
	public WebElement wbelemAppliedCriteriaName;
	@FindBy(id="idnumber")
	public WebElement wbelemCountDisplayed;
	@FindBy(css=".w-100pc.defaultTable>thead>tr>th:nth-of-type(2)>a>div:nth-of-type(1)")
	public WebElement wbHeaderMorningStar;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)")
	public WebElement wbelemPredefinedScreens;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemPredefinedScreensLabel;
	
	//Result table controls
	
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(1)")
	public WebElement wbelemPreviousColumnControl;
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(3)")
	public WebElement wbelemNextColumnControl;
	@FindBy(css="#Mod_EsResultsTables>div:nth-of-type(2)>a:nth-of-type(1)>span")
	public WebElement wbbtnShowSelectedETFsOnlyButton;
	@FindBy(css="#Mod_EsResultsTables>div:nth-of-type(2)>a:nth-of-type(2)>span")
	public WebElement wbbtnSaveAsWatchlistButton;
	@FindBy(css="#Mod_EsResultsTables>div:nth-of-type(2)>a:nth-of-type(3)>span")
	public WebElement wbbtnCompareSelectedFundsButton;
	
	//Applied criteria
	
	@FindBy(css=".customCriteriaApplied")
	public WebElement wbelemAppliedCriteria;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemLoadPercentageText;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(12)")
	public WebElement wbelemLoadPercentageMax;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(11)")
	public WebElement wbelemLoadPercentageMin;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(4)")
	public WebElement wbelemLoadPercentageMaxTarget;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>span:nth-of-type(8)")
	public WebElement wbelemLoadPercentageMinTarget;
	@FindBy(css="//thead/tr/th[3]/a/div[1]")
	public WebElement wbelemAppliedCriteriaNameTable;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[4]/span")
	public WebElement wbelemCloseLoadPercentage;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[1]/span")
	public WebElement wbelemCloseMorning5;
	@FindBy(css="#mod_MutualFundScreenerTableView")
	public WebElement wbTableResult;
	@FindBy(css="#Mod_CarousalContainer>div>div:nth-of-type(2)>table>tbody>tr>td>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)>div")
	public WebElement wbelemScreenNameResultTable;
	@FindBy(xpath=".//*[@id='Mod_EsResultsTables']/div[7]/div[2]/div/div[1]/span/span[3]")
	public WebElement wbelemCountMatched;
	@FindBy(css="#l2Research1>div>div>div:nth-of-type(2)>div>ul:nth-of-type(1)>li:nth-of-type(3)>a")
	public WebElement wblnkMFScreenerLink;
	@FindBy(css="#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-of-type(3)>a>span:nth-of-type(1)>strong")
	public WebElement wblnkMFScreenerTab;
	
	//Predefined screen options
	
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemNoLoadOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemMorningStar5Option;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemTargetDateOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemTargetAllocationOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemIndexOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemRetirementOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemPortfolioOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemSociallyRespOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemMorningStar4Option;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemHighPayingOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemInflationOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemTopPerformingOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(1)>div:nth-of-type(2)")
	public WebElement wbelemGrowthOption;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemNoLoadDescritpion;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemMorningStar5Description;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemTargetDateDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemTargetAllocationDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemIndexDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemRetirementDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemPortfolioDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemSociallyRespDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemMorningStar4Description;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemHighPayingDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemInflationDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemTopPerformingDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div")
	public WebElement wbelemGrowthDescription;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemNoLoadView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemMorningStar5View;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemTargetDateView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemTargetAllocationView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemIndexView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemRetirementView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemPortfolioView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemSociallyRespView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemMorningStar4View;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemHighPayingView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(11)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemInflationView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemTopPerformingView;
	@FindBy(css="#modCriteriaFilters>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(13)>div:nth-of-type(2)>div>div:nth-of-type(2)>div>a")
	public WebElement wbelemGrowthView;
	
	//Search tools
	
	@FindBy(css="#ui-id-1")
	public WebElement wbelemSearchResultDropdown;
	@FindBy(css="#empty-message")
	public WebElement wbelemEmptyMessage;
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[3]/span")
	public WebElement wbelemCloseLoadPercentage1;
	@FindBy(xpath=".//*[@id='mod_dialog']/div[1]/span")
	public WebElement wbelemCloseRestorePopup;
	@FindBy(css=".BestFitToolTipContainer")
	public WebElement wbCriteriaFitMessage;	
	@FindBy(xpath=".//*[@id='Mod_CarousalContainer']/div/div[2]/table/tbody/tr/td/table/thead/tr/th[3]/a/div[1]/div")
	public WebElement wbToolTip;
	@FindBy(xpath=".//*[@id='modCriteriaFilters']/div[2]/div[4]/div[2]/div[2]/div[1]/div[2]")
	public WebElement wbelemAverageAnnualTotalReturnLoadAdjusted;	
	@FindBy(xpath=".//*[@id='modCriteriaFilters']/div[2]/div[4]/div[2]/div[1]/div[1]/div[2]")
	public WebElement wbelemAverageAnnualTotalReturnNonLoadAdjusted;
	
	//Filter remove
	@FindBy(xpath=".//*[@id='modAccount']/div[4]/span[3]/span[2]/span")
	public WebElement wbelemRemoveFilter;
	
	public MFScreeners(WebDriver driver) {
		super(driver);

	}

}






