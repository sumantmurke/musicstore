package com.musicLibrary.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.musicLibrary.Dao.UserDB;



@Path("/Auth")
public class Authentication {
	
	@POST
	@Path("/login")
	public Response userLogin(@FormParam("email") String email, 
			@FormParam("password") String password){
		
		System.out.println("username is :"+email);
		System.out.println("password is :"+password);
		
		
		
		if(UserDB.loginCheck(email, password))
		{
		String output = "Login Successful for "+ email;
		System.out.println("User Validated :"+output);
		
		return Response.status(200).entity(output).build();
		
		}
		String output ="user invalid";
		 return Response.status(400).entity(output).build();
	}

}
