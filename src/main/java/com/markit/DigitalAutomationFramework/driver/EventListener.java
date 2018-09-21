package com.markit.DigitalAutomationFramework.driver;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.markit.DigitalAutomationFramework.utilities.Screenshot;
import com.markit.DigitalAutomationFramework.common.Logging;

 
/**
 * This class acts as a listener against the EventFiringWebDriver used for the tests
 * <P>
 * When certain events are fired the methods in this class are also executed allowing us 
 * to run specific pieces of code at the same time
 * 
 * @author stuart.rogers
 * @version 1.0
 * @since 2015-07-27
 */
public class EventListener extends AbstractWebDriverEventListener{
	/**
	 * Screenshot Object
	 */
	Screenshot ss;	
	
	/**
	 * Initialise a logger to allow for the class to write out using the 
	 * current log4j config
	 */
	
	private Logging Log =new Logging(super.getClass().getSimpleName());

	
	/**
	 * Executed before each click on a web element
	 * Waits for Element to be clickable. 
	 * Attempts to catch Element not clickable error while waiting i.e before actual click and retry the wait.
	 * @param element The WebElement that is to be clicked
	 * @param driver The WebDriver used in the current run
	 */
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {

		//Wait for Element to be clickable
		long tstart =  System.currentTimeMillis();
		long tElapsed;
		long maxWaitInSecond = 10;
		
		WebDriverWait wait;
		wait = (new WebDriverWait(driver,maxWaitInSecond));
		
		while(true){
		
			try{
				wait.until(ExpectedConditions.elementToBeClickable(element));
				hold();
				break;
			}catch (WebDriverException e){}
			
			tElapsed = System.currentTimeMillis() - tstart;
			tElapsed = tElapsed / 1000;
		
			Log.info("Waiting for ExpectedCondition (Element to be clickable) : Seconds Elapsed " +tElapsed + " out of " + maxWaitInSecond);
			if (tElapsed > maxWaitInSecond) 
				break;
		}
	
		
		Log.info("Attempting to click: '" + element );
	}
	
	/**
	 * Executed after each successfully click on a web element
	 * Waits for Page to load if click causes to page loading.
	 * waits ajax queries to complete if click causes ajax queries to execute in that iframe  
	 * @param element The WebElement that was click on successfully
	 * @param driver The WebDriver used in the current run
	 */
	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		waitForAjax(driver, 30);
		Log.info("Successfull click on: '" + element + "'");
	}

	/**
	 * Executed before each FindBy on a web element
	 * Waits for Page to load before finding element
	 * waits ajax queries to complete in that iframe  
	 * @param by Properties by which element will be searched
	 * @param element The WebElement that is to be found
	 * @param driver The WebDriver used in the current run
	 */
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		waitForAjax(driver, 30);
		Log.info("Attempting to locate: '" + by + "");
	}
	
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Log.info("Located: '" + by + "'");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		Log.info("Attempting to excute script: '" + script + "' On driver '" + driver + "'");
	}

	@Override
	public void afterScript(String script, WebDriver driver) {		
		Log.info("Successfull script Execution : '" + script + "' On driver '" + driver + "'" );
	}
	
//	///////////////------------Customised Methods-------------------------------------
	
	/**
	 * Puts thread to sleep for 1 second
	 */
	public void hold (){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Log.info("Thread Sleep Interrupted :" + e.getMessage());
		}
	}
	
	/**
	 * Returns number of active ajax queries in the current context (iframe)
	 * @param driver 
	 * @return number of active ajax queries. Type - int
	 */
	public int getAjaxCount(WebDriver driver){ 
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int activeJqueryCount;
		try
		{
			//Check if jQuery is defined
			Object obj = js.executeScript("return window.jQuery != undefined");
			
			//If jQuery is defined, find count of active ajax calls
			if (obj.toString() == "true"){
				String res =js.executeScript("return jQuery.active").toString();
		    	activeJqueryCount = Integer.parseInt(res);
			}
			//If jQuery is not defined, check status of DOM object
			else{
				//Status of DOM object. 0 if loading complete, else 1
				if(js.executeScript("return document.readyState").equals("complete"))
					activeJqueryCount = 0;
				else
					activeJqueryCount = 1;
			}
    	}
		//Probably control would never throw these exceptions. Keeping them just in case it does throws exception in any unforeseen event
		catch(Exception ex){
			if(js.executeScript("return document.readyState").equals("complete"))
				activeJqueryCount = 0;
			else
				activeJqueryCount = 1;
		}
		
		Log.info("."+activeJqueryCount+".");
		return activeJqueryCount;
    }

	/**
	 * Waits for active ajax queries to finish
	 * @param driver
	 * @param maxWaitInSecond maximum seconds to wait for ajax query to finish
	 */
	private void waitForAjax(WebDriver driver, int maxWaitInSecond) {
		long tstart =  System.currentTimeMillis();
		long tElapsed;
		
		while (true){
			
			try {
				
				// If ajax queries have finished, then proceed
				if (getAjaxCount(driver)==0 ){
						break;
				}
					
				//Else wait 1 more second before evaluating again
				else
				{
					hold();
				}
				
			}catch (WebDriverException e){
				// In case of JS failure, wait for max time
				while (true){
					hold();
					tElapsed = System.currentTimeMillis() - tstart;
					tElapsed = tElapsed / 1000;
					Log.info("<<JS Error>> Waiting for max time : " +tElapsed + " Seconds Elapsed out of " + maxWaitInSecond);
					
					
					if (tElapsed > maxWaitInSecond) 
						break;
				}
				
				break;
			}
			
			//Calculate time elapsed while waiting for ajax queries
			tElapsed = System.currentTimeMillis() - tstart;
			tElapsed = tElapsed / 1000;
			Log.info("Waiting for ajax : " +tElapsed + " Seconds Elapsed out of " + maxWaitInSecond);
			
			// If max wait time has elapsed, then proceed anyways
			if (tElapsed > maxWaitInSecond) 
				break;
			
		}
		
	}

}
