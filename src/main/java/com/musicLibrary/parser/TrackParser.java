package com.musicLibrary.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.musicLibrary.Dao.DatabaseConnection;
import com.musicLibrary.Dao.TrackVO;

public class TrackParser {


		
	
	public static void main(String[] args) {
		String FilePath = "";
		
		try {
			FileReader fr = new FileReader(FilePath);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			List<TrackVO> tracks = new ArrayList<TrackVO>(); 
			String line = null;
			while ((line = br.readLine())!=null)
			//String line = br.readLine();
			{
				
			String[] columns = line.split("|");
			String genre = new String();
			TrackVO trackVO = new TrackVO();
			for(int i = 0; i< columns.length; i++)
			{
				
				if (columns[i].equalsIgnoreCase("none"))
				columns[i] = null;	
				if (i ==0)
					trackVO.setId(columns[0]);
				else if (i ==1)
					trackVO.setAlbumnId(columns[1]);
				else if (i == 2)
					trackVO.setArtistId(columns[2]);
				else if (genre.isEmpty())
					genre = columns[i];
				else
					genre = genre + "," + columns[i]; 
				if (i == columns.length-1)
				{ trackVO.setGenreId(genre); }
			}
			
			tracks.add(trackVO);
			if (tracks.size()== 50)
			{
				saveList(tracks);
			}
			}
			if (!tracks.isEmpty())
			saveList(tracks);
			//
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		
			
		
	}
	
	private static void saveList(List<TrackVO> tracks) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (connection != null) {
			PreparedStatement statement;
			ResultSet resultSet;
			try {
				//save tracks.get..
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseConnection.closeAllDb(connection, null, null);
			}
	}
}
}


