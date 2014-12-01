package com.musicLibrary.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.musicLibrary.Beans.Albums;
import com.musicLibrary.Beans.Artists;
import com.musicLibrary.Beans.Genre;
import com.musicLibrary.Beans.Item_purchase;
import com.musicLibrary.Beans.Tracks;
import com.musicLibrary.Beans.User;
import com.musicLibrary.Dao.Cart_purchaseDao;
import com.musicLibrary.Dao.UserDB;
import com.musicLibrary.service.AuthenticationProcess;
import com.musicLibrary.service.ItemsLikedProcess;
import com.musicLibrary.service.SearchProcess;
import com.musicLibrary.service.TrackProcess;

@Path("/Auth")
public class Authentication {
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response userLogin(@FormParam("email") String email,
			@FormParam("password") String password) {
		System.out.println("username is :" + email);
		System.out.println("password is :" + password);

		AuthenticationProcess authProcess = new AuthenticationProcess();
		User user = null;
		user = authProcess.loginCheck(email, password);
		if (null != user) {
			String output = "Login Successful for " + email;
			System.out.println("User Validated :" + output);
			return Response.status(200).entity(user).build();
		}

		String output = "user invalid";
		return Response.status(400).entity(output).build();
	}

	@POST
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response userSignup(@FormParam("email") String email,
			@FormParam("password") String password,
			@FormParam("firstname") String firstname,
			@FormParam("lastname") String lastname){
		
		System.out.println(" "+firstname+lastname+ email+ password);
		
		UserDB udb = new UserDB();
		boolean adduser =udb.addUser(firstname, lastname, email, password);
		System.out.println("user added "+adduser);
		return null;
	}
	
	
	@GET
	@Path("/getRecc")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getrecommendation(@QueryParam("userId") int userId,
			@Context HttpServletRequest request) {
		System.out.println("in the get reccos");
		TrackProcess trackProcess = new TrackProcess();
		List<Tracks> tracksList = trackProcess.listTracks();
		if (tracksList.isEmpty()) {
			String output = "user invalid";
			return Response.status(400).entity(output).build();
		}
		request.setAttribute("tracks", tracksList);
		return Response.status(200).entity(new User(1, "amol")).build();
	}

	@GET
	@Path("/serachItems")
	@Produces(MediaType.APPLICATION_JSON)
	public Response serachItems(@QueryParam("itemId") String itemId,
			@QueryParam("itemType") String itemType,
			@Context HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		System.out.println("in serch" + itemId);
		SearchProcess searchProcess = new SearchProcess();

		List<Tracks> tracksList = new ArrayList<Tracks>();
		List<Albums> albumList = new ArrayList<Albums>();
		List<Artists> artistList = new ArrayList<Artists>();
		List<Genre> GenreList = new ArrayList<Genre>();
		
		
		String isTrackFound = null;
		String isAlbumFound = null;
		String isArtistFound = null;
		String iskedGenreFound = null;
		
		
		
		session.setAttribute("searchedTracks", tracksList);
		session.setAttribute("searchedAlbums", albumList);
		session.setAttribute("searchedArtist", artistList);
		session.setAttribute("searchedGenre", GenreList);
				
		
		
		
		session.setAttribute("isTrackFound", isTrackFound);
		session.setAttribute("isAlbumFound", isAlbumFound);
		session.setAttribute("isArtistFound", isArtistFound);
		session.setAttribute("isGenreFound", iskedGenreFound);
				
		
		
	//track	
		if (itemType.trim().toLowerCase().equals("track")) {
			tracksList = searchProcess.serachtracks(itemId);
			session.setAttribute("searchedTracks", tracksList);
			session.setAttribute("isTrackFound", "true");
		}
		// request.setAttribute("searchedTracks", tracksList);
		
		for (Tracks track : tracksList) {
			System.out.println(track.getTrackId() + " " + track.getAlbumId()
					+ " " + track.getPrice());
		}

		
	//album	
		if (itemType.trim().toLowerCase().equals("album")) {
			albumList = searchProcess.searchAlbums(itemId);
			session.setAttribute("searchedAlbums", albumList);
			session.setAttribute("isAlbumFound", "true");
		}
		// request.setAttribute("searchedAlbums", albumList);
		
		for (Albums album : albumList) {
			System.out.println(album.getAlbumId() + " " + album.getPrice());
		}
		
	//Artist
		if (itemType.trim().toLowerCase().equals("artist")){
			artistList = searchProcess.searchArtist(itemId);
			session.setAttribute("searchedArtist", artistList);
			session.setAttribute("isArtistFound", "true");
		}
		for (Artists artist : artistList) {
	
			System.out.println(artist.getArtistId() + " " + artist.getRating());
		}
		
	//Genre
		if (itemType.trim().toLowerCase().equals("genre")){
			GenreList = searchProcess.searchGenre(itemId);
			session.setAttribute("searchedGenre", GenreList);
			session.setAttribute("isGenreFound", "true");
			
		}
		for (Genre genre : GenreList) {
			System.out.println(genre.getGenreId() + " " + genre.getRating());
		}
		
		
		
		System.out.println("test git");
		return Response.status(200).entity(new User(1, "amol")).build();
	}

	@POST
	@Path("/insertLikedItems")
	// @Produces(MediaType.APPLICATION_JSON)
	public Response insertLikedItems(@FormParam("userId") String userId,
			@FormParam("itemId") String itemId,
			@FormParam("rating") String rating,
			@FormParam("itemType") String type,
			@Context HttpServletRequest request) {
		ItemsLikedProcess itemsLikedProcess = new ItemsLikedProcess();
		boolean isInserted = false;
		isInserted = itemsLikedProcess.inserLikedIten(userId, itemId, rating,
				type);
		String output = "success";
		if (!isInserted) {
			output = "not inserted";
			return Response.status(400).entity(output).build();
		}
		System.out.println("inserted");
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/getLikedItems")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLikedItems(@QueryParam("userId") String userId,
			@Context HttpServletRequest request) {
		ItemsLikedProcess itemsLikedProcess = new ItemsLikedProcess();
		HttpSession session = request.getSession(true);

		List<Tracks> tracksList = new ArrayList<Tracks>();
		List<Albums> albumList = new ArrayList<Albums>();
		//List<Artists> artistList = new ArrayList<Artists>();
		//List<Genre> GenreList = new ArrayList<Genre>();
		
		String likedTrackFound = null;
		String likedAlbumFound = null;
		//String likedArtistFound = null;
		//String likedGenreFound = null;
		
		session.setAttribute("searchedTracks", tracksList);
		session.setAttribute("searchedAlbums", albumList);
		//session.setAttribute("searchedArtist", artistList);
		//session.setAttribute("searchedGenre", GenreList);
		
		
		session.setAttribute("likedTrackFound", likedTrackFound);
		session.setAttribute("likedAlbumFound", likedAlbumFound);
		//session.setAttribute("likedArtistFound", likedArtistFound);
		//session.setAttribute("likedGenreFound", likedGenreFound);
		
		//for track
		tracksList = itemsLikedProcess.searchLikedTracks(userId);
		if (!tracksList.isEmpty()) {
		session.setAttribute("likedTracks", tracksList);
		session.setAttribute("likedTrackFound", "true");
		}
		for (Tracks track : tracksList) {
			System.out.println(track.getTrackId() + " " + track.getRating() + " " + track.getType());
		}
		
		//for album
		albumList = itemsLikedProcess.searchLikedAlbums(userId);
		if (!tracksList.isEmpty()) {
			session.setAttribute("likedAlbums", albumList);
			session.setAttribute("likedAlbumFound", "true");
			}
		
		
		for (Albums album : albumList) {
			System.out.println(album.getAlbumId() + " " + album.getRating() + " " + album.getType());
		}
		
		//for artist
		
		
		
		
		
		//for genre
		
		
		
		
		return Response.status(200).entity(new User(1, "amol")).build();
	}
	
	@POST
	@Path("/addtocart")

	public Response addtocart(@FormParam("userId") String userId,
			@FormParam("itemId") String itemId,			
			@FormParam("itemType") String type,
			@FormParam("itemPrice") String price,
			@Context HttpServletRequest request){
		
		System.out.println("all the data is : "+itemId+" "+type+" "+price);
		long UserId = Long.parseLong(userId);
		String ItemId = itemId;
		String itemType =type;
		String Price = price;
		double amount = Double.parseDouble(Price);
		
		Cart_purchaseDao cpd = new Cart_purchaseDao();
		boolean cart = cpd.insertItemIntoCart(UserId, ItemId, itemType, amount);
		System.out.println("added to cart "+cart);
		
		return Response.status(200).entity(new User(1, "amol")).build();
		
	}
	
	@GET
	@Path("/getCart")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCartDetails(@QueryParam("userId") String userId,
			@Context HttpServletRequest request){
		HttpSession session = request.getSession(true);
		List<Item_purchase> itemsPurchased = new ArrayList<Item_purchase>();
		
		String itemspuirchase = null;
		
		session.setAttribute("itemspurchase", itemspuirchase);
		session.setAttribute("itemsPurchasedList", itemsPurchased);
		
		long UserId = Long.parseLong(userId);
		 Cart_purchaseDao cpd = new Cart_purchaseDao();
		 itemsPurchased = cpd.getCart(UserId);
		
		 if(!itemsPurchased.isEmpty()){
			 session.setAttribute("itemsPurchasedListisThere", itemsPurchased);
			session.setAttribute("itemspurchase", "true");
		 }
		 
		 for (Item_purchase items : itemsPurchased){
			 System.out.println(items.getItemId());
		 }
		 
			return Response.status(200).entity(new User(1, "amol")).build();
	}
	
	@GET
	@Path("/reccomended")
	public Response processReccomedation(@QueryParam("userId") String userId,
			@QueryParam("tracksRecc") String tracksRecc,
			@QueryParam("albumRecc") String albumRecc,
			@QueryParam("artistRecc") String artistRecc,
			@QueryParam("genreRecc") String genreRecc,
			@Context HttpServletRequest request) {
		System.out.println();
		System.out.println("reccos");
		System.out.println( tracksRecc);
		System.out.println(albumRecc);
		System.out.println(artistRecc);
		System.out.println(genreRecc);
		
		HttpSession httpSession = request.getSession(true);
		
		Tracks track = null;
		Albums album = null;
		Artists artist = null;
		Genre genre = null;
		
		List<Albums> reccomAlbums = new ArrayList<Albums>();
		List<Tracks> reccomTracks = new ArrayList<Tracks>();
		List<Artists> reccomArtists = new ArrayList<Artists>();
		List<Genre> reccomGenres = new ArrayList<Genre>();
		
		String isReccTracks = null;
		String isReccAlbums = null;
		String isReccArtist = null;
		String isReccGenres = null;
		
		httpSession.setAttribute("reccomAlbums", reccomAlbums);
		httpSession.setAttribute("reccomTracks", reccomTracks);
		httpSession.setAttribute("reccomArtists", reccomArtists);
		httpSession.setAttribute("reccomGenres", reccomGenres);
		
		httpSession.setAttribute("isReccTracks", isReccTracks);
		httpSession.setAttribute("isReccAlbums", isReccAlbums);
		httpSession.setAttribute("isReccArtist", isReccArtist);
		httpSession.setAttribute("isReccGenres", isReccGenres);
		
		//tracks
		if( (!("null").equals(tracksRecc))  && (!tracksRecc.equals(""))) {
			tracksRecc = tracksRecc.replace('[', ' ');
			tracksRecc = tracksRecc.replace(']', ' ');
			tracksRecc = tracksRecc.trim();
			String[] tracksSplit = tracksRecc.split(",");
			String[] recc = new String[2];
			for (String recTrack : tracksSplit) {
				recc = recTrack.split(":");
				track = new Tracks();
				track.setTrackId(recc[0]);
				track.setRating(recc[1]);
				reccomTracks.add(track);
			}
			
			httpSession.setAttribute("reccomTracks", reccomTracks);
			httpSession.setAttribute("isReccTracks", "true");
		}
		for (Tracks tracked : reccomTracks) {
			System.out.println(tracked.getTrackId() + " " + tracked.getRating());
		}
		
		//albums
		if( (!("null").equals(albumRecc))   && (!albumRecc.equals(""))) {
			albumRecc = albumRecc.replace('[', ' ');
			albumRecc = albumRecc.replace(']', ' ');
			albumRecc = albumRecc.trim();
			String[] albumsSplit = albumRecc.split(",");
			String[] recc = new String[2];
			for (String recAlbum : albumsSplit) {
				recc = recAlbum.split(":");
				album = new Albums();
				album.setAlbumId(recc[0]);
				album.setRating(recc[1]);
				reccomAlbums.add(album);
			}
			
			httpSession.setAttribute("reccomAlbums", reccomAlbums);
			httpSession.setAttribute("isReccAlbums", "true");
		}
		for (Albums tracked : reccomAlbums) {
			System.out.println(tracked.getAlbumId() + " " + tracked.getRating());
		}
		
		//Artist
		if( (!("null").equals(artistRecc))  && (!artistRecc.equals(""))) {
			artistRecc = artistRecc.replace('[', ' ');
			artistRecc = artistRecc.replace(']', ' ');
			artistRecc = artistRecc.trim();
			String[] artistSplit = tracksRecc.split(",");
			String[] recc = new String[2];
			for (String recTrack : artistSplit) {
				recc = recTrack.split(":");
				artist = new Artists();
				artist.setArtistId(recc[0]);
				artist.setRating(recc[1]);
				reccomArtists.add(artist);
			}
			
			httpSession.setAttribute("reccomArtists", reccomArtists);
			httpSession.setAttribute("isReccArtist", "true");
		}
		for (Artists tracked : reccomArtists) {
			System.out.println(tracked.getArtistId() + " " + tracked.getRating());
		}
		
		//genre
		if( (!("null").equals(genreRecc))  && (!genreRecc.equals(""))) {
			genreRecc = genreRecc.replace('[', ' ');
			genreRecc = genreRecc.replace(']', ' ');
			genreRecc = genreRecc.trim();
			String[] genreSplit = genreRecc.split(",");
			String[] recc = new String[2];
			for (String recTrack : genreSplit) {
				recc = recTrack.split(":");
				genre = new Genre();
				genre.setGenreId(recc[0]);
				genre.setRating(recc[1]);
				reccomGenres.add(genre);
			}
			
			httpSession.setAttribute("reccomGenres", reccomGenres);
			httpSession.setAttribute("isReccGenres", "true");
		}
		for (Tracks tracked : reccomTracks) {
			System.out.println(tracked.getTrackId() + " " + tracked.getRating());
		}
		
		return Response.status(200).entity("success").build();
	}
}
