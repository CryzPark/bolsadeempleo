package com.cibtf.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public static Connection getConnection() {
		
		/*
		String urlServidor = "jdbc:mysql://uoakzbmtlqp1pzdc:ru45onnAnWH7Y7mDQlXR@buumtfkxieeiiotbck4i-mysql.services.clever-cloud.com:3306/buumtfkxieeiiotbck4i";
		String user = "uoakzbmtlqp1pzdc";
		String password = "ru45onnAnWH7Y7mDQlXR";
		*/
		
		String urlServidor = "jdbc:mysql://72.167.220.48:3306/bolsadee_maindb";
		String user = "bolsadee_bolsadee";
		String password = "Ad(lhTEY38kU";
		
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor,user,password);
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return conn;
	}

	
}
