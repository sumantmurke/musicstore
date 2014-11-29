package com.musicLibrary.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB {
	private static String connectionString = "jdbc:mysql://127.0.0.1:3306/musicLibrary";
	private static String dbUsername = "root";
	private static String dbPassword = "root";
	
	public static boolean loginCheck(String username, String password){
	    String query;
	    boolean login = false;
	    System.out.println("inside login check");

	    try {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con = DriverManager.getConnection(connectionString, dbUsername, dbPassword);
	        Statement stmt = (Statement) con.createStatement();
	        query = "SELECT email, password FROM user_details WHERE email='" + username + "' AND password='" + password + "';";
	        System.out.println("username"+username+"pwd"+password);
	        stmt.executeQuery(query);
	        ResultSet rs = stmt.getResultSet();
	        login = rs.first(); //rs.first();
	        con.close();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return login;
	}
	
	
	


}
