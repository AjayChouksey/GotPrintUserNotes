package com.gotprint.usernote.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class UserResponse {



	@XmlElement(name="user")
	private User user;
	@XmlElement(name="note", type=Note.class)
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
