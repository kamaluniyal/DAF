package com.markit.DigitalAutomationFramework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.markit.DigitalAutomationFramework.common.Logging;
import com.markit.DigitalAutomationFramework.common.PropertyReader;

import ru.yandex.qatools.allure.annotations.Attachment;



/**
 * This class is used to carry the functionality of taking screenshot.
 * 
 * @author sonam.chhetri
 * @author nishant.thakur
 */
public class Screenshot

{

	/**
	 * WebDriver attached
	 */
	protected WebDriver _driver;
	
	/**
	 * Creating a new log instance for the current test
	 */
	protected Logging log;

	/**
	 * 
	 * @param driver
	 */
	public Screenshot(WebDriver driver) {
		this._driver = driver;
		log = new Logging(this.getClass().getName());
	}
	
	/**
	 * Sets the screenshot path and takes a screenshot of a page on failure of test and store it in a folder
	 * named Screenshot in the current working directory.
	 * 
	 * @param result Result from TestNG
	 *            
	 * @throws IOException
	 */
	public File takeScreenshot(ITestResult result) throws IOException  {
		
		//Extract SuiteName
		String suiteName = result.getTestContext().getSuite().getName();
		
		//Extract TestName i.e. Name of Test of Suite i.e. Test Name in XML file not @Test
		String suiteTestName = result.getTestContext().getCurrentXmlTest().getName();
		
		
		//Steps to Create screenshot image name
		String finalImageName = "";
		
		//Get Calling method name.
		String callerMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();

		//Getting the failed method name and storing it.
		String failedMethodName = result.getName().toString().trim();

		//Instantiate a Date object and formating date in ddMMMyy-HH-mm-ss format
		SimpleDateFormat df = new SimpleDateFormat("ddMMMyy-HH-mm-ss");
		String timeStamp = df.format(new Date());
		
		if (callerMethodName.toLowerCase().contains("onexception"))
			finalImageName = failedMethodName+ "_" + timeStamp + "_Exception.png";
		else if (callerMethodName.toLowerCase().contains("onfailure"))
			finalImageName = failedMethodName+ "_" + timeStamp + "_Failure.png";
		else
			finalImageName = failedMethodName+ "_" + timeStamp + ".png";

		//Screenshot folder location
		String location = System.getProperty("user.dir") + File.separator 
							+ "Screenshot" + File.separator
							+ findBrowserName() + File.separator
							+ findEnvironment(result) + File.separator
							+ suiteName + File.separator
							+ suiteTestName;
		
		File dir = new File (location);
		dir.mkdirs();
		
		//Get screenshot, convert into file format and save
		log.info("Trying to take screenshot");
		
		
		File imageTemp = OutputType.FILE.convertFromPngBytes(getScreenshot());
		File image = new File(location + File.separator + finalImageName);
		FileUtils.copyFile(imageTemp, image);
		
		log.info("Screenshot taken : " + location + File.separator + finalImageName);
		
		//Return file reference
		return image;
	}

	/**
	 * Captures screenshot and returns as byte[]
	 * @return
	 */
	@Attachment(value = "Screenshot", type ="image/png"  )
	public byte[] getScreenshot(){
		return ((TakesScreenshot) _driver).getScreenshotAs(OutputType.BYTES);
	}

	/**
	 * Finds environment of execution 
	 * @param result
	 * @return
	 */
	protected String findEnvironment(ITestResult result){
		
		//Get All Parameters with which this test was executed
		Map<String,String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
		
		//Find if it has any parameter for Environment
		String envParamName = null;
		for(String e : params.keySet()){
			if(e.toLowerCase().contains("env")){
				envParamName = e;
				break;
			}
		}
		
		//If Environment parameter found use it get its value
		if (envParamName != null)
			return params.get(envParamName);
		//Else use default Environment name
		else
			return PropertyReader.getFieldValue("defaultEnvironment");
		
	}
	
	/**
	 * Extracts browser name
	 * @return
	 */
	protected String findBrowserName(){
		WebDriver d;
		try{
			EventFiringWebDriver  ed = (EventFiringWebDriver) _driver;
			d = ed.getWrappedDriver();
		}catch(ClassCastException e){
			//If already a RemoteWebDriver
			d = _driver;
		}
		
		RemoteWebDriver rd = ((RemoteWebDriver) d );
		Capabilities cap = rd.getCapabilities();
		return cap.getBrowserName().toUpperCase();
	}
	
}
