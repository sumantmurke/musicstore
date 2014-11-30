package com.musicLibrary.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.musicLibrary.Beans.User;
import com.musicLibrary.service.AuthenticationProcess;

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
	public Response getrecommendation (@QueryParam("userId") int userId, @Context HttpServletRequest request) {
		System.out.println("in the get reccos");
		return Response.status(200).entity(new User(1,"amol")).build();
	}
}
