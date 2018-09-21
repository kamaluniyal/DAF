package com.markit.DigitalAutomationFramework.common;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Reporter;

/**
 * Standardised logging class making use of the log4j library
 * 
 * @author stuart.rogers
 * @version 1.0
 * @since 2015-07-27
 * 
 */
public class Logging {

	// Initialize Log4j logs
	/**
	 * 
	 */
	Logger Log;

	/**
	 * 
	 * @param LogName
	 */
	public Logging(String LogName) {

		Log = Logger.getLogger(LogName);
		DOMConfigurator.configure("log4j.xml");
	}

	/**
	 * This is to print log for the beginning of the test case, as we usually
	 * run so many test cases as a test suite
	 * 
	 * @param sTestCaseName
	 *            String containing the name of the test case that has just
	 *            started
	 */
	public void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$   " + sTestCaseName
				+ "   $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Reporter.log("| TEST STARTED | ");

	}

	/**
	 * This is to print log for the ending of the test case
	 * 
	 * @param sTestCaseName
	 *            String containing the name of the test case that has completed
	 */
	public void endTestCase(String sTestCaseName) {

		
		Log.info("X");
	
		Log.info("X");
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " +"END--OF-- "
				+ sTestCaseName +"      XXXXXXXXXXXXXXXXXXXXXX");
	

		Reporter.log("| TEST ENDED | ");

	}

	/**
	 * Logs that information level and also adds the supplied message to the
	 * testNG reporter log
	 * 
	 * @param message
	 *            - A String containing the message to add to the logs
	 */
	public void info(String message) {
		Log.info(message);
		Reporter.log("| " + message + "| ");
	}

	/**
	 * Logs at the warning level
	 * 
	 * @param message
	 *            - A String containing the message to add to the logs
	 */
	public void warn(String message) {
		Log.warn(message);
	}

	/**
	 * Logs at the error level
	 * 
	 * @param message
	 *            - A String containing the message to add to the logs
	 */
	public void error(String message) 
	{
		Log.error(message);

	}

	/**
	 * Logs at the fatal level
	 * 
	 * @param message
	 *            - A String containing the message to add to the logs
	 */
	public void fatal(String message) {
		
		Log.fatal(message);

	}

	/**
	 * Logs at the debug level
	 * 
	 * @param message
	 *            - A String containing the message to add to the logs
	 */
	public void debug(String message) {
		
		Log.debug(message);

	}

	/**
	 * Logs at the trace level
	 * 
	 * @param message
	 *            - A String containing the message to add to the logs
	 */
	public void trace(String message) {
		Log.trace(message);

	}

	public Logger getLog() {
		return Log;
	}


}