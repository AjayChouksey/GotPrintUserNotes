package com.gotprint.usernote.delegate;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;

import com.gotprint.usernote.service.UserRequest;
import com.gotprint.usernote.service.UserResponse;
import com.gotprint.usernote.service.UserServiceImpl;
import com.gotprint.usernote.translator.UserTranslator;

public class UserDelegate {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	private UserTranslator userTranslator;

	/**
	 * @return the userServiceImpl
	 */
	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	/**
	 * @param userServiceImpl the userServiceImpl to set
	 */
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	/**
	 * @return the userTranslator
	 */
	public UserTranslator getUserTranslator() {
		return userTranslator;
	}

	/**
	 * @param userTranslator the userTranslator to set
	 */
	public void setUserTranslator(UserTranslator userTranslator) {
		this.userTranslator = userTranslator;
	}

	public JAXBElement findUser(com.gotprint.usernote.jaxb.UserRequest userRequest) {

		UserTranslator userTranslator = getUserTranslator();

		UserRequest userRequestDto = userTranslator
				.parseRequest(userRequest);
		
		UserResponse userResponse = null;
		com.gotprint.usernote.jaxb.UserResponse useJaxBResponse = null;

		userResponse = getUserServiceImpl()
					.findById(userRequestDto);

		useJaxBResponse = (com.gotprint.usernote.jaxb.UserResponse) userTranslator
					.parseResponse(userResponse).getValue();

		QName aQName = new QName("http://www.unisys.com/usfn");

		JAXBElement aJAXBElement = new JAXBElement(
				aQName,
				com.gotprint.usernote.jaxb.UserResponse.class,
				useJaxBResponse);

		return aJAXBElement;
	}
	
	public JAXBElement saveUser(com.gotprint.usernote.jaxb.UserRequest userRequest) {

		UserTranslator userTranslator = getUserTranslator();

		UserRequest userRequestDto = userTranslator
				.parseRequest(userRequest);
		
		UserResponse userResponse = null;
		com.gotprint.usernote.jaxb.UserResponse useJaxBResponse = null;

		if(userRequest.getUser() != null){
			userResponse = getUserServiceImpl()
						.saveUserNote(userRequestDto);
		}
		
		useJaxBResponse = (com.gotprint.usernote.jaxb.UserResponse) userTranslator
				.parseResponse(userResponse).getValue();

		QName aQName = new QName("http://www.unisys.com/usfn");

		JAXBElement aJAXBElement = new JAXBElement(
				aQName,
				com.gotprint.usernote.jaxb.UserResponse.class,
				useJaxBResponse);

		return aJAXBElement;
	}
	
	public void deleteUserNote(com.gotprint.usernote.jaxb.UserRequest userRequest) {

		UserTranslator userTranslator = getUserTranslator();

		UserRequest userRequestDto = userTranslator
				.parseRequest(userRequest);
		
		UserResponse userResponse = null;

		if(userRequest.getUser() != null){
			getUserServiceImpl()
						.deleteUserNoteById(userRequestDto);
		}
		
		QName aQName = new QName("http://www.unisys.com/usfn");
	}
}
