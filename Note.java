package com.gotprint.usernote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="NOTE")
public class Note {
	
	@Id
	@Column(name = "NOTE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TITLE", nullable = false)
	@Length(max = 50)
	private String title;

	@Length(max = 1000)
	@Column(name = "NOTE_BOX", nullable = false)
	private String noteBox;
	
	@Column(name = "CREATE_TIME", nullable = false)
	private String createTime;

	@Column(name = "LAST_UPDATE_TIME", nullable = false)
	private String lastUpdateTime;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
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
