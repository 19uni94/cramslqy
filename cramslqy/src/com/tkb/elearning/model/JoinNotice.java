package com.tkb.elearning.model;

import java.sql.Timestamp;

public class JoinNotice {

	private int id;              	//id
	private String content;			//文件
	private Timestamp create_date;  //創建時間
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
		
}
