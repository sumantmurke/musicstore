package com.musicLibrary.Dao;

//import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

	private static String connectionString = "jdbc:mysql://127.0.0.1:3306/musicLibrary";
	private static String dbUsername = "root";
	private static String dbPassword = "Janataraja-384";

	public static Connection getConnection() throws Exception {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionString, dbUsername,
				dbPassword);
		if (connection == null) {
			throw new Exception("Null database connection");
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeAllDb(Connection connection, ResultSet resultSet, PreparedStatement statement) {
		if (connection!= null) {
			closeConnection(connection);
		}
		if (resultSet!= null) {
			closeResultSet(resultSet);
		}
		if (statement!= null) {
			closePreparedStatement(statement);
		}
	}
}