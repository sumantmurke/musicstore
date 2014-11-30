package com.musicLibrary.Beans;

public class Albums {
	String albumId;
	String artistId;
	String genreIds;
	float price;
	/**
	 * @return the albumId
	 */
	public String getAlbumId() {
		return albumId;
	}
	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
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
	/**
	 * @return the genreIds
	 */
	public String getGenreIds() {
		return genreIds;
	}
	/**
	 * @param genreIds the genreIds to set
	 */
	public void setGenreIds(String genreIds) {
		this.genreIds = genreIds;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
}
