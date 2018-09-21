package com.markit.DigitalAutomationFramework.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * A class for retrieving configuration details from the properties file
 * 
 * @author stuart.rogers
 * @version 1.0
 * @since 2015-07-27
 *
 */
public class PropertyReader {

	/**
	 * Used to load the properties into
	 */
	private static Properties ValueMap = new Properties();
	/**
	 * Creating a new log instance for the PropertyReader class
	 */
	private static Logger log = Logger.getLogger(PropertyReader.class);

	/**
	 * Opens the specified file name and loads the properties within into the
	 * ValueMap
	 * 
	 * @param filename
	 *            The full path as a String for the method to open
	 * @throws IOException
	 *             Thrown if the file can not be located
	 */
	public static void ValueMap(String filename) throws IOException {
		DOMConfigurator.configure("log4j.xml");
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(filename);		
		ValueMap.load(inputStream);
		inputStream.close();
	}

	/**Looks into Configuration.properties in resources folder for properties by default unless 
	 * supplied in propertyFileName property
	 * @param fieldName name of property that is required
	 * @param propertyFileName optional parameter
	 * @return value of property in String if given, null if property is not present
	 */
	public static String getFieldValue(String fieldName) {
		try {
			ValueMap("Configuration.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Field Name Received is: " + fieldName);
		String fieldValue = ValueMap.getProperty(fieldName);
		log.info("Field Name Value get from configuration Properties file is: "+ fieldValue);
		return fieldValue;
	}
	
	
	/**Looks into Configuration.properties in resources folder for properties by default unless 
	 * supplied in propertyFileName property
	 * @param fieldName name of property that is required
	 * @param propertyFileName optional parameter
	 * @return value of property in String if given, null if property is not present
	 */
	public static String getFieldValue(String fieldName, String propertyFileName) {
		try {
			ValueMap(propertyFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Field Name Received is: " + fieldName);
		String fieldValue = ValueMap.getProperty(fieldName);
		log.info("Field Name Value get from configuration Properties file is: "+ fieldValue);
		if (fieldValue.equals("")) {
			//Assert.fail("Incorrect parameter ("+ fieldName+ ") was supplied for retrieval from config, failing the test");
			log.error("Incorrect parameter ("+ fieldName+ ") was supplied for retrieval from config);");
			return null;
		}
		return fieldValue;
	}
	
	
	/**Sets value for any field in Configuration.properties
	 * @param fieldName name of property that needs to be set
	 * @param fieldValue value to be set
	 */
	public static void setFieldValue(String fieldName, String fieldValue) {
		log.info("Field Name Received is: " + fieldName);
		ValueMap.setProperty(fieldName, fieldValue);
		log.info("Field Name Value to be set in configuration Properties file is: "+ fieldValue);
	}

}
