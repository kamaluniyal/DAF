package com.markit.DigitalAutomationFramework.test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.DigitalAutomationFramework.common.DataReader;
import com.markit.DigitalAutomationFramework.common.TestClass;
import com.markit.DigitalAutomationFramework.page.FundDetails;
import com.markit.DigitalAutomationFramework.page.ProductPage;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.SendMail;

/*
*
* @author: Sunny Jain	
* @purpose: this is a sample Page Test class
* @creation date: 8/6/2016
*
*/

public class FundDetails_Test extends ProductTestClass {

	PropertyReader prop;
	GlobalDriver gDriver;
	FundDetails fd;
	ProductPage pp;
	String loggedUser;
	SendMail mailObj;

	@BeforeMethod
	@Parameters({ "browser", "version", "Sel_Grid", "environment" })
	public void initialSetup(@Optional String browser, @Optional String version, @Optional String Sel_Grid,
			@Optional String environment) throws Exception {

		// pp = setupEnvironment(browser, version, Sel_Grid,environment);
		pp = setupEnvironment(browser, version, Sel_Grid, environment);
		fd = new FundDetails(driver);

	}

	@Test
	public void test1() {

		Assert.assertEquals(fd.getReturnLinktext(), "RETURNS");

		fd.clickHoldings();

	}

	@AfterMethod

	public void quit() throws AddressException, MessagingException {
		mailObj=new SendMail();
		mailObj.addSubject("Automated Test Mail");
	//	mailObj.addMessage("<html>This is \"test\" : mail</html>");
		StringBuilder s = mailObj.composeHtmlMessage();
		//mailObj.addMessage(s.toString());
		mailObj.addBodyAndAttachment(s.toString(),"input-data//TestData.xls");
		System.out.println(s);		
		mailObj.setAddress(RecipientType.TO,"sunny.jain@markit.com");
		mailObj.sendAction(); 

		driver.quit();
	}

}
