package com.gotprint.usernote.service;

import java.util.List;

import com.gotprint.usernote.model.Note;
import com.gotprint.usernote.model.User;

public class UserResponse {

	private User user;
	private Note note;
	private List<Note> noteList;
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
	/**
	 * @return the noteList
	 */
	public List<Note> getNoteList() {
		return noteList;
	}
	/**
	 * @param noteList the noteList to set
	 */
	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}
	
}
