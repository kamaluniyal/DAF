package com.markit.DigitalAutomationFramework.common;

import com.relevantcodes.extentreports.ExtentReports;
import com.markit.DigitalAutomationFramework.common.*;

import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.markit.DigitalAutomationFramework.common.ExtentReporting;

// Add following listener in testng.xml to generate this report
// <listener class-name="com.markit.infoqa.seleniumframework.utilities.BaseHTMLReporter" />
// The report would be generated in target folder of project
/**The class's methods are called after test execution has been completed.
 * It compiles the information regarding the test suite's execution.
 * Prints information about passed, failed and skipped tests and mail the same to requested addresses.
 *
 */

public class BaseHTMLReporter implements IReporter,ITestListener 
{
	SendMail mail = new SendMail();
	ExtentReporting report = new ExtentReporting();
	
	/**
	 * subject of mail
	 */
	String messageSub;

	//text to be sent for mailing
	String messageText;

	ArrayList<String> passedtestCasesDetails=new ArrayList<String>();
	ArrayList<String> skippedtestCasesDetails=new ArrayList<String>();
	ArrayList<String> failedtestCasesDetails=new ArrayList<String>();
	int testnumb=0;
	static 	String passedCases="", 			failedCases="", 		skippedCases="";


	/**
	 * @param reportTitle
	 */
	private void createReport(String reportTitle){
		messageText="<title>"
				+reportTitle
				+"</title>"
				+'\n';
	}
	

	/**
	 * @param text to be displayed 
	 */
	private void addLine(String txt){
		messageText=messageText+"<b>"+txt+"</b><br>";
	}

	/**
	 * creates a table
	 * @param caption
	 */
	private void addTable(String caption){
		messageText=messageText+"<table border=\"1\" style=\"width:100%\" bgcolor=\"#FFFFFF\" >"+'\n';	//table created
		messageText=messageText+"<caption> <b>"+caption+"</b></caption>"+'\n';		//caption to table
	}


	/**
	 * add row with requested colour
	 * @param colour
	 */
	private void addRow(String colour){
		messageText=messageText+"<tr bgcolor=\""+colour+"\">";

	}

	/**
	 * adds a row to table
	 */
	private void addRow(){
		messageText=messageText+"<tr>";
	}


	/**
	 * add data to row
	 * @param value
	 */
	private void addRowData(String value){
		messageText=messageText+"<td> "+value;
	}


	/**
	 * add data to row (specific for time duration)
	 * @param value
	 */
	private void addRowData(long value){
		messageText=messageText+"<td>"+value+"sec";
	}


	/**
	 * close row
	 */
	private void closeRow(){
		messageText=messageText+"</tr>";
	}


	/**
	 * closes table
	 */
	private void closeTable(){
		messageText=messageText+"</table> <br>";
	}

	/**
	 * @see org.testng.IReporter#generateReport(java.util.List, java.util.List, java.lang.String)
	 */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectoryName)
	{
		Logging Log = new Logging(this.getClass().getName());
		//System.out.println("Inside generate report");
		try 
		{
			PropertyReader.ValueMap("Configuration.properties");

			String env = PropertyReader.getFieldValue("defaultEnvironment");

			if(PropertyReader.getFieldValue("EmailEnable").equalsIgnoreCase("true"))
			{

				Log.info("Creating Email Report");

				ArrayList<HashMap<String, Serializable>> suiteList = new ArrayList<HashMap<String, Serializable>>();
				ArrayList<HashMap<String, String>> testList = new ArrayList<HashMap<String, String>>();

				int spass, sskip, sfail;
				int tpass, tskip, tfail;
				double spassrate , tpassrate;
				long tduration=0;
				String colour=null;
				DecimalFormat df = new DecimalFormat("0.00");

				HashMap<String, Serializable> smap ;
				HashMap<String, String> tmap;

				spass = sskip = sfail = 0;
				tpass = tskip = tfail = 0;

				createReport("Test Execution Report");		//title of report
				addLine("Host : "+System.getenv("COMPUTERNAME"));
				addLine("Operating System : "+System.getProperty("os.name"));
				
				for (ISuite suite : suites) {
					
					String suiteName = suite.getName();	
					//System.out.println(suiteName);
					
					messageSub="Test execution report of "+suite.getName() + " on "+ env+ " environment.";

					
					for (ISuiteResult sr : suite.getResults().values()) 
					{						
						//System.out.println(testnumb);
						
						ITestContext tc = sr.getTestContext();
						//System.out.println(tc.toString());
						addTable("Test Suite Name : " +tc.getName());		//adding new table with browser name


						long duration = (tc.getEndDate().getTime() - tc.getStartDate().getTime()) / 1000 ;
						Log.info("Duration for test '" + tc.getName() +
								"' is:" + duration);


						//Passed test cases
						tpass = tc.getPassedTests().getAllResults().size();
						Log.info("Passed cases for test '" + tc.getName() +
								"' is:" + tpass);

						//FAILED TESTS
						tfail = tc.getFailedTests().getAllResults().size(); 
						Log.info("Failed cases for test '" + tc.getName() +
								"' is:" + tfail);

						//skipped cases
						tskip = tc.getSkippedTests().getAllResults().size();
						Log.info("Skipped cases for test '" + tc.getName() +
								"' is:" + tskip);

						tpassrate = ((double)tpass / (double)(tpass + tfail + tskip)) * 100;
						Log.info("Pass Rate for test '" + tc.getName() +
								"' is:" + tpassrate);

						spass += tpass;
						sfail += tfail;
						sskip += tskip;
						tduration+=duration;


						if(tpass>0)
							colour="#90EE90";							//green
						else
							colour=null;

						addRow(colour);									//green colour for row of passed
						addRowData("Passed Tests:");
						//addRowData("Passed Tests:"	+'\n'+passedtestCasesDetails.get(testnumb));
						addRowData(Integer.toString(tpass));			//adding passed value to row
						closeRow();


						if(sskip>0)
							colour="#FFA500";							//orange
						else
							colour=null;
						addRow(colour);												//orange colour for row of skipped
						addRowData("Skipped Tests:"+'\n'+skippedtestCasesDetails.get(testnumb));	// getSkipped(browserUnderExec));
						addRowData(Integer.toString(tskip));						//adding skipped value to row	        
						closeRow();


						if(tfail>0)
							colour="#CD5C5C";							//red
						else
							colour=null; 
						addRow(colour);									//red colour for row of failed
						addRowData("Failed Tests:"+'\n'+failedtestCasesDetails.get(testnumb));
						addRowData(Integer.toString(tfail));			//adding failed value to row
						closeRow();	


						addRow();											//no colour for row of total
						addRowData("Total Tests");
						addRowData(Integer.toString(tskip+tfail+tpass));	//adding skipped value to row


						addRow();											//no colour for row of total
						addRowData("Total Duration");
						addRowData(duration);								//adding duration 
						closeRow();

						closeTable();

						tmap = new HashMap<String, String>();
						tmap.put("name", tc.getName());
						tmap.put("duration", Long.toString(duration));
						tmap.put("passCount", Integer.toString(tpass));
						tmap.put("failCount", Integer.toString(tfail));
						tmap.put("skipCount", Integer.toString(tskip));
						tmap.put("passRate", df.format(tpassrate));

						testList.add(tmap);

						testnumb++;
					}



					spassrate = ((double)spass / (double)(spass + sfail + sskip)) * 100;

					smap = new HashMap<String, Serializable>();
					smap.put("name", suiteName);
					smap.put("passCount", Integer.toString(spass));
					smap.put("failCount", Integer.toString(sfail));
					smap.put("skipCount", Integer.toString(sskip));
					smap.put("passRate", Integer.toString(sskip));
					smap.put("testList", testList);


					suiteList.add(smap);
//					if case added by rahul to print the overall status only at the end of all suites
					
					if(suites.get(suites.size()-1).getName().equalsIgnoreCase(suiteName))
					{
					addTable("Overall Status");						//adding new table with suite name

					if(spass>0)
						colour="#90EE90";							//green
					else
						colour=null;

					addRow(colour);						
					addRowData("Passed Tests");
					addRowData(Integer.toString(spass));		//adding passed value to row
					closeRow();

					if(sskip>0)
						colour="#FFA500";						//orange
					else
						colour=null;
					addRow(colour);							
					addRowData("Skipped Tests");
					addRowData(Integer.toString(sskip));		//adding skipped value to row
					closeRow();


					if(sfail>0)
						colour="#CD5C5C";						//red
					else
						colour=null;
					addRow(colour);							
					addRowData("Failed Tests");
					addRowData(Integer.toString(sfail));		//adding failed value to row
					closeRow();


					addRow();							
					addRowData("Total Tests");
					addRowData(Integer.toString(spass+sskip+sfail));	//adding passed value to row
					closeRow();


					addRow();							
					addRowData("Total Duration");
					addRowData(tduration);		//adding passed value to row
					closeRow();

					closeTable();
					Log.info("Total Pass cases for suite '" + suiteName +
							"' is:" + spass);

					Log.info("Total Fail cases for suite '" + suiteName +
							"' is:" + sfail);

					Log.info("Total Skip cases for suite '" + suiteName +
							"' is:" + sskip);

					Log.info("Total Pass Rate for suite '" + suiteName +
							"' is:" + spassrate);
					}
				}

				//Create and send mail
				String mailRecipients = PropertyReader.getFieldValue("Email_TO");
				//String mailCC = PropertyReader.getFieldValue("Email_CC");
				//String mailBCC = PropertyReader.getFieldValue("Email_BCC");

				mail.addSubject(messageSub);				//adding subject of mail
				mail.setAddress(RecipientType.TO, mailRecipients);	//adding recipients	
				//mail.setAddress(RecipientType.CC,mailCC);		//adding cc
				//mail.setAddress(RecipientType.BCC,mailBCC);	//adding bcc
				//mail.addMessage();				//adding text of message
				mail.addSubject(messageSub);
				
				mail.addBodyAndAttachment(messageText, ExtentReporting.fileName);//adding text of message and attachment
				//adding subject of mail
				mail.sendAction();							//send mail

				Log.info("Mail sent to : " + mailRecipients );
				//Log.info("Mail CC to : " + mailCC );
				//Log.info("Mail BCC to : " + mailBCC );
			}
			
			// Added functionality of saving report to network path mentioned in config file based on flag SaveReportToNetwork
			if(PropertyReader.getFieldValue("SaveReportToNetwork").equalsIgnoreCase("true"))
			{
				//saving file to network location .
				report.exportReport();
			}
			
		}
		catch (Exception e){
			Log.error(e.getMessage());
		}
	}

	/**
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {	
	}

	/**populates passed test's string
	 * 
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		passedCases=passedCases+"<br><I>"+getTestMethodName(result)+'\n';
	}

	/**populates failed test's string
	 * 
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult result){
		failedCases=failedCases+"<br><I>"+getTestMethodName(result)+'\n';
	}

	/**populates skipped test's string
	 * 
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult result){
		skippedCases=skippedCases+"<br><I>"+getTestMethodName(result)+'\n';
	}

	/**
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result){
	}

	/**cleans all test status.
	 * 
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext context){
		passedCases="";
		failedCases="";
		skippedCases="";
	}

	/**
	 * saves all tests' status to browser specific string variable which can be retrieved later.
	 * 
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext context){
		failedtestCasesDetails.add(failedCases);
		passedtestCasesDetails.add(passedCases);
		skippedtestCasesDetails.add(skippedCases);
	}

	/**Returns name of test method.
	 * 
	 * @param result - result variable for test.
	 * @return	- test method name
	 */
	public String getTestMethodName(ITestResult result){
		return result.getMethod().getConstructorOrMethod().getName();
	}

	/**Returns all passed test cases
	 * 
	 * @return - tests cases which passed.
	 */
	public String getPassed(){
		return passedCases;
	}

	/**Returns names of test cases which failed.
	 * 
	 * @return -  test cases which failed.
	 */
	public String getFailed(){
		return failedCases;
	}

	/**Returns names of test cases which skipped
	 * 
	 * @return - Test cases' names
	 */
	public String getSkipped(){
		return skippedCases;
	}

	/**Returns the full string containing the contents of the email message
	 * 
	 * @return - Email content
	 */
	public String getMessageText() {
		return messageText;
	}

}

