package com.gotprint.usernote.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.gotprint.usernote.delegate.UserDelegate;
import com.gotprint.usernote.jaxb.UserRequest;
import com.gotprint.usernote.jaxb.UserResponse;

@Path("/usernote")
public class UserServiceResource {

	@GET
	@Path("/find")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponse findUserNote(
			UserRequest pFileClaimsFindRequest) {
		JAXBElement aResponse = null;
		UserDelegate userDelegate = new UserDelegate();

		aResponse = userDelegate.findUser(pFileClaimsFindRequest);
		UserResponse userResponse = (UserResponse) aResponse.getValue();
		return userResponse;
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponse saveUserNote(
			UserRequest pFileClaimsPersistRequest) {
		JAXBElement aResponse = null;
		UserDelegate userDelegate = new UserDelegate();

		aResponse = userDelegate.saveUser(pFileClaimsPersistRequest);

		return (UserResponse) aResponse.getValue();
	}
}
