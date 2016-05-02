package com.gotprint.usernote.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Note")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRequest {
	
	@XmlElement(name="user")
	private User user;
	@XmlElement(name="note")
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