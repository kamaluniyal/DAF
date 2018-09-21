package com.markit.DigitalAutomationFramework.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.MDC;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import com.markit.DigitalAutomationFramework.common.DataReader;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.markit.DigitalAutomationFramework.common.Logging;

/**
 * Standard Test class that all other Test classes should extend This allows for
 * standard methods to be shared and cuts down on duplication
 * 
 * @author stuart.rogers
 * @version 1.0
 * @since 2015-07-27
 *
 */
@Listeners({ com.markit.DigitalAutomationFramework.common.TestListener.class,
		com.markit.DigitalAutomationFramework.utilities.SeALMMap.class })
public class TestClass {
	protected DataReader data;
	protected GlobalDriver gDriver;
	protected String testEnvironment, testURL, testUserType, testUserName, testPassword;
	// ExtentReports extent ;
	protected ExtentReporting extReport = new ExtentReporting();
	protected static ExtentReports extent;
	public SoftAssert softAssert = new SoftAssert();
	/**
	 * The WebDriver object being used for the current test
	 */
	protected WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Creating a new log instance for the current test
	 */
	protected Logging Log = new Logging(this.getClass().getName());
	Page p = new Page(driver);

	/**
	 * Uses the TestNG BeforeMethod attribute to add a message to the logs that
	 * the test is about to start
	 * 
	 * @param method
	 *            The name of the Test Method that is about to be executed
	 * 
	 */
	@BeforeMethod
	public void beforeMethod(Method method) {
		Thread t = new Thread();
		t.setName(method.getName());
		Long th = t.getId();
		MDC.put("TestCaseName", t.getName());
		MDC.put("ThreadID", "ID-" + th);
		Log.startTestCase(t.getName());
	}

	/**
	 * Uses the TestNG AfterMethod attribute to add a message to the logs that
	 * the test has completed.
	 * 
	 * @param result
	 *            Test result from TestNG
	 * 
	 * @param method
	 *            The name of the Test Method that has just completed execution
	 * 
	 * @throws IOException
	 */
	@AfterMethod
	public void afterMethod(ITestResult result, Method method) throws IOException {
		Thread t = new Thread();
		t.setName(method.getName());
		Log.endTestCase(t.getName());
	}

	/**
	 * Uses the TestNG BeforeClass attribute to add a message to the logs about
	 * Test name and Id of a test.
	 * 
	 * @throws IOException
	 * 
	 */
	@BeforeClass
	public void beforeClass() throws IOException {
		Thread t = new Thread();
		t.setName(this.getClass().getSimpleName());
		Long th = t.getId();
		MDC.put("TestCaseName", t.getName());
		MDC.put("ThreadID", "ID-" + th);
		Log.info("BEFORE CLASS: " + t.getName());
	}

	/**
	 * Counts total number of files in a directory, including sub directories
	 * 
	 * @param dir
	 *            the directory DataType - File
	 * @return total number of files DataType - int
	 */
	public static int countFilesInDirectory(File dir) {
		int totalFiles = 0;
		File[] listFiles = dir.listFiles();
		if (listFiles != null && listFiles.length > 0) {
			for (File file : listFiles) {
				if (file.isFile()) {
					totalFiles++;
				} else {
					totalFiles += countFilesInDirectory(file);
				}
			}
		}
		return totalFiles;
	}

	/**
	 * # Function Name: fnVerifyElementExistenceWithText()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the element existence with text.
	 * 
	 * # Date of creation: 14 July 2016
	 * 
	 * # Input Parameters: WebElement ,string
	 */
	public void fnVerifyElementExistenceWithText(WebElement element, String text) {
		try {
			String strText = element.getText().trim();
			if (strText.equals(text)) {
				extReport.enterLog("Pass", "Element with text '" + text + "' exists on the page.");
			} else {
				extReport.enterLog("Fail", "Element with text '" + text + "' does not exist on the page.");
				softAssert.assertEquals(true, false, "Text verification failed ");
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 3) {
				fnVerifyElementExistenceWithText(element, text);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale");
				softAssert.assertEquals(true, false, e1.toString());
				// Page.repeatCounter=0;
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			Log.info(e.toString());
			e.printStackTrace();
			softAssert.assertEquals(true, false, e.toString());
		} finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * # Function Name: fnVerifyElementExistenceWithPartialText()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the element existence.
	 * 
	 * # Date of creation: 14 July 2016
	 * 
	 * # Input Parameters: WebElement ,string
	 */
	public void fnVerifyElementExistence(WebElement element, String desc) {
		try {
			if (element.isDisplayed()) {
				extReport.enterLog("Pass", "'" + desc + "' exists on the page.");
			} else {
				softAssert.assertEquals(true, false, "Element does not exist ");
				extReport.enterLog("Fail", "'" + desc + "' does not exist on the page.");
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 5) {
				fnVerifyElementExistence(element, desc);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + Page.repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		} finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * # Function Name: fnVerifyHeadersOfwebtable()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the Header of a webtable at
	 * specified row.
	 * 
	 * # Date of creation: 14 June 2016
	 * 
	 * # Input Parameters: WebElement ,rowIndex ,string
	 */

	public void fnVerifyHeadersOfwebtable(WebElement element, int rowIndex, String str) {
		try {
			List<String> actualText = p.fnGetColumnHeadersOfWebtable(element, rowIndex);
			String[] expectedText = str.split("@");
			for (int j = 0; j < expectedText.length; j++) {
				if (expectedText[j].equals(actualText.get(j))) {
					extReport.enterLog("Pass", actualText.get(j) + " column is present in the table.");
				} else {
					extReport.enterLog("Fail", "'" + actualText.get(j) + "'"
							+ " column is not same with expected column - " + "' " + expectedText[j] + "'");
					softAssert.assertEquals(true, false, "Webtable header verification failed ");
				}
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 5) {
				fnVerifyHeadersOfwebtable(element, rowIndex, str);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + Page.repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.getMessage());
		} finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * # Function Name: fnVerifyDropdownOptions()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will verify the dropdown options
	 * 
	 * # Date of creation: 13 July 2016
	 * 
	 * # Input Parameters: WebElement ,options
	 */
	public void fnVerifyDropdownOptions(WebElement element, String options) {
		try {
			Log.info("Verifying list options with locator : " + element);
			String[] expectedOptions = options.split("@");
			Select dropdown = new Select(element);
			List<WebElement> actualOptions = dropdown.getOptions();
			for (int i = 0; i < expectedOptions.length; i++) {
				if (expectedOptions[i].equals(actualOptions.get(i).getText().trim())) {
					extReport.enterLog("Pass", "'" + expectedOptions[i] + "'" + " option exists in the Dropdown .");
				} else {
					softAssert.assertEquals(true, false, "Dropdown verification failed ");
					extReport.enterLog("Fail", "'" + actualOptions.get(i).getText() + "'"
							+ " is not same with expected option in dropdown- " + expectedOptions[i]);
				}
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 5) {
				fnVerifyDropdownOptions(element, options);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + Page.repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		} finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * fnVerifyDataOfWebtable # Function Name: fnVerifyDropdownOptions()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the data of a webtable rowwise.
	 * # Date of creation: 14 July 2016D
	 * 
	 * # Input Parameters: WebElement ,string
	 */
	public void fnVerifyDataOfWebtable(WebElement element, String str) {
		try {
			List<String> actualText = p.fnGetDataOfWebtable(element);
			String[] expectedText = str.split("@");
			for (int j = 0; j < expectedText.length; j++) {
				if (expectedText[j].equals(actualText.get(j))) {
					extReport.enterLog("Pass", actualText.get(j) + " has been verified successfully.");
				} else {
					softAssert.assertEquals(true, false, "Table data verification failed ");
					extReport.enterLog("Fail",
							actualText.get(j) + " is not same with expected text - " + expectedText[j]);
				}
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 5) {
				fnVerifyDataOfWebtable(element, str);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + Page.repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		} finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * # Function Name: fnVerifyStateOfWebelement()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the state of webelement
	 * 
	 * # Date of creation: 14 Dec 2016
	 * 
	 * # Input Parameters: WebElement ,rowIndex ,string
	 */
	public void fnVerifyStateOfWebelement(WebElement element, String state) {
		try {
			if (state.equalsIgnoreCase("Enable")) {
				boolean status = element.isEnabled();
				if (status) {
					extReport.enterLog("Pass", "Element is enabled.");
				} else {
					extReport.enterLog("Fail", "Element is not enabled.");
					softAssert.assertEquals(true, false, "State verification failed ");
				}
			} else if (state.equalsIgnoreCase("Disable")) {
				boolean status = element.isEnabled();
				if (!status) {
					extReport.enterLog("Pass", "Element is disabled.");
				} else {
					extReport.enterLog("Fail", "Element is not disabled.");
					softAssert.assertEquals(true, false, "State verification failed ");
				}
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 3) {
				fnVerifyStateOfWebelement(element, state);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale");
				// Page.repeatCounter=0;
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			Log.info(e.toString());
			softAssert.assertEquals(true, false, e.toString());
		} finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * # Function Name: fnVerifyElementExistenceWithPartialText()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the element existence with
	 * partial text.
	 * 
	 * # Date of creation: 14 Dec 2016
	 * 
	 * # Input Parameters: WebElement ,string
	 */
	public void fnVerifyElementExistenceWithPartialText(WebElement element, String text) {
		try {
			String strText = element.getText().trim();
			if (strText.contains(text)) {
				extReport.enterLog("Pass", "Element containing text '" + text + "' exists on the page.");
			} else {
				extReport.enterLog("Fail", "Element containing text '" + text + "' does not exist on the page.");
				softAssert.assertEquals(true, false, "Text verification failed ");
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 5) {
				fnVerifyElementExistenceWithPartialText(element, text);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + Page.repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		} finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * # Function Name: fnClick()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will click on the webelement 
	 * # Date of creation: 27 Sept 2016
	 * 
	 * # Input Parameters: WebElement
	 */
	public void fnClick(WebElement we) {
		try {
			// extReport.enterLog("info","Clicking on element "+we);
			we.click();
		} catch (Exception e) {
			if (e.getMessage().toString().contains("Element is not clickable at point")
					|| e.getMessage().toString().contains("stale element reference")) {
				Log.info("Exception occured while clicking : " + we);
				Page.repeatCounter++;
				if (Page.repeatCounter < 5) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Log.info("Trying to click again...");
					fnClick(we);
				} else {
					Log.info("Element  is not clickable.");
					extReport.enterLog("Fail", e.toString());
					softAssert.assertEquals(true, false, e.toString());
				}
			} else {
				extReport.enterLog("Fail", e.toString());
				softAssert.assertEquals(true, false, e.toString());
			}
		}
		finally {
			Page.repeatCounter = 0;
		}
	}

	/**
	 * # Function Name: fnVerifyTextInPDF()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will verify the presence of certain text in
	 * PDF # Date of creation: 27 December 2016
	 * 
	 * # Input Parameters: ArrayList of required texts ,rowIndex , Return
	 * type-string
	 */
	public void fnVerifyTextInPDF(ArrayList<String> texts, String pagetext) {
		try {
			for (String pattern : texts) {
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(pagetext);
				if (m.find()) {
					extReport.enterLog("pass", "'" + pattern + "' found in the pdf");
				} else {
					extReport.enterLog("fail", "'" + pattern + "' not found in the pdf");
				}
			}
		} catch (Exception e) {
			extReport.enterLog("fail", e.getMessage());
		}
	}

	/**
	 * # Function Name: fnVerifyDateFormatOfMMDDYY()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the format of date. # Date of
	 * creation: 27 December 2016
	 * 
	 * # Input Parameters: WebElement
	 */
	public void fnVerifyDateFormatOfMMDDYY(WebElement weElement) {
		try {
			String line = weElement.getText();
			String pattern = "(0[0-9]||1[0-2])/(0[1-9]||[1-2][0-9]||3[0-1])/([0-9][0-9])";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(line);
			if (m.find()) {
				extReport.enterLog("Pass", "As of Date format - MMDDYY has been verified successfully");
			} else {
				extReport.enterLog("Fail", "As of Date format - MMDDYY has not been verified");
			}
		} catch (StaleElementReferenceException e1) {
			Page.repeatCounter++;
			if (Page.repeatCounter < 5) {
				fnVerifyDateFormatOfMMDDYY(weElement);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + Page.repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		} finally {
			Page.repeatCounter = 0;
		}
	}
}
