package com.musicLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicLibrary.Beans.Albums;

public class AlbumDao {
	private static final String GET_ALBUMS = "select * from albums where albumId = ? ";

	public List<Albums> listAlbums(){
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Albums album = null;
		List<Albums> albumList = new ArrayList<Albums>();
		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (connection != null) {
			int startNumber = 1;
			try {
				statement = connection.prepareStatement(GET_ALBUMS);
				while (startNumber < 11) {
					startNumber++;
					statement.setString(1, (startNumber + ""));
					resultSet = statement.executeQuery();
					if (resultSet.next()) {
						album = new Albums();
						album.setAlbumId((null == resultSet.getString("albumId"))? "" : resultSet.getString("albumId"));
						album.setArtistId((null == resultSet.getString("artistId"))? "" : resultSet.getString("artistId"));
						album.setGenreIds((null == resultSet.getString("genreIds"))? "" : resultSet.getString("genreIds"));
						album.setPrice(resultSet.getFloat("price"));
						albumList.add(album);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, resultSet, statement);
			}
		}
		return albumList;
	}
}
