package com.musicLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicLibrary.Beans.Albums;
import com.musicLibrary.Beans.Item_purchase;
import com.musicLibrary.Beans.Tracks;


public class TransactionDao {
	private static final String INSERT_TRANSACTION = "insert into transaction (userId , ccNumber, total) values (?, ?, ?)";
	//private static final String GET_cart = "select * from cart_purchase where userid = ? and isPurchased=0";
	//private static final String GET_ALBUMS_RATED = "select * from itemsLiked where userid = ? and type='album'";

	public boolean insertTransaction(String userid, String ccNumber, double total) {
		PreparedStatement statement = null;
		Connection connection = null;
		boolean isInserted = true;
		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (connection != null) {
			try {
				statement = connection.prepareStatement(INSERT_TRANSACTION);
				statement.setString(1, userid);
				statement.setString(2, ccNumber);
				statement.setDouble(4, total);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				isInserted = false;
			} finally {
				DatabaseConnection.closeAllDb(connection, null, statement);
			}
		}
		return isInserted;
	}
}