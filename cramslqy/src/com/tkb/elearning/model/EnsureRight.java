package com.tkb.elearning.model;

import java.sql.Timestamp;

public class EnsureRight {
	
	private int id;
	private String right_title;
	private String right_content;
	private Timestamp create_date;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRight_title() {
		return right_title;
	}
	public void setRight_title(String right_title) {
		this.right_title = right_title;
	}
	public String getRight_content() {
		return right_content;
	}
	public void setRight_content(String right_content) {
		this.right_content = right_content;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	
}
