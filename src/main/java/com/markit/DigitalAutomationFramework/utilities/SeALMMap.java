package com.markit.DigitalAutomationFramework.utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.markit.DigitalAutomationFramework.common.Logging;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.utilities.*;


/**This class is a testNG listener class, acts as a bridge between test class and SeAlmIntegrater class.
 * It extends TestListnerAdapter class and implements ITestListener interface of testNG.
 * 
 * It has methods to perform following requests:
 * Authentication of user for ALM and storing test class name.
 * Calls for mapping selenium test methods and ALM test cases.
 * Registering result of test execution methods.
 * 
 * Prerequisites:
 * 1) xls file with sheet name TestDetails containing test id , test set id, run name and class name.
 * 
 * 
 * 2) configuration file having fields domain, project and enable_alm.
 * enable_alm=true/false
 * domain= domainName (as in ALM).
 * project= projectName (as in ALM).
 * 
 * 3) Please make sure that required test configuration of a test is available in test set in ALM.
 * Violation of this may result into logging result in other test configuration of same test case.
 *  
 * NOTE:
 * Please do not repeat entries in xls.
 * Please do not change the order of columns.
 * 
 * @author priyesh.tuli
 */
public class SeALMMap extends TestListenerAdapter implements ITestListener {
	
	/**
	 * Used to communicate with ALM.
	 */
	private SeAlmIntegrater sealm;
	
	/**
	 * Used for logging.
	 */
	private Logging log=new Logging(this.getClass().getSimpleName());
	
	/**Name of the test method implemented in test class.
	 * 
	 */
	private String testName;
	
	/**Execution status of test method 
	 * 
	 */
	private String status;							
	
	/**Name of the test class in framework.
	 * 
	 */
	private String className;
	
	/**Value of browser of test suite retrieved from testNG xml file.
	 * 
	 */
	private String browser;							//
	
	/**Name of domain in ALM. Value retrieved from configuration file of framework.
	 * 
	 */
	private String domain;
	
	/**Name of prject in ALM. Value retrieved from configuration file of framework.
	 * 
	 */
	private String project;
	
	/**Response code of http methods requested to ALM server.
	 * 
	 */
	private int responseCode;
	
	/**Test status message. Used for citing reason of test failure.
	 * 
	 */
	private String statusMessage;
	
	/**Duration of test method execution 
	 * 
	 */
	private long durationTime;
	
	/**Property reader object used for getting values from configuration file.
	 * 
	 */
	public PropertyReader prop = new PropertyReader();
	
	/**Constructor
	 * Maps test methods to ALM using SeALMIntegrater.
	 * Read values from configuration file using property reader.
	 * 
	 * @throws IOException
	 */
	public SeALMMap() throws IOException{
	}
	
	/**Authenticate user for ALM REST API.
	 * It take values of domain and project from configuration file.
	 * @throws IOException
	 */
	private void authenticateUsers() throws IOException {
		domain = PropertyReader.getFieldValue("domain");	//reading domain from config file
		
		project = PropertyReader.getFieldValue("project");	//reading project from config file
		
		sealm=new SeAlmIntegrater(domain, project);		//Creating Object
		responseCode=sealm.authenticateUsers();				//Authenticating User
		
		if(responseCode==200) {								//200 is response code for successful user authentication
			log.info("User authentication successful");
			sealm.getBrowserConfig();
		}
	}
	
	/**Called before any configuration method in test class.
	 * Authenticates user before calling beforeClass.
	 * Method also get test class name for every test method. 
	 */
	@Override
	public void beforeConfiguration(ITestResult result) {
		
		//getting class name
		className = result.getMethod().getTestClass().getRealClass().getSimpleName();
		
		if(PropertyReader.getFieldValue("enable_alm").equalsIgnoreCase("true"))		// If ALM integration enabled then only 
			if(result.getMethod().getMethodName().equals("beforeClass")) { 				// authentication will be performed at
																						// before class level.
				try {
					authenticateUsers();
				}
				catch (IOException IOExp)
				{
					log.info(IOExp.toString());
				}
			}
	}
	
	/**Method is called when test has passed.
	 * If enable_alm is set to true in configuration file then mapping of test cases between ALM and test 
	 * class is done and test status is logged in ALM for against the test case.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		
		//check if alm integration is enabled
		if(PropertyReader.getFieldValue("enable_alm").equalsIgnoreCase("true")) {
			browser = result.getMethod().getTestClass().getXmlTest().getParameter("browser");
			
			status="Passed";									// test status stored.
			
			statusMessage="Test case passed.";					//status message.
			
			sealm.mapWithALM(getTestMethodName(result), className, browser);		// getting test method name
			
			registerResponse();									//register response in ALM.
		}
	}
	
	/**Method is called when test has failed.
	 * If enable_alm is set to true in configuration file then mapping of test cases between ALM and test 
	 * class is done and test status is logged in ALM for against the test case.
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		
		//check if alm integration is enabled
		if(PropertyReader.getFieldValue("enable_alm").equalsIgnoreCase("true")) {
			browser = result.getMethod().getTestClass().getXmlTest().getParameter("browser");
				
			status="Failed";												// test status stored.
			
			statusMessage=result.getThrowable().toString();					//status message.
			
			sealm.mapWithALM(getTestMethodName(result), className, browser);	// getting test method name.
			
			registerResponse();											//registering response back to ALM.
		}
	}
	
	/**Method is called when test has been skipped.
	 * If enable_alm is set to true in configuration file then mapping of test cases between ALM and test 
	 * class is done and test status is logged in ALM for against the test case.
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		
		//check if alm integration is enabled
		if(PropertyReader.getFieldValue("enable_alm").equalsIgnoreCase("true")) {
			browser = result.getMethod().getTestClass().getXmlTest().getParameter("browser");
				
			status="No Run";												// test status stored.

			statusMessage="Test case has been skipped.";					//status message.

			sealm.mapWithALM(getTestMethodName(result), className, browser);// getting test method name

			registerResponse();
		}
	}
	
	/**Returns name of test method.
	 * 
	 * @param result - result variable for ITestResult.
	 * @return	- test method name
	 */
	private String getTestMethodName(ITestResult result) {
		testName=result.getMethod().getConstructorOrMethod().getName();		//getting test method name
		
		durationTime=result.getEndMillis()-result.getStartMillis();			//getting duration
		return testName;
	}
	
	/**Registers response in ALM for test case.
	 *
	 */
	private void registerResponse() {
		sealm.setInputSource();					// Setting input source to retrieve values from ALM, required to prepare paylaod
		
		sealm.preparePOSTPayload(testName,statusMessage,durationTime);		// Prepare result payload in xml format.
		
		int runID = sealm.registerResult();		// Register result in ALM and get run id.
		
		if(runID>0)
			log.info("Result registered in ALM.");
		else
			log.info("Result registeration failed in ALM. Response code/Error code form server: "+responseCode);
		
		sealm.updateTestStatus(runID,status);	// Update test case with run id and status.
	}
	
	
	// Following methods are not required for Se-ALM Integration as of now.
	// ********************************************************************
	/**
	 * 
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	/**
	 * 	
	 */
	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	/**
	 * 
	 */
	@Override
	public void onStart(ITestContext context) {
		
	}	
	
	/**
	 * 
	 */
	@Override
 	public void onTestStart(ITestResult result) {
		
	}
	//*******************************************************************
}
