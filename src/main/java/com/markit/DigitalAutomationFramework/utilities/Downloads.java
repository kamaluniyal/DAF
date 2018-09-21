package com.markit.DigitalAutomationFramework.utilities;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.markit.DigitalAutomationFramework.utilities.HTTPOperations;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.driver.GlobalDriver;
import com.markit.DigitalAutomationFramework.common.Logging;


/**Assists in operations on Download folder files, Also provides fileDownloadClickAndWait to wait for file to 
 * completely download before proceeding.
 * @author sambhav.chawla
 * @author nishant.thakur
 */
public class Downloads {
	
	/**
	 * Path to download folder. Will be picked up from Configuration.properties file attribute DOWNLOADFILEPATH
	 */
	public String downloadfolder;
	
	/**
	 * Browser Name
	 */
	public String browserName;
	
	/**
	 * Session id. Used to find remote node's host name and port if test is executing in grid environment
	 */
	public String sessionId;
	
	/**
	 * WebDriver
	 */
	public WebDriver driver;
	
	/**
	 * Logger
	 */
	private Logging Log =new Logging("Downloads");
	
	/**
	 * Max waiting time for a file to download, should be increased if file size is too big
	 */
	static int MAX_WAIT = 60; 
	
	/**
	 * Common file data types, used for waiting for a file type to download completely
	 */
	List<String> extensions = Arrays.asList("xls", "xlsx", "png","jpeg","jpg", "doc","docx", "csv", "txt", "mp3", "csv" ,"ppt", "pptx","pdf","rtf","xml","gif", "zip");

	/**
	 * The host where this suite was run, or null if it was run locally. The returned string has the form: host:port
	 */
	private String hubHostnameAndPort;

	/**
	 * Id of thread
	 */
	private long threadId;
	
	/**
	 * Constructor
	 * @param driver
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public Downloads(WebDriver driver) throws IOException, URISyntaxException {
		
		//Load Config properties
		loadProperties();
		
		//Save WebDriver
		this.driver= driver;
		
		//Save Thread id
		threadId = Thread.currentThread().getId();
		
		//Extract browser name and session id
		EventFiringWebDriver  ed = (EventFiringWebDriver) driver;
		WebDriver d = ed.getWrappedDriver();
		RemoteWebDriver rd = ((RemoteWebDriver) d );
		Capabilities cap = rd.getCapabilities();
		Map<String, ?> map = cap.asMap();
		
		//Find remote session id, Grid Execution. It is set only for grid execution. Not for Local execution
		String remoteSessionId = (String) map.get("webdriver.remote.sessionid");
		
		//If Grid Execution, find grid hub 
		if (remoteSessionId != null && remoteSessionId.length()>0){
			
			//Log Remote session
			Log.info("Remote session found : " + remoteSessionId);
			
			//Get hostname of Grid URL from Sel_Grid parameter if Grid execution
			String selGrid = null;
			
			//Find grid parameter in test XML parameters
			Set<String> params = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getAllParameters().keySet();
			for(String param: params){
				if (param.toLowerCase().contains("sel") && param.toLowerCase().contains("grid")){
					selGrid = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(param);
				}
			}
			
			//If grid parameter not found or its value is null, then try finding it in Config file
			if (selGrid == null)
				selGrid = PropertyReader.getFieldValue("defaultGrid");
			
			try {
				URI usi = new URI(selGrid);
				hubHostnameAndPort = usi.getHost() + ":" + usi.getPort() + "/";
			} catch (Exception e) {
				Log.error("Unable to find Hub host. This download test is likely to fail");
				throw (new URISyntaxException(selGrid, "invalid hub location"));
			}
			
		}
		
		//If local execution
		else{
			//Log Local session
			Log.info("Local session found");
			hubHostnameAndPort = null;
		}
		
		this.browserName = cap.getBrowserName().toUpperCase();
		this.sessionId = rd.getSessionId().toString();
		
		
		String os = GlobalDriver.getOS();
		
		//If linux
		if (os.toLowerCase().contains("nux")){
			 Log.info("-------------------------------------------------------------------------");
			 String s = "";
		      for (FileStore store : FileSystems.getDefault().getFileStores()) {
		    	 
		         long total = store.getTotalSpace() / 1024;
		         long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
		         long avail = store.getUsableSpace() / 1024;
		         s += "\n:" + store.name() +":\t" + store + "\t"  + total + "\t"  +  used + "\t"  +  avail + "\n";
		      }
		      Log.info(s);
			Log.info("--------------------------------XXXXXXXX--------------------------------");
			
			this.downloadfolder = PropertyReader.getFieldValue("linuxMountLocation")+ File.separator ;
			File file = new File (downloadfolder);
			Log.info(">>dir path: " + file.getName());
			Log.info(">>is dir:" + file.isDirectory());
			Log.info(">>dir exists:" + file.exists());
			Log.info(">>dir read perm:" + file.canRead());
			Log.info(">>dir write perm:" + file.canWrite());		
			
			this.downloadfolder += "GridExecution" + File.separator + threadId;
		}
		//If Windows
		else{
			
			//Set download path specified in configuration file if local execution
			if (hubHostnameAndPort==null){
				this.downloadfolder = PropertyReader.getFieldValue("DOWNLOADFILEPATH") + File.separator + threadId; 
			}
	
			//Set download path as Remote Node's download location if Grid execution
			else{
				//Get Remote Node's Hostname
				String r = getRemoteNodeHostNameAndPort();
				r = r.substring(0, r.indexOf(':')); //Remove port
				this.downloadfolder = File.separator + File.separator + r + File.separator + "SeleniumDownloads" + File.separator + "GridExecution" + File.separator + threadId; 
			}
		}
		//Add separate folders for different browsers in download location
		if (this.browserName.equals("INTERNET EXPLORER")){
			this.downloadfolder = this.downloadfolder + File.separator + "IE";	//IE folder is always cleaned before download
		}
		else if (this.browserName.equals("FIREFOX")){
			this.downloadfolder = this.downloadfolder + File.separator + "FIREFOX";
		}
		else if (this.browserName.equals("CHROME")){
			this.downloadfolder = this.downloadfolder + File.separator +"CHROME";
		}
		
		//Create download folder if doesn't exists
		createFolder();
		
		//Clean folder if IE browser
		if (this.browserName.equals("INTERNET EXPLORER")){
			this.cleanFolder(downloadfolder);
		}
		
		
		
	}

	/**
	 * Final download location where file would be looked for after download link is clicked
	 * @return
	 */
	public String getFinalDownloadPath(){
		return downloadfolder;
	}
	
	/**
	 * Creates default download folder if it doesn't exists
	 * @throws IOException 
	 */
	private void createFolder() throws IOException{
		
		Log.info("Final Download Location :" + downloadfolder);
		
		File file = new File (downloadfolder);
		
		boolean success = file.mkdirs();
		if(!success && !file.exists()) Log.error("Creating directory failed");
		else Log.info("Directory created");
		
		Log.info("Location Exists :" + file.exists());
		Log.info("Read permission :" + file.canRead());
		Log.info("Write permission :" + file.canWrite());
	}
	
	/**Returns number of files in the default download folder
	 * @return Count of files in download folder, Datatype - int
	 */
	private int getDownloadFolderCount(){
		return new File(downloadfolder).listFiles().length;
	}
	
	/**Returns the last modified file in default download folder
	 * @return Last modified file Datatype - File
	 */
	public File lastModifiedFile() {
	    File fl = new File(downloadfolder);
	    File[] files = fl.listFiles(new FileFilter() {          
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });	    
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	    return choice;
	}
	
	/**Returns file Size in Kilobytes
	 * @param file to get its Size
	 * @return File size in int
	 */
	public int getFileSize(File file){
		return (int) (file.length()/1024);
	}	
	
	/**Returns extension of file passed
	 * @param file for which extension is needed
	 * @return String actual extension of the file (example xls)
	 */
	public String getFileExtension(File file){
		String actualext=file.getName();
		int i = actualext.lastIndexOf('.');
		if (i > 0) {
			actualext = actualext.substring(i+1);
		}
		return actualext;		
	}
	
	/**Returns extension of last modified file in default download folder
	 * 
	 * @return actual extension in String
	 */
	public String getLastModifiedFileExtension(){
		File fl=lastModifiedFile();
		String actualext=fl.getName();
		int i = actualext.lastIndexOf('.');
		if (i > 0) {
			actualext = actualext.substring(i+1);
		}
		return actualext;		
	}
	
	/**Returns name of last modified file in default dowmload folder
	 * @return Name of file in String
	 */
	public String getLastModifiedFileName(){
		File fl=lastModifiedFile();
		String actualname=fl.getName();		
		actualname=actualname.substring(0, actualname.lastIndexOf('.'));
		return actualname;		
	}
	
	/**Returns name of file passed
	 * @param file for which name is needed
	 * @return Name of file in String without extension
	 */
	public String getFileName(File file){
		String actualname=file.getName();		
		actualname=actualname.substring(0, actualname.lastIndexOf('.'));
		return actualname;		
	}
	
	/**
	 * Reads the configurations from the default properties file
	 * @return PropertyReader
	 * @throws IOException
	 */
	private void loadProperties() throws IOException {
		PropertyReader.ValueMap("Configuration.properties");
	}
	
	/**
	 * Cleans given folder. Delete all files and sub-folders.
	 * @param path path of folder
	 */
	private void cleanFolder(String path){
		if (!(path.endsWith("/") || path.endsWith("\\")))
			path = path + "/";
		
		File f = new File(path);
		
		if (f.isDirectory())
			try {
				FileUtils.cleanDirectory(f);
			} catch (IOException e) {
			}
	}
	
	/**Waits for download folder to increase in 1 file size 
	 * Also waits for file extenison to be one of common filetypes or user can enter expected file extension
	 * Eg. jpg, xls, jpeg. Please enter extension without dot.
	 * @param click pass the WebElement here instead of the POM class which will be clicked to download the file. 
	 * @return File is returned after being downloaded
	 * @throws IOException 
	 */
	public File fileDownloadClickAndWait(WebElement click) throws IOException{
		final Date date = new Date();
		final File[] fl = new File[1];
		final int currentsize=getDownloadFolderCount();
		
		Log.info("Expected Download Location: " + downloadfolder);
		Log.info("Current Folder Size: " + currentsize);
		
		//Fire AutoIt if IE
		this.executeAutoItScriptIfIE();
		
		//Click on download link. Simple click causes issues in IE. Click never returns control. Action click resolves it.
		Log.info("Performing click on download link: " + click);
		Actions act = new Actions(driver); 
		act.click(click).build().perform();
		Log.info("Clicked on download link");
		
		this.executeAutoItScriptIfIE();
		
		Log.info("Waiting for Download to finish");
		//Wait for file to download
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {	            
	        	return getDownloadFolderCount()>currentsize;
	        }
	    });
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {	        	
	        	fl[0]=lastModifiedFile();	        	
	        	Date filemodified = new Date(fl[0].lastModified());	        	
	        	String actualext= getFileExtension(fl[0]);	        	
	        	Log.info("Extension expected: "+ extensions.contains(actualext)+". Is modified time later than download start time: "+ (!filemodified.before(date)) +". Is size greater than 1byte: "+(fl[0].length()>10)+ ".");
	        	return extensions.contains(actualext) && (!filemodified.before(date) && fl[0].length()>1);
	        }
	    });
		Log.info("Download finished");
		
		//Return downloaded file
		return fl[0];
		
	}
	

	/**Waits for download folder to increase in 1 file size 
	 * Also waits for file extenison to be one of common filetypes or user can enter expected file extension
	 * Eg. jpg, xls, jpeg. Please enter extension without dot.
	 * @param click pass the WebElement here instead of the POM class which will be clicked to download the file.
	 * @param expectedextension Optional parameter, Pass expected entension to wait for file download completion
	 * @return File is returned after being downloaded
	 * @throws IOException 
	 */
	public File fileDownloadClickAndWait(WebElement click,final String expectedextension) throws IOException{
		final Date date = new Date();
		final File[] fl = new File[1];
		final int currentsize=getDownloadFolderCount();
		
		Log.info("Expected Download Location: " + downloadfolder);
		Log.info("Current Folder Size: " + currentsize);

		//Fire AutoIt if IE
		this.executeAutoItScriptIfIE();
		
		//Click on download link. Simple click causes issues in IE. Click never returns control. Action click resolves it.
		Log.info("Performing click on download link: " + click);
		Actions act = new Actions(driver); 
		act.click(click).build().perform();
		Log.info("Clicked on download link");
		
		//Wait for file to download
		Log.info("Waiting for Download to finish");
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver){	            
	        	return getDownloadFolderCount()>currentsize;
	        }
	    });		
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver){
	        	fl[0]=lastModifiedFile();
	        	Date filemodified = new Date(fl[0].lastModified());
	        	String actualext= getFileExtension(fl[0]);
	        	Log.info("Extension expected: "+ extensions.contains(actualext)+". Is modified time later than download start time: "+ (!filemodified.before(date)) +". Is size greater than 1byte: "+(fl[0].length()>10)+ ".");
	        	return actualext.equals(expectedextension) && (!filemodified.before(date) && (!filemodified.before(date) && fl[0].length()>1));
	        }
	    });
		Log.info("Download finished");
		
		//Return downloaded file
		return fl[0];
	}
	

	/**Clicks on given download link, accepts confirmation alert,Waits for download folder to increase in 1 file size 
	 * Also waits for file extenison to be one of common filetypes or user can enter expected file extension
	 * Eg. jpg, xls, jpeg. Please enter extension without dot.
	 * @param click pass the WebElement here instead of the POM class which will be clicked to download the file. 
	 * @return File is returned after being downloaded
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public File fileDownloadClickAndWait_acceptAlert(WebElement click) throws InterruptedException, IOException{
		final Date date = new Date();
		final File[] fl = new File[1];
		final int currentsize=getDownloadFolderCount();
		
		Log.info("Expected Download Location: " + downloadfolder);
		Log.info("Current Folder Size: " + currentsize);
		
		//Fire AutoIt if IE
		this.executeAutoItScriptIfIE();
		
		//Click on download link. Simple click causes issues in IE. Click never returns control. Action click resolves it.
		Log.info("Performing click on download link: " + click);
		Actions act = new Actions(driver); 
		act.click(click).build().perform();
		Log.info("Clicked on download link");
		
		//Accept alert if Chrome or Firefox. For IE alert is handled by AutoIt Script
		if(!this.browserName.equals("INTERNET EXPLORER")){
			Log.info("Waiting for Alert");
			//Wait some time for alert to appear
			WebDriverWait wait = (new WebDriverWait(driver, 10));
			wait.until(ExpectedConditions.alertIsPresent());
			
			//Accept alert
			Alert a = driver.switchTo().alert();
			a.accept();
			
			Log.info("Alert Accepted");
		}
		
		
		//Wait for file to download
		Log.info("Waiting for Download to finish");
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {	            
	        	return getDownloadFolderCount()>currentsize;
	        }
	    });
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {	        	
	        	fl[0]=lastModifiedFile();	        	
	        	Date filemodified = new Date(fl[0].lastModified());	        	
	        	String actualext= getFileExtension(fl[0]);	        	
	        	Log.info("Extension expected: "+ extensions.contains(actualext)+". Is modified time later than download start time: "+ (!filemodified.before(date)) +". Is size greater than 1byte: "+(fl[0].length()>10)+ ".");
	        	return extensions.contains(actualext) && (!filemodified.before(date) && fl[0].length()>1);
	        }
	    });
		Log.info("Download finished");
		
		//Return downloaded file
		return fl[0];
	}
	

	/**Waits for download folder to increase in 1 file size 
	 * Also waits for file extenison to be one of common filetypes or user can enter expected file extension
	 * Eg. jpg, xls, jpeg. Please enter extension without dot.
	 * @param click pass the WebElement here instead of the POM class which will be clicked to download the file.
	 * @param expectedextension Optional parameter, Pass expected entension to wait for file download completion
	 * @return File is returned after being downloaded
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public File fileDownloadClickAndWait_acceptAlert(WebElement click,final String expectedextension) throws InterruptedException, IOException{
		final Date date = new Date();
		final File[] fl = new File[1];
		final int currentsize=getDownloadFolderCount();

		Log.info("Expected Download Location: " + downloadfolder);
		Log.info("Current Folder Size: " + currentsize);
		
		//Fire Auto It if IE
		this.executeAutoItScriptIfIE();
		
		//Click on download link. Simple click causes issues in IE. Click never returns control. Action click resolves it.
		Log.info("Performing click on download link: " + click);
		Actions act = new Actions(driver); 
		act.click(click).build().perform();
		Log.info("Clicked on download link");
		
		//Accept alert if Chrome or Firefox. For IE alert is handled by AutoIt Script
		if(!this.browserName.equals("INTERNET EXPLORER")){
			Log.info("Waiting for Alert");
			//Wait some time for alert to appear
			WebDriverWait wait = (new WebDriverWait(driver, 10));
			wait.until(ExpectedConditions.alertIsPresent());
			
			//Accept alert
			Alert a = driver.switchTo().alert();
			a.accept();
			
			Log.info("Alert Accepted");
		}
		
		//Wait for file to download
		Log.info("Waiting for Download to finish");
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver){	            
	        	return getDownloadFolderCount()>currentsize;
	        }
	    });		
		new WebDriverWait(driver,MAX_WAIT).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver){
	        	fl[0]=lastModifiedFile();
	        	Date filemodified = new Date(fl[0].lastModified());
	        	String actualext= getFileExtension(fl[0]);
	        	Log.info("Extension expected: "+ extensions.contains(actualext)+". Is modified time later than download start time: "+ (!filemodified.before(date)) +". Is size greater than 1byte: "+(fl[0].length()>10)+ ".");
	        	return actualext.equals(expectedextension) && (!filemodified.before(date) && (!filemodified.before(date) && fl[0].length()>1));
	        }
	    });
		Log.info("Download finished");
		
		//Return downloaded file
		return fl[0];
	}
	
	/**
	 * Set max waiting time to let download to finish
	 * @param seconds
	 */
	public void setMaxDownloadWait (int seconds){
		MAX_WAIT = seconds;
	}
	
	
	/**
	 * Deletes last modified file
	 */
	public void deleteFile(){
		File fl=lastModifiedFile();
		fl.deleteOnExit();
	}

	/**
	 * Returns name of Remote node's host name and Port if Grid execution and session found in Hub.
	 * @return Remote node host name and port if found, else null
	 * @throws IOException
	 */
	private String getRemoteNodeHostNameAndPort() throws IOException{
		
		//If local execution or invalid host address then return null
		if (hubHostnameAndPort == null){
			return null;
		}
		
		//Create request to hub 
		HTTPOperations req = new HTTPOperations();
		String requestToHub = "http://" + hubHostnameAndPort + "grid/admin/HubServlet?sessionID=" + this.sessionId;
		
		//Log Request string
		Log.info("Hub Request = [" + requestToHub + "]");
		
		
		int status;	//Status of response
		String remoteNodeHostNameAndPort = null; //remote node's host name and port
		
		try{
			//Make the request to Hub. 
			status = req.handleGET(requestToHub);	//This would throw HttpHostConnectException if Hub is not running
			
			//Save the node info. This would return xxx:yyy format if session found, null if session not found
			remoteNodeHostNameAndPort = req.outputString;
			
			//Remove 'http://'
			remoteNodeHostNameAndPort = remoteNodeHostNameAndPort.replace("http://", "");
		}
		
		catch (HttpHostConnectException e){
			Log.info("Hub not found: " + hubHostnameAndPort);
			return null;
		}
		
		//If Hub returned response but Session not found
		if (status == 200 && remoteNodeHostNameAndPort.equalsIgnoreCase("null")){
			Log.info("Session not found in Hub's active sessions: " + sessionId);
			remoteNodeHostNameAndPort = null;
		}
			
		return remoteNodeHostNameAndPort;
		
	}
	
	/**
	 * Executes AutoIt script if IE browser.
	 * @throws IOException
	 */
	private void executeAutoItScriptIfIE() throws IOException{
		if(this.browserName.equals("INTERNET EXPLORER"))
		{
			if (hubHostnameAndPort==null){
				executeScriptForIE_Locally(System.getProperty("user.dir") + "/src/test/resources/IEDownloader.exe", this.downloadfolder);
			}
			else{
				executeScriptForIE_Remotely(this.downloadfolder);
			}
		}
	}

	/**
	 * To run AutoIt script locally to handle download bar in IE
	 * @param autoItScriptPath
	 * @throws IOException
	 */
	private void executeScriptForIE_Locally(String autoItScriptPath, String downloadFolderPath) throws IOException{
		Log.info("Executing AutoIT script Locally");
		Log.info("Using AutoIt exe = [" + System.getProperty("user.dir") + "/src/test/resources/IEDownloader.exe] ");
		Log.info("Download location = [" + this.downloadfolder + "]" );
		
		//scriptPath is the path of the executable
		Runtime.getRuntime().exec(autoItScriptPath + " \"" + downloadFolderPath + "\"" + " " + (MAX_WAIT + 30));
		
		Log.info("Executed Auto It script");
	}

	/**
	 * To run AutoIt script in remote node to handle download bar in IE
	 * @param autoItScriptPath
	 * @throws IOException
	 */
	private void executeScriptForIE_Remotely(String downloadFolderPath) throws IOException{

		String nodeReq = "http://" + getRemoteNodeHostNameAndPort() + "/extra/NodeServlet?threadId=" + this.threadId + "&timeOut=" + (MAX_WAIT + 30);
		
		
		//Keeping for reference
//		String nodeReq = "http://" + getRemoteNodeHostNameAndPort() + "/extra/NodeServlet?downloadPath=" + URLEncoder.encode(downloadFolderPath,"UTF-8") + "&timeOut=" + (MAX_WAIT + 30);
		
		//Prepare remote node request
//		String nodeReq = "http://" + getRemoteNodeHostNameAndPort() + "/extra/NodeServlet?timeOut=" + (MAX_WAIT + 30);

		//Log info
		Log.info("Executing AutoIT Script remotely.");
		Log.info("Download location = [" + downloadFolderPath + "]" );
		Log.info("Node Request = [" + nodeReq + "]");
		
		//Send request
		HTTPOperations req = new HTTPOperations();
		int status = req.handleGET(nodeReq);
		
		//If remote node servlet responded
		if(status == 200){
			
			Log.info("Node response code = [200]");
			
			//Log if AutopIt script fired in remote node or not
			
			if(req.outputString.startsWith("Error")){
				Log.error("AutoIt script execution in remote node failed with following message");
				Log.error(req.outputString);
				
			}
			else{
				Log.info("AutoIT script fired successfully in remote node");
			}
			
		}
		
		//If remote node servlet did not respond
		else{
			Log.error("No response from remote node.");
		}
		
	}
	
	
}
