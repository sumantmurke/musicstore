package com.musicLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.musicLibrary.Beans.User;

public class UserDB {
	private static final String GET_USER = "SELECT ID, first_name, last_name  FROM user_details WHERE email= ? AND pwd = ? ";

	public User loginCheck(String email, String password) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		int userId = -1;
		String lastName = null;
		String firstName = null;

		User user = null;

		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (connection != null) {
			try {
				statement = connection.prepareStatement(GET_USER);
				statement.setString(1, email);
				statement.setString(2, password);
				resultSet = statement.executeQuery();
				if (resultSet.next()) {
					userId = resultSet.getInt("id");
					firstName = resultSet.getString("first_name");
					lastName = resultSet.getString("last_name");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, resultSet, statement);
			}
		}
		if (userId > -1) {
			System.out.println("got user");
			user = new User(userId, firstName, lastName);
		}
		return user;
	}

}
