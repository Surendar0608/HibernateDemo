package com.Suren.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // annotation, represent the table in database.
@Table(name="Song")
public class Song {
	@Id // primary key 
	@Column(name="Song_no") // property should mapping with database
	private int id;
	@Column(name = "Song_Nmae")
	private String SongName;
	@Column(name = "Song_Singer")
	private String SongAuthor;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongName() {
		return SongName;
	}
	public void setSongName(String songName) {
		SongName = songName;
	}
	public String getSongAuthor() {
		return SongAuthor;
	}
	public void setSongAuthor(String songAuthor) {
		SongAuthor = songAuthor;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", SongName=" + SongName + ", SongAuthor=" + SongAuthor + "]";
	}
	
	

}
