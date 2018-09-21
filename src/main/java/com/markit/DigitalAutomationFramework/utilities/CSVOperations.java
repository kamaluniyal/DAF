package com.markit.DigitalAutomationFramework.utilities;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.ResultSetHelper;
import com.opencsv.ResultSetHelperService;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Provides standard methods to interact with CSV files Please call saveCSV
 * method to commit all changes
 * 
 * @author sambhav.chawla
 *
 */
public class CSVOperations {
	/**
	 * Location of CSV file
	 */
	private String location;

	/**
	 * Delimiter being used
	 */
	private char delimiter = CSVParser.DEFAULT_QUOTE_CHARACTER;

	/**
	 * List of String array to store complete CSV
	 */
	private List<String[]> content = new ArrayList<String[]>();

	/**
	 * Global writer object
	 */
	private CSVWriter writer;

	/**
	 * Global Reader Object
	 */
	private CSVReader reader;

	/**
	 * Pass location and delimiter used
	 * 
	 * @param location
	 *            of CSV File
	 * @param delimiter
	 *            Used
	 * @throws IOException
	 */
	public CSVOperations(String location, String delimiter) throws IOException {
		this.location = location;
		this.delimiter = delimiter.charAt(0);
		try {
			reader = new CSVReader(new FileReader(location), this.delimiter);
			storeCSVInArray();
			reader.close();
			reader = new CSVReader(new FileReader(location), this.delimiter);
		} catch (FileNotFoundException f) {
		}
	}

	/**
	 * Stores CSV into List of array string
	 * 
	 * @throws IOException
	 */
	private void storeCSVInArray() throws IOException {
		content = reader.readAll();
	}

	/**
	 * Pass location of file Delimiter assumed to be comma
	 * 
	 * @param location
	 * @throws IOException
	 */
	public CSVOperations(String location) throws IOException {
		this.location = location;
		try {
			reader = new CSVReader(new FileReader(location));
			storeCSVInArray();
			reader.close();
			reader = new CSVReader(new FileReader(location));
		} catch (FileNotFoundException f) {
		}
	}

	/**
	 * Pass a custom reader and writer
	 * 
	 * @param customReader
	 *            CSVReader object
	 * @param customWriter
	 *            CSVWriter object
	 * @throws IOException
	 */
	public CSVOperations(CSVReader customReader, CSVWriter customWriter) throws IOException {
		reader = customReader;
		storeCSVInArray();
		reader.close();
		reader = customReader;
		writer = customWriter;
	}

	/**
	 * Count number of records in CSV file
	 * 
	 * @param countFirstRow
	 *            true if first rows should be counted, false otherwise
	 * @return number of records
	 * @throws IOException
	 */
	public int countRows(boolean countFirstRow) throws IOException {
		if (countFirstRow) {
			return this.content.size();
		} else {
			return this.content.size() - 1;
		}
	}

	/**
	 * Returns number of columns present in a csv file by looking at the first
	 * row only
	 * 
	 * @return int Number of Columns
	 * @throws IOException
	 */
	public int countCols() throws IOException {
		return this.content.get(0).length;
	}

	/**
	 * Returns the full contents of the CSV file
	 * 
	 * @return An array list of strings that contain the full contents of the
	 *         file
	 * @throws IOException
	 * 
	 */
	public List<String[]> readAllFromCSV() throws IOException {
		return content;
	}

	/**
	 * Returns the specified row from the CSV file
	 * 
	 * @param rowNum
	 *            The row number to return
	 * @return The Row as an String []
	 * @throws IOException
	 */
	public String[] readFromCSV(int rowNum) throws IOException {
		return content.get(rowNum);
	}

	/**
	 * Returns specified row and column of CSV file.
	 * 
	 * @param rowNum
	 *            Row number requested.M
	 * @param colNum
	 *            Column number requested.
	 * @return String The contents of the cell
	 * @throws IOException
	 */

	public String readFromCSV(int rowNum, int colNum) throws IOException {
		String[] row = readFromCSV(rowNum);
		return row[colNum];
	}

	/**
	 * Creates a new file with the specified header row
	 * 
	 * @param header
	 *            The header row for the CSV file
	 * @throws IOException
	 * @deprecated - Use proper constructor
	 */
	public void createCSVfile(String[] header) throws IOException {
		clearCSVFile();
		appendRow(header);
		saveCSV();
	}

	/**
	 * Creates a new file with the specified header row and gives time-stamp to
	 * the file if appendTimestamp is true.
	 * 
	 * @param header
	 *            The header row for the CSV file
	 * @param appendTimestamp
	 *            append time stamp to file name if true.
	 * @return String file name
	 * @throws IOException
	 * @deprecated use proper constructor
	 */
	public String createCSVfile(String[] header, boolean appendTimestamp) throws IOException {
		String fileName = null;
		if (appendTimestamp == true) {
			Date d = new Date();
			SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmSS");
			String date = time.format(d);
			fileName = location + "_" + date + ".csv";
			writer = new CSVWriter(new FileWriter(fileName), delimiter);
		} else {
			writer = new CSVWriter(new FileWriter(location), delimiter);
		}
		writer.writeNext(header, false);
		writer.flush();
		return fileName;
	}

	/**
	 * Adds a new row to the end of the existing CSV file
	 * 
	 * @param newRow
	 *            - The row to be added to the file
	 * @throws IOException
	 */
	public void appendRow(String[] newRow) throws IOException {
		content.add(newRow);
	}

	/**
	 * Inserts a new row into the CSV file.
	 * 
	 * @param rowNum
	 *            - Row number where new row is required to be added.
	 * @param testRow
	 *            - The Row of data to be added
	 * @throws IOException
	 */
	public void insertRow(int rowNum, String[] rowData) throws IOException {
		content.add(rowNum, rowData);
	}

	/**
	 * Replaces an existing row with the specified data
	 * 
	 * @param rowNum
	 *            Row number where new row is required to be replaced.
	 * @param rowData
	 *            The Row of data to be added
	 * @throws IOException
	 */
	public void replaceRow(int rowNum, String[] rowData) throws IOException {
		content.set(rowNum, rowData);
	}

	/**
	 * Deletes a row from the CSV file
	 * 
	 * @param rowNum
	 *            row to be deleted
	 * @throws IOException
	 */
	public void deleteRow(int rowNum) throws IOException {
		content.remove(rowNum);
	}

	/**
	 * Updates requested cell of CSV file.
	 * 
	 * @param rowNum
	 *            Row number requested.
	 * @param colNum
	 *            Column number requested.
	 * @param data
	 *            Data to be inserted at requested cell.
	 * @throws IOException
	 */
	public void writeToCell(int rowNum, int colNum, String data) throws IOException {
		content.get(rowNum)[colNum] = data;
	}

	/**
	 * Writes result set to CSV file
	 * 
	 * @param resultSet
	 *            to be written
	 * @param includeColumnNames
	 *            true if column headers should be written, false otherwise
	 * @throws SQLException
	 * @throws IOException
	 */
	public void retrieveResultSet(ResultSet resultSet, boolean includeColumnNames) throws SQLException, IOException {
		content.addAll(resultSetToList(resultSet, includeColumnNames));
	}

	/**
	 * Returns contents of result set in a list
	 * 
	 * @param resultSet
	 *            to get
	 * @param includeColumnNames
	 *            true if columns names should be included, false otherwise
	 * @return List<String[]> with contents of result set
	 * @throws SQLException
	 * @throws IOException
	 */
	private List<String[]> resultSetToList(ResultSet resultSet, boolean includeColumnNames)
			throws SQLException, IOException {
		List<String[]> tempCSVList = new ArrayList<String[]>();
		if (!includeColumnNames) {
			resultSet.next();
		}
		ResultSetHelper resultService = new ResultSetHelperService();
		while (resultSet.next()) {
			tempCSVList.add(resultService.getColumnValues(resultSet, true));
		}
		return tempCSVList;
	}

	/**
	 * Clears content of CSV File
	 */
	public void clearCSVFile() {
		this.content.clear();
	}

	/**
	 * Saves changes made to CSV file
	 * 
	 * @throws IOException
	 */
	public void saveCSV() throws IOException {
		writer = new CSVWriter(new FileWriter(location, false), this.delimiter);
		writer.writeAll(content, false);
		writer.flush();
	}

	/**
	 * Closes CSV object
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (writer != null) {
			writer.close();
		}
		if (reader != null) {
			reader.close();
		}
	}
}