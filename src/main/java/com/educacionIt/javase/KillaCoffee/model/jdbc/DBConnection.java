package com.educacionIt.javase.KillaCoffee.model.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static DBConnection instance = null;
	private Connection connection = null;
	private DBConnection() {
	
}
	
	private void init() throws SQLException {
		Properties dbProperties = new Properties();
		InputStream properties = getClass().getClassLoader().getResourceAsStream("database.properties");
		try {
			dbProperties.load(properties);
			String driver = dbProperties.getProperty("db.driver");
			String url = dbProperties.getProperty("db.url");
			String user = dbProperties.getProperty("db.user");
			String password = dbProperties.getProperty("db.password");
			Class.forName(driver);
			connection = DriverManager.getConnection(url,user,password);
		} catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		return connection;
	}
	
	public static Connection getInstance() throws SQLException{
		if(instance == null || instance.getConnection() == null || instance.getConnection().isClosed()) {
			instance = new DBConnection();
			instance.init();
		}
		return instance.getConnection();
	}
}
