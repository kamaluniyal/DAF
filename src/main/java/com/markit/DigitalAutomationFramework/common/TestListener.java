package com.markit.DigitalAutomationFramework.common;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.utilities.Screenshot;
import com.markit.DigitalAutomationFramework.common.Logging;

/**
 * This class acts as a listener against the test running.
 * 
 * @author sonam.chhetri
 * @author nishant.thakur
 */
public class TestListener  extends AbstractWebDriverEventListener implements ITestListener {

	/**
	 * Creating a new log instance for the current test
	 */
	protected Logging Log = new Logging(this.getClass().getName());


	/**
	 * Overriding the onException method of AbstractWebDriverEventListener for-<br>
	 * Generating logs for the exception.<br>
	 * Taking screenshot while exception occurs.
	 *  
	 */
	@Override
	public void onException(Throwable throwable, WebDriver driver) {

		String reason = throwable.getMessage();

		//If reason is multi line, then keep only first line
		int newLineIndex = reason.indexOf("\n");
		if (newLineIndex>-1){
			reason = reason.substring(0, newLineIndex);
		}

		Log.error("Exception: " + reason);
		
		if ( PropertyReader.getFieldValue("ScreenshotEnable").equalsIgnoreCase("true"))
		{
			try {
				
				//Find WebDriver if driver is Proxy. Else it throws java.lang.ClassCastException in Screenshot.findBrowserName()
				WebDriver d;
				if (driver instanceof Proxy){
					d = findWebDriverByReflection(Reporter.getCurrentTestResult());
				}
				else{
					d = driver;
				}
				(new Screenshot(d)).takeScreenshot(Reporter.getCurrentTestResult());
			} 
			//Catch All type of Exception. Test execution shouldn't break while taking screenshot on failure/exception
			catch (Exception e) {
				Log.error("Unable to take to screenshot. Reason: " + e.getMessage());
			}
		}	

	}
	
	/**	
	 * Retrieves and returns the Web Driver by using reflection.
	 * 
	 * @param tr Test Result
	 * @return WebDriver
	 */
	public WebDriver findWebDriverByReflection(ITestResult tr){

		WebDriver webDriver = null;
		Class<?> c = tr.getInstance().getClass();
		Method[] methods = c.getMethods();

		for (Method eachMethod: methods){
			if (eachMethod.getReturnType()== WebDriver.class){
				try {
					webDriver = (WebDriver) eachMethod.invoke(tr.getInstance());
				} catch (Exception e) {
					Log.error("Could not find the WebDriver");
					return null;
				}
			}
		}   
		return webDriver;

	}
	
	@Override
	public void onTestStart(ITestResult result) {
		Log.info("");
		Log.info("********************************\t Starting Test: " + result.getName() + " | Test Set: " + result.getTestContext().getName() + " | Test Class: " + result.getTestClass().getName() +"\t********************************");
		Log.info("");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("");
		Log.info("********************************\t Test Passed: " + result.getName() + " | Test Set: " + result.getTestContext().getName() + " | Test Class: " + result.getTestClass().getName() +"\t********************************");
		Log.info("");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("");
		Log.info("********************************\t Test Skipped: " + result.getName() + " | Test Set: " + result.getTestContext().getName() + " | Test Class: " + result.getTestClass().getName() +"\t********************************");
		Log.info("");
	}
	

	/**
	 * Invoked each time a test fails.<br>
	 * 
	 * Overriding the onTestFailure of ITestListner for taking screenshot at the time of assertion failure.
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		
		//Get Failure reason
		String reason = result.getThrowable().getMessage();

		//If reason is multi line, then keep only first line
//		int newLineIndex = reason.indexOf("\n");
//		if (newLineIndex>-1){
//			reason = reason.substring(0, newLineIndex);
//		}
		
		Log.error("");
		Log.error("********************************\t Test Failed: " + result.getName() + " || Test Set: " + result.getTestContext().getName() + " || Test Class: " + result.getTestClass().getName() +"\t********************************");
		Log.error("********************************\t Failure Reason \t******************************** \n" + reason + "\n\n");
		
		
		if(PropertyReader.getFieldValue("ScreenshotEnable").equalsIgnoreCase("true"))
		{
			WebDriver d=findWebDriverByReflection(result); 
			if (d!=null) {
				try {
					(new Screenshot(d)).takeScreenshot(result);
				} 
				//Catch All type of Exception. Test execution shouldn't break while taking screenshot on failure/exception
				catch (Exception e) {
					Log.error("Unable to take to screenshot. Reason: " + e.getMessage());
				}
			}
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Log.info("");
		Log.info("********************************\t Test Failed But Within Success Percentage: " + result.getName() + " | Test Set: " + result.getTestContext().getName() + " | Test Class: " + result.getTestClass().getName() +"\t********************************");
		Log.info("");

	}
	@Override
	public void onStart(ITestContext context) {
		Log.info("");
		Log.info("********************************\t Test Set Start: " + context.getName() + "\t********************************");
		Log.info("");

	}
	@Override
	public void onFinish(ITestContext context) {
		Log.info("");
		Log.info("********************************\t Test Set Complete: " + context.getName() + "\t********************************");
		Log.info("");

	}




}
