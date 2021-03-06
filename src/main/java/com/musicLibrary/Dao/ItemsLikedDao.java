package com.musicLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicLibrary.Beans.Albums;
import com.musicLibrary.Beans.Artists;
import com.musicLibrary.Beans.Genre;
import com.musicLibrary.Beans.Tracks;

public class ItemsLikedDao {
	private static final String INSERT_ITEMS = "insert into itemLiked (userid, itemid, rating, type) values (?, ?, ?, ?)";
	private static final String GET_TRACKS_RATED = "select * from itemLiked where userid = ? and type='track'";
	private static final String GET_ALBUMS_RATED = "select * from itemLiked where userid = ? and type='album'";
	private static final String GET_ARTIST_RATED = "select * from itemLiked where userid = ? and type='artist'";
	private static final String GET_GENRE_RATED = "select * from itemLiked where userid = ? and type='genre'";

	public List<Artists> searchLikedArtist(String userId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Artists artist = null;
		List<Artists> artistList = new ArrayList<Artists>();
		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (connection != null && null != userId) {
			try {
				statement = connection.prepareStatement(GET_ARTIST_RATED);
				statement.setString(1, userId.trim());
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					artist = new Artists();
					artist.setArtistId((null == resultSet.getString("itemid")) ? "None"
							: resultSet.getString("itemid"));
					artist.setRating(resultSet.getString("rating"));
					artist.setType("artist");
					artistList.add(artist);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, resultSet, statement);
			}
		}
		return artistList;
	}

	public List<Genre> searchLikedGenre(String userId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Genre genre = null;
		List<Genre> genreList = new ArrayList<Genre>();
		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (connection != null && null != userId) {
			try {
				statement = connection.prepareStatement(GET_GENRE_RATED);

				statement.setString(1, userId.trim());
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					genre = new Genre();
					genre.setGenreId((null == resultSet.getString("itemid")) ? "None"
							: resultSet.getString("itemid"));
					genre.setRating(resultSet.getString("rating"));
					genre.setType("genre");
					genreList.add(genre);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, resultSet, statement);
			}
		}
		return genreList;
	}

	public boolean insertLikedRecord(String userid, String itemId,
			String rating, String type) {
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
				statement = connection.prepareStatement(INSERT_ITEMS);
				statement.setString(1, userid);
				statement.setString(2, itemId);
				statement.setString(3, rating);
				statement.setString(4, type);
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
	}

	public List<Albums> searchLikedAlbums(String userId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Albums album = null;
		List<Albums> albumsList = new ArrayList<Albums>();

		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (connection != null && null != userId) {
			try {
				statement = connection.prepareStatement(GET_ALBUMS_RATED);
				statement.setString(1, userId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					album = new Albums();
					album.setAlbumId(resultSet.getString("itemid"));
					album.setRating(resultSet.getString("rating"));
					album.setType("album");
					albumsList.add(album);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, resultSet, statement);
			}
		}
		return albumsList;
	}
}
