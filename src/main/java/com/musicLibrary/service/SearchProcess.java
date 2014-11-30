package com.musicLibrary.service;

import java.util.List;

import com.musicLibrary.Beans.Albums;
import com.musicLibrary.Beans.Tracks;
import com.musicLibrary.Dao.SearchDao;

public class SearchProcess {
	public List<Tracks> serachtracks(String trackId) {
<<<<<<< Updated upstream
		SearchDao searchDao = new SearchDao();
		List<Tracks> tracksList = searchDao.searchtracks(trackId);
=======
		List<Tracks> tracksList = new ArrayList<Tracks>();
		
		Tracks tracks = new Tracks();
		tracks.setTrackId("1");
		tracks.setAlbumId("2");
		tracks.setArtistId("3");
		tracks.setGenreIds("1.34,56");
		tracksList.add(tracks);
		
		
		tracks = new Tracks();
		tracks.setTrackId("2");
		tracks.setAlbumId("2");
		tracks.setArtistId("3");
		tracks.setGenreIds("1.34,56");
		tracksList.add(tracks);
		
		tracks = new Tracks();
		tracks.setTrackId("3");
		tracks.setAlbumId("2");
		tracks.setArtistId("3");
		tracks.setGenreIds("1.34,56");
		tracksList.add(tracks);
		
		tracks = new Tracks();
		tracks.setTrackId("5");
		tracks.setAlbumId("2");
		tracks.setArtistId("3");
		tracks.setGenreIds("1.34,56");
		tracksList.add(tracks);
		
>>>>>>> Stashed changes
		return tracksList;
	}
	
	public List<Albums> searchAlbums(String albumId) {
		SearchDao searchDao = new SearchDao();
		List<Albums> albumList = searchDao.searchAlbums(albumId);
		return albumList;
	}
}
