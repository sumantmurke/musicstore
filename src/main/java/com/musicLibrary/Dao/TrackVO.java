package com.musicLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.musicLibrary.Beans.User;

public class TrackVO {
	String id;
	String albumnId;
	String genreId;
	String artistId;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the albumnId
	 */
	public String getAlbumnId() {
		return albumnId;
	}
	/**
	 * @param albumnId the albumnId to set
	 */
	public void setAlbumnId(String albumnId) {
		this.albumnId = albumnId;
	}
	/**
	 * @return the genreId
	 */
	public String getGenreId() {
		return genreId;
	}
	/**
	 * @param genreId the genreId to set
	 */
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	/**
	 * @return the artistId
	 */
	public String getArtistId() {
		return artistId;
	}
	/**
	 * @param artistId the artistId to set
	 */
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	

}
