package com.musicLibrary.service;

import java.util.List;

import com.musicLibrary.Beans.Albums;
import com.musicLibrary.Beans.Tracks;
import com.musicLibrary.Dao.SearchDao;

public class SearchProcess {
	public List<Tracks> serachtracks(String trackId) {
		SearchDao searchDao = new SearchDao();
		List<Tracks> tracksList = searchDao.searchtracks(trackId);
		return tracksList;
	}
	
	public List<Albums> searchAlbums(String albumId) {
		SearchDao searchDao = new SearchDao();
		List<Albums> albumList = searchDao.searchAlbums(albumId);
		return albumList;
	}
}
