package com.musicLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.musicLibrary.Beans.Tracks;

public class TrackDao {
	private static final String GET_TRACKS = "select * from tracks where trackId = ? ";

	public List<Tracks> listTracks() {
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

		if (connection != null) {
			int startNumber = 1;
			try {
				statement = connection.prepareStatement(GET_TRACKS);
				while (startNumber < 11) {
					startNumber++;
					statement.setString(1, (startNumber + ""));
					resultSet = statement.executeQuery();
					if (resultSet.next()) {
						tracks = new Tracks();
						tracks.setTrackId(resultSet.getString("trackId"));
						tracks.setAlbumId((null == resultSet.getString("albumId"))? "" : resultSet.getString("albumId"));
						tracks.setArtistId((null == resultSet.getString("artistId"))? "" : resultSet.getString("artistId"));
						tracks.setGenreIds((null == resultSet.getString("genreIds"))? "" : resultSet.getString("genreIds"));
						tracksList.add(tracks);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tracksList;
	}

}
