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

public class SearchDao {

	private static final String SEARCH_TRACKS = "select * from tracks where trackId like ? ";
	private static final String SEARCH_ALBUMS = "select * from albums where albumId like ? ";
	//private static final String SEARCH_ARTIST = "select * from artists where artistId like ? ";
	private static final String SEARCH_ARTIST = "SELECT * FROM musiclib.artists where `artists`.` artistId` like ? ";
	//private static final String SEARCH_GENRE = "select * from genre where genreId like ? ";
	private static final String SEARCH_GENRE = "select * from musiclib.genre where `genre`.` genreId`  like ? ";
	
	public List<Tracks> searchtracks(String trackId) {
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

		if (connection != null &&  null != trackId ) {
			try {
				statement = connection.prepareStatement(SEARCH_TRACKS);
					statement.setString(1, (trackId.trim()+"%"));
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						tracks = new Tracks();
						tracks.setTrackId(resultSet.getString("trackId"));
						tracks.setAlbumId((null == resultSet.getString("albumId"))? "" : resultSet.getString("albumId"));
						tracks.setArtistId((null == resultSet.getString("artistId"))? "" : resultSet.getString("artistId"));
						tracks.setGenreIds((null == resultSet.getString("genreIds"))? "" : resultSet.getString("genreIds"));
						tracks.setPrice(resultSet.getFloat("price"));
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
	
	public List<Albums> searchAlbums(String albumId){

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
		if (connection != null && null != albumId ) {
			try {
				statement = connection.prepareStatement(SEARCH_ALBUMS);
				
					statement.setString(1, (albumId.trim()+"%"));
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						album = new Albums();
						album.setAlbumId((null == resultSet.getString("albumId"))? "" : resultSet.getString("albumId"));
						album.setArtistId((null == resultSet.getString("artistId"))? "" : resultSet.getString("artistId"));
						album.setGenreIds((null == resultSet.getString("genreIds"))? "" : resultSet.getString("genreIds"));
						album.setPrice(resultSet.getFloat("price"));
						album.setType("album");
						albumList.add(album);
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, resultSet, statement);
			}
		}
		return albumList;
	}
	
	
	public List<Artists> searchArtist(String artistId){

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
		if (connection != null && null != artistId ) {
			try {
				statement = connection.prepareStatement(SEARCH_ARTIST);
				
					statement.setString(1, (artistId.trim()+"%"));
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						artist = new Artists();
						artist.setArtistId((null == resultSet.getString(1))? "None" : resultSet.getString(1));
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
	

	public List<Genre> searchGenre(String genreId){

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
		if (connection != null && null != genreId ) {
			try {
				statement = connection.prepareStatement(SEARCH_GENRE);
				
					statement.setString(1, (genreId.trim()+"%"));
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						genre = new Genre();
						genre.setGenreId((null == resultSet.getString(1))? "None" : resultSet.getString(1));
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
}
