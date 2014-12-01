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
import com.musicLibrary.Beans.Item_purchase;
import com.musicLibrary.Beans.Tracks;
import com.musicLibrary.Beans.User;
import com.musicLibrary.Dao.Cart_purchaseDao;
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
		
		String isTrackFound = null;
		String isAlbumFound = null;
		
		session.setAttribute("searchedTracks", tracksList);
		session.setAttribute("searchedAlbums", albumList);
		
		session.setAttribute("isTrackFound", isTrackFound);
		session.setAttribute("isAlbumFound", isAlbumFound);
		
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

		if (itemType.trim().toLowerCase().equals("album")) {
			albumList = searchProcess.searchAlbums(itemId);
			session.setAttribute("searchedAlbums", albumList);
			session.setAttribute("isAlbumFound", "true");
		}
		// request.setAttribute("searchedAlbums", albumList);
		
		for (Albums album : albumList) {
			System.out.println(album.getAlbumId() + " " + album.getPrice());
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

		String likedTrackFound = null;
		String likedAlbumFound = null;
		
		session.setAttribute("searchedTracks", tracksList);
		session.setAttribute("searchedAlbums", albumList);
		
		session.setAttribute("likedTrackFound", likedTrackFound);
		session.setAttribute("likedAlbumFound", likedAlbumFound);
		
		tracksList = itemsLikedProcess.searchLikedTracks(userId);
		if (!tracksList.isEmpty()) {
		session.setAttribute("likedTracks", tracksList);
		session.setAttribute("likedTrackFound", "true");
		}
		for (Tracks track : tracksList) {
			System.out.println(track.getTrackId() + " " + track.getRating() + " " + track.getType());
		}
		albumList = itemsLikedProcess.searchLikedAlbums(userId);
		if (!tracksList.isEmpty()) {
			session.setAttribute("likedAlbums", albumList);
			session.setAttribute("likedAlbumFound", "true");
			}
		
		
		for (Albums album : albumList) {
			System.out.println(album.getAlbumId() + " " + album.getRating() + " " + album.getType());
		}
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

}
