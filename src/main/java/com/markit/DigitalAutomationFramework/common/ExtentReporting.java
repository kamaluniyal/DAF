package com.markit.DigitalAutomationFramework.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporting {
	
	public  static ExtentReports extent;
	public  ExtentTest test;
	
	static String fileName;
	
	public  static ExtentReports getInstance(){
		
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yy_HH_mm_ss");
		Date date = new Date();
		//String date1= dateFormat.format(date);
		String datetime= dateFormat.format(date);
		
		//fileName ="./ExtentReports/report_" + date1 + ".html";
		
		
		String Client = PropertyReader.getFieldValue("Client");
		String ProjectName = PropertyReader.getFieldValue("Project");
		//fileName ="./ExtentReports/"+datetime+"_"+Client+"_"+ProjectName+".html";
		
		fileName =datetime+"_"+Client+"_"+ProjectName+".html";
		
		extent = new ExtentReports(fileName,false);	
		return extent;
	}
	
	public  ExtentTest startTest(String strTestName,  String strTestDescription){
		
		test = extent.startTest( strTestName , strTestDescription);	
		return test;
		
	}
	
	public  void endTest(ExtentTest test){
		extent.endTest(test);
	}
	
	public  void enterLog(String logStatus,String logDescription){
	    switch(logStatus.toUpperCase()){
		
		case "PASS":
			 test.log(LogStatus.PASS,logDescription);
			 break;
		case "FAIL":
			 test.log(LogStatus.FAIL,logDescription);
			 break;
		case "INFO":
			 test.log(LogStatus.INFO,logDescription);
			 break;
		}
	}
	
		
public  void exportReport()
	{	
		try
		{
			String Client 		= PropertyReader.getFieldValue("Client");
			String ProjectName  = PropertyReader.getFieldValue("Project");
			String ParentFolder = PropertyReader.getFieldValue("NetworkRootFolder");
			
			File dir = new File(ParentFolder+"//"+Client+"//"+ProjectName+"//");
			dir.mkdirs();
			File srcFile = new File(ExtentReporting.fileName);
			File destFile = new File(dir.getAbsolutePath()+"\\"+ExtentReporting.fileName);
			FileUtils.moveFile(srcFile, destFile);
		}
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
		
		catch(NullPointerException e)
		{			
			e.printStackTrace();		
		}
		
	}
		
	
	public  void flushReport(){
		extent.flush();
	}

}
