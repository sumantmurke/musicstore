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


public class Cart_purchaseDao {
	private static final String INSERT_ITEMS_cart = "insert into cart_purchase (userid , itemId, itemType, price) values (?, ?, ?, ?)";
	private static final String GET_cart = "select * from cart_purchase where userid = ? and isPurchased=0";
	private static final String PURCHASE_cart = "update cart_purchase  SET isPurchased=1 where userid = ?";
	private static final String REMOVE_FROM_cart = "delete from cart_purchase  where userid = ? and itemId = ?";
	//private static final String GET_ALBUMS_RATED = "select * from itemsLiked where userid = ? and type='album'";

	
	
	public boolean removeItemFromCart(long userid, String itemId) {
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
				statement = connection.prepareStatement(REMOVE_FROM_cart);
				statement.setLong(1, userid);
				statement.setString(2, itemId);
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


	public boolean purchaseCart( long userid ) {
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
				statement = connection.prepareStatement(PURCHASE_cart);
				statement.setLong(1, userid);
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


	
	public boolean insertItemIntoCart(long userid, String itemId, String itemType, double price) {
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
				statement = connection.prepareStatement(INSERT_ITEMS_cart);
				statement.setLong(1, userid);
				statement.setString(2, itemId);
				statement.setString(3, itemType);
				statement.setDouble(4, price);
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


	public List<Item_purchase> getCart(long userId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Item_purchase item = null;
		List<Item_purchase> itemList = new ArrayList<Item_purchase>();

		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (connection != null && 0 != userId) {
			try {
				statement = connection.prepareStatement(GET_cart);
				statement.setLong(1, userId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					item = new Item_purchase();
					item.setItemId(resultSet.getString("itemId"));
					item.setItemType(resultSet.getString("itemType"));
					item.setPrice(resultSet.getFloat("price"));
					itemList.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, resultSet, statement);
			}
		}
		return itemList;
	}
}

/*
public List<Tracks> searchLikedTracks(String userId) {
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	Connection connection = null;
	Tracks tracks = null;
	List<Tracks> tracksList = new ArrayList<Tracks>();

	try {
		connection = DatabaseConnection.getConnection();
	} catch (Exception e1) {
		e1.printStackTrace();
	}

	if (connection != null && null != userId) {
		try {
			statement = connection.prepareStatement(GET_TRACKS_RATED);
			statement.setString(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tracks = new Tracks();
				tracks.setTrackId(resultSet.getString("itemid"));
				tracks.setRating(resultSet.getString("rating"));
				tracks.setType("track");
				tracksList.add(tracks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeAllDb(connection, resultSet, statement);
		}
	}
	return tracksList;
}*/