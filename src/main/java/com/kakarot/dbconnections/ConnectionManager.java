package com.kakarot.dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static ConnectionManager instance;
	private Connection con;

	private ConnectionManager() throws ClassNotFoundException, SQLException {
		final String username = System.getenv("db.password");
		final String password= System.getenv("db.username");
		final String url = System.getenv("db.url");
		
		final String driver = System.getenv("db.driver");
		Class.forName(driver);
		
		con = DriverManager.getConnection(url, username, password);
	}

	public static ConnectionManager getConnectionManager() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new ConnectionManager();

		return instance;
	}

	public Statement getStatement() throws SQLException {
		return con.createStatement();
	}

}
