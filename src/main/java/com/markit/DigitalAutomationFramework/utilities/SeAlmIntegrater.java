package com.markit.DigitalAutomationFramework.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.http.client.ClientProtocolException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.markit.DigitalAutomationFramework.common.Logging;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.utilities.*;

/** Class is developed to integrate ALM and Selenium Framework.
 *  It has methods for user authentication, collection of attributes and their corresponding values 
 *  belonging to an entity from test instances.
 *  Class has methods to register result back into ALM for every test method by creating run entity 
 *  for every test method by mapping test methods and test cases between test Selenium and ALM.
 * 
 * @author priyesh.tuli
 *
 */

public class SeAlmIntegrater {
	
	/**For utilising HTTP methods */
	static HTTPOperations httpRequest;
	
	/**For xml parsing and accessing nodes in xml for test instances in ALM
	 */
	private XMLParser xml;
	
	/**For xml parsing and accessing nodes in xml for test configs in ALM*/
	private XMLParser xmlConfig;
	
	/**Used for logging. */
	Logging log=new Logging(this.getClass().getSimpleName());
	
	/**Used for locating xls file. */
	private FileInputStream file;
	
	/**Used for locating workbook. */
	private HSSFWorkbook workbook;
	
	/**Used for locating sheet. */
	private HSSFSheet sheet;
	
	/**Test id of test case in ALM */
	private String testId;
	
	/**Test-set id from test set in ALM */
	private String cycleId;
	
	/**Test instance id, retrieved from REST API of ALM. */
	private String testCycleId;
	
	/**Test configuration id. */
	private String configId;
	
	/**Run-id from ALM. */
	private String runId;
	
	/**Browser value retrieved from test configuration. */
	private String browserValue;
	
	/**Used in conditions.
	 * If mapping is true, request will be sent further to get ids.
	 * 
	 */
	private boolean mapping=true;
	
	/**Value of browser retrieved from testNG. */
	private String browser;
	
	/**Internal name of alm configuration for browser field that to be used in browser configuration.
	 * 
	 */
	private String browserField;
	
	/**
	 * Used in conditions to check if browser configuration is valid or not.
	 */
	private boolean browserConfigValid;
	
	/**Owner of test. */
	private String owner;
	
	/**Test status of test case, depends on execution of test case. */
	private String testStatus;
	
	/**User name who executed the test case. */
	private String tester;
	
	/**Payload required to register response in ALM. Payload is mandatory to be of xml type. */
	private String xmlPayload;
	
	/**Updated xml payload, used for updating test status.
	 * 
	 */
	private String updatedXmlPayload;
	
	/**Input source equivalent of xml response of ALM for Test Instance. */
	private InputSource inputSource;
	
	/**Input source equivalent of xml response of ALM for Test Configuration. */
	private InputSource inpSConfig; 
	
	/**Url for test configuration (test configuration). */
	private String urlConfigs;
	
	/**Url for test-instances */
	private String urlTestInstances;
	
	/**Domain */
	private String domain;
	
	/**Project */
	private String project;
	
	/**Row number for locating row to enter values in xls */
	private int rowNum;
	
	/**Name of sheet in xls file containing test details for mapping*/ 
	private String sheetName="TestDetails";
	
	/**List of nodes for children nodes of Entity */
	private List<Node> entitiesChildren;
	
	/**
	 * Used in xml parsing.
	 */
	private Node fields;
	
	/**Constructor
	 * 
	 * @param domain : name of domain of project in ALM. 
	 * @param project : name of project in ALM.
	 * 
	 * @throws IOException
	 */
	public SeAlmIntegrater(String domain, String project) throws IOException {
		
		httpRequest=new HTTPOperations();
		
		this.domain=domain;		//	Storing domain name
		this.project=project;	//	Storing project name
	}

	/**Returns object of handleHTTPrequests class.
	 * 
	 * @return Return object of type HandleHttpRequest
	 */
	public  HTTPOperations getHttpRequest() {
		return httpRequest;
	}

	/**Set value of object of handleHTTPRequests
	 * 
	 * @param httpRequest
	 */
	public void setHttpRequest(HTTPOperations httpRequest) {
		SeAlmIntegrater.httpRequest = httpRequest;
	}
	
	/**Authenticates users on authentication link using login credentials.
	 * 
	 * @param url
	 * @param payload
	 * @return Returns server response code. Returned value 200 means user authentication successful,
	 * 			while 401 means authentication has failed.
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int authenticateUsers() throws ClientProtocolException, IOException {
		
		String username="";
		String password="";
		
		if( getUsername()!=null && !(getUsername().isEmpty()) ) {				//if user's login credentials are available
			username=getUsername();			// use login credentials only
			
			if(getPassword()!=null && !(getPassword().isEmpty()) )				//read password field.
				password=getPassword();											//read password from config file.
				
		}
		else {
			// else use default user credentials.
			username="seluser";
			password="Welcome123";
		}
		
		String payloadUserCredentials="<alm-authentication><user>"+username+"</user><password>"+password+"</password></alm-authentication>";
		
		//authentication link
		String auth_url="http://alm.markit.partners/qcbin/authentication-point/alm-authenticate";
		
		return httpRequest.handlePOST(payloadUserCredentials,"application/xml", auth_url);
	}
	
	
	/**
	 * 
	 * @return Returns a username
	 */
	private String getUsername() {
		return PropertyReader.getFieldValue("ALM_Username");
	}
	
	
	/**
	 * 
	 * @return returns password
	 */
	private String getPassword() {
		return PropertyReader.getFieldValue("ALM_Password");
	}
	
	/**Get browser configuration field for project.
	 * Also validates if configuration available or not.
	 * 
	 */
	public void getBrowserConfig() {
		browserConfigValid=true;				//assuming browser configuration is available for project under test.

		String configFieldsUrl="http://alm.markit.partners/qcbin/rest/domains/"+domain+"/projects/"+project+"/customization/entities/test-config/fields";
		try {
			
			if(httpRequest.handleGET(configFieldsUrl)==200) {		//config fields are accessible
				xmlConfig=new XMLParser(httpRequest.inputsource);	//parse configs xml response
				if(xmlConfig.getNode("Field", "Label", "Browser")!=null) {	//if browser field is available in configuration
					browserField = xmlConfig.getAttributeValue(xmlConfig.getNode("Field", "Label", "Browser"), "Field", "Name");	//get label value for browser field
					log.info(browserField+" INTERNAL CONFIG NAME from ALM.");
				}
				else
					browserConfigValid=false;		//else declare browser configuration validity invalid
			}
		}
		catch (ClientProtocolException clientProtoExp) {
			log.info("ERROR: "+clientProtoExp.toString());
		}
		catch (IOException ioExp) {
			log.info("ERROR: "+ioExp.toString());
		}
		catch(SAXException SAXExp) {
			log.info("ERROR: "+SAXExp.toString());
		}
	}
	
	/**Returns response code for authentication request
	 * 
	 * @return response code for request made to ALM.
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int isAuth() throws ClientProtocolException, IOException {
		
		String url_isAuth = "http://alm.markit.partners/qcbin/rest/is-authenticated";
		
		//respose code
		int resp = httpRequest.handleGET(url_isAuth);
		
		return resp;
	}

	/**Logs out user.
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public void logoutUsers() throws ClientProtocolException, IOException {
		
		String url_Logout = "http://alm.markit.partners/qcbin/authentication-point/logout";
		httpRequest.handleGET(url_Logout);					//performs logout
	}

	/**Collect values from xls file and use it to extract information from TestInstances in ALM.
	  * 
	  * @param testMethodName : Name of test method.
	  * @param className : Name of class containing test method.
	  * @param browser : Name of browser against which execution has been requested.
	  */
	public void mapWithALM(String testMethodName, String className,String browser) {
		
		//saving browser name
		this.browser=browser;
		
		//Set test id and test set id by reading from xls file.
		//Following method maps test class name and test method name to test id and test set id.
		setTestandTestSetId(testMethodName, className);
		log.info("Test Id and Test-Set Id mapped.");			//adding to log file
	}

	/**Set test id and test set id. 
	 * 
	 * @param testName : Name of the test method
	 * @param className : Name of test class.
	 * 
	 * @throws IOException
	 */
	private void setTestandTestSetId(String testName, String className) {
		
		//Locating xls file
		try {
			file = new FileInputStream(new File(System.getProperty("user.dir") + "/"+PropertyReader.getFieldValue("testDataFilePath")));
		} 
		catch (FileNotFoundException fnfExp) {		
			log.info(fnfExp.toString());
		}		
		
		//Locate workbook
		try {
			workbook = new HSSFWorkbook(file);
		} 
		catch (IOException IOExp) {
			
			log.info(IOExp.toString());
		}
		
		//Get workbook's sheet
		sheet = workbook.getSheet(sheetName);							
		
		//Getting last populated row
		int last_row  = sheet.getLastRowNum();								
		
		//Row 1 holds first values of for mapping. Row 0 is used for headings of columns.
		int rowNumber=1;
		
		while(!(rowNumber>last_row)) {
			
			/*
			 * Cell 2 is for Test Name in xls file.
			 * Cell 3 is for Test Class in xls file.
			 *
			 * if pair of class name and test method name matches correctly return row number to locate/insert other values in xls. 
			*/
			if((sheet.getRow(rowNumber).getCell(2).getStringCellValue().equals(testName)) && (sheet.getRow(rowNumber).getCell(3).getStringCellValue().equals(className)) ) {
				break;
			}
			rowNumber++;
		}

		if(rowNumber==last_row+1) {
			rowNumber=-1;
			log.info("Mapping failed. Test method and test class combination could not be found in xls.");
		}
		
		if( sheet.getRow(rowNumber)!=null) {
			
			sheet.getRow(rowNumber).getCell(0).setCellType(Cell.CELL_TYPE_STRING);	//setting cell type as string
			testId = sheet.getRow(rowNumber).getCell(0).getStringCellValue();		//getting test id from column 0.
			
			sheet.getRow(rowNumber).getCell(1).setCellType(Cell.CELL_TYPE_STRING);	//setting cell type as string
			cycleId =sheet.getRow(rowNumber).getCell(1).getStringCellValue();		//getting test set id from column 1.
		
		}
		
		rowNum=rowNumber;															//keeping track of row number, used when storing details in xls.
		try {
			file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}															//close file
		
	}

	/**Sets input source for collecting information required to prepare payload.
	 * Request is made using GET method for test instance to REST API of ALM.
	 */
	public void setInputSource() {
		
		//Test instances link for specfic test case available in specific test set.
		
		urlTestInstances = "http://alm.markit.partners/qcbin/rest/domains/"+domain+"/projects/"+project+"/test-instances?query=%7Btest-id%5B" + testId + "%5D;cycle-id%5B" + cycleId + "%5D%7D";
		try {
			//Input source equivalent of xml response of GET request for test instances
			httpRequest.handleGET(urlTestInstances);
			inputSource=httpRequest.getInputSource();
		
			xml=new XMLParser(inputSource);				//passing input source to xml parser
		
			mapAttributes();							//map attributes from xml input source
		}
		catch(IOException ioEx) {
			mapping=false;
			log.info("ERROR: "+ioEx.toString());
		}
		catch(SAXException sax) {
			mapping=false;
			log.info("ERROR: "+sax.toString());
		}
		catch(XPathExpressionException xpathEx) {
			mapping=false;
			log.info("ERROR: "+xpathEx.toString());
		}
	}

	/**Extracts values from xml response from server. Extracted values are used to prepare payload for registering response in ALM.
	 * 
	 * @throws IOException 
	 * @throws XPathExpressionException 
	 * @throws SAXException 
	 */
	private void mapAttributes() throws IOException, XPathExpressionException, SAXException {
		
		//Getting child entity nodes of root node Entities
		entitiesChildren =xml.getChildren(xml.getNode("Entities", "TotalResults"));
		
		//looping through entities children
		for(Node n1:entitiesChildren) {
			// Getting Fields tag (Entity tag has only one child tag)
			fields=n1.getFirstChild();
			
			// Getting config id by locating child node of Fields based on attribute name and attribute value
			configId = xml.getNodeText(xml.getChildNode(fields,"Name", "test-config-id").getFirstChild(), xml.getChildNode(fields,"Name", "test-config-id").getFirstChild().getNodeName());	
			log.info("config id: "+configId);
			
			// Getting test configuration link for API. 
			urlConfigs="http://alm.markit.partners/qcbin/rest/domains/"+domain+"/projects/"+project+"/test-configs?query=%7Bid%5B" + configId + "%5D%7D";
			
			// Setting input source for test configuration.
			setInputSourceConfigs();
			
			if(browserConfigValid==true) {		//if browser configuration is available
				
				//getting browser value
				browserValue=xmlConfig.getNodeText(xmlConfig.getNode("Field", "Name", browserField), "Value");
				
				// Checking if browser value from testNG is null or empty.
				if(browser==null||browser.isEmpty()) {
					
					if(browserValue.isEmpty()||browserValue==null) {	//if browser value from ALM is also empty or null,

						//log result against empty configuration
						log.info("Correct configuration found");
						break;						
					}
				}
				else if(browserValue.equalsIgnoreCase(browser)) {	//comparing browser value from test and testNG.xml
						
						log.info("Correct configuration found");
						break;
				}													//end of else if
				
			}														//end of if
			else {													// if browserConfigValid is false 
				break;												// then break out of iteration 
			}
		}			//end of for
		
		testCycleId		 = getTestCycleId();				//Get test cycle id. (test instance) 
		owner			 = getTestOwner();					//Get owner of test case
		tester			 = getTester();						//Get name of tester
	}

	/**Set input source for test configuration.
	 * 
	 * @throws IOException
	 * @throws SAXException
	 */
	private void setInputSourceConfigs() throws IOException, SAXException {
		httpRequest.handleGET(urlConfigs);
		inpSConfig= httpRequest.getInputSource();	//getting input source of test config based in id.
		xmlConfig=new XMLParser(inpSConfig);		//xml parser object for test-configs
	}

	/**Returns current user name.
	 * 
	 * @return Name of the tester.
	 * @throws IOException
	 */
	private String getTester() throws IOException {
		tester= System.getProperty("user.name");			//getting tester name 
		return tester;
	}

	/**Returns value of test cycle id which is displayed as test instance id in ALM.
	 * 
	 * @return Returns test cycle id.
	 * @throws IOException 
	 */
 	private String getTestCycleId() throws IOException {
 		return xml.getNodeText(xml.getChildNode(fields,"Name", "id").getFirstChild(), xml.getChildNode(fields,"Name", "id").getFirstChild().getNodeName());
	}

	/**Return test owner.
	 * 
	 * @param test_id
	 * @return Returns owner of the test.
	 * @throws IOException 
	 */
	private String getTestOwner() throws IOException {
		return xml.getNodeText(xml.getChildNode(fields,"Name", "owner").getFirstChild(), xml.getChildNode(fields,"Name", "owner").getFirstChild().getNodeName());
	}

	
	/**Prepares payload for registering result.
	 * 
	 * @param methodName : Name of test method to be used as run name for ALM Runs.
	 * @param statusMsg : Status of test.
	 * @param duration : Duration of test execution.
	 */
	public void preparePOSTPayload(String methodName,String statusMsg, Long duration) {

		//Xml payload for registering test result back to 
		xmlPayload="<Entity Type=\"run\"><Fields>";
		
		//Adding run name as method name
		xmlPayload=xmlPayload +"<Field Name=\"name\"><Value>" + methodName + "</Value></Field>";
		
		//Adding test id
		xmlPayload=xmlPayload +"<Field Name=\"test-id\"><Value>" + testId + "</Value></Field>";
		
		//Adding test cycle id (test instance id)
		xmlPayload=xmlPayload +"<Field Name=\"testcycl-id\"><Value>" + testCycleId + "</Value></Field>";
		
		//Adding test configuration id
		xmlPayload=xmlPayload+"<Field Name=\"test-config-id\"><Value>" + configId + "</Value></Field>";
		
		//Adding test set id
		xmlPayload=xmlPayload+"<Field Name=\"cycle-id\"><Value>"+cycleId+"</Value></Field>";
		
		//Adding test_subtype id (fixed value)
		xmlPayload=xmlPayload +"<Field Name=\"subtype-id\"><Value>" + "hp.qc.run.MANUAL" + "</Value></Field>";
		
		//Adding test owner
		xmlPayload=xmlPayload +"<Field Name=\"owner\"><Value>" + owner + "</Value></Field>";
		
		//Adding operating system
		xmlPayload=xmlPayload +"<Field Name=\"os-name\"><Value>" + System.getProperty("os.name") + "</Value></Field>";
		
		//adding test duration
		xmlPayload=xmlPayload +"<Field Name=\"duration\"><Value>"+ duration +"</Value></Field>";
		//Adding comment
		xmlPayload=xmlPayload +"<Field Name=\"comments\"><Value>"+ statusMsg+'\n'+"Note: Duration of test cases is in milli seconds. \nRun from Automation Framework.\n" +"</Value></Field>";
		
		//Closing fields and entity
		xmlPayload=xmlPayload+"</Fields></Entity>";
		
		log.info("XML payload for registering result into ALM: "+xmlPayload);
	}

	/**Registers result in ALM runs section.
	 * 
	 * @return Run id of newly created run entity.
	 */
	public int registerResult() {
		
		int runID=-1;		//run id with default error value of -1

		String runsURL="http://alm.markit.partners/qcbin/rest/domains/"+domain+"/projects/"+project +"/runs"; //runs url in ALM.
		
		try{
			//Executing POST method to register run result
			httpRequest.handlePOST(xmlPayload, "application/xml", runsURL);
		
			xml=new XMLParser(httpRequest.inputsource);

			//Getting child tag (Fields) tag of Entity tag of xml response of POST request.
			Node fields=xml.getNode("Entity").getFirstChild();

			//getting run id
			runID= Integer.parseInt(xml.getNodeText(xml.getChildNode(fields,"Name", "id"), xml.getChildNode(fields,"Name", "id").getFirstChild().getNodeName()));
		}
		catch(ClientProtocolException clientProto){
			mapping=false;									//mapping failed.
			log.info("ERROR: "+clientProto.toString());
			runID=-1;
		}
		catch(IOException ioEx){
			mapping=false;									//mapping failed.
			log.info("ERROR: "+ioEx.toString());
			runID=-1;
		}
		catch(SAXException saxEx){
			mapping=false;									//mapping failed.
			log.info("ERROR: "+saxEx.toString());
			runID=-1;
		}
		catch(NumberFormatException numbEx){
			mapping=false;									//mapping failed.
			log.info("ERROR: "+numbEx.toString());
			runID=-1;
		}
		
		return runID;
	}

	/**Updates test status of newly created run entity.
	 * 
	 * @param	runID2 : Run id of newly created entity
	 * @param	status : Test status.
	
	 * @throws 	IOException
	 */
	public void updateTestStatus(Integer runID2, String status) {
		
		testStatus=status;				//saving test status
		
		runId= runID2.toString();
		try{
			//updates test status of newly created entity.
			updateStatus();

			//write test result details into xls file.
			writeXlsDetails();
		}
		catch(IOException ioEx) {
			//writting error statement in xls
			log.info("ERROR: "+ioEx.toString());
		}
	}
	
	
	/**Updates the test status for the run entity.
	 * 
	 * @return Return response code of operation performed.
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private int updateStatus() throws ClientProtocolException, IOException {
		
		//xml payload for updating test status
		updatedXmlPayload="<Entity Type=\"run\"><Fields><Field Name=\"status\"><Value>"+ testStatus +"</Value></Field></Fields></Entity>";
		String urlRuns="http://alm.markit.partners/qcbin/rest/domains/"+domain+"/projects/"+project+"/runs/"+runId;
		 
		//returns status code of put request. 
		return httpRequest.handlePUT(updatedXmlPayload,"application/xml",urlRuns);
		
	}
	
	
	/**Write test related details to xls file for every test.
	 * 
	 * @throws IOException
	 */
	private void writeXlsDetails() {
		
		boolean fileOp=true;
		Date date= new Date();
		
		List<String> details=new ArrayList<String>();
		
		details.add(0, owner);					//adding details to list
		details.add(1,tester);					
		details.add(2,testStatus);				
		details.add(3, date.toString());
		
		if(mapping==true) {
			
			details.add(4,"SUCCESSFUL");
			if(browserConfigValid==false) {
				details.add(4,"SUCCESSFUL.But browser configuration unavailable in ALM.");
			}
		}
		else
			details.add(4,"FAILED");
		
		// Locate file						// Reading location from config file 		
		try {
			file = new FileInputStream(new File(System.getProperty("user.dir") + "/" +PropertyReader.getFieldValue("testDataFilePath")));
		} 
		catch (FileNotFoundException e) {
			fileOp=false;
			log.info("Error with file location. Cannot update status.");
		}
		
		try {
			workbook = new HSSFWorkbook(file);									//locate workbook
		} 
		catch (IOException e) {
			fileOp=false;
			log.info("Error with workbook location. Cannot update status.");
		}										
		sheet = workbook.getSheet(sheetName);									//get workbook's sheet
		
		for(int colNum=4;colNum<9;colNum++) {
			
			if(sheet.getRow(rowNum)!=null) {
				sheet.getRow(rowNum).createCell(colNum);										//creating cell
				sheet.getRow(rowNum).getCell(colNum).setCellValue(details.get(colNum-4));		//inserting value in cell
			}
		}
		
		try {
			file.close();					//closes file input stream
		} 
		catch (IOException e1) {
			fileOp=false;
			log.info("Error when closing file.");
		}															
		FileOutputStream outfile=null;
		try {
			outfile = new FileOutputStream(new File(System.getProperty("user.dir") + "/" +PropertyReader.getFieldValue("testDataFilePath")));
		} 
		catch (FileNotFoundException e) {
			fileOp=false;
			log.info("Error with file location. Cannot update status.");
		}
		
		try {
			workbook.write(outfile);				//writing workbook
		} 
		catch (IOException e) {
			log.info("Error with workbook location. Cannot update status.");
		}					
		try {
			outfile.close();						//closing file
		} 
		catch (IOException e) {
			fileOp=false;
			log.info("Error with file outputstream. Please make sure any other process is not keeping the file open.");
		}		
		
		if(fileOp==true)
			log.info("value written to xls ");
		
		mapping=true;								//turning mapping back to true
	}
	
	
	/**Deletes entity from requested url. 
	 * entity id must be post fixed to an url.
	 * 
	 * @param entityUrl : url of entity to be deleted.
	 * @return Returns response code from server.
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int deleteEntitity(String entityUrl) throws ClientProtocolException, IOException {
		return httpRequest.handleDelete(entityUrl);
	}
	
	
	/**Returns test configuration id.
	 * 
	 * @return Returns configuration of id of the test case
	 */
	public int getConfigId() {
		return Integer.parseInt(configId);
	}
	
	
	/**Return test id
	 * 
	 * @return test id
	 */
	public int getTestId() {
		return Integer.parseInt(testId);
	}
	
	/**Return test set id
	 * 
	 * @return test set id
	 */
	public int getTestSetId() {
		return Integer.parseInt(cycleId);
	}
	
	/**Return test instance id
	 * 
	 * @return test instance id
	 */
	public int getTestInstanceId() {
		return Integer.parseInt(testCycleId);
	}
	
	/**Return run id.
	 * 
	 * @return Run id.
	 */
	public int getRunId() {
		return Integer.parseInt(runId);
	}

	/**Returns xml payload used for creating run entity.
	 * 
	 * @return xmlpayload carrying required attributes and values for loggign results.
	 */
	public String getRunsPayload() {
		return xmlPayload;
	}
	
	/**Returns xml payload used for updating test status 
	 * 
	 * @return updated payload.
	 */
	public String getTestStatusUpdatePayload() {
		return updatedXmlPayload;
	}
	
	/**Returns url of test instances on ALM based on test id and test set id. 
	 * 
	 * @return url of test instances.
	 */
	public String getUrlTestInstances() {
		return urlTestInstances;
	}
	
	/**Returns browser value found in test configuration
	 * 
	 * @return returns configuration value, set for browser.
	 */
	public String getbrowserValuefromConfig() {
		return browserValue;
	}
	
	/**Returns browser value found in TestNG file.
	 * 
	 * @return browser value in testNG.xml
	 */
	public String getBrowserfromTestNG() {
		return browser;
	}
	

}

