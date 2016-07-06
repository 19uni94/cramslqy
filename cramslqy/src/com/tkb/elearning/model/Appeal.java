package com.tkb.elearning.model;

import java.sql.Timestamp;

public class Appeal {

	private int id;
	private String transactor;			//處理人
	private Timestamp handle_date;		//處理日期
	private String handle_content;		//處理內容
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactor() {
		return transactor;
	}
	public void setTransactor(String transactor) {
		this.transactor = transactor;
	}
	public Timestamp getHandle_date() {
		return handle_date;
	}
	public void setHandle_date(Timestamp handle_date) {
		this.handle_date = handle_date;
	}
	public String getHandle_content() {
		return handle_content;
	}
	public void setHandle_content(String handle_content) {
		this.handle_content = handle_content;
	}
	
	
}
