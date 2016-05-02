package com.gotprint.usernote.translator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.gotprint.usernote.jaxb.Note;
import com.gotprint.usernote.jaxb.User;
import com.gotprint.usernote.jaxb.UserResponse;
import com.gotprint.usernote.service.UserRequest;

/**
 * @author ChoukseA
 *
 */
public class UserTranslator {

	public UserRequest parseRequest(com.gotprint.usernote.jaxb.UserRequest userRequestJaxb){
		
		UserRequest userRequest = new UserRequest();
		
		User userJAXB = userRequestJaxb.getUser();
		com.gotprint.usernote.model.User userDto = new com.gotprint.usernote.model.User();
		List<com.gotprint.usernote.model.Note> noteDtoList = new ArrayList<com.gotprint.usernote.model.Note>();
		
		userDto.setId(userJAXB.getId());
		userDto.setEmail(userJAXB.getEmail());
		userDto.setCreateTime(userJAXB.getCreateTime());
		userDto.setLastUpdateTime(userJAXB.getLastUpdateTime());
		
		Note noteJAXB = userRequestJaxb.getNote();
		com.gotprint.usernote.model.Note noteDto = new com.gotprint.usernote.model.Note();
		
		noteDto.setId(noteJAXB.getId());
		noteDto.setTitle(noteJAXB.getTitle());
		noteDto.setCreateTime(noteJAXB.getCreateTime());
		noteDto.setLastUpdateTime(noteJAXB.getLastUpdateTime());
		noteDto.setUser(userDto);
		
		noteDtoList.add(noteDto);
		userDto.setNote(noteDtoList);
		
		userRequest.setNote(noteDto);
		userRequest.setUser(userDto);
		
		return userRequest;
	}
	
	
	public JAXBElement<UserResponse> parseResponse(com.gotprint.usernote.service.UserResponse userResponse){
		
		QName aQName = new QName("http://www.unisys.com/usfn");
		JAXBElement aJAXBElement = new JAXBElement(aQName,
				UserResponse.class, new UserResponse());
		UserResponse userResponseJaxb = (UserResponse) aJAXBElement
				.getValue();
	
		com.gotprint.usernote.model.User userDto = userResponse.getUser();
		com.gotprint.usernote.jaxb.User userJaxb = new com.gotprint.usernote.jaxb.User();
		List<com.gotprint.usernote.jaxb.Note> noteJaxbList = new ArrayList<com.gotprint.usernote.jaxb.Note>();
		
		userJaxb.setId(userDto.getId());
		userJaxb.setEmail(userDto.getEmail());
		userJaxb.setCreateTime(userDto.getCreateTime());
		userJaxb.setLastUpdateTime(userDto.getLastUpdateTime());
		
		com.gotprint.usernote.model.Note noteDto = userResponse.getNote();
		com.gotprint.usernote.jaxb.Note noteJaxb = new com.gotprint.usernote.jaxb.Note();
		
		noteJaxb.setId(noteDto.getId());
		noteJaxb.setTitle(noteDto.getTitle());
		noteJaxb.setCreateTime(noteDto.getCreateTime());
		noteJaxb.setLastUpdateTime(noteDto.getLastUpdateTime());
		noteJaxb.setUser(userJaxb);
		
		noteJaxbList.add(noteJaxb);
		userJaxb.setNote(noteJaxbList);
		
		userResponseJaxb.setNote(noteJaxb);
		userResponseJaxb.setUser(userJaxb);
		
	return aJAXBElement;
		
	}
	
}