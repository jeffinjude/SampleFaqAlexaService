package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnector {
	
	// Database credentials
	// TODO : move to properties file
	static final String USER = "root";
	static final String PASS = "root";
	static final String IP_ADDR = "localhost";
		
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://"+IP_ADDR+"/samplefaq";

	static Connection conn = null;
	
	public static Connection getConnection()
	{
		// Register JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		// Open a connection
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
