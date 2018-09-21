package com.markit.DigitalAutomationFramework.driver;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.NDC;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.markit.DigitalAutomationFramework.common.PropertyReader;
import com.markit.DigitalAutomationFramework.common.TestListener;
import com.markit.DigitalAutomationFramework.common.Logging;

/**
 * This class is the global driver used to launch browsers requested as part of
 * the test suite
 * 
 * @author stuart.rogers
 * @version 1.0
 * @since 2015-07-27
 */
public class GlobalDriver {

	/**
	 * Browser name
	 */
	private String dBrowser;
	
	/**
	 * Browser version as supplied
	 */
	private String dVersion;
	
	/**
	 * Grid parameter as supplied
	 */
	private String dGrid;
	
	/**
	 * The public EventFiringWebDriver that will be returned once the browser is
	 * launched
	 */
	public EventFiringWebDriver _driver = null;
	/**
	 * The RemoteWebDriver for when the tests are to be executed via Selenium
	 * Grid
	 */
	private RemoteWebDriver _rmdriver = null;
	/**
	 * The WebDriver when the tests are to be run locally
	 */
	private WebDriver _ldriver = null;

	/**
	 * Create a new logger for the driver
	 */
	private Logging Log = new Logging(GlobalDriver.class.getName());
	
	/**
	 * Download path to be set in ChromeOptions or Firefox profile. 
	 * IE doesn't allows to set download path. 
	 * For IE this path is provided by Auto IT script which is fired by appropriate method of Download class. {@link com.markit.infoqa.seleniumframework.test} 
	 */
	private String defaultdownloadpath = null;

	/**
	 * Final Capabilities which are request to create instance of WebDriver (local or remote)
	 */
	private DesiredCapabilities finalCapabilities;
	
	/**
	 * IE Capabilities requested to be added in Final Capabilities 
	 */
	private DesiredCapabilities ieCapability;
	
	/**
	 * Firefox profile requested to be added in Final Capabilities
	 */
	private FirefoxProfile ffProfile;
	
	/**
	 * Chrome Options requested to be added in Final Capabilities
	 */
	private ChromeOptions chromeOptions;

	/**
	 * Default constructor
	 */
	public GlobalDriver(){
		this.finalCapabilities = null;
		this.ieCapability = null;
		this.ffProfile = null;
		this.chromeOptions = null;
	}
	
	/**
	 * Sets download path for WebDriver instance. (FF and Chrome)
	 * For Local execution: DOWNLOADFILEPATH property from Configuration.properties
	 * For Grid execution: C:\SeleniumDownloads\GridExecution\<thread-id>
	 */
	protected void setDownloadPath() {
		long tid = Thread.currentThread().getId();
		
		if (dGrid == null || dGrid.isEmpty()){
			defaultdownloadpath = PropertyReader.getFieldValue("DOWNLOADFILEPATH") + "\\" + tid;
		}
		else{
			defaultdownloadpath = "C:\\SeleniumDownloads\\GridExecution" + "\\" + tid;
		}
	}

	/**
	 * Returns download path for the WebDriver instance
	 * @return
	 */
	public String getDownloadPath (){
		return this.defaultdownloadpath;
	}
	
	public String getBrowserName (){
		return this.dBrowser;
	}
	
	public String getVersion (){
		return this.dVersion;
	}
	
	public String getGrid(){
		return this.dGrid;
	}
	/**
	 * Initialises WebDriver instance.
	 * @param browser 
	 * @param version
	 * @param grid
	 * @param internetExplorerCapability
	 * @return
	 * @throws IOException
	 */
	public EventFiringWebDriver init(String browser, String version, String grid, DesiredCapabilities internetExplorerCapability ) throws IOException {
		if (internetExplorerCapability.getBrowserName() != BrowserType.IE){
			Log.info("ERROR: ONLY INTERNET EXPLORER CAPABILITY ACCEPTED");
			return null;
		}
		this.ieCapability = internetExplorerCapability;
		return this.init(browser, version, grid);
	}

	public EventFiringWebDriver init(String browser, String version, String grid, FirefoxProfile firefoxProfile ) throws IOException {
		this.ffProfile = firefoxProfile;
		return this.init(browser, version, grid);
	}
	
	public EventFiringWebDriver init(String browser, String version, String grid, ChromeOptions chromeOptions ) throws IOException {
		this.chromeOptions = chromeOptions;
		return this.init(browser, version, grid);
	}
	
	/**
	 * This launches the required browser, if the tests are launched from a
	 * TestNG xml file then the parameters specified there are used. e.g:
	 * 
	 * <pre>
	 * {@code
	 * <parameter name="Sel_Grid" value="http://uktestingdpc012:4444/wd/hub" />
	 * <parameter name="browser" value="Chrome" />
	 * <parameter name="version" value="43.0" />
	 * }
	 * </pre>
	 * <p>
	 * If these are not supplied or the test is launched from within the IDE
	 * directly then the browser used will default to that specified in the
	 * Configuration.properties file
	 * 
	 * @param browser
	 *            A String containing the name of the browser to launch, should
	 *            be either
	 *            <p>
	 *            "firefox"
	 *            <p>
	 *            "ie"
	 *            <p>
	 *            "chrome"
	 * @param version
	 *            The version of the browser required, if not specified then any
	 *            available version will be used
	 * @param grid
	 *            The Selenium grid URL to execute the tests against which will
	 *            distribute the execustion across multiple environments if
	 *            available
	 * @return EventFiringWebDriver The driver controlling the browser instance
	 *         that has been launched
	 * @throws IOException
	 */
	public EventFiringWebDriver init(String browser, String version, String grid) throws IOException {

		//If browser parameter is null, then find default browser to be used
		if (browser == null) {
			dBrowser = PropertyReader.getFieldValue("defaultBrowser");
		} else {
			dBrowser = browser;
		}
		
		//Use version and grid parameter as provided
		this.dVersion = version;
		this.dGrid = grid;
		
		//Load config properties
		this.loadProperties();
		
		//Set download path according to Local or Grid execution
		this.setDownloadPath();
		
		//Set final capabilities to be requested
		this.setCapabilities();
		
		// Create a new instance of the driver
		// If grid is supplied then create a remote WebDriver instance
		if (grid != null) {

			URL hubUrl = new URL(grid);
			Log.info("Grid URL used: " + hubUrl);


			NDC.pop();

			NDC.push(dBrowser.toUpperCase());

			Log.info("Requesting new remote browser: " + dBrowser + " " + version);

			_rmdriver = new RemoteWebDriver(hubUrl, finalCapabilities);

			_driver = new EventFiringWebDriver(_rmdriver);

			// Creating an instance of Capabilities
			Capabilities cap = ((RemoteWebDriver) _rmdriver).getCapabilities();
			// Storing the browser name in a string
			dBrowser = cap.getBrowserName().toUpperCase();
			// Storing the Browser version in a string
			String browserVersion = cap.getVersion().toString();
			// Storing the platform in a string
			String platform = cap.getPlatform().toString();
			// Creating log when browser is initiated
			Log.info("Browser:" + dBrowser + ":" + "Version:" + browserVersion + " " + "Platform:" + platform);
		} 
		
		//If grid not supplied, create a local WebDriver instance
		else {

			NDC.pop();

			NDC.push(dBrowser.toUpperCase());

			

			Log.info("Requesting new local browser: " + dBrowser);
			ClassLoader classLoader = getClass().getClassLoader();

			// From browser param launch the correct browser
			
			//FIREFOX
			if (dBrowser.equalsIgnoreCase("firefox")) {
			//	_ldriver = new FirefoxDriver(finalCapabilities);
				
				// Code changes to make it run on local machine.
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile ffprofile = profile.getProfile("default-1473834323885");
				_ldriver = new FirefoxDriver(ffprofile);
				
			} 
			
			//IE
			else if (dBrowser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", classLoader.getResource("IEDriverServer.exe").getFile());
				_ldriver = new InternetExplorerDriver(finalCapabilities);
			} 
			
			//CHROME
			else if (dBrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", classLoader.getResource("chromedriver.exe").getFile());
				_ldriver = new ChromeDriver(finalCapabilities);
			} 
			
			
			//PHANTOMJS
			else if (dBrowser.equalsIgnoreCase("phantomjs")) {

				DesiredCapabilities dCaps = new DesiredCapabilities();
				dCaps.setJavascriptEnabled(true);
				dCaps.setCapability("takesScreenshot", false);
				dCaps.setCapability("browserName", "phantomjs");
				_ldriver = new RemoteWebDriver(new URL("http://127.0.0.1:8080"), dCaps);

			}

			_driver = new EventFiringWebDriver(_ldriver);

			// Creating an instance of Capabilities
			Capabilities cap = ((RemoteWebDriver) _ldriver).getCapabilities();
			// Storing the browser name in a string
			dBrowser = cap.getBrowserName().toUpperCase();
			// Storing the Browser version in a string
			String browserVersion = cap.getVersion().toString();
			// Creating log when browser is initiated
			String platform = cap.getPlatform().toString();
			
			Log.info("Browser:" + dBrowser + ":" + "Version:" + browserVersion + " " + "Platform:" + platform);
		}

		// Creating instance of eventListener, that we just defined
		EventListener eventListener1 = new EventListener();
		TestListener testL = new TestListener();
		// Register the Listener with the event firing driver
		_driver.register(eventListener1);
		_driver.register(testL);

		Log.info("New driver instantiated");

		// Put a Implicit wait, this means that any search for elements on the
		// page could take the time the implicit wait is set for before throwing
		// exception
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		_driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		_driver.manage().window().maximize();
		Log.info("Implicit wait applied on the driver for 10 seconds");
		return _driver;

	}

	private void setCapabilities(){
		// From browser param launch the correct browser
		if (dBrowser.equalsIgnoreCase("firefox")) {
			this.setFFOptions();
		} 
		
		else if ( dBrowser.equalsIgnoreCase("ie") || dBrowser.equalsIgnoreCase("INTERNET EXPLORER")) {
			this.setIEOptions();
		} 
		
		else if (dBrowser.equalsIgnoreCase("chrome")) {
			this.setChromeOptions();
		}
		
	}
	
	private void setFFOptions() {
		
		
		String mimeTypes = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/pdf;text/csv;image/gif;image/jpeg;application/x-ms-application;application/x-msdownload;application/vnd.ms-excel;application/vnd.openxmlformats-officedocument.spreadsheetml.template;application/vnd.openxmlformats-officedocument.wordprocessingml.document;application/vnd.ms-powerpoint;application/msword;text/plain;image/png;application/rss+xml;application/xml;application/xlsx;text/xlsx;application/octet-stream;application/msexcel;application/x-msexcel;application/x-ms-excel;application/x-excel;application/x-dos_ms_excel;text/xml;application/unknown;application/zip";
		
		if (this.ffProfile == null){
			
			this.ffProfile = new FirefoxProfile();
			ffProfile.setPreference("pdfjs.disabled", true);
			ffProfile.setPreference("plugin.scan.plid.all", false);
			ffProfile.setPreference("plugin.scan.Acrobat", "99.0");
			ffProfile.setPreference("browser.download.folderList", 2);
			ffProfile.setPreference("browser.download.dir", defaultdownloadpath + "\\FIREFOX");
			ffProfile.setPreference("browser.popups.showPopupBlocker", false);
			ffProfile.setPreference("privacy.popups.showBrowserMessage", false);
			ffProfile.setPreference("browser.zoom.full", true);
			ffProfile.setPreference("javascript.enabled", true);
			ffProfile.setPreference("browser.download.manager.showWhenStarting", false);
			ffProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", mimeTypes);
			ffProfile.setPreference("browser.helperApps.neverAsk.openFile", mimeTypes);
		}
		else{
			//Just Set default Download options.
			ffProfile.setPreference("pdfjs.disabled", true);
			ffProfile.setPreference("plugin.scan.plid.all", false);
			ffProfile.setPreference("plugin.scan.Acrobat", "99.0");
			ffProfile.setPreference("browser.download.folderList", 2);
			ffProfile.setPreference("browser.download.dir", defaultdownloadpath + "\\FIREFOX");
			ffProfile.setPreference("browser.download.manager.showWhenStarting", false);
			ffProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", mimeTypes);
			ffProfile.setPreference("browser.helperApps.neverAsk.openFile", mimeTypes);
			
		}
		
		
	finalCapabilities = new DesiredCapabilities();
		
				
		if (dVersion != null) {
		finalCapabilities.setVersion(dVersion);
	}
  				
		finalCapabilities.setBrowserName("firefox");
		finalCapabilities.setCapability(FirefoxDriver.PROFILE, ffProfile); 
		finalCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);  //To not DISMISS alerts generated. Should be handled by user
	}

	private void setIEOptions() {

		
		if (this.ieCapability == null){
			ieCapability = DesiredCapabilities.internetExplorer();
			
			ieCapability.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			ieCapability.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			ieCapability.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
			ieCapability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			ieCapability.setJavascriptEnabled(true);
			ieCapability.setCapability("nativeEvents", false);
		}
		
		finalCapabilities = ieCapability;
		finalCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT); //To not ACCEPT alerts generated. Should be handled by user
		if (dVersion != null) {
			finalCapabilities.setVersion(dVersion);
		}
		
		
	}

	private void setChromeOptions() {

		
		if (this.chromeOptions == null){
			
			chromeOptions = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			
			//add download folder preference
			prefs.put("download.default_directory", defaultdownloadpath + "\\CHROME");
			//add preference for download notification								
			prefs.put("download.prompt_for_download", "false");
			//preference for pop up
			prefs.put("profile.default_content_settings.popups", 0);
			//language preference
			prefs.put("settings.language.preferred_languages", "en");
								
			//set chrome options using the preferences set above
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.setExperimentalOption("prefs", prefs);
			HashMap<String, Object> plugin = new HashMap<String, Object>();
			plugin.put("enabled", false);
			plugin.put("name", "Chrome PDF Viewer");
			prefs.put("plugins.plugins_list", Arrays.asList(plugin));
			
		}
		else{
			//Set only default download path
			Map<String, Object> prefs = new HashMap<String, Object>();
			
			//add download folder preference
			prefs.put("download.default_directory", defaultdownloadpath + "\\CHROME");
			//add preference for download notification								
			prefs.put("download.prompt_for_download", "false");
			
			//Disable pdf plugin to enable download of PDF file instead of opening inside browser
			HashMap<String, Object> plugin = new HashMap<String, Object>();
			plugin.put("enabled", false);
			plugin.put("name", "Chrome PDF Viewer");
			prefs.put("plugins.plugins_list", Arrays.asList(plugin));
			
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.setExperimentalOption("prefs", prefs);
		}
		
		finalCapabilities = new DesiredCapabilities();
		finalCapabilities.setBrowserName("chrome");
		finalCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		finalCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE); //To not DISMISS alerts generated. Should be handled by user
		if (dVersion != null) {
			finalCapabilities.setVersion(dVersion);
		}
		

	}

	public static String getOS() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}
	}

	/**
	 * Reads the configurations from the default properties file
	 * 
	 * @return PropertyReader
	 * @throws IOException
	 */
	private void loadProperties() throws IOException {
		PropertyReader.ValueMap("Configuration.properties");
	}

}
