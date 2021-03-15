package com.examples.java.jdbc;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;

public class JdbcWithRowSetEx {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		RowSet rs = null;

		try {
//			// STEP 2: [OPTIONAL] Register JDBC driver with Driver Manager
//			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("MySQL driver registered...");
			
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true); // enable transaction

			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			System.out.println("Creating RowSet...");
			
			// JDBC RowSet
			rs = new JdbcRowSetImpl(conn);
			
			// Cached RowSet
//			rs = new CachedRowSetImpl();
//			rs.setUrl(DB_URL);
//			rs.setUsername("training");
//			rs.setPassword("training");
			
			String sql = "SELECT * FROM employee";
			rs.setCommand(sql);
			rs.execute();
			
			// STEP 5: Extract data from RowSet
			ResultSetMetaData rsmeta = rs.getMetaData();
			int cols = rsmeta.getColumnCount();

			// Header
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i));
			}
			System.out.println();			
			
			while (rs.next()) {
			    // each call to next, generates a cursorMoved event
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
			    
				// Display values
				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
			}
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {}
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqle) {}			
		} finally {
			// finally block used to close resources
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end FirstExample