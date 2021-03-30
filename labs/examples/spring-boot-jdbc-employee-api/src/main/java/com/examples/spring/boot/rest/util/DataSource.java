package com.examples.spring.boot.rest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DataSource {

	// JDBC driver name and database URL
	private String driverName = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost/empapp";

	// Database credentials
	private String userName = "training";
	private String password = "training";

	private Connection conn;

	public Connection getConnection(){

		try {
			if (conn == null) {
				// Load db driver
				loadDriver();

				System.out.println("Creating connection to databse - " + dbUrl);
				// Open a connection
				conn = DriverManager.getConnection(dbUrl, userName, password);
				// Uncomment to enable transaction support
				// conn.setAutoCommit(false);
				System.out.println("Connection created");
			}
		} catch (Exception e) {
			System.out.println("Error occured while creating connection");
			e.printStackTrace();
		}
		return conn;
	}

	private void loadDriver() throws ClassNotFoundException {
		Class.forName(driverName);
		System.out.println("Database driver loaded.");
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				System.out.println("Closing connection...");
				conn.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
