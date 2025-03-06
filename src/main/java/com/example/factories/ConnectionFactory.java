package com.example.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			
			var host = "jdbc:postgresql://localhost:5437/apiTurmas";
			var user = "admin";
			var pass = "admin";
			
			return DriverManager.getConnection(host, user, pass);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
