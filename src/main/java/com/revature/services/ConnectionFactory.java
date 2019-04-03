package com.revature.services;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static final String PROPERTIES_FILE = "database.properties";
	private static String user;
	private static String password;
	private static String url;
	private static ConnectionFactory cf;
	
	public static Connection getConnection(){
		
		if (cf == null){
			cf = new ConnectionFactory();
		}
		
		return cf.createConnection();
		
	}
	
	private ConnectionFactory(){
		//private constructor makes this a singleton
		Properties prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try (InputStream file = classLoader.getResourceAsStream(PROPERTIES_FILE);){
			prop.load(file);
			url = prop.getProperty("url");
			user = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection createConnection(){
		Connection conn = null;
		
		try{
			DriverManager.registerDriver(new org.postgresql.Driver());
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("Issue connecting with DB");
		}
		
		return conn;
	}

}

