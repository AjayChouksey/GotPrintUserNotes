package com.gotprint.usernote.service;

import com.gotprint.usernote.model.Note;
import com.gotprint.usernote.model.User;

public class UserRequest {

	private User user;
	private Note note;
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the note
	 */
	public Note getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(Note note) {
		this.note = note;
	}
	
	
	
}
