package com.markit.DigitalAutomationFramework.common;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.xml.sax.InputSource;


/**This class contains methods to add various properties to an email and send it. 
 * 
 * @author priyesh.tuli
 */
public class SendMail
{
	Logging log =new Logging(this.getClass().getSimpleName());

	MimeMessage message;
	String messagetxt;
	BodyPart messageBodyPart ,messageAttachment;
	Multipart multipart ;
	DataSource source;
	List <ArrayList<String>> tests;


	/**CONSTRUCTOR:
	 * Creates properties object and session for mime message
	 * 
	 */
	public SendMail()
	{
		Properties property = new Properties();

		//set host name from properties file.
		property.setProperty("mail.smtp.host",PropertyReader.getFieldValue("EmailHost"));

		Session session = Session.getDefaultInstance(property);		//creating session

		// Create a default MimeMessage object.
		message = new MimeMessage(session);					//adding session
	}

	/**
	 * Binds all required values like recipients, sender, subject and message content, to send an email and sends the mail
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public void sendAction() throws AddressException, MessagingException
	{     
		// Set From: header field of the header.
		senderAddress();

		// Send message
		Transport.send(message);

		//adding successful message send status to log
		log.info("Sent message successfully....");


	}

	/**
	 * gets sender's address based on machine from where execution has of test suit has been triggered.
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	private void senderAddress() throws AddressException, MessagingException
	{
		String senderAddress= System.getProperty("user.name")+PropertyReader.getFieldValue("EmailDomain");	//"@markit.com"	
		message.setFrom(new InternetAddress(senderAddress));
	}

	/**Adds recipients as type of TO, CC and BCC.
	 * 
	 * @param category
	 * @param addresses
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void setAddress(RecipientType category,String...  addresses) throws AddressException, MessagingException
	{
		ArrayList<String> recipients= parseAddress(addresses);

		for(String address:recipients)
			message.addRecipient(category, new InternetAddress(address));

	}

	/**parse multiple arguments into a single arraylist of string.
	 * 
	 * 
	 * @param addresses
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public ArrayList<String> parseAddress(String... addresses) throws AddressException, MessagingException
	{
		int numberofArgs=0;
		ArrayList<String> addressList=new ArrayList<String>();

		//counting number arguments supplied by user.
		numberofArgs=addresses.length;

		if(numberofArgs==1)									// expecting comma separated values
		{
			String[] r=addresses;
			if(r[0].contains(","))							//if comma is present in argument
			{
				String recievers=r[0], address;

				int lastComma=recievers.lastIndexOf(","); 	//position of last comma
				int numberOfEmails;

				if((lastComma)==(recievers.length()-1))		//to check if last email is void
					recievers=recievers.substring(0, lastComma);		//trim last comma

				numberOfEmails=recievers.length()-(r[0].replace(",","")).length() + 1 ;	//number of commas +1 = number of emails			   

				for( int i=0; i<numberOfEmails; i++ )
				{
					//if there is no comma left in string, it is expected that only one address is left.
					if(recievers.contains(",")==false)
					{
						addressList.add(recievers);

					}
					else	//two or more addresses available in string.
					{
						address=recievers.substring(0,recievers.indexOf(","));
						addressList.add(address);

						recievers=recievers.substring(recievers.indexOf(",")+1, recievers.length());
					}
				}		//end for loop
			}		//end inner if
			else
			{ 	
				if(addresses[0].length()>1)
				{
					addressList.add(addresses[0]);
					//message.addRecipient(category, new InternetAddress(addresses[0]));
				}

			}
		}		//end outer if
		else
		{
			if(addresses.length>0)			//if at least one argument has been added expecting that no comma is present argument value
			{
				for(String address:addresses)
				{
					addressList.add(address);
					// message.addRecipient(category, new InternetAddress(address));		//adding address to receivers list 
				}
			}
		}
		return addressList;
	}

	/**Returns all addresses.
	 * 
	 * @param type	The RecipientType required
	 * 
	 * @return ArrayList of email addresses for the specified recipient type
	 * @throws MessagingException
	 */
	public ArrayList<String> getAddresses(RecipientType type) throws MessagingException    
	{
		InternetAddress addressType;				
		Address[] recipients=   message.getRecipients(type);
		ArrayList<String> address=new ArrayList<String>();

		for(int i=0;i<recipients.length; i++)
		{
			addressType=(InternetAddress)recipients[i];		//casting recipient Address into InternetAddress

			address.add((String)addressType.getAddress());	//casting InternetAddress into String and adding to ArrayList

		}

		return address;
	}

	/**Adds string message text of mail to be sent.
	 * 
	 * @param msg String message text 
	 * @throws MessagingException 
	 */
	public void addMessage(String msg) throws MessagingException
	{

		message.setContent(msg, "text/html");    
	}

	/**Returns message content.
	 * 
	 * @return The message content
	 * @throws IOException
	 * @throws MessagingException
	 */
	public String getMessageContent() throws IOException, MessagingException
	{
		return (String) message.getContent();
	}

	/**Adds subject of mail.
	 * 
	 * @param sub
	 * @throws MessagingException
	 */
	public void addSubject(String sub) throws MessagingException
	{
		message.setSubject(sub);							//adding subject of mail
	}
	/* 
	 * Added by Rahul
	 * 
	 * */
	public void addBodyAndAttachment(String msg,String filename) throws MessagingException
	{

		multipart = new MimeMultipart();

		messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(msg, "text/html");
		multipart.addBodyPart(messageBodyPart);

		messageAttachment = new MimeBodyPart();
		source = new FileDataSource(filename);
		messageAttachment.setDataHandler(new DataHandler(source));
		messageAttachment.setFileName(filename);
		multipart.addBodyPart(messageAttachment);
		message.setContent(multipart );
	}
	/* 
	 * Added by Rahul
	 * 
	 * */
	public StringBuilder composeHtmlMessage() throws MessagingException
	{
		readExecutionStatus();
		StringBuilder email = new StringBuilder();
		email.append("Please find attached the detailed execution status in the excel sheet."+"\n"+"\n");
		email.append("<html><body>");
		email.append("<h1 style=\"text-align:center\">Execution Report</h1>");
		email.append("<table style=\"width:100%\" border=\"2\" bordercolor=\"black\" bgcolor=\"green\" border-width: 1px>");
		email.append("<tr><TH>Test Name</TH><TH>Status</TH><TH>Timestamp</TH><TH>Remarks</TH></tr>");


		for (ArrayList<String> testDetail  : tests) 
		{
			email.append("<tr>");
			for (String s: testDetail)
			{
				email.append("<td>"+s+"</td>");			
			}
			email.append("</tr>");
		}
		email.append("</table></body></html>");
		return email;
	}

	/* 
	 * Added by Rahul
	 * 
	 * */
	public void readExecutionStatus()
	{
		HSSFWorkbook xlWBook;
		HSSFSheet xlSheet;
		HSSFRow excelRow;
		HSSFCell excelCell;
		ArrayList <String> testDetails;
		try 
		{

			FileInputStream xlFile = new FileInputStream("input-data//TestData.xls");

			// Access the required test data sheet

			xlWBook = new HSSFWorkbook(xlFile);

			// Assuming your data is in Sheet1- if not use your own sheet name
			xlSheet = xlWBook.getSheet("TestDetails");

			// gives row count in sheet
			int noOfRows = xlSheet.getPhysicalNumberOfRows();

			// gives column count in sheet
			excelRow = xlSheet.getRow(0);
			int noOfColumns = excelRow.getLastCellNum();
			tests=new ArrayList<ArrayList<String>>();
			for (int r = 1; r < noOfRows; r++) 
			{
				testDetails = new ArrayList<String>();

				for (int c = 0; c < noOfColumns; c++) 
				{
					excelRow = xlSheet.getRow(r);
					excelCell = excelRow.getCell(c);

					// Here we have complete excel data in an array -excelData-

					if(excelCell!=null&&(c==2||c==6||c==7||c==8)) 
					{
						excelCell.setCellType ( Cell.CELL_TYPE_STRING );
						testDetails.add(excelCell.getStringCellValue());
					}

				}
				tests.add(testDetails);
			}

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}



	/**Returns subject of message
	 * 
	 * @return the subject of the email
	 * @throws MessagingException
	 */
	public String getSubject() throws MessagingException
	{
		return message.getSubject();
	}
}
