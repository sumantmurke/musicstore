package com.musicLibrary.service;

import java.util.List;

import com.musicLibrary.Beans.Tracks;
import com.musicLibrary.Dao.TrackDao;

public class TrackProcess {
	public List<Tracks> listTracks() {
		TrackDao trackDao = new TrackDao();
		List<Tracks> tracksList = trackDao.listTracks();
		return tracksList;
	}
}
