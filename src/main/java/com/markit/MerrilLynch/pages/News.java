/**
 * 
 */
package com.markit.MerrilLynch.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * @author ritu.nath
 * @purpose:  This News page class contains all the elements to be interacted in test scenarios.
 * @creation date: 22/6/2016
 */

public class News extends MerrillLynchProductPage {

	
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-child(2)>div>div:nth-child(1)>div>div>div>div:nth-child(1)")
	public WebElement wbelemMarketUpdate;
	@FindBy(css = "#mod_USMarketsWhatsHappeningView>div:nth-of-type(1)>div>div>div:nth-of-type(1)")
	public WebElement wbelemWhatsHappeningInUSMarkets;
	@FindBy(css = "#news_composite_widget>div:nth-child(1)>div>div>div")
	public WebElement wbelemLatestHeadlineText;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div")
	public WebElement wbelemSearchNewsText;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>input")
	public WebElement wblnkSearchTextBox;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(1)>a")
	public WebElement wblnkSelectAll;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(2)>ul>li:nth-child(3)>a")
	public WebElement wblnkClearAllCriteria;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(3)>div>div:nth-child(1)>div")
	public WebElement wbelemNewsFilterText;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(3)>div>div:nth-child(2)>table>tbody>tr>td:nth-child(1)>div>label>input")
	public WebElement wbelemMyHoldingsCheckBox;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(3)>div>div:nth-child(2)>table>tbody>tr>td:nth-child(2)>div>label>input")
	public WebElement wbelemMyWatchListCheckBox;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(1)>div")
	public WebElement wbelemNewsProviderText;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(1)>div")
	public WebElement wbelemCategoriesText;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(3)>div>div:nth-child(1)>div")
	public WebElement wbelemRegionsText;
	@FindBy(css = "#ctl00_ctl00_ctl01_cphSiteMst_EMCContainerDiv>ul>li:nth-child(7)>a")
	public WebElement wblnkNewsTab;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>a")
	public WebElement wblnkSeeMore;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(2)>table>tbody>tr:nth-child(1)>td:nth-child(1)>div")
	public WebElement wbelemAFSCheckBox;
	@FindBy(css = ".mod-headline.mod-text-heading4")
	public WebElement wblnkFirstNewsHeading;
	@FindBy(css = "#generic-view>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(1)")
	public WebElement wbelemFirstNewsSource;
	@FindBy(css = "#generic-view>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(1)>span:nth-child(2)")
	public WebElement wbelemFirstNewsTimestamp;
	@FindBy(css = "#generic-view>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(2)>div>a")
	public WebElement wblnkFirstNewsReadMoreLink;
	@FindBy(css = ".lightboxContent.hasLayout.-news-hover-body")
	public WebElement wbelemHoverNewsIntro;
	@FindBy(css = "#hover-news-intro>div>h1>span:nth-of-type(1)")
	public WebElement wbelemHoverNews;
	@FindBy(css = "#generic-view>div:nth-child(2)>div>div:nth-child(3)>select")
	public WebElement wbelemDisplayDropdown;
	@FindBy(css = ".mod-text-heading2.pb-m")
	public WebElement wbelemCompanyNewsTitle;
	@FindBy(css = "#generic-view>div:nth-child(1)>div:nth-child(1)>div>div>div:nth-child(2)>div>a")
	public WebElement wblnkReadMoreLink;
	@FindBy(css = "#news_article_full_story>div")
	public WebElement wbelemFullarticle;
	@FindBy(css = ".prev-link")
	public WebElement wblnkPrev;
	@FindBy(css = ".next-link")
	public WebElement wblnkNext;
	@FindBy(css = ".clearfix.mod-table-pagination")
	public WebElement wbelemPagination;
	@FindBy(css = ".mod-panel-mediumgray.mod-panel-border.mb-xxxl.p-m>a")
	public WebElement wblnkReturnNews;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(2)>table>tbody")
	public WebElement wbelemNews1Table;	
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(2)>div>div:nth-child(1)>table>tbody")
	public WebElement wbelemNews2Table;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div>div:nth-child(2)>div>div:nth-child(2)>a")
	public WebElement wblnkNewsSeeMore;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(2)>table>tbody")
	public WebElement wbelemCategoryTable;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(1)>table>tbody")
	public WebElement wbelemCategoryTable1;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)>div>div:nth-child(2)>div>div:nth-child(2)>a")
	public WebElement wblnkCategorySeeMore;
	@FindBy(css = "#news_search_widget>div>div:nth-child(2)>div:nth-child(2)>div:nth-child(3)>div>div:nth-child(2)>table>tbody")
	public WebElement wbelemRegionsTable;
	@FindBy(css = ".mod-headline.mod-text-heading4.popupHover")
	public WebElement wbelemHover;
	@FindBy(css = "#generic-view>div:nth-of-type(1)>p")
	public WebElement wbelemNewsNotAvailable;
	@FindBy(css = "#news_search_widget>div>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div")
	public WebElement wbelemNewSearchClick;
	
	
	
	public static Boolean fnIsTimeStampValid(String inputString)
	{ 
	    SimpleDateFormat format = new java.text.SimpleDateFormat("Month DD, YYYY HH:MM");
	    try{
	       format.parse(inputString);
	       Pattern p = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}[.]?\\d{1,6}$");
	       return p.matcher(inputString).matches();
	       
	    }
	    catch(ParseException e)
	    {
	        return false;
	    }
	}
	
	public News(WebDriver driver) {
		super(driver);
	}
	
	
}
