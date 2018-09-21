package com.markit.DigitalAutomationFramework.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



/**
 * Class for reading Parameters from Excel file
 * @author nishant.thakur
 *
 */

public class DataReader {
	
//	////////---------Variables------------------------------
	protected String filepath;
	protected String sheetName;
	protected String valueColumnName;
	protected int valueColumnNum;
	protected HashMap<String, String> map;
	
//	////------------Constructors------------------------------
	
	
	/**
	 * Constructor Method. 
	 * Takes data file name from Configuration.Properties file's field testDataFilePath. 
	 * Sets the sheet to read from
	 * Cells in First column of the sheet is considered as the parameter Names
	 * Cells in Second column of the sheet is considered as the parameter Values
	 * @param sheetName Sheet name to read data
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public DataReader (String sheetName) throws InvalidFormatException, FileNotFoundException, IOException{
		
		//Configure Property Reader
		PropertyReader prop = new PropertyReader();
		prop.ValueMap("Configuration.properties");
		
		//Get full path of data file
		filepath = System.getProperty("user.dir") +PropertyReader.getFieldValue("testDataFilePath");
		
		//Set sheetname and valueColumnName
		this.sheetName = sheetName;	
		this.valueColumnName = null;	// 2nd column in sheet would be used as value Column by default
		
		//Create HashMap
		setMap ();
	}
	
	/**
	 * Constructor Method. 
	 * Takes data file name from Configuration.Properties file's field testDataFilePath. 
	 * Sets the sheet to read from
	 * Cells in First column of the sheet is considered as the parameter Names
	 * Cells in given column of the sheet is considered as the parameter Values
	 * @param sheetName Sheet name to read data
	 * @param valueColumnName Name of column from which parameters values will be supplied
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public DataReader (String sheetName, String valueColumnName) throws InvalidFormatException, FileNotFoundException, IOException{		
		//Get full path of data file
		filepath = System.getProperty("user.dir") +PropertyReader.getFieldValue("testDataFilePath");
		
		//Set sheetname and valueColumnName
		this.sheetName = sheetName;
		this.valueColumnName = valueColumnName;

		//Create HashMap
		setMap ();
	}

	
//	////------------Methods------------------------------
	
	/**
	 * Returns the full path of current data file
	 * @return	full path of data file. Type - String
	 */
	public String getFilePath (){
		return filepath;
	}
	
	/**
	 * Returns the current sheet name
	 * @return	current sheet name. Type - String
	 */
	public String getSheetName(){
		return sheetName;
	}
	
	/**
	 * Returns the coulumn name from which Parameter values are taken
	 * @return	column name for parameter values. Type - String
	 */
	public String getvalueColumnName(){
		return valueColumnName;
	}
	
	/**
	 * Returns URL for the given environment.
	 * Preconditions:
	 * -excel workbook must have sheet EnvironmentInfo
	 * -sheet EnvironmentInfo must have first column for name of environment and second column for URL 
	 * @param environmentName name of environment
	 * @return URL if environment found, else null. Type - String
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String getURL (String environmentName) throws InvalidFormatException, IOException{
		String url = null;
		
		if (environmentName == null){
			return null;
		}
		else{
			

			//Open data file
			FileInputStream file = new FileInputStream(filepath);
			Workbook book = WorkbookFactory.create(file);
			
			//Set sheet name
			Sheet sheet = book.getSheet("EnvironmentInfo");
			
			//temp variables
			Row row;
			String rowEnvironmentName, rowUrl;
			DataFormatter fmt=new DataFormatter();
			
			//check from first row to Last row with data
			for (int i=1; i<=sheet.getLastRowNum(); i++){
				try{
					//get environment name and URL in the row
					row = sheet.getRow(i);
					rowEnvironmentName = fmt.formatCellValue(row.getCell(0));
					rowUrl = fmt.formatCellValue(row.getCell(1));
				}catch (NullPointerException e){
					continue;	// In case of blank row or cell
				}
				
				//remove preceding and succeeding spaces
				rowEnvironmentName = rowEnvironmentName.trim();
				rowUrl = rowUrl.trim();
				
				//check if right URL found
				if (rowEnvironmentName.contentEquals(environmentName)){
					url = rowUrl;
					break;
				}
				
			}
			
			//close data file
			file.close();
		}
		
		return url;
		
	}
	
	/**
	 * Returns UserName for the given environment and user Type.
	 * Preconditions:
	 * -excel workbook must have sheet UserInfo
	 * -sheet UserInfo must have columns for name of user type, for environment name, username and password. And in that order. 
	 * @param userType name of user type
	 * @param environmentName name of environment
	 * @return UserName if found, else null
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String getUserName (String userType, String environmentName) throws InvalidFormatException, IOException{
		String userName = null;
		
		if (userType == null || environmentName == null){
			
			return null;
		}
		else{
			
			//Open data file
			FileInputStream file = new FileInputStream(filepath);
			Workbook book = WorkbookFactory.create(file);
			
			//Set sheet name
			Sheet sheet = book.getSheet("UserInfo");
			
			//temp variables
			Row row;
			String rowUserType, rowEnvironmentName, rowUserName;
			DataFormatter fmt=new DataFormatter();
			
			//check from first row to Last row with data
			for (int i=1; i<=sheet.getLastRowNum(); i++){
				try{
					//get usertype, environment name and username in the row
					row = sheet.getRow(i);
					rowUserType = fmt.formatCellValue(row.getCell(0));
					rowEnvironmentName = fmt.formatCellValue(row.getCell(1));
					rowUserName = fmt.formatCellValue(row.getCell(2));
				}catch (NullPointerException e){
					continue;	// In case of blank row or cell
				}
				
				//remove preceding and succeeding spaces
				rowUserType = rowUserType.trim();
				rowEnvironmentName = rowEnvironmentName.trim();
				rowUserName = rowUserName.trim();
				
				//check if right username found
				if (rowUserType.contentEquals(userType) && rowEnvironmentName.contentEquals(environmentName)){
					userName = rowUserName;
					break;
				}
				
			}
			
			//close data file
			file.close();
		}
		
		
		return userName;
		
	}
	
	/**
	 * Returns Password for the given environment and user Type.
	 * Preconditions:
	 * -excel workbook must have sheet UserInfo
	 * -sheet UserInfo must have columns for name of user type, for environment name, username and password. And in that order. 
	 * @param userType name of user type
	 * @param environmentName name of environment
	 * @return Password if found, else null
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String getPassword (String userType, String environmentName) throws InvalidFormatException, IOException{
		String password = null;
		
		if (userType == null || environmentName == null){
			return null;
		}
		else{
			//Open data file
			FileInputStream file = new FileInputStream(filepath);
			Workbook book = WorkbookFactory.create(file);
			
			//Set sheet name
			Sheet sheet = book.getSheet("UserInfo");
			
			//temp variables
			Row row;
			String rowUserType, rowEnvironmentName, rowPassword;
			DataFormatter fmt=new DataFormatter();
			
			//check from first row to Last row with data
			for (int i=1; i<=sheet.getLastRowNum(); i++){
				try{
					//get usertype, environment name and password in the row
					row = sheet.getRow(i);
					rowUserType = fmt.formatCellValue(row.getCell(0));
					rowEnvironmentName = fmt.formatCellValue(row.getCell(1));
					rowPassword = fmt.formatCellValue(row.getCell(3));
				}catch (NullPointerException e){
					continue;	// In case of blank row or cell
				}
				
				//remove preceding and succeeding spaces
				rowUserType = rowUserType.trim();
				rowEnvironmentName = rowEnvironmentName.trim();
				rowPassword = rowPassword.trim();
				
				//check if right password found
				if (rowUserType.contentEquals(userType) && rowEnvironmentName.contentEquals(environmentName)){
					password = rowPassword;
					break;
				}
				
			}
			
			//close data file
			file.close();
		}
		
		
		return password;
		
	}
	/**
	 * Set the data sheet to newSheetName
	 * @param newSheetName	Sheet name to read data
	 * @param valueColumnName	Name of column from which parameters values will be supplied
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setSheetName(String newSheetName, String valueColumnName) throws InvalidFormatException, FileNotFoundException, IOException{
		sheetName = newSheetName;
		this.valueColumnName = valueColumnName;
		setMap ();
	}
	
	/**
	 * Sets the column for parameters values
	 * @param valueColumnName Name of column from which parameters values will be supplied
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void setValueColumn (String valueColumnName) throws InvalidFormatException, FileNotFoundException, IOException{
		this.valueColumnName = valueColumnName;
		setMap ();
	}
	
	/**
	 * Creates the Hash Map
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void setMap () throws InvalidFormatException, FileNotFoundException, IOException {
		
		//Initialise Hash Map
		map = new HashMap<String, String>();
		
		//Open data file
		FileInputStream file = new FileInputStream(filepath);
		Workbook book = WorkbookFactory.create(file);
		
		//Set sheet name
		Sheet sheet = book.getSheet(sheetName);
		
		//temp variables
		Row row;
		String v1, v2;
		DataFormatter fmt=new DataFormatter();
		
		//Get the index of first row in the sheet. Starting point of reading the sheet row wise
		row = sheet.getRow(sheet.getFirstRowNum());
		
		//Set valueColumnNum according to the name supplied
		if (valueColumnName != null){
			
			for (int i=1; i<=row.getLastCellNum(); i++ ){
				if (row.getCell(i).toString().contentEquals(valueColumnName)){
					valueColumnNum = i;
					break;
				}
			}
		}
		
		//Set valueColumnNum as 1 (i.e. 2nd Column) in case valueCoulmnName is not supplied
		else
		{
			valueColumnNum = 1;
		}
		
		//Fetch data from sheet. 
		//First Column cells as Keys 
		//Cells in column having index equal to valueColumnNum as Values
		for (int i=0; i<=sheet.getLastRowNum(); i++){
			
			try{
				row = sheet.getRow(i);
				v1 = row.getCell(0).toString();
				v2=fmt.formatCellValue(row.getCell(valueColumnNum));
			}catch (NullPointerException e){
				continue;
			}
			
			v1 = v1.trim();
			v2 = v2.trim();
			
			map.put(v1,v2);
		}
		

		file.close();
	}
	
	/**
	 * Returns value for given parameter name
	 * @param name	name of parameter
	 * @return value of parameter if it is found in HashMap. Otherwise returns null. Type - String
	 */
	public String getValue(String name){

		return map.get(name);
		
	}
	
	/**
	 * Clears all data from Hash Map
	 */
	public void clearAll (){
		map.clear();
	}
	
	
}
