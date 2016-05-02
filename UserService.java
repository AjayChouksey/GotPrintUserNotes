package com.gotprint.usernote.service;



public interface UserService {

	UserResponse findById(UserRequest userRequest);
	
	UserResponse saveUserNote(UserRequest userRequest);
	
	UserResponse updateUserNote(UserRequest userRequest);
	
	void deleteUserNoteById(UserRequest userRequest);

}
