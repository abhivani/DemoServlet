package com.amstech.inc.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DButils {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306";
	private static final String DB_NAME = "/demo?SSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	// Create a Connection
	public static Connection getConnection() throws Exception {
		Connection connection = null;
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL + DB_NAME, USERNAME, PASSWORD);
		System.out.println("MSG");
		System.out.println("connected Sucessfull");

		return connection;
	}

	// Close Connection
	public static void close(Connection connection, PreparedStatement pstmt, ResultSet rs) throws Exception {
		if (connection != null)
			connection.close();
		if (pstmt != null)
			pstmt.close();
		if (rs != null)
			rs.close();
		System.out.println("Connection Closed !!!");
	}

	// Testing With Main
	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
			close(null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
