package com.gotprint.usernote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gotprint.usernote.dao.UserDaoImpl;
import com.gotprint.usernote.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;
	
	public UserResponse findById(UserRequest userRequest) {
		UserResponse userResponse = new UserResponse();
		User user = userRequest.getUser();
		int id = user.getId();
		user =  dao.findById(user, id);
		userResponse.setUser(user);
		userResponse.setNoteList(user.getNote());
		return userResponse;
	}

	public UserResponse saveUserNote(UserRequest userRequest) {
		
		UserResponse userResponse = new UserResponse();
		User user = userRequest.getUser();
		user =  dao.save(user);
		userResponse.setUser(user);
		userResponse.setNoteList(user.getNote());
		return userResponse;
		
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public UserResponse updateUserNote(UserRequest userRequest) {
		UserResponse userResponse = new UserResponse();
		User user = userRequest.getUser();
		User entity = dao.findById(user, user.getId());
		if(entity!=null){
			entity.setEmail(user.getEmail());
		}
		userResponse.setUser(entity);
		userResponse.setNoteList(entity.getNote());
		return userResponse;
	}

	public void deleteUserNoteById(UserRequest userRequest) {
		User user = userRequest.getUser();
		int id = user.getId();
		dao.deleteById(id);
	}

}
