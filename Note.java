package com.gotprint.usernote.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlRootElement(name="Note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note {
	
	@XmlElement(name="id")
	private int id;
	
	@XmlElement(name="title")
	private String title;

	@XmlElement(name="noteBox")
	private String noteBox;
	
	@XmlSchemaType(name = "dateTime")
	@XmlElement(name="createTime")
	private String createTime;
	
	@XmlSchemaType(name = "dateTime")
	@XmlElement(name="lastUpdateTime")
	private String lastUpdateTime;
	
	@XmlElement(name="user")
	private User user;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the noteBox
	 */
	public String getNoteBox() {
		return noteBox;
	}

	/**
	 * @param noteBox the noteBox to set
	 */
	public void setNoteBox(String noteBox) {
		this.noteBox = noteBox;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the lastUpdateTime
	 */
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

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

}
