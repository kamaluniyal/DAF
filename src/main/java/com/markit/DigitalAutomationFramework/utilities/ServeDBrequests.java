package com.markit.DigitalAutomationFramework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Provides method to connect to MSSQL , Oracle and MySQL database and fire queries
 * calling stored procedure is not supported. 
 * @author sambhav.chawla
 *
 */
public class ServeDBrequests {
   	
   	public enum ConnectionType{
   		/**
   		 * JDBC driver name for MySQL
   		 */
   		JDBC_Driver_MySQL("com.mysql.jdbc.Driver"),
   		/**
   		 * JDBC driver name for Oracle
   		 */
   		JDBC_Driver_Oracle("oracle.jdbc.driver.OracleDriver"),
   		/**
   		 * JDBC driver name for MSSQL
   		 */
   		JDBC_Driver_MSSQL("com.microsoft.sqlserver.jdbc.SQLServerDriver");   		
		
   		/**
   		 * value of connection object
   		 */
   		private String value;   	   	
   	   	
   		
   		/**Constructor for enumeration
   		 * @param valueDriver class driver value
   		 */
   		ConnectionType(String valueDriver){
   	   		this.value = valueDriver;
   	   	}
	}
   	   	
   	/**
   	 * class driver
   	 */
   	private String connectionType;
   	
   	/**
   	 * username to login
   	 */
   	private String username;
   	
   	/**
   	 * password to login
   	 */
   	private String password;
   		
	
	/**
	 *Connection object used for executions 
	 */
	private Connection connectionObject = null;
	
	/**
	 * Query to execute
	 */
	private PreparedStatement query;
	
	/**Constructor | initialises URL, user credential values.
	 * 
	 * @param url	URL of the database location.
	 * @param uname	Username
	 * @param pword	Password
	 * @deprecated Use ConnectionType Constructor
	 */
	public ServeDBrequests(String url, String uname, String pword){
		username = uname;
		password = pword;
		connectionType = url;		
	}
	
	/**Connects to database and initialises connection object for use
	 * @param connectionType Enumeration for Oracle , MSSQL or MySQL
	 * @param server on which database is located
	 * @param username for connection
	 * @param password for connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ServeDBrequests(ConnectionType connectionType, String server , String username, String password) throws ClassNotFoundException, SQLException{	
		if(connectionType == ConnectionType.JDBC_Driver_MSSQL){
			this.connectionObject = connectMSSQL(connectionType.value, server, username, password);
		}
	}
	
	/**Connects to database and initialises connection object for use
	 * @param connectionType Enumeration for Oracle , MSSQL or MySQL
	 * @param server on which database is located
	 * @param databaseName to connect to
	 * @param username for connection
	 * @param password for connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ServeDBrequests(ConnectionType connectionType, String server ,String databaseName, String username, String password) throws ClassNotFoundException, SQLException{	
		if(connectionType == ConnectionType.JDBC_Driver_MSSQL){
			this.connectionObject = connectMSSQL(connectionType.value, server,databaseName, username, password);
		}
		
		if(connectionType == ConnectionType.JDBC_Driver_Oracle){
			this.connectionObject = connectOracle(connectionType.value, server,databaseName, username, password);
		}
		
		if(connectionType == ConnectionType.JDBC_Driver_MySQL){
			this.connectionObject = connectMySQL(connectionType.value, server, databaseName, username, password);
		}
	}
		
	 
	/**Connects to database and initialises connection object for use
	 * User can supply complete connection string
	 * @param connectionType Enumeration for Oracle , MSSQL or MySQL
	 * @param connectionString on which database is located
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ServeDBrequests(ConnectionType connectionType, String connectionString) throws ClassNotFoundException, SQLException{
		if(connectionType == ConnectionType.JDBC_Driver_MSSQL){
			this.connectionObject = connectMSSQL(connectionType.value,connectionString);
		}	
		
		if(connectionType == ConnectionType.JDBC_Driver_Oracle){
			this.connectionObject = connectOracle(connectionType.value,connectionString);
		}	
		
		if(connectionType == ConnectionType.JDBC_Driver_MySQL){
			this.connectionObject = connectMySQL(connectionType.value,connectionString);
		}	
	}
	
	/**Connects to database and initialises connection object for use
	 * Please use MSSQL driver only
	 * Provides connection to local object
	 * @param connectionType JDBC_Driver_MSSQL
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ServeDBrequests(ConnectionType connectionType) throws ClassNotFoundException, SQLException{
		if(connectionType == ConnectionType.JDBC_Driver_MSSQL){
			this.connectionObject = connectMSSQL(connectionType.value);
		}
	}
	
	
	/**Connects to MySQL and returns connection object
	 * @param connectionType driver class
	 * @param server name
	 * @param databaseName to connect to
	 * @param username
	 * @param password
	 * @return Connection object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private Connection connectMySQL(String connectionType, String server, String databaseName, String username, String password) throws SQLException, ClassNotFoundException{
		String connectionString = "jdbc:mysql://"+server+":3306/"+databaseName;
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(connectionString, username, password);
		return conn;		
	}
	
	/**Connects to MySQL database by providing driver class and connection string
	 * @param connectionType driver class
	 * @param connectionString
	 * @return Connection Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connectMySQL(String connectionType, String connectionString) throws ClassNotFoundException, SQLException{
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(connectionString);
		return conn;
	}	
	
	/**Connects to MSSQL database
	 * @param connectionType driver class
	 * @param server name
	 * @param databaseName to connect to
	 * @param username
	 * @param password
	 * @return Connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connectMSSQL(String connectionType, String server, String databaseName, String username, String password) throws ClassNotFoundException, SQLException{
		String url = "jdbc:sqlserver://"+server+"\\MSSQLSERVER:1433;integratedSecurity=false;databaseName="+databaseName;
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	/**Connects to MSSQL database.
	 * Just server name can be provided and database name can be provided in queries
	 * @param connectionType driver class
	 * @param server
	 * @param username
	 * @param password
	 * @return Connection Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connectMSSQL(String connectionType, String server, String username, String password) throws ClassNotFoundException, SQLException{
		String url = "jdbc:sqlserver://"+server+"\\MSSQLSERVER:1433;integratedSecurity=false";
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	/**Connects to MSSQL database
	 * Connection type and connection string can be provided
	 * @param connectionType driver class
	 * @param connectionString containing server, username, password, etc
	 * @return Connection Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connectMSSQL(String connectionType, String connectionString) throws ClassNotFoundException, SQLException{
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(connectionString);
		return conn;
	}
	
	/**Connects to local MSSQL database by providing driver class
	 * @param connectionType driver class
	 * @return Connection Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connectMSSQL(String connectionType) throws ClassNotFoundException, SQLException{		
		String connectionString = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;integratedSecurity=true";
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(connectionString);
		return conn;
	}
	
	
	
	
	/**Connects to Oracle database
	 * @param connectionType driver class
	 * @param server name
	 * @param databaseName to connect to
	 * @param username
	 * @param password
	 * @return Connection Object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connectOracle(String connectionType, String server,String databaseName, String username, String password) throws ClassNotFoundException, SQLException{
		String url = "jdbc:oracle:thin:@"+server+":1521/"+databaseName;
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	/**Connects to Oracle database by providing driver class and connection string
	 * @param connectionType
	 * @param connectionString
	 * @return Connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection connectOracle(String connectionType, String connectionString) throws ClassNotFoundException, SQLException{
		Class.forName(connectionType);
		Connection conn = DriverManager.getConnection(connectionString);
		return conn;
	}
	
	
	/**
	 * sets up connection and opens it
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @deprecated Use proper Constructor
	 */
	public void setConnection(String JDBC_DRIVER) throws ClassNotFoundException, SQLException{		
		Class.forName(JDBC_DRIVER);								//registering JDBC driver
		connectionObject = DriverManager.getConnection(connectionType, username, password);	//opening connection
	}
	
	/**executes supplied query and sets it as gloal query
	 * @param query to execute
	 * @return Result Set after execution
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException{
		this.query = connectionObject.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);		//creating statement
		ResultSet rs = this.query.executeQuery();		//execute query
		return rs;			
	}
	
	/**Executes set global query
	 * @return	Result Set after executing query
	 * @throws SQLException
	 */
	public ResultSet executeQuery() throws SQLException	{
		ResultSet rs = this.query.executeQuery();
		return rs;
	}
	
	/**Sets the global query object
	 * @param query query to execute
	 * @throws SQLException
	 */
	public void setQuery(String query) throws SQLException{
		this.query = connectionObject.prepareStatement(query);
	}	
	
		
	/**
	 * closes connection to database 
	 * @throws SQLException 
	 */
	public void closeConnection() throws SQLException{
		connectionObject.close();		
	}

	/**Returns current connection object
	 * @return Connection Object
	 */
	public Connection getConnectionObject() {
		return connectionObject;
	}

	/**Sets connection object
	 * @param connectionObject Custom connection object
	 */
	public void setConnectionObject(Connection connectionObject) {
		this.connectionObject = connectionObject;
	}
}
