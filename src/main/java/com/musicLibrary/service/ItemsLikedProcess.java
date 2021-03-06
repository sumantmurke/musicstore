package com.musicLibrary.service;

import java.util.List;

import com.musicLibrary.Beans.Albums;
import com.musicLibrary.Beans.Artists;
import com.musicLibrary.Beans.Genre;
import com.musicLibrary.Beans.Tracks;
import com.musicLibrary.Dao.ItemsLikedDao;

public class ItemsLikedProcess {
	public List<Tracks> searchLikedTracks(String userId) {
		ItemsLikedDao likedDao = new ItemsLikedDao();
		List<Tracks> tracksList = likedDao.searchLikedTracks(userId);
		return tracksList;
	}

	public List<Albums> searchLikedAlbums(String userId) {
		ItemsLikedDao likedDao = new ItemsLikedDao();
		List<Albums> albumsList = likedDao.searchLikedAlbums(userId);
		return albumsList;
	}
	
	public List<Artists> searchLikedArtists(String userId) {
		ItemsLikedDao likedDao = new ItemsLikedDao();
		List<Artists> artistList = likedDao.searchLikedArtist(userId);
		return artistList;
	}
	
	public List<Genre> searchLikedGenre(String userId) {
		ItemsLikedDao likedDao = new ItemsLikedDao();
		List<Genre> genreList = likedDao.searchLikedGenre(userId);
		return genreList;
	}

	public boolean inserLikedIten(String userid, String itemId, String rating,
			String type) {
		ItemsLikedDao likedDao = new ItemsLikedDao();
		boolean isInserted = likedDao.insertLikedRecord(userid, itemId, rating,
				type);
		return isInserted;
	}
}
