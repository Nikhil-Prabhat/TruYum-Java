package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHandler {

	public static Connection getConnection() {
		Connection con = null;
		Properties property = null;

		try {
			FileInputStream file = new FileInputStream("connection.properties");
			property = new Properties();
			property.load(file);
			Class.forName(property.getProperty("driver"));
			con = DriverManager.getConnection(property.getProperty("connection-url"), property.getProperty("user"),
					property.getProperty("password"));
			System.out.println("Connection established successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
