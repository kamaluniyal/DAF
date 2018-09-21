package com.markit.DigitalAutomationFramework.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.google.common.base.Function;

/**
 * Standard page class that all other page object classes should extend This
 * allows for standard methods to be shared and cuts down on duplication
 * 
 * @author stuart.rogers
 * @version 1.0
 * @since 2015-07-27
 * 
 */
public class Page {
	/**
	 * WebDriver object used that has launched the currently accessed page
	 */
	public static int repeatCounter = 0; // Added this counter for fnClick
	// function
	protected WebDriver _driver;
	protected ExtentReporting extReport;
	public SoftAssert softAssert;
	private String parentWindow;

	public void sendObject(ExtentReporting ob, SoftAssert s) {
		extReport = ob;
		softAssert = s;
	}

	/**
	 * The current iFrame the code has switched to
	 * <p>
	 * Usefull to keep track off as with Selenium yopu need to tell the driver
	 * to move into and out of an iframe before it can identify elements at that
	 * level
	 */
	protected WebElement currentIFrame;
	/**
	 * Create a new logger for the page
	 */
	protected Logging Log = new Logging(this.getClass().getName());

	/**
	 * 
	 * 
	 * @param driver
	 *            The WebDriver object that launches the page
	 */
	public Page(WebDriver driver) {
		this._driver = driver;
		Log.info(this.getClass().getName() + " initiated");
		PageFactory.initElements(driver, this);
	}

	/**
	 * Switch the WebDriver focus to a specific iframe on the page
	 * 
	 * @param requiredFrame
	 *            The WebElement representing the frame that needs to be
	 *            switched to
	 */
	public void SwitchToFrame(WebElement requiredFrame) {
		try {
			if (currentIFrame != requiredFrame) {
				WebDriverWait wait = (new WebDriverWait(_driver, 10));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(requiredFrame));
				// Log.debug("Frame: " + requiredFrame.getTagName() + "
				// loaded");
				currentIFrame = requiredFrame;
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			extReport.enterLog("Fail", e.getMessage());
			softAssert.assertEquals(true, false, e.getMessage() + "Exception Occured");
		}
	}

	/**
	 * wait for the page loading to complete
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver _driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver _driver) {
				return ((JavascriptExecutor) _driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(_driver, 30);
		wait.until(pageLoadCondition);
	}

	/**
	 * Move back to the top level of the page outside of any frames
	 */
	public void SwitchToTopFrame() {
		try {
			_driver.switchTo().defaultContent();
			currentIFrame = null;
		} catch (Exception e) {
			Log.error(e.getMessage());
			extReport.enterLog("Fail", e.getMessage());
			softAssert.assertEquals(true, false, e.getMessage() + "Exception Occured");
		}
	}

	/**
	 * Uses Selenium actions to carry out a mouse over a specified WebElement.
	 * Which will simulate a mouse moving to the middle of the WebElement and
	 * will trigger any onHover on that WebElement.
	 * 
	 * @param we
	 *            The WebElement that is required for the mouse to move over
	 */
	public void actMouseOver(WebElement we) {
		Actions a = new Actions(_driver);
		try {
			a.moveToElement(we).build().perform();
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				actMouseOver(we);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.error(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * Simulates mouse over to a specified WebElement using Selenium Actions.
	 * <p>
	 * This method takes two web element,first to which the mouse is to be over
	 * and <br>
	 * another Web Element which it waits until to its visibility.
	 * 
	 * @param we
	 * @param waitWe
	 */
	public void actMouseOver(WebElement we, WebElement waitWe) {
		WebDriverWait wait = (new WebDriverWait(_driver, 60));
		try {
		    actMouseOver(we);
			wait.until(ExpectedConditions.visibilityOf(waitWe));
			
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				actMouseOver(we);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.error(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * Simulates mouse over to a specified WebElement using Selenium Actions.
	 * <p>
	 * This method takes a web element and By ,first arguments to which the
	 * mouse is to be over and <br>
	 * another which it waits until to its visibility.
	 * 
	 * @param we
	 * @param waitWe
	 */
	public void actMouseOver(WebElement we, By waitWe) {
		WebDriverWait wait = (new WebDriverWait(_driver, 10));
		actMouseOver(we);
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitWe));
	}

	/**
	 * Simulates the mouse over event to a specified WebElement using java
	 * script executor.
	 * 
	 * @param we
	 *            WebElement from which mouse out event to be performed.
	 */
	public void jsMouseOver(WebElement we) {
		JavascriptExecutor executor = (JavascriptExecutor) _driver;
		executor.executeScript(
				"if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}",
				we);
	}

	/**
	 * Performs mouse out event from a specified WebElement using java script
	 * executor.
	 * 
	 * @param we
	 *            WebElement from which mouse out event to be performed.
	 */
	public void jsMouseOut(WebElement we) {
		JavascriptExecutor executor = (JavascriptExecutor) _driver;
		executor.executeScript(
				"if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseout', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseout');}",
				we);
	}

	/**
	 * Simulates the mouse click event to a specified web element by using
	 * selenium Actions
	 * 
	 * @param we
	 *            WebElement where click is to be performed
	 */
	public void actClick(WebElement we) {
		Actions a = new Actions(_driver);
		try {
			a.click(we).build().perform();
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				actClick(we);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.error(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * Simulates the mouse click event to a specified web element by using
	 * JavascriptExecutor
	 * 
	 * @param we
	 *            WebElement to be clicked.
	 */
	public void jsClick(WebElement we) {
		JavascriptExecutor executor = (JavascriptExecutor) _driver;
		executor.executeScript("arguments[0].click();", we);
	}

	/**
	 * Simulates the enter event by using Selenium Actions
	 */
	public void actEnter() {
		Actions action = new Actions(_driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	/**
	 * Simulates the sends key of a specified key to the active element by using
	 * Selenium Actions
	 * 
	 * @param key
	 *            any pressable key that aren't text
	 */
	public void actSendKeys(Keys key) {
		try {
			Actions action = new Actions(_driver);
			action.sendKeys(key).build().perform();
		} catch (Exception e) {
			Log.error(e.getMessage());
			extReport.enterLog("Fail", e.getMessage());
			softAssert.assertEquals(true, false, e.getMessage() + "Exception Occured");
		}
	}

	/**
	 * Performs drag and drop function dragging source locator to destination
	 * locator
	 * 
	 * @param source
	 *            , target
	 * 
	 * @author rahul.tiwari
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(_driver);
		try {
			action.dragAndDrop(source, target).perform();
			extReport.enterLog("Pass",
					"Source element '" + source + "' is dragged and dropped to '" + target + "' element");
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				dragAndDrop(source, target);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.error(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * Returns the text of the specified web element.
	 * 
	 * @param we
	 *            WebElement that the text is required from
	 * @return String text contained in the WebElement
	 */
	public String getElementText(WebElement we) {
		String str = null;
		try {
			str = we.getText();
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				getElementText(we);

			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.error(e.toString());
		}
		repeatCounter = 0;
		return str;
	}

	/**
	 * Verifies if the String is numerical by trying to Parse into float
	 * 
	 * @param value
	 *            String for verification
	 * @return true if string is numerical. Type - boolean
	 */
	public boolean isNumerical(String value) {
		try {
			@SuppressWarnings("unused")
			Float f = Float.parseFloat(value);
			return true;
		} catch (NumberFormatException e) {
			Log.error(e.getMessage());
			extReport.enterLog("Fail", e.getMessage());
			softAssert.assertEquals(true, false, e.getMessage() + "Exception Occured");
			return false;
		}
	}

	/**
	 * Retrieves the WebElements from inside a drop-down on the web page
	 * 
	 * @param we
	 *            The WebElement for the select that the contents need to be
	 *            retrieved from
	 * 
	 * @return A list of WeblElements that are contained within the select
	 * @see Select
	 */
	public List<WebElement> getDropdownOptions(WebElement we) {
		Select sel;
		List<WebElement> allOptions = null;
		try {
			sel = new Select(we);
			allOptions = sel.getOptions();
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				getDropdownOptions(we);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
				allOptions = null;
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.error(e.toString());
		}
		repeatCounter = 0;
		return allOptions;
	}

	/**
	 * Checks the existence of file by taking file path as an argument.
	 * 
	 * @param filePath
	 *            :File path of a file.
	 * @return boolean value true if exist else false.
	 */
	public boolean checkFileExistence(String filePath) {
		File f = new File(filePath);
		if (f.exists())
			return true;
		else
			return false;
	}

	/**
	 * # Function Name: fnSelectRadioButton() # Author: Sunny Jain #
	 * Description: This function will select the radiobutton based on value
	 * provided. # Date of creation: 14 June 2016 # Input Parameters:elementList
	 * , optionval
	 */
	public void fnSelectRadioButton(List<WebElement> elementList, String optionval) {
		try {
			List<WebElement> radios = elementList;
			for (int i = 0; i < radios.size(); i++) {
				String val = (radios.get(i).getAttribute("Value").toString());
				if (val.equals(optionval)) {
					radios.get(i).click();
					Log.info("Radio button has been selected successfully");
				}
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnSelectRadioButton(elementList, optionval);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.error(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnSelectValueFromDropDownByValue()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will select the value from the drop down
	 * list based on value provided.
	 * 
	 * # Date of creation: 14 June 2016 # Input Parameters: weElement , strValue
	 */
	public void fnSelectValueFromDropDownByValue(WebElement weElement, String strValue) {
		try {
			Select oSelect = new Select(weElement);
			oSelect.selectByValue(strValue);
			Log.info(strValue + " has been selected in the dropdown" + weElement + "successfully");
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnSelectValueFromDropDownByValue(weElement, strValue);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnSelectValueFromDropDownByVisibleText()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will select the value from the drop down
	 * list based on visible text of value in drop down.
	 * 
	 * # Date of creation: 14 June 2016
	 * 
	 * # Input Parameters: weElement , strValue
	 */
	public void fnSelectValueFromDropDownByVisibleText(WebElement weElement, String strText) {
		try {
			Select oSelect = new Select(weElement);
			oSelect.selectByVisibleText(strText);
			Log.info(strText + " has been selected in the dropdown" + weElement + "successfully");
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnSelectValueFromDropDownByVisibleText(weElement, strText);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");

			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnSelectValueFromDropDownByIndex()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will select the value from the drop down
	 * list based on index of value in drop down.
	 * 
	 * # Date of creation: 14 June 2016
	 * 
	 * # Input Parameters: weElement , strValue
	 */
	public void fnSelectValueFromDropDownByIndex(WebElement weElement, int index) {
		try {
			Select oSelect = new Select(weElement);
			oSelect.selectByIndex(index);
			Log.info(index + " has been selected in the dropdown" + weElement + "successfully");
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnSelectValueFromDropDownByIndex(weElement, index);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnWaitTillElementVisible()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will wait for specified time till element is
	 * visible.
	 * 
	 * # Date of creation: 14 June 2016
	 * 
	 * # Input Parameters: WebDriver,iTimeOut,WebElement
	 */
	public void fnWaitTillElementVisible(WebDriver _driver, int iTimeOut, WebElement weElement) {
		try {
			Log.info("waiting for element to get visible");
			// WebDriverWait wait = (new WebDriverWait(_driver, iTimeOut));
			// wait.until(ExpectedConditions.visibilityOf(weElement));
			int counter = 0;
			while (!weElement.isDisplayed() && counter < iTimeOut) {
				Thread.sleep(1000);
				counter++;
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnWaitTillElementVisible(_driver, iTimeOut, weElement);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			Log.info(e.toString());
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnWaitTillElementVisible()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will wait for specified time till element is
	 * visible.
	 * 
	 * # Date of creation: 14 Nov 2016
	 * 
	 * # Input Parameters: WebDriver,iTimeOut,String
	 */
	public void fnWaitTillElementVisible(WebDriver _driver, int iTimeOut, String weElement) {
		try {
			Log.info("waiting for" + weElement + "to get visible");
			WebDriverWait wait = (new WebDriverWait(_driver, iTimeOut));
			wait.until(ExpectedConditions.visibilityOf(_driver.findElement(By.xpath(weElement))));
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnWaitTillElementVisible(_driver, iTimeOut, weElement);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");

			}
		} catch (Exception e) {
			Log.info(e.toString());
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnWaitTillElementEnable()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will wait for specified time till element is
	 * enabled.
	 * 
	 * # Date of creation: 14 June 2016
	 * 
	 * # Input Parameters: WebDriver,iTimeOut,WebElement
	 */

	public void fnWaitTillElementEnable(WebDriver _driver, int iTimeOut, WebElement weElement) {
		try {
			Log.info("waiting for Element to get enabled");
			Wait<WebElement> wait = new FluentWait<WebElement>(weElement).withTimeout(iTimeOut, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(new Function<WebElement, Boolean>() {
				@Override
				public Boolean apply(WebElement element) {
					return element.isEnabled();
				}
			});
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnWaitTillElementEnable(_driver, iTimeOut, weElement);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnVerifyElementColor()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify the color of the element.
	 * 
	 * # Date of creation: 16 June 2016
	 * 
	 * # Input Parameters: WebElement,colorcode
	 */
	public boolean fnVerifyElementColor(WebElement webelement, String colorcode) {
		boolean b = false;
		try {
			String rgb = webelement.getCssValue("color");
			if (rgb.equals(colorcode)) {
				Log.info("Actual color is same as expected color");
				b = true;
			} else {
				Log.info("Actual color is not same as expected color");
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnVerifyElementColor(webelement, colorcode);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info("Unable to verify the color due to exception :" + e.toString());
		}
		repeatCounter = 0;
		return b;
	}

	/**
	 * # Function Name: fnVerifyElementText()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will verify text of the element.
	 * 
	 * # Date of creation: 16 June 2016
	 * 
	 * # Input Parameters: WebElement,text
	 */
	public boolean fnVerifyElementText(WebElement element, String text) {
		String strText;
		boolean b = false;
		try {
			strText = element.getText();
			if (strText.equals(text)) {
				b = true;
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnVerifyElementText(element, text);
			} else {
				Log.info("Element is stale " + repeatCounter);
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info("Unable to verify the text");
		}
		repeatCounter = 0;
		return b;
	}

	/**
	 * # Function Name: fnScrollPage()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will scroll the page up or down by specified
	 * pixels.
	 * 
	 * # Date of creation: 16 June 2016
	 * 
	 * # Input Parameters: WebElement
	 */
	public void fnScrollPage(String scrollCase, int pixelToScroll) {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) _driver;
			switch (scrollCase.toUpperCase()) {
			case "DOWN":
				// Scrolled page down
				jsExecutor.executeScript("scrollBy(0," + pixelToScroll + ")");
				break;
			case "UP":
				// Scrolled page up
				jsExecutor.executeScript("scrollBy(0," + -pixelToScroll + ")");
				break;
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info("Unable to Scroll the page");
		}
	}

	/**
	 * # Function Name: fnGetColumnHeadersOfWebtable()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will fetch the header texts of the webtable
	 * in a list.
	 * 
	 * # Date of creation: 16 June 2016
	 * 
	 * # Input Parameters: WebElement ,colIndex
	 */
	public List<String> fnGetColumnHeadersOfWebtable(WebElement element, int rowIndex) {
		List<String> colValues = new ArrayList<String>();
		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			List<WebElement> columns = rows.get(rowIndex - 1).findElements(By.tagName("th"));
			for (int cnum = 0; cnum < columns.size(); cnum++) {
				colValues.add(columns.get(cnum).getText());
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnGetColumnHeadersOfWebtable(element, rowIndex);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
				colValues = null;
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
			colValues = null;
		}
		repeatCounter = 0;
		return colValues;
	}

	/**
	 * # Function Name: fnGetColumnHeadersOfWebtable()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will fetch the header objects of the
	 * webtable in a list. The objects will be used for further processing
	 * 
	 * # Date of creation: 5 December 2016
	 * 
	 * # Input Parameters: WebElement ,rowIndex
	 */
	public List<WebElement> fnGetColumnHeadersObjectsOfWebtable(WebElement element, int rowIndex) {
		List<WebElement> columns = new ArrayList<WebElement>();
		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			columns = rows.get(rowIndex - 1).findElements(By.tagName("th"));
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnGetColumnHeadersOfWebtable(element, rowIndex);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
				columns = null;
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
			columns = null;
		}
		repeatCounter = 0;
		return columns;
	}

	/**
	 * # Function Name: fnGetDataOfWebtable()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will fetch the data of all columns for all
	 * rows in a webtable.
	 * 
	 * # Date of creation: 14 July 2016
	 * 
	 * # Input Parameters: WebElement (Locator till tbody of the table)
	 */
	public List<String> fnGetDataOfWebtable(WebElement element) {
		List<String> values = new ArrayList<String>();
		List<WebElement> rows;
		try {
			rows = element.findElements(By.tagName("tr"));
			for (int rnum = 0; rnum < rows.size(); rnum++) {
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				for (int cnum = 0; cnum < columns.size(); cnum++) {
					values.add(columns.get(cnum).getText());
				}
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnGetDataOfWebtable(element);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
				values = null;
			}
		} catch (Exception e) {
			Log.info(e.toString());
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			values = null;
		}
		repeatCounter = 0;
		return values;
	}

	/**
	 * # Function Name: fnGetListOfRowElementsForColumnFromWebtable()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will fetch the list of all rows elements for
	 * a particular column from a webtable.
	 * 
	 * # Date of creation: 16 June 2016
	 * 
	 * # Input Parameters: WebElement ,colIndex
	 */
	public List<String> fnGetListOfRowElementsForColumnFromWebtable(WebElement element, int colIndex) {
		List<String> rowValues = new ArrayList<String>();
		List<WebElement> rows;
		try {
			rows = element.findElements(By.tagName("tr"));
			for (int rnum = 1; rnum < rows.size(); rnum++) {
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				rowValues.add(columns.get(colIndex).getText());
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnGetListOfRowElementsForColumnFromWebtable(element, colIndex);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
				rowValues = null;
			}
		} catch (Exception e) {
			Log.info(e.toString());
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			rowValues = null;
		}
		repeatCounter = 0;
		return rowValues;
	}

	/**
	 * # Function Name: fnGetListOfColumnElementsForRowFromWebtable()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will fetch the list of all columns elements
	 * for a particular row from a webtable.
	 * 
	 * # Date of creation: 16 June 2016
	 * 
	 * # Input Parameters: WebElement ,rowIndex
	 */
	public List<String> fnGetListOfColumnElementsForRowFromWebtable(WebElement element, int rowIndex) {
		List<String> colValues = new ArrayList<String>();
		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			List<WebElement> columns = rows.get(rowIndex).findElements(By.tagName("td"));
			for (int cnum = 0; cnum < columns.size(); cnum++) {
				colValues.add(columns.get(cnum).getText());
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnGetListOfColumnElementsForRowFromWebtable(element, rowIndex);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
				colValues = null;
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
			colValues = null;
		}
		repeatCounter = 0;
		return colValues;
	}

	/**
	 * # Function Name: fnNavigateBack()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will navigate back.
	 * 
	 * # Date of creation: 16 June 2016
	 * 
	 * # Input Parameters: NA
	 */
	public void fnNavigateBack() {
		try {
			_driver.navigate().back();
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		}
	}

	/**
	 * # Function Name: fnSwitchToNewlyOpenedWindow()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will switch to newly opened window.
	 * 
	 * # Date of creation: 16 Dec 2016
	 * 
	 * # Input Parameters: NA
	 */
	public void fnSwitchToNewlyOpenedWindow() {
		for (String winHandle : _driver.getWindowHandles()) {
			try {
				_driver.switchTo().window(winHandle);
			} catch (Exception e) {
				extReport.enterLog("Fail", e.toString());
				softAssert.assertEquals(true, false, e.toString());
				Log.info(e.toString());
			}
		}
	}

	/**
	 * # Function Name: fnCheckElementExistence()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will switch to newly opened window.
	 * 
	 * # Date of creation: 16 Dec 2016
	 * 
	 * # Input Parameters: WebElement
	 */

	public boolean fnCheckElementExistence(WebElement element) {
		boolean b = false;
		try {
			if (element.isDisplayed()) {
				b = true;
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnCheckElementExistence(element);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
		}
		repeatCounter = 0;
		return b;
	}

	/**
	 * # Function Name: fnSwitchToParentWindow()
	 * 
	 * # Author: Rahul Tiwari
	 * 
	 * # Description: This function will switch to newly opened window.
	 * 
	 * # Date of creation: 16 Dec 2016
	 * 
	 * # Input Parameters: NA
	 */
	public void fnSwitchToParentWindow() {
		try {
			_driver.switchTo().window(parentWindow);
		} catch (Exception e) {
			extReport.enterLog("Fail", e.getMessage());
			Log.info(e.getMessage());
			softAssert.assertEquals(true, false, e.getMessage() + "Exception Occured");
		}
	}

	/**
	 * # Function Name: fnCheckCheckbox()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will check the checkbox.
	 * 
	 * # Date of creation: 21 Dec 2016
	 * 
	 * # Input Parameters: WebElement
	 */
	public void fnCheckCheckbox(WebElement weElement) {
		try {
			Log.info("waiting for element to get enabled");
			if (weElement.isSelected()) {
				extReport.enterLog("Info", "Checkbox is already selected");
			} else {
				weElement.click();
				if (weElement.isSelected()) {
					extReport.enterLog("Pass", "Checkbox has been selected");
				} else {
					extReport.enterLog("Fail", "Checkbox has not been selected");
				}
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnCheckCheckbox(weElement);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		}
		repeatCounter = 0;
	}

	/**
	 * # Function Name: fnUncheckCheckbox()
	 * 
	 * # Author: Sunny Jain
	 * 
	 * # Description: This function will uncheck the checkbox.
	 * 
	 * # Date of creation: 21 Dec 2016
	 * 
	 * # Input Parameters: WebElement
	 */
	public void fnUncheckCheckbox(WebElement weElement) {
		try {
			Log.info("waiting for element to get enabled");
			if (weElement.isSelected()) {
				weElement.click();
				if (weElement.isSelected()) {
					extReport.enterLog("Fail", "Checkbox has not been unselected");
				} else {
					extReport.enterLog("Pass", "Checkbox has been unselected");
				}
			} else {
				extReport.enterLog("Info", "Checkbox is already unselected");
			}
		} catch (StaleElementReferenceException e1) {
			repeatCounter++;
			if (repeatCounter < 5) {
				fnUncheckCheckbox(weElement);
			} else {
				Log.info("Element is stale");
				extReport.enterLog("Fail", "Element is stale after" + repeatCounter + "tries");
			}
		} catch (Exception e) {
			extReport.enterLog("Fail", e.toString());
			softAssert.assertEquals(true, false, e.toString());
			Log.info(e.toString());
		}
		repeatCounter = 0;
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
		Page.repeatCounter = 0;
	}

}
