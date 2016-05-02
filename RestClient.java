package com.gotprint.usernote.RestClient;

import javax.ws.rs.core.MediaType;

import com.gotprint.usernote.jaxb.Note;
import com.gotprint.usernote.jaxb.User;
import com.gotprint.usernote.jaxb.UserRequest;
import com.gotprint.usernote.jaxb.UserResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClient {

	public static void main(String[] args) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResourceFind = client
				   .resource("http://localost:8080/UserNote/rest/usernote/find");
		
		WebResource webResourceSave = client
				   .resource("http://localost:8080/UserNote/rest/usernote/save");
		
		UserRequest requestObject = new UserRequest();
		//Note note = new Note();
		User user = new User();
		
		user.setId(1);
		requestObject.setUser(user);
	    
	ClientResponse response = webResourceFind.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestObject);
	UserResponse userResponse = ((ClientResponse) response).getEntity(UserResponse.class);
	userResponse.getUser();
	
	
	
	}
}
